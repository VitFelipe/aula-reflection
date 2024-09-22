package org.example.refl.Transform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.refl.exception.ParseJsonException;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TranformObjectToJson {

    public String tranform(Object object) throws ParseJsonException {
        Class<?> classObj = object.getClass();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            List<Field> fieldList = Arrays.stream(classObj.getDeclaredFields()).toList();
            Map<String, Object> maps = new HashMap<>();
            for (Field field : fieldList) {
                field.setAccessible(true);
                maps.put(field.getName(), field.get(object));
            }
            return objectMapper.writeValueAsString(maps);
        } catch (Exception e) {
            throw new ParseJsonException("Erro ao converter o Objeto da classe %s para o formato json ".formatted(classObj.getSimpleName()), e.getCause());
        }
    }

}
