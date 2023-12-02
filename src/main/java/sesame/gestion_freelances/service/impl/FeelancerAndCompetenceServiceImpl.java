package sesame.gestion_freelances.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sesame.gestion_freelances.models.Competence;
import sesame.gestion_freelances.models.User;
import sesame.gestion_freelances.repository.CompetenceDAO;
import sesame.gestion_freelances.repository.UserRepository;
import sesame.gestion_freelances.service.FeelancerAndCompetenceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeelancerAndCompetenceServiceImpl implements FeelancerAndCompetenceService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CompetenceDAO competenceDAO;
    @Override
    public ResponseEntity<Void> addCompetenceToFreelancer(Integer id, Competence competence) {
        try {
            User freelancer = userRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Freelancer not found"));

            Competence competenceToAdd = competenceDAO.findById(competence.getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Competence not found"));

            if (freelancer.getCompetences().contains(competenceToAdd)) {
                return ResponseEntity.badRequest().build();
            }

            freelancer.getCompetences().add(competenceToAdd);
            competenceToAdd.getFreelancers().add(freelancer);

            userRepository.save(freelancer);
            competenceDAO.save(competenceToAdd);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @Override
    public ResponseEntity<List<Competence>> getCompetencesForFreelancer(Integer id) {
        Optional<User> optionalFreealncer = userRepository.findById(id);
        if (!optionalFreealncer.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        User freelancer = optionalFreealncer.get();
        List<Competence> competences = freelancer.getCompetences();
        return ResponseEntity.ok(competences);
    }

    @Override
    public ResponseEntity<Void> removeCompetenceFromFreeLaner(Integer id, Integer competenceId) {
        Optional<User> optionalFreealncer = userRepository.findById(id);
        Optional<Competence> optionalCompetence = competenceDAO.findById(competenceId);
        if (!optionalFreealncer.isPresent() || !optionalCompetence.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        User freelancer = optionalFreealncer.get();
        Competence competenceToRemove = optionalCompetence.get();
        if (!freelancer.getCompetences().contains(competenceToRemove)) {
            return ResponseEntity.badRequest().build();
        }
        freelancer.getCompetences().remove(competenceToRemove);
        userRepository.save(freelancer);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<User>> getFreealncerForCompetence(Integer competenceId) {
        Optional<Competence> competenceOptional = competenceDAO.findById(competenceId);
        if (!competenceOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Competence competence = competenceOptional.get();
        List<User> freelancers = competence.getFreelancers();
        return ResponseEntity.ok(freelancers);
    }
}
