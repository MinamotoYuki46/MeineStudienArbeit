<?php
    class Buku {
        private int $idBuku;
        private string $judulBuku;
        private string $penulis;
        private string $penerbit;
        private int $tahunTerbit;

        public function __construct(int $idBuku, string $judulBuku, string $penulis, string $penerbit, int $tahunTerbit) {
            $this -> idBuku = $idBuku;
            $this -> judulBuku = $judulBuku;
            $this -> penulis = $penulis;
            $this -> penerbit = $penerbit;
            $this -> tahunTerbit = $tahunTerbit;
        }

        public function getIdBuku(): int {
            return $this -> idBuku;
        }

        public function setIdBuku(int $idBuku): void {
            $this -> idBuku = $idBuku;
        }

        public function getJudulBuku(): string {
            return $this -> judulBuku;
        }

        public function setJudulBuku(string $judulBuku): void {
            $this -> judulBuku = $judulBuku;
        }

        public function getPenulis(): string {
            return $this -> penulis;
        }

        public function setPenulis(string $penulis): void {
            $this -> penulis = $penulis;
        }

        public function getPenerbit(): string {
            return $this -> penerbit;
        }

        public function setPenerbit(string $penerbit): void {
            $this -> penerbit = $penerbit;
        }

        public function getTahunTerbit(): int {
            return $this -> tahunTerbit;
        }

        public function setTahunTerbit(int $tahunTerbit): void {
            $this -> tahunTerbit = $tahunTerbit;
        }
    }
?>
