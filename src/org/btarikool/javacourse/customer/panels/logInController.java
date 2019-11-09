package org.btarikool.javacourse.customer.panels;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.btarikool.javacourse.*;
import org.btarikool.javacourse.config.Logger;
import org.btarikool.javacourse.customer.Customer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.ResourceBundle;

public class logInController implements Initializable {

    private final static String WRONG_ANSWER = "FIELD %s: You entered something else, but not %s.";

    private boolean rightInput = true;
    @FXML
    private Label labelError;
    @FXML
    private TextField fieldName;
    @FXML
    private TextField fieldPassword;

    @FXML
    private void logIn() {
        systemInName();
        systemInPassword();
        if (rightInput && isCustomerPresents()) {
            PetShop.getInstance().setLoggedInCustomer(getCustomer());
            try {
                changeSceneToLoggedInCustomerPanel();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else labelError.setText("Can not find customer with such name and password.");
        rightInput = true;
    }

    private boolean isCustomerPresents() {
        return Collections.getInstance().getCustomersList().stream().
                anyMatch(customer -> customer.getName().equals(fieldName.getText()) && Base64.getEncoder().encodeToString(customer.getPassword()).equals(fieldPassword.getText()));
    }

    private Customer getCustomer() {
        return Collections.getInstance().getCustomersList().stream().
                filter(customer -> customer.getName().equals(fieldName.getText()) && Base64.getEncoder().encodeToString(customer.getPassword()).equals(fieldPassword.getText())).findFirst().get();
    }

    private void systemInName() {
        if (fieldName.getText().matches("\\s*")) {
            labelError.setText("FIELD NAME: Can not be empty!");
            rightInput = false;
            return;
        }
    }

    private void systemInPassword() {
        if (fieldPassword.getText().matches("\\s*")) {
            labelError.setText("FIELD Password: Can not be empty!");
            rightInput = false;
            return;
        }
        else if (fieldPassword.getText().length() < 8) {
            labelError.setText("FIELD Password: Should be min. 8 symbols!");
            rightInput = false;
            return;
        }
    }

    @FXML
    private void changeSceneToPetShopPanel() throws IOException {
        File ne = new File(System.getProperty("user.dir").concat("/src/org/btarikool/javacourse/petShopPane.fxml"));
        Pane myPane = FXMLLoader.load(ne.toURL());
        PetShopInterface.getMyStage().setTitle("PetShop Vol.1");
        PetShopInterface.getMyStage().setScene(new Scene(myPane));
    }

    @FXML
    private void changeSceneToLoggedInCustomerPanel() throws IOException {
        File ne = new File(System.getProperty("user.dir").concat("/src/org/btarikool/javacourse/customer/panels/loggedInCustomerPane.fxml"));
        Pane myPane = FXMLLoader.load(ne.toURL());
        PetShopInterface.getMyStage().setTitle("PetShop Vol.1 / Customer's Panel");
        PetShopInterface.getMyStage().setScene(new Scene(myPane));
    }


    public void initialize(URL location, ResourceBundle resources) {
    }

}