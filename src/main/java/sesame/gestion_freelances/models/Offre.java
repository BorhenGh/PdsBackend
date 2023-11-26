package sesame.gestion_freelances.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sesame.gestion_freelances.models.Enumeration.DomaineExpertise;
import sesame.gestion_freelances.models.Enumeration.Technologie;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Offre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private float prix_heure;
    @Enumerated(EnumType.STRING)
    private DomaineExpertise domaineExpertise;

    @Enumerated(EnumType.STRING)
    private Technologie technologie;
    @JsonBackReference("freelance-offre")

    @ManyToOne
    @JoinColumn(name = "id_freelance")
    private User freelancer;
}
