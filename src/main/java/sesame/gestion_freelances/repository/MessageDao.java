package sesame.gestion_freelances.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sesame.gestion_freelances.models.Message ;

import java.util.List;


public interface MessageDao extends JpaRepository <Message , Long>{


        List<Message> findByChatIdOrderByDateSent(String chatId);
}
