package org.sid.application;

import javafx.stage.Stage;

public class StageSlider {

    private static Stage primaryStage = new Stage();

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        StageSlider.primaryStage = primaryStage;
    }
}
