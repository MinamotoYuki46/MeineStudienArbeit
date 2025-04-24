<?php
    $students = [
        [
            'name' => "Ridho", 
            'subjects' => [
                ['name' => "Pemrograman I", 'credit' => 2], 
                ['name' => "Praktikum Pemrogaman I", 'credit' => 1], 
                ['name' => "Pengantar Lingkungan Lahan Basah", 'credit' => 2], 
                ['name' => "Arsitektur Komputer",'credit' => 3]
            ]
        ],
        [
            'name' => "Ratna", 
            'subjects' => [
                ['name' => "Basis Data I", 'credit' => 2], 
                ['name' => "Praktikum Basis Data I", 'credit' => 1], 
                ['name' => "Kalkulus", 'credit' => 3]
            ]
        ],
        [
            'name' => "Tono", 
            'subjects' => [
                ['name' => "Rekayasa Perangkat Lunak", 'credit' => 3], 
                ['name' => "Analisis dan Perancangan Sistem", 'credit' => 3], 
                ['name' => "Komputasi Awan", 'credit' => 3],
                ['name' => "Kecerdasan Bisnis", 'credit' => 3]
            ]
        ]
    ];
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Praktikum Web II Modul 4 Soal 3</title>

        <style>
            table {
                border-collapse: collapse;
            }

            th, td {
                border: 1px solid black;
                padding: 8px 12px;
                text-align: center;
            }

            th {
                background-color: grey;
                font-weight: bold;
                color: black;
            }

        </style>

    </head>
    <body>
        <table>
            <tr style="background-color: grey; font-style: bold;">
                <th>No</th>
                <th>Nama</th>
                <th>Mata Kuliah diambil</th>
                <th>SKS</th>
                <th>Total SKS</th>
                <th>Keterangan</th>
            </tr>

            <?php
                $i = 1;
                foreach ($students as $student) {
                    $totalCredit = 0;
                    $subjects = $student['subjects'];
                    $rowspan = count($subjects);

                    foreach($student['subjects'] as $subject) $totalCredit += $subject['credit'];

                    $pass = ($totalCredit > 7) ? "Tidak Revisi" : "Revisi SKS";
                    $bg = ($totalCredit > 7) ? "#00af50" : "red";

                    echo '
                        <tr>
                            <td rowspan="' . $rowspan . '">' . $i . '</td>
                            <td rowspan="' . $rowspan . '">' . $student['name'] . '</td>
                            <td>' . $subjects[0]['name'] . '</td>
                            <td>' . $subjects[0]['credit'] . '</td>
                            <td rowspan="' . $rowspan . '">' . $totalCredit . '</td>
                            <td rowspan="' . $rowspan . '" style="background-color: ' . $bg . '">' . $pass . '</td>
                        </tr>
                    ';

                    for ($j = 1; $j < $rowspan; $j++) {
                        echo '<tr>';
                        echo '<td>' . $subjects[$j]['name'] . '</td>';
                        echo '<td>' . $subjects[$j]['credit'] . '</td>';
                        echo '</tr>';
                    }

                    $i++;
                }
            ?>
        </table>
    </body>
</html>