<?php 
    $celcius = 37.841;

    $fahrenheit = ($celcius * 9 / 5) + 32;
    $reamur = (4 / 5) * $celcius;
    $kelvin = $celcius + 273.15;

    echo "
        Celcius: " . number_format($celcius, 3) . "<br>
        Fahrenheit (F): " . number_format($fahrenheit, 4, ',') . "<br>
        Reamur (R): " . number_format($reamur, 4, ',') . "<br>
        Kelvin (K): " . number_format($kelvin, 4, ',') . "<br>"
    ;
?>