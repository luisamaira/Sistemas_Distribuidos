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
import br.luisa.GerenciamentoProjetos.Model.Users;
import br.luisa.GerenciamentoProjetos.Services.UsersService;
import br.luisa.GerenciamentoProjetos.Services.VerificaNumberService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UsersService service;
	
	@Autowired
	private VerificaNumberService verifica;
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Users findById(@PathVariable (value = "id") String id) throws Exception{
		if(!verifica.isNumeric(id)) {
			throw new UnsupportedOperationsException("ID não é Válido");
			}

			Long idBD = verifica.convertToLong(id);

			return service.findByID(idBD);
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Users> findAllUsers(){
		
		return service.findAllUsers();
	}
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Users create(@RequestBody Users user) { 
		return service.Create(user);
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
	public Users update(@RequestBody Users user) {
		return service.Update(user);

	}
	
	

}