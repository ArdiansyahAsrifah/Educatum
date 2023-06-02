package Educatum.AboutUNI.UGM;

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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Educatum.Utils.DatabaseConfig;

public class JurusanUGM {
    private Stage stage;
    private Connection conn;
    private Statement stmt;
   

    public JurusanUGM(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(50));

        Button jurusanButton = createButton("Back");
        jurusanButton.setId("jurusan-ugm");
        jurusanButton.setStyle("-fx-text-fill: black;");
        jurusanButton.setOnAction(e -> {
            Ugm ui = new Ugm(stage);
            ui.show();
        });

        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/AboutUNIUGM2.png"));

            BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        Background background = new Background(backgroundImg);
        gridPane.setBackground(background);

        TableView<JurusanData> jurusanTable = createJurusanTable();

        gridPane.add(jurusanButton, 0, 0);
        gridPane.add(jurusanTable, 0, 1);

        Scene scene = new Scene(gridPane, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    private Button createButton(String buttonText) {
        Button button = new Button(buttonText);
        button.setStyle("-fx-background-color: transparent;");
        button.setTextFill(Color.BLACK);
        return button;
    }

    private TableView<JurusanData> createJurusanTable() {
        TableView<JurusanData> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<JurusanData, String> jurusanColumn = new TableColumn<>("Jurusan");
        jurusanColumn.setCellValueFactory(new PropertyValueFactory<>("jurusan"));
        jurusanColumn.setPrefWidth(300);

        TableColumn<JurusanData, String> fakultasColumn = new TableColumn<>("Fakultas");
        fakultasColumn.setCellValueFactory(new PropertyValueFactory<>("fakultas"));
        fakultasColumn.setPrefWidth(400);

        table.getColumns().addAll(jurusanColumn, fakultasColumn);

        try {
            List<JurusanData> jurusanDataList = new ArrayList<>();
            conn = DatabaseConfig.getConnection();
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM jurusan WHERE KAMPUS='UGM' ORDER BY ID");
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

    public static class JurusanData {
        private String jurusan;
        private String fakultas;

        public JurusanData(String jurusan, String fakultas) {
            this.jurusan = jurusan;
            this.fakultas = fakultas;
        }

        public String getJurusan() {
            return jurusan;
        }

        public String getFakultas() {
            return fakultas;
        }
    }
}
