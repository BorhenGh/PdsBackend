package sesame.gestion_freelances.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date date_envois;

    @JsonBackReference("freelancer-Mess")
    @ManyToOne
    @JoinColumn(name = "idFreelancer")
    private User freelancer;

    @JsonBackReference("entreprise-Mess")
    @ManyToOne
    @JoinColumn(name = "idRhEntreprise")
    private User entreprise;
}
