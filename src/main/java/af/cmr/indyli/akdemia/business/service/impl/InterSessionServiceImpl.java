package af.cmr.indyli.akdemia.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import af.cmr.indyli.akdemia.business.dao.IInterSessionRepository;
import af.cmr.indyli.akdemia.business.entity.InterSession;
import af.cmr.indyli.akdemia.business.entity.Trainer;
import af.cmr.indyli.akdemia.business.service.IInterSessionService;

public class InterSessionServiceImpl implements IInterSessionService {
	
	@Autowired
	private IInterSessionRepository iInterSessionRepository;
	
	@Override
	public InterSession save ( InterSession interSess) {
		return iInterSessionRepository.save(interSess);
	}
	
	@Override
	public InterSession findById(Integer id) {
	    return iInterSessionRepository.findById(id).orElse(null);
	}
	

	

}
