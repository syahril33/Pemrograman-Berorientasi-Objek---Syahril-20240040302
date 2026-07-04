const mysql = require('mysql2');
const readline = require('readline');
const Table = require('cli-table3');

// 1. Konfigurasi Koneksi Database
const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',      // Sesuaikan jika user MySQL kamu berbeda
    password: '',      // Kosongkan jika menggunakan XAMPP default
    database: 'toko_retail'
});

// Cek Koneksi
db.connect((err) => {
    if (err) throw err;
    showMenu(); // Tampilkan menu utama jika berhasil connect
});

// 2. Setup Readline untuk Input Terminal
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

// Helper agar input bisa menggunakan async/await
const question = (text) => new Promise((resolve) => rl.question(text, resolve));

// 3. Fungsi Menampilkan Menu
function showMenu() {
    // Membuat tabel untuk bingkai menu persis seperti screenshot
    const menuTable = new Table({
        head: [{ content: 'MENU TOKO RETAIL', hAlign: 'center' }]
    });
    
    menuTable.push([
        " 1. Tampil Semua Data\n 2. Tambah Data\n 3. Cari Data\n 4. Ubah Data\n 5. Hapus Data\n 0. Keluar"
    ]);
    
    console.log(menuTable.toString());
    
    rl.question("Pilihan : ", async (pilihan) => {
        console.log(""); // Jarak baris
        switch(pilihan) {
            case '1': await tampilData(); break;
            case '2': await tambahData(); break;
            case '3': await cariData(); break;
            case '4': await ubahData(); break;
            case '5': await hapusData(); break;
            case '0': 
                console.log("Keluar dari program...");
                db.end();
                rl.close();
                break;
            default:
                console.log("Pilihan tidak valid!\n");
                showMenu();
                break;
        }
    });
}

// 4. CRUD: Tampil Semua Data (Menu 1)
function tampilData() {
    return new Promise((resolve) => {
        db.query("SELECT * FROM barang", (err, results) => {
            if (err) throw err;

            const table = new Table();
            // Header tabel
            table.push(
                [{ content: 'DAFTAR BARANG TOKO RETAIL', colSpan: 5, hAlign: 'center' }],
                ['#', 'Kode', 'Nama Barang', 'Harga', 'Stok']
            );

            // Looping data dari database
            results.forEach((row, index) => {
                table.push([index + 1, row.kode, row.nama_barang, row.harga, row.stok]);
            });

            console.log(table.toString());
            console.log(`Total: ${results.length} barang\n`);
            
            showMenu();
            resolve();
        });
    });
}

// 5. CRUD: Tambah Data (Menu 2)
async function tambahData() {
    const kode = await question("Masukkan Kode Barang : ");
    const nama = await question("Masukkan Nama Barang : ");
    const harga = await question("Masukkan Harga       : ");
    const stok = await question("Masukkan Stok        : ");

    db.query("INSERT INTO barang (kode, nama_barang, harga, stok) VALUES (?, ?, ?, ?)", 
        [kode, nama, harga, stok], (err, result) => {
        if (err) console.log("Gagal: " + err.sqlMessage);
        else console.log("=> Data berhasil ditambahkan!\n");
        showMenu();
    });
}

// 6. CRUD: Cari Data (Menu 3)
async function cariData() {
    const keyword = await question("Masukkan Nama Barang yang dicari: ");
    const query = "SELECT * FROM barang WHERE nama_barang LIKE ?";
    
    db.query(query, [`%${keyword}%`], (err, results) => {
        if (err) throw err;
        
        if (results.length > 0) {
            const table = new Table();
            table.push(['#', 'Kode', 'Nama Barang', 'Harga', 'Stok']);
            results.forEach((row, index) => {
                table.push([index + 1, row.kode, row.nama_barang, row.harga, row.stok]);
            });
            console.log(table.toString());
        } else {
            console.log("=> Data tidak ditemukan!\n");
        }
        console.log("");
        showMenu();
    });
}

// 7. CRUD: Ubah Data (Menu 4)
async function ubahData() {
    const kode = await question("Masukkan Kode Barang yang akan diubah: ");
    const nama = await question("Masukkan Nama Barang baru : ");
    const harga = await question("Masukkan Harga baru       : ");
    const stok = await question("Masukkan Stok baru        : ");

    db.query("UPDATE barang SET nama_barang=?, harga=?, stok=? WHERE kode=?", 
        [nama, harga, stok, kode], (err, result) => {
        if (err) throw err;
        if (result.affectedRows > 0) console.log("=> Data berhasil diubah!\n");
        else console.log("=> Kode barang tidak ditemukan!\n");
        showMenu();
    });
}

// 8. CRUD: Hapus Data (Menu 5)
async function hapusData() {
    const kode = await question("Masukkan Kode Barang yang akan dihapus: ");
    
    db.query("DELETE FROM barang WHERE kode=?", [kode], (err, result) => {
        if (err) throw err;
        if (result.affectedRows > 0) console.log("=> Data berhasil dihapus!\n");
        else console.log("=> Kode barang tidak ditemukan!\n");
        showMenu();
    });
}