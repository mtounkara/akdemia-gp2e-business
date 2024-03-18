package af.cmr.indyli.akdemia.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import af.cmr.indyli.akdemia.business.dao.ITrainingRepository;
import af.cmr.indyli.akdemia.business.entity.Training;
import af.cmr.indyli.akdemia.business.service.ITrainingService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;

@Service(ConstsValues.ServiceKeys.TRAINING_SERVICE_KEY)
public class TrainingServiceImpl implements ITrainingService {
	
	@Autowired ITrainingRepository iTrainingRepository;

	@Override
	public List<Training> findAll() {
		return iTrainingRepository.findAll();
	}

	@Override
	public Training getTrainingById(Long id) {
		return iTrainingRepository.findById(id).orElse(null);	
	}

	@Override
	public Training saveTraining(Training training) {
        return iTrainingRepository.save(training);

	}

	@Override
	public void deleteTraining(Long id) {
        iTrainingRepository.deleteById(id);
		
	}

	
}
