package PRAKTIKUM7.controller;

import java.sql.*;
import java.util.Optional;

import PRAKTIKUM7.database.*;
import PRAKTIKUM7.model.*;
import javafx.fxml.FXML;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class MainController {
    // Buku 
    @FXML private TableView<Buku> tbvTabelBuku;
    @FXML private TableColumn<Buku, String> tbcJudulBuku,tbcPenulisBuku,tbcHargaBuku, tbcStokBuku;
    @FXML private TextField txfJudulBuku, txfPenulisBuku, txfHargaBuku, txfStokBuku;
    @FXML private Button btnAddBuku, btnUpdateBuku, btnDeleteBuku;
    private ObservableList<Buku> daftarBuku;

    // Pelanggan
    @FXML private TableView<Pelanggan> tbvTabelPelanggan;
    @FXML private TableColumn<Pelanggan, String> tbcNamaPelanggan, tbcEmailPelanggan, tbcNomorTeleponPelanggan;
    @FXML private TextField txfNamaPelanggan, txfEmailPelanggan, txfNomorTeleponPelanggan;
    @FXML private Button btnAddPelanggan, btnUpdatePelanggan, btnDeletePelanggan;
    private ObservableList<Pelanggan> daftarPelanggan;

    // Transaksi
    @FXML private TableView<Penjualan> tbvTabelTransaksi;
    @FXML private TableColumn<Penjualan, String> tbcNamaTransaksi, tbcBukuTransaksi, tbcKuantitasTransaksi, tbcTotalHargaTransaksi;
    @FXML private ComboBox<String> cmbNamaTransaksi, cmbBukuTransaksi;
    @FXML private TextField txfKuantitasTransaksi;
    @FXML private Button btnAddTransaksi, btnUpdateTransaksi, btnDeleteTransaksi;
    private ObservableList<Penjualan> daftarTransaksi;

    @FXML
    public void initialize() {
        try {
            tbcJudulBuku.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJudul()));
            tbcPenulisBuku.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPenulis()));
            tbcHargaBuku.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHargaStr()));
            tbcStokBuku.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStokStr()));

            tbcNamaPelanggan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNama()));
            tbcEmailPelanggan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
            tbcNomorTeleponPelanggan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNomor_telepon()));

            tbcNamaTransaksi.setCellValueFactory(cellData -> {
                try {
                    return new SimpleStringProperty(getNamaPelanggan(cellData.getValue().getPelanggan_id()));
                } catch (Exception e) {
                    e.printStackTrace();
                    return new SimpleStringProperty("Tidak diketahui");
                }
            });
            tbcBukuTransaksi.setCellValueFactory(cellData -> {
                try {
                    return new SimpleStringProperty(getJudulBuku(cellData.getValue().getBuku_id()));
                } catch (Exception e) {
                    e.printStackTrace();
                    return new SimpleStringProperty("Tidak diketahui");
                }
            });
            tbcKuantitasTransaksi.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJumlahStr()));
            tbcTotalHargaTransaksi.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTotal_hargaStr()));

            loadDatabase();  
            loadComboBox();
            
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("ERROR", "Eror", "Database Eror", "Terjadi kesalahan saat memuat data");
        }
        tbvTabelBuku.setOnMouseClicked(event -> pilihBuku());
        tbvTabelPelanggan.setOnMouseClicked(event -> pilihPelanggan());
        tbvTabelTransaksi.setOnMouseClicked(event -> {
            try {
                pilihPenjualan();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void loadComboBox() throws Exception{
        try {
            ObservableList<String> dataNama = getDataComboBox("pelanggan");
            ObservableList<String> dataJudul = getDataComboBox("buku");

            cmbNamaTransaksi.setItems(dataNama);
            cmbBukuTransaksi.setItems(dataJudul);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ObservableList<String> getDataComboBox(String key) throws Exception{
        ObservableList<String> data = FXCollections.observableArrayList();
        String query = "";

        if (key.equals("pelanggan")) {
            query = "SELECT NAMA FROM PELANGGAN";
        } else if (key.equals("buku")) {
            query = "SELECT JUDUL FROM BUKU";
        } else {
            throw new IllegalArgumentException("Invalid key: " + key);
        }

        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
        ) {
            while(rs.next()){
                data.add(rs.getString(1));
            }
        } 
        catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }

    private void loadDatabase() throws Exception{
        try {
            daftarBuku = BukuDAO.getAllBuku();  
            tbvTabelBuku.setItems(daftarBuku);

            daftarPelanggan = PelangganDAO.getAllPelanggan();
            tbvTabelPelanggan.setItems(daftarPelanggan);

            daftarTransaksi = PenjualanDAO.getAllPenjualan();
            tbvTabelTransaksi.setItems(daftarTransaksi);


        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("ERROR", "Eror", "Database Eror", "Terjadi kesalahan saat memuat data buku");
        }
    }

    private void showAlert(String type, String title, String header, String message){
        Alert.AlertType alertType;
    
        switch (type.toLowerCase()) {
            case "information":
                alertType = Alert.AlertType.INFORMATION;
                break;
            case "warning":
                alertType = Alert.AlertType.WARNING;
                break;
            case "error":
                alertType = Alert.AlertType.ERROR;
                break;
            case "confirmation":
                alertType = Alert.AlertType.CONFIRMATION;
                break;
            default:
                alertType = Alert.AlertType.NONE; 
                break;
        }

        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML private void pilihBuku() {
        Buku selectedBuku = tbvTabelBuku.getSelectionModel().getSelectedItem();

        if (selectedBuku != null) {
            txfJudulBuku.setText(selectedBuku.getJudul());
            txfPenulisBuku.setText(selectedBuku.getPenulis());
            txfHargaBuku.setText(String.valueOf(selectedBuku.getHarga()));
            txfStokBuku.setText(String.valueOf(selectedBuku.getStok()));
        }
    }

    @FXML private void pilihPelanggan() {
        Pelanggan selectedPelanggan = tbvTabelPelanggan.getSelectionModel().getSelectedItem();

        if (selectedPelanggan != null) {
            txfNamaPelanggan.setText(selectedPelanggan.getNama());
            txfEmailPelanggan.setText(selectedPelanggan.getEmail());
            txfNomorTeleponPelanggan.setText(String.valueOf(selectedPelanggan.getNomor_telepon()));
        }
    }

    @FXML private void pilihPenjualan() throws Exception {
        Penjualan selectedTransaksi = tbvTabelTransaksi.getSelectionModel().getSelectedItem();

        if (selectedTransaksi != null) {
            cmbNamaTransaksi.setValue(getNamaPelanggan(selectedTransaksi.getPelanggan_id()));
            cmbBukuTransaksi.setValue(getJudulBuku(selectedTransaksi.getBuku_id()));
            txfKuantitasTransaksi.setText(String.valueOf(selectedTransaksi.getJumlah()));
        }
    }

    private String getNamaPelanggan(String pelanggan_id) throws Exception{
        String namaPelanggan = null;

        String query = "SELECT NAMA FROM PELANGGAN WHERE PELANGGAN_ID = ?";
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, pelanggan_id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    namaPelanggan = rs.getString("NAMA");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        }

        return namaPelanggan;
    }

    private String getIDPelanggan(String namaPelanggan) throws Exception{
        String IDPelanggan = null;

        String query = "SELECT PELANGGAN_ID FROM PELANGGAN WHERE NAMA = ?";
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, namaPelanggan);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    IDPelanggan = rs.getString("PELANGGAN_ID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        }

        return IDPelanggan;
    }

    private String getJudulBuku(String buku_id) throws Exception{
        String judulBuku = null;

        String query = "SELECT JUDUL FROM BUKU WHERE BUKU_ID = ?";
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, buku_id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    judulBuku = rs.getString("JUDUL");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        }

        return judulBuku;
    }

    private String getIDBuku(String judulBuku) throws Exception{
        String IDBuku = null;

        String query = "SELECT BUKU_ID FROM BUKU WHERE JUDUL = ?";
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, judulBuku);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    IDBuku = rs.getString("BUKU_ID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        }

        return IDBuku;
    }

    private int getStokBuku(String buku_id) throws Exception {
        int stok = 0;
    
        String query = "SELECT STOK FROM BUKU WHERE BUKU_ID = ?";
        
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, buku_id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    stok = rs.getInt("STOK");
                } else {
                    throw new Exception("Buku dengan ID " + buku_id + " tidak ditemukan.");
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Eror saat mengakses database.", e);
        }
    
        return stok;
    }
    

    @FXML private void tambahBuku() throws Exception {
        String judul = txfJudulBuku.getText();
        String penulis = txfPenulisBuku.getText();
        String harga = txfHargaBuku.getText();
        String stok = txfStokBuku.getText();
        
        if (judul.isEmpty() || penulis.isEmpty() || harga.isEmpty() || stok.isEmpty()) {
            showAlert("ERROR", "Kesalahan Input", "", "Data yang dimasukkan belum lengkap!");
            return;
        }
        else if (Double.parseDouble(harga) <= 0){
            showAlert("ERROR", "Kesalahan Input", "", "Harga yang dimasukkan harus bernilai positif");
            return;
        }
        else if (Integer.parseInt(stok) <= 0){
            showAlert("ERROR", "Kesalahan Input", "", "Jumlah stok yang dimasukkan harus bernilai positif");
            return;
        }

        try {
            String IDBuku = BukuDAO.IDBukuGenerator();
            double hargaBuku = Double.parseDouble(harga);
            int stokBuku = Integer.parseInt(stok);

            Buku newBuku = new Buku(IDBuku, judul, penulis, hargaBuku, stokBuku);
            BukuDAO.addBuku(newBuku); 
            loadDatabase();
            loadComboBox();
        } 
        catch (NumberFormatException e) {
            showAlert("ERROR","Kesalahan Input", "", "Harga dan stok harus berupa numerik");
        } 
        catch (SQLException e) {
            e.printStackTrace();
            showAlert("ERROR", "Database Eror", "", "Gagal menambah buku");
        }
    }

    @FXML private void editBuku() throws Exception{
        Buku selectedBuku = tbvTabelBuku.getSelectionModel().getSelectedItem();
    
        if (selectedBuku != null) {
            String judul = txfJudulBuku.getText();
            String penulis = txfPenulisBuku.getText();
            String harga = txfHargaBuku.getText();
            String stok = txfStokBuku.getText();

            if (judul.isEmpty() || penulis.isEmpty() || harga.isEmpty() || stok.isEmpty()) {
                showAlert("ERROR", "Kesalahan Input", "", "Data yang dimasukkan belum lengkap!");
                return;
            }
            else if (Double.parseDouble(harga) <= 0){
                showAlert("ERROR", "Kesalahan Input", "", "Harga yang dimasukkan harus bernilai positif.");
                return;
            }
            else if (Integer.parseInt(stok) <= 0){
                showAlert("ERROR", "Kesalahan Input", "", "Jumlah stok yang dimasukkan harus bernilai positif.");
                return;
            }

            try {
                selectedBuku.setJudul(judul);
                selectedBuku.setPenulis(penulis);
                selectedBuku.setHarga(Double.parseDouble(harga));
                selectedBuku.setStok(Integer.parseInt(stok));

                BukuDAO.updateBuku(selectedBuku); 
                loadDatabase(); 
                loadComboBox();
            } 
            catch (NumberFormatException e) {
                showAlert("ERROR","Kesalahan Input", "", "Harga dan stok harus berupa numerik.");
            } 
            catch (SQLException e) {
                e.printStackTrace();
                showAlert("ERROR", "Database Eror", "", "Gagal mengubah data buku.");
            }
        }
    }

    @FXML private void hapusBuku() throws Exception{
        Buku selectedBuku = tbvTabelBuku.getSelectionModel().getSelectedItem();

        if (selectedBuku != null) {
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Konfirmasi Penghapusan Buku");
            confirmationAlert.setHeaderText("Apakah Anda yakin untuk menghapus buku ini?");
            confirmationAlert.setContentText("Tindakan ini tidak dapat dibatalkan.");

            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    BukuDAO.deleteBuku(selectedBuku); 
                    loadDatabase(); 
                    loadComboBox();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                    showAlert("ERROR", "Database Eror", "", "Gagal menghapus buku.");
                }
            }
        } else {
            showAlert("ERROR", "Tidak ada buku terpilih", "", "Silahkan pilih buku yang ingin dihapus!");
        }
    }

    @FXML private void tambahPelanggan() throws Exception {
        String nama = txfNamaPelanggan.getText();
        String email = txfEmailPelanggan.getText();
        String noTelepon = txfNomorTeleponPelanggan.getText();
        
        if (nama.isEmpty() || email.isEmpty() || noTelepon.isEmpty()) {
            showAlert("ERROR", "Kesalahan Input", "", "Data yang dimasukkan belum lengkap!");
            return;
        }
        

        try {
            String IDPelanggan = PelangganDAO.IDPelangganGenerator();
            
            Pelanggan pelanggan = new Pelanggan(IDPelanggan, nama, email, noTelepon);
            PelangganDAO.addPelanggan(pelanggan); 
            loadDatabase();
            loadComboBox();
        } 
        catch (SQLException e) {
            e.printStackTrace();
            showAlert("ERROR", "Database Eror", "", "Gagal menambahkan pelanggan.");
        }
    }

    @FXML private void editPelanggan() throws Exception{
        Pelanggan selectedPelanggan = tbvTabelPelanggan.getSelectionModel().getSelectedItem();
    
        if (selectedPelanggan != null) {
            String nama = txfNamaPelanggan.getText();
            String email = txfEmailPelanggan.getText();
            String noTelepon = txfNomorTeleponPelanggan.getText();

            if (nama.isEmpty() || email.isEmpty() || noTelepon.isEmpty()) {
                showAlert("ERROR", "Kesalahan Input", "", "Data yang dimasukkan belum lengkap!");
                return;
            }

            try {
                selectedPelanggan.setNama(nama);
                selectedPelanggan.setEmail(email);
                selectedPelanggan.setNomor_telepon(noTelepon);

                PelangganDAO.updatePelanggan(selectedPelanggan); 
                loadDatabase(); 
                loadComboBox();
            } 
            catch (SQLException e) {
                e.printStackTrace();
                showAlert("ERROR", "Database Eror", "", "Gagal mengubah data pelanggan.");
            }
        }
    }

    @FXML private void hapusPelanggan() throws Exception{
        Pelanggan selectedPelanggan = tbvTabelPelanggan.getSelectionModel().getSelectedItem();
    
        if (selectedPelanggan != null) {
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Konfirmasi Penghapusan Pelanggan");
            confirmationAlert.setHeaderText("Apakah Anda yakin untuk menghapus pelanggan ini?");
            confirmationAlert.setContentText("Tindakan ini tidak dapat dibatalkan.");

            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    PelangganDAO.deletePelanggan(selectedPelanggan); 
                    loadDatabase(); 
                    loadComboBox();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                    showAlert("ERROR", "Database Eror", "", "Gagal menghapus pelanggan.");
                }
            }
        } else {
            showAlert("ERROR", "Tidak ada pelanggan terpilih", "", "Silahkan pilih pelanggan yang ingin dihapus!");
        }
    }

    @FXML private void tambahTransaksi() throws Exception{
        String namaPelanggan = cmbNamaTransaksi.getValue();
        String judulBuku = cmbBukuTransaksi.getValue();
        String kuantitas = txfKuantitasTransaksi.getText(); 

        

        if (namaPelanggan == null || judulBuku == null || kuantitas.isEmpty()) {
            throw new IllegalArgumentException("Semua field harus diisi.");
        }

        else if (Integer.parseInt(kuantitas) <= 0){
            showAlert("ERROR", "Kesalahan Input", "", "Jumlah stok yang dimasukkan harus bernilai positif");
            return;
        }

        else if (Integer.parseInt(kuantitas) > getStokBuku(getIDBuku(judulBuku))){
            showAlert("ERROR", "Kesalahan Input", "", "Jumlah kuantitas yang dimasukkan melebihi stok yang ada!");
            return;
        }

        try {
            String IDPenjualan = PenjualanDAO.IDPenjualanGenerator();
            String IDBuku = getIDBuku(judulBuku);
            String IDPelanggan = getIDPelanggan(namaPelanggan);
            int jumlah = Integer.parseInt(kuantitas);
            double totalHarga = hitungTotalHarga(IDBuku, jumlah);

            Penjualan transaksi = new Penjualan(IDPenjualan, jumlah, totalHarga, IDPelanggan, IDBuku);
            PenjualanDAO.addPenjualan(transaksi);
            hitungSisaStok(IDBuku, 0, jumlah);
            loadDatabase();
            loadComboBox();
        } 
        
        catch (NumberFormatException e) {
            showAlert("ERROR","Kesalahan Input", "", "Kuantitas harus berupa numerik.");
        } 
        catch (SQLException e) {
            e.printStackTrace();
            showAlert("ERROR", "Database Eror", "", "Gagal menambahkan transaksi.");
        }
    }

    @FXML private void editTransaksi() throws Exception{
        Penjualan selectedTransaksi = tbvTabelTransaksi.getSelectionModel().getSelectedItem();

        if(selectedTransaksi != null){
            String namaPelanggan = cmbNamaTransaksi.getValue();
            String judulBuku = cmbBukuTransaksi.getValue();
            String kuantitas = txfKuantitasTransaksi.getText(); 

            if (namaPelanggan == null || judulBuku == null || kuantitas.isEmpty()) {
                throw new IllegalArgumentException("Semua field harus diisi.");
            }
    
            else if (Integer.parseInt(kuantitas) <= 0){
                showAlert("ERROR", "Kesalahan Input", "", "Jumlah stok yang dimasukkan harus bernilai positif");
                return;
            }
    
            else if (Integer.parseInt(kuantitas) > getStokBuku(getIDBuku(judulBuku))){
                showAlert("ERROR", "Kesalahan Input", "", "Jumlah kuantitas yang dimasukkan melebihi stok yang ada!");
                return;
            }
    
            try {
                String IDBuku = getIDBuku(judulBuku);
                String IDPelanggan = getIDPelanggan(namaPelanggan);
                int jumlah = Integer.parseInt(kuantitas);
                double totalHarga = hitungTotalHarga(IDBuku, jumlah);;
                
                hitungSisaStok(IDBuku, selectedTransaksi.getJumlah(), jumlah);

                selectedTransaksi.setBuku_id(IDBuku);
                selectedTransaksi.setPelanggan_id(IDPelanggan);
                selectedTransaksi.setJumlah(jumlah);
                selectedTransaksi.setTotal_harga(totalHarga);
    
                PenjualanDAO.updatePenjualan(selectedTransaksi);
                loadDatabase();
                loadComboBox();
            } 
            
            catch (NumberFormatException e) {
                showAlert("ERROR","Kesalahan Input", "", "Kuantitas harus berupa numerik.");
            } 
            catch (SQLException e) {
                e.printStackTrace();
                showAlert("ERROR", "Database Eror", "", "Gagal mengubah data transaksi.");
            }
        }
        
    }

    @FXML private void hapusTransaksi() throws Exception{
        Penjualan selectedTransaksi = tbvTabelTransaksi.getSelectionModel().getSelectedItem();
    
        if (selectedTransaksi != null) {
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Konfirmasi Penghapusan Transaksi");
            confirmationAlert.setHeaderText("Apakah Anda yakin untuk menghapus transaksi ini?");
            confirmationAlert.setContentText("Tindakan ini tidak dapat dibatalkan.");

            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    hitungSisaStok(selectedTransaksi.getBuku_id(), 0, -selectedTransaksi.getJumlah());
                    PenjualanDAO.deletePenjualan(selectedTransaksi); 
                    loadDatabase();
                    loadComboBox(); 
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                    showAlert("ERROR", "Database Eror", "", "Gagal menghapus transaksi.");
                }
            }
        } else {
            showAlert("ERROR", "Tidak ada transaksi terpilih", "", "Silahkan pilih transaksi yang ingin dihapus!");
        }
    }

    private double hitungTotalHarga(String IDBuku, int jumlah) throws Exception{
        double harga = 0;

        String query = "SELECT HARGA FROM BUKU WHERE BUKU_ID = ?";
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, IDBuku);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    harga = rs.getDouble("HARGA");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        }

        return harga * jumlah;
    }

    private void hitungSisaStok(String buku_id, int curStok, int newStok) throws Exception{
        int sisaStok = curStok;
        String getStok = "SELECT STOK FROM BUKU WHERE BUKU_ID = ?";
        String setStok = "UPDATE BUKU SET STOK = ? WHERE BUKU_ID = ?";

        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmtGet = conn.prepareStatement(getStok);
            PreparedStatement stmtSet = conn.prepareStatement(setStok);
        ){
            stmtGet.setString(1, buku_id);
            try (ResultSet rs = stmtGet.executeQuery()){
                if (rs.next()){
                    sisaStok += rs.getInt("STOK");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            sisaStok -= newStok;

            if(sisaStok < 0){
                throw new IllegalArgumentException("Stok habis!");
            }

            stmtSet.setInt(1, sisaStok);
            stmtSet.setString(2, buku_id);
            stmtSet.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Gagal memperbarui stok buku.", e);
        }
    }
}
