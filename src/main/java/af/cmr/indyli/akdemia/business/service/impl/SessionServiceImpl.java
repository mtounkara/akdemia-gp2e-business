package af.cmr.indyli.akdemia.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import af.cmr.indyli.akdemia.business.dao.ISessionRepository;
import af.cmr.indyli.akdemia.business.entity.Session;
import af.cmr.indyli.akdemia.business.service.ISessionService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;

@Service (value = ConstsValues.ServiceKeys.SESSION_SERVICE_KEY)
public class SessionServiceImpl implements ISessionService  {
	
	@Autowired ISessionRepository iSessionRepository;
	
	 public List<Session> findAll() {
		 return iSessionRepository.findAll();
	 }

	@Override
	public Session findById(Long id) {
		return iSessionRepository.findById(id).orElse(null) ;
	}

	@Override
	public Session save(Session session) {
		return iSessionRepository.save(session) ; 
	}

	@Override
	public void delete(Long id) {
		iSessionRepository.deleteById(id);
	}

	@Override
	public List<Session> getAllSessions() {
        return iSessionRepository.findAll();

	}
	

}
