package sesame.gestion_freelances.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sesame.gestion_freelances.models.Categorie;
@RepositoryRestResource
public interface CategorieDAO extends JpaRepository<Categorie,Integer> {
}
