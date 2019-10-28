package org.btarikool.javacourse;

import org.btarikool.javacourse.animal.Animal;
import org.btarikool.javacourse.settings.Settings;

import java.util.List;

public class PetShop {
    public static void main(String[] args) {
<<<<<<< HEAD

=======
        List<Animal> animals = Settings.getAnimals();
        System.out.println(animals);
        Report report = new Report();
        report.toFile(animals, "animals");
>>>>>>> d5722ab5165c1092b7b3e97207b9fb18023b250e
    }
}
