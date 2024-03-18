package af.cmr.indyli.akdemia.business.dto.basic;

import java.util.Date;

import af.cmr.indyli.akdemia.business.dto.IDTO;
import af.cmr.indyli.akdemia.business.entity.Evaluation;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

/**
 * @author Magamba
 * This class represents a basic Data Transfer Object (DTO) for a
 * {@link EmployeeSubscription} entity.
 */
public class EmployeeSubscriptionBasicDTO implements IDTO {

	// --------------- ATTRIBUTES ---------------//
	private Integer id;
	private String status;
	private Date creationDate;
	private Date updateDate;

	// --------------- CONSTRUCTOR ---------------//
	public EmployeeSubscriptionBasicDTO() {
		super();
	}

	// --------------- GETTERS/SETTERS ------------//
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
