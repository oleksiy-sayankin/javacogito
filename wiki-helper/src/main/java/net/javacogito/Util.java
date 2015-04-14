package net.javacogito;


import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public final class Util {
    private Util(){}
    public static String readFile(String fileName) throws IOException {
        String result = "";
        ClassLoader classLoader = new Util().getClass().getClassLoader();
        result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        return result;
    }

    public static File getFile(String fileName) throws URISyntaxException {
        File file = new File("src/main/resources" + "/" + fileName);
        return file;
    }
}
