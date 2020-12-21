package fr.hoag.repositories.encryptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
@Configuration
public class EncryptionDataConverter implements AttributeConverter<String, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(EncryptionDataConverter.class);

    @Value("${hoag.encryption.password}")
    private String encryptPassword;

    @Override
    public String convertToDatabaseColumn(String data) {
        String encryptedString = "";
        try {
            encryptedString = SecureEncryption.encryptString(data, encryptPassword);
        } catch (Exception e) {
            LOGGER.error("{}", e);
        }
        return encryptedString;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        String decryptedString = "";
        try {
            decryptedString = SecureEncryption.decryptString(dbData, encryptPassword);
        } catch (Exception e) {
            LOGGER.error("{}", e);
        }
        return decryptedString;
    }


}
