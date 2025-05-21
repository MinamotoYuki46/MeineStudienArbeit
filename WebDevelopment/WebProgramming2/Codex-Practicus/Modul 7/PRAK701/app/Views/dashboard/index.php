<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dashboard</title>
        <link href="<?= base_url('assets/css/tailwind.css') ?>" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    </head>
    <body class="bg-gray-50 flex flex-col min-h-screen"></body>

        <?php include 'layout/header.php'; ?>

        <main class="flex-grow w-full py-8">
            <div class="container mx-auto px-4 sm:px-6 lg:px-8">
                <?php if(session()->getFlashdata('success')): ?>
                    <div class="bg-green-100 border border-green-400 text-green-700 px-4 py-3 rounded mb-4 flex justify-between">
                        <span><?= session()->getFlashdata('success') ?></span>
                        <button class="text-green-700" onclick="this.parentElement.style.display='none';">&times;</button>
                    </div>
                <?php endif; ?>

                <?php if(session()->getFlashdata('error')): ?>
                    <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded mb-4 flex justify-between">
                        <span><?= session()->getFlashdata('error') ?></span>
                        <button class="text-red-700" onclick="this.parentElement.style.display='none';">&times;</button>
                    </div>
                <?php endif; ?>

                <div class="bg-white shadow rounded-lg p-6">
                    <div class="flex justify-between items-center mb-6">
                        <h2 class="text-xl font-semibold text-gray-800">Manajemen Buku</h2>
                        <a href="<?= base_url('dashboard/add') ?>" class="bg-blue-600 hover:bg-blue-700 text-white px-4 py-2 rounded-md text-sm transition-colors">
                            <i class="fas fa-plus mr-1"></i> Tambah Buku
                        </a>
                    </div>

                    <div class="mb-6">
                        <input type="text" id="searchInput" class="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="Cari judul, penulis, penerbit...">
                    </div>

                    <div class="overflow-x-auto">
                        <table class="min-w-full bg-white table-fixed">
                            <thead class="bg-gray-100">
                                <tr>
                                    <th class="py-3 px-4 text-left text-xs font-medium text-gray-500 uppercase">ID</th>
                                    <th class="py-3 px-4 text-left text-xs font-medium text-gray-500 uppercase">Judul</th>
                                    <th class="py-3 px-4 text-left text-xs font-medium text-gray-500 uppercase">Penulis</th>
                                    <th class="py-3 px-4 text-left text-xs font-medium text-gray-500 uppercase">Penerbit</th>
                                    <th class="py-3 px-4 text-left text-xs font-medium text-gray-500 uppercase">Tahun</th>
                                    <th class="py-3 px-4 text-left text-xs font-medium text-gray-500 uppercase">Aksi</th>
                                </tr>
                            </thead>
                            <tbody id="booksTableBody" class="divide-y divide-gray-200">
                                <?php if (empty($books)): ?>
                                    <tr id="noDataRow">
                                        <td colspan="6" class="py-4 px-4 text-center text-gray-500">Belum ada buku. Tambahkan buku pertama Anda!</td>
                                    </tr>
                                <?php else: ?>
                                    <?php foreach ($books as $book): ?>
                                        <tr class="hover:bg-gray-50 book-row">
                                            <td class="py-3 px-4 text-sm text-gray-500"><?= $book['id'] ?></td>
                                            <td class="py-3 px-4 text-sm text-gray-900 book-title"><?= $book['title'] ?></td>
                                            <td class="py-3 px-4 text-sm text-gray-500 book-author"><?= $book['author'] ?></td>
                                            <td class="py-3 px-4 text-sm text-gray-500 book-publisher"><?= $book['publisher'] ?></td>
                                            <td class="py-3 px-4 text-sm text-gray-500 book-year"><?= $book['publication_year'] ?></td>
                                            <td class="py-3 px-4 text-sm font-medium">
                                                <div class="flex space-x-2">
                                                    <a href="<?= base_url('dashboard/edit/' . $book['id']) ?>" class="text-green-600 hover:text-green-900">
                                                        <i class="fas fa-edit"></i> Edit
                                                    </a>
                                                    <form action="<?= base_url('dashboard/delete/' . $book['id'])?>" method="POST">
                                                        <?= csrf_field() ?>
                                                        <input type="hidden" name="_method" value="DELETE">
                                                        <button type="button"
                                                            class="text-red-600 hover:text-red-900 cursor-pointer"
                                                            onclick="openDeleteModal('<?= base_url('dashboard/delete/' . $book['id']) ?>')">
                                                            <i class="fas fa-trash-alt"></i> Hapus
                                                        </button>
                                                    </form>
                                                </div>
                                            </td>
                                        </tr>
                                    <?php endforeach; ?>
                                <?php endif; ?>
                            </tbody>
                        </table>

                        <div id="noSearchResults" class="hidden py-4 px-4 text-center text-gray-500">
                            <i class="fas fa-search text-gray-400 text-2xl mb-2"></i>
                            <p>Tidak ada buku yang cocok dengan pencarian Anda.</p>
                            <p class="text-sm mt-1">Coba kata kunci lain atau <a href="#" onclick="clearSearch()" class="text-blue-600 hover:underline">reset pencarian</a>.</p>
                        </div>
                    </div>
                </div>

                <div class="mt-8 grid grid-cols-1 md:grid-cols-3 gap-6">
                    <div class="bg-white p-6 rounded-lg shadow">
                        <h3 class="text-lg font-medium text-gray-900 mb-2">Total Buku</h3>
                        <p class="text-3xl font-bold text-blue-600"><?= count($books) ?></p>
                    </div>
                </div>
            </div>
        </main>

        <?php include 'layout/footer.php'; ?>

        <div id="deleteModal" class="hidden fixed inset-0 bg-gray-500 bg-opacity-75 flex items-center justify-center">
            <div class="bg-white rounded-lg p-6 max-w-md mx-auto">
                <h3 class="text-lg font-medium text-gray-900 mb-4">Konfirmasi Hapus</h3>
                <p class="text-gray-700 mb-4">Apakah Anda yakin ingin menghapus buku ini? Tindakan ini tidak dapat dibatalkan.</p>
                <div class="flex justify-end space-x-3">
                    <button onclick="closeDeleteModal()" class="px-4 py-2 bg-gray-200 text-gray-800 rounded-md hover:bg-gray-300 transition-colors">Batal</button>
                    <form id="deleteForm" method="POST">
                        <?= csrf_field() ?>
                        <input type="hidden" name="_method" value="DELETE">
                        <button type="submit" class="px-4 py-2 bg-red-600 text-white rounded-md hover:bg-red-700 transition-colors">Ya, Hapus</button>
                    </form>
                </div>
            </div>
        </div>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                const searchInput = document.getElementById('searchInput');
                const bookRows = document.querySelectorAll('.book-row');
                const noSearchResults = document.getElementById('noSearchResults');

                searchInput.addEventListener('input', function () {
                    const term = this.value.toLowerCase().trim();
                    let matchCount = 0;

                    bookRows.forEach(row => {
                        const title = row.querySelector('.book-title').textContent.toLowerCase();
                        const author = row.querySelector('.book-author').textContent.toLowerCase();
                        const publisher = row.querySelector('.book-publisher').textContent.toLowerCase();
                        const year = row.querySelector('.book-year').textContent.toLowerCase();

                        const match = [title, author, publisher, year].some(text => text.includes(term));
                        row.style.display = match ? 'table-row' : 'none';
                        if (match) matchCount++;
                    });

                    noSearchResults.classList.toggle('hidden', matchCount > 0 || term === '');
                });

                window.clearSearch = function () {
                    searchInput.value = '';
                    bookRows.forEach(row => row.style.display = 'table-row');
                    noSearchResults.classList.add('hidden');
                };
            });

            function openDeleteModal(deleteUrl) {
                const modal = document.getElementById('deleteModal');
                const form = document.getElementById('deleteForm');
                form.action = deleteUrl;
                modal.classList.remove('hidden');
            }

            function closeDeleteModal() {
                document.getElementById('deleteModal').classList.add('hidden');
            }
        </script>
    </body>
</html>