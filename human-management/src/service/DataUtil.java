package service;

import java.util.Collection;

/**
 * @param <T>
 */
public class DataUtil<T> {

    public static <T> boolean isEmptyCollection(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

}
