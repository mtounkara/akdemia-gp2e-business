package af.cmr.indyli.akdemia.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import af.cmr.indyli.akdemia.business.entity.Training;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;

@Service
public interface ITrainingService {
	
	List<Training> findAll();

    Training getTrainingById(Long id);

    Training saveTraining(Training training);

    void deleteTraining(Long id);

}
