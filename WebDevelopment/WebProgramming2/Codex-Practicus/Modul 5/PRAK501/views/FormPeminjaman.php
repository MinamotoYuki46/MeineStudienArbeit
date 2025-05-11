<?php
    require_once '../dao/PeminjamanDAO.php';
    require_once '../dao/MemberDAO.php';
    require_once '../dao/BukuDAO.php';
    require_once '../models/Peminjaman.php';

    $peminjamanDAO = new PeminjamanDAO();
    $memberDAO = new MemberDAO();
    $bukuDAO = new BukuDAO();
    $selectedLoan = null;

    $id = 0;

    if (isset($_GET['id'])) {
        $id = $_GET['id'];
        $selectedLoan = $peminjamanDAO -> getPeminjaman($id);
    }

    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        $idMember = $_POST['id-member'];
        $idBuku = $_POST['id-buku'];
        $tglPinjam = $_POST['tgl-pinjam'];
        $tglKembali = $_POST['tgl-kembali'];

        $peminjaman = new Peminjaman(
            $id,
            $idMember,
            $idBuku,
            $tglPinjam,
            $tglKembali,
        );

        if ($id) {
            if ($peminjamanDAO -> updatePeminjaman($peminjaman)) {
                header('Location: PeminjamanView.php');
                exit();
            } else {
                echo "Error updating peminjaman.";
            }
        } else {
            if ($peminjamanDAO->addPeminjaman($peminjaman)) {
                header('Location: PeminjamanView.php');
                exit();
            } else {
                echo "Error adding new peminjaman.";
            }
        }
    }

    $members = $memberDAO -> getAllMember();
    $books = $bukuDAO -> getAllBuku();
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title><?= $selectedLoan ? 'Edit Peminjaman' : 'Tambah Peminjaman' ?></title>
        <link rel="stylesheet" href="form.css">
        <style>
            select {
                width: 100%;
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 6px;
            }
        </style>
    </head>
    <body>
        <div class="form-container">
            <h2><?= $selectedLoan ? 'Edit Peminjaman' : 'Tambah Peminjaman' ?></h2>
            <form action="" method="post">
                <?php if ($selectedLoan): ?> 
                    <input type="hidden" name="id" value="<?= $selectedLoan -> getIdPeminjaman() ?>">
                <?php endif; ?>

                <div class="form-group">
                    <label for="id-member">Member</label>
                    <select name="id-member" id="id_member" required>
                    <option value="">Pilih Member</option>
                    <?php foreach ($members as $member): ?>
                        <option value="<?= $member -> getIdMember() ?>" 
                        <?= $selectedLoan && $selectedLoan -> getIdMember() == $member -> getIdMember() ? 'selected' : '' ?>>
                        <?= $member -> getNamaMember() ?> (<?= $member -> getNomorMember() ?>)
                        </option>
                    <?php endforeach; ?>
                    </select>
                </div>

                <div class="form-group">
                    <label for="id-buku">Buku</label>
                    <select name="id-buku" id="id_buku" required>
                    <option value="">Pilih Buku</option>
                    <?php foreach ($books as $book): ?>
                        <option value="<?= $book -> getIdBuku() ?>" 
                        <?= $selectedLoan && $selectedLoan -> getIdBuku() == $book -> getIdBuku() ? 'selected' : '' ?>>
                        <?= $book -> getJudulBuku() ?> (<?= $book -> getPenulis() ?>)
                        </option>
                    <?php endforeach; ?>
                    </select>
                </div>

                <div class="form-group">
                    <label for="tgl-pinjam">Tanggal Pinjam</label>
                    <input type="date" name="tgl-pinjam" id="tgl_pinjam" required
                        value="<?= $selectedLoan ? $selectedLoan -> getTglPinjam() : date('Y-m-d') ?>">
                </div>

                <div class="form-group">
                    <label for="tgl-kembali">Tanggal Kembali</label>
                    <input type="date" name="tgl-kembali" id="tgl_kembali" required
                        value="<?= $selectedLoan ? $selectedLoan -> getTglKembali() : date('Y-m-d') ?>">
                </div>

                <div class="form-actions">
                    <button type="submit" class="btn btn-submit">Simpan</button>
                    <a href="PeminjamanView.php" class="btn btn-cancel">Batal</a>
                </div>
            </form>
        </div>
    </body>
</html>