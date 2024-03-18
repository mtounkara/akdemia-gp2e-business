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
import af.cmr.indyli.akdemia.business.dao.ISessionRepository;
import af.cmr.indyli.akdemia.business.entity.Session;
import jakarta.transaction.Transactional;


@Transactional
@ContextConfiguration(classes = { AkdemiaBusinessGp2eConfig.class })
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SessionServiceTest {

	
@Autowired ISessionRepository iSessionRepository;

@Autowired ISessionService iSessionService;


@Test
	public void testSessionCRUD() {
        // Create
        Session session = new Session();
        session.setCode("XYZ");
        session.setDuration(60L);
        session.setPrice(100.0);
        session.setDescription("Introduction to Java Programming");
        session.setStatus("Active");
        session.setDate(new Date(0));
        session.setLocation("Room 101");
        session.setSessionScore(90);
        session.setCreationDate(new Date(0));
        session.setUpdateDate(new Date(0));
        
//        objet a définir avant le test 
        
//        session.setAkdemiaTrainer(trainer);
//        session.setAkdemiaTraining(training);
        
//        sauve l'objet session
        iSessionRepository.save(session);
        
//        test qui verifie si l'objet est en base de donnée
        assertNotNull(session.getId());
        
        

        //  de du tect de lecture
        
//        la variable prend comme valeur l'objet en base 
        Session retrievedSession = iSessionRepository.findById(session.getId()).orElse(null);
        
//        verification du test 
//        il compare le champ code d'entrée avec celui stoker dans la vraiable
        assertEquals("XYZ", retrievedSession.getCode());

        // début du test d'Update
//        Ajout d'une nouvelle valeur dans l'objet retrieveSession
        retrievedSession.setCode("ABC");
//        sauvegarde dans la base de donner de l'objet retrieveSession
        iSessionRepository.save(retrievedSession);
        
//        recupération et stockage de du nouvelle objet dans une variable pour la comparaison
        Session updatedSession = iSessionRepository.findById(retrievedSession.getId()).orElse(null);
        
//        Vérification du test 
        assertEquals("ABC", updatedSession.getCode());

        // Delete
        iSessionRepository.deleteById(updatedSession.getId());
        
        Session deletedSession = iSessionRepository.findById(updatedSession.getId()).orElse(null);
        assertNull(deletedSession);
    }

}



