package sesame.gestion_freelances.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference("entreprise-demande")
    @ManyToOne
    @JoinColumn(name = "idEntreprise")
    private User entreprise;

    @JsonBackReference("offre-demande")
    @ManyToOne
    @JoinColumn(name = "idOffre")
    private Offre offre;

    @Temporal(TemporalType.DATE)
    private Date date_demande;

    @Enumerated(EnumType.STRING)
    private EtatDemande etatD;
}
