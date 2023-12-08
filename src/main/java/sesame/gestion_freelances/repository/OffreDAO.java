package sesame.gestion_freelances.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sesame.gestion_freelances.models.Enumeration.DomaineExpertise;
import sesame.gestion_freelances.models.Enumeration.Technologie;
import sesame.gestion_freelances.models.Offre;

import java.util.List;

@RepositoryRestResource
public interface OffreDAO extends JpaRepository<Offre,Integer> {
    @Query("SELECT o, o.freelancer.firstname,o.freelancer.lastname,o.freelancer.numTel,o.freelancer.pays FROM Offre o WHERE o.domaineExpertise = :domaine AND o.technologie = :technologie")
    List<Object[]> rechercherOffresParDomaineEtTechnologie(
            @Param("domaine") DomaineExpertise domaine,
            @Param("technologie") Technologie technologie
    );

    List<Offre> findByFreelancerId(int userId);
}
