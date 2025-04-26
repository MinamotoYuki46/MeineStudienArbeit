<?php 
    $nums = [];

    if (isset($_POST['submit'])){
        $length = $_POST['length'] ?? 0;
        $width = $_POST['width'] ?? 0;
        $nums = isset($_POST['nums']) ? explode(' ', $_POST['nums']) : [];
    }

    function printNums($nums, $length, $width){
        $n = sizeof($nums);

        if ($n > $length * $width){
            echo 'Panjang nilai melebihi ukuran matriks yang didefinisikan di atas';
            return;
        }

        echo '<table style="border-collapse: collapse;">';
        for($i = 0; $i < $length; $i++){
            echo '<tr>';
            for($j = 0; $j < $width; $j++){
                $value = isset($nums[$i * $width + $j]) ? $nums[$i * $width + $j] : '&nbsp;';
                echo '<td style="border: 1px solid black; padding: 5px; text-align: center;">' . $value . '</td>';
            }
            echo '</tr>';
        }
        echo '</table>';
    }
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Praktikum Web II Modul 4 Soal 1</title>
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
        <form method="POST">
                <div class="field">
                    <label >Panjang: </label>
                    <input type="number" name="length" value="<?php echo htmlspecialchars($length ?? ''); ?>"> 
                </div>

                <div class="field">
                    <label >Lebar: </label> 
                    <input type="number" name="width" value="<?php echo htmlspecialchars($width ?? ''); ?>"> 
                </div>

                <div class="field">
                    <label >Nilai: </label> 
                    <input type="text" name="nums" value="<?php echo htmlspecialchars(implode(' ', $nums) ?? ''); ?>"> 
                </div>
                <button type="submit" name="submit">Cetak</button>
        </form>
        <h1>Output</h1>
        <div class="output-box">
            <?php 
                if (isset($_POST['submit'])){
                    printNums($nums, $length, $width);
                }
            ?>
        </div>
    </body>
</html>