<?php 
    require_once '../config/koneksi.php'; 
    require_once '../models/Member.php';

    class MemberDAO {
        private $db;

        public function __construct() {
            global $conn;
            $this -> db = $conn;
        }

        public function getAllMember(): array {
            $memberList = [];

            try {
                $stmt = $this -> db -> prepare("SELECT * FROM MEMBER");
                $stmt -> execute();
                $rows = $stmt -> fetchAll(PDO::FETCH_ASSOC);

                foreach ($rows as $row) {
                    $memberList[] = new Member(
                        $row['ID_MEMBER'],
                        $row['NAMA_MEMBER'],
                        $row['NOMOR_MEMBER'],
                        $row['ALAMAT'],
                        $row['TGL_MENDAFTAR'],
                        $row['TGL_TERAKHIR_BAYAR']
                    );
                }
            } catch (PDOException $e) {
                error_log("Error fetching members: " . $e -> getMessage());
            }

            return $memberList;
        }

        public function getMember(string $id): ?Member {
            try {
                $stmt = $this -> db -> prepare("SELECT * FROM MEMBER WHERE ID_MEMBER = ?");
                $stmt -> execute([$id]);
                $row = $stmt -> fetch(PDO::FETCH_ASSOC);

                if ($row) {
                    return new Member(
                        $row['ID_MEMBER'],
                        $row['NAMA_MEMBER'],
                        $row['NOMOR_MEMBER'],
                        $row['ALAMAT'],
                        $row['TGL_MENDAFTAR'],
                        $row['TGL_TERAKHIR_BAYAR']
                    );
                }
            } catch (PDOException $e) {
                error_log("Error fetching member by ID: " . $e -> getMessage());
            }

            return null;
        }

        public function addMember(Member $member): bool {
            try {
                $stmt = $this -> db -> prepare("
                    INSERT INTO MEMBER (NAMA_MEMBER, NOMOR_MEMBER, ALAMAT, TGL_MENDAFTAR, TGL_TERAKHIR_BAYAR)
                    VALUES (?, ?, ?, ?, ?)
                ");

                return $stmt -> execute([
                    $member -> getNamaMember(),
                    $member -> getNomorMember(),
                    $member -> getAlamat(),
                    $member -> getTglMendaftar(),
                    $member -> getTglTerakhirBayar()
                ]);
            } catch (PDOException $e) {
                error_log("Error inserting member: " . $e -> getMessage());
                return false;
            }
        }

        public function updateMember(Member $member): bool {
            try {
                $stmt = $this -> db -> prepare("
                    UPDATE MEMBER 
                    SET NAMA_MEMBER = ?, NOMOR_MEMBER = ?, ALAMAT = ?, TGL_MENDAFTAR = ?, TGL_TERAKHIR_BAYAR = ?
                    WHERE ID_MEMBER = ?
                ");

                return $stmt -> execute([
                    $member -> getNamaMember(),
                    $member -> getNomorMember(),
                    $member -> getAlamat(),
                    $member -> getTglMendaftar(),
                    $member -> getTglTerakhirBayar(),
                    $member -> getIdMember()
                ]);
            } catch (PDOException $e) {
                error_log("Error updating member: " . $e -> getMessage());
                return false;
            }
        }

        public function deleteMember(Member $member): bool {
            try {
                $stmt = $this -> db -> prepare("DELETE FROM MEMBER WHERE ID_MEMBER = ?");
                return $stmt -> execute([$member -> getIdMember()]);
            } catch (PDOException $e) {
                error_log("Error deleting member: " . $e -> getMessage());
                return false;
            }
        }
    }
?>