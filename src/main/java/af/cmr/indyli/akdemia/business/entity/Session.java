package af.cmr.indyli.akdemia.business.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "akdemia_session")
@Inheritance(strategy = InheritanceType.JOINED)
public class Session {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "DURATION")
    private Long duration;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "LACATION")
    private String location;

    @Column(name = "SESSION_SCORE")
    private Integer sessionScore;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;
    
    
//  A implémenter quand les table seront crée 

  
 @ManyToOne(fetch = FetchType.LAZY)
@JsonIgnore
@JoinColumn(name = "ID_AKDEMIA_TRAINER")
private Trainer trainer;

@ManyToOne(fetch = FetchType.LAZY)
@JsonIgnore@JoinColumn(name = "ID_AKDEMIA_TRAINING")
 private Training training;



//getters et setter
 
// public Training getTraining() {
//		return training;
//	}
//
//	public void setTraining(Training training) {
//		this.training = training;
//	}
	     

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public Long getDuration() {
	return duration;
}

public void setDuration(Long duration) {
	this.duration = duration;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public Integer getSessionScore() {
	return sessionScore;
}

public void setSessionScore(Integer sessionScore) {
	this.sessionScore = sessionScore;
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

public Trainer getTrainer() {
	return trainer;
}

public void setTrainer(Trainer trainer) {
	this.trainer = trainer;
}

  
    
}
