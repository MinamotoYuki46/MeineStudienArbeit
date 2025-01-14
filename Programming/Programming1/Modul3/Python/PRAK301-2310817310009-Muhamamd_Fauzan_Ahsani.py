number = input().split()
num1, num2 = map(int, number)

if num1 > num2:
    print(f"{num2} {num1}")
elif num1 < num2:
    print(f"{num1} {num2}")