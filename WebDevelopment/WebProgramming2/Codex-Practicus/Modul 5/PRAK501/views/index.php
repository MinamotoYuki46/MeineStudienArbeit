<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Modul 5 - Halaman Beranda Perpustakaan</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                margin: 0;
                height: 100vh; 
                display: flex;
                justify-content: center; 
                align-items: center;
                background-image: url(mit.jpg);
                background-size: cover;
                background-position: center center;  
                background-attachment: fixed;  
            }

            .container {
                max-width: 600px;
                margin-top: -600px;
                background: white;
                padding: 2rem;
                border-radius: 10px;
                box-shadow: 0 2px 10px rgba(0,0,0,0.1);
                text-align: center;
            }

            h1 {
                margin-bottom: 2rem;
            }

            .nav-buttons {
                display: flex;
                flex-direction: column;
                gap: 1rem;
            }

            .nav-buttons a {
                text-decoration: none;
                background-color: #007bff;
                color: white;
                padding: 12px;
                border-radius: 6px;
                font-size: 1rem;
                font-weight: bold;
                transition: background 0.2s;
            }

            .nav-buttons a:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Selamat Datang di Data Perpustakaan</h1>
            <div class="nav-buttons">
                <a href="BukuView.php">Data Buku</a>
                <a href="MemberView.php">Data Member</a>
                <a href="PeminjamanView.php">Data Peminjaman</a>
            </div>
        </div>
    </body>
</html>
