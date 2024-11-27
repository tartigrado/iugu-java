package com.iugu.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

class ExceptionTranslatorPTBRTest {
    ExceptionTranslator translator = new ExceptionTranslator(new Locale("pt", "BR"));

    @Test
    @DisplayName("Exception Translator: Should return the correct pt-BR message")
    void testReceivableMessage() {
        Assertions.assertEquals(
                "Antecipações são permitidas apenas em dias úteis, entre 09:05 e 18:50.",
                translator.getError("Advancements are permitted only in working days, between 09:05 and 18:50.")
        );
    }

}