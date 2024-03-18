package af.cmr.indyli.akdemia.business.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp2eConfig;
import af.cmr.indyli.akdemia.business.dao.ITrainingRepository;
import af.cmr.indyli.akdemia.business.entity.Training;
import jakarta.transaction.Transactional;

@DataJpaTest
@Transactional // Annule les modifications en BDD après chaque test
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = { AkdemiaBusinessGp2eConfig.class })

public class TrainingServiceTest {
	
	@Autowired ITrainingRepository iTrainingRepository;
	
	@Autowired ITrainingService iTrainingService;

	@Test
	public void testSaveAndDeleteTraining() {
        // Créer une instance de Training pour l'insertion
        Training trainingToSave = new Training();
        trainingToSave.setTitle("Formation de test");
        trainingToSave.setDescription("Description de la formation de test");
        trainingToSave.setTrainingPrice(99.99);
        trainingToSave.setCreationDate(new Date(0));

        // Enregistrer la formation dans la base de données
        Training savedTraining = iTrainingRepository.save(trainingToSave);

        // Récupérer la formation depuis la base de données
        Training retrievedTraining = iTrainingRepository.findById(savedTraining.getId()).orElse(null);
        assertNotNull(retrievedTraining);
        assertEquals("Formation de test", retrievedTraining.getTitle());

        // Supprimer la formation de la base de données
        iTrainingRepository.deleteById(savedTraining.getId());

        // Vérifier que la formation a été supprimée
        Training deletedTraining = iTrainingRepository.findById(savedTraining.getId()).orElse(null);
        assertNull(deletedTraining);
    }

}
