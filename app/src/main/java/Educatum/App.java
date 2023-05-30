package Educatum;

import Educatum.Scene.Home;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Home home = new Home(primaryStage);
        home.show();

        primaryStage.setTitle("EDUCATUM");
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
