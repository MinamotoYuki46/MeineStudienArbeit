<?php include('layouts/header.php'); ?>
    <div class="container">
        <h1>Halo Dunia! Selamat Datang! <br> Perkenalkan, saya</h1>

        <div class="profile-card">
            <img src="images/<?= $student -> images[0]?>" alt="Profile Picture" style="width: 200px; height: 200px; object-fit: cover;" class="img-fluid rounded">
                <h2> <?= $student -> name?> </h2> 
                <h2> <?= $student -> id?> </h2>
            <a href="/profile" class="gold-button">Lihat Profil Detail</a>
        </div>
    </div>
<?php include('layouts/footer.php'); ?>
