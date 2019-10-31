package org.btarikool.javacourse.customer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NewCustomerInterface extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane myPane = FXMLLoader.load(getClass().getResource("newCustomerPane.fxml"));
        primaryStage.setTitle("PetShop Vol.1 / NewUser");
        primaryStage.setScene(new Scene(myPane));
        primaryStage.show();
    }

}
