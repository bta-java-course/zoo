package org.btarikool.javacourse.admin;


import org.btarikool.javacourse.Collections;
import org.btarikool.javacourse.Logger;
import org.btarikool.javacourse.genus.Genus;
import org.btarikool.javacourse.genus.species.Species;

public enum AdminOption {

    A1 ("a1"),
    A2 ("a2"),
    A3 ("a3"),
    A4 ("a4"),
    A5 ("a5"),
    B ("a6"),
    C ("c"),
    D ("d");

    private String name;

    AdminOption(String optionToLowerCase) {
        this.name = name;
    }

    public String getOptionToLowerCase() {
        return name;
    }

    public void runOption(Collections collection, Species species, Genus genus) {
        Logger logger = new Logger();
        switch (this) {
            case A1:
                collection.getAnimalsListSortedNick().stream().
                    peek(a -> logger.logString(a.toString())).
                    forEach(System.out::println);
            break;
            case A2:
                collection.getAnimalsListSortedGenus().stream().
                        peek(a -> logger.logString(a.toString())).
                        forEach(System.out::println);
                break;
            case A3:
                collection.getAnimalsListSortedSpecies().stream().
                        peek(a -> logger.logString(a.toString())).
                        forEach(System.out::println);
                break;
            case A4:
                collection.getAnimalsListSortedPriceHighestFirst().stream().
                    peek(a -> logger.logString(a.toString())).
                    forEach(System.out::println);
                break;
            case A5:
                collection.getAnimalsListSortedPriceLowestFirst().stream().
                        peek(a -> logger.logString(a.toString())).
                        forEach(System.out::println);
                break;
            case B:
                String totalPrice = String.valueOf(collection.getAnimalsTotalCost());
                System.out.println(totalPrice);
                logger.logString(totalPrice);
                break;
            case C:
                collection.getAnimalsListFilteredGenus(genus).stream().
                        peek(a -> logger.logString(a.toString())).
                        forEach(System.out::println);
                break;
            case D: collection.getAnimalsListFilteredSpecies(species).stream().
                    peek(a -> logger.logString(a.toString())).
                    forEach(System.out::println);
                break;
        }
    }

}
