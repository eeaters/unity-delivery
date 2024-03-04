package io.eeaters.delivery.core.util;

import java.util.*;

public interface ServiceLoaderUtils {

    static <T> List<T> loadSPI(Class<T> tClass) {
        return loadSPI(tClass, Thread.currentThread().getContextClassLoader());
    }

    static <T> List<T> loadSPI(Class<T> tClass, ClassLoader classLoader) {
        List<T> result = new ArrayList<>();

        ServiceLoader<T> serviceLoader = ServiceLoader.load(tClass, classLoader);
        Iterator<T> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }

    static <T> Optional<T> loadFirstSPI(Class<T> tClass) {
        return loadFirstSPI(tClass, Thread.currentThread().getContextClassLoader());
    }
    static <T> Optional<T> loadFirstSPI(Class<T> tClass, ClassLoader classLoader) {
        ServiceLoader<T> serviceLoader = ServiceLoader.load(tClass, classLoader);
        for (T t : serviceLoader) {
            return Optional.of(t);
        }
        return Optional.empty();
    }





}
