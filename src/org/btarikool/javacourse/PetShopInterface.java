package org.btarikool.javacourse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class PetShopInterface extends Application {

    private static Pane myPane;
    private static Stage myStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        myStage = primaryStage;
        myPane = FXMLLoader.load(getClass().getResource("petShopPane.fxml"));
        myStage.setWidth(bounds.getWidth());
        myStage.setHeight(bounds.getHeight());
        myStage.setTitle("PetShop Vol.1");
        myStage.setScene(new Scene(myPane));
        myStage.show();
    }

    public static Pane getMyPane() {
        return myPane;
    }

    public static void setMyPane(Pane myPane) {
        PetShopInterface.myPane = myPane;
    }

    public static Stage getMyStage() {
        return myStage;
    }

    public static void setMyStage(Stage myStage) {
        PetShopInterface.myStage = myStage;
    }
}
