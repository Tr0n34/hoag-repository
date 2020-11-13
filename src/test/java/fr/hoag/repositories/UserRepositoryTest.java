package fr.hoag.repositories;


import fr.hoag.repositories.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ActiveProfiles("dev")
public class UserRepositoryTest {

    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        this.userRepository = mock(UserRepository.class);
    }

    @Test
    public void should_create_user() {
        UserDto user1 = new UserDto(1L,"devlogin1", "devpassword1", "test@test.com");
        when(userRepository.save(user1)).thenReturn(user1);
        UserDto user2 = userRepository.save(user1);
        assertThat(user1).isEqualTo(user2);
        assertThat(user2.getId()).isPositive();
    }

//    @Test
//    public void should_find_user_by_login() {
//        UserDto user1 = new UserDto(1L,"devlogin1", "devpassword1", "test@test.com");
//        when(userRepository.findByLogin("devlogin1")).thenReturn(user1);
//        UserDto user2 = userRepository.findByLogin("devlogin1");
//        assertThat(user1).isEqualTo(user2);
//        assertThat(user2.getId()).isPositive();
//    }

    @Test
    public void should_find_user_by_login_and_password() {
        UserDto user1 = new UserDto(1L,"devlogin1", "devpassword1", "test@test.com");
        when(userRepository.findByLoginAndPassword("devlogin1", "devpassword1")).thenReturn(user1);
        UserDto user2 = userRepository.findByLoginAndPassword("devlogin1", "devpassword1");
        assertThat(user1).isEqualTo(user2);
        assertThat(user2.getId()).isPositive();
    }



}
