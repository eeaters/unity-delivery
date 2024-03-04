package io.eeaters.delivery.core.util;

import java.util.function.Consumer;
import java.util.function.Function;

public interface AssertHandler {

    public static <T, R> void ifPresent(T value, Consumer<T> consumer) {
        if (value != null) {
            consumer.accept(value);
        }
    }
}
