package sesame.gestion_freelances.service.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sesame.gestion_freelances.auth.UserDetailsUpdateRequest;
import sesame.gestion_freelances.models.ChangePasswordRequest;
import sesame.gestion_freelances.models.User;
import sesame.gestion_freelances.repository.UserRepository;
import sesame.gestion_freelances.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import java.security.Principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository,PasswordEncoder passwordEncoder ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return repository.findByEmail(email);
    }


    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();


        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }

        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));


        repository.save(user);
    }
    @Override
    public void updateProfileImage(MultipartFile image, Principal connectedUser) {
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();


        if (image != null && !image.isEmpty()) {
            try {

                String imageUrl = saveImage(image);


                user.setProfileImageUrl(imageUrl);


                repository.save(user);
            } catch (IOException e) {
                throw new IllegalStateException("Failed to save profile image: " + e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("Image file is empty or null");
        }
    }

    private String saveImage(MultipartFile image) throws IOException {
        String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
        String uploadDir = "src/main/resources/static/profile-images/";

        Path uploadPath = Path.of(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);


        return filePath.toString();
    }

    @Override
    public void updateProfileAndDetails(MultipartFile image, UserDetailsUpdateRequest userDetails, Principal connectedUser) {
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();


        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        user.setEmail(userDetails.getEmail());
        user.setNomEntreprise(userDetails.getNomEntreprise());


        if (image != null && !image.isEmpty()) {
            try {
                String imageUrl = saveImage(image);
                user.setProfileImageUrl(imageUrl);
            } catch (IOException e) {
                throw new IllegalStateException("Failed to save profile image: " + e.getMessage());
            }
        }

        repository.save(user);
    }
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof User) {
            return (User) authentication.getPrincipal();
        }
        return null;
    }



}