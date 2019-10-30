package org.btarikool.javacourse.zoo;

import org.btarikool.javacourse.zoo.animals.mammalias.Cat;
import org.btarikool.javacourse.zoo.animals.fish.GoldFish;
import org.btarikool.javacourse.zoo.animals.amphibias.Salamander;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PetShop {
    private static List<Animal> list = new ArrayList<>();
    private static String toLog = "Animals: \n";

    public static void main(String[] args) {
        for (Animal animal : Settings.getAnimals()) {
            System.out.println(animal);
        }
        Animal.writeToLog();
        GraphicalInterface.startUI(args);
    }
}
