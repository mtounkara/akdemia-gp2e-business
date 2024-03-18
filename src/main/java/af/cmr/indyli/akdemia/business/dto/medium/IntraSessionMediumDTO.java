package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeSubscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.IntraSessionBasicDTO;

/**
 * @author Magamba DTO a completer apres la creation et le mapping de la classe
 *         {@link Session}
 */
public class IntraSessionMediumDTO extends IntraSessionBasicDTO {
	// --- Attributes : à completer après creation de l'entité Session
	private EmployeeSubscriptionBasicDTO emplSub;

	// -- Getters / setters
	public EmployeeSubscriptionBasicDTO getEmplSub() {
		return emplSub;
	}

	public void setEmplSub(EmployeeSubscriptionBasicDTO emplSub) {
		this.emplSub = emplSub;
	}

	public IntraSessionMediumDTO(EmployeeSubscriptionBasicDTO emplSub) {
		super();
		this.emplSub = emplSub;
	}

}
