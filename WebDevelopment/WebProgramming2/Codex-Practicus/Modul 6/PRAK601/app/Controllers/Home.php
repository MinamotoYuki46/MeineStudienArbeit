<?php
    namespace App\Controllers;

    use App\Models\Students;

    class Home extends BaseController {
        public function index() {
            $student = new Students(
                'Muhammad Fauzan Ahsani', 
                '2310817310009', 
                'Teknologi Informasi',
                [
                    'Bermain rubik', 'mendengarkan musik', 'bermain gim'
                ],
                [
                    'C++', 'C', 'Java', 'Python', 'LaTeX', 'Fisika', 'Matematika', 
                'Arduino', 'Bahasa Jepang', 'Bahasa Inggris', 'Bahasa Indonesia'
                ],
                ['img1.jpg', 'img2.jpg'],
                'Tembilahan',
                '2 Juli 2005',
                'Universitas Lambung Mangkurat',
                '2023',
                '4',
                '3.82',
                '2310817310009@mhs.ulm.ac.id',
                'Barabai, Kalimantan Selatan',
                [
                    'Peserta OSN-K Bidang IPA tingkat SD 2016',
                    'Peserta OSN-k Bidang Fisika tingkat SMA 2022',
                    'Peserta terbaik Pelatihan TSA - Oracle Academy 2024'
                ]
            );
            return view('home', ['student' => $student]);
        }
    }