package com.colegio.app.entity;

import java.io.Serializable;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@SuppressWarnings("unused")
@Entity
@Table(name="users")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4249029035482822066L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//@Column(name="nombres",length = 100,nullable=false)
	@Column(name="nombres",length = 100)
	private String names;
	@Column(length = 100)
	private String surname;
	@Column(length = 100,unique=true)
	private String email;
	private boolean enabled;
	
	private String telefono;
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
