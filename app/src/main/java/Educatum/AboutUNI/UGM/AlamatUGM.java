package Educatum.AboutUNI.UGM;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AlamatUGM {
    private Stage stage;

    public AlamatUGM(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        // Membuat GridPane sebagai layout utama
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(50));

        // Membuat label alamat
        Label alamatLabel = new Label("Alamat Universitas Indonesia:");
        alamatLabel.setStyle("-fx-font-size: 16pt; -fx-font-weight: bold;");

        // Membuat teks alamat
        Label alamatText = new Label("Kec. Depok, Kabupaten Sleman, Daerah Istimewa Yogyakarta, Indonesia");

        // Menambahkan label dan teks alamat ke dalam GridPane
        gridPane.add(alamatLabel, 0, 0);
        gridPane.add(alamatText, 0, 1);

        // Mengatur latar belakang menggunakan gambar
        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/DesignAboutUniUGM.png"));
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        Background background = new Background(backgroundImg);
        gridPane.setBackground(background);

        // Membuat tombol back
        Button backButton = new Button("Back");
        backButton.setId("alamat-ugm");
        backButton.setOnAction(e -> {
            Ugm jUi = new Ugm(stage);
            jUi.show();
        });

        // Menambahkan tombol back ke dalam GridPane
        gridPane.add(backButton, 3, 0);

        // Membuat scene dan menampilkan stage
        Scene scene = new Scene(gridPane, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
