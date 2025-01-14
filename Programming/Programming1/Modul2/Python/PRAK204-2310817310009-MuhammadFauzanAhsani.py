radius, height = input().split()
radius, height = map(float, (radius, height))
pi = 22.00/7.00

print(f"Volume = {radius**2 * pi * height:.2f}")
print(f"Luas = {2 * ((pi * radius) * (radius + height)):.2f}")
print(f"Keliling = {2 * pi * radius:.2f}")