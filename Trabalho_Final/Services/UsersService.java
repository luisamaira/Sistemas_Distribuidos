package br.luisa.GerenciamentoProjetos.Services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.luisa.GerenciamentoProjetos.Exceptions.ResourceNotFoundException;
import br.luisa.GerenciamentoProjetos.Model.Users;
import br.luisa.GerenciamentoProjetos.Repositories.UserRepository;

@Service
public class UsersService {
	
	private Logger logger = Logger.getLogger(UsersService.class.getName());
	
	@Autowired
	UserRepository repository;
	
	public 	Users findByID(Long id) {
		logger.info("Procurando um Usuário!" + id); 
		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Não há registros para esse ID"));
		
	}
	
	public List<Users> findAllUsers() {
		logger.info("Buscando Lista de Usuarios");
		return repository.findAll();
	}

	
	public Users Create (Users user) {
		logger.info("Criando uma nova entidade na base de dados");
		return repository.save(user);
	}
	
	public Users Update(Users user) {
		logger.info("Atualizando entidade na base de dados");
		
		var entity = repository.findById(user.getId()).orElseThrow(()-> new ResourceNotFoundException("Não há registros para esse ID")); 
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setResponsibility(user.getResponsibility());
		entity.setFirm(user.getFirm());
		
		return repository.save(entity);
	}
	
	public void Delete(Long id) {
		logger.info("Removendo entidade da base de dados ID..." +id);
		
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Não ha registros com esse ID"));
		
		repository.delete(entity);
	}
	
}