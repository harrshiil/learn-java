package com.pluralsight.example.creational.singleton;

public class Singleton {
    private static volatile Singleton instance = null;

    private Singleton() {
        if (instance != null) {
            throw new RuntimeException("Call using getInstance() method.");
            // This line will prevent creating new instance using reflection.
        }
    }

    // 1-Way => Lazy loaded Singleton class
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }


    // 2-Way => Lazy loaded Singleton class with method level synchronization in multi threaded environment
    public static synchronized Singleton getInstanceSC() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }


    // 3-Way => Lazy loaded Singleton class with double lock checking  in multi threaded environment
    public static Singleton getInstanceDC() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
