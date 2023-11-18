package sesame.gestion_freelances.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sesame.gestion_freelances.models.Enumeration.StatusProjet;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titre;
    private String description;
    private String imageUrl;
    private float budget;
    @Temporal(TemporalType.DATE)
    private Date dateProjet;
    @Enumerated(EnumType.STRING)
    private StatusProjet statusProjet;
    @OneToMany(mappedBy = "projet")
    List<Categorie> categorieList;

}
