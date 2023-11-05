package com.omvg.springboot.CompaniaABC1.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name ="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idUser", updatable = false, nullable = false)
	private UUID idUser;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email", unique = true)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="date_Created")
	private Timestamp dateCreated;

	public UUID getIdUser() {
		return idUser;
	}

	public void setIdUser(UUID idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getdateCreated() {
		return dateCreated;
	}

	public void setdateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	

}
