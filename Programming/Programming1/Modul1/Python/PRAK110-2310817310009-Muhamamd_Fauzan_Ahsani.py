import math

base = 5
height = 12
hypotenuse = math.sqrt(base**2 + height**2 )
hypotenuse = int(hypotenuse)  

print(f"Diketahui : \nAlas = {base} cm \nTinggi = {height} cm\n")
print(f"Jawab : \nSisi A = {height} cm\nSisi B = {base} cm\nSisi C = {hypotenuse} cm" )
print(f"Keliling = {base + height + hypotenuse} cm\nLuas = {int(.5 * base * height)} cm" )