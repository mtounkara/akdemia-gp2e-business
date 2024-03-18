package af.cmr.indyli.akdemia.business.service;

import java.util.List;
import java.util.Optional;

import af.cmr.indyli.akdemia.business.dao.IEmployeeSubscriptionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeSubscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.EmployeeSubscriptionFullDTO;
import af.cmr.indyli.akdemia.business.entity.EmployeeSubscription;
import af.cmr.indyli.akdemia.business.entity.Evaluation;

/**
 * 
 * @author Magamba
 * 
 *         Interface extending the IAbstractAkdemiaService interface for
 *         managing Evaluation, providing specific operations for
 *         {@link EmployeeSubscription} entities.
 *
 * @see IAbstractAkdemiaService
 *
 */

public interface IEmployeeSubscriptionService extends
		IAbstractAkdemiaService<EmployeeSubscription, EmployeeSubscriptionBasicDTO, EmployeeSubscriptionFullDTO, IEmployeeSubscriptionRepository> {

	// Créer une nouvelle souscription
	public EmployeeSubscription createEmployeeSubscription(EmployeeSubscription subscription);

	// Récupérer une souscription par ID
	public Optional<EmployeeSubscription> getEmployeeSubscriptionById(Integer id);

	// Modifier une souscription existante
	public EmployeeSubscription updateEmployeeSubscription(Integer id, EmployeeSubscription newSubscription);

	// Supprimer une souscription par ID
	public void deleteEmployeeSubscription(Integer id);

	// Récupérer toutes les souscriptions
	public List<EmployeeSubscription> getAllEmployeeSubscriptions();
}
