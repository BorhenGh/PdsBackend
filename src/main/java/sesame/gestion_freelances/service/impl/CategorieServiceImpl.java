package sesame.gestion_freelances.service.impl;


import org.springframework.stereotype.Service;
import sesame.gestion_freelances.models.Categorie;
import sesame.gestion_freelances.repository.CategorieDAO;


import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl {

   CategorieDAO categorieRepository;

    public Categorie ajouterUneCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public void supprimerUneCategorie(int id) {
        categorieRepository.deleteById(id);
    }

    public Categorie updateUneCategorie(Categorie categorie, int id) {
        Optional<Categorie> existingCategorie = categorieRepository.findById(id);

        if (existingCategorie.isPresent()) {
            Categorie updatedCategorie = existingCategorie.get();
            updatedCategorie.setCategorie(categorie.getCategorie());
            updatedCategorie.setProjet(categorie.getProjet());
            return categorieRepository.save(updatedCategorie);
        } else {
            throw new RuntimeException("Catégorie non trouvée avec l'ID : " + id);
        }
    }

    public Optional<Categorie> getCategorieById(int id) {
        return categorieRepository.findById(id);
    }

    public List<Categorie> tousLesCategories() {
        return categorieRepository.findAll();
    }
}
