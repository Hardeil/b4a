-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 18, 2025 at 03:54 PM
-- Server version: 11.5.2-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `company`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch_master`
--

CREATE TABLE `branch_master` (
  `id` int(50) NOT NULL,
  `branch_name` varchar(50) NOT NULL,
  `total_pos` int(50) NOT NULL,
  `average_pos` int(50) NOT NULL,
  `avg_sales` int(100) NOT NULL,
  `company_id` int(50) NOT NULL,
  `target_id` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `branch_master`
--

INSERT INTO `branch_master` (`id`, `branch_name`, `total_pos`, `average_pos`, `avg_sales`, `company_id`, `target_id`) VALUES
(1, 'Ezware Branch 1', 50, 50, 120, 1, 1),
(4, 'Atlantic Branch 1', 900, 300, 920, 3, 2),
(5, 'Atlantic Branch 2', 600, 10, 180, 3, 3),
(6, 'Gaisano Branch 1', 200, 200, 200200, 2, 1),
(8, 'Lanueva Branch 1', 300, 150, 1100, 4, 2),
(9, 'Lanueva Branch 2', 124, 267, 190, 4, 3),
(10, 'Lanueva Branch 3', 200, 456, 145, 4, 4),
(18, 'Atlantic Branch 3', 900, 300, 920, 3, 5),
(19, 'Atlantic Branch 4', 900, 300, 790, 3, 6),
(20, 'Atlantic Branch 5', 550, 300, 550, 3, 7),
(21, 'Atlantic Branch 6', 555, 300, 555, 3, 8),
(22, 'Atlantic Branch 7', 555, 300, 555, 3, 1),
(23, 'Atlantic Branch 8', 650, 300, 650, 3, 2),
(24, 'Atlantic Branch 9', 505, 300, 505, 3, 3),
(25, 'Atlantic Branch 10', 510, 300, 920, 3, 4),
(26, 'Ezware Branch 2', 50, 50, 150, 1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `branch_purchase`
--

CREATE TABLE `branch_purchase` (
  `id` int(50) NOT NULL,
  `branch_id` int(50) NOT NULL,
  `purchase_1` int(50) NOT NULL,
  `purchase_2` int(50) NOT NULL,
  `purchase_3` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `branch_purchase`
--

INSERT INTO `branch_purchase` (`id`, `branch_id`, `purchase_1`, `purchase_2`, `purchase_3`) VALUES
(1, 4, 100, 110, 120),
(2, 1, 105, 115, 125),
(3, 8, 106, 116, 126),
(4, 6, 107, 117, 127),
(5, 4, 120, 120, 130),
(6, 26, 125, 125, 135),
(7, 8, 126, 136, 146),
(8, 6, 117, 127, 137);

-- --------------------------------------------------------

--
-- Table structure for table `branch_target`
--

CREATE TABLE `branch_target` (
  `id` int(50) NOT NULL,
  `target_no` int(50) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `branch_target`
--

INSERT INTO `branch_target` (`id`, `target_no`, `date`) VALUES
(1, 29, '2025-02-07'),
(2, 1, '2025-02-08'),
(3, 6, '2025-02-09'),
(4, 8, '2025-02-10'),
(5, 32, '2025-02-07'),
(6, 8, '2025-02-10'),
(7, 6, '2025-02-09'),
(8, 1, '2025-02-08');

-- --------------------------------------------------------

--
-- Table structure for table `company_master`
--

CREATE TABLE `company_master` (
  `id` int(50) NOT NULL,
  `company_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `company_master`
--

INSERT INTO `company_master` (`id`, `company_name`) VALUES
(1, 'Ezware'),
(2, 'Gaisano'),
(3, 'Atlantic'),
(4, 'Lanueva');

-- --------------------------------------------------------

--
-- Table structure for table `device_amount`
--

