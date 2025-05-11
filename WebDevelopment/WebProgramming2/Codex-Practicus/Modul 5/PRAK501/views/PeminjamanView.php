<?php
    require_once '../dao/PeminjamanDAO.php';
    require_once '../dao/MemberDAO.php';
    require_once '../dao/BukuDAO.php';

    $peminjamanDAO = new PeminjamanDAO();
    $memberDAO = new MemberDAO();
    $bukuDAO = new BukuDAO();

    $loans = $peminjamanDAO -> getAllPeminjaman();

    if (isset($_GET['delete'])) {
        $id = $_GET['delete'];
        $selectedLoan = $peminjamanDAO -> getPeminjaman($id);
        $peminjamanDAO -> deletePeminjaman($selectedLoan);
        header("Location: PeminjamanView.php");
        exit;
    }
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Data Peminjaman</title>
        <link rel="stylesheet" href="styles.css">
        <style>
            .tooltip {
                position: relative;
                display: inline-block;
                cursor: pointer;
            }

            .tooltip .tooltip-text {
                visibility: hidden;
                width: 300px;
                background-color: #333;
                color: #fff;
                text-align: left;
                border-radius: 5px;
                padding: 10px;
                position: absolute;
                z-index: 1;
                bottom: 125%; 
                left: 50%;
                margin-left: -150px; 
                opacity: 0;
                transition: opacity 0.3s;
            }

            .tooltip:hover .tooltip-text {
                visibility: visible;
                opacity: 1;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Data Peminjaman</h2>

            <div class="top-bar">
                <input type="text" class="search-input" placeholder="Cari...">
                <div style="display: flex; gap: 8px;">
                    <a href="index.php" class="btn-home">Beranda</a>
                    <a href="FormPeminjaman.php" class="btn-add">+ Tambah Peminjaman Baru</a>
                </div>
            </div>

            <table class="searchable-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Member</th>
                        <th>Buku</th>
                        <th>Tanggal Pinjam</th>
                        <th>Tanggal Kembali</th>
                        <th>Aksi</th>
                    </tr>
                </thead>
                <tbody>
                    <?php foreach ($loans as $loan): 
                        $member = $memberDAO -> getMember($loan -> getIdMember());
                        $book = $bukuDAO -> getBuku($loan -> getIdBuku());
                    ?>
                    <tr>
                        <td><?= $loan -> getIdPeminjaman() ?></td>
                        <td>
                            <div class="tooltip">
                                <?= $member -> getNamaMember() ?>
                                <div class="tooltip-text">
                                    <strong>Detail Buku:</strong><br>
                                    ID: <?= $member -> getIdMember()?> <br>
                                    Nama: <?= $member -> getNamaMember() ?><br>
                                    No. Telepon: <?= $member -> getNomorMember() ?><br>
                                    Alamat: <?= $member -> getAlamat() ?> <br>
                                    Tanggal Daftar: <?= $member -> getTglMendaftar() ?> <br>
                                    Tanggal Terakhir Bayar: <?= $member -> getTglTerakhirBayar() ?>
                                </div>
                            </div>
                        </td>
                        <td>
                            <div class="tooltip">
                                <?= $book -> getJudulBuku() ?>
                                <div class="tooltip-text">
                                    <strong>Detail Member:</strong><br>
                                    ID: <?= $book -> getIdBuku()?> <br>
                                    Judul: <?= $book -> getJudulBuku() ?><br>
                                    Penulis: <?= $book -> getPenulis() ?><br>
                                    Penerbit: <?= $book -> getPenerbit() ?> <br>
                                    Tahun Terbit: <?= $book -> getTahunTerbit() ?> <br>
                                </div>
                            </div>
                        </td>
                        <td><?= $loan -> getTglPinjam() ?></td>
                        <td><?= $loan -> getTglKembali() ?: '-' ?></td>
                        <td>
                            <div class="actions">
                                <a href="FormPeminjaman.php?id=<?= $loan -> getIdPeminjaman() ?>" class="btn-edit">Edit</a>
                                <a href="PeminjamanView.php?delete=<?= $loan -> getIdPeminjaman() ?>" class="btn-delete" onclick="return confirm('Anda yakin menghapus data peminjaman ini?')">Hapus</a>
                            </div>
                        </td>
                    </tr>
                    <?php endforeach; ?>
                </tbody>
            </table>
        </div>
        <script src="script.js"></script> 
    </body>
</html>