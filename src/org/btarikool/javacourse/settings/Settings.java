package org.btarikool.javacourse.settings;

import org.btarikool.javacourse.animal.Animal;
import org.btarikool.javacourse.animal.Species;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Settings {
    static Properties properties = new Properties();

    static {
        try(InputStream input = new FileInputStream("conf/default.properties")) {
            properties.load(input);
        } catch(IOException ioe) {
            System.out.println("properties file not found");
        }

    }

    public static List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<>();
        String nicks = properties.getProperty("shop.pets.nicks");
        String species = properties.getProperty("shop.pets.species");
        String sexes = properties.getProperty("shop.pets.sex");
        String prices = properties.getProperty("shop.pets.prices");
        List<String> animalList = Arrays.asList(nicks.split(","));
        List<String> speciesList = Arrays.asList(species.split(","));
        List<String> sexList = Arrays.asList(sexes.split(","));
        List<String> pricesList = Arrays.asList(prices.split(","));
        for(int i = 0; i < animalList.size(); i++) {
            int speciesId = Integer.parseInt(speciesList.get(i));
            double price = Double.parseDouble(pricesList.get(i));
            Animal animal = Species.getNewAnimalBySpeciesId(speciesId,
                    animalList.get(i), price, sexList.get(i));
            animals.add(animal);
        }
        return animals;
    }

}