<?php
    class Peminjaman {
        private int $idPeminjaman;
        private int $idMember;
        private int $idBuku;
        private DateTime $tglPinjam;
        private DateTime $tglKembali; 

        public function __construct(int $idPeminjaman, int $idMember, int $idBuku, string $tglPinjam, string $tglKembali) {
            $this -> idPeminjaman = $idPeminjaman;
            $this -> idMember = $idMember;
            $this -> idBuku = $idBuku;
            $this -> tglPinjam = new DateTime($tglPinjam);
            $this -> tglKembali = new DateTime($tglKembali);
        }

        public function getIdPeminjaman(): int {
            return $this -> idPeminjaman;
        }

        public function setIdPeminjaman(int $idPeminjaman): void {
            $this -> idPeminjaman = $idPeminjaman;
        }

        public function getIdMember(): int {
            return $this -> idMember;
        }

        public function setIdMember(int $idMember): void {
            $this -> idMember = $idMember;
        }

        public function getIdBuku(): int {
            return $this -> idBuku;
        }

        public function setIdBuku(int $idBuku): void {
            $this -> idBuku = $idBuku;
        }

        public function getTglPinjam(): string {
            return $this -> tglPinjam -> format('Y-m-d');
        }

        public function setTglPinjam(string $tglPinjam): void {
            $this -> tglPinjam = new DateTime($tglPinjam);
        }

        public function getTglKembali(): string {
            return $this -> tglKembali -> format('Y-m-d');
        }

        public function setTglKembali(string $tglKembali): void {
            $this -> tglKembali = new DateTime($tglKembali);
        }
    }
?>