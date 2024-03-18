package af.cmr.indyli.akdemia.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import af.cmr.indyli.akdemia.business.entity.Trainer;

@Service
public interface ITrainerService {
	public Trainer createTrainer(Trainer trainer);
    public List<Trainer> findAllTrainers();
    public Trainer getTrainerById(int id);
    public void deleteTrainerById(int id);
    public Trainer updateTrainer(Trainer trainer);
    public List<Trainer> findTrainersByActivity(String activity);
	public Trainer save(Trainer trainer);
    }
