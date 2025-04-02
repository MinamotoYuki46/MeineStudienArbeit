<?php 
    $samsung = [
        "S22" => "Samsung Galaxy S22", 
        "S22+" => "Samsung Galaxy S22+", 
        "A03" => "Samsung Galaxy A03", 
        "Xcover5" => "Samsung Galaxy Xcover 5"];

    echo "
        <table border= '1px'>
            <tr>
                <th style='background-color: RED; height: 60px; font-size: 18pt'>Daftar Smartphone Samsung</th>
            </tr>
            <tr>
                <td>
                    " . $samsung["S22"]. "
                </td>
            </tr>
            <tr>
                <td>
                    " . $samsung["S22+"] . "
                </td>
            </tr>
            <tr>
                <td>
                    " . $samsung["A03"] . "
                </td>
            </tr>
            <tr>
                <td>
                    " . $samsung["Xcover5"] . "
                </td>
            </tr>
        </table>
        ";
?>