package org.btarikool.javacourse;

public enum Allergie {
    BITE,
    FUR,
    SMELL;
    Allergie nonCompliant;
    static {
        BITE.nonCompliant = BITE;
        FUR.nonCompliant = SMELL;
        SMELL.nonCompliant = FUR;
    }
/*
    private Allergie(String nonCompliance) {
        this.nonCompliant = Allergie.valueOf(nonCompliance);
        this.nonCompliant = nonCompliant;
    }
*/

    @Override
    public String toString() {
        return "Allergie{" +
                "name=" + this.name() +
                ", nonCompliant='" + this.nonCompliant.name() + '\'' +
                '}';
    }
}
