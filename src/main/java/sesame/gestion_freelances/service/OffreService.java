package sesame.gestion_freelances.service;

import sesame.gestion_freelances.models.Enumeration.DomaineExpertise;
import sesame.gestion_freelances.models.Enumeration.Technologie;
import sesame.gestion_freelances.models.Offre;

import java.util.List;
import java.util.Optional;

public interface OffreService {
    Offre ajouterUneOffre(Offre offre);

    void supprimerUneOffre(int id);

    Offre updateUneOffre(Offre offre, int id);

    Optional<Offre> getOffreById(int id);

    List<Offre> tousLesOffres();
  List<Object[]> rechercherOffresParDomaineEtTechnologie(DomaineExpertise domaine, Technologie technologie);
}
