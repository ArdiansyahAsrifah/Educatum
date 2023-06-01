package Educatum;

import Educatum.Scene.Home;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    //Menambahkan Stage sebagai langkah awal
    @Override
    public void start(Stage primaryStage) {
        Home home = new Home(primaryStage);
        home.show();

        //Set tittle di app
        primaryStage.setTitle("EDUCATUM");
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
