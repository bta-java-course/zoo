package org.btarikool.javacourse;

public class Allergie {
    public static final Allergie FUR = new Allergie("FUR");
    public static final Allergie SMELL = new Allergie("SMELL");
    String type;
    private Allergie(String type) {
        this.type = type;
    }
}
