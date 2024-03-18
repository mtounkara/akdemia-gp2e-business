package af.cmr.indyli.akdemia.business.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import af.cmr.indyli.akdemia.business.dao.ITrainerRepository;
import af.cmr.indyli.akdemia.business.entity.Trainer;
import af.cmr.indyli.akdemia.business.service.ITrainerService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;

@Service(ConstsValues.ServiceKeys.TRAINER_SERVICE_KEY)
public class TrainerServiceImpl implements ITrainerService {

@Autowired
private ITrainerRepository trainerRepository;

@Override
public Trainer createTrainer(Trainer trainer) {
    return trainerRepository.save(trainer);
}

@Override
public List<Trainer> findAllTrainers() {
    return trainerRepository.findAll();
}

@Override
public Trainer getTrainerById(int id) {
    Optional<Trainer> trainerOptional = trainerRepository.findById(id);
    return trainerOptional.orElse(null);
}

@Override
public void deleteTrainerById(int id) {
    trainerRepository.deleteById(id);
}

@Override
public Trainer updateTrainer(Trainer trainer) {
    // Check if the trainer with given id exists
    Optional<Trainer> existingTrainerOptional = trainerRepository.findById(trainer.getId());
    if (existingTrainerOptional.isPresent()) {
        // Update the existing trainer
        return trainerRepository.save(trainer);
    } else {
        // If trainer with given id does not exist, return null or throw an exception
        return null;
    }
}

@Override
public List<Trainer> findTrainersByActivity(String activity) {
    return trainerRepository.findByActivity(activity);
}

@Override
public Trainer save(Trainer trainer) {
	return trainerRepository.save(trainer);
}
	}
	


