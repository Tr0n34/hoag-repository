package fr.hoag.repositories.encryptions;

import javax.persistence.AttributeConverter;

public class HashDataConverter implements AttributeConverter<String, String> {


    @Override
    public String convertToDatabaseColumn(String attribute) {
        return null;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return null;
    }

}
