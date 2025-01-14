def mutlak(angka:int):
    return abs(angka)

def hitung(nilai1:int, nilai2:int):
    return mutlak(nilai1 - nilai2)

a, c, b, d = map(int, input().split())
Hasil = hitung(a,b) + hitung(c,d)
print(mutlak(Hasil))