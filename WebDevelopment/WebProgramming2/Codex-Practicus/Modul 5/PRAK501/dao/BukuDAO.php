<?php 
    require_once '../config/koneksi.php'; 
    require_once '../models/Buku.php';

    class BukuDAO {
        private $db;

        public function __construct() {
            global $conn;
            $this -> db = $conn;
        }

        public function getAllBuku(): array {
            $bookList = [];
    
            try {
                $stmt = $this -> db -> prepare("SELECT * FROM BUKU");
                $stmt -> execute();
                $rows = $stmt -> fetchAll(PDO::FETCH_ASSOC);
    
                foreach ($rows as $row) {
                    $bookList[] = new Buku(
                        $row['ID_BUKU'],
                        $row['JUDUL_BUKU'],
                        $row['PENULIS'],
                        $row['PENERBIT'],
                        $row['TAHUN_TERBIT']
                    );
                }
            } catch (PDOException $e) {
                error_log("Error fetching books: " . $e -> getMessage());
            }
    
            return $bookList;
        }

        public function getBuku(string $id): ?Buku {
            try {
                $stmt = $this -> db -> prepare("SELECT * FROM BUKU WHERE ID_BUKU = ?");
                $stmt -> execute([$id]);
                $row = $stmt -> fetch(PDO::FETCH_ASSOC);
    
                if ($row) {
                    return new Buku(
                        $row['ID_BUKU'],
                        $row['JUDUL_BUKU'],
                        $row['PENULIS'],
                        $row['PENERBIT'],
                        $row['TAHUN_TERBIT']
                    );
                }
            } catch (PDOException $e) {
                error_log("Error fetching book by ID: " . $e -> getMessage());
            }
    
            return null;
        }

        public function addBuku(Buku $buku): bool {
            try {
                $stmt = $this -> db -> prepare("
                    INSERT INTO BUKU (JUDUL_BUKU, PENULIS, PENERBIT, TAHUN_TERBIT)
                    VALUES (?, ?, ?, ?)
                ");

                return $stmt -> execute([
                    $buku -> getJudulBuku(),
                    $buku -> getPenulis(),
                    $buku -> getPenerbit(),
                    $buku -> getTahunTerbit()
                ]);
            } catch (PDOException $e) {
                error_log("Error inserting book: " . $e -> getMessage());
                return false;
            }
        }

        public function updateBuku(Buku $buku): bool {
            try {
                $stmt = $this -> db -> prepare("
                    UPDATE BUKU 
                    SET JUDUL_BUKU = ?, PENULIS = ?, PENERBIT = ?, TAHUN_TERBIT = ?
                    WHERE ID_BUKU = ?
                ");
    
                return $stmt -> execute([
                    $buku -> getJudulBuku(),
                    $buku -> getPenulis(),
                    $buku -> getPenerbit(),
                    $buku -> getTahunTerbit(),
                    $buku -> getIdBuku()
                ]);
            } catch (PDOException $e) {
                error_log("Error updating book: " . $e -> getMessage());
                return false;
            }
        }

        public function deleteBuku(Buku $buku): bool {
            try {
                $stmt = $this -> db -> prepare("DELETE FROM BUKU WHERE ID_BUKU = ?");
                return $stmt -> execute([$buku -> getIdBuku()]);
            } catch (PDOException $e) {
                error_log("Error deleting book: " . $e -> getMessage());
                return false;
            }
        }  
    }
?>