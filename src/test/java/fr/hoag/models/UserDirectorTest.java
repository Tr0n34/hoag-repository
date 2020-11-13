package fr.hoag.models;

import fr.hoag.models.users.User;
import fr.hoag.models.users.PreferencesBuilder;
import fr.hoag.models.users.ProfileBuilder;
import fr.hoag.models.users.UserBuilder;
import fr.hoag.models.users.UserDirector;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDirectorTest {

    @Test
    void should_create_user() throws UnknownHostException {
        LocalDateTime now = LocalDateTime.now();
        UserBuilder userBuilder = UserBuilder.create()
                .withUsername("devtest1")
                .withPassword("passwordev1");
        ProfileBuilder profileBuilder = new ProfileBuilder()
                .withAdress(null)
                .withAvatar(null)
                .withBirthday(LocalDateTime.of(1980, 9, 5, 11, 40))
                .withCreationDate(now.minusYears(1))
                .withLastConnectionAdress(InetAddress.getLocalHost())
                .withEmail("test@test.com")
                .withLastConnectionDate(now.minusMonths(1))
                .withName("LETTERON")
                .withSurname("NICOLAS");
        PreferencesBuilder preferencesBuilder = new PreferencesBuilder()
                .withPropertie("entry1", true)
                .withPropertie("entry2", 8);
        User builtUser = new UserDirector(userBuilder, preferencesBuilder, profileBuilder).build();
        assertThat(builtUser.getUsername()).isEqualTo("devtest1");
        assertThat(builtUser.getPreferences().getProperties()).containsEntry("entry1", true);
    }

}
