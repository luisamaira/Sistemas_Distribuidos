package br.luisa.GerenciamentoTarefas;

import java.io.Serializable;
import java.util.Objects;

public class Tarefas implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String tarefas;
	
	public Tarefas() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTarefas() {
		return tarefas;
	}

	public void setTarefas(String tarefas) {
		this.tarefas = tarefas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tarefas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefas other = (Tarefas) obj;
		return Objects.equals(id, other.id) && Objects.equals(tarefas, other.tarefas);
	}
	
	
}