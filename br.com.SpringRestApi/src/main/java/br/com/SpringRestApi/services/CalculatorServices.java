package br.com.SpringRestApi.services;

import br.com.SpringRestApi.services.utils.NumberConverterServices;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServices {
    private NumberConverterServices numberConverterServices;

    public CalculatorServices(NumberConverterServices numberConverterServices) {
        this.numberConverterServices = numberConverterServices;
    }

    public Double sum(String firstNumber, String secondNumber) {
        return numberConverterServices.convertToDouble(firstNumber) + numberConverterServices.convertToDouble(secondNumber);
    }

    public Double subtract(String firstNumber, String secondNumber) {
        return numberConverterServices.convertToDouble(firstNumber) - numberConverterServices.convertToDouble(secondNumber);
    }

    public Double multiply(String firstNumber, String secondNumber) {
        return numberConverterServices.convertToDouble(firstNumber) * numberConverterServices.convertToDouble(secondNumber);
    }

    public Double divide(String firstNumber, String secondNumber) {
        return numberConverterServices.convertToDouble(firstNumber) / numberConverterServices.convertToDouble(secondNumber);
    }

    public Double sqrt(String number) {
        return Math.sqrt(numberConverterServices.convertToDouble(number));
    }

    public Double avg(String firstNumber, String secondNumber) {
        return (numberConverterServices.convertToDouble(firstNumber) + numberConverterServices.convertToDouble(secondNumber)) / 2;
    }
}
