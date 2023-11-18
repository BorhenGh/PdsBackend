package sesame.gestion_freelances.controller.Api;

import org.springframework.web.bind.annotation.*;
import sesame.gestion_freelances.models.Categorie;
import static sesame.gestion_freelances.utils.Constants.Api_Root;

import java.util.List;
import java.util.Optional;

public interface CategorieApi {
    @PostMapping(value = Api_Root+"cat/create")
    Categorie AjouterUneCategorie(@RequestBody Categorie categorie);
    @DeleteMapping(value = Api_Root+"cat/{id}")

    void SupprimerUneCategorie(@PathVariable int id);
    @PutMapping(value = Api_Root+"cat/{id}")

    Categorie UpdateUneCategorie(@RequestBody Categorie categorie,@PathVariable int id);
    @GetMapping(value = Api_Root+"cat/{id}")

    Optional<Categorie> getCategorieById(@PathVariable int id);
    @GetMapping(value = Api_Root+"cat/All")

    List<Categorie> TousLesCategories();
}
