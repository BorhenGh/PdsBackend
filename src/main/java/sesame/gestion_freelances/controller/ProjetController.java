package sesame.gestion_freelances.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sesame.gestion_freelances.controller.Api.ProjetApi;
import sesame.gestion_freelances.models.Projet;
import sesame.gestion_freelances.service.ProjectService;

import java.util.List;
import java.util.Optional;
@RestController
public class ProjetController implements ProjetApi {
    @Autowired
    ProjectService projectService;
    @Override
    public Projet AjouterUnProjet(Projet projet) {
        return projectService.AjouterUnProjet(projet);
    }

    @Override
    public void SupprimerUnProjet(int id) {
        projectService.SupprimerUnProjet(id);
    }

    @Override
    public Projet UpdateUnProjet(Projet projet, int id) {
        return projectService.UpdateUnProjet(projet,id);
    }

    @Override
    public Optional<Projet> getProjetById(int id) {
        return projectService.getProjetById(id);
    }

    @Override
    public List<Projet> TousLesProjets() {
        return projectService.TousLesProjets();
    }
}
