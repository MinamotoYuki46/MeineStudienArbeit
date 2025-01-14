import numpy as np

dimension = int(input())

print("Matriks A")
numberA = [list(map(int, input().split())) for _ in range(dimension)]
arrA = np.array(numberA).reshape(dimension, dimension)

print("Matriks B")
numberB = [list(map(int, input().split())) for _ in range(dimension)]
arrB = np.array(numberB).reshape(dimension, dimension)

print("Matriks AXB")
result = np.dot(arrA, arrB)

for i in result:
    for j in i:
        print(j, end=" ")
    print()
