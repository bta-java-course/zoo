package org.btarikool.javacourse.zoo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Settings {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = new FileInputStream("conf/petshop.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Properties not found");
        }
    }

    public static List<Animal> getAnimals() {
        List<Animal> list = new ArrayList<>();
        try {
            List<String> listOfNames = Arrays.asList(properties.getProperty("shop.pets.nicks").split(","));
            List<String> listOfSex = Arrays.asList(properties.getProperty("shop.pets.sex").split(","));
            List<String> listOfPrices = Arrays.asList(properties.getProperty("shop.pets.prices").split(","));
            List<String> listOfSpecies = Arrays.asList(properties.getProperty("shop.pets.species").split(","));
            for (int i = 0; i < listOfNames.size(); i++) {
                Animal animal = Animal.createAnimal(listOfNames.get(i), listOfSpecies.get(i), listOfSex.get(i), listOfPrices.get(i));
                list.add(animal);
            }
        } catch (Exception e) {
            System.out.println("Invalid properties value for randomName");
        }
        return list;
    }
}
