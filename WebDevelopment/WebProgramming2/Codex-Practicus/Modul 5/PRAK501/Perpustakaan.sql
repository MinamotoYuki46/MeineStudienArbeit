-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for perpustakaan
CREATE DATABASE IF NOT EXISTS `perpustakaan` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `perpustakaan`;

-- Dumping structure for table perpustakaan.buku
CREATE TABLE IF NOT EXISTS `buku` (
  `ID_BUKU` int NOT NULL AUTO_INCREMENT,
  `JUDUL_BUKU` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PENULIS` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PENERBIT` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `TAHUN_TERBIT` int NOT NULL,
  PRIMARY KEY (`ID_BUKU`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table perpustakaan.buku: ~4 rows (approximately)
INSERT INTO `buku` (`ID_BUKU`, `JUDUL_BUKU`, `PENULIS`, `PENERBIT`, `TAHUN_TERBIT`) VALUES
	(1, 'Laskar Pelangi', 'Andrea Hirata', 'Bentang Pustaka', 2005),
	(2, 'Bumi Manusia', 'Pramoedya Ananta Toer', 'Hasta Mitra', 1980),
	(3, 'Negeri 5 Menara', 'Ahmad Fuadi', 'Gramedia Pustaka Utama', 2009),
	(4, 'Physics: Principles with Applications (7th Edition)', 'Douglas C. Giancoli', 'Pearson', 2013);

-- Dumping structure for table perpustakaan.member
CREATE TABLE IF NOT EXISTS `member` (
  `ID_MEMBER` int NOT NULL AUTO_INCREMENT,
  `NAMA_MEMBER` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `NOMOR_MEMBER` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ALAMAT` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `TGL_MENDAFTAR` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `TGL_TERAKHIR_BAYAR` date NOT NULL,
  PRIMARY KEY (`ID_MEMBER`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table perpustakaan.member: ~4 rows (approximately)
INSERT INTO `member` (`ID_MEMBER`, `NAMA_MEMBER`, `NOMOR_MEMBER`, `ALAMAT`, `TGL_MENDAFTAR`, `TGL_TERAKHIR_BAYAR`) VALUES
	(1, 'Muhammad Fauzan Ahsani', '0812-3456-7890', 'Kayu Tangi 1, Jalur 3', '2025-02-01 23:03:00', '2025-05-02'),
	(2, 'Rick Astley', '0254-2543-5320', 'London', '1987-05-02 23:17:02', '2025-03-02'),
	(4, 'Galih', '0854-2356-7809', 'kayu tangi II', '2025-05-09 15:30:00', '2025-05-17'),
	(6, 'Albert Einstein', '2432-5154-3423', 'New Jersey, Amerika Serikat', '2025-05-09 18:03:48', '2025-05-10');

-- Dumping structure for table perpustakaan.peminjaman
CREATE TABLE IF NOT EXISTS `peminjaman` (
  `ID_PEMINJAMAN` int NOT NULL AUTO_INCREMENT,
  `ID_MEMBER` int NOT NULL,
  `ID_BUKU` int NOT NULL,
  `TGL_PINJAM` date NOT NULL,
  `TGL_KEMBALI` date NOT NULL,
  PRIMARY KEY (`ID_PEMINJAMAN`) USING BTREE,
  KEY `id_member` (`ID_MEMBER`) USING BTREE,
  KEY `id_buku` (`ID_BUKU`) USING BTREE,
  CONSTRAINT `FK1_ID_MEMBER` FOREIGN KEY (`ID_MEMBER`) REFERENCES `member` (`ID_MEMBER`),
  CONSTRAINT `FK2_ID_BUKU` FOREIGN KEY (`ID_BUKU`) REFERENCES `buku` (`ID_BUKU`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table perpustakaan.peminjaman: ~4 rows (approximately)
INSERT INTO `peminjaman` (`ID_PEMINJAMAN`, `ID_MEMBER`, `ID_BUKU`, `TGL_PINJAM`, `TGL_KEMBALI`) VALUES
	(1, 1, 3, '2025-05-03', '2025-05-09'),
	(3, 4, 2, '2025-05-06', '2025-05-08'),
	(4, 2, 2, '2025-05-09', '2025-05-22'),
	(7, 6, 4, '2025-05-09', '2025-05-29');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;