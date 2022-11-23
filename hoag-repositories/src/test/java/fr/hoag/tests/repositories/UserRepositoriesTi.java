package fr.hoag.tests.repositories;

import fr.hoag.repositories.UserRepository;
import fr.hoag.repositories.dto.UserDto;
import fr.hoag.repositories.types.PgInet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.net.Inet4Address;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("staging")
public class UserRepositoriesTi {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ApplicationContext context;

    @AfterEach
    public void after() {
        userRepository.deleteAll();
    }

    @Test
    public void should_save_user() throws Exception {
        UserDto user = UserDto.create()
                .login("test")
                .password("test")
                .email("test@test.com")
                .ipAddress(PgInet.of(Inet4Address.getLocalHost()))
                .createdOn(Timestamp.from(Instant.now().truncatedTo(ChronoUnit.SECONDS)))
                .lastLogin(Timestamp.from(Instant.now().truncatedTo(ChronoUnit.SECONDS)))
                .build();
        int id = userRepository.save(user).getId();
        UserDto savedUser = userRepository.findById(id);
        assertThat(savedUser).isNotNull();
        assertThat(user).isEqualTo(savedUser);
    }



}
