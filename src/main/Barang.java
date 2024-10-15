// note :

// class :
// Barang

// atribut :
// Kode
// Nama
// Harga
// Jenis

// package Array_Alpro2;

// import java.util.Scanner;

// /**
//  *
//  * @author CHAN
//  */
// public class Barang {
//     String kode, nama;
//     double harga;

//     // Method untuk membaca data barang dari input
//     void BacaBarang() {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Kode : ");
//         kode = sc.nextLine();
//         System.out.print("Nama : ");
//         nama = sc.nextLine();
//         System.out.print("Harga : ");
//         harga = sc.nextDouble();
//     }

//     // Method untuk menampilkan data barang
//     void TampilBarang() {
//         System.out.println("Kode: " + kode + ", Nama: " + nama + ", Harga: " + harga);
//     }

//     public static void main(String[] args) {
//         // Membuat objek barang dan membaca serta menampilkan data barang
//         Barang B = new Barang();
//         B.BacaBarang();
//         B.TampilBarang();
//     }
// }

package Array_Alpro2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Barang {
    String kode, nama;
    double harga;

    // Koneksi ke database
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://127.0.0.1:3306/barang_db";
        String user = "root"; // Sesuaikan dengan user MySQL Anda
        String password = ""; // Sesuaikan dengan password MySQL Anda
        return DriverManager.getConnection(url, user, password);
    }

    // Method untuk membaca data barang dari input
    void BacaBarang() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Kode : ");
        kode = sc.nextLine();
        System.out.print("Nama : ");
        nama = sc.nextLine();
        System.out.print("Harga : ");
        harga = sc.nextDouble();
    }

    // Method untuk menampilkan data barang
    void TampilBarang() {
        System.out.println(kode + " " + nama + " " + harga);
    }

    // Simpan data barang ke database
    public void simpanKeDatabase() throws SQLException {
        Connection conn = getConnection();
        String query = "INSERT INTO barang (kode, nama, harga) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, kode);
        stmt.setString(2, nama);
        stmt.setDouble(3, harga);
        stmt.executeUpdate();
        conn.close();
    }

    // Method untuk mengambil data barang dari database berdasarkan kode
    public void ambilDariDatabase(String kodeBarang) throws SQLException {
        Connection conn = getConnection();
        String query = "SELECT * FROM barang WHERE kode = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, kodeBarang);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            kode = rs.getString("kode");
            nama = rs.getString("nama");
            harga = rs.getDouble("harga");
        } else {
            System.out.println("Barang tidak ditemukan.");
        }
        conn.close();
    }

    public static void main(String[] args) throws SQLException {
        Barang B = new Barang();

        // Baca barang dari input
        B.BacaBarang();

        // Simpan ke database
        B.simpanKeDatabase();

        // Ambil barang dari database
        System.out.print("Masukkan kode barang yang ingin diambil: ");
        Scanner sc = new Scanner(System.in);
        String kodeBarang = sc.nextLine();
        B.ambilDariDatabase(kodeBarang);

        // Tampilkan barang yang diambil dari database
        B.TampilBarang();
    }
}
