package fr.hoag.repositories.encryptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EncryptionDataConverter implements AttributeConverter<String, String> {

    private static final Logger logger = LoggerFactory.getLogger(EncryptionDataConverter.class);

    private static final String PASSWORD = "T#oT#o60";

    @Override
    public String convertToDatabaseColumn(String data) {
        try {
            return SecureEncryption.encryptString(data, PASSWORD);
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        try {
            return SecureEncryption.decryptString(dbData, PASSWORD);
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }


}
