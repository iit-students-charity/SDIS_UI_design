package sample.Classes;

import Controllers.MainWinFormController;
import javafx.application.Application;

import javafx.stage.Stage;

import javafx.scene.Scene;


public class MainApp extends Application {

    private final int WINFORM_WIDTH = 250;
    private final int WINFORM_HEIGHT = 300;
    private final String WINFORM_NAME = "UI design";


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle(WINFORM_NAME);
        primaryStage.setWidth(WINFORM_WIDTH);
        primaryStage.setHeight(WINFORM_HEIGHT);

        MainWinFormLayout mainWFL = new MainWinFormLayout();
        Scene mainScene = new Scene(mainWFL.getRoot());
        primaryStage.setScene(mainScene);

        MainWinFormController mainWFC = new MainWinFormController(mainWFL);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}