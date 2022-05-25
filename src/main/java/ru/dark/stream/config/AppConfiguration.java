package ru.dark.stream.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.dark.stream.rabbit.RabbitConfiguration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("ru.dark.stream")
@Import(RabbitConfiguration.class)
public class AppConfiguration {


}
