package sesame.gestion_freelances.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesame.gestion_freelances.models.Enumeration.TicketStatus;
import sesame.gestion_freelances.models.Ticket;
import sesame.gestion_freelances.repository.TicketRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long ticketId) {
        return ticketRepository.findById(ticketId);
    }

    public Optional<Ticket> updateTicket(Long ticketId, Ticket updatedTicket) {
        return ticketRepository.findById(ticketId)
                .map(existingTicket -> {
                    updatedTicket.setId(ticketId);
                    return ticketRepository.save(updatedTicket);
                });
    }

    public boolean deleteTicket(Long ticketId) {
        if (ticketRepository.existsById(ticketId)) {
            ticketRepository.deleteById(ticketId);
            return true;
        } else {
            return false;
        }
    }

    public List<Ticket> getTicketsByUserId(Long userId) {
        return ticketRepository.findByCreatedBy_IdOrAssignedTo_Id(userId, userId);
    }

    public Ticket updateTicketWorkflowStatus(Long id, TicketStatus newStatus) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setStatus(newStatus);
            ticket.setLastUpdated(LocalDateTime.now());
            return ticketRepository.save(ticket);
        }
        return null;
    }
}