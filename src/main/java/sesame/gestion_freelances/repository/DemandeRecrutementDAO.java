package sesame.gestion_freelances.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sesame.gestion_freelances.models.*;
import sesame.gestion_freelances.models.Enumeration.EtatDemande;

import java.util.List;

@RepositoryRestResource
public interface DemandeRecrutementDAO extends JpaRepository<DemandeRecrutement,Integer> {
    @Query("SELECT   f.prix_heure, f.description, f.domaineExpertise,f.technologie,d.etatD " +
            "FROM Offre f INNER JOIN f.demandeRecrutements d " +
            "WHERE d.etatD = 'Valider' AND d.entreprise.id = :idEntreprise")
    List<Object[]> findAllDemandeValidForEntreprise(@Param("idEntreprise") Integer idEntreprise);
        boolean existsByOffreAndEntreprise(Offre offre, User entreprise);
    List<DemandeRecrutement> findAllByEtatD(EtatDemande etat);
}
