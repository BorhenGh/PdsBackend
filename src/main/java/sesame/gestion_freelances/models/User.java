package sesame.gestion_freelances.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sesame.gestion_freelances.models.Enumeration.Pays;
import sesame.gestion_freelances.models.Enumeration.Role;
import sesame.gestion_freelances.token.Token;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String nomEntreprise;

    private String password;
    private boolean etatDispo;
    private int numTel;
    @Enumerated(EnumType.STRING)
    private Pays pays;
    @Enumerated(EnumType.STRING)
    private Role role;


    @OneToMany(mappedBy = "user")
    private List<Token> tokens;
    @JsonIdentityReference(alwaysAsId = true)
    @JsonManagedReference("entreprise-demande")
    @OneToMany(mappedBy = "entreprise")
    private List<DemandeRecrutement> demandeRecrutementsEn;
    @JsonIdentityReference(alwaysAsId = true)
    @JsonManagedReference("freelance-demande")
    @OneToMany(mappedBy = "freelancer")
    private List<DemandeRealisation> demandeRealisationFr;
    @JsonIdentityReference(alwaysAsId = true)
    @JsonManagedReference("freelance-offre")
    @OneToMany(mappedBy = "freelancer")
    private List<Offre> offreList;

    @JsonIdentityReference(alwaysAsId = true)
    @JsonManagedReference("entreprise-Projet")
    @OneToMany(mappedBy = "entreprise")
    private List<Projet> listeDesProjets;

    @JsonIdentityReference(alwaysAsId = true)
    @JsonManagedReference("freelancer-Mess")
    @OneToMany(mappedBy = "freelancer")
    private List<Message> ListeMessFr;

    @JsonIdentityReference(alwaysAsId = true)
    @JsonManagedReference("entreprise-Mess")
    @OneToMany(mappedBy = "entreprise")
    private List<Message> listeMessEn;
    @JsonIdentityReference(alwaysAsId = true)
    @JsonManagedReference("freelancer-Comp")
    @OneToMany(mappedBy = "freelancer")
    private List<Competence> competences;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role != null) {
            return List.of(new SimpleGrantedAuthority(role.name()));
        }
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
