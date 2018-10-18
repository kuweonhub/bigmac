package org.unkongress.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = [
        "org.unkongress.bigmac.dao",
        "org.unkongress.bigmac.service",
        "org.unkongress.bigmac.service.converter"
])

public class BicMacApp {

    public BicMacApp() {
    }

    public static void main(String[] args) {
        SpringApplication.run(BicMacApp.class, args);
    }
}
