package org.btarikool.javacourse;

import org.btarikool.javacourse.animal.Animal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Report {


    public void toFile (List<Animal> data, String fileName) {
        try {
            fileName = "log/" + fileName + ".log";
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            for (Animal line : data) {
                writer.println(line.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


