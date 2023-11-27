package sesame.gestion_freelances.service;

import sesame.gestion_freelances.models.ChangePasswordRequest;
import sesame.gestion_freelances.models.User;

import java.security.Principal;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserByEmail(String email);

    void changePassword(ChangePasswordRequest request, Principal connectedUser);
}
