package br.luisa.GerenciamentoTarefas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class GerenciamentoService {
	
	private final AtomicLong counter = new AtomicLong();
	
	private Logger logger = Logger.getLogger(GerenciamentoService.class.getName());
	
	public Tarefas findByID(String id) {
		logger.info("Procurando uma tarefa!" + id);
		Tarefas tarefa = new Tarefas();
		tarefa.setId(counter.incrementAndGet()); 
		tarefa.setTarefas("Tarefa MOCK");
		return tarefa;
		
	}
	
	public List<Tarefas> findAllTarefas() {

		List<Tarefas> tarefas = new ArrayList<>();

		logger.info("Buscando Lista de Tarefas!");

		for(int i=0; i<10;i++) {
		Tarefas tarefa = mockTarefas(i);
		tarefas.add(tarefa);
		}
		
		return tarefas;
	}
	
	public Tarefas mockTarefas(int i) {
		Tarefas tarefa = new Tarefas();
		
		tarefa.setId(counter.incrementAndGet());
		tarefa.setTarefas("Tarefa MOCK" +i);
		return tarefa;
	}
	
	public Tarefas Create (Tarefas tarefa) {
		logger.info("Criando uma nova entidade na base de dados");
		return tarefa;
	}
	
	public Tarefas Update(Tarefas tarefa) {
		logger.info("Atualizando entidade na base de dados");
		
		return tarefa;
	}
	
	public void Delete(String id) {
		logger.info("Removendo entidade da base de dados ID..." +id);
		
	}
	
}
