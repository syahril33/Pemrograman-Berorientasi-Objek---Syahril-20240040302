-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Jul 2026 pada 02.44
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_laundry`
--

DELIMITER $$
--
-- Prosedur
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `tambah_transaksi_laundry` (IN `p_id_customer` INT, IN `p_berat` DOUBLE, IN `p_harga` DOUBLE)   BEGIN

    INSERT INTO transaksi_laundry(

        id_customer,
        berat_kg,
        harga_per_kg,
        total_harga,
        tanggal_masuk

    )

    VALUES(

        p_id_customer,
        p_berat,
        p_harga,
        hitung_total_harga(p_berat,p_harga),
        CURDATE()

    );

END$$

--
-- Fungsi
--
CREATE DEFINER=`root`@`localhost` FUNCTION `hitung_total_harga` (`p_berat` DOUBLE, `p_harga` DOUBLE) RETURNS DOUBLE DETERMINISTIC BEGIN
    RETURN p_berat * p_harga;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE `customer` (
  `id_customer` int(11) NOT NULL,
  `nama_customer` varchar(100) NOT NULL,
  `no_hp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `customer`
--

INSERT INTO `customer` (`id_customer`, `nama_customer`, `no_hp`) VALUES
(1, 'Andi', '081234567890'),
(2, 'Budi', '082233445566'),
(3, 'Citra', '081998877665'),
(4, 'Ariel', '0812443378'),
(5, 'riko', '08966743'),
(6, '2', 'diki'),
(7, 'syahril', '0088777766'),
(8, '1', '08005673334');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi_laundry`
--

CREATE TABLE `transaksi_laundry` (
  `id_transaksi` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL,
  `berat_kg` double NOT NULL,
  `harga_per_kg` double NOT NULL,
  `total_harga` double NOT NULL,
  `tanggal_masuk` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi_laundry`
--

INSERT INTO `transaksi_laundry` (`id_transaksi`, `id_customer`, `berat_kg`, `harga_per_kg`, `total_harga`, `tanggal_masuk`) VALUES
(1, 4, 3, 7000, 21000, '2026-07-10'),
(2, 6, 5, 7000, 35000, '2026-07-10'),
(3, 1, 4, 7000, 28000, '2026-07-10'),
(4, 1, 8, 7000, 56000, '2026-07-10'),
(5, 1, 10, 7000, 70000, '2026-07-10'),
(6, 6, 7, 7000, 49000, '2026-07-11'),
(7, 7, 1000, 7000, 7000000, '2026-07-11');

--
-- Trigger `transaksi_laundry`
--
DELIMITER $$
CREATE TRIGGER `trigger_set_total_harga` BEFORE INSERT ON `transaksi_laundry` FOR EACH ROW SET NEW.total_harga = NEW.berat_kg * NEW.harga_per_kg
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `nama_user` varchar(100) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `view_riwayat_laundry`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `view_riwayat_laundry` (
`id_transaksi` int(11)
,`nama_customer` varchar(100)
,`berat_kg` double
,`harga_per_kg` double
,`total_harga` double
,`tanggal_masuk` date
);

-- --------------------------------------------------------

--
-- Struktur untuk view `view_riwayat_laundry`
--
DROP TABLE IF EXISTS `view_riwayat_laundry`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_riwayat_laundry`  AS SELECT `t`.`id_transaksi` AS `id_transaksi`, `c`.`nama_customer` AS `nama_customer`, `t`.`berat_kg` AS `berat_kg`, `t`.`harga_per_kg` AS `harga_per_kg`, `t`.`total_harga` AS `total_harga`, `t`.`tanggal_masuk` AS `tanggal_masuk` FROM (`transaksi_laundry` `t` join `customer` `c` on(`t`.`id_customer` = `c`.`id_customer`)) ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id_customer`);

--
-- Indeks untuk tabel `transaksi_laundry`
--
ALTER TABLE `transaksi_laundry`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_customer` (`id_customer`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `customer`
--
ALTER TABLE `customer`
  MODIFY `id_customer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `transaksi_laundry`
--
ALTER TABLE `transaksi_laundry`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `transaksi_laundry`
--
ALTER TABLE `transaksi_laundry`
  ADD CONSTRAINT `transaksi_laundry_ibfk_1` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
