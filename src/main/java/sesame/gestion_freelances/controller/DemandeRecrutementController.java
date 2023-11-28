package sesame.gestion_freelances.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sesame.gestion_freelances.controller.Api.DemandeRecrutementApi;
import sesame.gestion_freelances.models.DemandeRecrutement;
import sesame.gestion_freelances.service.DemandeRecrutementService;

import java.util.List;
import java.util.Optional;
@RestController
public class DemandeRecrutementController implements DemandeRecrutementApi {
    @Autowired
    DemandeRecrutementService demandeRecrutementService;
    @Override
    public DemandeRecrutement createDemandeRecrutement(DemandeRecrutement demandeRecrutement) {
        return demandeRecrutementService.createDemandeRecrutement(demandeRecrutement);
    }

    @Override
    public DemandeRecrutement validerDemandeRecrutement(Integer id) {
        return demandeRecrutementService.validerDemandeRecrutement(id);
    }

    @Override
    public DemandeRecrutement annulerDemandeRecrutement(Integer id) {
        return demandeRecrutementService.annulerDemandeRecrutement(id);
    }

    @Override
    public Optional<DemandeRecrutement> findById(Integer id) {
        return demandeRecrutementService.findById(id);
    }

    @Override
    public List<DemandeRecrutement> findAll() {
        return demandeRecrutementService.findAll();
    }

    @Override
    public List<Object[]> findAllValidDemande(Integer iden) {
        return demandeRecrutementService.findAllValidDemande(iden);
    }

    @Override
    public List<DemandeRecrutement> findAllEnCours() {
        return demandeRecrutementService.findAllEnCours();
    }

    @Override
    public List<DemandeRecrutement> findAllAnnuler() {
        return demandeRecrutementService.findAllAnnuler();
    }

    @Override
    public List<DemandeRecrutement> findAllValider() {
        return demandeRecrutementService.findAllValider();
    }

    @Override
    public void delete(int id) {
        demandeRecrutementService.delete(id);
    }
}
