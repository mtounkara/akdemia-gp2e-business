package af.cmr.indyli.akdemia.business.service;

import static org.mockito.Mockito.when;

import java.nio.file.AccessDeniedException;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp2eConfig;
import af.cmr.indyli.akdemia.business.dao.IIntraSessionRepository;
import af.cmr.indyli.akdemia.business.dto.full.IntraSessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.IntraSession;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.impl.IntraSessionServiceImpl;

@ContextConfiguration(classes = { AkdemiaBusinessGp2eConfig.class })
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
/**
 * 
 * @author Magamba
 * Classe de test de IntraSession : méthode create testée
 *
 */
public class IntraSessionServiceTest {
	@Mock
    private IIntraSessionRepository intraSessionRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private IntraSessionServiceImpl intraSessionService;

    @Test
    public void testCreate() throws AkdemiaBusinessException {
        // Préparation des données de test
        IntraSessionFullDTO dto = new IntraSessionFullDTO(null);
        IntraSession intraSession = new IntraSession();
        when(modelMapper.map(dto, IntraSession.class)).thenReturn(intraSession);
        when(modelMapper.map(intraSession, IntraSessionFullDTO.class)).thenReturn(dto);
        when(intraSessionRepository.save(intraSession)).thenReturn(intraSession);

        // Appel de la méthode à tester
        IntraSessionFullDTO result = intraSessionService.create(dto);

        // Vérification du résultat
        Assertions.assertNotNull(result);
        // Vous pouvez ajouter d'autres assertions selon le comportement attendu
    }
}
