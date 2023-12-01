package sesame.gestion_freelances.auth;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sesame.gestion_freelances.models.Enumeration.Pays;
import sesame.gestion_freelances.models.Enumeration.Role;
@Data

@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsUpdateRequest {
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
    private String profileImageUrl;
}
