package io.eeaters.delivery.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface CollectionUtils {

    static <T> List<T> ofList(T... ts) {
        return new ArrayList<>(Arrays.asList(ts));
    }

}
