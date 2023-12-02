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
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "projet_images",
            joinColumns = {
                    @JoinColumn(name = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "image_id")
            }
    )
    private Set<ImageModel> productImages;

    public Set<ImageModel> getProductImages() {
        return productImages;
    }

    public void setProductImages(Set<ImageModel> productImages) {
        this.productImages = productImages;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "projet")
    private List<DemandeRealisation> DemandeRealisation;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idEntreprise")
    private User entreprise;
}
