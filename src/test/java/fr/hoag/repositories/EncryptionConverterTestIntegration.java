package fr.hoag.repositories;

import fr.hoag.repositories.encryptions.EncryptionConverter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("integration")
public class EncryptionConverterTestIntegration {

    @Test
    void should_encrypt_id() {
        EncryptionConverter converter = new EncryptionConverter();
        Integer id = 1;
        Integer encryptedId = converter.convertToDatabaseColumn(id);
        Integer decryptedId = converter.convertToEntityAttribute(encryptedId);
        assertThat(id).isEqualTo(decryptedId);
    }
}
