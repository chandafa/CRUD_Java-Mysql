# Setup database
    CREATE DATABASE barang_db;

    USE barang_db;

    CREATE TABLE barang (
        kode VARCHAR(10) PRIMARY KEY,
        nama VARCHAR(100),
        harga DOUBLE
    );


# Edit you connection
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
  

# Run program
  ## Initialisasi
    javac Array_Alpro2/Barang.java
  ## Running
    java -cp .;lib\mysql-connector-java-9.0.0.jar Array_Alpro2.Barang

    
