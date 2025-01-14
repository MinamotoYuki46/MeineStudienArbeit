import math

a, b = input().split()
a, b = map(float, (a, b))
c = math.sqrt(b**2 - a**2)

print(f"Alas = {c:.0f} cm")
print(f"Tinggi = {a:.0f} cm")
print(f"Keliling = {a+b+c:.0f} cm")
print(f"Luas = {.5 * a * c:.0f} cm^2")
