package br.luisa.PronomeTratamento;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PronomeController {
	
	@RequestMapping(value="/pronome/usuario={usuario}&sobrenome={sobrenome}&tratamento={tratamento}")
	public String pronome(
			@PathVariable(value="usuario")String usuario,
			@PathVariable(value="sobrenome")String sobrenome,
			@PathVariable(value="tratamento")String tratamento) {
		
		String sobrenomeUsuario = sobrenome.isEmpty() ? "" : sobrenome;
		String nomeUsuario = usuario.isEmpty() ? "" : usuario;
		String tratamentoUsuario = tratamento.isEmpty() ? "" : tratamento;
		
		return tratamentoUsuario + "; " + sobrenomeUsuario + ", " + nomeUsuario;
		
	}

	

}
