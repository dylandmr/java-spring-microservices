package br.com.myFirstSpringWebApp.calculator.utils;

public class NumberConverter {
    public static double convertToDouble(String number) {
        NumberValidator.validateInput(number);

        number = number.replaceAll(",", ".");

        return Double.parseDouble(number);
    }
}
