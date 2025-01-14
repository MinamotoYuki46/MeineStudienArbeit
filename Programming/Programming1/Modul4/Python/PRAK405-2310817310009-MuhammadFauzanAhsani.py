var = input().split()
val1, val2 = map(int, var)

for i in range(1, val1 + 1):
    for j in range(i):
        if (i == j + 1):
            print(f"({i-j} * {val2}) = ", end = "")
        else:
            print(f"({i-j} * {val2}) + ", end ="")
    print(f"{(i * (i + 1) * val2 / 2):.0f}")
print(f"{(val1 * (val1 + 1) * (val1 + 2) * val2 / 6):.0f}")
