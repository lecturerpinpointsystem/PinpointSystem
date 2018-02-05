-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 05 Feb 2018 pada 09.13
-- Versi Server: 10.1.29-MariaDB
-- PHP Version: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pinpoint`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `datapengajar`
--

CREATE TABLE `datapengajar` (
  `NIP` varchar(12) NOT NULL,
  `NAMA` varchar(100) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `USERNAME` varchar(100) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `ALAMAT` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `datapengajar`
--

INSERT INTO `datapengajar` (`NIP`, `NAMA`, `EMAIL`, `USERNAME`, `PASSWORD`, `ALAMAT`) VALUES
('101111', 'Jojo', 'jojo@gmail.com', 'jojo', 'jojo', 'Jojo');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jadwal`
--

CREATE TABLE `jadwal` (
  `NOMOR` int(11) NOT NULL,
  `NIP` varchar(12) NOT NULL,
  `NAMA` varchar(100) DEFAULT NULL,
  `MATAKULIAH` varchar(100) NOT NULL,
  `RUANGAN` varchar(10) NOT NULL,
  `HARI` varchar(10) NOT NULL,
  `MULAI` varchar(10) NOT NULL,
  `USAI` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jadwal`
--

INSERT INTO `jadwal` (`NOMOR`, `NIP`, `NAMA`, `MATAKULIAH`, `RUANGAN`, `HARI`, `MULAI`, `USAI`) VALUES
(1, '101111', 'Jojo', 'Gulat', 'Lpanag', 'Senin', '12:30', '13:30');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `datapengajar`
--
ALTER TABLE `datapengajar`
  ADD PRIMARY KEY (`NIP`),
  ADD UNIQUE KEY `EMAIL` (`EMAIL`);

--
-- Indexes for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD PRIMARY KEY (`NOMOR`),
  ADD UNIQUE KEY `RUANGAN` (`RUANGAN`),
  ADD KEY `NIP` (`NIP`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jadwal`
--
ALTER TABLE `jadwal`
  MODIFY `NOMOR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `jadwal`
--
ALTER TABLE `jadwal`
  ADD CONSTRAINT `jadwal_ibfk_1` FOREIGN KEY (`NIP`) REFERENCES `datapengajar` (`NIP`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
