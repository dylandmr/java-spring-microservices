package br.com.SpringRestApi.services.utils;

import org.springframework.stereotype.Service;

@Service
public class NumberConverterServices {
    private NumberValidatorServices numberValidatorServices;

    public NumberConverterServices(NumberValidatorServices numberValidatorServices) {
        this.numberValidatorServices = numberValidatorServices;
    }

    public double convertToDouble(String number) {
        numberValidatorServices.validateInput(number);

        number = number.replaceAll(",", ".");

        return Double.parseDouble(number);
    }
}
