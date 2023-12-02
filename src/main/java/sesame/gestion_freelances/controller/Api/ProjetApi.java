package sesame.gestion_freelances.controller.Api;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sesame.gestion_freelances.models.Enumeration.DomaineExpertise;
import sesame.gestion_freelances.models.Enumeration.Technologie;
import sesame.gestion_freelances.models.Projet;

import java.util.List;
import java.util.Optional;
import static sesame.gestion_freelances.utils.Constants.Api_Root;

public interface ProjetApi  {


    @PostMapping(value = Api_Root + "proj/create", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    Projet ajouterUnProjet(@RequestPart(value = "projet", required = true) Projet projet,
                           @RequestPart(value = "imageFile", required = true) MultipartFile[] file);


    @PutMapping(Api_Root + "proj/{id}")
    Projet updateUnProjet(@RequestPart("projet") Projet projet, @PathVariable int id, @RequestPart("image") MultipartFile image);
    @DeleteMapping(value = Api_Root+"proj/{id}")
    void SupprimerUnProjet(@PathVariable int id);

    @GetMapping(value = Api_Root+"proj/{id}")
    Optional<Projet> getProjetById(@PathVariable  int id);
    @GetMapping(value = Api_Root+"proj/All")
    Page<Projet> tousLesProjets( @RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "10") int size);
    @GetMapping(value = Api_Root+"/proj/recherche/{domaine}/{technologie}")
    List<Object[]> rechercherProjetsParDomaineEtTechnologie(@PathVariable DomaineExpertise domaine,@PathVariable Technologie technologie);


}
