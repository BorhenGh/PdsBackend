package sesame.gestion_freelances.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sesame.gestion_freelances.models.Ticket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByCreatedBy_IdOrAssignedTo_Id(Long createdByUserId, Long assignedToUserId);

}
