package org.btarikool.javacourse.zoo.animals.mammalias;

import org.btarikool.javacourse.zoo.Allergies;
import org.btarikool.javacourse.zoo.PetShop;
import org.btarikool.javacourse.zoo.animal.types.Allergic;
import org.btarikool.javacourse.zoo.genus.Mammalia;

public class Cat extends Mammalia implements Allergic {
    private String allergyName;
    public Cat() {
        causeAllergy();
    }

    @Override
    public void causeAllergy() {
        Allergies.Allergy theAllergy = Allergies.Allergy.FUR;
        this.allergyName = theAllergy.getAllergyName();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", allergy= '" + allergyName + '\'';
    }
}
