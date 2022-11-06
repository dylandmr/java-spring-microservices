package com.example.dockerwebappdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {
    Logger logger = LoggerFactory.getLogger(DockerController.class);

    @RequestMapping("/hello-docker")
    public HelloDocker greeting() {
        logger.info("Endpoint hello-docker was called.");

        final var hostname = System.getenv("HOSTNAME");

        return HelloDocker.builder()
                .content("Hello docker")
                .environment(hostname)
                .build();
    }
}
