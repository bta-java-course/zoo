package org.btarikool.javacourse.zoo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class Settings {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = new FileInputStream("conf/petshop.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Properties not found");
        }
    }

public String getNick(int i){
    try {
        List<String> listOfNames = Arrays.asList(properties.getProperty("shop.pets.nicks").split(","));
        return listOfNames.get(i);
    }catch (Exception e){
        System.out.println("Invalid properties value for randomName");
        return "";
    }
}
public String getSex(int i){
    try {
        List<String> listOfNames = Arrays.asList(properties.getProperty("shop.pets.sex").split(","));
        return listOfNames.get(i);
    }catch (Exception e){
        System.out.println("Invalid properties value for randomName");
        return "";
    }
}
public String getPrice(int i){
    try {
        List<String> listOfNames = Arrays.asList(properties.getProperty("shop.pets.prices").split(","));
        return listOfNames.get(i);
    }catch (Exception e){
        System.out.println("Invalid properties value for randomName");
        return "";
    }
}

}
