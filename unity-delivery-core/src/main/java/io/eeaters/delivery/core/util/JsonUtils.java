package io.eeaters.delivery.core.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public interface JsonUtils {

    Logger log = LoggerFactory.getLogger(JsonUtils.class);

    ObjectMapper objectMapper = new ObjectMapper() {
        {
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            registerModule(new JavaTimeModule());
            setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        }
    };

    static String writeValueToString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            //todo
            log.warn("序列化失败，异常:{}", e.getLocalizedMessage());
            return null;
        }
    }

    static <T> T readValue(String str, Class<T> tClass) {
        try {
            return objectMapper.readValue(str, tClass);
        } catch (Exception e) {
            //todo
            return null;
        }
    }


    static <T> T readValue(String str, TypeReference<T> reference) {
        try {
            return objectMapper.readValue(str, reference);
        } catch (Exception e) {
            //todo
            System.out.println("e.getLocalizedMessage() = " + e.getLocalizedMessage());
            return null;
        }
    }

    static <T> T readValue(String content, JavaType valueType) {
        try {
            return objectMapper.readValue(content, valueType);
        } catch (Exception e) {
            //todo
            System.out.println("e.getLocalizedMessage() = " + e.getLocalizedMessage());
            return null;
        }
    }

}
