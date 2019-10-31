package org.btarikool.javacourse.admin;

import org.btarikool.javacourse.Collections;
import org.btarikool.javacourse.animal.genus.Genus;
import org.btarikool.javacourse.animal.genus.species.Species;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class OLDAdminInterface {
/*

    private Collections collection;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public OLDAdminInterface(Collections collection) {
        this.collection = collection;
    }

    public void getInterface() {
        System.out.println("Please select an option:");
        System.out.println("\t•If u want to see animals sorted by:");
        System.out.println("\t\t Enter a1 by name");
        System.out.println("\t\t Enter a2 by genus");
        System.out.println("\t\t Enter a3 by species");
        System.out.println("\t\t Enter a4 by price - highest first");
        System.out.println("\t\t Enter a5 by price - lowest first");
        System.out.println("\t•Enter b if you want to see animals total cost.");
        System.out.println("\t•Enter c if you want to see list of animals with certain genus. \n\t List of genus [ " +
                Genus.getGenusString() + " ]\n\t After choosing option c, press enter, then enter needed genus.");
        System.out.println("\t•Enter d if you want to see list of animals with certain species. \n\t List of species [ " +
                Species.getSpeciesString() + " ]\n\t After choosing option d, press enter, then enter needed species.");
        System.out.print("SELECT AN OPTION: ");
        selectOption();
    }

        private void selectOption() {
            String option = getOption();
            if (Arrays.asList(AdminOption.values()).stream().anyMatch(o -> o.name().toLowerCase().equals(option)))
                AdminOption.valueOf(option.toUpperCase()).runOption(collection, null, null);
            if (Arrays.asList(Species.values()).stream().anyMatch(s -> s.name().toLowerCase().equals(option)))
                AdminOption.D.runOption(collection, Species.valueOf(option.toUpperCase()), null);
            if (Arrays.asList(Genus.values()).stream().anyMatch(g -> g.name().toLowerCase().equals(option)))
                AdminOption.C.runOption(collection, null, Genus.valueOf(option.toUpperCase()));
        }

    private String getOption() {
        String finalSelection = "";
        finalSelection = checkSelection(reader, finalSelection, "option", Arrays.asList(AdminOption.values()));
        if (finalSelection.equals("c")) {
            System.out.print("SELECT GENUS TYPE: ");
            finalSelection = checkSelection(reader, finalSelection, "genus", Arrays.asList(Genus.values()));
        }
        if (finalSelection.equals("d")) {
            System.out.print("SELECT SPECIES TYPE: ");
            finalSelection = checkSelection(reader, finalSelection, "species", Arrays.asList(Species.values()));
        }
        return finalSelection;
    }

    private String checkSelection(BufferedReader reader, String finalSelection, String message, List<Enum> valuesList) {
        boolean run = false;
        try  {
            while (!run) {
                String selection = reader.readLine().toLowerCase();
                run = valuesList.stream().
                        anyMatch(o -> o.name().toLowerCase().equals(selection));
                if (!run) System.out.print(String.format("You entered wrong %s. PLEASE TRY AGAIN: ", message));
                finalSelection = selection;
            }
        } catch (IOException e) {
            System.out.println("checkSelection");
        }
        return finalSelection;
    }
*/

}
