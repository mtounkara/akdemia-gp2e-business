package af.cmr.indyli.akdemia.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import af.cmr.indyli.akdemia.business.entity.Training;

@Repository
public interface ITrainingRepository extends JpaRepository<Training, Long> {

}
