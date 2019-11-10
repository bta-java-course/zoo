package org.btarikool.javacourse;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PetShopController implements Initializable

{

    public static final String PROPERTY = System.getProperty("user.dir");
    public static final String PATH = "/src/org/btarikool/javacourse/";
    public static final String PET_SHOP_VOL_1 = "PetShop Vol.1";

    @FXML
    private void changeSceneToAdminsPanel() throws IOException {
        changeScene("admin/adminsPane.fxml", PET_SHOP_VOL_1 + " / Admins Panel");
    }

    @FXML
    private void changeSceneToNewCustomerPanel() throws IOException {
        changeScene("customer/panels/newCustomerPane.fxml", PET_SHOP_VOL_1 + " / New Customer");
    }

    @FXML
    private void changeSceneToLogIn() throws IOException {
        changeScene("customer/panels/logInPane.fxml", PET_SHOP_VOL_1 + " / Log In");
    }

    private void changeScene(String s, String s2) throws IOException {
        File ne = new File(PROPERTY.concat(PATH + s));
        Pane myPane = FXMLLoader.load(ne.toURL());
        PetShopInterface.getMyStage().setTitle(s2);
        PetShopInterface.getMyStage().setScene(new Scene(myPane));
    }

    public void initialize(URL location, ResourceBundle resources) {
    }

}