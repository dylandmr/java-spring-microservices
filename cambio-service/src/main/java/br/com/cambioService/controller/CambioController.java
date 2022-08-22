package br.com.cambioService.controller;

import br.com.cambioService.models.Cambio;
import br.com.cambioService.repository.CambioRepository;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("cambio-service")
public class CambioController {
    private final Environment environment;
    private final CambioRepository cambioRepository;

    public CambioController(Environment environment, CambioRepository cambioRepository) {
        this.environment = environment;
        this.cambioRepository = cambioRepository;
    }

    @GetMapping("/{amount}/{from}/{to}")
    public Cambio getCambio(
            @PathVariable("amount") BigDecimal amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to) {
        var cambio = cambioRepository.findByFromAndTo(from, to);

        if (cambio == null) {
            throw new RuntimeException("Unsupported currency.");
        }

        var currentPort = environment.getProperty("local.server.port");

        cambio.setEnvironment(currentPort);

        var conversionFactor = cambio.getConversionFactor();

        var convertedValue = conversionFactor.multiply(amount);

        cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));

        return cambio;
    }
}
