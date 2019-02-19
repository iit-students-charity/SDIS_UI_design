package sample.Classes;

import Controller.FourthWinFormController;
import Controller.FifthWinFormController;

import FormLayout.FifthWinFormLayout;
import FormLayout.FourthWinFormLayout;
import FormLayout.MainWinFormLayout;
import javafx.application.Application;

import javafx.stage.Stage;

import javafx.scene.Scene;


public class MainApp extends Application {

    private final int WINFORM_WIDTH = 500;
    private final int WINFORM_HEIGHT = 800;
    private final String WINFORM_NAME = "UI design";


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle(WINFORM_NAME);
        primaryStage.setWidth(WINFORM_WIDTH);
        primaryStage.setHeight(WINFORM_HEIGHT);

        FourthWinFormLayout fourthWFL = new FourthWinFormLayout();
        FifthWinFormLayout fifthWFLL = new FifthWinFormLayout();
        MainWinFormLayout mainWFL = new MainWinFormLayout(fourthWFL, fifthWFLL);

        FourthWinFormController fourthWFC = new FourthWinFormController(fourthWFL);
        FifthWinFormController fifthWFC = new FifthWinFormController(fifthWFLL);

        Scene mainScene = new Scene(mainWFL.getRoot_GridPane());
        primaryStage.setScene(mainScene);
        //primaryStage.setScene(mainScene);

        //Scene mainSceneL = new Scene(mainWFLL.getRoot_GridPane());





        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}