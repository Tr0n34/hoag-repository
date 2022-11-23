import fr.hoag.repositories.encryptions.EncryptionDataConverter;
import fr.hoag.repositories.encryptions.HashDataConverter;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@Profile("staging")
public class DataConverterTest {

    @Test
    void should_encrypt_and_decrypt_password() {
        EncryptionDataConverter converter = new EncryptionDataConverter("jep0_824NJKDZ8Y2492J4NLKJFDZE98");
        String password = "T#oT#o96";
        String encryptedPassword = converter.convertToDatabaseColumn(password);
        String decryptedPassword = converter.convertToEntityAttribute(encryptedPassword);
        assertThat(password).isEqualTo(decryptedPassword);
    }

    @Test
    void should_hash_password() {
        HashDataConverter converter = new HashDataConverter();
        String password = "T#oT#o37";
        String hashPassword = converter.convertToDatabaseColumn(password);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        assertThat(encoder.matches(password, hashPassword)).isTrue();
    }

}
