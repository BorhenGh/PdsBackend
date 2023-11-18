package sesame.gestion_freelances.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;
import sesame.gestion_freelances.models.Enumeration.CategorieProjet;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    private CategorieProjet categorie;
    @ManyToOne
    @JoinColumn(name = "idprojet")
    Projet projet;
}
