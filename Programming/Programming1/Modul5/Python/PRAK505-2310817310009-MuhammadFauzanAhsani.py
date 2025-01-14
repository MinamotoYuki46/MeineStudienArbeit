def Biodata(year:int, name:str, dom:str):
    tahun_sekarang = 2023
    print(f"Perkenalkan Nama Saya : {name}")
    print(f"Umur saya : {tahun_sekarang - year}")
    print(f"Saya Adalah Angkatan : {year}")
    print(f"Asal saya dari : {dom}")
    
tahunLahir = int(input())
Namaku = input()
Asal = input()

Biodata(tahunLahir, Namaku, Asal)