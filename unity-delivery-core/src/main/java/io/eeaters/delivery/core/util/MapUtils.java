package io.eeaters.delivery.core.util;

import java.util.HashMap;
import java.util.Map;

public interface MapUtils {


    static Map<String, Object> initSingleEntryMap(String key, Object value) {
        Map<String, Object> result = new HashMap<>();
        result.put(key, value);
        return result;
    }

    static Map<String, Object> initDoubleEntryMap(String key1, Object value1, String key2, Object value2) {
        Map<String, Object> result = new HashMap<>();
        result.put(key1, value1);
        result.put(key2, value2);
        return result;
    }
}
