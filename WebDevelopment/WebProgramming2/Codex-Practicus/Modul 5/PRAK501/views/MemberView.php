<?php

    require_once '../dao/MemberDAO.php';

    $dao = new MemberDAO();
    $members = $dao -> getAllMember();

    if (isset($_GET['delete'])) {
        $id = $_GET['delete'];
        $selectedMember = $dao -> getMember($id);
        $dao -> deleteMember($selectedMember);
        header("Location: MemberView.php");
        exit;
    }
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Data Member</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="container">
            <h2>Data Member</h2>

            <div class="top-bar">
                <input type="text" class="search-input" placeholder="Cari...">
                <div style="display: flex; gap: 8px;">
                    <a href="index.php" class="btn-home">Beranda</a>
                    <a href="FormMember.php" class="btn-add">+ Tambah Member Baru</a>
                </div>
            </div>

            <table class="searchable-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nama</th>
                        <th>Nomor</th>
                        <th>Alamat</th>
                        <th>Tanggal Mendaftar</th>
                        <th>Tanggal Terakhir Bayar</th>
                        <th>Aksi</th>
                    </tr>
                </thead>
                <tbody>
                    <?php foreach ($members as $member): ?>
                    <tr>
                        <td><?= $member -> getIdMember() ?></td>
                        <td><?= $member -> getNamaMember() ?></td>
                        <td class="phone-number"><?= $member->getNomorMember() ?></td>
                        <td><?= $member -> getAlamat() ?></td>
                        <td><?= $member -> getTglMendaftar() ?></td>
                        <td><?= $member -> getTglTerakhirBayar() ?></td>
                        <td>
                            <div class="actions">
                                <a href="FormMember.php?id=<?= $member -> getIdMember() ?>" class="btn-edit">Edit</a>
                                <a href="MemberView.php?delete=<?= $member -> getIdMember() ?>" class="btn-delete" onclick="return confirm('Anda yakin menghapus member ini?')">Hapus</a>
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
