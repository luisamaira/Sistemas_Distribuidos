package br.luisa.GerenciamentoProjetos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.luisa.GerenciamentoProjetos.Exceptions.UnsupportedOperationsException;
import br.luisa.GerenciamentoProjetos.Model.Tasks;
import br.luisa.GerenciamentoProjetos.Services.TasksService;
import br.luisa.GerenciamentoProjetos.Services.VerificaNumberService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TasksService service;
	
	@Autowired
	private VerificaNumberService verifica;
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Tasks findById(@PathVariable (value = "id") String id) throws Exception{
		if(!verifica.isNumeric(id)) {
			throw new UnsupportedOperationsException("ID não é Válido");
			}

			Long idBD = verifica.convertToLong(id);

			return service.findByID(idBD);
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Tasks> findAllTasks(){
		
		return service.findAllTasks();
	}
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Tasks create(@RequestBody Tasks task) { 
		return service.Create(task);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable (value = "id") String id) throws Exception{

	if(!verifica.isNumeric(id)) {
	throw new UnsupportedOperationException("Não é um ID válido");
	}

	Long idBD = verifica.convertToLong(id);

	service.Delete(idBD);
	return ResponseEntity.noContent().build();

	}
	
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Tasks update(@RequestBody Tasks task) {
		return service.Update (task);

	}
	
	

}