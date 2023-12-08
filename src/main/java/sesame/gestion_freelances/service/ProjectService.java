package sesame.gestion_freelances.service;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import sesame.gestion_freelances.models.Enumeration.DomaineExpertise;
import sesame.gestion_freelances.models.Enumeration.Technologie;
import sesame.gestion_freelances.models.Offre;
import sesame.gestion_freelances.models.Projet;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Projet ajouterUnProjet(Projet projet);
    void supprimerUnProjet(int id);
    Projet updateUnProjet(Projet projet, int id);
    Optional<Projet> getProjetById(int id);
    Page<Projet> tousLesProjets(int page,int size);
    List<Projet> findAll();
    List<Object[]> rechercherProjetsParDomaineEtTechnologie(DomaineExpertise domaine, Technologie technologie);
    List<Projet> getProjetByUserId(int userId);
}
