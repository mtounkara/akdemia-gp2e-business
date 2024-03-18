package af.cmr.indyli.akdemia.business.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp2eConfig;
import af.cmr.indyli.akdemia.business.dao.IInterSessionRepository;
import af.cmr.indyli.akdemia.business.dao.ISessionRepository;
import af.cmr.indyli.akdemia.business.entity.InterSession;
import jakarta.transaction.Transactional;

@DataJpaTest
@Transactional // Annule les modifications en BDD après chaque test
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = { AkdemiaBusinessGp2eConfig.class })
public class InterSessionServiceTest {

	@Autowired
	private IInterSessionRepository iInterSessionRepository;

	@Test
	public void testInterSessionMapping() {
        // Create a sample InterSession object
        InterSession interSession = new InterSession();
        interSession.setMinParticipants(5);

        // Save the object to the database
        iInterSessionRepository.save(interSession);

        // Retrieve the object from the database
        InterSession retrievedInterSession = iInterSessionRepository.findById(interSession.getId().intValue()).orElse(null);

        // Perform assertions
        assertEquals(5, retrievedInterSession.getMinParticipants().intValue());
    }

}
