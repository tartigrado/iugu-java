package com.iugu.utils;

import java.util.Objects;
import java.util.regex.Pattern;

public class StringUtils {

    private final static Pattern pattern = Pattern.compile("\\D");

    public static boolean isNullOrEmpty(CharSequence s) {
        return Objects.isNull(s) || s.isEmpty();
    }

    public static String onlyDigits(CharSequence s) {
        if (isNullOrEmpty(s)) {
            return "";
        }
        return pattern.matcher(s).replaceAll("");
    }

}
