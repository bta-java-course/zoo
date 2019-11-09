package org.btarikool.javacourse;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.btarikool.javacourse.animal.genus.Genus;
import org.btarikool.javacourse.animal.genus.species.Species;
import org.btarikool.javacourse.config.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PetShopController implements Initializable

{

    @FXML
    private void changeSceneToAdminsPanel() throws IOException {
        File ne = new File(System.getProperty("user.dir").concat("/src/org/btarikool/javacourse/admin/adminsPane.fxml"));
        Pane myPane = FXMLLoader.load(ne.toURL());
        PetShopInterface.getMyStage().setTitle("PetShop Vol.1 / Admins Panel");
        PetShopInterface.getMyStage().setScene(new Scene(myPane));
    }

    @FXML
    private void changeSceneToNewCustomerPanel() throws IOException {
        File ne = new File(System.getProperty("user.dir").concat("/src/org/btarikool/javacourse/customer/panels/newCustomerPane.fxml"));
        Pane myPane = FXMLLoader.load(ne.toURL());
        PetShopInterface.getMyStage().setTitle("PetShop Vol.1 / New Customer");
        PetShopInterface.getMyStage().setScene(new Scene(myPane));
    }

    @FXML
    private void changeSceneToLogIn() throws IOException {
        File ne = new File(System.getProperty("user.dir").concat("/src/org/btarikool/javacourse/customer/panels/logInPane.fxml"));
        Pane myPane = FXMLLoader.load(ne.toURL());
        PetShopInterface.getMyStage().setTitle("PetShop Vol.1 / Log In");
        PetShopInterface.getMyStage().setScene(new Scene(myPane));
    }

    public void initialize(URL location, ResourceBundle resources) {
    }

}