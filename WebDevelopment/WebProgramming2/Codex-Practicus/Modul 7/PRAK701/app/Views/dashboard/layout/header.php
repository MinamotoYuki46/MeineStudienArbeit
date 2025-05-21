<header class="bg-white shadow">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-4 flex justify-between items-center">
        <div>
            <h1 class="text-2xl font-bold text-gray-900">Data Buku</h1>
        </div>
        <div class="flex items-center">
            <p class="mr-4 text-gray-700">Hi, <span class="font-semibold text-blue-600"><?= session()->get('username') ?></span></p>
            <a href="<?= base_url('auth/logout') ?>" class="bg-red-500 hover:bg-red-600 text-white px-4 py-2 rounded-md text-sm transition-colors">
                <i class="fas fa-sign-out-alt mr-1"></i> Logout
            </a>
        </div>
    </div>
</header>