package org.btarikool.javacourse.zoo;

public class PetShop {
    /*private static List<Animal> list = new ArrayList<>();
    private static String toLog = "Animals: \n";*/

    public static void main(String[] args) {
        for (Animal animal : Settings.getAnimals()) {
            System.out.println(animal);
        }
        Animal.writeToLog();
        GraphicalInterfaceMain.startUI(args);
    }
}
