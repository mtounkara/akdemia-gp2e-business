package af.cmr.indyli.akdemia.business.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp2eConfig;
import af.cmr.indyli.akdemia.business.dao.IEmployeeSubscriptionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeSubscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.CompanyFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.EmployeeFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.EmployeeSubscriptionFullDTO;
import af.cmr.indyli.akdemia.business.entity.EmployeeSubscription;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.impl.EmployeeSubscriptionServiceImpl;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;

/**
 * 
 * @author Magamba
 * Test for EmployeeSubscriptionService
 *
 */
@ContextConfiguration(classes = { AkdemiaBusinessGp2eConfig.class })
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeSubscriptionServiceTest {

	@Resource(name = ConstsValues.ServiceKeys.EMPLOYEE_SUBSCRIPTION_SERVICE_KEY)
	private IEmployeeSubscriptionService employeeSubscriptionService;
	private EmployeeSubscriptionFullDTO employeeSubscriptionForAllTest = null;
	private EmployeeFullDTO employeeForAllTest = null;
	//	private IntraSessionFullDTO intraSessionForAllTest = null; //--- Classe non implémentée
	private Integer idCreatedEmplSub = null;
	
	@Resource(name = ConstsValues.ServiceKeys.EMPLOYEE_SERVICE_KEY)
	private IEmployeeService employeeService;
	
	 @Mock
	    private IEmployeeSubscriptionRepository subscriptionRepository;

	    @InjectMocks
	    private EmployeeSubscriptionServiceImpl subscriptionService;

	    @Test
	    public void testCreateEmployeeSubscription() {
	        // Given
	        EmployeeSubscription subscriptionToCreate = new EmployeeSubscription();
	        when(subscriptionRepository.save(subscriptionToCreate)).thenReturn(subscriptionToCreate);

	        // When
	        EmployeeSubscription createdSubscription = subscriptionService.createEmployeeSubscription(subscriptionToCreate);

	        // Then
	        assertEquals(subscriptionToCreate, createdSubscription);
	    }

		@Test
	    public void testGetEmployeeSubscriptionById() {
	        // Given
	        int subscriptionId = 1;
	        EmployeeSubscription subscription = new EmployeeSubscription();
	        subscription.setId(subscriptionId);
	        when(subscriptionRepository.findById(subscriptionId)).thenReturn(Optional.of(subscription));

	        // When
	        Optional<EmployeeSubscription> foundSubscription = subscriptionService.getEmployeeSubscriptionById(subscriptionId);

	        // Then
	        assertEquals(subscription, foundSubscription.get());
	    }
}
