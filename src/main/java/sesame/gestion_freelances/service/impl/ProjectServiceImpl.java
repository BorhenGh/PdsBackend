package sesame.gestion_freelances.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sesame.gestion_freelances.models.Enumeration.Experience;
import sesame.gestion_freelances.models.Enumeration.NatureTravail;
import sesame.gestion_freelances.models.Projet;
import sesame.gestion_freelances.repository.ProjetDAO;
import sesame.gestion_freelances.service.ProjectService;
import sesame.gestion_freelances.models.Enumeration.DomaineExpertise;
import sesame.gestion_freelances.models.Enumeration.Technologie;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjetDAO projetDAO;


    @Override
    public Projet ajouterUnProjet(Projet projet) {
        return projetDAO.save(projet);
    }

    @Override
    public void supprimerUnProjet(int id) {
        projetDAO.deleteById(id);
    }

    @Override
    public Projet updateUnProjet(Projet projet, int id) {
        Optional<Projet> existingProjet = projetDAO.findById(id);

        if (existingProjet.isPresent()) {
            Projet updatedProjet = existingProjet.get();
            updatedProjet.setTitre(projet.getTitre());
            updatedProjet.setDescription(projet.getDescription());
            updatedProjet.setBudget(projet.getBudget());
            updatedProjet.setDuree(projet.getDuree());
            updatedProjet.setStatusProjet(projet.getStatusProjet());
            updatedProjet.setExperience(projet.getExperience());
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
    public Page<Projet> tousLesProjets(int page, int size) {
        return projetDAO.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Projet> findAll() {
        return projetDAO.findAll();
    }

    @Override
    public List<Object[]> rechercherProjetsParDomaineEtTechnologie(DomaineExpertise domaine, Technologie technologie) {
        return projetDAO.rechercherProjetsParDomaineEtTechnologie(domaine, technologie);
    }
    public List<Projet> getProjetByUserId(int userId) {
        // Implement the logic to fetch offers by user ID from the repository
        return projetDAO.findByEntrepriseId(userId);
    }

    @Override
    public List<Projet> rechercherProjetsByCriteria(DomaineExpertise domaineExpertise, Technologie technologie, NatureTravail natureTravail, Experience experience) {
        return projetDAO.rechercherProjetsCriteria(domaineExpertise,technologie,natureTravail,experience);
    }


}
