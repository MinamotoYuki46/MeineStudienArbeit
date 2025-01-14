while True:
    print('''
Pilih program
1. Penjumlahan
2. Pengurangan
3. Perkalian
4. Pembagian
5. Exit
''', end = "")
    selector = int(input("Masukkan pilihan : "))

    if (selector < 5):
        val1 = int(input("Masukkan nilai pertama :"))
        val2 = int(input("Masukkan nilai kedua : "))

        if (selector == 1):
            print(f"Hasil penjumlahan antata {val1:.2f} dengan {val2:.2f} adalah {(val1 + val2):.2f} ")

        elif (selector == 2):
            print(f"Hasil pengurangan antata {val1:.2f} dengan {val2:.2f} adalah {(val1 - val2):.2f} ")

        elif (selector == 3):
            print(f"Hasil perkalian antata {val1:.2f} dengan {val2:.2f} adalah {(val1 * val2):.2f} ")

        elif (selector == 4):
            print(f"Hasil pembagian antata {val1:.2f} dengan {val2:.2f} adalah {(val1 / val2):.2f} ")

    elif (selector == 5):
        print("Terimakasih, telah menggunakan kalkulator Muhammad Fauzan Ahsani")
        break
    else:
        print("Input anda salah, silahkan coba lagi")