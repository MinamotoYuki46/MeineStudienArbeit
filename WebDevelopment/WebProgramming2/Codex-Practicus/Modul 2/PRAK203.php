<?php
    define('C_RATE', 5); 
    define('R_RATE', 4); 
    define('F_RATE', 9);
    define('K_SHIFT', 273.15);
    define('F_SHIFT', 32);

    function convertTemperature($temp, $src, $dst): float {
        if (!is_numeric($temp)) return 0;

        switch ($src) {
            case 'Celcius':
                $celsius = $temp;
                break;
            case 'Reaumur':
                $celsius = $temp * C_RATE / R_RATE;
                break;
            case 'Fahrenheit':
                $celsius = ($temp - F_SHIFT) * C_RATE / F_RATE;
                break;
            case 'Kelvin':
                $celsius = $temp - K_SHIFT;
                break;
            default:
                return 0; 
        }

        switch ($dst) {
            case 'Celcius':
                return $celsius;
            case 'Reaumur':
                return $celsius * R_RATE / C_RATE;
            case 'Fahrenheit':
                return ($celsius * F_RATE / C_RATE) + F_SHIFT;
            case 'Kelvin':
                return $celsius + K_SHIFT;
            default:
                return 0; 
        }
    }

    $temperature = $_GET['temperature'] ?? '';
    $unit = ['Celcius', 'Reaumur', 'Fahrenheit', 'Kelvin'];
    $symbol = ['Celcius' => '°C', 'Reaumur' => '°Ré', 'Fahrenheit' => '°F', 'Kelvin' => 'K'];
    $src = $_GET['src'] ?? '';
    $dst = $_GET['dst'] ?? '';
    $result = '';

    if (isset($_GET['submit'])) {
        if (is_numeric($temperature) && $src && $dst) {
            $result = convertTemperature($temperature, $src, $dst);
        } else {
            $result = 'Masukan invalid. Cek masukan dan suhu yang dipilih!';
        }
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
        <h1>Program Konversi Suhu</h1>
        <form action="" method="GET">
            <div class="field">
                <label>Nilai:</label>
                <input type="number" name="temperature" value="<?php echo htmlspecialchars($temperature); ?>" step="any"> 
            </div>
            <div class="field">
                <label>Dari:</label> <br>
                <?php foreach ($unit as $i): ?>
                    <label>
                        <input type="radio" name="src" value="<?= $i ?>" <?= ($src === $i) ? 'checked' : '' ?> required>
                        <?= $i ?>
                    </label><br>
                <?php endforeach; ?>
            </div>
            <div class="field">
                <label>Ke: </label><br>
                <?php foreach ($unit as $i): ?>
                    <label>
                        <input type="radio" name="dst" value="<?= $i ?>" <?= ($dst === $i) ? 'checked' : '' ?> required>
                        <?= $i ?>
                    </label><br>
                <?php endforeach; ?>
            </div>
            <button name="submit" type="submit">Konversi</button>
        </form>

        <h1>Hasil:</h1>
        <?php 
            if (isset($_GET['submit'])) {
                echo '<div class="output-box">';
                if (is_numeric($result)) {
                    echo "<h1>" . number_format($result, 2) . " " . $symbol[$dst] . "</h1>";
                } else {
                    echo "<h1>" . $result . "</h1>";
                }
                echo '</div>';
            } else {
                echo '<div class="output-box">';
                echo "Silahkan masukkan nilai suhu dan pilih satuan suhu yang ingin dikonversi.";
                echo '</div>';
            }
        ?>
    </body>
</html>