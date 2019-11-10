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
    @Override
    public String toString() {
        return "Allergie{" +
                "name=" + this.name() +
                ", nonCompliant=" + this.nonCompliant.name() +
                '}';
    }
}
