package com.sha.taravosh.util;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public final class MapperUtil {



    public static String resourceToString(String path) {
        try (InputStream is = MapperUtil.class.getResourceAsStream(path);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            if (is == null) {
                return null;
            }
            is.transferTo(baos);
            return baos.toString();
        }catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
