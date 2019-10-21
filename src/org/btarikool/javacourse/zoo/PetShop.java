package org.btarikool.javacourse.zoo;

import org.btarikool.javacourse.zoo.animals.Cat;
import org.btarikool.javacourse.zoo.animals.GoldFish;
import org.btarikool.javacourse.zoo.animals.Salamander;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PetShop {
    public static List<Animal> list = new ArrayList<>();
    public static String toLog = "Animals: \n";

    public static void main(String[] args) {

        Animal theCat = new Cat(1);
        Animal theGoldFish = new GoldFish(2);
        Animal theSalamander = new Salamander(3);
        toLog += theCat.toString() + theGoldFish.toString() + theSalamander.toString();
        list.add(theCat);
        list.add(theGoldFish);
        list.add(theSalamander);
        System.out.println("Animals: \n");
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
        writeToLog();
    }

    public static void writeToLog() {
        try {
            FileWriter writer = new FileWriter("log/petshop_out.log");
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println(toLog);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
