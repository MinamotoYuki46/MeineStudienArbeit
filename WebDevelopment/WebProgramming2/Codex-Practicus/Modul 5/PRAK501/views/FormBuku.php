<?php
    require_once '../dao/BukuDAO.php';
    require_once '../models/Buku.php';

    $dao = new BukuDAO();
    $selectedBook = null;

    $id = 0;

    if (isset($_GET['id'])) {
        $id = $_GET['id'];
        $selectedBook = $dao  ->  getBuku($id);
    }

    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        $judul = $_POST['judul'];
        $penulis = $_POST['penulis'];
        $penerbit = $_POST['penerbit'];
        $tahunTerbit = $_POST['tahun_terbit'];

        $book = new Buku(
            $id,
            $judul,
            $penulis,
            $penerbit,
            $tahunTerbit
        );

        if ($id) {
            if ($dao -> updateBuku($book)) {
                header('Location: BukuView.php'); 
                exit();
            } else {
                echo "Gagal mengubah data buku.";
            }
        } else {
            if ($dao -> addBuku($book)) {
                header('Location: BukuView.php');
                exit();
            } else {
                echo "Gagal menambah data buku.";
            }
        }
    }
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title><?= $selectedBook ? 'Edit Buku' : 'Tambah Buku' ?></title>
        <link rel="stylesheet" href="form.css">
    </head>
    <body>
        <div class="form-container">
            <h2><?= $selectedBook ? 'Edit Buku' : 'Tambah Buku' ?></h2>
            <form action="" method="post">
            <?php if ($selectedBook): ?> 
                <input type="hidden" name="id" value="<?= $selectedBook -> getIdBuku() ?>">
            <?php endif; ?>

            <div class="form-group">
                <label for="judul">Judul Buku</label>
                <input type="text" name="judul" id="judul" required value="<?= $selectedBook ? $selectedBook -> getJudulBuku() : '' ?>">
            </div>

            <div class="form-group">
                <label for="penulis">Penulis</label>
                <input type="text" name="penulis" id="penulis" required value="<?= $selectedBook ? $selectedBook -> getPenulis() : '' ?>">
            </div>

            <div class="form-group">
                <label for="penerbit">Penerbit</label>
                <input type="text" name="penerbit" id="penerbit" required value="<?= $selectedBook ? $selectedBook -> getPenerbit() : '' ?>">
            </div>

            <div class="form-group">
                <label for="tahun_terbit">Tahun Terbit</label>
                <input type="number" name="tahun_terbit" id="tahun_terbit" required 
                    min="1900" max="<?= date('Y') ?>" 
                    value="<?= $selectedBook ? $selectedBook -> getTahunTerbit() : '' ?>">
            </div>

            <div class="form-actions">
                <button type="submit" class="btn btn-submit">Simpan</button>
                <a href="BukuView.php" class="btn btn-cancel">Batal</a>
            </div>
            </form>
        </div>
    </body>
</html>