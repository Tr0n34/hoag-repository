package fr.hoag.repositories;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("integration")
public class UserRepositoryTestIntegration {

    private static final Logger LOGGER = LoggerFactory.getLogger("UserRepositoryTestIntegration");

    @Autowired
    UserRepository userRepository;

    @Test
    void should_build_hibernate_context() {
        assertThat(true);
    }

    @Test
    void should_save_user() {

    }

    @Test
    void should_find_user_by_login() {

    }

}
