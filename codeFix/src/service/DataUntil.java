package service;

import java.util.Collection;

public class DataUntil<T> {
    public static <T> boolean isEmptyCollection(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }
}