CREATE TABLE `device_amount` (
  `id` int(50) NOT NULL,
  `amount` int(100) NOT NULL,
  `sales_1` int(50) NOT NULL,
  `sales_2` int(50) NOT NULL,
  `sales_3` int(50) NOT NULL,
  `createdAt` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `device_amount`
--

INSERT INTO `device_amount` (`id`, `amount`, `sales_1`, `sales_2`, `sales_3`, `createdAt`) VALUES
(26, 100, 110, 120, 130, '2025-02-11'),
(27, 150, 210, 220, 230, '2025-02-11'),
(28, 170, 310, 320, 330, '2025-02-11'),
(29, 190, 410, 420, 430, '2025-02-11'),
(30, 200, 510, 620, 630, '2025-02-11'),
(31, 220, 710, 720, 730, '2025-02-11'),
(32, 225, 819, 829, 729, '2025-02-11'),
(33, 230, 910, 920, 930, '2025-02-11'),
(34, 235, 1010, 1020, 1030, '2025-02-11'),
(35, 240, 1110, 1120, 1130, '2025-02-11');

-- --------------------------------------------------------

--
-- Table structure for table `device_master`
--

CREATE TABLE `device_master` (
  `id` int(50) NOT NULL,
  `deviceAmountID` int(100) NOT NULL,
  `serial_num` varchar(50) NOT NULL,
  `branch_id` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `device_master`
--

INSERT INTO `device_master` (`id`, `deviceAmountID`, `serial_num`, `branch_id`) VALUES
(26, 26, '100200300111', 1),
(27, 27, '100200301', 1),
(28, 28, '100200302', 6),
(29, 29, '100200304', 1),
(30, 30, '100200305', 1),
(31, 31, '100200306', 1),
(32, 32, '100200307', 1),
(33, 33, '100200308', 4),
(34, 34, '100200309', 1),
(35, 35, '100200310', 1),
(38, 26, '100200300', 1),
(39, 28, '100200341', 26),
(40, 35, '100200342', 26);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `branch_master`
--
ALTER TABLE `branch_master`
  ADD PRIMARY KEY (`id`),
  ADD KEY `company_id` (`company_id`),
  ADD KEY `target_id` (`target_id`);

--
-- Indexes for table `branch_purchase`
--
ALTER TABLE `branch_purchase`
  ADD PRIMARY KEY (`id`),
  ADD KEY `branch_id` (`branch_id`);

--
-- Indexes for table `branch_target`
--
ALTER TABLE `branch_target`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `company_master`
--
ALTER TABLE `company_master`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `device_amount`
--
ALTER TABLE `device_amount`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `device_master`
--
ALTER TABLE `device_master`
  ADD PRIMARY KEY (`id`),
  ADD KEY `deviceAmountID` (`deviceAmountID`),
  ADD KEY `branch_id` (`branch_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `branch_master`
--
ALTER TABLE `branch_master`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `branch_purchase`
--
ALTER TABLE `branch_purchase`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `branch_target`
--
ALTER TABLE `branch_target`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `company_master`
--
ALTER TABLE `company_master`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `device_amount`
--
ALTER TABLE `device_amount`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `device_master`
--
ALTER TABLE `device_master`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `branch_master`
--
ALTER TABLE `branch_master`
  ADD CONSTRAINT `branch_master_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company_master` (`id`),
  ADD CONSTRAINT `branch_master_ibfk_2` FOREIGN KEY (`target_id`) REFERENCES `branch_target` (`id`);

--
-- Constraints for table `branch_purchase`
--
ALTER TABLE `branch_purchase`
  ADD CONSTRAINT `branch_purchase_ibfk_1` FOREIGN KEY (`branch_id`) REFERENCES `branch_master` (`id`);

--
-- Constraints for table `device_master`
--
ALTER TABLE `device_master`
  ADD CONSTRAINT `device_master_ibfk_1` FOREIGN KEY (`deviceAmountID`) REFERENCES `device_amount` (`id`),
  ADD CONSTRAINT `device_master_ibfk_2` FOREIGN KEY (`branch_id`) REFERENCES `branch_master` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
