package org.btarikool.javacourse.customer;

import org.btarikool.javacourse.Allergen;
import org.btarikool.javacourse.Psychotype;
import org.btarikool.javacourse.customer.Customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CustomerInfoFill {

    private final static String WRONG_ANSWER = "You entered something else, but not %s. Please try again: ";

    public static void fillingCustomerFields(Customer customer) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            systemInBudget(reader, customer);
            systemInAllergen(reader, customer);
            systemInPsychoType(reader, customer);
            systemInAfraidOfLoud(reader, customer);
            systemInHousingArea(reader, customer);
            systemInResidencePlace(reader, customer);
            systemInAge(reader, customer);
        } catch (IOException e) {}
    }

    private static void systemInBudget(BufferedReader reader, Customer customer) throws IOException {
        System.out.print("Please enter your budget: ");
        String budget;
        while (!((budget = reader.readLine()).matches("\\d+,?\\.?\\d*"))) {
            System.out.print(String.format(WRONG_ANSWER, "a number"));
        }
        //customer.setBudget((Double.parseDouble(budget.replaceAll(",", "."))));
    }

    private static void systemInAllergen(BufferedReader reader, Customer customer) throws IOException {
        System.out.print("Please enter your allergens [" +
                Allergen.getAllergensString() +
                "] or leave field empty to continue\n" +
                "(If you want to choose more than one allergen, then write first, press enter and write next: ");
        String allergen;
        List<String> allergens = new ArrayList<>();
        while (!(allergen = reader.readLine()).equals("")) {
            System.out.print(allergen == null ? "Please enter first: " : "Please enter next: ");
            if (((allergen.toLowerCase()).matches("\\bdandruff\\b|\\bsalvia\\b|\\burine\\b")))
                allergens.add(allergen);
            else System.out.print(String.format(WRONG_ANSWER, "a right answer"));
        }
        setAllergenIfListContainsIt(allergens, customer);
        customer.getSpecifications().getAllergens().forEach(System.out::println);
    }

    private static void setAllergenIfListContainsIt(List<String> allergens, Customer customer) {
        for (Allergen allergen : Allergen.values())
            if (allergens.contains(allergen.toString().toLowerCase()))
                customer.getSpecifications().setAllergens(allergen);
    }

    private static void systemInPsychoType(BufferedReader reader, Customer customer) throws IOException {
        System.out.print("Please enter your psycho type [Choleric, Sanguine, Melancholic]: ");
        String psychoType;
        while (!((psychoType = reader.readLine().toLowerCase()).matches("\\bcholeric\\b|\\bsanguine\\b|\\bmelancholic\\b"))) {
            System.out.print(String.format(WRONG_ANSWER, "a right answer"));
        }
        switch (psychoType) {
            case "choleric": psychoType = "fast";
                break;
            case "sanguine": psychoType = "neutral";
                break;
            case "melancholic": psychoType = "slow";
                break;
        }
        customer.getSpecifications().setPsychoType(Psychotype.valueOf(psychoType.toUpperCase()));
    }

    private static void systemInAfraidOfLoud(BufferedReader reader, Customer customer) throws IOException {
        System.out.print("Please enter whether you afraid of loud sounds or not [Yes, No]: ");
        String afraidOfLoud;
        while (!((afraidOfLoud = reader.readLine().toLowerCase()).matches("\\byes\\b|\\bno\\b"))) {
            System.out.print(String.format(WRONG_ANSWER, "a right answer"));
        }
        customer.getSpecifications().setAfraidOfLoudSounds(afraidOfLoud.equals("yes") ? true : false);
    }

    private static void systemInHousingArea(BufferedReader reader, Customer customer) throws IOException {
        System.out.print("Please enter area of your housing: ");
        String volumeOfHouse;
        while (!((volumeOfHouse = reader.readLine()).matches("\\d+,?\\.?\\d*"))) {
            System.out.print(String.format(WRONG_ANSWER, "a number"));
        }
        customer.getSpecifications().setVolumeOfHousing(
                (int)Double.parseDouble(volumeOfHouse.replaceAll(",", "."))
        );
    }

    private static void systemInResidencePlace(BufferedReader reader, Customer customer) throws IOException {
        System.out.print("Please enter place of your residence [City, Village]: ");
        String residenceLoc;
        while (!((residenceLoc = reader.readLine().toLowerCase()).matches("\\bcity\\b|\\bvillage\\b"))) {
            System.out.print(String.format(WRONG_ANSWER, "a right answer"));
        }
        customer.getSpecifications().setLivingPlaceIsCity(residenceLoc.equals("city") ? true : false);
    }

    private static void systemInAge(BufferedReader reader, Customer customer) throws IOException {
        System.out.print("Please enter your age [Years]: ");
        String ageS;
        while (!((ageS = reader.readLine()).matches("\\d+"))) {
            System.out.print(String.format(WRONG_ANSWER, "an integer"));
        }
        customer.getSpecifications().setAge(Integer.parseInt(ageS));
    }
}
