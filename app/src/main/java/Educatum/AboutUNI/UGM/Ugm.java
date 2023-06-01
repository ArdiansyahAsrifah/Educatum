package Educatum.AboutUNI.UGM;

import Educatum.Scene.AboutUni;
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
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Ugm {
    private Stage stage;

    public Ugm(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        // Membuat GridPane sebagai layout utama
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER_RIGHT); // Mengubah posisi grid ke kanan
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(70));

        // Membuat tombol "Jurusan" dengan style teks berwarna navy
        Button jurusanButton = createTransparentButton("Jurusan");
        jurusanButton.setStyle("-fx-text-fill: navy;");
        jurusanButton.setId("jurusan-button");
        jurusanButton.setOnAction(e -> {
            JurusanUGM jurusan = new JurusanUGM(stage);
            jurusan.show();
        });

        // Membuat tombol "Alamat" dengan style teks berwarna navy
        Button alamatButton = createTransparentButton("Alamat");
        alamatButton.setStyle("-fx-text-fill: navy;");
        alamatButton.setId("alamat-button");
        alamatButton.setOnAction(e -> {
            AlamatUGM alamatUI = new AlamatUGM(stage);
            alamatUI.show();
        });

        // Membuat tombol "Seleksi Masuk" dengan style teks berwarna navy
        Button seleksiButton = createTransparentButton("Seleksi Masuk");
        seleksiButton.setStyle("-fx-text-fill: navy;");
        seleksiButton.setId("seleksi-button");
        seleksiButton.setOnAction(e -> {
            SeleksiUGM seleksiUI = new SeleksiUGM(stage);
            seleksiUI.show();
        });

        // Membuat tombol "Back" dengan style teks berwarna hitam
        Button backButton = createTransparentButton("Back");
        backButton.setStyle("-fx-text-fill: black");
        backButton.setId("back-button");
        backButton.setOnAction(e -> {
            AboutUni aboutuni = new AboutUni(stage);
            aboutuni.show();
        });

        // Mengatur latar belakang menggunakan gambar
        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/DesignAboutUniUGM.png"));
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        Background background = new Background(backgroundImg);
        gridPane.setBackground(background);

        // Menambahkan tombol-tombol ke dalam gridPane
        gridPane.add(jurusanButton, 0, 0);
        gridPane.add(alamatButton, 0, 1);
        gridPane.add(seleksiButton, 0, 2);
        gridPane.add(backButton, 0, 3);

        // Membuat scene dan menampilkan stage
        Scene scene = new Scene(gridPane, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    // Membuat tombol dengan latar belakang transparan dan style teks di tengah
    private Button createTransparentButton(String buttonText) {
        Button button = new Button(buttonText);
        button.setStyle("-fx-background-color: transparent;");
        button.setTextAlignment(TextAlignment.CENTER);
        button.setFont(Font.font(18));
        return button;
    }
}
