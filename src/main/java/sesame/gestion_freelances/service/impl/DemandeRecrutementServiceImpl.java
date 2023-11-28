package sesame.gestion_freelances.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesame.gestion_freelances.models.*;
import sesame.gestion_freelances.models.Enumeration.EtatDemande;
import sesame.gestion_freelances.repository.DemandeRecrutementDAO;
import sesame.gestion_freelances.repository.OffreDAO;
import sesame.gestion_freelances.repository.UserRepository;
import sesame.gestion_freelances.service.DemandeRecrutementService;

import java.util.List;
import java.util.Optional;
@Service
public class DemandeRecrutementServiceImpl implements DemandeRecrutementService {
    @Autowired
    DemandeRecrutementDAO demandeRecrutementDAO;
    @Autowired
    OffreDAO offreDAO;
    @Autowired
    UserRepository userRepository;
    @Override
    public DemandeRecrutement createDemandeRecrutement(DemandeRecrutement demandeRecrutement) {


        Offre offre = demandeRecrutement.getOffre();
        User entreprise = demandeRecrutement.getEntreprise();

        if (offre == null || entreprise == null) {
            throw new RuntimeException("Enregistrement échoué : Offre ou User non trouvé");
        }

        Offre offreEnBase = offreDAO.findById(offre.getId())
                .orElseThrow(() -> new RuntimeException(" Offre non trouvé avec l'ID : " + offre.getId()));

        User entreprise1 = userRepository.findById(entreprise.getId())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + entreprise.getId()));

        boolean demandeDejaExiste = demandeRecrutementDAO.existsByOffreAndEntreprise(offreEnBase, entreprise1);

        if (!demandeDejaExiste) {
            demandeRecrutement.setEtatD(EtatDemande.valueOf("En_Cours"));
            return demandeRecrutementDAO.save(demandeRecrutement);
        } else {
            throw new RuntimeException("Une demande de recrutement existe déjà pour ce projet et ce freelanceur");
        }
    }


    @Override
    public DemandeRecrutement validerDemandeRecrutement(Integer id) {
        // Check if the ID is not null
        if (id == null) {
            throw new IllegalArgumentException("ID de demande de recrutement non défini");
        }

        // Retrieve the DemandeRealisation from the repository
        Optional<DemandeRecrutement> demandeRecrutmentOptional = demandeRecrutementDAO.findById(id);

        if (demandeRecrutmentOptional.isPresent()) {
            DemandeRecrutement demandeRecrutement = demandeRecrutmentOptional.get();
            Offre offre= demandeRecrutement.getOffre();
            if (demandeRecrutement.getEtatD()!= EtatDemande.En_Cours){
                throw  new RuntimeException("La demade de recrutement est n'est pas en cours");
            }
            demandeRecrutement.setEtatD(EtatDemande.Valider);
            return demandeRecrutementDAO.save(demandeRecrutement);

        } else {
            throw new RuntimeException("Demande de recrutement non trouvée avec l'ID : " + id);
        }
    }

    @Override
    public DemandeRecrutement annulerDemandeRecrutement(Integer id) {
        // Check if the ID is not null
        if (id == null) {
            throw new IllegalArgumentException("ID de demande de réalisation non défini");
        }

        // Retrieve the DemandeRealisation from the repository
        Optional<DemandeRecrutement> demandeRecrutmentOptional = demandeRecrutementDAO.findById(id);

        if (demandeRecrutmentOptional.isPresent()) {
            DemandeRecrutement demandeRecrutement = demandeRecrutmentOptional.get();
            Offre offre= demandeRecrutement.getOffre();
            if (demandeRecrutement.getEtatD()!= EtatDemande.En_Cours){
                throw  new RuntimeException("La demade de recrutement est n'est pas en cours");
            }
            demandeRecrutement.setEtatD(EtatDemande.Annuler);
            return demandeRecrutementDAO.save(demandeRecrutement);

        } else {
            throw new RuntimeException("Demande de recrutement non trouvée avec l'ID : " + id);
        }
    }

    @Override
    public Optional<DemandeRecrutement> findById(Integer id) {
        return demandeRecrutementDAO.findById(id);
    }

    @Override
    public List<DemandeRecrutement> findAll() {
        return demandeRecrutementDAO.findAll();
    }

    @Override
    public List<Object[]> findAllValidDemande(Integer iden) {
        return demandeRecrutementDAO.findAllDemandeValidForEntreprise(iden);
    }

    @Override
    public List<DemandeRecrutement> findAllEnCours() {
        return demandeRecrutementDAO.findAllByEtatD(EtatDemande.valueOf("En_Cours"));
    }

    @Override
    public List<DemandeRecrutement> findAllAnnuler() {
        return demandeRecrutementDAO.findAllByEtatD(EtatDemande.valueOf("Annuler"));
    }

    @Override
    public List<DemandeRecrutement> findAllValider() {

            return demandeRecrutementDAO.findAllByEtatD(EtatDemande.valueOf("Valider"));
    }

    @Override
    public void delete(int id) {
        demandeRecrutementDAO.deleteById(id);
    }
}
