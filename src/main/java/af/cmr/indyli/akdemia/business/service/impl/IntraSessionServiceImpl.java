package af.cmr.indyli.akdemia.business.service.impl;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import af.cmr.indyli.akdemia.business.dao.IIntraSessionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.IntraSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.IntraSessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.IntraSession;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.IIntraSessionService;

/**
 * 
 * @author Magamba Service implements de IntraSession
 */
public class IntraSessionServiceImpl implements IIntraSessionService {

	@Autowired
	private IIntraSessionRepository intraSessionRepository;

	@Autowired
	private ModelMapper modelMapper;

	// --- Creation d'une IntraSession à partir d'un FullDTO
	@Override
	public IntraSessionFullDTO create(IntraSessionFullDTO ent) throws AkdemiaBusinessException {
		IntraSession intraSession = modelMapper.map(ent, IntraSession.class);
		return modelMapper.map(intraSessionRepository.save(intraSession), IntraSessionFullDTO.class);
	}

	//---	Mise à jour d'une IntraSession
	@Override
	public IntraSessionFullDTO update(IntraSessionFullDTO entToUpdate)
			throws AkdemiaBusinessException, AccessDeniedException {
		Optional<IntraSession> optionalIntraSession = intraSessionRepository.findById(entToUpdate.getId());
		if (optionalIntraSession.isPresent()) {
			IntraSession existingIntraSession = optionalIntraSession.get();
			modelMapper.map(entToUpdate, existingIntraSession);
			return modelMapper.map(intraSessionRepository.save(existingIntraSession), IntraSessionFullDTO.class);
		} else {
			throw new AkdemiaBusinessException("Session introuvable");
		}
	}
	
	//---	Suppression d'une IntraSession
	@Override
	public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
		intraSessionRepository.deleteById(id);
	}
	
	//---	Afficher toutes les intraSession
	@Override
	public List<IntraSessionBasicDTO> findAll() {
		return intraSessionRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, IntraSessionBasicDTO.class))
                .collect(Collectors.toList());
	}

	//---	Trouver une IntraSession par son Id
	@Override
	public IntraSessionFullDTO findById(int id) throws AkdemiaBusinessException {
		 IntraSession intraSession = intraSessionRepository.findById(id)
	                .orElseThrow(() -> new AkdemiaBusinessException("Session introuvable"));
	        return modelMapper.map(intraSession, IntraSessionFullDTO.class);
	}

	//---	verifier par l'Id si une IntraSession existe
	@Override
	public boolean ifEntityExistById(int id) throws AkdemiaBusinessException {
		return intraSessionRepository.existsById(id);
	}

	// ---	Conversion vers entite
	@Override
	public <T extends IntraSessionBasicDTO> T findById(int id, Class<T> type) throws AkdemiaBusinessException {
		IntraSessionFullDTO dto = findById(id);
        return modelMapper.map(dto, type);
	}

	@Override
	public IIntraSessionRepository getDAO() {
		return intraSessionRepository;
	}

}
