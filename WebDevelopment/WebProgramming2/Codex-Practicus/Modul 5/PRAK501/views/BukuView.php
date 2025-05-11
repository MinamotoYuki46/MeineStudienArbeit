<?php
    require_once '../dao/BukuDAO.php';

    $dao = new BukuDAO();
    $books = $dao -> getAllBuku();

    if (isset($_GET['delete'])) {
        $id = $_GET['delete'];
        $selectedBook = $dao -> getBuku($id);
        $dao -> deleteBuku($selectedBook);
        header("Location: BukuView.php");
        exit;
    }
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Data Buku</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="container">
            <h2>Data Buku</h2>

            <div class="top-bar">
                <input type="text" class="search-input" placeholder="Cari...">
                <div style="display: flex; gap: 8px;">
                    <a href="index.php" class="btn-home">Beranda</a>
                    <a href="FormBuku.php" class="btn-add">+ Tambah Buku Baru</a>
                </div>
            </div>

            <table class="searchable-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Judul Buku</th>
                        <th>Penulis</th>
                        <th>Penerbit</th>
                        <th>Tahun Terbit</th>
                        <th>Aksi</th>
                    </tr>
                </thead>
                <tbody>
                    <?php foreach ($books as $book): ?>
                    <tr>
                        <td><?= $book -> getIdBuku() ?></td>
                        <td><?= $book -> getJudulBuku() ?></td>
                        <td><?= $book -> getPenulis() ?></td>
                        <td><?= $book -> getPenerbit() ?></td>
                        <td><?= $book -> getTahunTerbit() ?></td>
                        <td>
                            <div class="actions">
                                <a href="FormBuku.php?id=<?= $book -> getIdBuku() ?>" class="btn-edit">Edit</a>
                                <a href="BukuView.php?delete=<?= $book -> getIdBuku() ?>" class="btn-delete" onclick="return confirm('Anda yakin menghapus buku ini?')">Hapus</a>
                            </div>
                        </td>
                    </tr>
                    <?php endforeach; ?>
                </tbody>
            </table>
        </div>
        <script src="search.js"></script> 
    </body>
</html>