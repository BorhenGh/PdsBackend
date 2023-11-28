package sesame.gestion_freelances.controller.Api;

import org.springframework.web.bind.annotation.*;
import sesame.gestion_freelances.models.Competence;

import java.util.List;
import java.util.Optional;

import static sesame.gestion_freelances.utils.Constants.Api_Root;

public interface CompetenceApi {
    @PostMapping(value = Api_Root+"Compet/create")
    Competence AjouterUneCompetence(@RequestBody Competence competence);
    @DeleteMapping(value = Api_Root +"Compet/{id}")
    void SupprimerUneCompetence(@PathVariable int id);
    @PutMapping(value = Api_Root +"/Compet/{id}")
    Competence UpdateUneCompetence(@RequestBody Competence competence,@PathVariable int id);
    @GetMapping(value = Api_Root +"Compet/{id}")
    Optional<Competence> getUneCompetenceById(@PathVariable int id);
    @GetMapping(value = Api_Root+"/Compet/All")
    List<Competence> TousLesCompetences();
}

