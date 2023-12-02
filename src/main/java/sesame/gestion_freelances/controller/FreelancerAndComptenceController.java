package sesame.gestion_freelances.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sesame.gestion_freelances.controller.Api.FreelancerAndComptenenceApi;
import sesame.gestion_freelances.models.Competence;
import sesame.gestion_freelances.models.User;
import sesame.gestion_freelances.service.FeelancerAndCompetenceService;

import java.util.List;
@RestController
public class FreelancerAndComptenceController implements FreelancerAndComptenenceApi {
    @Autowired
    FeelancerAndCompetenceService freelancerAndCompetenceService;
    @Override
    public ResponseEntity<Void> addCompetenceToFreelancer(Integer id, Competence competence) {
        return freelancerAndCompetenceService.addCompetenceToFreelancer(id,competence);
    }

    @Override
    public ResponseEntity<List<Competence>> getCompetencesForFreelancer(Integer id) {
        return freelancerAndCompetenceService.getCompetencesForFreelancer(id);
    }

    @Override
    public ResponseEntity<Void> removeCompetenceFromFreeLaner(Integer id, Integer competenceId) {
        return freelancerAndCompetenceService.removeCompetenceFromFreeLaner(id,competenceId);
    }

    @Override
    public ResponseEntity<List<User>> getFreealncerForCompetence(Integer competenceId) {
        return freelancerAndCompetenceService.getFreealncerForCompetence(competenceId);
    }
}
