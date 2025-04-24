<?php 
    $upper = 0;
    $lower = 0;

    if (isset($_POST['submit'])) {
        $upper = $_POST['upper'];
        $lower = $_POST['lower'];
    }

    $img = "star.png";
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Praktikum Web II Modul 3 Soal 3</title>
        <style>
            .img {
                height: 10px;
                width: 10px;
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
                <label>Batas Bawah: </label><br>
                <input type="number" name="lower" value="<?php echo htmlspecialchars($lower); ?>"><br>
            </div>

            <div class="field">
                <label>Batas Atas: </label><br>
                <input type="number" name="upper" value="<?php echo htmlspecialchars($upper); ?>"><br>
            </div>

            <button type="submit">Cetak</button>
        </form>

        <h1>Hasil: </h1>
            <div class="output-box">
                <?php 
                    $i = $lower;
                    do {
                        if ((($i + 7) % 5) == 0)
                            echo '<img src="'. $img . '" class="img"> ';
                        else
                            echo $i . ' ';
                        $i++;
                    } while ($i <= $upper);
                ?>
            </div>
    </body>
</html>
