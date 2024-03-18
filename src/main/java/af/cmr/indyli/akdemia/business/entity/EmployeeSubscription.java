package af.cmr.indyli.akdemia.business.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Magamba
 * This class represents an EmployeeSubscription entity. It encapsulates
 * information about the EmployeeSubscription to a IntraSession of a training.
 */
@Entity
@Table(name = "AKDEMIA_EMPLOYEE_SOUSCRIPTION")
public class EmployeeSubscription implements IEntity{

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	//--- This attribute have to decommented when the IntraSession class is created
	//---
	@ManyToOne
	private IntraSession intraSession;

	@ManyToOne
	private Employee employee;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public Date getCreationDate() {
		return creationDate;
	}
	
	@Override
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Override
	public Date getUpdateDate() {
		return updateDate;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public IntraSession getIntraSession() {
		return intraSession;
	}

	public void setIntraSession(IntraSession intraSession) {
		this.intraSession = intraSession;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
