package sesame.gestion_freelances.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesame.gestion_freelances.models.Projet;
import sesame.gestion_freelances.repository.ProjetDAO;
import sesame.gestion_freelances.service.ProjectService;


import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjetDAO projetDAO;

    @Override
    public Projet AjouterUnProjet(Projet projet) {
        return projetDAO.save(projet);
    }

    @Override
    public void SupprimerUnProjet(int id) {
        projetDAO.deleteById(id);
    }

    @Override
    public Projet UpdateUnProjet(Projet projet, int id) {

        Optional<Projet> existingProjet = projetDAO.findById(id);

        if (existingProjet.isPresent()) {
            Projet updatedProjet = existingProjet.get();
            updatedProjet.setTitre(projet.getTitre());
            updatedProjet.setDescription(projet.getDescription());
            updatedProjet.setBudget(projet.getBudget());
            updatedProjet.setImageUrl(projet.getImageUrl());
            updatedProjet.setDuree(projet.getDuree());
            updatedProjet.setStatusProjet(projet.getStatusProjet());
            return projetDAO.save(updatedProjet);
        } else {
            throw new RuntimeException("Projet non trouvé avec l'ID : " + id);
        }
    }


    @Override
    public Optional<Projet> getProjetById(int id) {
        return projetDAO.findById(id);
    }

    @Override
    public List<Projet> TousLesProjets() {
        return projetDAO.findAll();
    }
}
