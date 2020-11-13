package fr.hoag.repositories;

import fr.hoag.repositories.dto.UserDto;
import org.assertj.core.api.Assertions;
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

    }

    @Test
    void should_save_user() {
        UserDto user = new UserDto("test01", "test01password", "test@test.com");
        UserDto userSaved = this.userRepository.save(user);
        assertThat(userSaved)
                .isNotNull()
                .isEqualToComparingOnlyGivenFields(userSaved, "login", "password", "email");
    }

    @Test
    void should_find_user_by_login() {
        UserDto userSaved = new UserDto("test01", "test01password", "test@test.com");
        this.userRepository.save(userSaved);
        LOGGER.debug("{}", this.userRepository.findByLogin("test01"));
//        assertThat(userFound)
//                .isNotNull()
//                .isEqualToComparingOnlyGivenFields(userSaved, "login", "password", "email");
    }

}
