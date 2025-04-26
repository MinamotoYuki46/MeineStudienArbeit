<?php
    $students = [
        ['name' => "Andi", "id" => "2101001", "mid_pts" => 87, "fin_pts" => 65],
        ['name' => "Budi", "id" => "2101002", "mid_pts" => 76, "fin_pts" => 79],
        ['name' => "Tono", "id" => "2101003", "mid_pts" => 50, "fin_pts" => 41],
        ['name' => "Jessica", "id" => "2101004", "mid_pts" => 60, "fin_pts" => 75]
    ];

    function letterGrade($val): string {
        if      ($val >= 80)                return 'A';
        else if ($val <= 79 && $val >= 70 ) return 'B';
        else if ($val <= 69 && $val >= 60 ) return 'C';
        else if ($val <= 59 && $val >= 50 ) return 'D';
        else                                return 'E';
    }
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Praktikum Web II Modul 4 Soal 2</title>

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
                background-color: #d0cece;
                font-weight: bold;
                color: black;
            }

        </style>

    </head>
    <body>
        <table>
            <tr style="font-style: bold;">
                <th>Nama</th>
                <th>NIM</th>
                <th>Nilai UTS</th>
                <th>Nilai UAS</th>
                <th>Nilai Akhir</th>
                <th>Huruf</th>
            </tr>

            <?php
                foreach ($students as $student) {
                    $res = ($student['mid_pts'] * .4 + $student['fin_pts'] *.6);
                    echo '
                        <tr>
                            <td>' . $student['name'] . '</td>
                            <td>' . $student['id'] . '</td>
                            <td>' . $student['mid_pts'] . '</td>
                            <td>' . $student['fin_pts'] . '</td>
                            <td>' . $res . '</td>
                            <td>' . letterGrade($res). '</td>
                        </tr>
                    ';
                }
            ?>
        </table>
    </body>
</html>