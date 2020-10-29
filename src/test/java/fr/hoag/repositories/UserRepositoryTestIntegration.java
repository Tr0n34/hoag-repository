package fr.hoag.repositories;

import fr.hoag.repositories.dto.UserDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("integration")
public class UserRepositoryTestIntegration {

    @Autowired
    UserRepository userRepository;

    @Test
    void should_build_hibernate_context() {

    }

    @Test
    void should_save_user() {
        UserDto user = new UserDto("test01", "test01password", "test@test.com");
        UserDto userSaved = this.userRepository.save(user);
        assertThat(user).isEqualToComparingOnlyGivenFields(userSaved, "login", "password", "email");
    }
}
