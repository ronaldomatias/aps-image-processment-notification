package com.aps.rabbit.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.bson.types.ObjectId;

public class ObjectMapperUtil {
    private static ObjectMapper objectMapper;

    public ObjectMapperUtil() {
    }

    public static ObjectMapper getMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.registerModule((new SimpleModule("ObjectIdModule")).addSerializer(ObjectId.class, new ObjectIdJsonSerializer()));
            objectMapper.findAndRegisterModules();
        }

        return objectMapper;
    }
}
