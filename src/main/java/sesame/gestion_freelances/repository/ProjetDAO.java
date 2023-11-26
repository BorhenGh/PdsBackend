package sesame.gestion_freelances.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sesame.gestion_freelances.models.Enumeration.DomaineExpertise;
import sesame.gestion_freelances.models.Enumeration.Technologie;
import sesame.gestion_freelances.models.Projet;

import java.util.List;

@RepositoryRestResource
public interface ProjetDAO extends JpaRepository<Projet,Integer> {
    @Query("SELECT p, p.entreprise.nomEntreprise, p.entreprise.pays, p.entreprise.numTel FROM Projet p WHERE p.domaineExpertise = :domaine AND p.technologie = :technologie")
    List<Object[]> rechercherProjetsParDomaineEtTechnologie(
            @Param("domaine") DomaineExpertise domaine,
            @Param("technologie") Technologie technologie
    );
}
