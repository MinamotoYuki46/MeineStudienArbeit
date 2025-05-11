<?php 
    require_once '../config/koneksi.php'; 
    require_once '../models/Peminjaman.php';

    class PeminjamanDAO {
        private $db;

        public function __construct() {
            global $conn;
            $this -> db = $conn;
        }

        public function getAllPeminjaman(): array {
            $loanList = [];
            try {
                $stmt = $this -> db -> prepare("SELECT * FROM PEMINJAMAN");
                $stmt -> execute();
                $rows = $stmt -> fetchAll(PDO::FETCH_ASSOC);

                foreach ($rows as $row) {
                    $loanList[] = new Peminjaman(
                        $row['ID_PEMINJAMAN'],
                        $row['ID_MEMBER'],
                        $row['ID_BUKU'],
                        $row['TGL_PINJAM'],
                        $row['TGL_KEMBALI']
                    );
                }
            } catch (PDOException $e) {
                error_log("Error fetching borrowing: " . $e -> getMessage());
            }

            return $loanList;
        }

        public function getPeminjaman(string $id): ?Peminjaman {
            try {
                $stmt = $this -> db -> prepare("SELECT * FROM PEMINJAMAN WHERE ID_PEMINJAMAN = ?");
                $stmt -> execute([$id]);
                $row = $stmt -> fetch(PDO::FETCH_ASSOC);

                if ($row) {
                    return new Peminjaman(
                        $row['ID_PEMINJAMAN'],
                        $row['ID_MEMBER'],
                        $row['ID_BUKU'],
                        $row['TGL_PINJAM'],
                        $row['TGL_KEMBALI']
                    );
                }
            } catch (PDOException $e) {
                error_log("Error fetching borrowing by ID: " . $e -> getMessage());
            }

            return null;
        }

        public function addPeminjaman(Peminjaman $peminjaman): bool {
            try {
                $stmt = $this -> db -> prepare("
                    INSERT INTO PEMINJAMAN (ID_MEMBER, ID_BUKU, TGL_PINJAM, TGL_KEMBALI)
                    VALUES (?, ?, ?, ?)
                ");

                return $stmt -> execute([
                    $peminjaman -> getIdMember(),
                    $peminjaman -> getIdBuku(),
                    $peminjaman -> getTglPinjam(),
                    $peminjaman -> getTglKembali()
                ]);
            } catch (PDOException $e) {
                error_log("Error inserting borrowing: " . $e -> getMessage());
                return false;
            }
        }

        public function updatePeminjaman(Peminjaman $peminjaman): bool {
            try {
                $stmt = $this -> db -> prepare("
                    UPDATE PEMINJAMAN 
                    SET ID_MEMBER = ?, ID_BUKU = ?, TGL_PINJAM = ?, TGL_KEMBALI = ?
                    WHERE ID_PEMINJAMAN = ?
                ");

                return $stmt -> execute([
                    $peminjaman -> getIdMember(),
                    $peminjaman -> getIdBuku(),
                    $peminjaman -> getTglPinjam(),
                    $peminjaman -> getTglKembali(),
                    $peminjaman -> getIdPeminjaman()
                ]);
            } catch (PDOException $e) {
                error_log("Error updating borrowing: " . $e -> getMessage());
                return false;
            }
        }

        public function deletePeminjaman(Peminjaman $peminjaman): bool {
            try {
                $stmt = $this -> db -> prepare("DELETE FROM PEMINJAMAN WHERE ID_PEMINJAMAN = ?");
                return $stmt -> execute([$peminjaman -> getIdPeminjaman()]);
            } catch (PDOException $e) {
                error_log("Error deleting borrowing: " . $e -> getMessage());
                return false;
            }
        }
    }
?>