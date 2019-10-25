package org.btarikool.javacourse;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Allergen {
    DANDRUFF("dandruff"),
    SALVIA("salvia"),
    URINE("urine");

    private String string;

    Allergen(String string) {
        this.string = string;
    }

    public static String getAllergensString() {
        return Arrays.asList(Allergen.values()).stream().
                map(allergen -> StringUtils.capitalize(allergen.toString().toLowerCase())).
                collect(Collectors.joining(", "));
    }

}
