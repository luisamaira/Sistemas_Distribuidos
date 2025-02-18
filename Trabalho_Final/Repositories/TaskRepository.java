package br.luisa.GerenciamentoProjetos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.luisa.GerenciamentoProjetos.Model.Tasks;

public interface TaskRepository extends JpaRepository<Tasks, Long> {

}
