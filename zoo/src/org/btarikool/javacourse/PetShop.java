package org.btarikool.javacourse;

import org.btarikool.javacourse.genus.Genus;
import org.btarikool.javacourse.genus.species.Species;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class PetShop {

    private static Collections collections = new Collections();

    static {
        Configuration.fillAnimalsList(collections.getAnimalsList());
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Logger logger = new Logger();
        collections.getAnimalsList().stream().
                peek(a -> a.toString()).
                forEach(System.out::println);
        logger.logList(collections.getAnimalsList());
        System.out.println();
        AdminInterface inte = new AdminInterface(collections);
        inte.getInterface();
    }

}
