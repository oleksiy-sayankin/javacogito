package net.javacogito;


import org.apache.commons.io.IOUtils;

import java.io.IOException;

public final class Util {
    private Util(){}
    public static String readFile(String fileName) throws IOException {
        String result = "";
        ClassLoader classLoader = new Util().getClass().getClassLoader();
        result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        return result;
    }
}
