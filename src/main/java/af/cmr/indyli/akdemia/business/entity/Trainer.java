package af.cmr.indyli.akdemia.business.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Déclation de la classe entité TRAINER

/**
 * 
 * @author Magamba 
 *TODO Checking du mapping 
 */
@Entity
@Table(name="akdemia_trainer")
public class Trainer extends User {
	
    @Column(name = "ACTIVITY")
    private String activity;

    @Column(name = "CV_LINK")
    private String cvLink;

    @Column(name = "FIRSTNAME")
    private String firstName;
    
    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "GENDER")
    private String gender;

    @ManyToOne // Many trainers can have one validation test
    @JoinColumn(name = "ID_AKDEMIA_VALIDATION_TEST")
    private ValidationTest validationTest;


	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getCvLink() {
		return cvLink;
	}

	public void setCvLink(String cvLink) {
		this.cvLink = cvLink;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ValidationTest getValidationTest() {
		return validationTest;
	}

	public void setValidationTest(ValidationTest validationTest) {
		this.validationTest = validationTest;
	}
}






	
	
	
	
	


