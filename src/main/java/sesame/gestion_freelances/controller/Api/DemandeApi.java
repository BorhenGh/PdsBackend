package sesame.gestion_freelances.controller.Api;

import org.springframework.web.bind.annotation.*;
import sesame.gestion_freelances.models.DemandeRealisation;

import java.util.List;
import java.util.Optional;

import static sesame.gestion_freelances.utils.Constants.Api_Root;

public interface DemandeApi {
    @PostMapping(value = Api_Root+"demandeF/create")
    DemandeRealisation createDemandeRealisation(@RequestBody DemandeRealisation demandeRealisation);
    @PutMapping(value = Api_Root +"/valider/{id}")
    DemandeRealisation validerDemandeRealisation(@PathVariable Integer id);
    @PutMapping(value = Api_Root +"/annuler/{id}")
    DemandeRealisation annulerDemandeRealisation(@PathVariable Integer id);
    @GetMapping(value = Api_Root +"/{id}")
    Optional<DemandeRealisation> findById(@PathVariable Integer id);
    @GetMapping(value = Api_Root +"/all")
    List<DemandeRealisation> findAll();
    @GetMapping(value = Api_Root+"/demandeF/valid/{idfreelancer}")

    List<Object[]> findAllValidDemande(@PathVariable Integer idfreelancer);
    @GetMapping(value = Api_Root+"/demandeF/encours/All")

     List<DemandeRealisation> findAllEnCours();
    @GetMapping(value = Api_Root+"/demandeF/annuler/All")
     List<DemandeRealisation> findAllAnnuler();
    @GetMapping(value = Api_Root+"/demandeF/valider/All")
    public List<DemandeRealisation> findAllValider();
    @DeleteMapping(value = Api_Root +"/{id}")
    void delete(@PathVariable int id);
}
