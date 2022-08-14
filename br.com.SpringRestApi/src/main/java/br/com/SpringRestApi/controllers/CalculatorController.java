package br.com.SpringRestApi.controllers;

import br.com.SpringRestApi.services.CalculatorServices;
import br.com.SpringRestApi.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    private CalculatorServices calculatorService;

    public CalculatorController(CalculatorServices calculatorService) {
        this.calculatorService = calculatorService;
    }

    @RequestMapping(value="/sum/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value="firstNumber") String firstNumber,
                      @PathVariable(value="secondNumber") String secondNumber) throws UnsupportedMathOperationException {
        return calculatorService.sum(firstNumber, secondNumber);
    }

    @RequestMapping(value="/subtract/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    public Double subtract(@PathVariable(value="firstNumber") String firstNumber,
                      @PathVariable(value="secondNumber") String secondNumber) throws UnsupportedMathOperationException {
        return calculatorService.subtract(firstNumber, secondNumber);
    }

    @RequestMapping(value="/multiply/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    public Double multiply(@PathVariable(value="firstNumber") String firstNumber,
                      @PathVariable(value="secondNumber") String secondNumber) throws UnsupportedMathOperationException {
        return calculatorService.multiply(firstNumber, secondNumber);
    }

    @RequestMapping(value="/divide/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    public Double divide(@PathVariable(value="firstNumber") String firstNumber,
                      @PathVariable(value="secondNumber") String secondNumber) throws UnsupportedMathOperationException {
        return calculatorService.divide(firstNumber, secondNumber);
    }

    @RequestMapping(value="/sqrt/{number}/", method = RequestMethod.GET)
    public Double sqrt(@PathVariable(value="number") String number) throws UnsupportedMathOperationException {
        return calculatorService.sqrt(number);
    }

    @RequestMapping(value="/avg/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    public Double avg(@PathVariable(value="firstNumber") String firstNumber,
                      @PathVariable(value="secondNumber") String secondNumber) throws UnsupportedMathOperationException {
        return calculatorService.avg(firstNumber, secondNumber);
    }

}