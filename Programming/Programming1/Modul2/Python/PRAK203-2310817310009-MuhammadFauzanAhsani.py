a, b, i, j, x, y = input().split()
a, b, i, j, x, y = map(float, (a, b, i, j, x, y))

print(f"{(a-b) * i / j - (x + y):.3f}")