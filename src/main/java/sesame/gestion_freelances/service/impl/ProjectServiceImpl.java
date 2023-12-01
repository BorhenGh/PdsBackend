package sesame.gestion_freelances.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sesame.gestion_freelances.models.Projet;
import sesame.gestion_freelances.repository.ProjetDAO;
import sesame.gestion_freelances.service.ProjectService;
import sesame.gestion_freelances.models.Enumeration.DomaineExpertise;
import sesame.gestion_freelances.models.Enumeration.Technologie;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjetDAO projetDAO;

    private static final String UPLOAD_DIR = "src/main/resources/static/project-images/";

    @Override
    public Projet ajouterUnProjet(Projet projet, MultipartFile image) {
        validateFile(image);
        String imageUrl = saveImage(image);
        projet.setImageUrl(imageUrl);
        return projetDAO.save(projet);
    }

    @Override
    public void supprimerUnProjet(int id) {
        projetDAO.deleteById(id);
    }

    @Override
    public Projet updateUnProjet(Projet projet, int id, MultipartFile image) {
        validateFile(image);

        Optional<Projet> existingProjet = projetDAO.findById(id);

        if (existingProjet.isPresent()) {
            Projet updatedProjet = existingProjet.get();
            updatedProjet.setTitre(projet.getTitre());
            updatedProjet.setDescription(projet.getDescription());
            updatedProjet.setBudget(projet.getBudget());
            updatedProjet.setDuree(projet.getDuree());
            updatedProjet.setStatusProjet(projet.getStatusProjet());

            // Mettez à jour l'image uniquement si un nouveau fichier est fourni
            if (image != null && !image.isEmpty()) {
                String imageUrl = saveImage(image);
                updatedProjet.setImageUrl(imageUrl);
            }

            return projetDAO.save(updatedProjet);
        } else {
            throw new EntityNotFoundException("Projet non trouvé avec l'ID : " + id);
        }
    }

    @Override
    public Optional<Projet> getProjetById(int id) {
        return projetDAO.findById(id);
    }

    @Override
    public List<Projet> tousLesProjets() {
        return projetDAO.findAll();
    }

    @Override
    public List<Object[]> rechercherProjetsParDomaineEtTechnologie(DomaineExpertise domaine, Technologie technologie) {
        return projetDAO.rechercherProjetsParDomaineEtTechnologie(domaine, technologie);
    }

    private void validateFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("Fichier non valide ou manquant.");
        }
    }

    private String saveImage(MultipartFile image) {
        try {
            String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
            Path uploadPath = Path.of(UPLOAD_DIR);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(fileName);
            Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return filePath.toString();
        } catch (IOException e) {
            log.error("Erreur lors de l'enregistrement de l'image du projet : {}", e.getMessage());
            throw new RuntimeException("Erreur lors de l'enregistrement de l'image du projet : " + e.getMessage());
        }
    }
}
