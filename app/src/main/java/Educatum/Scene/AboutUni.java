package Educatum.Scene;

import Educatum.AboutUNI.UGM.Ugm;
import Educatum.AboutUNI.UI.Ui;
import Educatum.AboutUNI.UNHAS.Unhas;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AboutUni {
    //Encapsulation stage
    private Stage stage;

    //Membuat Constructor
    public AboutUni(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        // Membuat GridPane untuk tata letak elemen-elemen
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(50));

        // Membuat tombol untuk Universitas Indonesia
        Button uiButton = createButton("Universitas Indonesia");
        uiButton.setStyle("-fx-font-weight: bold");
        uiButton.setId("univ-button");
        uiButton.setOnAction(e -> {
            Ui ui = new Ui(stage);
            ui.show();
        });

        // Membuat tombol untuk Universitas Hasanuddin
        Button unhasButton = createButton("Universitas Hasanuddin");
        unhasButton.setStyle("-fx-font-weight: bold");
        unhasButton.setId("univ-button");
        unhasButton.setOnAction(e -> {
            Unhas unhas = new Unhas(stage);
            unhas.show();
        });

        // Membuat tombol untuk Universitas Gadjah Mada
        Button ugmButton = createButton("Universitas Gadjah Mada");
        ugmButton.setStyle("-fx-font-weight: bold");
        ugmButton.setId("univ-button");
        ugmButton.setOnAction(e -> {
            Ugm ugm = new Ugm(stage);
            ugm.show();
        });

        // Membuat tombol untuk kembali ke halaman sebelumnya
        Button backButton = createButton("Back");
        backButton.setStyle("-fx-text-fill: black");
        backButton.setId("backKecil-button");
        backButton.setOnAction(e -> {
            FeatureScene featureScene = new FeatureScene(stage);
            featureScene.show();
        });

        // Membuat tombol untuk kembali ke halaman utama
        Button homeButton = createButton("Home");
        homeButton.setFont(Font.font(14));
        homeButton.setStyle("-fx-text-fill: black");
        homeButton.setId("home-button");
        homeButton.setOnAction(e -> {
            Home home = new Home(stage);
            home.show();
        });

        // Membuat objek Image untuk latar belakang
        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/AboutUniDesign.png"));

        // Membuat objek BackgroundImage untuk latar belakang
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        // Membuat objek Background menggunakan backgroundImg
        Background background = new Background(backgroundImg);
        gridPane.setBackground(background);

        // Menambahkan tombol-tombol ke dalam GridPane
        gridPane.add(uiButton, 0, 1);
        gridPane.add(unhasButton, 2, 1);
        gridPane.add(ugmButton, 4, 1);
        gridPane.add(backButton, 0, 5);
        gridPane.add(homeButton, 0, 6);

        // Membuat objek Scene dengan menggunakan GridPane sebagai root node
        Scene scene = new Scene(gridPane, 640, 480);
        
        // Menambahkan stylesheet ke Scene
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        
        // Mengatur Scene ke dalam Stage dan menampilkan Stage
        stage.setScene(scene);
        stage.show();
    }

    // Membuat tombol dengan teks yang diberikan
    private Button createButton(String buttonText) {
        Button button = new Button(buttonText);
        button.setStyle("-fx-background-color: transparent;");
        button.setTextFill(Color.BLACK);
        return button;
    }
}
