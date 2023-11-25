package sesame.gestion_freelances.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sesame.gestion_freelances.controller.Api.CategorieApi;
import sesame.gestion_freelances.models.Categorie;
import sesame.gestion_freelances.service.CategorieService;

import java.util.List;
import java.util.Optional;
@RestController
public class CategorieController implements CategorieApi {
    @Autowired
    CategorieService categorieService;
    @Override
    public Categorie AjouterUneCategorie(Categorie categorie) {
        return categorieService.AjouterUneCategorie(categorie);
    }

    @Override
    public void SupprimerUneCategorie(int id) {
         categorieService.SupprimerUneCategorie(id);
    }

    @Override
    public Categorie UpdateUneCategorie(Categorie categorie, int id) {
        return categorieService.UpdateUneCategorie(categorie,id);
    }

    @Override
    public Optional<Categorie> getCategorieById(int id) {
        return categorieService.getCategorieById(id);
    }

    @Override
    public List<Categorie> TousLesCategories() {
        return categorieService.TousLesCategories();
    }
}
