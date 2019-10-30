package org.btarikool.javacourse.zoo.animals.reptilias;

import org.btarikool.javacourse.zoo.Allergies;
import org.btarikool.javacourse.zoo.animal.types.Allergic;
import org.btarikool.javacourse.zoo.genus.Reptilia;

public class Turtle extends Reptilia implements Allergic {
    private String allergyName;
    public Turtle() {
causeAllergy();
    }

    @Override
    public void causeAllergy() {
        Allergies.Allergy theAllergy = Allergies.Allergy.URINE;
        this.allergyName = theAllergy.getAllergyName();
    }

    @Override
    public String toString() {
        return super.toString() +
                "allergy= '" + allergyName+ '\'';
    }
}
