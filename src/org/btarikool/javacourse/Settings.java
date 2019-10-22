package org.btarikool.javacourse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {
    static Properties properties = new Properties();

    static {
        try(InputStream input = new FileInputStream("conf/default.properties")) {
            properties.load(input);
        } catch(IOException ioe) {
            System.out.println("properties file not found");
        }
    }

    public static String[] getShopPetsNicks () {
        String nicks = properties.getProperty("shop.pets.nicks");
        String[] petNames = nicks.split(",");
        return petNames;
    }

}
