package fr.hoag.tests.repositories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "fr.hoag")
@EnableJpaRepositories(basePackages = {"fr.hoag.repositories"})
@EntityScan("fr.hoag.repositories.dto")
public class AccessingRepositoriesApplication {

    public static void main(String... args) {
        SpringApplication.run(AccessingRepositoriesApplication.class, args);
    }

}
