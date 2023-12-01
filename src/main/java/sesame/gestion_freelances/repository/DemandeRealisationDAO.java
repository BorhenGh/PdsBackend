package sesame.gestion_freelances.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import sesame.gestion_freelances.models.DemandeRealisation;
import sesame.gestion_freelances.models.Enumeration.EtatDemande;
import sesame.gestion_freelances.models.Projet;
import sesame.gestion_freelances.models.User;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface DemandeRealisationDAO extends JpaRepository<DemandeRealisation,Integer> {

    @Query("SELECT   f.titre, f.description, f.imageUrl,f.duree,d.etatD " +
            "FROM Projet f INNER JOIN f.DemandeRealisation d " +
            "WHERE d.etatD = 'Valider' AND d.freelancer.id = :idFreelancer")
    List<Object[]> findAllDemandeValidForFreealncer(@Param("idFreelancer") Integer idFreelancer);
    boolean existsByProjetAndFreelancer(Projet projet, User freelancer);
    List<DemandeRealisation> findAllByEtatD(EtatDemande etat);


}
