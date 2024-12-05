package com.iugu.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    @DisplayName("StringUtils: should return the string with only digits")
    void testOnlyDigits() {
        Assertions.assertEquals("11520224000140", StringUtils.onlyDigits("11.520.224/0001-40"));
    }
}