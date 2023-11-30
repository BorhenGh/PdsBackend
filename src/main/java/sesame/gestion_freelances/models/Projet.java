package sesame.gestion_freelances.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sesame.gestion_freelances.models.Enumeration.DomaineExpertise;
import sesame.gestion_freelances.models.Enumeration.StatusProjet;
import sesame.gestion_freelances.models.Enumeration.Technologie;


import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String description;
    @Enumerated(EnumType.STRING)
    private DomaineExpertise domaineExpertise;

    @Enumerated(EnumType.STRING)
    private Technologie technologie;
    private String imageUrl;
    private float budget;
    private int duree;
    @Enumerated(EnumType.STRING)
    private StatusProjet statusProjet;

    @JsonIgnore
    @OneToMany(mappedBy = "projet")
    private List<DemandeRealisation> DemandeRealisation;


    @ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name = "idEntreprise")
    private User entreprise;
}
