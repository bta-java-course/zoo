package org.btarikool.javacourse.zoo;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GraphicalInterface extends Application {

    public void start(Stage stage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setHgap(25);
        pane.setVgap(15);

        Label requiredF = new Label("(Required fields marked as *)");
        pane.add(requiredF, 0, 0,3,1);
        Label name = new Label("Name*:");
        pane.add(name, 0, 1);
        TextField nameInput = new TextField("");
        pane.add(nameInput, 1, 1);

        Label age = new Label("Age*:");
        pane.add(age, 0, 2);
        TextField ageInput = new TextField("");
        pane.add(ageInput, 1, 2);

        Label budget = new Label("Budget*:");
        pane.add(budget, 0, 3);
        TextField budgetInput = new TextField("");
        pane.add(budgetInput, 1, 3);

        Label currency = new Label("Currency:");
        pane.add(currency, 0, 4);
        ComboBox<String> currencyList = new ComboBox<>();
        currencyList.getItems().add("EUR");
        currencyList.getItems().add("USD");
        currencyList.getItems().add("YEN");
        pane.add(currencyList, 1, 4);

        Label allergies = new Label("Allergies:");
        pane.add(allergies, 0, 5);
        Label allergyFur = new Label("Fur");
        pane.add(allergyFur, 1, 6);
        CheckBox furCheck = new CheckBox();
        GridPane.setHalignment(furCheck, HPos.RIGHT);
        pane.add(furCheck, 1, 6);
        Label allergyUrine = new Label("Urine");
        pane.add(allergyUrine, 1, 7);
        CheckBox urineCheck = new CheckBox();
        GridPane.setHalignment(urineCheck, HPos.RIGHT);
        pane.add(urineCheck, 1, 7);
        Label allergySaliva = new Label("Saliva");
        pane.add(allergySaliva, 1, 8);
        CheckBox salivaCheck = new CheckBox();
        GridPane.setHalignment(salivaCheck, HPos.RIGHT);
        pane.add(salivaCheck, 1, 8);

        Button button = new Button("Send");
        button.setPrefWidth(100);
        GridPane.setHalignment(button, HPos.RIGHT);
        pane.add(button, 1, 9);
        Label labelresponse= new Label();
        labelresponse.setTextFill(Color.web("#ff0000"));
        pane.add(labelresponse,0,10,3,1);
        button.setOnAction( e ->  {
            if (nameInput.getText().isEmpty()
                    || ageInput.getText().isEmpty()
                    || budgetInput.getText().isEmpty()){
                labelresponse.setText("Please fill in all required fields.");
            } else if(!(ageInput.getText().matches("[1-9]\\d*"))){
                labelresponse.setText("Age has to be Integer greater than 0");
            } else if(!(budgetInput.getText().matches("[1-9]\\d*\\.\\d+$"))){
                labelresponse.setText("Budget has to be Double (e.g. 1.0) greater than 0");
            } else{
                labelresponse.setText("OK");
            }
        });


        Scene scene = new Scene(pane, 370, 480);
        stage.setScene(scene);
        stage.setTitle("JavaFX Test");
        stage.show();

    }

    public static void startUI(String[] args) {
        launch(args);
    }

}

