package com.globant.student.infraestructure.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
@Slf4j
public class JsonMapper {
    private final ObjectMapper jsonMapper = new ObjectMapper();

    public Map<String,Object> convertStringToMap(String jsonValue) {
        TypeReference<HashMap<String, Object>> typeRef
                = new TypeReference<>() {};

        try {
            return jsonMapper.readValue(jsonValue,typeRef);
        } catch (JsonProcessingException e) {
            log.error("Error al convertir un string a map", e);
            return null;
        }
    }
}
