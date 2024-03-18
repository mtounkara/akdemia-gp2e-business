package af.cmr.indyli.akdemia.business.service;

import org.springframework.stereotype.Service;

import af.cmr.indyli.akdemia.business.entity.InterSession;

@Service
public interface IInterSessionService {
	
	InterSession save(InterSession interSession);

	InterSession findById(Integer id);
	
	
	

	
}
