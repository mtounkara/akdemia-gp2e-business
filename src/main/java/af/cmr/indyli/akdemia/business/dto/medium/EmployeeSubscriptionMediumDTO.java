package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeSubscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.IntraSessionBasicDTO;

/**
 * @author Magamba
 *
 */
public class EmployeeSubscriptionMediumDTO extends EmployeeSubscriptionBasicDTO {

	// --------------- ATTRIBUTES ---------------//
	private EmployeeBasicDTO employee;
	

	private IntraSessionBasicDTO intraSession;

	// --------------- CONSTRUCTOR ---------------//
	public EmployeeSubscriptionMediumDTO() {
		super();
	}
	// --------------- GETTERS/SETTERS ------------//

	public EmployeeBasicDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeBasicDTO employee) {
		this.employee = employee;
	}

	
	public IntraSessionBasicDTO getIntraSession() {
		return intraSession;
	}

	public void setIntraSession(IntraSessionBasicDTO intraSession) {
		this.intraSession = intraSession;
	}

}
