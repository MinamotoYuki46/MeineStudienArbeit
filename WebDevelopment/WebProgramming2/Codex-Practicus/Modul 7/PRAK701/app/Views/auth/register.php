<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Daftar</title>
        <link href="<?= base_url('assets/css/tailwind.css')?>" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    </head>
    <body class="bg-white">
        <main class="flex min-h-screen flex-col items-center justify-center bg-white px-4">
            <div class="max-w-md w-full mx-auto">
                <div class="text-center mb-10">
                    <h1 class="text-3xl font-bold text-gray-900">Daftar Akun</h1>
                </div>
                
                <?php if(session()->getFlashdata('error')): ?>
                    <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded mb-4">
                        <?= session()->getFlashdata('error') ?>
                    </div>
                <?php endif; ?>
                
                <div class="bg-white rounded-lg shadow-lg p-6">
                    <form action="<?= base_url('auth/processRegister') ?>" method="post">
                        <div class="mb-4">
                            <label for="username" class="block text-gray-700 text-sm font-medium mb-2">Username</label>
                            <input type="text" id="username" name="username" 
                                class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
                                placeholder="Masukkan username Anda" required>
                        </div>
                        
                        <div class="mb-4">
                            <label for="email" class="block text-gray-700 text-sm font-medium mb-2">Email</label>
                            <input type="email" id="email" name="email" 
                                class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
                                placeholder="email@contoh.com" required>
                        </div>
                        
                        <div class="mb-4 relative">
                            <label for="password" class="block text-gray-700 text-sm font-medium mb-2">Password</label>
                            <input type="password" id="password" name="password" 
                                class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
                                placeholder="Masukkan password" required>
                            
                            <button type="button" id="togglePassword"
                                class="absolute right-3 top-9 text-gray-500 hover:text-gray-700 focus:outline-none">
                                <i class="fa-solid fa-eye" id="eyeIcon"></i>
                            </button>
                        </div>
                        
                        <div class="mb-6 relative">
                            <label for="confirmPassword" class="block text-gray-700 text-sm font-medium mb-2">Konfirmasi Password</label>
                            <input type="password" id="confirmPassword" name="confirmPassword"
                                class="w-full px-3 py-2 pr-10 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
                                placeholder="Masukkan kembali password" required>
                            <button type="button" id="toggleConfirm"
                                class="absolute right-3 top-9 text-gray-500 hover:text-gray-700 focus:outline-none">
                                <i class="fa-solid fa-eye" id="eyeIconConfirm"></i>
                            </button>
                        </div>
                        
                        <div class="mb-6">
                            <button type="submit" 
                                class="w-full bg-blue-600 text-white py-2 px-4 rounded-md hover:bg-blue-700 transition-colors">
                                Daftar
                            </button>
                        </div>
                        
                        <div class="text-center text-sm">
                            <p>Sudah punya akun? 
                                <a href="<?= base_url('auth/login') ?>" class="text-blue-600 hover:underline">
                                    Masuk di sini
                                </a>
                            </p>
                        </div>
                    </form>
                </div>
                
                <div class="text-center mt-6">
                    <a href="<?= base_url() ?>" class="text-gray-600 hover:text-blue-600 text-sm">
                        &larr; Kembali ke halaman utama
                    </a>
                </div>
            </div>
        </main>
        <script src="<?= base_url( 'assets/js/showPass.js')?>"></script>
    </body>
</html>