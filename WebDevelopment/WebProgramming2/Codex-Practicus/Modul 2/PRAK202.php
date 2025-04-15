<?php 
    $student = array();
    $name = '';
    $id = '';
    $gender = '';
    $errNameMsg = $errIdMsg = $errGenderMsg = '';

    if (isset($_POST['submit'])) {
        $name = $_POST['name'] ?? '';
        $id = $_POST['id'] ?? '';
        $gender = $_POST['gender'] ?? '';

        $flag = true;
        if (empty($name)){
            $errNameMsg = "Nama tidak boleh kosong";
            $flag = false;
        }
        if (empty($id)){
            $errIdMsg = "NIM tidak boleh kosong";
            $flag = false;
        }
        if (empty($gender)){
            $errGenderMsg = "Jenis kelamin tidak boleh kosong";
            $flag = false;
        }

        if ($flag){
            $student = array($name, $id, $gender);
        }
    }
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Praktikum Web II Modul 2 Soal 2</title>
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
        <h1>Program Biodata</h1>

        <form action="" method="POST">
            <div class="field">
                <label>Nama:</label>
                <input type="text" name="name" value="<?php echo htmlspecialchars($name); ?>">
                <span style="color:red;">*</span>
                <span class="error"><?php echo $errNameMsg; ?></span>
            </div>

            <div class="field">
                <label>NIM: </label>
                <input type="text" name="id" value="<?php echo htmlspecialchars($id); ?>">
                <span style="color:red;">*</span>
                <span class="error"><?php echo $errIdMsg; ?></span>
            </div>

            <div class="field">
                <label>Jenis Kelamin: </label> <span style="color:red;">*</span>
                <span class="error"><?php echo $errGenderMsg; ?></span> <br>
                <input type="radio" name="gender" value="Laki-laki" <?php if ($gender == 'Laki-laki') echo 'checked'; ?>> Laki-laki <br>
                <input type="radio" name="gender" value="Perempuan" <?php if ($gender == 'Perempuan') echo 'checked'; ?>> Perempuan
            </div>

            <button name="submit" type="submit">Submit</button>
        </form> <br>

        <h1>Hasil</h1>
        <?php 
        if (!empty($student)) {
            echo '<div class="output-box">';
            echo 'Nama: ' . htmlspecialchars($student[0]) . "<br>";
            echo 'NIM: ' . htmlspecialchars($student[1]) . "<br>";
            echo 'Jenis Kelamin: ' . htmlspecialchars($student[2]) . "<br>";
            echo '</div>';
        }
        ?>
    </body>
</html>
