package sample.Classes;

import formLayout.*;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CountDownLatch;
import javafx.application.Platform;

public class MainApp extends Application {

    private final int WINFORM_WIDTH = 750;
    private final int WINFORM_HEIGHT = 300;
    private final String WINFORM_NAME = "UI design";


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(WINFORM_NAME);
        primaryStage.setWidth(WINFORM_WIDTH);
        primaryStage.setHeight(WINFORM_HEIGHT);
        String stageTitle = primaryStage.getTitle();
        String WHITE_SPACE = " ";

        FirstForm firstF = new FirstForm();
        SecondForm secondF = new SecondForm();
        ThirdForm thirdF = new ThirdForm();
        FourthForm fourthF = new FourthForm();
        FifthForm fifthF = new FifthForm();
        MainForm mainF = new MainForm(firstF, secondF, thirdF, fourthF, fifthF);
        Scene mainScene = new Scene(mainF.getRoot_GridPane());
        primaryStage.setScene(mainScene);

        Runnable task = new Runnable() {
            public void run() {
                new Thread(() -> {
                    while (mainScene.getWindow().isShowing()) {
                        Platform.runLater(() -> {
                            primaryStage.setTitle(WHITE_SPACE + primaryStage.getTitle());

                            if (primaryStage.getTitle().length() >= primaryStage.getWidth() / 4) {
                                primaryStage.setTitle(stageTitle);
                            }
                        });

                        try {
                            TimeUnit.MILLISECONDS.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                }).start();
            }
        };

        new Thread(task).start();

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}