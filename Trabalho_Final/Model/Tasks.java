package br.luisa.GerenciamentoProjetos.Model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Tasks implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	   
	private String title;
	private Date start_date;
	private Date end_date;
	private String status;
	private LocalTime hours;
	private Projects project_id;
	private Users user_id;
	
	public Tasks() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getStart_date() {
		return start_date;
	}


	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}


	public Date getEnd_date() {
		return end_date;
	}


	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public LocalTime getHours() {
		return hours;
	}


	public void setHours(LocalTime hours) {
		this.hours = hours;
	}


	public Projects getProject_id() {
		return project_id;
	}


	public void setProject_id(Projects project_id) {
		this.project_id = project_id;
	}


	public Users getUser_id() {
		return user_id;
	}


	public void setUser_id(Users user_id) {
		this.user_id = user_id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(end_date, hours, id, project_id, start_date, status, title);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tasks other = (Tasks) obj;
		return Objects.equals(end_date, other.end_date) && Objects.equals(hours, other.hours)
				&& Objects.equals(id, other.id) && Objects.equals(project_id, other.project_id)
				&& Objects.equals(start_date, other.start_date) && Objects.equals(status, other.status)
				&& Objects.equals(title, other.title);
	}
	
	
}
