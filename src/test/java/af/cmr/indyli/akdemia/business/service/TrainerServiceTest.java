package af.cmr.indyli.akdemia.business.service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp2eConfig;
import af.cmr.indyli.akdemia.business.dao.ITrainerRepository;
import af.cmr.indyli.akdemia.business.entity.Trainer;
import jakarta.transaction.Transactional;

@DataJpaTest
@Transactional // Annule les modifications en BDD après chaque test
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = { AkdemiaBusinessGp2eConfig.class })


public class TrainerServiceTest {
	
	@Autowired
    private ITrainerRepository trainerRepository;

    @Autowired
    private ITrainerService trainerService;
    

    @Test
    public void testSaveAndDelete() {
    	
    	        // Préparer un nouveau Trainer
    	        Trainer newTrainer = new Trainer();
    	        newTrainer.setActivity("Software Development");
    	        newTrainer.setFirstName("John");
    	        newTrainer.setLastName("Doe");
    	        

    	        // Enregistrer le Trainer
    	        trainerRepository.save(newTrainer);

    	        // Rechercher le Trainer enregistré
    	        Trainer savedTrainer = trainerRepository.findById(newTrainer.getId()).get();

    	        // Vérifier les résultats
    	        assertEquals(newTrainer, savedTrainer);
    	    }

//    déclaration de la fonction pour le test 
	private void assertEquals(Trainer newTrainer, Trainer savedTrainer) {
		// TODO Auto-generated method stub
		
	}
    	 
  
    }
    

	



		


	

		
	

    

