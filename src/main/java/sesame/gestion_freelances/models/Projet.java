package sesame.gestion_freelances.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sesame.gestion_freelances.models.Enumeration.StatusProjet;


import java.util.List;

@Entity
@Data
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String description;
    private String imageUrl;
    private float budget;
    private int duree;
    @Enumerated(EnumType.STRING)
    private StatusProjet statusProjet;
    @JsonIdentityReference(alwaysAsId = true)
    @JsonManagedReference("projet-cat")
    @OneToMany(mappedBy = "projetReference")
    private List<Categorie> categorieList;
    @JsonIdentityReference(alwaysAsId = true)
    @JsonManagedReference("projet-demande")
    @OneToMany(mappedBy = "projet")
    private List<DemandeRealisation> DemandeRealisation;

    @JsonBackReference("entreprise-Projet")
    @ManyToOne
    @JoinColumn(name = "idEntreprise")
    private User entreprise;
}
