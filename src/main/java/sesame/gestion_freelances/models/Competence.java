package sesame.gestion_freelances.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sesame.gestion_freelances.models.Enumeration.NiveauCompetence;
import sesame.gestion_freelances.models.Enumeration.TypeCompetence;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    @Enumerated(EnumType.STRING)
    private TypeCompetence typeC;

    @Enumerated(EnumType.STRING)
    private NiveauCompetence niveauC;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_freelancer")
    private User freelancer;
}
