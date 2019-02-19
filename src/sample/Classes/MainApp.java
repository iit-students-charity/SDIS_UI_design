package sample.Classes;

import formLayout.*;
import javafx.application.Application;

import javafx.stage.Stage;

import javafx.scene.Scene;


public class MainApp extends Application {

    private final int WINFORM_WIDTH = 500;
    private final int WINFORM_HEIGHT = 800;
    private final String WINFORM_NAME = "UI design";


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(WINFORM_NAME);
        primaryStage.setWidth(WINFORM_WIDTH);
        primaryStage.setHeight(WINFORM_HEIGHT);

        FirstForm firstF = new FirstForm();
        SecondForm secondF = new SecondForm();
        ThirdForm thirdF = new ThirdForm();
        FourthForm fourthF = new FourthForm();
        FifthForm fifthF = new FifthForm();
        MainForm mainWFL = new MainForm(firstF, secondF, thirdF, fourthF, fifthF);

        Scene mainScene = new Scene(mainWFL.getRoot_GridPane());
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}