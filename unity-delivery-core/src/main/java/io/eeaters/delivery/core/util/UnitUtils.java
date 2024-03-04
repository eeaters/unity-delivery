package io.eeaters.delivery.core.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public interface UnitUtils {

    static Double fenToYuan(Integer fen) {
        return (double) fen / 100;
    }

    static Integer yuanToFen(Double yuan) {
        return (int) (yuan * 100);
    }

    static Double gToKg(Integer g) {
        return (double) g / 1000;
    }

    static LocalDateTime secondToLocalDateTime(Integer second) {
        return secondToLocalDateTime(Long.valueOf(second));
    }

    static LocalDateTime secondToLocalDateTime(Long second) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(second), ZoneId.systemDefault());
    }

    static Integer localDateTimeToSecond(LocalDateTime localDateTime) {
        return Math.toIntExact(localDateTime.toEpochSecond(ZoneOffset.of("+8")));
    }
}
