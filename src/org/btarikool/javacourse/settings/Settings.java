package org.btarikool.javacourse.settings;

import org.btarikool.javacourse.animal.Animal;

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

    public List<Animal> getSpecies() {
        List<Animal> animals = new ArrayList<>();
        String nicks;
        String species = properties.getProperty("shop.species");
        List<String> speciesList = Arrays.asList(species.split(","));
        for(String s : speciesList) {
            
        }

        return null;
    }

}
