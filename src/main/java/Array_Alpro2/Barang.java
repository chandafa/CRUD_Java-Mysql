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

    // CREATE: Simpan data barang ke database
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

    // READ: Mengambil data barang dari database berdasarkan kode
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

    // UPDATE: Memperbarui data barang di database berdasarkan kode
    public void updateDatabase(String kodeBarang, String newNama, double newHarga) throws SQLException {
        Connection conn = getConnection();
        String query = "UPDATE barang SET nama = ?, harga = ? WHERE kode = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, newNama);
        stmt.setDouble(2, newHarga);
        stmt.setString(3, kodeBarang);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data berhasil diperbarui.");
        } else {
            System.out.println("Barang tidak ditemukan.");
        }
        conn.close();
    }

    // DELETE: Menghapus data barang dari database berdasarkan kode
    public void deleteFromDatabase(String kodeBarang) throws SQLException {
        Connection conn = getConnection();
        String query = "DELETE FROM barang WHERE kode = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, kodeBarang);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Barang tidak ditemukan.");
        }
        conn.close();
    }

    public static void main(String[] args) throws SQLException {
        Barang B = new Barang();
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Barang");
            System.out.println("3. Perbarui Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi (1-5): ");
            pilihan = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (pilihan) {
                case 1: // Tambah Barang
                    B.BacaBarang();
                    B.simpanKeDatabase();
                    System.out.println("Barang berhasil ditambahkan.");
                    break;

                case 2: // Lihat Barang
                    System.out.print("Masukkan kode barang yang ingin dilihat: ");
                    String kodeLihat = sc.nextLine();
                    B.ambilDariDatabase(kodeLihat);
                    B.TampilBarang();
                    break;

                case 3: // Perbarui Barang
                    System.out.print("Masukkan kode barang yang ingin diperbarui: ");
                    String kodeUpdate = sc.nextLine();
                    System.out.print("Masukkan nama baru: ");
                    String newNama = sc.nextLine();
                    System.out.print("Masukkan harga baru: ");
                    double newHarga = sc.nextDouble();
                    B.updateDatabase(kodeUpdate, newNama, newHarga);
                    break;

                case 4: // Hapus Barang
                    System.out.print("Masukkan kode barang yang ingin dihapus: ");
                    String kodeHapus = sc.nextLine();
                    B.deleteFromDatabase(kodeHapus);
                    break;

                case 5: // Keluar
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

            System.out.println(); // Untuk memberikan jarak antara setiap iterasi menu
        } while (pilihan != 5);

        sc.close();
    }
}
