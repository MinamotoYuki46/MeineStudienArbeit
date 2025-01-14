#include<iostream>
#include <string>
using namespace std;

struct vehicle{
    string plate, type, owner, address, city;
};

int main(){
    vehicle meineVehicle;
    meineVehicle.plate = "DA1234MK";
    meineVehicle.type = "RUSH";
    meineVehicle.owner = "Andika Hartanto";
    meineVehicle.address = "Jl. Kayu Tangi 1";
    meineVehicle.city = "Banjarmasin";

    cout << "Plat Nomor Kendaraan : " << meineVehicle.plate << endl;
    cout << "Jenis Kendaraan : " << meineVehicle.type << endl;
    cout << "Nama Pemilik : " << meineVehicle.owner << endl;
    cout << "Alamat : " << meineVehicle.address << endl;
    cout << "Kota : " << meineVehicle.city << endl;

    return 0;
}