package sesame.gestion_freelances.service;

import org.springframework.data.domain.Page;
import sesame.gestion_freelances.models.DemandeRealisation;
import sesame.gestion_freelances.models.Enumeration.DomaineExpertise;
import sesame.gestion_freelances.models.Enumeration.Experience;
import sesame.gestion_freelances.models.Enumeration.NatureTravail;
import sesame.gestion_freelances.models.Enumeration.Technologie;
import sesame.gestion_freelances.models.Offre;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface OffreService {
    Offre ajouterUneOffre(Offre offre);

    void supprimerUneOffre(int id);

    Offre updateUneOffre(Offre offre, int id);

    Optional<Offre> getOffreById(int id);
    List<Offre> findAll();
    List<Offre> rechercherOffresByCriteria(DomaineExpertise domaineExpertise, Technologie technologie, NatureTravail natureTravail,Experience experience);
    Page<Offre> tousLesOffres(int page, int size);
  List<Object[]> rechercherOffresParDomaineEtTechnologie(DomaineExpertise domaine, Technologie technologie);
    Page<Object> getAllOffresAndProjets(int page, int size);
    List<Offre> getOffresByUserId(int userId);

}
