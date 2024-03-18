package af.cmr.indyli.akdemia.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import af.cmr.indyli.akdemia.business.entity.Employee;
import af.cmr.indyli.akdemia.business.entity.EmployeeSubscription;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;

/**
 * 
 * @author Magamba
 * 
 * This interface serves as a repository for managing {@link EmployeeSubscription} entities
 * in the database. It extends JpaRepository, providing CRUD operations for the
 * {@link EmployeeSubscription} entity with Integer as the type of its primary key.
 */

@Repository(value = ConstsValues.ConstsDAO.EMPLOYEE_SUBSCRIPTION_DAO_KEY)
public interface IEmployeeSubscriptionRepository extends JpaRepository<EmployeeSubscription, Integer> {

}
