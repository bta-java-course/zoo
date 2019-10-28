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

        Noise firstNoise = new Noise(50, Noise.Feature.UNEXPECTED);
        Customer first = new Customer(100, Currency.EUR, Allergie.FUR, firstNoise);
        System.out.println(first);
    }
}
