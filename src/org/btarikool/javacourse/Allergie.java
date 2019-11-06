package org.btarikool.javacourse;

<<<<<<< HEAD
public interface Allergie {

}

=======
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
>>>>>>> origin/master_p2-7_2-8
