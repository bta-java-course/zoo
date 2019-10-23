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
    public  String getNick(String s) {
        return getNick("shop.pets.nick");
    }
    public  String getSpecies(String s) {
        return getSpecies("shop.pets.species");
    }
    public  String getSex(String s) {
        return getSex("shop.pets.sex");
    }
    public  String getPrice(String s) {
        return getPrice("shop.pets.price");
    }



}
