package sesame.gestion_freelances.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sesame.gestion_freelances.models.ChangePasswordRequest;
import sesame.gestion_freelances.models.User;
import sesame.gestion_freelances.repository.UserRepository;
import sesame.gestion_freelances.service.UserService;
import sesame.gestion_freelances.service.impl.UserServiceImpl;


import java.security.Principal;
import java.util.Optional;

import static sesame.gestion_freelances.utils.Constants.Api_Root;

@RestController
@RequestMapping(value = Api_Root+"/users")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    private UserRepository userRepository;
    @PatchMapping
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser
    ) {
        userService.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) throws ChangeSetPersister.NotFoundException {
        return Optional.ofNullable(userService.getUserByEmail(email)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException()));
    }

}