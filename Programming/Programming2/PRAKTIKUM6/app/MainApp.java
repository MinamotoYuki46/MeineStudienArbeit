package PRAKTIKUM6.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    
        @Override
        public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/PRAKTIKUM6/view/TabelMahasiswaView.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Tabel Mahasiswa");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); 
    }
}
