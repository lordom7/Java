package com.omvg.springboot.CompaniaABC1.Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "Campaing")
public class Campaing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcampaing")
	private Integer idCampaing;
	
	
	@Column(name = "idUser")
	private String idUser;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "numberOfRecipients")
	private Integer numberOfRecipients;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "date_Created")
	private Timestamp dateCreated;
	

	public Integer getIdCampaing() {
		return idCampaing;
	}

	public void setIdCampaing(Integer idCampaing) {
		this.idCampaing = idCampaing;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getNumberOfRecipients() {
		return numberOfRecipients;
	}

	public void setNumberOfRecipients(Integer numberOfRecipients) {
		this.numberOfRecipients = numberOfRecipients;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Timestamp getdateCreated() {
		return dateCreated;
	}

	public void setdateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
}
