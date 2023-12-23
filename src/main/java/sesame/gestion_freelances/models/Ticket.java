package sesame.gestion_freelances.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sesame.gestion_freelances.models.Enumeration.TicketStatus;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String summary;
    @Column(length = 1000)
    private String description;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;
    private LocalDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

}
