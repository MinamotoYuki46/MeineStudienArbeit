<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
        <link href="<?= base_url('assets/css/tailwind.css')?>" rel="stylesheet">
    </head>
    <body class="bg-white">
        <main class="flex min-h-screen flex-col items-center justify-center bg-white px-4">
            <div class="max-w-3xl mx-auto text-center">
                <h1 class="text-4xl md:text-5xl font-bold tracking-tight text-gray-900 mb-6">
                    Selamat Datang
                    <span class="block text-2xl mt-2 text-indigo-600">di Perpustakaan Syntaxius</span>
                </h1>
                
                <div class="flex flex-col sm:flex-row gap-4 justify-center items-center">
                    <a href="<?= site_url('auth/login') ?>" class="px-6 py-3 bg-blue-600 text-white font-medium rounded-md hover:bg-indigo-700 transition-colors group">
                        Masuk <br>
                    </a>
                    <a href="<?= site_url('auth/register') ?>" class="px-6 py-3 bg-gray-100 text-blue-600 font-medium rounded-md hover:bg-gray-200 transition-colors group">
                        Daftar
                    </a>
                </div>
            </div>
        </main>
    </body>
</html>