int isEmpty(){
    //if(head == NULL) return 1;
    //else return 0;
}

void tambahDepan(){
    cout << "Masukkan data : ";
    TNode *baru;
    baru = new TNode;
    cin >> dataBaru;
    baru -> data = dataBaru;
    baru -> next = baru;

    if(isEmpty() == 1){
        head = baru;
        tail = baru;
    }
    else{
        baru -> next = head;
        head = baru;
        tail -> next = head;
    }
    cout << "Data \"" << dataBaru << "\" berhasil dimasukkan di bagian depan" << endl;
}