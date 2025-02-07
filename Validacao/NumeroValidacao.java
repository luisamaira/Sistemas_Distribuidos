package br.luisa.Validacao;

public class NumeroValidacao {

    public static void validarCPF(String cpf) {
        if (cpf.contains(".") || cpf.contains(",")) {
            throw new FormatoInvalidoException("O CPF não pode conter pontos ou vírgulas.");
        }
        if (!cpf.matches("\\d{11}")) {
            throw new UnsupportedValidacaoException("CPF inválido. Deve conter exatamente 11 dígitos numéricos.");
        }
    }

    public static void validarCNPJ(String cnpj) {
        if (cnpj.contains(".") || cnpj.contains(",")) {
            throw new FormatoInvalidoException("O CNPJ não pode conter pontos ou vírgulas.");
        }
        if (!cnpj.matches("\\d{14}")) {
            throw new UnsupportedValidacaoException("CNPJ inválido. Deve conter exatamente 14 dígitos numéricos.");
        }
    }
}
