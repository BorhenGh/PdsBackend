package sesame.gestion_freelances.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesame.gestion_freelances.models.Competence;
import sesame.gestion_freelances.models.Offre;
import sesame.gestion_freelances.repository.CompetenceDAO;
import sesame.gestion_freelances.service.CompetenceService;

import java.util.List;
import java.util.Optional;
@Service
public class CompetenceServiceImpl implements CompetenceService {
    @Autowired
    CompetenceDAO competenceDAO;
    @Override
    public Competence AjouterUneCompetence(Competence competence) {
        return competenceDAO.save(competence);
    }

    @Override
    public void SupprimerUneCompetence(int id) {
          competenceDAO.deleteById(id);
    }

    @Override
    public Competence UpdateUneCompetence(Competence competence, int id) {

        Optional<Competence> existingCompetence = competenceDAO.findById(id);

        if (existingCompetence.isPresent()) {
            Competence updatedskills = existingCompetence.get();
            updatedskills.setNom(competence.getNom());
            updatedskills.setFreelancer(competence.getFreelancer());
            updatedskills.setTypeC(competence.getTypeC());
            updatedskills.setNiveauC(competence.getNiveauC());
            return competenceDAO.save(updatedskills);
        } else {
            throw new RuntimeException("Competence non trouvée avec l'ID : " + id);
        }
    }


    @Override
    public Optional<Competence> getUneCompetenceById(int id) {
        return competenceDAO.findById(id);
    }

    @Override
    public List<Competence> TousLesCompetences() {
        return competenceDAO.findAll();
    }
}
