<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dashboard: Tambah Buku</title>
        <link href="<?= base_url('assets/css/tailwind.css') ?>" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    </head>
    <body class="bg-gray-50 flex flex-col min-h-screen"></body>

        <?php include 'layout/header.php'; ?>
        <main class="flex-grow w-full py-8">
            <div class="container mx-auto px-4 sm:px-6 lg:px-8 max-w-4xl">
                <?php if(session()->getFlashdata('error')): ?>
                    <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded mb-4 flex justify-between">
                        <span><?= session()->getFlashdata('error') ?></span>
                        <button class="text-red-700" onclick="this.parentElement.style.display='none';">&times;</button>
                    </div>
                <?php endif; ?>

                <div class="bg-white shadow rounded-lg p-6">
                    <div class="flex justify-between items-center mb-6">
                        <h2 class="text-xl font-semibold text-gray-800">Tambah Buku Baru</h2>
                        <a href="<?= base_url('dashboard') ?>" class="text-blue-600 hover:text-blue-800">
                            <i class="fas fa-arrow-left mr-1"></i> Kembali
                        </a>
                    </div>

                    <form action="<?= base_url('dashboard/save') ?>" method="post">
                        <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
                            <div>
                                <label for="title" class="block text-sm font-medium text-gray-700 mb-1">Judul Buku</label>
                                <input type="text" id="title" name="title" required
                                    class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
                                    placeholder="Masukkan judul buku">
                            </div>

                            <div>
                                <label for="author" class="block text-sm font-medium text-gray-700 mb-1">Penulis</label>
                                <input type="text" id="author" name="author" required
                                    class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
                                    placeholder="Masukkan nama penulis">
                            </div>

                            <div>
                                <label for="publisher" class="block text-sm font-medium text-gray-700 mb-1">Penerbit</label>
                                <input type="text" id="publisher" name="publisher" required
                                    class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
                                    placeholder="Masukkan nama penerbit">
                            </div>

                            <div>
                                <label for="publication_year" class="block text-sm font-medium text-gray-700 mb-1">Tahun Terbit</label>
                                <input type="number" id="publication_year" name="publication_year" required
                                    class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
                                    placeholder="Contoh: 2023" min="1800" max="<?= date('Y') ?>">
                            </div>
                        </div>

                        <div class="mt-8 flex justify-end">
                            <button type="submit" class="bg-blue-600 hover:bg-blue-700 text-white px-6 py-2 rounded-md transition-colors">
                                <i class="fas fa-save mr-1"></i> Simpan Buku
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </main>
        <?php include 'layout/footer.php'; ?>
    </body>
</html>