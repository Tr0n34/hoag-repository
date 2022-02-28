package fr.hoag.tests.repositories;

import fr.hoag.repositories.UserRepository;
import fr.hoag.repositories.dto.UserDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.net.InetAddress;
import java.sql.Timestamp;
import java.time.Instant;

@SpringBootTest
@ActiveProfiles("dev")
public class UserRepositoriesTi {

    @Autowired
    UserRepository userRepository;

    @Test
    public void should() throws Exception {
        UserDto user = UserDto.of(1, "test", "test", "test@test.com", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), InetAddress.getLocalHost());
        userRepository.save(user);
        UserDto savedUser = userRepository.findById(1);
        Assertions.assertThat(user).isEqualTo(savedUser);
    }

}
