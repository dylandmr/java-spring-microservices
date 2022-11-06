package com.example.dockerwebappdemo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HelloDocker {
    private final String content;
    private final String environment;
}
