package Educatum.AboutUNI.UNHAS;

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
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Educatum.Utils.DatabaseConfig;

public class JurusanUnhas {

    //Deklarasikan atribut
    private Stage stage;
    private Connection conn;
    private java.sql.Statement stmt;
    
    //Membuat contruktor
    public JurusanUnhas(Stage stage) {
        this.stage = stage;
    }

    //Membuat method show
    public void show() {
        //Membuat gridpane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(50));

        //Membuat button back
        Button jurusanButton = createButton("Back");
        jurusanButton.setStyle("-fx-text-fill: black;");
        jurusanButton.setId("unhasbuttonjur");
        jurusanButton.setOnAction(e -> {
            Unhas unhas = new Unhas(stage);
            unhas.show();
        });

        //menambahkan image sebagai backround
        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/UnhasBackDesign.png"));

            BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        Background background = new Background(backgroundImg);
        gridPane.setBackground(background);

        //Menambahkan tabel
        TableView<JurusanData> jurusanTable = createJurusanTable();

        //Mengatur tata letak
        gridPane.add(jurusanButton, 0, 0);
        gridPane.add(jurusanTable, 0, 1);

        //Mengatur stage
        Scene scene = new Scene(gridPane, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    //membuat create button
    private Button createButton(String buttonText) {
        Button button = new Button(buttonText);
        button.setStyle("-fx-background-color: transparent;");
        button.setTextFill(Color.BLACK);
        return button;
    }

    //Membuat table view
    private TableView<JurusanData> createJurusanTable() {
        TableView<JurusanData> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //Mengatur tabel kolom jurusan
        TableColumn<JurusanData, String> jurusanColumn = new TableColumn<>("Jurusan");
        jurusanColumn.setCellValueFactory(new PropertyValueFactory<>("jurusan"));
        jurusanColumn.setPrefWidth(300);

        //Mengatur tabel kolom fakultas
        TableColumn<JurusanData, String> fakultasColumn = new TableColumn<>("Fakultas");
        fakultasColumn.setCellValueFactory(new PropertyValueFactory<>("fakultas"));
        fakultasColumn.setPrefWidth(400);

        //Menggabungkan kolom jurusan dan fakultas
        table.getColumns().addAll(jurusanColumn, fakultasColumn);

        try {
            List<JurusanData> jurusanDataList = new ArrayList<>();
            conn = DatabaseConfig.getConnection();
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM jurusan WHERE KAMPUS='UNHAS' ORDER BY ID");
            while (rs.next()) {
                String jurusan = rs.getString("JURUSAN");
                String fakultas = rs.getString("FAKULTAS");
                jurusanDataList.add(new JurusanData(jurusan, fakultas));
            }
            table.getItems().addAll(jurusanDataList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return table;
    }

    //Membuat data
    public static class JurusanData {
        //Deklarasikan atribut
        private String jurusan;
        private String fakultas;

        //Membuat Contructor
        public JurusanData(String jurusan, String fakultas) {
            this.jurusan = jurusan;
            this.fakultas = fakultas;
        }

        //Menambahkan getter
        public String getJurusan() {
            return jurusan;
        }

        public String getFakultas() {
            return fakultas;
        }
    }
}
