package af.cmr.indyli.akdemia.business.dto.full;

import af.cmr.indyli.akdemia.business.dto.basic.EmployeeSubscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.medium.IntraSessionMediumDTO;
/**
 * 
 * @author Magamba
 *
 */
public class IntraSessionFullDTO extends IntraSessionMediumDTO {

	public IntraSessionFullDTO(EmployeeSubscriptionBasicDTO emplSub) {
		super(emplSub);
	}

}
