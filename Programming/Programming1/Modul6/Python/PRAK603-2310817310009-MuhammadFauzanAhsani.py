import numpy as np

column1, column2 = map(int, input().split())
if (column1 != column2):
    print("Jumlah tidak sama")
    
else:
    number1 = list(map(int, input().split()))
    number2 = list(map(int, input().split()))

    arr1 = np.array(number1).reshape(1, column1)
    arr2 = np.array(number2).reshape(1, column2)

    for i in range(column1):
        print(arr1[0,i] * arr2[0,i], end=" ")