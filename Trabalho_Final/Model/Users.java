package br.luisa.GerenciamentoProjetos.Model;

import java.io.Serializable;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String responsibility;
	private String firm;
	
	public Users() {
		
	} 
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public String getResponsibility() {
		return responsibility;
	}
	
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	
	public String getFirm() {
		return firm;
	}
	
	public void setFirm(String firm) {
		this.firm = firm;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, firm, id, name, responsibility);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(email, other.email) && Objects.equals(firm, other.firm) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(responsibility, other.responsibility);
	}
	
}
