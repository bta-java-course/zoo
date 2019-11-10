package org.btarikool.javacourse.customer.panels;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.btarikool.javacourse.Collections;
import org.btarikool.javacourse.PetShop;
import org.btarikool.javacourse.PetShopController;
import org.btarikool.javacourse.PetShopInterface;
import org.btarikool.javacourse.customer.Customer;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.ResourceBundle;

public class LogInController implements Initializable {

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
                anyMatch(customer -> customer.getName().
                        equals(fieldName.getText()) && getFromMD5Password(customer.getPassword()).equals(fieldPassword.getText()));
    }

    private Customer getCustomer() {
        Customer customer = Collections.getInstance().getCustomersList().stream().
                filter(customr -> customr.getName().
                        equals(fieldName.getText()) && getFromMD5Password(customr.getPassword()).equals(fieldPassword.getText())).
                findFirst().
                get();
        return customer;
    }

    private String getFromMD5Password(MessageDigest password) {
        return Base64.getEncoder().encodeToString(password.digest());
    }

    private void systemInName() {
        if (fieldName.getText().matches("\\s*")) {
            labelError.setText("FIELD NAME: Can not be empty!");
            rightInput = false;
        }
    }

    private void systemInPassword() {
        if (fieldPassword.getText().matches("\\s*")) {
            labelError.setText("FIELD Password: Can not be empty!");
            rightInput = false;
            return;
        } else if (fieldPassword.getText().length() < 8) {
            labelError.setText("FIELD Password: Should be min. 8 symbols!");
            rightInput = false;
            return;
        }
    }

    @FXML
    private void changeSceneToPetShopPanel() throws IOException {
        changeScene("petShopPane.fxml", PetShopController.PET_SHOP_VOL_1);
    }

    @FXML
    private void changeSceneToLoggedInCustomerPanel() throws IOException {
        changeScene("customer/panels/loggedInCustomerPane.fxml", PetShopController.PET_SHOP_VOL_1 + " / Customer's Panel");
    }

    private void changeScene(String s, String s2) throws IOException {
        File ne = new File(PetShopController.PROPERTY.concat(PetShopController.PATH + s));
        Pane myPane = FXMLLoader.load(ne.toURL());
        PetShopInterface.getMyStage().setTitle(s2);
        PetShopInterface.getMyStage().setScene(new Scene(myPane));
    }

    public void initialize(URL location, ResourceBundle resources) {
    }

}