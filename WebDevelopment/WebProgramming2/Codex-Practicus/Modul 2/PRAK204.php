<?php
    $num = (float) $_GET['number'] ?? '';
    $count = (int) log10($num) + 1;
    $digit = [1 => 'Satuan', 2 => 'Puluhan', 3 => 'Ratusan'];

    if (!is_numeric($num)){
        $result = 'Masukkan angka dari 0 hingga 999';
    }
    else if ($num >= 1000){
        $result = 'Anda Menginput Melebihi Limit Bilangan';
    }
    else if ($num < 0){
        $result = 'Anda Mengingput Kurang dari Limit Bilangan';
    }
    else if ($num == 0){
        $result = 'Nol';
    }
    else if ($num >= 11 && $num<= 19){
        $result = 'Belasan';
    }
    else{
        $result = $digit[$count];
    }
?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Praktikum Web II Modul 2 Soal 3</title>

    <style>
        .output-box {
            border: 1px solid #ccc;
            padding: 10px;
            width: fit-content;
            background-color: #f9f9f9;
            border-radius: 5px;
            margin-top: 10px;
        }
        .field {
            margin-bottom: 10px;
        }
    </style>

    </head>
    <body>
        <h1>Program Penghitung Digit</h1>

        <form action="" method="GET">
            <div class="field">
                <label for="number">Nilai: </label>
                <input type="text" name="number" id="number" value="<?php echo htmlspecialchars($num ?? ''); ?>">
            </div>

            <button name="submit" type="submit">Konversi</button>
        </form>

        <h1>Hasil: </h1>
        <?php 
            if (isset($_GET['submit'])) {
                echo '
                    <div class="output-box">
                        <h1>' . $result . '</h1>
                    </div>
                ';
            }
        ?>
    </body>
</html>