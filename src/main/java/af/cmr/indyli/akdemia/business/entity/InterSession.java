package af.cmr.indyli.akdemia.business.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;


 
 
/**
 * @author Remi
 * Declaration de l'entité InterSession
 * La classe herite de la table Session 
 * On spécifie la clé primaire de la table hériter qui remplace
 *  cette de la table actuelle
 */
@Entity
@Table(name = "akdemia_inter_session")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
public class InterSession extends Session {
	


    private Integer MIN_PARTICIPANTS;
       

	public Integer getMinParticipants() {
		return MIN_PARTICIPANTS;
	}

	public void setMinParticipants(Integer minParticipants) {
		this.MIN_PARTICIPANTS = minParticipants;
	}

}
