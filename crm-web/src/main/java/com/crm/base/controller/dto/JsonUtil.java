package com.crm.base.controller.dto;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    // ObjectMapper is thread-safe without re-config, according to
    // http://wiki.fasterxml.com/JacksonFAQThreadSafety
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> T toObject(InputStream stream, Class<T> clazz) {
        ResourceReader reader = null;
        try {
            StringBuilder string = new StringBuilder();
            reader = new ResourceReader(stream, "UTF-8");
            String line = null;
            reader.load();
            while ((line = reader.readLine()) != null) {
                string.append(line);
            }
            if (string.length() > 0) {
                return JSON.parseObject(string.toString(), clazz);
            }
        } catch (Exception e) {
            logger.error("Exception", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static <T> T toObject(String string, Class<T> clazz) {
        try {
            return JSON.parseObject(string, clazz);
        } catch (Exception e) {
            logger.error("Exception", e);
        }
        return null;
    }

    public static <T> String toJson(T t) {
        try {
            return JSON.toJSONString(t);
        } catch (Exception e) {
            logger.error("Exception", e);
        }
        return null;
    }

    public static <T> String writeObjectToGson(T t) {
        Gson gson = new Gson();

        return gson.toJson(t);
    }

    public static <T> Map<String, T> toMap(String jsonAsString) throws JsonGenerationException {
        try {
            return mapper.readValue(jsonAsString, new TypeReference<Map<String, T>>() {
            });
        } catch (Exception e) {
            logger.error("parse jsonString error.[" + jsonAsString + "]");
            throw new JsonGenerationException(e);
        }
    }

    public static <T> Map<String, T>[] toMapArray(String jsonAsString) throws JsonGenerationException {
        try {
            return mapper.readValue(jsonAsString, new TypeReference<Map<String, T>[]>() {
            });
        } catch (Exception e) {
            logger.error("parse jsonString error.[" + jsonAsString + "]");
            throw new JsonGenerationException(e);
        }
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    public static <T> T toList(String string, Class<?> clazzList, Class<?> clazzBean) {
        try {
            JavaType javaType = getCollectionType(clazzList, clazzBean);
            return mapper.readValue(string, javaType);
        } catch (IOException e) {
            logger.error("Exception", e);
        }
        return null;
    }
}
