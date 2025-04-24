<?php 
    $num = 0;

    if (isset($_POST['submit'])) {
        $num = $_POST['num'];
    }

    $img = "star.png";

    if (isset($_POST['tambah'])) {
        $num++;
    }

    if (isset($_POST['kurang'])) {
        $num--;
        if ($num < 0) $num = 0;
    }

    function printImg($num, $img){
        for($i = 0; $i < $num; $i++){
            echo '<img src="'. $img . '" class="img">';
        }
    }
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Praktikum Web II Modul 3 Soal 4</title>
        <style>
            .img {
                height: 50px;
                width: 50px;
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

        <?php if ($num === 0): ?>
            <form method="POST">
                <div class="field">
                    <label>Jumlah: </label><br>
                    <input type="number" name="num" min="0"><br><br>
                </div>
                <button type="submit" name="submit">Cetak</button>
            </form>
        <?php else: ?>
            <p>Jumlah: <?php echo $num; ?></p>
            <h1>Hasil: </h1>
            <div class="output-box">
                <?php printImg($num, $img); ?>
            </div>
            <br><br>
            <form method="POST">
                <div class="field">
                    <input type="hidden" name="num" value="<?php echo $num; ?>">
                </div>
                <button type="submit" name="tambah">Tambah</button>
                <button type="submit" name="kurang">Kurang</button>
            </form>
        <?php endif; ?>

    </body>
</html>
