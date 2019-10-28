package org.btarikool.javacourse;

public class Allergie {
    public static final Allergie FUR = new Allergie("FUR");
    public static final Allergie SMELL = new Allergie("SMELL");
    public static final Allergie BITE = new Allergie("BITE");
    String type;
    private Allergie(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Allergie{" +
                "type='" + type + '\'' +
                '}';
    }
}
