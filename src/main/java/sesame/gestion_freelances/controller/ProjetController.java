package sesame.gestion_freelances.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sesame.gestion_freelances.controller.Api.ProjetApi;
import sesame.gestion_freelances.models.Enumeration.DomaineExpertise;
import sesame.gestion_freelances.models.Enumeration.Technologie;
import sesame.gestion_freelances.models.ImageModel;
import sesame.gestion_freelances.models.Projet;
import sesame.gestion_freelances.service.ProjectService;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class ProjetController implements ProjetApi {
    @Autowired
    ProjectService projectService;

    public Projet ajouterUnProjet(@RequestPart(value = "projet") Projet projet,
                                  @RequestPart(value = "imageFile") MultipartFile[] file) {
        try {
            Set<ImageModel> images = uploadImage(file);
            projet.setProductImages(images);
            return projectService.ajouterUnProjet(projet);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<ImageModel>();

        for (MultipartFile file : multipartFiles) {
            ImageModel imageModel = new ImageModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
            imageModels.add(imageModel);
        }
        return imageModels;
    }

    @Override
    public void SupprimerUnProjet(int id) {
        projectService.supprimerUnProjet(id);
    }

    @Override
    public Projet updateUnProjet(@RequestPart("projet") Projet projet, @PathVariable int id) {
        return projectService.updateUnProjet(projet, id);
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

    @Override
    public List<Projet> findAll() {
        return projectService.findAll();
    }
}
