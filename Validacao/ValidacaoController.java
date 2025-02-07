package br.luisa.Validacao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validacao")
public class ValidacaoController {

    @GetMapping("/CPF/{numero_CPF}")
    public String validacaoCPF(@PathVariable("numero_CPF") String numeroCPF) {
        NumeroValidacao.validarCPF(numeroCPF);
        return numeroCPF + " - CPF VALIDADO!";
    }

    @GetMapping("/CNPJ/{numero_CNPJ}")
    public String validacaoCNPJ(@PathVariable("numero_CNPJ") String numeroCNPJ) {
        NumeroValidacao.validarCNPJ(numeroCNPJ);
        return numeroCNPJ + " - CNPJ VALIDADO!";
    }
}
