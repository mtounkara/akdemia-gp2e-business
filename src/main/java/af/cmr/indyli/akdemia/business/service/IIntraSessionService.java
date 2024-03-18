package af.cmr.indyli.akdemia.business.service;

import org.springframework.stereotype.Repository;

import af.cmr.indyli.akdemia.business.dao.IEmployeeSubscriptionRepository;
import af.cmr.indyli.akdemia.business.dao.IIntraSessionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeSubscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.IntraSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.EmployeeSubscriptionFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.IntraSessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.EmployeeSubscription;
import af.cmr.indyli.akdemia.business.entity.IntraSession;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;

/**
 * 
 * @author Magamba
 * 
 */
@Repository(value = ConstsValues.ServiceKeys.INTRA_SESSION_SERVICE_KEY)
public interface IIntraSessionService extends
IAbstractAkdemiaService<IntraSession, IntraSessionBasicDTO, IntraSessionFullDTO, IIntraSessionRepository> {

}
 