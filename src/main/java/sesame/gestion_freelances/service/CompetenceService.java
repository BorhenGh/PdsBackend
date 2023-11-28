package sesame.gestion_freelances.service;

import sesame.gestion_freelances.models.Competence;
import sesame.gestion_freelances.models.Projet;

import java.util.List;
import java.util.Optional;

public interface CompetenceService {
    Competence AjouterUneCompetence(Competence competence);
    void SupprimerUneCompetence(int id);
    Competence UpdateUneCompetence(Competence competence,int id);

    Optional<Competence> getUneCompetenceById(int id);
    List<Competence> TousLesCompetences();
}
