package br.luisa.GerenciamentoProjetos.Services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.luisa.GerenciamentoProjetos.Exceptions.ResourceNotFoundException;
import br.luisa.GerenciamentoProjetos.Model.Tasks;
import br.luisa.GerenciamentoProjetos.Repositories.TaskRepository;

@Service
public class TasksService {
	
	private Logger logger = Logger.getLogger(TasksService.class.getName());
	
	@Autowired
	TaskRepository repository;
	
	public 	Tasks findByID(Long id) {
		logger.info("Procurando uma tarefa!" + id); 
		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Não há registros para esse ID"));
		
	}
	
	public List<Tasks> findAllTasks() {
		logger.info("Buscando Lista de Tarefas");
		return repository.findAll();
	}

	
	public Tasks Create (Tasks task) {
		logger.info("Criando uma nova entidade na base de dados");
		return repository.save(task);
	}
	
	public Tasks Update(Tasks task) {
		logger.info("Atualizando entidade na base de dados");
		
		var entity = repository.findById(task.getId()).orElseThrow(()-> new ResourceNotFoundException("Não há registros para esse ID")); 
		entity.setTitle(task.getTitle());
		entity.setStart_date(task.getStart_date());
		entity.setEnd_date(task.getEnd_date());
		entity.setStatus(task.getStatus());
		entity.setHours(task.getHours());
		entity.setProject_id(task.getProject_id());
		entity.setUser_id(task.getUser_id());
		
		return repository.save(entity);
	}
	
	public void Delete(Long id) {
		logger.info("Removendo entidade da base de dados ID..." +id);
		
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Não ha registros com esse ID"));
		
		repository.delete(entity);
	}
	
}

