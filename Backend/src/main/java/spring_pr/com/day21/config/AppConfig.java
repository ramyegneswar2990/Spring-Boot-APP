package spring_pr.com.day21.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Car car() {
        return new Car("Toyota", "Camry", 2020);
    }
}