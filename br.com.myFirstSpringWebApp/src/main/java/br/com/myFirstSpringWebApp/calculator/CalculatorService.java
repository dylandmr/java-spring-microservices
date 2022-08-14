package br.com.myFirstSpringWebApp.calculator;

import static br.com.myFirstSpringWebApp.calculator.utils.NumberConverter.convertToDouble;

public class CalculatorService {
    public Double sum(String firstNumber, String secondNumber) {
        return convertToDouble(firstNumber) + convertToDouble(secondNumber);
    }

    public Double subtract(String firstNumber, String secondNumber) {
        return convertToDouble(firstNumber) - convertToDouble(secondNumber);
    }

    public Double multiply(String firstNumber, String secondNumber) {
        return convertToDouble(firstNumber) * convertToDouble(secondNumber);
    }

    public Double divide(String firstNumber, String secondNumber) {
        return convertToDouble(firstNumber) / convertToDouble(secondNumber);
    }

    public Double sqrt(String number) {
        return Math.sqrt(convertToDouble(number));
    }

    public Double avg(String firstNumber, String secondNumber) {
        return (convertToDouble(firstNumber) + convertToDouble(secondNumber)) / 2;
    }
}
