package br.com.leo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leo.exception.UnsuportedMathOperationException;
import br.com.leo.math.SimpleMath;
import br.com.leo.request.TesteRequest;
import br.com.leo.response.TesteResponse;

@RestController
public class MathController {
	
	SimpleMath math = new SimpleMath();
	
	@RequestMapping(value = "sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Digite valores numericos!");
		}
		return math.sumOperation(convertToDouble(numberOne), convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "sub/{numberOne}/{numberTwo}")
	public Double sub(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Digite valores numericos!");
		}
		return math.subOperation(convertToDouble(numberOne), convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "mult/{numberOne}/{numberTwo}")
	public Double mult(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Digite valores numericos!");
		}
		return math.multOperation(convertToDouble(numberOne), convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "div/{numberOne}/{numberTwo}")
	public Double div(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Digite valores numericos!");
		}
		return math.divOperation(convertToDouble(numberOne), convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "sqrt/{numberOne}")
	public Double sqrt(@PathVariable("numberOne") String numberOne) throws Exception {
		
		if(!isNumeric(numberOne)) {
			throw new UnsuportedMathOperationException("Digite valores numericos!");
		}
		return math.sqrtOperation(convertToDouble(numberOne));
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
	
    @PostMapping(value = "teste", produces = "application/json", consumes = "application/json")
	public TesteResponse buscarGeUnidades(
			@RequestBody TesteRequest req) {
    	TesteResponse response = new TesteResponse();
    	response.setTesteresp(req.getTeste());
				return response;
		
	}

}
