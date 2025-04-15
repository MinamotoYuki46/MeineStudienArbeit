<?php 
    $arrName = array();

    if (isset($_POST['sort'])) {
        $name1 = $_POST['name1'] ?? '';
        $name2 = $_POST['name2'] ?? '';
        $name3 = $_POST['name3'] ?? '';

        $arrName = array($name1, $name2, $name3);

        sort($arrName);
    }
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Praktikum Web II Modul 2 Soal 1</title>

        <style>
            .output-box {
                border: 1px solid #ccc;
                padding: 10px;
                width: fit-content;
                background-color: #f9f9f9;
                border-radius: 5px;
                margin-top: 10px;
            }
            .error {
                color: red;
                font-size: 0.9em;
            }
            .field {
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <h1>Program Pengurut Nama</h1>

        <form action="" method="POST">
            <div class="field">
                <label >Nama 1: </label>
                <input type="text" name="name1" value="<?php echo htmlspecialchars($name1 ?? ''); ?>">
            </div>

            <div class="field">
                <label >Nama 2: </label>
                <input type="text" name="name2" value="<?php echo htmlspecialchars($name2 ?? ''); ?>">
            </div>

            <div class="field">
                <label >Nama 3: </label>
                <input type="text" name="name3" value="<?php echo htmlspecialchars($name3 ?? ''); ?>">
            </div>

            <button name="sort" type="submit">Urutkan</button>
        </form> <br>

        <h1>Hasil</h1>
        <?php 
        if (!empty($arrName)) {
            echo '<div class="output-box">';
            foreach ($arrName as $name) {
                echo htmlspecialchars($name) . "<br>";
            }
            echo '</div>';
        }
        ?>
    </body>
</html>
