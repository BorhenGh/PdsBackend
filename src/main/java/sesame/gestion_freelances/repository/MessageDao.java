package sesame.gestion_freelances.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sesame.gestion_freelances.models.Message ;


public interface MessageDao extends JpaRepository <Message , String>{


}
