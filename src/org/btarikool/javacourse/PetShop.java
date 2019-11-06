package org.btarikool.javacourse;

import com.sun.deploy.util.StringUtils;
import org.btarikool.javacourse.animal.Animal;
import org.btarikool.javacourse.animal.types.Allergene;
import org.btarikool.javacourse.animal.types.Noisy;
import org.btarikool.javacourse.settings.Settings;

import java.util.List;

public class PetShop {
    public static void main(String[] args) {

        System.out.println(Allergie.FUR);
        System.out.println(Allergie.SMELL);
        System.out.println(Allergie.BITE);
        List<Animal> animals = Settings.getAnimals();
        for (Animal animal : animals) {
            if (animal instanceof Noisy) {
                ((Noisy) animal).makesNoise();
            }
            if(animal instanceof Allergene) {
                ((Allergene) animal).makesAllergie();
            }
        }
        System.out.println(animals);
        Report report = new Report();
        report.toFile(animals, "animals");

        Noise firstNoise = new Noise(50, Noise.Feature.UNEXPECTED);
        Customer first = new Customer(100, Currency.EUR, Allergie.FUR, firstNoise);
        System.out.println(first);
    }

    public static String createCustomer(String name, String age, String budget, String currency, List<String> allergies)  {
        String message = "CUSTOMER IS CREATING";
        boolean success = true;
        System.out.println(name);
        System.out.println(age);
        int ageInt;
        try {
            ageInt = Integer.parseInt(age);
        } catch (Exception e) {
            message = "Age is not a number";
            success = false;
        }
        System.out.println(budget);
        double budgetDbl;
        try {
            budgetDbl = Double.parseDouble(budget);
        } catch (Exception e) {
            message = "Budget is not a number";
            success = false;
        }

        System.out.println(currency);
        if (currency == null || "".equals(currency)) {
            message = "Currency is not set";
            success = false;
        }
        if (success) {

        }
        System.out.println(allergies);
        Allergie allergie = Allergie.valueOf(allergies.get(0));
        return message;
    }
}
