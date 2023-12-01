package sesame.gestion_freelances.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sesame.gestion_freelances.models.Enumeration.EtatDemande;

import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DemandeRecrutement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idEntreprise")
    private User entreprise;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idOffre")
    private Offre offre;

    @Temporal(TemporalType.DATE)
    private Date date_demande;

    @Enumerated(EnumType.STRING)
    private EtatDemande etatD;
}
