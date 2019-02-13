package de.inmediasp.springws.zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ZooApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZooApplication.class, args);
    }
}

