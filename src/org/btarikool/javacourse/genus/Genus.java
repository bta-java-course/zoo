package org.btarikool.javacourse.genus;

import com.sun.xml.internal.ws.util.StringUtils;
import org.btarikool.javacourse.Allergen;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Genus {

    AMPHIBIAN,
    BIRD,
    FISH,
    MAMMAL,
    REPTILE;

    public static String getGenusString() {
        return Arrays.asList(Genus.values()).stream().
                map(genus -> StringUtils.capitalize(genus.toString().toLowerCase())).
                collect(Collectors.joining(", "));
    }

}
