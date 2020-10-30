package fr.hoag.repositories;

import fr.hoag.repositories.encryptions.EncryptionDataConverter;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("integration")
public class EncryptionConverterTestIntegration {

    @Test
    void should_encrypt_and_decrypt_password() {
        EncryptionDataConverter converter = new EncryptionDataConverter();
        String password = "T#oT#o96";
        String encryptedPassword = converter.convertToDatabaseColumn(password);
        String decryptedPassword = converter.convertToEntityAttribute(encryptedPassword);
        assertThat(password).isEqualTo(decryptedPassword);
    }

}
