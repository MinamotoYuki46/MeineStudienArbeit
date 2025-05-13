<?php include('layouts/header.php'); ?>
    <div class="container">
        <h1 class="page-title">Detail Mahasiswa</h1>

        <div class="profile-card">
            <img src="images/<?= esc($student -> images[1]) ?>" alt="Foto Profil" class="profile-img">
            
            <div class="info">
                <div class="field"><strong>Nama:</strong> <?= esc($student -> name) ?></div>
                <div class="field"><strong>TTL:</strong> <?= esc($student -> birthPlace) ?>, <?= esc($student -> birthDate) ?></div>
                <div class="field"><strong>NIM:</strong> <?= esc($student -> id) ?></div>
                <div class="field"><strong>Universitas:</strong> <?= esc($student -> university) ?></div>
                <div class="field"><strong>Program Studi:</strong> <?= esc($student -> major) ?></div>
                <div class="field"><strong>Angkatan:</strong> <?= esc($student -> year) ?></div>
                <div class="field"><strong>Semester:</strong> <?= esc($student -> semester) ?></div>
                <div class="field"><strong>IPK:</strong> <?= esc($student -> gpa) ?></div>
                <div class="field"><strong>Alamat Email:</strong> <?= esc($student -> email) ?></div>
                <div class="field"><strong>Asal:</strong> <?= esc($student -> origin) ?></div>
                
                <div class="field"><strong>Hobi:</strong>
                    <ul>
                        <?php foreach($student -> hobby as $h): ?>
                            <li><?= esc($h) ?></li>
                        <?php endforeach; ?>
                    </ul>
                </div>

                <div class="field"><strong>Pencapaian:</strong>
                    <ul>
                        <?php foreach($student -> achievements as $a): ?>
                            <li><?= esc($a) ?></li>
                        <?php endforeach; ?>
                    </ul>
                </div>
            </div>
            
            <a href="/" class="gold-button" style="margin-top: 3rem">Kembali ke Halaman Beranda</a>
        </div>
    </div>
<?php include('layouts/footer.php'); ?>
