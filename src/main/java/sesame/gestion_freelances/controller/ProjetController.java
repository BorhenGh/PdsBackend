package sesame.gestion_freelances.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sesame.gestion_freelances.controller.Api.ProjetApi;
import sesame.gestion_freelances.models.Enumeration.DomaineExpertise;
import sesame.gestion_freelances.models.Enumeration.Technologie;
import sesame.gestion_freelances.models.Projet;
import sesame.gestion_freelances.service.ProjectService;

import java.util.List;
import java.util.Optional;
@RestController
public class ProjetController implements ProjetApi {
    @Autowired
    ProjectService projectService;

    @Override
    public Projet ajouterUnProjet(@RequestPart("projet") Projet projet, @RequestPart("image") MultipartFile image) {
        return projectService.ajouterUnProjet(projet, image);
    }

    @Override
    public void SupprimerUnProjet(int id) {
        projectService.supprimerUnProjet(id);
    }

    @Override
    public Projet updateUnProjet(Projet projet, int id, MultipartFile image) {
        return projectService.updateUnProjet(projet, id, image);
    }

    @Override
    public Optional<Projet> getProjetById(int id) {
        return projectService.getProjetById(id);
    }

    @Override
    public Page<Projet> tousLesProjets(int page, int size) {
        return projectService.tousLesProjets(page,size);
    }


    @Override
    public List<Object[]> rechercherProjetsParDomaineEtTechnologie(DomaineExpertise domaine, Technologie technologie) {
        return projectService.rechercherProjetsParDomaineEtTechnologie(domaine, technologie);
    }
}
