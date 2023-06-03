package br.com.leo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leo.exception.UnsuportedMathOperationException;

@RestController
public class MathController {
	
	@RequestMapping(value = "sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Digite valores numericos!");
		}
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum; 
	}
	
	@RequestMapping(value = "sub/{numberOne}/{numberTwo}")
	public Double sub(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Digite valores numericos!");
		}
		Double sum = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return sum; 
	}
	
	@RequestMapping(value = "mult/{numberOne}/{numberTwo}")
	public Double mult(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Digite valores numericos!");
		}
		Double sum = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return sum; 
	}
	
	@RequestMapping(value = "div/{numberOne}/{numberTwo}")
	public Double div(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Digite valores numericos!");
		}
		Double sum = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return sum; 
	}
	
	@RequestMapping(value = "sqrt/{numberOne}")
	public Double sqrt(@PathVariable("numberOne") String numberOne) throws Exception {
		
		if(!isNumeric(numberOne)) {
			throw new UnsuportedMathOperationException("Digite valores numericos!");
		}
		Double sum = convertToDouble(numberOne);
		return Math.sqrt(sum);
	}

	private Double convertToDouble(String strNumber) {
		if(strNumber == null) {
			return 0D;
		}
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) {
			return Double.parseDouble(number);
		}
		return 1D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) {
			return false;
		}
		String number = strNumber.replace(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
