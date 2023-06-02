package Educatum;

import Educatum.Scene.Home;
import Educatum.Utils.DatabaseConfig;
import javafx.application.Application;
import javafx.stage.Stage;


//TEAM 16
//Muhammad Ardiansyah Asrifah - H071221068
//Vicky Jesflinto - H071221019
//Muhammad Rafli Dahlan - H071221104


public class App extends Application {

    //Menambahkan Stage sebagai langkah awal
    @Override
    public void start(Stage primaryStage) {
        Home home = new Home(primaryStage);
        home.show();
        DatabaseConfig.getConnection();
        //Set tittle di app
        primaryStage.setTitle("EDUCATUM");
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
