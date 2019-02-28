package sample.Classes;

import formLayout.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.concurrent.TimeUnit;

public class MainApp extends Application {

    private final int WINFORM_WIDTH = 1100;
    private final int WINFORM_HEIGHT = 300;
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
        MainForm mainF = new MainForm(firstF, secondF, thirdF, fourthF, fifthF);
        Scene mainScene = new Scene(mainF.getRoot_GridPane());
        primaryStage.setScene(mainScene);
        primaryStage.show();

        String title = primaryStage.getTitle();

        Platform.runLater( () -> {
            while (true) {
                primaryStage.setTitle(" " + primaryStage.getTitle());
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}