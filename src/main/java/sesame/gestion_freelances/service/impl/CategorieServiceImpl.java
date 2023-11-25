package sesame.gestion_freelances.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesame.gestion_freelances.models.Categorie;
import sesame.gestion_freelances.repository.CategorieDAO;
import sesame.gestion_freelances.service.CategorieService;


import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {
@Autowired
   CategorieDAO categorieRepository;


    public Categorie AjouterUneCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void SupprimerUneCategorie(int id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public Categorie UpdateUneCategorie(Categorie categorie, int id) {
        Optional<Categorie> existingCategorie = categorieRepository.findById(id);

        if (existingCategorie.isPresent()) {
            Categorie updatedCategorie = existingCategorie.get();
            updatedCategorie.setCategorie(categorie.getCategorie());
            updatedCategorie.setProjetReference(categorie.getProjetReference());
            return categorieRepository.save(updatedCategorie);
        } else {
            throw new RuntimeException("Catégorie non trouvée avec l'ID : " + id);
        }
    }
    @Override
    public Optional<Categorie> getCategorieById(int id) {
        return categorieRepository.findById(id);
    }

    @Override
    public List<Categorie> TousLesCategories() {

        return    categorieRepository.findAll();
    }

}
