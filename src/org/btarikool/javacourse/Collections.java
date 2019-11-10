package org.btarikool.javacourse;

import org.btarikool.javacourse.animal.Animal;
import org.btarikool.javacourse.customer.Customer;
import org.btarikool.javacourse.animal.genus.Genus;
import org.btarikool.javacourse.animal.genus.species.Species;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Collections {
    private static Collections instance = new Collections();
    private List<Animal> animalsList = new ArrayList<>();
    private List<Customer> customersList = new ArrayList<>();

    private Collections() {
    }

    public static Collections getInstance() {
        return instance;
    }

    public List<Animal> getAnimalsList() {
        return this.animalsList;
    }

    public void setAnimalsList(List<Animal> animalsList) {
        this.animalsList = animalsList;
    }

    public List<Customer> getCustomersList() {
        return this.customersList;
    }

    public void setCustomersList(List<Customer> customersList) {
        this.customersList = customersList;
    }

    public List<Animal> getAnimalsListSortedId() {
        return animalsList.stream().
                sorted(Comparator.comparingInt(Animal::getId)).
                collect(Collectors.toList());
    }

    public List<Animal> getAnimalsListSortedNick() {
        return animalsList.stream().
                sorted(Comparator.comparing(Animal::getNick)).
                collect(Collectors.toList());
    }

    public List<Animal> getAnimalsListSortedPriceLowestFirst() {
        return animalsList.stream().
                sorted(Comparator.comparingDouble(Animal::getDoublePrice)).
                collect(Collectors.toList());
    }

    public List<Animal> getAnimalsListSortedPriceHighestFirst() {
        return animalsList.stream().
                sorted(Comparator.comparingDouble(Animal::getDoublePrice).reversed()).
                collect(Collectors.toList());
    }

    public List<Animal> getAnimalsListSortedGenus() {
        return animalsList.stream().
                sorted(Comparator.comparing(Animal::getGenus)).
                collect(Collectors.toList());
    }

    public List<Animal> getAnimalsListSortedSpecies() {
        return animalsList.stream().
                sorted(Comparator.comparing(Animal::getSpecies)).
                collect(Collectors.toList());
    }

    public List<Animal> getAnimalsListFilteredGenus(Genus genus) {
        return animalsList.stream().
                filter(a -> a.getGenus().name().equals(genus.name())).
                sorted(Comparator.comparing(Animal::getGenus)).
                collect(Collectors.toList());
    }

    public List<Animal> getAnimalsListFilteredSpecies(Species species) {
        return animalsList.stream().
                filter(a -> a.getSpecies().name().equals(species.name())).
                sorted(Comparator.comparing(Animal::getSpecies)).
                collect(Collectors.toList());
    }

    public Animal getAnimalById(int id) {
        Animal animal = getAnimalsList().stream().filter(a -> a.getId() == id).findAny().get();
        return animal;
    }

    public double getAnimalsTotalCost() {
        return animalsList.stream().mapToDouble(a -> a.getDoublePrice()).sum();
    }


}
