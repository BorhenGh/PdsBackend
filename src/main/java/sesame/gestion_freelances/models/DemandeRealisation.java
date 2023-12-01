package sesame.gestion_freelances.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sesame.gestion_freelances.models.Enumeration.EtatDemande;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DemandeRealisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idfreelancer")
    private User freelancer;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idprojet")
    private Projet projet;

    @Temporal(TemporalType.DATE)
    private Date date_demande;

    @Enumerated(EnumType.STRING)
    private EtatDemande etatD;
}
