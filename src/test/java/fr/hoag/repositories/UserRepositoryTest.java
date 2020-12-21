package fr.hoag.repositories;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@ActiveProfiles("dev")
public class UserRepositoryTest {

    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        this.userRepository = mock(UserRepository.class);
    }

    @Test
    public void should_create_user() {

    }

    @Test
    public void should_find_user_by_login() {

    }

    @Test
    public void should_find_user_by_login_and_password() {

    }



}
