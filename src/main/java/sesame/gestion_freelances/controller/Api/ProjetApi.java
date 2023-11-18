package sesame.gestion_freelances.controller.Api;

import org.springframework.web.bind.annotation.*;
import sesame.gestion_freelances.models.Projet;

import java.util.List;
import java.util.Optional;
import static sesame.gestion_freelances.utils.Constants.Api_Root;

public interface ProjetApi  {
    @PostMapping(value = Api_Root+"proj/create")
    Projet AjouterUnProjet(@RequestBody Projet projet);
    @DeleteMapping(value = Api_Root+"proj/{id}")
    void SupprimerUnProjet(@PathVariable int id);
    @PutMapping(value = Api_Root+"proj/{id}")
    Projet UpdateUnProjet(@RequestBody Projet projet,@PathVariable  int id);
    @GetMapping(value = Api_Root+"proj/{id}")
    Optional<Projet> getProjetById(@PathVariable  int id);
    @GetMapping(value = Api_Root+"proj/All")
    List<Projet> TousLesProjets();
}
