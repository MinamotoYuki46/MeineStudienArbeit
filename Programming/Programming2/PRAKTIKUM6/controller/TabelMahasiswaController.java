package PRAKTIKUM6.controller;

import PRAKTIKUM6.model.Mahasiswa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class TabelMahasiswaController {

    @FXML private TableView<Mahasiswa> tabelMahasiswa;
    @FXML private TableColumn<Mahasiswa, String> nimColumn, namaColumn;

    private ObservableList<Mahasiswa> daftarMahasiswa;

    public void initialize(){
        nimColumn.setCellValueFactory(new PropertyValueFactory<>("nim"));
        namaColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));

        daftarMahasiswa = FXCollections.observableArrayList(
            new Mahasiswa(1, "Ibnu Fulan", "A1234124"),
            new Mahasiswa(2, "Rick Astley", "B2432351"),
            new Mahasiswa(3, "Uvuvwevwe Onyetenyevwe Ugwemuhwem Osas", "C9876543"),
            new Mahasiswa(4, "John Smith", "D5637281"),
            new Mahasiswa(5, "Muhammad Sumbul", "E1123581"),
            new Mahasiswa(6, "Freedie Mercury", "F4455667"),
            new Mahasiswa(7, "Mikhail Ivanov", "G9871234"),
            new Mahasiswa(8, "Li Wei", "H5678432"),
            new Mahasiswa(9, "Feliks Zemdegs", "I6789012"),
            new Mahasiswa(10, "Palui", "J4321098")
        );
        tabelMahasiswa.setItems(daftarMahasiswa);
    }
}