package sesame.gestion_freelances.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesame.gestion_freelances.models.DemandeRealisation;
import sesame.gestion_freelances.models.Enumeration.EtatDemande;
import sesame.gestion_freelances.models.Projet;
import sesame.gestion_freelances.models.User;
import sesame.gestion_freelances.repository.DemandeRealisationDAO;
import sesame.gestion_freelances.repository.ProjetDAO;
import sesame.gestion_freelances.repository.UserRepository;
import sesame.gestion_freelances.service.DemandeService;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeServiceImpl implements DemandeService {
    @Autowired
    DemandeRealisationDAO demandeRealisationDAO;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProjetDAO projetDAO;
    public DemandeRealisation createDemandeRealisation(DemandeRealisation demandeRealisation) {
        Integer id = demandeRealisation.getId();
        if (id != null) {
            throw new RuntimeException("ID de demande de réalisation déjà défini");
        }

        Projet projet = demandeRealisation.getProjet();
        User freelancer = demandeRealisation.getFreelancer();

        if (projet == null || freelancer == null) {
            throw new RuntimeException("Enregistrement échoué : Projet ou User non trouvé");
        }

        Projet projetEnBase = projetDAO.findById(projet.getId())
                .orElseThrow(() -> new RuntimeException("Projet non trouvé avec l'ID : " + projet.getId()));

        User freelancer1 = userRepository.findById(freelancer.getId())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + freelancer.getId()));

        boolean demandeDejaExiste = demandeRealisationDAO.existsByProjetAndFreelancer(projetEnBase, freelancer1);

        if (!demandeDejaExiste) {
            demandeRealisation.setEtatD(EtatDemande.valueOf("En_Cours"));
            return demandeRealisationDAO.save(demandeRealisation);
        } else {
            throw new RuntimeException("Une demande de réalisation existe déjà pour ce projet et ce freelanceur");
        }
    }




    @Override
    public DemandeRealisation validerDemandeRealisation(Integer id) {
        // Check if the ID is not null
        if (id == null) {
            throw new IllegalArgumentException("ID de demande de réalisation non défini");
        }

        // Retrieve the DemandeRealisation from the repository
        Optional<DemandeRealisation> demandeRealisationOptional = demandeRealisationDAO.findById(id);

        if (demandeRealisationOptional.isPresent()) {
            DemandeRealisation demandeRealisation = demandeRealisationOptional.get();
           Projet projet= demandeRealisation.getProjet();
           if (demandeRealisation.getEtatD()!= EtatDemande.En_Cours){
               throw  new RuntimeException("La demade de relastion est n'est pas en cours");
           }
                   demandeRealisation.setEtatD(EtatDemande.Valider);
                return demandeRealisationDAO.save(demandeRealisation);

        } else {
            throw new RuntimeException("Demande de réalisation non trouvée avec l'ID : " + id);
        }
    }

    @Override
    public DemandeRealisation annulerDemandeRealisation(Integer id) {
        // Check if the ID is not null
        if (id == null) {
            throw new IllegalArgumentException("ID de demande de réalisation non défini");
        }

        // Retrieve the DemandeRealisation from the repository
        Optional<DemandeRealisation> demandeRealisationOptional = demandeRealisationDAO.findById(id);

        if (demandeRealisationOptional.isPresent()) {
            DemandeRealisation demandeRealisation = demandeRealisationOptional.get();
            Projet projet = demandeRealisation.getProjet();

            // Check if the state is "En_Cours" (case-insensitive)
            if (demandeRealisation.getEtatD()!= EtatDemande.En_Cours){
                throw  new RuntimeException("La demade de relastion est n'est pas en cours");
            }

            // Set the state to "Annulee" and save the updated DemandeRealisation to the database
            demandeRealisation.setEtatD(EtatDemande.Annuler);
            return demandeRealisationDAO.save(demandeRealisation);
        } else {
            throw new RuntimeException("Demande de réalisation non trouvée avec l'ID : " + id);
        }
    }

    @Override
    public Optional<DemandeRealisation> findById(Integer id) {
        return demandeRealisationDAO.findById(id);
    }


    @Override
    public List<DemandeRealisation> findAll() {
        return demandeRealisationDAO.findAll();
    }

    @Override
    public List<Object[]> findAllValidDemande(Integer idfreelancer) {
        return demandeRealisationDAO.findAllDemandeValidForFreealncer(idfreelancer);
    }

    @Override
    public List<DemandeRealisation> findAllEnCours() {
        return demandeRealisationDAO.findAllByEtatD(EtatDemande.valueOf("En_Cours"));
    }

    @Override
    public List<DemandeRealisation> findAllAnnuler() {
        return demandeRealisationDAO.findAllByEtatD(EtatDemande.valueOf("Annuler"));
    }

    @Override
    public List<DemandeRealisation> findAllValider() {
        return demandeRealisationDAO.findAllByEtatD(EtatDemande.valueOf("Valider"));
    }



    @Override
    public void delete(int id) {
         demandeRealisationDAO.deleteById(id);
    }

}
