package af.cmr.indyli.akdemia.business.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import af.cmr.indyli.akdemia.business.dao.IEmployeeSubscriptionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeSubscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.EmployeeSubscriptionFullDTO;
import af.cmr.indyli.akdemia.business.entity.EmployeeSubscription;
import af.cmr.indyli.akdemia.business.service.IEmployeeSubscriptionService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;

/**
 * @author Magamba Service implementation class for managing
 *         {@link EmployeeSubscription} entity, extending the
 *         AbstractAkdemiaServiceImpl class. This class provides specific
 *         functionality for managing evaluation, including CRUD operations
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.EMPLOYEE_SUBSCRIPTION_SERVICE_KEY) // --- annotation Service
public class EmployeeSubscriptionServiceImpl extends
		AbstractAkdemiaServiceImpl<EmployeeSubscription, EmployeeSubscriptionBasicDTO, EmployeeSubscriptionFullDTO, IEmployeeSubscriptionRepository>
		implements IEmployeeSubscriptionService {

	// ----------- INJECTION DU DAO CORRESPONDANT : EmployeeSubscriptionRepository à
	// ----------- travers son interface IEmployeeSubscriptionRepository
	@Resource(name = ConstsValues.ConstsDAO.EMPLOYEE_SUBSCRIPTION_DAO_KEY)
	private IEmployeeSubscriptionRepository employeeSubscriptionRepository;

	public EmployeeSubscriptionServiceImpl() {
		super(EmployeeSubscription.class, EmployeeSubscriptionBasicDTO.class, EmployeeSubscriptionFullDTO.class);
	}

	// Créer une nouvelle souscription
	@Override
	public EmployeeSubscription createEmployeeSubscription(EmployeeSubscription subscription) {
		return employeeSubscriptionRepository.save(subscription);
	}

	// Récupérer une souscription par ID
	@Override
	public Optional<EmployeeSubscription> getEmployeeSubscriptionById(Integer id) {
		return employeeSubscriptionRepository.findById(id);
	}

	// Modifier une souscription existante
	@Override
	public EmployeeSubscription updateEmployeeSubscription(Integer id, EmployeeSubscription newSubscription) {
		Optional<EmployeeSubscription> optionalSubscription = employeeSubscriptionRepository.findById(id);
		if (optionalSubscription.isPresent()) {
			EmployeeSubscription existingSubscription = optionalSubscription.get();
			existingSubscription.setStatus(newSubscription.getStatus());
			existingSubscription.setCreationDate(newSubscription.getCreationDate());
			existingSubscription.setUpdateDate(newSubscription.getUpdateDate());
			existingSubscription.setIntraSession(newSubscription.getIntraSession());
			existingSubscription.setEmployee(newSubscription.getEmployee());
			return employeeSubscriptionRepository.save(existingSubscription);
		} else {
			// Gérer le cas où la souscription n'existe pas
			return null;
		}
	}

	// Supprimer une souscription par ID
	@Override
	public void deleteEmployeeSubscription(Integer id) {
		employeeSubscriptionRepository.deleteById(id);
	}

	// Récupérer toutes les souscriptions
	@Override
	public List<EmployeeSubscription> getAllEmployeeSubscriptions() {
		return employeeSubscriptionRepository.findAll();
	}

	@Override
	public IEmployeeSubscriptionRepository getDAO() {
		return this.employeeSubscriptionRepository;
	}

}
