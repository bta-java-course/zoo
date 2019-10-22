package org.btarikool.javacourse;

import org.btarikool.javacourse.genus.Bird;
import org.btarikool.javacourse.genus.species.Parrot;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class PetShop {

    private static List<Animal> animalsList = new ArrayList<>();
    private static List<Customer> customersList = new ArrayList<>();

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.fillAnimalsList(animalsList);
        animalsList.stream().forEach(a ->
        {
            System.out.println(a.getId() + " "
                    + a.getAge() + " "
                    + a.getNick() + " "
                    + a.getAnimalSpecifications().getLivingYears() + " "
                    + a.getAnimalSpecifications().getSize() + " "
                    + a.getAnimalSpecifications().getPsychotype() + " "
                    + a.getAnimalSpecifications().getAllergens() + " "
            );
        }

                );
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
