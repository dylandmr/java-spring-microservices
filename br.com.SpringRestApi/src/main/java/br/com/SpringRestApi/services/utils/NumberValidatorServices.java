package br.com.SpringRestApi.services.utils;

import br.com.SpringRestApi.exceptions.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class NumberValidatorServices {
    public void validateInput(String... numbers) {
        for (var number : numbers)
            if (isNotNumeric(number) || isNotNumeric(number))
                throw new UnsupportedMathOperationException("Please input a valid numeric value.");
    }

    public boolean isNotNumeric(String number) {
        if (number == null)
            return true;

        number = number.replaceAll(",", ".");

        return !number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}