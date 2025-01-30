package br.luisa.Calculadora;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

	@RequestMapping(value="/soma/n1={n1}/n2={n2}", method=RequestMethod.GET)
	public double soma(
			@PathVariable(value="n1")String n1,
			@PathVariable (value="n2")String n2) throws Exception{
		if((!isNumeric(n1))||((!isNumeric(n2)))) {
			throw new Exception();
		}
		return(convertToDouble(n1)+convertToDouble(n2));
	}
	
	@RequestMapping(value="/subtracao/n1={n1}/n2={n2}", method=RequestMethod.GET)
	public double subtracao(
			@PathVariable(value="n1") String n1, 
			@PathVariable(value="n2") String n2) throws Exception{
		if((!isNumeric(n1))||(!isNumeric(n2))) {
			throw new Exception();
		}
		return(convertToDouble(n1)-convertToDouble(n2));
	}
	
	@RequestMapping(value="/multiplicacao/n1={n1}/n2={n2}", method=RequestMethod.GET)
	public double multiplicacao(
			@PathVariable(value="n1")String n1,
			@PathVariable(value="n2")String n2) throws Exception{
		if((!isNumeric(n1))||(!isNumeric(n2))) {
			throw new Exception();
		}
		return(convertToDouble(n1)*convertToDouble(n2));
	}
	
	@RequestMapping(value="/divisao/n1={n1}/n2={n2}", method=RequestMethod.GET)
	public double divisao(
			@PathVariable(value="n1")String n1,
			@PathVariable(value="n2")String n2) throws Exception{
		if((!isNumeric(n1))||(!isNumeric(n2))) {
			throw new Exception();
		}
		return(convertToDouble(n1)/convertToDouble(n2));
	}
	
	@RequestMapping(value="/radiciacao/n1={n1}", method=RequestMethod.GET)
	public double radiciacao(
			@PathVariable(value="n1")String n1) throws Exception{
		if((!isNumeric(n1))) {
			throw new Exception();
		}
		return Math.sqrt(convertToDouble(n1));
	}
	
	@RequestMapping(value="/exponenciacao/base={base}/expoente={expoente}", method=RequestMethod.GET)
	public double exponenciacao(
			@PathVariable(value="base")String base,
			@PathVariable(value="expoente")String expoente) throws Exception{
		if((!isNumeric(base))||(!isNumeric(expoente))) {
			throw new Exception();
		}
		return Math.pow(convertToDouble(base), convertToDouble(expoente));
	}
	
	@RequestMapping(value="/inverso/n1={n1}", method=RequestMethod.GET)
	public double inverso(
			@PathVariable(value="n1")String n1) throws Exception{
		if(!isNumeric(n1)) {
			throw new Exception();
		}
		double numero = convertToDouble(n1);
        if (numero == 0) throw new ArithmeticException("Não é possível calcular o inverso de zero.");
        return 1 / numero;
}
	
	@RequestMapping(value="/modulo/n1={n1}", method=RequestMethod.GET)
	public double modulo(
			@PathVariable(value="n1")String n1) throws Exception{
		if((!isNumeric(n1))) {
			throw new Exception();
		}
		return Math.abs(convertToDouble(n1));
	}
	
	@RequestMapping(value="/fatorial/n1={n1}", method=RequestMethod.GET)
	public long fatorial(
			@PathVariable(value="n1")String n1) throws Exception{
	    if (!isNumeric(n1)) {
	        throw new Exception();
	    }

	    int numero = (int) convertToDouble(n1);

	    if (numero < 0) {
	        throw new Exception();
	    }

	    long resultado = 1;
	    for (int i = 2; i <= numero; i++) {
	        resultado *= i;
	    }

	    return resultado;
	}
	
	@RequestMapping(value="/media/{n1}/{n2}/{n3}/{n4}/{n5}", method=RequestMethod.GET)
	public double media(
			@PathVariable(value="n1")String n1, 
			@PathVariable(value="n2")String n2,
			@PathVariable(value="n3")String n3,
			@PathVariable(value="n4")String n4,
			@PathVariable(value="n5")String n5) throws Exception{
		if(!isNumeric(n1)||!isNumeric(n2)||!isNumeric(n3)||!isNumeric(n4)||!isNumeric(n5)) {
			throw new Exception();
		}
		return (convertToDouble(n1) + convertToDouble(n2) + convertToDouble(n3) + convertToDouble(n4) + convertToDouble(n5)) / 5;
	}
	
	@RequestMapping(value="/mediana/{n1}/{n2}/{n3}/{n4}/{n5}", method=RequestMethod.GET)
	public double mediana(
			@PathVariable(value="n1")String n1, 
			@PathVariable(value="n2")String n2,
			@PathVariable(value="n3")String n3,
			@PathVariable(value="n4")String n4,
			@PathVariable(value="n5")String n5) throws Exception{
		if(!isNumeric(n1)||!isNumeric(n2)||!isNumeric(n3)||!isNumeric(n4)||!isNumeric(n5)) {
			throw new Exception();
		}
		double[] numeros = {convertToDouble(n1), convertToDouble(n2), convertToDouble(n3), convertToDouble(n4), convertToDouble(n5)};
        java.util.Arrays.sort(numeros);
        return numeros[2];
	}
	
	
	private double convertToDouble(String strNumber) throws Exception{
		if(strNumber == null) throw new Exception();
		
		String number = strNumber.replaceAll(",", ".");
		
		if(isNumeric(number)) return (Double.parseDouble(number));
		else throw new Exception();
		
	}
	
	private boolean isNumeric(String strNumber) {
		if(strNumber == null) {
			return false;
		}
		String number = strNumber.replaceAll(",", ".");
		
		return(number.matches("[-+]?[0-9]*\\.?[0-9]*"));
	}
	
}
