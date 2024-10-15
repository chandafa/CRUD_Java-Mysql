// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//  */
// package Array_Alpro2;

// /**
//  *
//  * @author CHAN
//  */
// public class larikint {

//     int N = 3;

//     int[] a = new int[N];

//     void BacaArray() {

//     }

//     void TampilArray() {
//         for (int i = 0; i < N; i++) {
//             System.out.println("a["+i+"]= " + a[i]);
//         }

//     }

//     public static void main(String[] args) {
//         larikint L = new larikint();

//         L.BacaArray();
//         L.TampilArray();

//     }
// }

// [Benar]
package Array_Alpro2;

import java.util.Scanner;

/**
 *
 * @author CHAN
 */
public class larikint {

    int N = 3; // Ukuran array untuk kedua larik
    int[] L1 = new int[N]; // Array pertama
    int[] L2 = new int[N]; // Array kedua

    // Method untuk membaca input dan mengisi kedua array secara manual
    void BacaArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan nilai untuk array L1:");
        for (int i = 0; i < N; i++) {
            System.out.print("L1[" + i + "]: ");
            L1[i] = sc.nextInt(); // Membaca input untuk L1
        }

        System.out.println("Masukkan nilai untuk array L2:");
        for (int i = 0; i < N; i++) {
            System.out.print("L2[" + i + "]: ");
            L2[i] = sc.nextInt(); // Membaca input untuk L2
        }
    }

    // Method untuk menampilkan isi kedua array
    void TampilArray() {
        System.out.println("Isi array L1:");
        for (int i = 0; i < N; i++) {
            System.out.println("L1[" + i + "]= " + L1[i]);
        }

        System.out.println("Isi array L2:");
        for (int i = 0; i < N; i++) {
            System.out.println("L2[" + i + "]= " + L2[i]);
        }
    }

    public static void main(String[] args) {
        // Membuat objek larikint
        larikint L = new larikint();

        // Memanggil method untuk membaca input dan menampilkan array
        L.BacaArray(); // Input manual untuk L1 dan L2
        L.TampilArray(); // Menampilkan hasil input
    }
}
