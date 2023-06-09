package Educatum.AboutUNI.UNHAS;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.List;

public class SeleksiUnhas {
    private Stage stage;

    public SeleksiUnhas(Stage stage) {
        this.stage = stage;
    }

    //Membuat method show
    public void show() {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(50));

        // Buat Tabel
        TableView<SeleksiData> table = new TableView<>();
        table.setPrefWidth(600);
        table.setPrefHeight(400);

        // Buat Kolom
        TableColumn<SeleksiData, String> seleksiColumn = new TableColumn<>("Seleksi Masuk");
        seleksiColumn.setCellValueFactory(new PropertyValueFactory<>("seleksiMasuk"));
        seleksiColumn.setPrefWidth(100);

        TableColumn<SeleksiData, String> biayaColumn = new TableColumn<>("Biaya Pendaftaran");
        biayaColumn.setCellValueFactory(new PropertyValueFactory<>("biayaPendaftaran"));
        biayaColumn.setPrefWidth(200);

        TableColumn<SeleksiData, String> waktuColumn = new TableColumn<>("Waktu Pelaksanaan");
        waktuColumn.setCellValueFactory(new PropertyValueFactory<>("waktuPelaksanaan"));
        waktuColumn.setPrefWidth(250);

        table.getColumns().addAll(seleksiColumn, biayaColumn, waktuColumn);

        // Menambahkan data ke tabel
        List<SeleksiData> seleksiDataList = Arrays.asList(
                new SeleksiData("SNBP", "GRATIS", "14 Februari 2023"),
                new SeleksiData("SNBT", "Rp. 200.000", "08 Mei 2023"),
                new SeleksiData("JNS", "Rp. 1.000.000", "30 Juni 2023"),
                new SeleksiData("POSK", "Gratis", "30 Juni 2023")
        );
        table.setItems(FXCollections.observableList(seleksiDataList));
        vbox.getChildren().add(table);

        // Membuat button back
        Button backButton = new Button("Back");
        backButton.setId("seleksi_unhas_button");
        backButton.setOnAction(e -> {
            Unhas UI = new Unhas(stage);
            UI.show();
        });

        //Mengatur Vbox
        vbox.getChildren().add(backButton);

        //Menambahkan gambar sebagai backround
        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/UnhasBackDesign.png"));
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        Background background = new Background(backgroundImg);
        vbox.setBackground(background);

        //Mengatur stage 
        Scene scene = new Scene(vbox, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    // Data class for seleksi
    public static class SeleksiData {
        //Deklarasikan atribut
        private String seleksiMasuk;
        private String biayaPendaftaran;
        private String waktuPelaksanaan;

        //Adanya Konstruktor
        public SeleksiData(String seleksiMasuk, String biayaPendaftaran, String waktuPelaksanaan) {
            this.seleksiMasuk = seleksiMasuk;
            this.biayaPendaftaran = biayaPendaftaran;
            this.waktuPelaksanaan = waktuPelaksanaan;
        }
        //Menambahkan get
        public String getSeleksiMasuk() {
            return seleksiMasuk;
        }

        public String getBiayaPendaftaran() {
            return biayaPendaftaran;
        }

        public String getWaktuPelaksanaan() {
            return waktuPelaksanaan;
        }
    }
}
