package br.luisa.GerenciamentoProjetos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.luisa.GerenciamentoProjetos.Model.Projects;

public interface ProjectRepository extends JpaRepository<Projects, Long> {

}
