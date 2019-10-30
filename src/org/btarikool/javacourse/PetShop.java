package org.btarikool.javacourse;

import javafx.application.Application;
import org.btarikool.javacourse.admin.AdminInterface;
import org.btarikool.javacourse.config.Configuration;


public class PetShop {

    private static Collections collections = new Collections();

    static {
        Configuration.fillAnimalsList(collections.getAnimalsList());
    }

    public static void main(String[] args) {
       Application.launch(AdminInterface.class, args);


/*        Logger logger = new Logger();
        collections.getAnimalsList().stream().
                peek(a -> a.toString()).
                forEach(System.out::println);
        logger.logList(collections.getAnimalsList());
        System.out.println();
        AdminInterface inte = new AdminInterface(collections);
        inte.getInterface();*/

    }

    public static Collections getCollections() {
        return collections;
    }
}
