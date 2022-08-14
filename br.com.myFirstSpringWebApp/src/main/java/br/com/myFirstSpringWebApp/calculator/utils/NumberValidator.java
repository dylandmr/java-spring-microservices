package br.com.myFirstSpringWebApp.calculator.utils;

import br.com.myFirstSpringWebApp.exceptions.UnsupportedMathOperationException;

public class NumberValidator {
    public static void validateInput(String... numbers) {
        for (var number : numbers)
            if (isNotNumeric(number) || isNotNumeric(number))
                throw new UnsupportedMathOperationException("Please input a valid numeric value.");
    }

    public static boolean isNotNumeric(String number) {
        if (number == null)
            return true;

        number = number.replaceAll(",", ".");

        return !number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}