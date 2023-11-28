package sesame.gestion_freelances.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @JsonIgnoreProperties("freelancer")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFreelancer")
    private User freelancer;

    @JsonIgnoreProperties("entreprise")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idRhEntreprise")
    private User entreprise;
}
