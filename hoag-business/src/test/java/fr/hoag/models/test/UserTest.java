package fr.hoag.models.test;

import fr.hoag.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("dev")
public class UserTest {

    @Test
    public void shouldCreateUserWithBuilder() {
        String username = "test1";
        String password = "password1";
        LocalDateTime now = LocalDateTime.now();
        User user = User.create()
                .accountNonExpired(true)
                .username(username)
                .password(password)
                .createdOn(now)
                .build();
        assertThat(user).isNotNull();
        assertThat(user.getCreatedOn()).isEqualTo(now);
        assertThat(user.getUsername()).isEqualTo(username);
        assertThat(user.getPassword()).isEqualTo(password);
    }

    @Test
    public void shouldCreateUserWithStaticBuilder() {
        String username = "username";
        String password = "password";
        User user = User.of(username,
                password,
                "email@email.com",
                true,
                true,
                true,
                true,
                null,
                LocalDateTime.now(),
                LocalDateTime.now());
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo(username);
        assertThat(user.getPassword()).isEqualTo(password);
    }

    @Test
    public void shouldBeEqualWithSameUsername() throws IOException {
        String username = "test1";
        LocalDateTime now = LocalDateTime.now();
        User user1 = User.create()
                .accountNonExpired(true)
                .username(username)
                .password("password1")
                .createdOn(now)
                .build();
        User user2 = User.create()
                .accountNonExpired(false)
                .username(username)
                .password("password2")
                .createdOn(now)
                .build();
        assertThat(user1).isEqualTo(user2);

        BufferedReader reader = Files.newBufferedReader(Path.of(""));
        List<String> programmingLanguage = List.of("java", "python", "c++","javaScript");
        Map<String, List<String>> mapping = retrieveWritersBooksMap();

        var reader2 = Files.newBufferedReader(Path.of(""));
        var stringList2 = List.of("java", "python", "c++","javaScript");
        Map<String, List<String>> mapping2 = retrieveWritersBooksMap();


    }

}
