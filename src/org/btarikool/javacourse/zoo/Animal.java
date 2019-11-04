package org.btarikool.javacourse.zoo;

import org.btarikool.javacourse.zoo.animals.amphibias.Frog;
import org.btarikool.javacourse.zoo.animals.amphibias.Salamander;
import org.btarikool.javacourse.zoo.animals.birds.Owl;
import org.btarikool.javacourse.zoo.animals.birds.Parrot;
import org.btarikool.javacourse.zoo.animals.fish.GoldFish;
import org.btarikool.javacourse.zoo.animals.fish.Guppy;
import org.btarikool.javacourse.zoo.animals.mammalias.Cat;
import org.btarikool.javacourse.zoo.animals.mammalias.Dog;
import org.btarikool.javacourse.zoo.animals.reptilias.Chameleon;
import org.btarikool.javacourse.zoo.animals.reptilias.Turtle;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private static List<Animal> listOfAnimals = new ArrayList<>();
    // private static String toLog = "Animals: \n";
    private String nick;
    private String sex;
    private String price;
    private String species;
    private Settings settings = new Settings();

    public Animal() {
    }

    public String getNick() {
        return nick;
    }

    public String getSex() {
        return sex;
    }

    public String getPrice() {
        return price;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public static List<Animal> getListOfAnimals() {
        return listOfAnimals;
    }

    public static Animal createAnimal(String theNick, String theSpecies, String theSex, String thePrice) {
        Animal animal;
        switch (theSpecies.toLowerCase()) {
            case "frog":
                animal = new Frog();
                animal.setNick(theNick);
                animal.setPrice(thePrice);
                animal.setSex(theSex);
                animal.setSpecies(theSpecies);
                listOfAnimals.add(animal);
                break;
            case "salamander":
                animal = new Salamander();
                animal.setNick(theNick);
                animal.setPrice(thePrice);
                animal.setSex(theSex);
                animal.setSpecies(theSpecies);
                listOfAnimals.add(animal);
                break;
            case "owl":
                animal = new Owl();
                animal.setNick(theNick);
                animal.setPrice(thePrice);
                animal.setSex(theSex);
                animal.setSpecies(theSpecies);
                listOfAnimals.add(animal);
                break;
            case "parrot":
                animal = new Parrot();
                animal.setNick(theNick);
                animal.setPrice(thePrice);
                animal.setSex(theSex);
                animal.setSpecies(theSpecies);
                listOfAnimals.add(animal);
                break;
            case "goldfish":
                animal = new GoldFish();
                animal.setNick(theNick);
                animal.setPrice(thePrice);
                animal.setSex(theSex);
                animal.setSpecies(theSpecies);
                listOfAnimals.add(animal);
                break;
            case "guppy":
                animal = new Guppy();
                animal.setNick(theNick);
                animal.setPrice(thePrice);
                animal.setSex(theSex);
                animal.setSpecies(theSpecies);
                listOfAnimals.add(animal);
                break;
            case "cat":
                animal = new Cat();
                animal.setNick(theNick);
                animal.setPrice(thePrice);
                animal.setSex(theSex);
                animal.setSpecies(theSpecies);
                listOfAnimals.add(animal);
                break;
            case "dog":
                animal = new Dog();
                animal.setNick(theNick);
                animal.setPrice(thePrice);
                animal.setSex(theSex);
                animal.setSpecies(theSpecies);
                listOfAnimals.add(animal);
                break;
            case "chameleon":
                animal = new Chameleon();
                animal.setNick(theNick);
                animal.setPrice(thePrice);
                animal.setSex(theSex);
                animal.setSpecies(theSpecies);
                listOfAnimals.add(animal);
                break;
            default:
                animal = new Turtle();
                animal.setNick(theNick);
                animal.setPrice(thePrice);
                animal.setSex(theSex);
                animal.setSpecies(theSpecies);
                listOfAnimals.add(animal);
                break;
        }
        return animal;
    }

    public static void writeToLog() {
        StringBuilder toLog = new StringBuilder("Animals: \n");
        for (Animal check : listOfAnimals) {
            toLog.append(check +"\n");
        }
        try {
            FileWriter writer = new FileWriter("log/petshop_out.log");
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println(toLog);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return
                "nick='" + nick + '\'' +
                        ", species= '" + species + '\'' +
                        ", sex='" + sex + '\'' +
                        ", price='" + price + '\'';
    }

}
