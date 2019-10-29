package org.btarikool.javacourse;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.btarikool.javacourse.admin.AdminInterface2;
import org.btarikool.javacourse.admin.AdminOption;


public class PetShop {

    private static Collections collections = new Collections();

    static {
        Configuration.fillAnimalsList(collections.getAnimalsList());
    }

    public static void main(String[] args) {
       Application.launch(AdminInterface2.class, args);


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
