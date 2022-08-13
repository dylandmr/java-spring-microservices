package br.com.myFirstSpringWebApp;

import br.com.myFirstSpringWebApp.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @RequestMapping(value="/sum/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value="firstNumber") String firstNumber,
                      @PathVariable(value="secondNumber") String secondNumber) throws UnsupportedMathOperationException {
        if (!isNumeric(firstNumber) || !isNumeric(secondNumber))
            throw new UnsupportedMathOperationException("Please input a valid numeric value.");

        return convertToDouble(firstNumber) + convertToDouble(secondNumber);
    }

    private double convertToDouble(String number) {
        if (number == null)
            return 0D;

        number = number.replaceAll(",", ".");

        if (isNumeric(number))
            return Double.parseDouble(number);

        return 0D;
    }

    private boolean isNumeric(String number) {
        if (number == null)
            return false;

        number = number.replaceAll(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}