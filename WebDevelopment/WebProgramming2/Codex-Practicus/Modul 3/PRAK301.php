<?php 
    $num = 0;
    if(isset($_POST['submit'])) $num = $_POST['num'];
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Praktikum Web II Modul 3 Soal 1</title>

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
                <label >Masukkan jumlah peserta: </label> <br>
                <input type="number" name="num" value="<?php echo htmlspecialchars($num ?? ''); ?>">
            </div>
            
            <button type="submit">Cetak</button>
        </form>
        <h1>Hasil</h1>
        <div class="output-box">
            <?php 
                $i = 1;
                while($i <= $num){
                    if ($i & 1){
                        echo '<h1 style="color:red">Peserta ke-' . $i . '</h1>';
                    }
                    else {
                        echo '<h1 style="color:green">Peserta ke-' . $i . '</h1>';
                    }
                    $i++;
                }
            ?>
        </div>
        
    </body>
</html>