package sesame.gestion_freelances.service;

import sesame.gestion_freelances.models.Categorie;
import sesame.gestion_freelances.models.Projet;

import java.util.List;
import java.util.Optional;

public interface CategorieService {
    Categorie AjouterUneCategorie(Categorie categorie);
    void SupprimerUneCategorie(int id);
    Categorie UpdateUneCategorie(Categorie categorie,int id);

    Optional<Categorie> getCategorieById(int id);
    List<Categorie> TousLesCategories();
}
