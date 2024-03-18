package af.cmr.indyli.akdemia.business.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.jms.JmsProperties.Listener.Session;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * 
 * @author Magamba
 * Mapping de l'entité "{@link IntraSession}
 * 
 */
@Entity
@Table(name = "akdemia_intra_session")
// --- IntraSession doit hérité de Session. L'héritage doit être ajouté après la création de la classe
// --- Session
public class IntraSession extends Session {

	//---
	//---Les attributs et leurs mapping vers les colonnes de la table "akdemia_intra_session".
	//---
	@Id
	@JoinColumn(name = "ID", referencedColumnName = "ID", table = "akdemia_session")
	private Integer id;
    
    @OneToMany(mappedBy = "intraSession", fetch = FetchType.LAZY)
    private List<EmployeeSubscription> emplSub = new ArrayList<>();

    //--- GETTERS / SETTERS
	public Integer getID() {
		return id;
	}

	public void setID(Integer iD) {
		id = iD;
	}

	public List<EmployeeSubscription> getEmplSub() {
		return emplSub;
	}

	public void setEmplSub(List<EmployeeSubscription> emplSub) {
		this.emplSub = emplSub;
	}
}
