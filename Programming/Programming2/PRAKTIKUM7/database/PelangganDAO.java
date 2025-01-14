package PRAKTIKUM7.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Random;

import PRAKTIKUM7.model.Pelanggan;

public class PelangganDAO {
    public static ObservableList<Pelanggan> getAllPelanggan() throws Exception {
        ObservableList<Pelanggan> daftarPelanggan = FXCollections.observableArrayList();
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PELANGGAN");
            ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                String pelanggan_id = rs.getString("PELANGGAN_ID");
                String nama = rs.getString("NAMA");
                String email = rs.getString("EMAIL");
                String nomorTelepon = rs.getString("TELEPON");
                
                daftarPelanggan.add(new Pelanggan(pelanggan_id, nama, email, nomorTelepon));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daftarPelanggan;
    }

    public static void addPelanggan(Pelanggan pelanggan) throws Exception {
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO PELANGGAN (PELANGGAN_ID, NAMA, EMAIL, TELEPON) VALUES (?, ?, ?, ?)"
            )){

            stmt.setString(1, pelanggan.getPelanggan_id());
            stmt.setString(2, pelanggan.getNama());
            stmt.setString(3, pelanggan.getEmail());
            stmt.setString(4, pelanggan.getNomor_telepon());

            stmt.executeUpdate();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePelanggan(Pelanggan pelanggan) throws Exception {
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(
            "UPDATE PELANGGAN SET NAMA = ?, EMAIL = ?, TELEPON = ? WHERE PELANGGAN_ID = ?"
            )){

            stmt.setString(1, pelanggan.getNama());
            stmt.setString(2, pelanggan.getEmail());
            stmt.setString(3, pelanggan.getNomor_telepon());
            stmt.setString(4, pelanggan.getPelanggan_id());

            stmt.executeUpdate();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePelanggan(Pelanggan pelanggan) throws Exception {
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(
            "DELETE FROM PELANGGAN WHERE PELANGGAN_ID = ?"
            )){

            stmt.setString(1,pelanggan.getPelanggan_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String IDPelangganGenerator() throws Exception{
        String generatedID;
        boolean isUnique;

        do {
            generatedID = "CST" + String.format("%03d", new Random().nextInt(1000));

            isUnique = checkUnique(generatedID);
        } while (!isUnique); 

        return generatedID; 
    }

    private static boolean checkUnique(String ID) throws Exception{
        String query = "SELECT COUNT(*) FROM PELANGGAN WHERE PELANGGAN_ID = ?";
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
