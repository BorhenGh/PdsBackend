package sesame.gestion_freelances.service;

import org.springframework.web.multipart.MultipartFile;
import sesame.gestion_freelances.models.Enumeration.DomaineExpertise;
import sesame.gestion_freelances.models.Enumeration.Technologie;
import sesame.gestion_freelances.models.Projet;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Projet ajouterUnProjet(Projet projet, MultipartFile image);
    void supprimerUnProjet(int id);
    Projet updateUnProjet(Projet projet, int id, MultipartFile image);
    Optional<Projet> getProjetById(int id);
    List<Projet> tousLesProjets();
    List<Object[]> rechercherProjetsParDomaineEtTechnologie(DomaineExpertise domaine, Technologie technologie);
}
