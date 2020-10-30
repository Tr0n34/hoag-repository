package fr.hoag.repositories;

import fr.hoag.repositories.encryptions.EncryptionDataConverter;
import fr.hoag.repositories.encryptions.HashDataConverter;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("integration")
public class DataConverterTestIntegration {

    @Test
    void should_encrypt_and_decrypt_password() {
        EncryptionDataConverter converter = new EncryptionDataConverter();
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
