<?php 
    $num = 0;
    $img = '';

    if(isset($_POST['num'])) $num = $_POST['num'];
    if(isset($_POST['img'])) $img = $_POST['img'];
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Praktikum Web II Modul 3 Soal 2</title>
        <style>
            .img {
                height: 30px;
                width: 30px;
            }
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
                <label>Tinggi: </label><br>
                <input type="number" name="num" value="<?php echo htmlspecialchars($num); ?>">
            </div>
            
            <div class="field">
                <label>Alamat gambar: </label><br>
                <input type="text" name="img" value="<?php echo htmlspecialchars($img); ?>">
            </div>
            

            <button type="submit">Cetak</button>
        </form>

        <h1>Hasil</h1>
        <div class="output-box">
            <?php 
                $i = 0;
                while ($i < $num) {
                    $j = 0;
                    while ($j < $num) {
                        if ($j < $i)    echo "<img src='" . htmlspecialchars($img) . "' class='img' style='visibility: hidden;'>";
                        else            echo "<img src='" . htmlspecialchars($img) . "' class='img'>";

                        $j++;
                    }
                    echo '<br>';
                    $i++;
                }
            ?>
        </div>
    </body>
</html>