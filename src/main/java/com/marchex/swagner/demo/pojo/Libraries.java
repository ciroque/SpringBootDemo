package com.marchex.swagner.demo.pojo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Vector;

public class Libraries {
    private ArrayList<String> libraries;

    private Libraries(ArrayList<String> libraries) {
        this.libraries = libraries;
    }

    public static Libraries GetLibraries() {
        Vector<String> libraries;

        try {
            final Field Libraries = ClassLoader.class.getDeclaredField("loadedLibraryNames");
            Libraries.setAccessible(true);
            libraries = (Vector<String>) Libraries.get(ClassLoader.getSystemClassLoader());
        } catch(NoSuchFieldException | IllegalAccessException ex) {
            libraries = new Vector<String>();
        }

        return new Libraries(new ArrayList<>(libraries));
    }

    public ArrayList<String> getLibraries() {
        return libraries;
    }
}
