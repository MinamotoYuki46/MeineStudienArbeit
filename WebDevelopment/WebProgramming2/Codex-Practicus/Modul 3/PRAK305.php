<?php
    $str = '';
    $res = '';

    if (isset($_POST['submit'])) {
        $str = $_POST['word'];
        $n = strlen($str);
        $res = printWord($str, $n);
    }

    function printWord($str, $n): string {
        $res = '';
        for($i = 0; $i < $n; $i++){
            if(ctype_alpha($str[$i])){
                $res .= strtoupper($str[$i]);
                for($j = 1; $j < $n; $j++){
                    $res .= strtolower($str[$i]);
                }
            }
        }
        return $res;
    }
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Praktikum Web II Modul 3 Soal 5</title>

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
        <form action="" method="POST">
            <div class="field">
                <label>Masukkan kata: </label><br>
                <input type="text" name="word">
            </div>
            <button type="submit" name="submit">Cetak</button>
        </form>

        <h1>Input: </h1> 
        <div class="output-box">
            <p><?php echo htmlspecialchars($str); ?></p>
        </div>

        <h1>Output: </h1> 
        <div class="output-box">
            <p><?php echo htmlspecialchars($res); ?></p>
        </div>
    </body>
</html>
