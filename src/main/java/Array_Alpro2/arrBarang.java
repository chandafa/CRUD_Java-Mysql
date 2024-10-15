// package Array_Alpro2;

// import java.util.Scanner;

// public abstract class arrBarang {
//     int N = 3;

//     Barang[] a = new Barang[N];

//     arrBarang() {

//     }

//     // Inisialisasi Array
//     void InitArray() {
//         for (int i = 0; i < N; i++) {
//             a[i].kode = "S";
//             a[i].nama = "S";
//             a[i].harga = 0;

//         }
//     }

//     // Membaca Array
//     void BacaArr() {
//         Barang B = new Barang();
//         Scanner sc = new Scanner(System.in);
//         for (int i = 0; i < N; i++) {
//             System.out.print("Nilai ke :" + i);
//             a[i].BacaBarang();

//             a[i] = B;
//             B.BacaBarang();

//             // System.out.print("Nilai ke :" + i); a[i].BacaBarang();
//         }
//     }

//     // Menampilkan array
//     void TampilArray() {
//         for (int i = 0; i < N; i++) {
//             System.out.println("L1[" + i + "]= " + L1[i]);
//             a[i].TampilBarang();
//         }
//     }

//     // Salin Array
//     static void Salin(arrBarang L1, arrBarang L2) {
//         for (int i = 0; i < L1.N; i++) {
//             L2.a[i] = L1.a[i];
//         }
//     }

//     public static void main(String[] args) {
//         arrBarang L = new arrBarang();
//         arrBarang L2 = new arrBarang();

//         L.InitArray();
//         L.TampilArray();
//         L.BacaArr();
//         L.TampilArray();
//         System.out.println("L2....");
//         L2.TampilArray();
//         Salin(L, L2);
//         L2.TampilArray();
//     }
// }

package Array_Alpro2;

import java.util.Scanner;

public class arrBarang {
    int N = 3; // Ukuran array
    Barang[] a = new Barang[N]; // Array untuk menyimpan objek Barang

    // Konstruktor untuk inisialisasi array objek Barang
    arrBarang() {
        for (int i = 0; i < N; i++) {
            a[i] = new Barang(); // Menginisialisasi setiap elemen array sebagai objek Barang
        }
    }

    // Method untuk membaca data setiap objek Barang dalam array
    void BacaArr() {
        for (int i = 0; i < N; i++) {
            System.out.println("Barang ke-" + (i + 1));
            a[i].BacaBarang(); // Memanggil method untuk membaca data barang
        }
    }

    // Method untuk menampilkan data setiap objek Barang dalam array
    void TampilArray() {
        for (int i = 0; i < N; i++) {
            System.out.println("Barang ke-" + (i + 1));
            a[i].TampilBarang(); // Memanggil method untuk menampilkan data barang
        }
    }

    // Method untuk menyalin isi array Barang dari satu objek arrBarang ke yang lain
    static void Salin(arrBarang L1, arrBarang L2) {
        for (int i = 0; i < L1.N; i++) {
            L2.a[i].kode = L1.a[i].kode;
            L2.a[i].nama = L1.a[i].nama;
            L2.a[i].harga = L1.a[i].harga;
        }
    }

    public static void main(String[] args) {
        // Membuat dua objek arrBarang
        arrBarang L = new arrBarang();
        arrBarang L2 = new arrBarang();

        // Membaca dan menampilkan data barang pada L
        L.BacaArr();
        L.TampilArray();

        // Menampilkan L2 sebelum penyalinan
        System.out.println("Sebelum disalin ke L2:");
        L2.TampilArray();

        // Menyalin data dari L ke L2
        Salin(L, L2);

        // Menampilkan L2 setelah penyalinan
        System.out.println("Setelah disalin ke L2:");
        L2.TampilArray();
    }
}
