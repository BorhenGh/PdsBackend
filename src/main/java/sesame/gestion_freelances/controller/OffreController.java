package sesame.gestion_freelances.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sesame.gestion_freelances.controller.Api.OffreApi;
import sesame.gestion_freelances.models.Offre;
import sesame.gestion_freelances.service.OffreService;

import java.util.List;
import java.util.Optional;
@RestController
public class OffreController implements OffreApi {
    @Autowired
    OffreService offreService;
    @Override
    public Offre ajouterUneOffre(Offre offre) {
        return offreService.ajouterUneOffre(offre);
    }

    @Override
    public void supprimerUneOffre(int id) {
             offreService.supprimerUneOffre(id);
    }

    @Override
    public Offre updateUneOffre(Offre offre, int id) {
        return offreService.updateUneOffre(offre,id);
    }

    @Override
    public Optional<Offre> getOffreById(int id) {
        return offreService.getOffreById(id);
    }

    @Override
    public List<Offre> tousLesOffres() {
        return offreService.tousLesOffres();
    }
}
