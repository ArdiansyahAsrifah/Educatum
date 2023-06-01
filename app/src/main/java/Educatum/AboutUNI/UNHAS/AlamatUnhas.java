package Educatum.AboutUNI.UNHAS;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AlamatUnhas {
    private Stage stage;

    public AlamatUnhas(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        // Membuat GridPane untuk tata letak
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(50));

        // Membuat label untuk alamat
        Label alamatLabel = new Label("Alamat Universitas Hasanuddin:");
        alamatLabel.setStyle("-fx-font-size: 16pt; -fx-font-weight: bold;");

        // Membuat label untuk teks alamat
        Label alamatText = new Label("Perintis Kemerdekaan, Kota Makassar, Indonesia");

        // Menambahkan label dan teks alamat ke dalam GridPane
        gridPane.add(alamatLabel, 0, 0);
        gridPane.add(alamatText, 0, 1);

        // Menambahkan gambar latar belakang
        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/UnhasHome.png"));

        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        // Membuat tombol Back
        Button backButton = new Button("Back");
        backButton.setId("alamat_unhasbutt");
        backButton.setOnAction(e -> {
            // Kembali ke halaman sebelumnya
            Unhas unhas = new Unhas(stage);
            unhas.show();
        });
        gridPane.add(backButton, 3, 0);

        // Menambahkan gambar latar belakang ke dalam GridPane
        Background background = new Background(backgroundImg);
        gridPane.setBackground(background);

        // Membuat scene dan menampilkan stage
        Scene scene = new Scene(gridPane, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
