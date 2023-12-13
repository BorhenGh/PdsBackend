package sesame.gestion_freelances.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sesame.gestion_freelances.models.Enumeration.Pays;
import sesame.gestion_freelances.models.Enumeration.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int numTel;
    private Pays pays;
    private String nomEntreprise;
    private String siteweb;
    private Role role;
}