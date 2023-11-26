package sesame.gestion_freelances.controller.Api;

import org.springframework.web.bind.annotation.*;
import sesame.gestion_freelances.models.Enumeration.DomaineExpertise;
import sesame.gestion_freelances.models.Enumeration.Technologie;
import sesame.gestion_freelances.models.Offre;
import static sesame.gestion_freelances.utils.Constants.Api_Root;
import java.util.List;
import java.util.Optional;

public interface OffreApi {
    @PostMapping(value = Api_Root+"offer/create")
    Offre ajouterUneOffre(@RequestBody Offre offre);
    @DeleteMapping(value = Api_Root+"offer/{id}")
    void supprimerUneOffre(@PathVariable int id);
    @PutMapping(value = Api_Root+"offer/{id}")
    Offre updateUneOffre(@RequestBody Offre offre,@PathVariable int id);
    @GetMapping(value = Api_Root+"offer/{id}")
    Optional<Offre> getOffreById(@PathVariable int id);
    @GetMapping(value = Api_Root+"offer/All")
    List<Offre> tousLesOffres();
    @GetMapping(value = Api_Root+"/recherche/{domaine}/{technologie}")
 List<Object[]> rechercherOffresParDomaineEtTechnologie(@PathVariable DomaineExpertise domaine,@PathVariable Technologie technologie);
}
