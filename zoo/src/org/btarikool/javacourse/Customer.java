package org.btarikool.javacourse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final static String WRONG_ANSWER = "You entered something else, but not a right answer. Please try ageing: ";
    private final static String NOT_INTEGER = "You entered something else, but not an integer. Please try ageing: ";
    private final static String NOT_NUMBER = "You entered something else, but not a number. Please try ageing: ";

    private CustomerSpecifications specifications;

    public Customer(List<Customer> list) {
        this.specifications = new CustomerSpecifications();
        fillingCustomerFields();
        list.add(this);
    }

    public CustomerSpecifications getSpecifications() {
        return this.specifications;
    }

    private void fillingCustomerFields() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            this.systemInAllergen(reader);
            this.systemInPsychoType(reader);
            this.systemInAfraidOfLoud(reader);
            this.systemInHousingArea(reader);
            this.systemInResidencePlace(reader);
        } catch (IOException e) {}

    }

    private void systemInAllergen(BufferedReader reader) throws IOException {
        System.out.print("Please enter your allergens [Dandruff, Salvia, Urine] or leave field empty to continue\n" +
                "(If you want to choose more than one allergen, then write first, press enter and write next: ");
        String allergen;
        List<String> allergens = new ArrayList<>();
        while (!(allergen = reader.readLine()).equals("")) {
            System.out.print(allergen == null ? "Please enter first: " : "Please enter next: ");
            if (((allergen.toLowerCase()).matches("\\bdandruff\\b|\\bsalvia\\b|\\burine\\b")))
                allergens.add(allergen);
            else
                System.out.print(WRONG_ANSWER);
        }
        if (allergens.contains("dandruff")) this.specifications.setAllergens(Allergen.DANDRUFF);
        if (allergens.contains("salvia")) this.specifications.setAllergens(Allergen.SALVIA);
        if (allergens.contains("urine")) this.specifications.setAllergens(Allergen.URINE);
        this.specifications.getAllergens().stream().forEach(System.out::println);
    }

    private void systemInPsychoType(BufferedReader reader) throws IOException {
        System.out.print("Please enter your psycho type [Choleric, Sanguine, Melancholic]: ");
        String psychoType;
        while (!((psychoType = reader.readLine().toLowerCase()).matches("\\bcholeric\\b|\\bsanguine\\b|\\bmelancholic\\b"))) {
            System.out.print(WRONG_ANSWER);
        }
        switch (psychoType) {
            case "choleric": psychoType = "fast";
                break;
            case "sanguine": psychoType = "neutral";
                break;
            case "melancholic": psychoType = "slow";
                break;
        }
        this.specifications.setPsychotype(Psychotype.valueOf(psychoType.toUpperCase()));
    }

    private void systemInAfraidOfLoud(BufferedReader reader) throws IOException {
        System.out.print("Please enter whether you afraid of loud sounds or not [Yes, No]: ");
        String afraidOfLoud;
        while (!((afraidOfLoud = reader.readLine().toLowerCase()).matches("\\byes\\b|\\bno\\b"))) {
            System.out.print(WRONG_ANSWER);
        }
        this.specifications.setAfraidOfLoudSounds(afraidOfLoud.equals("yes") ? true : false);
    }

    private void systemInHousingArea(BufferedReader reader) throws IOException {
        System.out.print("Please enter area of your housing: ");
        String volumeOfHouse;
        while (!((volumeOfHouse = reader.readLine()).matches("\\d+,?\\.?\\d*"))) {
            System.out.print(NOT_NUMBER);
        }
        this.specifications.setVolumeOfHousing(
                (int)Double.parseDouble(volumeOfHouse.replaceAll(",", "."))
        );
    }

    private void systemInResidencePlace(BufferedReader reader) throws IOException {
        System.out.print("Please enter place of your residence [City, Village]: ");
        String residenceLoc;
        while (!((residenceLoc = reader.readLine().toLowerCase()).matches("\\bcity\\b|\\bvillage\\b"))) {
            System.out.print(WRONG_ANSWER);
        }
        this.specifications.setLivingPlaceIsCity(residenceLoc.equals("city") ? true : false);
    }

    private void systemInAge(BufferedReader reader) throws IOException {
        System.out.print("Please enter your age [Years]: ");
        String ageS;
        while (!((ageS = reader.readLine()).matches("\\d+"))) {
            System.out.print(NOT_INTEGER);
        }
        this.specifications.setAge(Integer.parseInt(ageS));
    }

}
