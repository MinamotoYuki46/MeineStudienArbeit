def reverse(x:int):
    temp = x
    ret = 0

    while (temp > 0):
        ret = (ret * 10) + (temp % 10)
        temp //= 10
    return ret

A, B = map(int, input().split())
A = reverse(A)
B = reverse(B)
C = A + B
print(reverse(C))