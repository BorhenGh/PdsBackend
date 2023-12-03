package sesame.gestion_freelances.service;

import org.springframework.web.multipart.MultipartFile;
import sesame.gestion_freelances.auth.UserDetailsUpdateRequest;
import sesame.gestion_freelances.models.ChangePasswordRequest;
import sesame.gestion_freelances.models.User;

import java.security.Principal;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserByEmail(String email);

    void changePassword(ChangePasswordRequest request, Principal connectedUser);

    void updateProfileImage(MultipartFile image, Principal connectedUser);

    void updateProfileAndDetails(MultipartFile image, UserDetailsUpdateRequest userDetails, Principal connectedUser);
     User getUserById(int userId);
   User saveUser(User user) ;
}
