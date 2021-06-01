package com.nelsonenterprises.springbootmongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.PublicKey;

public class URL {

    public static String decode(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
