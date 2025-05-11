<?php
    class Member {
        private int $idMember;
        private string $namaMember;
        private string $nomorMember;
        private string $alamat;
        private DateTime $tglMendaftar;
        private DateTime $tglTerakhirBayar;

        public function __construct(int $idMember, string $namaMember, string $nomorMember, string $alamat, string $tglMendaftar, string $tglTerakhirBayar) {
            $this -> idMember = $idMember;
            $this -> namaMember = $namaMember;
            $this -> nomorMember = $nomorMember;
            $this -> alamat = $alamat;
            $this -> tglMendaftar = new DateTime($tglMendaftar);  
            $this -> tglTerakhirBayar = new DateTime($tglTerakhirBayar);  
        }

        public function getIdMember(): int {
            return $this -> idMember;
        }

        public function setIdMember(int $idMember): void {
            $this -> idMember = $idMember;
        }

        public function getNamaMember(): string {
            return $this -> namaMember;
        }

        public function setNamaMember(string $namaMember): void {
            $this -> namaMember = $namaMember;
        }

        public function getNomorMember(): string {
            return $this -> nomorMember;
        }

        public function setNomorMember(string $nomorMember): void {
            $this -> nomorMember = $nomorMember;
        }

        public function getAlamat(): string {
            return $this -> alamat;
        }

        public function setAlamat(string $alamat): void {
            $this -> alamat = $alamat;
        }

        public function getTglMendaftar(): string {
            return $this -> tglMendaftar -> format('Y-m-d H:i:s');
        }

        public function setTglMendaftar(string $tglMendaftar): void {
            $this -> tglMendaftar = new DateTime($tglMendaftar);
        }

        public function getTglTerakhirBayar(): string {
            return $this -> tglTerakhirBayar -> format('Y-m-d');
        }

        public function setTglTerakhirBayar(string $tglTerakhirBayar): void {
            $this -> tglTerakhirBayar = new DateTime($tglTerakhirBayar);
        }
    }
?>
