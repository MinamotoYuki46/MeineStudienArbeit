<?php
    require_once '../dao/MemberDAO.php';
    require_once '../models/Member.php';

    $dao = new MemberDAO();
    $selectedMember = null;

    $id = 0;

    if (isset($_GET['id'])) {
        $id = $_GET['id'];
        $selectedMember = $dao -> getMember($id);
    }

    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        $nama = $_POST['nama'];
        $nomorTelepon = $_POST['nomor-telepon'];
        $alamat = $_POST['alamat'];

        if ($id) {
            $tglDaftar = $selectedMember ? $selectedMember -> getTglMendaftar() : date('Y-m-d H:i:s');
            $tglAkhBayar = $_POST['tgl-akh-bayar'] ? date('Y-m-d', strtotime($_POST['tgl-akh-bayar'])) : date('Y-m-d');
        } else {
            $tglDaftar = date('Y-m-d H:i:s');
            $tglAkhBayar = date('Y-m-d');
        }

        $member = new Member($id, $nama, $nomorTelepon, $alamat, $tglDaftar, $tglAkhBayar);

        if ($id) {
            if ($dao -> updateMember($member)) {
                header('Location: MemberView.php');
                exit();
            } else {
                echo "Error updating member.";
            }
        } else {
            if ($dao -> addMember($member)) {
                header('Location: MemberView.php'); 
                exit();
            } else {
                echo "Error adding new member.";
            }
        }
    }
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title><?= $selectedMember ? 'Edit Member' : 'Tambah Member' ?></title>
        <link rel="stylesheet" href="form.css">
    </head>
    <body>
        <div class="form-container">
            <h2><?= $selectedMember ? 'Edit Member' : 'Tambah Member' ?></h2>
            <form action="" method="post">
                <?php if ($selectedMember): ?> 
                    <input type="hidden" name="id" value="<?= $selectedMember -> getIdMember() ?>">
                <?php endif; ?>

                <div class="form-group">
                    <label for="nama">Nama</label>
                    <input type="text" name="nama" id="name" required value="<?= $selectedMember ? $selectedMember -> getNamaMember() : '' ?>">
                </div>

                <div class="form-group">
                    <label for="nomor-telepon">Nomor</label>
                    <input type="text" name="nomor-telepon" id="phone" required value="<?= $selectedMember ? $selectedMember -> getNomorMember() : '' ?>">
                </div>

                <div class="form-group">
                    <label for="alamat">Alamat</label>
                    <textarea name="alamat" id="address" rows="3" required><?= $selectedMember ? $selectedMember -> getAlamat() : '' ?></textarea>
                </div>

                <?php if ($selectedMember): ?>
                    <div class="form-group">
                        <label for="tgl-akh-bayar">Tanggal Terakhir Bayar</label>
                        <input type="date" name="tgl-akh-bayar" id="last_payment" value="<?= $selectedMember ? $selectedMember -> getTglTerakhirBayar() : '' ?>">
                    </div>
                <?php endif; ?>

                <div class="form-actions">
                    <button button type="submit" class="btn btn-submit">Simpan</button>
                    <a href="MemberView.php" class="btn btn-cancel">Batal</a>
                </div>
            </form>
        </div>
        <script src="script.js"></script>
    </body>
</html>