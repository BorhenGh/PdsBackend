package sesame.gestion_freelances.service;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import sesame.gestion_freelances.models.Competence;
import sesame.gestion_freelances.models.User;

import java.util.List;

public interface FeelancerAndCompetenceService {
  ResponseEntity<Void> addCompetenceToFreelancer(Integer id,Competence competence);
    ResponseEntity<List<Competence>> getCompetencesForFreelancer( Integer id);
    ResponseEntity<Void> removeCompetenceFromFreeLaner( Integer id,Integer competenceId);
    ResponseEntity<List<User>> getFreealncerForCompetence( Integer competenceId);

}
