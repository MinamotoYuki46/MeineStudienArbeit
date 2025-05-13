<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Biodata Mahasiswa</title>

        <script type="module" src="https://unpkg.com/@material/web/all.js"></script>
        <link rel="stylesheet" href="https://unpkg.com/@material/web/all.css">

        <style>
            body {
                font-family: 'Roboto', sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f5f5f5;
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                flex-direction: column;
            }

            .container {
                padding: 2rem;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                text-align: center;
            }

            .profile-card {
                border-radius: 16px;
                padding: 24px;
                background-color: white;
                box-shadow: 0 4px 12px rgba(0,0,0,0.1);
                width: 100%;
                max-width: 500px;
            }

            a.gold-button {
                background-color: gold;
                color: black;
                border: none;
                padding: 12px 24px;
                border-radius: 8px;
                font-weight: bold;
                cursor: pointer;
                text-decoration: none;
            }

            a.gold-button:hover {
                background-color: goldenrod;
                color: white;
            }

            nav {
                background-color: #ffffff;
                box-shadow: 0 2px 4px rgba(0,0,0,0.1);
                padding: 1rem 2rem;
                display: flex;
                justify-content: space-between;
                align-items: center;
                width: 100%;
                position: fixed;
                top: 0;
                left: 0;
                z-index: 100;
            }

            .nav-container {
                display: flex;
                justify-content: space-between;
                align-items: center;
                max-width: 1200px;
                margin: 0 auto;
            }

            .nav-links {
                display: flex;
                gap: 1rem;
            }

            .nav-title {
                font-size: 1.5rem;
                font-weight: bold;
                color: #333;
            }

            .nav-links a {
                text-decoration: none;
                color: #333;
                margin-left: 1.5rem;
                font-weight: 500;
                transition: color 0.2s;
            }

            .nav-links a:hover {
                color: #00796B;
            }

            footer {
                background-color: #ffffff;
                padding: 1rem 2rem;
                text-align: center;
                width: 100%;
                position: fixed;
                bottom: 0;
                left: 0;
                box-shadow: 0 -2px 4px rgba(0, 0, 0, 0.1);
            }

            footer p {
                margin: 0;
                color: #333;
            }

            .profile-card {
                background: white;
                border-radius: 16px;
                padding: 24px;
                box-shadow: 0 4px 12px rgba(0,0,0,0.1);
                margin-top: 1rem;
            }

            .profile-img {
                width: 200px;
                height: 200px;
                object-fit: cover;
                border-radius: 16px;
                display: block;
                margin: 0 auto 2rem auto;
            }

            .field {
                margin-bottom: 0.75rem;
                text-align: left;
            }

            ul {
                margin-top: 0.5rem;
                padding-left: 1.5rem;
            }

            .page-title {
                text-align: center;
                margin-top: 2rem;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <nav>
            <div class="nav-container">
                <div class="nav-title">Biodata Mahasiswa</div>
                <div class="nav-links">
                    <a href="/">Home</a>
                    <a href="/profile">Profile</a>
                </div>
            </div>
        </nav>