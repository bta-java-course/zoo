package org.btarikool.javacourse;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PetShop {

    private static List<Animal> animalsList = new ArrayList<>();

    public static void main(String[] args) {
        SubSpecies s = new SubSpecies("Andrei", 1, 2.5d, true);
        SubSpecies s2 = new SubSpecies("Vasja", 1, 2.5d, true);
        animalsList.add(s);
        animalsList.add(s2);
        System.out.println(s.getId());
        System.out.println(s2.getId());
        s.getAnimalSpecifications().setAllergen(Allergen.DANDRUFF, Allergen.SALVIA, Allergen.URINE);
        System.out.println(getAnimalById(0).getNick());
    }

    public static Animal getAnimalById(int id) {
        try {
            Animal currentAnimal = animalsList.stream().filter(animal -> animal.getId() == id).findFirst().get();
            return currentAnimal;
        } catch (NoSuchElementException e) {
            System.out.println("No such ID");
            return null;
        }
    }
}
