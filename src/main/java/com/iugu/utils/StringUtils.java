package com.iugu.utils;

import java.util.Objects;

public class StringUtils {

    public static boolean isNullOrEmpty(CharSequence s) {
        return Objects.isNull(s) || s.length() == 0;
    }

}
