package sesame.gestion_freelances.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesame.gestion_freelances.models.Offre;
import sesame.gestion_freelances.repository.OffreDAO;
import sesame.gestion_freelances.service.OffreService;

import java.util.List;
import java.util.Optional;
@Service
public class OffreServiceImpl implements OffreService {
    @Autowired
    OffreDAO offreDAO;
    @Override
    public Offre ajouterUneOffre(Offre offre) {
        return offreDAO.save(offre);
    }

    @Override
    public void supprimerUneOffre(int id) {
         offreDAO.deleteById(id);
    }

    @Override
    public Offre updateUneOffre(Offre offre, int id) {
        Optional<Offre> existingOffre = offreDAO.findById(id);

        if (existingOffre.isPresent()) {
            Offre updatedOffre = existingOffre.get();
            updatedOffre.setDescription(offre.getDescription());
            updatedOffre.setPrix_heure(offre.getPrix_heure());

            return offreDAO.save(updatedOffre);
        } else {
            throw new RuntimeException("Offre non trouvée avec l'ID : " + id);
        }
    }

    @Override
    public Optional<Offre> getOffreById(int id) {
        return offreDAO.findById(id);
    }

    @Override
    public List<Offre> tousLesOffres() {
        return offreDAO.findAll();
    }
}
