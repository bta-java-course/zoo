package org.btarikool.javacourse;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Report {


    public void toFile (List<Object> data, String fileName) {
        try {
            fileName = "log/" + fileName + ".log";
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            for (Object line : data) {
                writer.println(line.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


