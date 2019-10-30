package org.btarikool.javacourse.animal.genus.species;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Species {

    BONY,
    CAT,
    CROCODILE,
    DOG,
    FROG,
    GOLDY,
    HORSE,
    PARROT,
    TURTLE;

    public static String getSpeciesString() {
        return Arrays.asList(Species.values()).stream().
                map(species -> StringUtils.capitalize(species.toString().toLowerCase())).
                collect(Collectors.joining(", "));
    }

}
