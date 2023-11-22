package sesame.gestion_freelances.service;

import sesame.gestion_freelances.models.Projet;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Projet AjouterUnProjet(Projet projet);
    void SupprimerUnProjet(int id);
    Projet UpdateUnProjet(Projet projet,int id);

    Optional<Projet> getProjetById(int id);
    List<Projet> TousLesProjets();
}