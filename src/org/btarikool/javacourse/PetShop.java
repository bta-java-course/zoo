package org.btarikool.javacourse;

import org.btarikool.javacourse.animal.Animal;
import org.btarikool.javacourse.settings.Settings;

import java.util.List;

public class PetShop {
    public static void main(String[] args) {
        List<Animal> animals = Settings.getAnimals();
        System.out.println(animals);
        Report report = new Report();
        report.toFile(animals, "animals");
    }
}
