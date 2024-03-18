package af.cmr.indyli.akdemia.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import af.cmr.indyli.akdemia.business.entity.Session;

@Service
public interface ISessionService {

	 List<Session> findAll() ;
	    void delete(Long id);
		Session save(Session session);
		Session findById(Long id);	
	    List<Session> getAllSessions();

}
