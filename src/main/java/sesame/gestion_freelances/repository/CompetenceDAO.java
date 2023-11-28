package sesame.gestion_freelances.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import sesame.gestion_freelances.models.Competence;

@RepositoryRestResource
public interface CompetenceDAO extends JpaRepository<Competence,Integer> {
}
