#include <iostream>
using namespace std;

int main(){

    int A = 10;
    int* ptr_A = &A;

    cout << ptr_A << " " << *ptr_A;
    return 0;
}