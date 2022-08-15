package br.com.GreetingService.controllers;

import br.com.GreetingService.configuration.GreetingConfiguration;
import br.com.GreetingService.models.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    private final GreetingConfiguration greetingConfiguration;

    public GreetingController(GreetingConfiguration greetingConfiguration) {
        this.greetingConfiguration = greetingConfiguration;
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value= "name", defaultValue = "") String name) {

        if (name.isEmpty())
            name = greetingConfiguration.getDefaultValue();

        return new Greeting(counter.incrementAndGet(), String.format(template, greetingConfiguration.getGreeting(), name));
    }
}