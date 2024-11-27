package com.iugu.exceptions;

import com.iugu.IuguConstants;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
public final class ExceptionTranslator {
    final ResourceBundle errors;
    final ResourceBundle fields;

    public ExceptionTranslator() {
        this(Locale.forLanguageTag(IuguConstants.LOCALE));
    }


    public ExceptionTranslator(Locale locale) {
        this(ResourceBundle.getBundle("iugu.Errors", locale), ResourceBundle.getBundle("iugu.Fields", locale));
    }

    String getField(String key) {
        return Optional.ofNullable(getMessage(fields, key)).orElse(key);
    }

    String getError(String key) {
        return getMessage(errors, key);
    }

    String getMessage(ResourceBundle bundle, String key) {
        try {
            return bundle.getString(key);
        } catch (MissingResourceException ex) {
            return null;
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public Map<String, Object> translate(Map<String, Object> errors) {
        Map<String, Object> translated = new HashMap<>();
        errors.forEach((k, v) -> {
            if (v instanceof String) {
                String error = Optional.ofNullable(getError((String) v)).orElse(((String) v));
                translated.put(getField(k), error);
            } else if (v instanceof List) {
                List<Object> translatedList = new ArrayList<>();
                ((List<?>) v).forEach(item -> {
                    if (item instanceof String) {
                        String error = Optional.ofNullable(getError((String) item)).orElse(((String) item));
                        translatedList.add(error);
                    } else if (item instanceof Map map) {
                        translatedList.add(translate(map));
                    } else {
                        translatedList.add(item);
                    }
                });
                translated.put(getField(k), translatedList);
            } else if (v instanceof Map map) {
                translated.put(getField(k), translate(map));
            } else {
                translated.put(getField(k), v);
            }
        });
        return translated;
    }
}
