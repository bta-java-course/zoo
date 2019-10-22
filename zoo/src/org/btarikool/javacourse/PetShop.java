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

        printAnimalFilteredBySpecies("BoNy");
    }

    public static void printAnimalListById() {
        animalsList.stream().
                sorted(Comparator.comparingInt(Animal::getId)).
                forEach(animal -> System.out.println(animal.getId()));
    }

    public static void printAnimalListByNick() {
        animalsList.stream().
                sorted(Comparator.comparing(Animal::getNick)).
                forEach(animal -> System.out.println(animal.getNick()));
    }

    public static void printAnimalListByPriceLowestFirst() {
        animalsList.stream().
                sorted(Comparator.comparingDouble(Animal::getPrice)).
                forEach(animal -> System.out.println(animal.getPrice()));
    }

    public static void printAnimalListByPriceHighestFirst() {
        animalsList.stream().
                sorted(Comparator.comparingDouble(Animal::getPrice).reversed()).
                forEach(animal -> System.out.println(animal.getPrice()));
    }

    public static void printAnimalListByGenus() {
        animalsList.stream().
                sorted(Comparator.comparing(Animal::getGenus)).
                forEach(animal -> System.out.println(animal.getGenus()));
    }

    public static void printAnimalListBySpecies() {
        animalsList.stream().
                sorted(Comparator.comparing(Animal::getSpecies)).
                forEach(animal -> System.out.println(animal.getSpecies()));
    }

    public static void printAnimalFilteredByGenus(String genus) {
        animalsList.stream().
                filter(a -> a.getGenus().toLowerCase().equals(genus.toLowerCase())).
                sorted(Comparator.comparing(Animal::getGenus)).
                forEach(System.out::println);
    }

    public static void printAnimalFilteredBySpecies(String species) {
        animalsList.stream().
                filter(a -> a.getSpecies().toLowerCase().equals(species.toLowerCase())).
                sorted(Comparator.comparing(Animal::getSpecies)).
                forEach(a -> Configuration.log(a.toString()));
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
