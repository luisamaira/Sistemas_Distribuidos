package br.luisa.GerenciamentoTarefas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.luisa.GerenciamentoTarefas.GerenciamentoService;
import br.luisa.GerenciamentoTarefas.Tarefas;

@RestController
@RequestMapping("/tarefas")
public class GerenciamentoTarefasController {
	
	@Autowired
	private GerenciamentoService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Tarefas findById(@PathVariable (value = "id") String id) throws Exception{
		return service.findByID(id);
	}
	
	@RequestMapping(method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Tarefas> findAllTarefas(){
		return service.findAllTarefas();
	}
	
	@RequestMapping(method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Tarefas create(@RequestBody Tarefas tarefa) {
		return service.Create(tarefa);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable (value = "id") String id) throws Exception{
		service.Delete(id);

	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Tarefas update(@RequestBody Tarefas tarefa) {
		return service.Update(tarefa);
	}
	
	@RequestMapping(value="/teste/{tarefa}")
	public String Teste_De_Excecoes(@PathVariable (value = "tarefa") String tarefa) throws Exception{
		
		return tarefa;
	}
	

}