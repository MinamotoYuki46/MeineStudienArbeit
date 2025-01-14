package PRAKTIKUM7.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Random;

import PRAKTIKUM7.model.Penjualan;

public class PenjualanDAO {
    public static ObservableList<Penjualan> getAllPenjualan() throws Exception {
        ObservableList<Penjualan> daftarPenjualan = FXCollections.observableArrayList();
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PENJUALAN");
            ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                String penjualan_id = rs.getString("PENJUALAN_ID");
                Integer jumlah = rs.getInt("JUMLAH");
                Double totalHarga = rs.getDouble("TOTAL_HARGA");
                String pelanggan_id = rs.getString("PELANGGAN_ID");
                String buku_id = rs.getString("BUKU_ID");
                
                daftarPenjualan.add(new Penjualan(penjualan_id, jumlah, totalHarga, pelanggan_id, buku_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daftarPenjualan;
    }

    public static void addPenjualan(Penjualan penjualan) throws Exception {
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO PENJUALAN (PENJUALAN_ID, JUMLAH, TOTAL_HARGA, PELANGGAN_ID, BUKU_ID) VALUES (?, ?, ?, ?, ?)"
            )){

            stmt.setString(1, penjualan.getPenjualan_id());
            stmt.setInt(2, penjualan.getJumlah());
            stmt.setDouble(3, penjualan.getTotal_harga());
            stmt.setString(4, penjualan.getPelanggan_id());
            stmt.setString(5, penjualan.getBuku_id());

            stmt.executeUpdate();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePenjualan(Penjualan penjualan) throws Exception {
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(
            "UPDATE PENJUALAN SET JUMLAH = ?, TOTAL_HARGA = ?, PELANGGAN_ID = ?, BUKU_ID = ? WHERE PENJUALAN_ID = ?"
            )){

            stmt.setInt(1, penjualan.getJumlah());
            stmt.setDouble(2, penjualan.getTotal_harga());
            stmt.setString(3, penjualan.getPelanggan_id());
            stmt.setString(4, penjualan.getBuku_id());
            stmt.setString(5, penjualan.getPenjualan_id());

            stmt.executeUpdate();
        } 
        catch (SQLException e) {
            e.printStackTrace();
    }
}

    public static void deletePenjualan(Penjualan penjualan) throws Exception {
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(
            "DELETE FROM PENJUALAN WHERE PENJUALAN_ID = ?"
            )){

            stmt.setString(1,penjualan.getPenjualan_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String IDPenjualanGenerator() throws Exception{
        String generatedID;
        boolean isUnique;

        do {
            generatedID = "TSC" + String.format("%03d", new Random().nextInt(1000));

            isUnique = checkUnique(generatedID);
        } while (!isUnique); 

        return generatedID; 
    }

    private static boolean checkUnique(String ID) throws Exception{
        String query = "SELECT COUNT(*) FROM PENJUALAN WHERE PENJUALAN_ID = ?";
        try (
            Connection connection = DBConnection.connect();
            PreparedStatement stmt = connection.prepareStatement(query)) {

                stmt.setString(1, ID);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count == 0; 
                }
            }
        }
        return false;
    }
}
