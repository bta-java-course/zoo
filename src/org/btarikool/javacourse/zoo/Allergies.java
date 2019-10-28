package org.btarikool.javacourse.zoo;

public class Allergies {
    public enum Allergy {
        SALIVA("saliva"),
        URINE("urine"),
        FUR("fur");
        String allergyName;

        Allergy(String name) {
            this.allergyName = name;
        }
        public String getAllergyName(){
            return allergyName;
        }
    }

}
