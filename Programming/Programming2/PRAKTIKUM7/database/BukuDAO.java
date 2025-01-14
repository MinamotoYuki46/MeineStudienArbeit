package PRAKTIKUM7.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Random;

import PRAKTIKUM7.model.Buku;

public class BukuDAO {
    public static ObservableList<Buku> getAllBuku() throws Exception {
        ObservableList<Buku> daftarBuku = FXCollections.observableArrayList();
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM BUKU");
            ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                String buku_id = rs.getString("BUKU_ID");
                String judul = rs.getString("JUDUL");
                String penulis = rs.getString("PENULIS");
                Double harga = rs.getDouble("HARGA");
                Integer stok = rs.getInt("STOK");

                daftarBuku.add(new Buku(buku_id, judul, penulis, harga, stok));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daftarBuku;
    }

    public static void addBuku(Buku buku) throws Exception {
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO BUKU (BUKU_ID, JUDUL, PENULIS, HARGA, STOK) VALUES (?, ?, ?, ?, ?)"
            )){

            stmt.setString(1, buku.getIDBuku());
            stmt.setString(2, buku.getJudul());
            stmt.setString(3, buku.getPenulis());
            stmt.setDouble(4, buku.getHarga());
            stmt.setInt(5, buku.getStok());

            stmt.executeUpdate();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateBuku(Buku buku) throws Exception {
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(
            "UPDATE BUKU SET JUDUL = ?, PENULIS = ?, HARGA = ?, STOK = ? WHERE BUKU_ID = ?"
            )){

            stmt.setString(1, buku.getJudul());
            stmt.setString(2, buku.getPenulis());
            stmt.setDouble(3, buku.getHarga());
            stmt.setInt(4, buku.getStok());
            stmt.setString(5, buku.getIDBuku());

            stmt.executeUpdate();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBuku(Buku buku) throws Exception {
        try (
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(
            "DELETE FROM BUKU WHERE BUKU_ID = ?"
            )){

            stmt.setString(1, buku.getIDBuku());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String IDBukuGenerator() throws Exception{
        String generatedID;
        boolean isUnique;

        do {
            generatedID = "BK" + String.format("%03d", new Random().nextInt(1000));

            isUnique = checkUnique(generatedID);
        } while (!isUnique); 

        return generatedID; 
    }

    private static boolean checkUnique(String ID) throws Exception{
        String query = "SELECT COUNT(*) FROM BUKU WHERE BUKU_ID = ?";
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
