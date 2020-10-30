package fr.hoag.repositories.encryptions;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class HashDataConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String data) {
        return new BCryptPasswordEncoder().encode(data);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData;
    }

}
