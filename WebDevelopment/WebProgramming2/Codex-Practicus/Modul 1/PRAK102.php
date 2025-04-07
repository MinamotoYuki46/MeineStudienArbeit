<?php 
    $panjang = 8.9;
    $lebar = 14.7;
    $tinggi = 5.4;

    $volumeLimasSegiEmpat = (1 / 3) * $panjang * $lebar * $tinggi;

    echo number_format($volumeLimasSegiEmpat, 3, ',', ) . " m3";
?>