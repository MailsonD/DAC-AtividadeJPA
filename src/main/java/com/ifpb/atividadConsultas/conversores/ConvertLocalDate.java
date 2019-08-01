package com.ifpb.atividadConsultas.conversores;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.sql.Date;

@Converter(autoApply = false)
public class ConvertLocalDate implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        if (attribute == null) {
            return null;
        }
        return Date.valueOf(attribute);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        if (dbData == null) {
            return null;
        }

        return dbData.toLocalDate();
    }

}