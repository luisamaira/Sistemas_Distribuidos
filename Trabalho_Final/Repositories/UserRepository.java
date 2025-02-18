package br.luisa.GerenciamentoProjetos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.luisa.GerenciamentoProjetos.Model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
