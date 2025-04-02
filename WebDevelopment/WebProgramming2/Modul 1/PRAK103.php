<?php 
    $celcius = 37.841;

    $fahrenheit = ($celcius * 9 / 5) + 32;
    $reamur = (4 / 5) * $celcius;
    $kelvin = $celcius + 273.15;

    echo "
        Celcius: $celcius <br>
        Fahrenheit: $fahrenheit <br>
        Reamur: $reamur <br>
        Kelvin: $kelvin
    ";
?>
