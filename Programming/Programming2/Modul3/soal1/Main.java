package Modul3.soal1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Dadu> ListDadu = new LinkedList<>();

        int n = sc.nextInt();
        int sum = 0;

        for(int i = 0; i < n; i++){
            ListDadu.add(new Dadu());
            System.out.printf("Dadu ke-%d bernilai %d\n", i + 1, ListDadu.get(i).getNilai());
            sum += ListDadu.get(i).getNilai();
        }

        System.out.println("Total nilai dadu keseluruhan " + sum);

        sc.close();
    }
}