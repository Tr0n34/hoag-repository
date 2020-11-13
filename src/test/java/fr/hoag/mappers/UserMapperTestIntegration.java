package fr.hoag.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("integration")
public class UserMapperTestIntegration {

    private UserMapper userMapper;

    @Test
    void should_map_user_to_userDto() {

    }

}
