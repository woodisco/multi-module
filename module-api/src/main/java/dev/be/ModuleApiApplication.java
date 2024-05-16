package dev.be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "dev.be.moduleapi", "dev.be.modulecommon" })
public class ModuleApiApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(ModuleApiApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}