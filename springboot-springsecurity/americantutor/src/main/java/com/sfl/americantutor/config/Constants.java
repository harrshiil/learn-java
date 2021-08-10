package com.sfl.americantutor.config;


import java.util.Collections;
import java.util.function.Supplier;

/**
 * Application constants.
 */
public final class Constants {


    /**
     * Null Guards
     */
    public static <T> T listNullGuard(Supplier<T> supplier) {
        try {
            supplier.get().toString();
            return supplier.get();
        } catch (@SuppressWarnings("unused") NullPointerException ignored) {
            return (T) Collections.emptyList();
        }
    }

    public static <T> T booleanNullGuard(Supplier<T> supplier) {
        try {
            supplier.get().toString();
            return supplier.get();
        } catch (@SuppressWarnings("unused") NullPointerException ignored) {
            return (T) Boolean.FALSE;
        }
    }

    public static <T> T stringNullGuard(Supplier<T> supplier) {
        try {
            supplier.get().toString();
            return supplier.get();
        } catch (@SuppressWarnings("unused") NullPointerException ignored) {
            return (T) "";
        }
    }
}
