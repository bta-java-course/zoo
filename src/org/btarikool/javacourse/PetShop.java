package org.btarikool.javacourse;

import com.sun.deploy.util.StringUtils;
import org.btarikool.javacourse.animal.Animal;
import org.btarikool.javacourse.animal.types.Allergene;
import org.btarikool.javacourse.animal.types.Noisy;
import org.btarikool.javacourse.settings.Settings;

import java.util.ArrayList;
import java.util.List;

public class PetShop {
    static List<Customer> customerList = new ArrayList<>();
    static Customer activeCustomer;
    static List<Animal> animalList;
    public static void main(String[] args) {

        System.out.println(Allergie.FUR);
        System.out.println(Allergie.SMELL);
        System.out.println(Allergie.BITE);

    }


    public static void initAnimals() {
        animalList = new ArrayList<>();
        List<Animal> animals = Settings.getAnimals();
        for (Animal animal : animals) {
            animalList.add(animal);
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
    }
    public static String createCustomer(String name, String age, String budget,
                                        String currencyStr,
                                        List<String> allergies,
                                        List<Animal> compantibleAnimmals)  {
        String message = "CUSTOMER IS CREATING";
        boolean success = true;
        System.out.println(name);
        System.out.println(age);
        int ageInt = 0;
        try {
            ageInt = Integer.parseInt(age);
        } catch (Exception e) {
            message = "Age is not a number";
            success = false;
        }
        System.out.println(budget);
        double budgetDbl = 0;
        try {
            budgetDbl = Double.parseDouble(budget);
        } catch (Exception e) {
            message = "Budget is not a number";
            success = false;
        }
        Currency currency = Currency.EUR;
        System.out.println(currencyStr);
        if (currencyStr == null || "".equals(currencyStr)) {
            message = "Currency is not set";
            success = false;
        } else {
            currency = Currency.valueOf(currencyStr);
        }
        List<Allergie> allergList = new ArrayList<>();
        for (String allergie : allergies) {
            Allergie next = Allergie.valueOf(allergie);
            allergList.add(next)    ;
        }

        if (success) {
            Customer newCustomer = new Customer(name, ageInt, budgetDbl, currency,
                                    allergList, null);
            customerList.add(newCustomer);
            activeCustomer = newCustomer;
            System.out.println(customerList);
            compantibleAnimmals = findAnimalsForCustomer();
            System.out.println(compantibleAnimmals);
        }
        System.out.println(allergies);
        return message;
    }
    public static List<Animal> findAnimalsForCustomer() {
        Customer.Budget budget = activeCustomer.budget;
        List<Animal> ret = new ArrayList<>();
        for (Animal animal : animalList) {
            if(budget != null
                    && (animal.getPrice() <= budget.amount)
                    && animal.isCustomerAllergieCompatible(activeCustomer)) {
                ret.add(animal);
            }
        }
        return ret;
    }
}
