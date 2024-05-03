-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.39-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema sm_project
--

CREATE DATABASE IF NOT EXISTS sm_project;
USE sm_project;

--
-- Definition of table `tbl_cases`
--

DROP TABLE IF EXISTS `tbl_cases`;
CREATE TABLE `tbl_cases` (
  `case_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `case_manufacturer` varchar(50) DEFAULT NULL,
  `case_color` varchar(50) DEFAULT NULL COMMENT 'Color',
  `case_size` varchar(50) DEFAULT NULL COMMENT 'Case Size',
  PRIMARY KEY (`case_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Cases Table';

--
-- Dumping data for table `tbl_cases`
--

/*!40000 ALTER TABLE `tbl_cases` DISABLE KEYS */;
INSERT INTO `tbl_cases` (`product_id`, `case_manufacturer`, `case_color`, `case_size`)
VALUES
(46, 'IDCooling', 'Black', 'Mid Tower'),
(47, 'Corsair', 'White', 'Full Tower'),
(48, 'MSI', 'Blue', 'Mini Tower'),
(49, 'Gigabyte', 'Red', 'Micro Tower'),
(50, 'Asus', 'Green', 'ATX'),
(51, 'IDCooling', 'Yellow', 'Mini-ITX'),
(52, 'Corsair', 'Purple', 'Micro ATX'),
(53, 'MSI', 'Orange', 'E-ATX'),
(54, 'Gigabyte', 'Pink', 'Slim Tower'),
(55, 'Asus', 'Gray', 'Cube Case');

/*!40000 ALTER TABLE `tbl_cases` ENABLE KEYS */;


--
-- Definition of table `tbl_cooling`
--

DROP TABLE IF EXISTS `tbl_cooling`;
CREATE TABLE `tbl_cooling` (
  `cooling_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `cooling_manufacturer` varchar(50) DEFAULT NULL,
  `cooling_type` varchar(50) DEFAULT NULL COMMENT 'Cooling Type',
  `cooling_color` varchar(50) DEFAULT NULL COMMENT 'Color',
  `cooling_fan_size` varchar(50) DEFAULT NULL COMMENT 'Fan Size',
  PRIMARY KEY (`cooling_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Cooling Table';

--
-- Dumping data for table `tbl_cooling`
--

/*!40000 ALTER TABLE `tbl_cooling` DISABLE KEYS */;
INSERT INTO `tbl_cooling` (`product_id`, `cooling_manufacturer`, `cooling_type`, `cooling_color`, `cooling_fan_size`)
VALUES
(56, 'Corsair', 'Air Cooler', 'Black', '120mm'),
(57, 'Deepcool', 'Liquid Cooler', 'White', '120mm'),
(58, 'Corsair', 'Air Cooler', 'Black', '120mm'),
(59, 'Xigmatek', 'Air Cooler', 'Black', '120mm'),
(60, 'ID-COOLING', 'Liquid Cooler', 'RGB', '120mm'),
(61, 'ID-COOLING', 'Liquid Cooler', 'White', '120mm'),
(62, 'Xigmatek', 'Air Cooler', 'White', '120mm'),
(63, 'Corsair', 'Liquid Cooler', 'Black', '120mm'),
(64, 'Corsair', 'Liquid Cooler', 'Black', '120mm'),
(65, 'ID-COOLING', 'Liquid Cooler', 'White', '120mm');
/*!40000 ALTER TABLE `tbl_cooling` ENABLE KEYS */;


--
-- Definition of table `tbl_cpus`
--

DROP TABLE IF EXISTS `tbl_cpus`;
CREATE TABLE `tbl_cpus` (
  `cpu_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `cpu_collection` varchar(100) DEFAULT NULL COMMENT 'Core i5/Ryzen 5',
  `cpu_socket` varchar(50) DEFAULT NULL COMMENT 'Socket',
  `cpu_cores` int(11) unsigned DEFAULT NULL COMMENT 'Core',
  `cpu_threads` int(11) unsigned DEFAULT NULL COMMENT 'Threads',
  `cpu_speed_ghz` varchar(50) DEFAULT NULL COMMENT 'Speed (GHz)',
  PRIMARY KEY (`cpu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='CPUs Table';

--
-- Dumping data for table `tbl_cpus`
--

/*!40000 ALTER TABLE `tbl_cpus` DISABLE KEYS */;
INSERT INTO `tbl_cpus` (`product_id`, `cpu_collection`, `cpu_socket`, `cpu_cores`, `cpu_threads`, `cpu_speed_ghz`)
VALUES
(66, 'AMD Ryzen 9 7900', 'Socket AM5', 12, 24, '3.0 - 4.6 GHz'),
(67, 'AMD Ryzen 7 7800X3D', 'Socket AM5', 8, 16, '3.2 - 4.8 GHz'),
(68, 'Intel Core i9-14900K', 'LGA 1700', 24, 32, '3.2 - 5.6 GHz'),
(69, 'Intel Core i7-14700K', 'LGA 1700', 20, 28, '3.4 - 5.6 GHz'),
(70, 'Intel Core i5-12600K', 'LGA 1200', 12, 16, '3.0 - 4.4 GHz'),
(71, 'AMD Ryzen 5 6500', 'Socket AM4', 6, 12, '3.2 - 4.4 GHz'),
(72, 'Intel Core i3-12100', 'LGA 1200', 4, 8, '2.8 - 4.2 GHz'),
(73, 'AMD Athlon 3000G', 'Socket AM4', 4, 4, '3.0 - 3.2 GHz'),
(74, 'Intel Pentium Gold G6500', 'LGA 1200', 2, 4, '3.1 - 3.5 GHz'),
(75, 'AMD A-Series A6-9500', 'Socket AM4', 2, 4, '3.5 - 3.8 GHz');
/*!40000 ALTER TABLE `tbl_cpus` ENABLE KEYS */;


--
-- Definition of table `tbl_desktops`
--

DROP TABLE IF EXISTS `tbl_desktops`;
CREATE TABLE `tbl_desktops` (
  `desktop_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11)  NOT NULL,
  `desktop_manufacturer` varchar(20) DEFAULT NULL,
  `desktop_type` varchar(20) DEFAULT NULL COMMENT 'Gaming, Office, Graphics',
  `desktop_cpu` varchar(20) NOT NULL COMMENT 'CPU',
  `desktop_gpu` varchar(20) DEFAULT NULL COMMENT 'GPU',
  `desktop_ram_capacity` varchar(20) DEFAULT NULL COMMENT 'RAM Capacity',
  `desktop_ram_type` varchar(20) DEFAULT NULL COMMENT 'RAM Type',
  `desktop_storage` varchar(20) NOT NULL COMMENT 'Storage',
  `desktop_power_supply` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`desktop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Desktops Table';

--
-- Dumping data for table `tbl_desktops`
--

/*!40000 ALTER TABLE `tbl_desktops` DISABLE KEYS */;
INSERT INTO `tbl_desktops` (`product_id`, `desktop_manufacturer`, `desktop_type`, `desktop_cpu`, `desktop_gpu`, `desktop_ram_capacity`, `desktop_ram_type`, `desktop_storage`, `desktop_power_supply`)
VALUES
(76, 'Asus', 'Gaming', 'Intel Core i5-11400F', 'NVIDIA GeForce GTX 1650', '16GB', 'DDR4', '512GB SSD', '500W'),
(77, 'Giga', 'Gaming', 'Intel Core i7-14700K', 'NVIDIA GeForce RTX 4060 Ti', '32GB', 'DDR5', '1TB SSD + 2TB HDD', '650W'),
(78, 'MSI', 'Gaming', 'Intel Core i5-12600K', 'NVIDIA GeForce RTX 4060 Ti', '16GB', 'DDR4', '1TB SSD', '550W'),
(79, 'Asus', 'Gaming', 'AMD Ryzen 9 5900X', 'NVIDIA GeForce RTX 3080', '64GB', 'DDR4', '2TB NVMe SSD + 4TB HDD', '750W'),
(80, 'Giga', 'Gaming', 'AMD Ryzen 7 5800X', 'NVIDIA GeForce RTX 3070 Ti', '32GB', 'DDR4', '1TB SSD', '700W'),
(81, 'MSI', 'Gaming', 'Intel Core i9-12900K', 'NVIDIA GeForce RTX 3090', '64GB', 'DDR5', '2TB NVMe SSD', '850W'),
(82, 'Asus', 'Office', 'Intel Core i7-12700K', 'NVIDIA GeForce RTX 3050', '32GB', 'DDR4', '1TB SSD', '700W'),
(83, 'Giga', 'Graphics', 'AMD Ryzen 5 5600X', 'NVIDIA GeForce RTX 3060', '16GB', 'DDR4', '512GB NVMe SSD', '600W'),
(84, 'MSI', 'Graphics', 'Intel Core i5-12400F', 'NVIDIA GeForce GTX 1660 Ti', '16GB', 'DDR4', '512GB SSD + 1TB HDD', '550W'),
(85, 'Asus', 'Office', 'Intel Core i3-12100F', 'NVIDIA GeForce GT 1030', '8GB', 'DDR4', '256GB SSD', '450W');
/*!40000 ALTER TABLE `tbl_desktops` ENABLE KEYS */;


--
-- Definition of table `tbl_graphics_cards`
--

DROP TABLE IF EXISTS `tbl_graphics_cards`;
CREATE TABLE `tbl_graphics_cards` (
  `graphics_card_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) unsigned NOT NULL,
  `graphics_card_manufacturer` varchar(100) DEFAULT NULL COMMENT 'Manufacturer',
  `graphics_card_speed` varchar(20) DEFAULT NULL,
  `graphics_card_cores` varchar(20) DEFAULT NULL,
  `graphics_card_version` varchar(50) DEFAULT NULL COMMENT 'Version',
  `graphics_card_vram_capacity` varchar(20) DEFAULT NULL COMMENT 'VRAM Capacity',
  `graphics_card_require_psu` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`graphics_card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Graphics Cards Table';

--
-- Dumping data for table `tbl_graphics_cards`
--

/*!40000 ALTER TABLE `tbl_graphics_cards` DISABLE KEYS */;
INSERT INTO `tbl_graphics_cards` (`product_id`, `graphics_card_manufacturer`, `graphics_card_speed`, `graphics_card_cores`, `graphics_card_version`, `graphics_card_vram_capacity`, `graphics_card_require_psu`)
VALUES
(86, 'NVIDIA', '1320 MHz', '3584', 'RTX 3060', '12 GB', '550W'),
(87, 'AMD', '2359 MHz', '1792', 'RX 6600', '8 GB', '500W'),
(88, 'NVIDIA', '1605 MHz', '6144', 'RTX 4070', '16 GB', '650W'),
(89, 'NVIDIA', '1800 MHz', '8192', 'RTX 4090', '24 GB', '750W'),
(90, 'NVIDIA', '1770 MHz', '1536', 'GTX 1660 Ti', '6 GB', '450W'),
(91, 'AMD', '2424 MHz', '2560', 'RX 6700 XT', '12 GB', '650W'),
(92, 'NVIDIA', '1710 MHz', '8704', 'GTX 3080', '10 GB', '750W'),
(93, 'AMD', '2250 MHz', '4608', 'RX 6800 XT', '16 GB', '750W'),
(94, 'NVIDIA', '1665 MHz', '4864', 'GTX 3060 Ti', '8 GB', '600W'),
(95, 'AMD', '2424 MHz', '2304', 'RX 6700', '6 GB', '550W');
/*!40000 ALTER TABLE `tbl_graphics_cards` ENABLE KEYS */;


--
-- Definition of table `tbl_headphones_speakers`
--

DROP TABLE IF EXISTS `tbl_headphones_speakers`;
CREATE TABLE `tbl_headphones_speakers` (
  `headphones_speakers_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `headphones_manufacturer` varchar(50) DEFAULT NULL,
  `headphone_type` varchar(100) DEFAULT NULL COMMENT 'Inear/Overear/Speaker',
  `headphones_connection` varchar(50) DEFAULT NULL COMMENT 'Connection Type',
  `headphones_connection_ports` varchar(100) DEFAULT NULL COMMENT 'Connection Ports',
  PRIMARY KEY (`headphones_speakers_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Headphones/Speakers Table';

--
-- Dumping data for table `tbl_headphones_speakers`
--

/*!40000 ALTER TABLE `tbl_headphones_speakers` DISABLE KEYS */;
INSERT INTO `tbl_headphones_speakers` (`product_id`, `headphones_manufacturer`, `headphone_type`, `headphones_connection`, `headphones_connection_ports`) VALUES
(96, 'Logitech', 'Headphones', 'Wireless', 'USB'),
(97, 'Asus', 'Headphones', 'Wired', 'USB'),
(98, 'Razer', 'Headphones', 'Wired', 'USB'),
(99, 'HyperX', 'Headphones', 'Wireless', 'Bluetooth'),
(100, 'Logitech', 'Headphones', 'Wireless', 'USB'),
(101, 'Asus', 'Speaker', 'Wired', '3.5mm'),
(102, 'Razer', 'Headphones', 'Wired', 'USB'),
(103, 'HyperX', 'Headphones', 'Wireless', 'USB'),
(104, 'Logitech', 'Speaker', 'Wired', '3.5mm'),
(105, 'Asus', 'Headphones', 'Wired', 'USB');
/*!40000 ALTER TABLE `tbl_headphones_speakers` ENABLE KEYS */;


--
-- Definition of table `tbl_keyboards`
--

DROP TABLE IF EXISTS `tbl_keyboards`;
CREATE TABLE `tbl_keyboards` (
  `keyboard_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `keyboard_type` varchar(100) DEFAULT NULL COMMENT 'Gaming/mechanical/Office',
  `keyboard_connection_type` varchar(50) DEFAULT NULL COMMENT 'Connection Type',
  `keyboard_size_layout` varchar(50) DEFAULT NULL COMMENT 'Size Layout',
  `keyboard_led_backlighting` varchar(50) DEFAULT NULL COMMENT 'LED Backlighting',
  PRIMARY KEY (`keyboard_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Keyboards Table';

--
-- Dumping data for table `tbl_keyboards`
--

/*!40000 ALTER TABLE `tbl_keyboards` DISABLE KEYS */;
INSERT INTO `tbl_keyboards` (`product_id`, `keyboard_type`, `keyboard_connection_type`, `keyboard_size_layout`, `keyboard_led_backlighting`) VALUES
(106, 'Gaming', 'USB', 'Compact', 'RGB'),
(107, 'Office', 'Wireless', 'Full-size', 'Single-color'),
(108, 'Mechanical', 'USB', 'Full-size', 'RGB'),
(109, 'Mechanical_2', 'USB', 'Tenkeyless', 'RGB'),
(110, 'Gaming', 'Wireless', 'Compact', 'RGB'),
(111, 'Office', 'USB', 'Tenkeyless', 'Single-color'),
(112, 'Mechanical', 'Wireless', 'Full-size', 'RGB'),
(113, 'Gaming', 'USB', 'Full-size', 'RGB'),
(114, 'Office', 'Wireless', 'Compact', 'Single-color'),
(115, 'Mechanical_2', 'USB', 'Full-size', 'RGB');
/*!40000 ALTER TABLE `tbl_keyboards` ENABLE KEYS */;


--
-- Definition of table `tbl_laptops`
--

DROP TABLE IF EXISTS `tbl_laptops`;
CREATE TABLE `tbl_laptops` (
  `laptop_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `laptop_manufacturer` varchar(100) DEFAULT NULL COMMENT 'Manufacturer',
  `laptop_cpu` int(11) unsigned DEFAULT NULL COMMENT 'CPU',
  `laptop_ram` int(11) unsigned DEFAULT NULL COMMENT 'RAM',
  `laptop_graphics_card` int(11) unsigned DEFAULT NULL COMMENT 'Graphics Card',
  `laptop_storage` int(11) unsigned DEFAULT NULL COMMENT 'Storage',
  `laptop_screen_size` int(11) unsigned DEFAULT NULL COMMENT 'Screen Size',
  `laptop_refresh_rate` int(11) unsigned DEFAULT NULL COMMENT 'Refresh Rate',
  `laptop_resolution` varchar(20) DEFAULT NULL COMMENT 'Resolution',
  `laptop_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`laptop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Laptops Table';

--
-- Dumping data for table `tbl_laptops`
--

/*!40000 ALTER TABLE `tbl_laptops` DISABLE KEYS */;
INSERT INTO `tbl_laptops` (`product_id`, `laptop_manufacturer`, `laptop_cpu`, `laptop_ram`, `laptop_graphics_card`, `laptop_storage`, `laptop_screen_size`, `laptop_refresh_rate`, `laptop_resolution`, `laptop_type`) VALUES
(6, 'Apple', 'Apple M1', '8GB LPDDR4X', 'Integrated Apple GPU', '512GB SSD', '13 inches', '60Hz', '2560x1600', 'Ultrabook'),
(7, 'HP', 'Intel Core i3-1215U', '8GB DDR4', 'Integrated Intel UHD Graphics', '256GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(8, 'Asus', 'Intel Core i5-11400H', '16GB DDR4', 'NVIDIA GeForce GTX 1650', '512GB SSD', '15.6 inches', '144Hz', '1920x1080', 'Gaming Laptop'),
(9, 'Acer', 'Intel Core i5-13420H', '8GB DDR4', 'NVIDIA GeForce GTX 1650', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Gaming Laptop'),
(10, 'Asus', 'AMD Ryzen 5 7520U', '8GB DDR4', 'Integrated AMD Graphics', '256GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Vivobook'),
(12, 'HP', 'Intel Core i3-1215U', '4GB DDR4', 'Integrated Intel UHD Graphics', '256GB SSD', '14 inches', '60Hz', '1366x768', 'Notebook'),
(13, 'Asus', 'Intel Core i5-1335U', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '16 inches', '60Hz', '1920x1080', 'Vivobook'),
(14, 'HP', 'Intel Core i5-1235U', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(15, 'Asus', 'Intel Core i3-1215U', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Vivobook'),
(16, 'Asus', 'Intel Core i3-1115G4', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Vivobook'),
(17, 'HP', 'Intel Core i5-1235U', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '14 inches', '60Hz', '1920x1080', 'Notebook'),
(18, 'Asus', 'Intel Core i5-1135G7', '8GB DDR4', 'Integrated Intel Iris Xe Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Vivobook'),
(19, 'Dell', 'Intel Core i3-1215U', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(20, 'HP', 'Intel Core i3 N305', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '14 inches', '60Hz', '1920x1080', 'Notebook'),
(21, 'Lenovo', 'Intel Core i3-1115G4', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(22, 'Dell', 'Intel Core i3-1215U', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(23, 'HP', 'Intel Core i3-1115G4', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(24, 'Asus', 'Intel Core i3-1115G4', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(26, 'Dell', 'Intel Core i5-1235U', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(27, 'Asus', 'Intel Core i5-1335U', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(29, 'Lenovo', 'Intel Core i3-1215U', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(30, 'HP', 'Intel Core i5-1240P', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(31, 'Lenovo', 'Intel Core i5-1155G7', '8GB DDR4', 'Integrated Intel Iris Xe Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(32, 'HP', 'Intel Core i3-1115G4', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '14 inches', '60Hz', '1366x768', 'Notebook'),
(33, 'Asus', 'Intel Core i7-11800H', '16GB DDR4', 'NVIDIA GeForce RTX 3050 Ti', '512GB SSD', '15.6 inches', '144Hz', '1920x1080', 'Gaming Laptop'),
(34, 'HP', 'Intel Core i7-1255U', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(35, 'Acer', 'Intel Core i3-1215U', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(36, 'MSI', 'Intel Core i5-11400H', '16GB DDR4', 'NVIDIA GeForce GTX 1650', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Gaming Laptop'),
(38, 'MSI', 'Intel Core i7-11800H', '16GB DDR4', 'NVIDIA GeForce GTX 1650', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Gaming Laptop'),
(39, 'Asus', 'Intel Core i5-13500H', '16GB DDR4', 'Integrated Intel Iris Xe Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Vivobook'),
(40, 'Lenovo', 'Intel Core i5-12450H', '16GB DDR4', 'Integrated Intel Iris Xe Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(41, 'Apple', 'Apple M2', '8GB LPDDR5', 'Integrated Apple GPU', '512GB SSD', '13 inches', '60Hz', '2560x1600', 'Ultrabook'),
(42, 'Acer', 'Intel Core i5-11400H', '16GB DDR4', 'NVIDIA GeForce GTX 1650', '512GB SSD', '15.6 inches', '144Hz', '1920x1080', 'Gaming Laptop'),
(43, 'HP', 'Intel Core i5-1240P', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(44, 'Dell', 'Intel Core i3-1215U', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(45, 'Lenovo', 'Intel Core i3-1115G4', '8GB DDR4', 'Integrated Intel UHD Graphics', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Notebook'),
(116, 'Mac', 'Apple M1 Pro', '16GB LPDDR4X', 'Integrated Apple GPU', '512GB SSD', '14 inches', '120Hz', '2880x1800', 'Ultrabook'),
(117, 'Asus', 'Intel Core i7-12700H', '16GB DDR5', 'NVIDIA GeForce RTX 3050', '1TB NVMe SSD', '15.6 inches', '144Hz', '1920x1080', 'Gaming Laptop'),
(118, 'Dell', 'Intel Core i9-12900HK', '32GB DDR5', 'NVIDIA GeForce RTX 3070', '2TB SSD', '17 inches', '240Hz', '3840x2160', 'High-End Gaming Laptop'),
(119, 'MSI', 'AMD Ryzen 9 5900HX', '32GB DDR4', 'NVIDIA GeForce RTX 3080', '1TB NVMe SSD', '15.6 inches', '300Hz', '1920x1080', 'High-End Gaming Laptop'),
(120, 'HP', 'Intel Core i5-12400H', '8GB DDR4', 'Integrated Intel Iris Xe Graphics', '512GB SSD', '14 inches', '60Hz', '1920x1080', 'Office Laptop'),
(121, 'Lenovo', 'AMD Ryzen 7 5800H', '16GB DDR4', 'NVIDIA GeForce RTX 3060', '1TB SSD', '15.6 inches', '120Hz', '1920x1080', 'Gaming Laptop'),
(122, 'Apple', 'Apple M1 Max', '32GB LPDDR5', 'Integrated Apple GPU', '2TB SSD', '16 inches', '120Hz', '3072x1920', 'High-Performance Laptop'),
(123, 'Asus', 'Intel Core i9-12900K', '64GB DDR5', 'NVIDIA GeForce RTX 3090', '2TB NVMe SSD', '17.3 inches', '300Hz', '3840x2160', 'Extreme Gaming Laptop'),
(124, 'Dell', 'AMD Ryzen 9 6900HX', '64GB DDR5', 'AMD Radeon RX 6900M', '2TB SSD', '17 inches', '240Hz', '3840x2160', 'Extreme Gaming Laptop'),
(125, 'Lenovo', 'Intel Core i7-12750H', '32GB DDR5', 'NVIDIA GeForce RTX 3080', '1TB NVMe SSD', '16 inches', '165Hz', '2560x1600', 'Content Creation Laptop');
/*!40000 ALTER TABLE `tbl_laptops` ENABLE KEYS */;


--
-- Definition of table `tbl_mice`
--

DROP TABLE IF EXISTS `tbl_mice`;
CREATE TABLE `tbl_mice` (
  `mouse_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `mouse_manufacturer` varchar(50) DEFAULT NULL,
  `mouse_type` varchar(100) DEFAULT NULL COMMENT 'Gaming/Office',
  `mouse_connection_type` varchar(50) DEFAULT NULL COMMENT 'Connection Type',
  `mouse_design` varchar(100) DEFAULT NULL COMMENT 'Design',
  `mouse_battery` varchar(50) DEFAULT NULL COMMENT 'Battery Type',
  PRIMARY KEY (`mouse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Mice Table';

--
-- Dumping data for table `tbl_mice`
--

/*!40000 ALTER TABLE `tbl_mice` DISABLE KEYS */;
INSERT INTO `tbl_mice` (`product_id`, `mouse_manufacturer`, `mouse_type`, `mouse_connection_type`, `mouse_design`, `mouse_battery`) VALUES
(126, 'Logitech', 'Office', 'Wireless', 'Standard', 'AAA'),
(127, 'Asus', 'Office', 'Wireless', 'Ergonomic', 'AA'),
(128, 'Razer', 'Gaming', 'Wireless', 'Ergonomic', 'Rechargeable'),
(129, 'HyperX', 'Gaming', 'Wireless', 'Ambidextrous', 'Rechargeable'),
(130, 'Logitech', 'Gaming', 'Wireless', 'Ergonomic', 'Rechargeable'),
(131, 'Asus', 'Office', 'Wireless', 'Standard', 'AAA'),
(132, 'Razer', 'Gaming', 'Wired', 'Ergonomic', 'None'),
(133, 'HyperX', 'Gaming', 'Wired', 'Ambidextrous', 'None'),
(134, 'Logitech', 'Office', 'Wired', 'Ergonomic', 'None'),
(135, 'Asus', 'Office', 'Wired', 'Standard', 'None');
/*!40000 ALTER TABLE `tbl_mice` ENABLE KEYS */;


--
-- Definition of table `tbl_monitors`
--

DROP TABLE IF EXISTS `tbl_monitors`;
CREATE TABLE `tbl_monitors` (
  `monitor_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) unsigned NOT NULL,
  `monitor_manufacturer` varchar(100) DEFAULT NULL COMMENT 'Manufacturer',
  `monitor_size` varchar(50) DEFAULT NULL COMMENT 'Size',
  `monitor_type` varchar(100) DEFAULT NULL COMMENT 'Gaming/Office/Graphics',
  `monitor_resolution` varchar(50) DEFAULT NULL COMMENT 'Resolution',
  `monitor_panel_type` varchar(50) DEFAULT NULL COMMENT 'Panel Type',
  `monitor_refresh_rate` int(11) unsigned DEFAULT NULL COMMENT 'Refresh Rate',
  `monitor_screen_type` varchar(50) DEFAULT NULL COMMENT 'Shape/Ratio',
  `monitor_response` double DEFAULT NULL COMMENT 'Respone time',
  PRIMARY KEY (`monitor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Monitors Table';

--
-- Dumping data for table `tbl_monitors`
--

/*!40000 ALTER TABLE `tbl_monitors` DISABLE KEYS */;
INSERT INTO `tbl_monitors` (`product_id`, `monitor_manufacturer`, `monitor_size`, `monitor_type`, `monitor_resolution`, `monitor_panel_type`, `monitor_refresh_rate`, `monitor_screen_type`, `monitor_response`)
VALUES
(136, 'Asus', '24 inch', 'Gaming', '1920x1080', 'IPS', 144, '16:9', 1),
(137, 'Giga', '27 inch', 'Office', '2560x1440', 'VA', 75, '16:9', 5),
(138, 'MSI', '32 inch', 'Graphics', '3840x2160', 'TN', 60, '16:9', 4),
(139, 'Tuff', '27 inch', 'Gaming', '2560x1440', 'IPS', 165, '16:9', 2),
(140, 'Asus', '24 inch', 'Office', '1920x1200', 'IPS', 60, '16:10', 5),
(141, 'Giga', '32 inch', 'Graphics', '3840x2160', 'IPS', 144, '16:9', 4),
(142, 'MSI', '27 inch', 'Gaming', '2560x1440', 'VA', 144, '16:9', 1),
(143, 'Tuff', '24 inch', 'Office', '1920x1080', 'IPS', 75, '16:9', 5),
(144, 'Asus', '27 inch', 'Gaming', '2560x1440', 'TN', 240, '16:9', 1),
(145, 'Giga', '32 inch', 'Office', '2560x1440', 'IPS', 60, '16:9', 4);
/*!40000 ALTER TABLE `tbl_monitors` ENABLE KEYS */;


--
-- Definition of table `tbl_motherboards`
--

DROP TABLE IF EXISTS `tbl_motherboards`;
CREATE TABLE `tbl_motherboards` (
  `motherboard_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `motherboard_manufacturer` varchar(100) DEFAULT NULL COMMENT 'Manufacturer',
  `motherboard_chipset` varchar(100) DEFAULT NULL COMMENT 'Chipset',
  `motherboard_socket` varchar(50) DEFAULT NULL COMMENT 'Socket',
  `motherboard_size` varchar(50) DEFAULT NULL COMMENT 'Size',
  `motherboard_ram_support` varchar(50) DEFAULT NULL COMMENT 'RAM Support',
  `motherboard_ram_slots` varchar(50) DEFAULT NULL COMMENT 'Number of RAM Slots',
  PRIMARY KEY (`motherboard_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Motherboards Table';

--
-- Dumping data for table `tbl_motherboards`
--

/*!40000 ALTER TABLE `tbl_motherboards` DISABLE KEYS */;
INSERT INTO `tbl_motherboards` (`product_id`, `motherboard_manufacturer`, `motherboard_chipset`, `motherboard_socket`, `motherboard_size`, `motherboard_ram_support`, `motherboard_ram_slots`)
VALUES
(146, 'MSI', 'B460', 'LGA1200', 'ATX', 'DDR4', '4'),
(147, 'Asus', 'Z590', 'LGA1200', 'ATX', 'DDR4', '4'),
(148, 'Gigabyte', 'X570', 'AM4', 'ATX', 'DDR4', '4'),
(149, 'MSI', 'H470', 'LGA1200', 'Micro ATX', 'DDR4', '4'),
(150, 'Asus', 'B550', 'AM4', 'Micro ATX', 'DDR4', '4'),
(151, 'Gigabyte', 'B450', 'AM4', 'Mini-ITX', 'DDR4', '2'),
(152, 'MSI', 'B560', 'LGA1200', 'ATX', 'DDR4', '4'),
(153, 'Asus', 'H510', 'LGA1200', 'Micro ATX', 'DDR4', '4'),
(154, 'Gigabyte', 'B550', 'AM4', 'ATX', 'DDR4', '4'),
(155, 'MSI', 'Z590', 'LGA1200', 'ATX', 'DDR4', '4');
/*!40000 ALTER TABLE `tbl_motherboards` ENABLE KEYS */;


--
-- Definition of table `tbl_other_accessories`
--

DROP TABLE IF EXISTS `tbl_other_accessories`;
CREATE TABLE `tbl_other_accessories` (
  `accessory_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL COMMENT 'Description',
  PRIMARY KEY (`accessory_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Other Accessories Table';

--
-- Dumping data for table `tbl_other_accessories`
--

/*!40000 ALTER TABLE `tbl_other_accessories` DISABLE KEYS */;
INSERT INTO `tbl_other_accessories` (`product_id`, `description`)
VALUES
(156, 'External SSD 1TB'),
(157, 'USB 3.0 Flash Drive 64GB'),
(158, 'Wireless Charging Pad'),
(159, 'Gaming Mouse Pad - Large'),
(160, 'Portable Laptop Stand'),
(161, 'Bluetooth Wireless Earbuds'),
(162, 'Gaming Controller for PC'),
(163, 'RGB LED Light Strip - 5m'),
(164, 'Webcam Cover Slider'),
(165, 'Anti-Static Wrist Strap');
/*!40000 ALTER TABLE `tbl_other_accessories` ENABLE KEYS */;


--
-- Definition of table `tbl_power_supply`
--

DROP TABLE IF EXISTS `tbl_power_supply`;
CREATE TABLE `tbl_power_supply` (
  `psu_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `psu_manufacturer` varchar(50) DEFAULT NULL,
  `psu_certification` varchar(50) DEFAULT NULL COMMENT 'Power Certification',
  `psu_cable_type` varchar(100) DEFAULT NULL COMMENT 'Cable Type',
  `psu_size` varchar(50) DEFAULT NULL COMMENT 'Size',
  `psu_power_output` varchar(50) DEFAULT NULL COMMENT 'Power Output',
  PRIMARY KEY (`psu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Power Supply Table';

--
-- Dumping data for table `tbl_power_supply`
--

/*!40000 ALTER TABLE `tbl_power_supply` DISABLE KEYS */;
INSERT INTO `tbl_power_supply` (`product_id`, `psu_manufacturer`, `psu_certification`, `psu_cable_type`, `psu_size`, `psu_power_output`)
VALUES
(166, 'Corsair', '80 Plus Gold', 'Fully Modular', 'ATX', '750W'),
(167, 'NZXT', '80 Plus Platinum', 'Semi-Modular', 'ATX', '650W'),
(168, 'NZXT', '80 Plus Gold', 'Fully Modular', 'ATX', '750W'),
(169, 'NZXT', '80 Plus Bronze', 'Semi-Modular', 'ATX', '650W'),
(170, 'Corsair', '80 Plus Platinum', 'Fully Modular', 'ATX', '850W'),
(171, 'Corsair', '80 Plus Titanium', 'Fully Modular', 'ATX', '1000W'),
(172, 'Corsair', '80 Plus Gold', 'Fully Modular', 'ATX', '850W'),
(173, 'NZXT', '80 Plus Gold', 'Fully Modular', 'ATX', '850W');
/*!40000 ALTER TABLE `tbl_power_supply` ENABLE KEYS */;


--
-- Definition of table `tbl_rams`
--

DROP TABLE IF EXISTS `tbl_rams`;
CREATE TABLE `tbl_rams` (
  `ram_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) unsigned NOT NULL,
  `ram_manufacturer` varchar(50) DEFAULT NULL,
  `ram_type` varchar(50) DEFAULT NULL COMMENT 'RAM Type',
  `ram_capacity` varchar(20) DEFAULT NULL COMMENT 'RAM Capacity',
  `ram_bus_speed` varchar(20) DEFAULT NULL COMMENT 'RAM Bus Speed',
  `ram_standard` varchar(50) DEFAULT NULL COMMENT 'RAM Standard',
  PRIMARY KEY (`ram_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='RAMs Table';

--
-- Dumping data for table `tbl_rams`
--

/*!40000 ALTER TABLE `tbl_rams` DISABLE KEYS */;
INSERT INTO `tbl_rams` (`product_id`, `ram_manufacturer`, `ram_type`, `ram_capacity`, `ram_bus_speed`, `ram_standard`)
VALUES
(174, 'Corsair', 'DDR4', '16GB', '3200 MHz', 'XMP 2.0'),
(175, 'IDCooling', 'DDR4', '8GB', '2666 MHz', 'JEDEC'),
(176, 'G.Skill', 'DDR4', '32GB', '3600 MHz', 'XMP 2.0'),
(177, 'Kingston', 'DDR4', '16GB', '3200 MHz', 'JEDEC'),
(178, 'Corsair', 'DDR4', '64GB', '4000 MHz', 'XMP 3.0'),
(179, 'Crucial', 'DDR4', '8GB', '2666 MHz', 'JEDEC'),
(180, 'TeamGroup', 'DDR4', '16GB', '3600 MHz', 'XMP 2.0'),
(181, 'ADATA', 'DDR4', '32GB', '3200 MHz', 'JEDEC'),
(184, 'Corsair', 'DDR5', '16GB', '4800 MHz', 'XMP 3.0'),
(185, 'Corsair', 'DDR5', '32GB', '5200 MHz', 'XMP 3.0');
/*!40000 ALTER TABLE `tbl_rams` ENABLE KEYS */;


--
-- Definition of table `tbl_storage`
--

DROP TABLE IF EXISTS `tbl_storage`;
CREATE TABLE `tbl_storage` (
  `storage_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `storage_manufacturer` varchar(50) DEFAULT NULL,
  `storage_type` varchar(50) DEFAULT NULL COMMENT 'SSD/HDD',
  `storage_capacity` varchar(20) DEFAULT NULL COMMENT 'Capacity',
  `storage_m2_pcie_type` varchar(50) DEFAULT NULL COMMENT 'M.2 PCIe type',
  `storage_rpm` varchar(20) DEFAULT NULL COMMENT 'RPM',
  PRIMARY KEY (`storage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Storage Table';

--
-- Dumping data for table `tbl_storage`
--

/*!40000 ALTER TABLE `tbl_storage` DISABLE KEYS */;
INSERT INTO `tbl_storage` (`product_id`, `storage_manufacturer`, `storage_type`, `storage_capacity`, `storage_m2_pcie_type`, `storage_rpm`)
VALUES
(186, 'WDB', 'SSD', '500GB', 'M.2 NVMe', NULL),
(187, 'Samsung', 'HDD', '4TB', NULL, '7200 RPM'),
(188, 'Samsung', 'SSD', '500GB', 'SATA', NULL),
(189, 'Kingston', 'SSD', '1TB', 'SATA', NULL),
(190, 'Samsung', 'HDD', '2TB', 'SATA', '500 RPM'),
(191, 'Samsung', 'SSD', '2TB', 'M.2 NVMe', NULL),
(192, 'Samsung', 'SSD', '1TB', 'M.2 NVMe', NULL),
(193, 'WDB', 'SSD', '1TB', 'M.2 NVMe', NULL);
/*!40000 ALTER TABLE `tbl_storage` ENABLE KEYS */;


--
-- Definition of table `tbl_usbs`
--

DROP TABLE IF EXISTS `tbl_usbs`;
CREATE TABLE `tbl_usbs` (
  `usb_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) unsigned NOT NULL,
  `usb_manufacturer` varchar(100) DEFAULT NULL COMMENT 'Manufacturer',
  `usb_capacity` varchar(20) DEFAULT NULL COMMENT 'Capacity',
  PRIMARY KEY (`usb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='USBs Table';
--
-- Dumping data for table `tbl_usbs`
--

/*!40000 ALTER TABLE `tbl_usbs` DISABLE KEYS */;
INSERT INTO `tbl_usbs` (`product_id`, `usb_manufacturer`, `usb_capacity`)
VALUES
(194, 'SanDisk', '64GB'),
(195, 'Samsung', '32GB'),
(196, 'Kingston', '128GB'),
(197, 'Samsung', '256GB'),
(198, 'SanDisk', '64GB'),
(199, 'Kingston', '128GB'),
(200, 'SanDisk', '32GB'),
(201, 'Samsung', '64GB'),
(202, 'Kingston', '32GB'),
(203, 'Samsung', '256GB');
/*!40000 ALTER TABLE `tbl_usbs` ENABLE KEYS */;


--
-- Definition of table `tblaction`
--

DROP TABLE IF EXISTS `tblaction`;
CREATE TABLE `tblaction` (
  `action_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `action_created_date` varchar(14) NOT NULL,
  `action_creator_id` int(11) unsigned NOT NULL DEFAULT '0',
  `action_target_table` int(11) unsigned NOT NULL,
  `action_target_column` int(11) unsigned NOT NULL DEFAULT '0',
  `action_method` int(1) unsigned NOT NULL,
  PRIMARY KEY (`action_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblaction`
--

/*!40000 ALTER TABLE `tblaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblaction` ENABLE KEYS */;


--
-- Definition of table `tblbd`
--

DROP TABLE IF EXISTS `tblbd`;
CREATE TABLE `tblbd` (
  `bd_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `bd_bill_id` int(11) NOT NULL DEFAULT '0' COMMENT 'ID hóa đơn',
  `bd_product_id` int(11) NOT NULL DEFAULT '0' COMMENT 'ID Sản phẩm',
  `bd_product_quantity` int(10) NOT NULL DEFAULT '0' COMMENT 'Số lượng',
  PRIMARY KEY (`bd_id`)
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=utf8 COMMENT='Bảng chi tiết hóa đơn';

--
-- Dumping data for table `tblbd`
--

/*!40000 ALTER TABLE `tblbd` DISABLE KEYS */;
INSERT INTO `tblbd` (`bd_id`,`bd_bill_id`,`bd_product_id`,`bd_product_quantity`) VALUES 
 (1,1,7,5),
 (2,1,8,3),
 (3,1,9,2),
 (4,1,10,1),
 (5,1,6,4),
 (6,2,8,3),
 (7,2,9,2),
 (8,2,12,4),
 (9,2,7,1),
 (10,2,9,3),
 (11,3,12,4),
 (12,3,15,2),
 (13,3,6,1),
 (14,3,8,3),
 (15,3,10,2),
 (16,4,13,2),
 (17,4,23,3),
 (18,4,25,1),
 (19,4,17,4),
 (20,4,19,2),
 (21,5,21,3),
 (22,5,14,4),
 (23,5,16,1),
 (24,5,8,2),
 (25,5,10,3),
 (26,6,12,3),
 (27,6,13,2),
 (28,6,15,4),
 (29,6,17,1),
 (30,6,9,3),
 (31,7,12,4),
 (32,7,14,2),
 (33,7,6,1),
 (34,7,8,3),
 (35,7,10,2),
 (36,8,12,2),
 (37,8,13,3),
 (38,8,15,1),
 (39,8,7,4),
 (40,8,9,2),
 (41,9,12,3),
 (42,9,14,4),
 (43,9,16,1),
 (44,9,18,2),
 (45,9,10,3),
 (46,10,12,5),
 (47,10,12,3),
 (48,10,13,2),
 (49,10,14,1),
 (50,10,15,4),
 (51,11,12,3),
 (52,11,21,2),
 (53,11,13,1),
 (54,11,14,4),
 (55,11,15,3),
 (56,12,6,2),
 (57,12,8,3),
 (58,12,10,1),
 (59,12,12,4),
 (60,12,14,2),
 (61,13,16,3),
 (62,13,18,4),
 (63,13,20,1),
 (64,13,22,3),
 (65,13,24,2),
 (66,14,17,4),
 (67,14,19,2),
 (68,14,21,1),
 (69,14,23,3),
 (70,14,25,2),
 (71,15,12,3),
 (72,15,13,2),
 (73,15,15,1),
 (74,15,7,4),
 (75,15,9,2),
 (76,16,12,4),
 (77,16,14,2),
 (78,16,16,1),
 (79,16,18,3),
 (80,16,10,2),
 (81,17,12,2),
 (82,17,31,3),
 (83,17,15,1),
 (84,17,17,4),
 (85,17,9,2),
 (86,18,12,3),
 (87,18,14,4),
 (88,18,16,1),
 (89,18,8,2),
 (90,18,10,3),
 (91,19,12,3),
 (92,19,13,2),
 (93,19,15,1),
 (94,19,17,4),
 (95,19,19,2),
 (96,20,12,4),
 (97,20,14,3),
 (98,20,16,2),
 (99,20,18,1),
 (100,20,20,4),
 (101,21,21,3),
 (102,21,22,2),
 (103,21,23,1),
 (104,21,24,4),
 (105,21,25,3),
 (106,22,6,2),
 (107,22,8,3),
 (108,22,10,1),
 (109,22,12,4),
 (110,22,14,2),
 (111,23,16,3),
 (112,23,18,4),
 (113,23,20,1),
 (114,23,22,3),
 (115,23,24,2),
 (116,24,17,4),
 (117,24,19,2),
 (118,24,21,1),
 (119,24,23,3),
 (120,24,25,2),
 (121,25,12,3),
 (122,25,13,2),
 (123,25,15,1),
 (124,25,17,4),
 (125,25,9,2),
 (126,26,12,4),
 (127,26,14,2),
 (128,26,6,1),
 (129,26,8,3),
 (130,26,10,2),
 (131,27,10,2),
 (132,27,31,3),
 (133,27,15,1),
 (134,27,7,4),
 (135,27,9,2),
 (136,28,12,3),
 (137,28,14,4),
 (138,28,6,1),
 (139,28,8,2),
 (140,28,10,3),
 (141,29,10,3),
 (142,29,13,2),
 (143,29,15,1),
 (144,29,17,4),
 (145,29,19,2),
 (146,30,12,4),
 (147,30,14,3),
 (148,30,16,2),
 (149,30,18,1),
 (150,30,20,4),
 (151,31,21,3),
 (152,31,22,2),
 (153,31,23,1),
 (154,31,24,4),
 (155,31,25,3),
 (156,32,6,2),
 (157,32,8,3),
 (158,32,10,1),
 (159,32,12,4),
 (160,32,14,2),
 (161,33,16,3),
 (162,33,18,4),
 (163,33,20,1),
 (164,33,22,3),
 (165,33,24,2),
 (166,34,17,4),
 (167,34,19,2),
 (168,34,21,1),
 (169,34,23,3),
 (170,34,25,2),
 (171,35,10,3),
 (172,35,13,2),
 (173,35,15,1),
 (174,35,17,4),
 (175,35,9,2),
 (176,36,12,4),
 (177,36,14,2),
 (178,36,6,1),
 (179,36,8,3),
 (180,36,10,2),
 (181,37,10,2),
 (182,37,13,3),
 (183,37,15,1),
 (184,37,7,4),
 (185,37,19,2),
 (186,38,12,3),
 (187,38,14,4),
 (188,38,16,1),
 (189,38,8,2),
 (190,38,10,3),
 (191,39,12,3),
 (192,39,13,2),
 (193,39,15,1),
 (194,39,17,4),
 (195,39,19,2),
 (196,40,12,4),
 (197,40,14,3),
 (198,40,16,2),
 (199,40,18,1),
 (200,40,20,4),
 (201,41,21,3),
 (202,41,22,2),
 (203,41,23,1),
 (204,41,24,4),
 (205,41,25,3),
 (206,42,6,2),
 (207,42,8,3),
 (208,42,10,1),
 (209,42,12,4),
 (210,42,14,2),
 (211,43,16,3),
 (212,43,18,4),
 (213,43,20,1),
 (214,43,22,3),
 (215,43,24,2),
 (216,44,17,4),
 (217,44,19,2),
 (218,44,21,1),
 (219,44,23,3),
 (220,44,25,2),
 (221,45,13,3),
 (222,45,13,2),
 (223,45,15,1),
 (224,45,7,4),
 (225,45,9,2),
 (226,46,12,4),
 (227,46,14,2),
 (228,46,6,1),
 (229,46,8,3),
 (230,46,10,2),
 (231,47,14,2),
 (232,47,13,3),
 (233,47,5,1),
 (234,47,7,4),
 (235,47,9,2),
 (236,48,12,3),
 (237,48,14,4),
 (238,48,16,1),
 (239,48,8,2),
 (240,48,10,3),
 (241,49,15,3),
 (242,49,13,2),
 (243,49,15,1),
 (244,49,17,4),
 (245,49,19,2),
 (246,50,12,4),
 (247,50,14,3),
 (248,50,16,2),
 (249,50,18,1),
 (250,50,20,4);
/*!40000 ALTER TABLE `tblbd` ENABLE KEYS */;


--
-- Definition of table `tblbill`
--

DROP TABLE IF EXISTS `tblbill`;
CREATE TABLE `tblbill` (
  `bill_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID hóa đơn',
  `bill_created_date` varchar(15) DEFAULT NULL COMMENT 'Ngày tạo hóa đơn',
  `bill_creator_id` int(11) DEFAULT '0' COMMENT 'Người tạo hóa đơn',
  `bill_delivery_id` int(11) DEFAULT '0' COMMENT 'Người vận chuyển, Đơn vị vận chuyển',
  PRIMARY KEY (`bill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COMMENT='Bảng hóa đơn';

--
-- Dumping data for table `tblbill`
--

/*!40000 ALTER TABLE `tblbill` DISABLE KEYS */;
INSERT INTO `tblbill` (`bill_id`,`bill_created_date`,`bill_creator_id`,`bill_delivery_id`) VALUES 
 (1,'1/1/2023',1,1),
 (2,'6/1/2023',2,2),
 (3,'13/1/2023',3,3),
 (4,'20/1/2023',4,4),
 (5,'26/1/2023',5,5),
 (6,'3/2/2023',6,6),
 (7,'8/2/2023',7,7),
 (8,'12/2/2023',8,8),
 (9,'18/2/2023',9,9),
 (10,'23/2/2023',10,10),
 (11,'1/3/2023',1,11),
 (12,'9/3/2023',2,12),
 (13,'15/3/2023',3,13),
 (14,'21/3/2023',4,14),
 (15,'28/3/2023',5,15),
 (16,'3/4/2023',6,16),
 (17,'8/4/2023',7,17),
 (18,'15/4/2023',8,18),
 (19,'22/4/2023',9,19),
 (20,'26/4/2023',10,20),
 (21,'5/5/2023',1,21),
 (22,'10/5/2023',2,22),
 (23,'16/5/2023',3,23),
 (24,'21/5/2023',4,24),
 (25,'27/5/2023',5,25),
 (26,'5/6/2023',6,26),
 (27,'11/6/2023',7,27),
 (28,'17/6/2023',8,28),
 (29,'23/6/2023',9,29),
 (30,'28/6/2023',10,30),
 (31,'4/7/2023',1,31),
 (32,'11/7/2023',2,32),
 (33,'17/7/2023',3,33),
 (34,'23/7/2023',4,34),
 (35,'1/8/2023',5,35),
 (36,'8/8/2023',6,36),
 (37,'14/8/2023',7,37),
 (38,'19/8/2023',8,38),
 (39,'25/8/2023',9,39),
 (40,'4/9/2023',10,40),
 (41,'12/9/2023',1,41),
 (42,'17/9/2023',2,42),
 (43,'24/9/2023',3,43),
 (44,'1/10/2023',4,44),
 (45,'7/10/2023',5,45),
 (46,'13/10/2023',6,46),
 (47,'17/10/2023',7,47),
 (48,'23/10/2023',8,48),
 (49,'1/11/2023',9,49),
 (50,'8/11/2023',10,50);
/*!40000 ALTER TABLE `tblbill` ENABLE KEYS */;


--
-- Definition of table `tblcomment`
--

DROP TABLE IF EXISTS `tblcomment`;
CREATE TABLE `tblcomment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_content` text NOT NULL,
  `comment_created_date` int(11) NOT NULL,
  `comment_creator_id` int(11) NOT NULL,
  `comment_product_id` int(11) NOT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblcomment`
--

/*!40000 ALTER TABLE `tblcomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblcomment` ENABLE KEYS */;


--
-- Definition of table `tbldelivery`
--

DROP TABLE IF EXISTS `tbldelivery`;
CREATE TABLE `tbldelivery` (
  `delivery_id` int(11) NOT NULL AUTO_INCREMENT,
  `delivery_name` varchar(255) NOT NULL,
  PRIMARY KEY (`delivery_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbldelivery`
--

/*!40000 ALTER TABLE `tbldelivery` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbldelivery` ENABLE KEYS */;


--
-- Definition of table `tbllog`
--

DROP TABLE IF EXISTS `tbllog`;
CREATE TABLE `tbllog` (
  `log_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `log_user_id` varchar(45) NOT NULL COMMENT 'ID người khởi tạo',
  `log_user_permission` smallint(1) unsigned NOT NULL COMMENT 'Quyền của người dùng',
  `log_username` varchar(45) NOT NULL COMMENT 'Tên người dùng',
  `log_action` smallint(1) unsigned NOT NULL COMMENT '1-Add, 2- Edit, 3-Del',
  `log_position` smallint(50) unsigned NOT NULL COMMENT 'Vị trí bảng (1-bill, 2-bd, 3-employee. 4-guarantee, 5-product, 6-provider, 7-user, 8-shop, 9-wsd)',
  `log_name` text COMMENT 'Tên log',
  `log_notes` text COMMENT 'Ghi chú của log',
  `log_created_date` varchar(45) DEFAULT NULL COMMENT 'Ngày khởi tạo Log',
  `log_deleted` bit(1) NOT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='Bảng thông tin nhật ký';

--
-- Dumping data for table `tbllog`
--

/*!40000 ALTER TABLE `tbllog` DISABLE KEYS */;
INSERT INTO `tbllog` (`log_id`,`log_user_id`,`log_user_permission`,`log_username`,`log_action`,`log_position`,`log_name`,`log_notes`,`log_created_date`,`log_deleted`) VALUES 
 (1,'1',1,'DogLoverr',1,1,'log_name 1','log_notes 1','10:20:40 21/12/2023',0x00),
 (2,'2',2,'Pé',2,2,'log_name 2','log_notes 2','15:20:30 22/12/2023',0x00),
 (3,'3',3,'SktKhanh',3,3,'log_name 3','log_notes 3','9:30:05 23/12/2023',0x00),
 (4,'4',4,'Cloudy999',1,4,'log_name 4','log_notes 4','8:11:06 24/12/2023',0x00),
 (5,'5',5,'TuanWhite',2,5,'log_name 5','log_notes 5','9:09:08 24/12/2023',0x00),
 (6,'6',4,'admin@gmail.com',1,8,NULL,'','07:08:06 26/12/2023',0x00),
 (7,'6',4,'admin@gmail.com',1,8,NULL,'','02:37:07 29/12/2023',0x00),
 (8,'6',4,'admin@gmail.com',1,8,NULL,'','09:18:16 29/12/2023',0x00),
 (9,'6',4,'admin@gmail.com',3,8,NULL,'','23:01:01 04/01/2024',0x00),
 (10,'6',4,'admin@gmail.com',1,8,NULL,'','23:02:24 04/01/2024',0x00),
 (11,'6',4,'admin@gmail.com',1,8,NULL,'','23:03:04 04/01/2024',0x00);
/*!40000 ALTER TABLE `tbllog` ENABLE KEYS */;


--
-- Definition of table `tblpc`
--

DROP TABLE IF EXISTS `tblpc`;
CREATE TABLE `tblpc` (
  `pc_id` int(11) NOT NULL AUTO_INCREMENT,
  `pc_name` varchar(100) DEFAULT NULL,
  `pc_notes` text,
  `pc_created_date` varchar(10) DEFAULT NULL,
  `pc_image` varchar(100) DEFAULT NULL,
  `pc_enable` bit(1) DEFAULT NULL,
  `pc_parent_id` int(11) DEFAULT NULL,
  `pc_creator_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='Bảng danh mục sản phẩm';

--
-- Dumping data for table `tblpc`
--

/*!40000 ALTER TABLE `tblpc` DISABLE KEYS */;
INSERT INTO `tblpc` (`pc_id`,`pc_name`,`pc_notes`,`pc_created_date`,`pc_image`,`pc_enable`,`pc_parent_id`,`pc_creator_id`) VALUES 
 (1,'Màn hình','','','',0x00,0,0),
 (2,'Bàn phím','','','',0x00,0,0),
 (3,'Chuột','','','',0x00,0,0),
 (4,'Tai nghe - Loa','','','',0x00,0,0),
 (5,'Laptop','','','',0x00,0,0),
 (6,'Desktop','','','',0x00,0,0),
 (7,'CPU','','','',0x00,0,0),
 (8,'Mainboard','','','',0x00,0,0),
 (9,'Ram','','','',0x00,0,0),
 (10,'Ổ cứng','','','',0x00,0,0),
 (11,'VGA','','','',0x00,0,0),
 (12,'PSU','','','',0x00,0,0),
 (13,'Vỏ case','','','',0x00,0,0),
 (14,'Tản nhiệt','','','',0x00,0,0),
 (15,'USB','','','',0x00,0,0),
 (16,'Thiết bị khác','','','',0x00,0,0);
/*!40000 ALTER TABLE `tblpc` ENABLE KEYS */;


--
-- Definition of table `tblproduct`
--

DROP TABLE IF EXISTS `tblproduct`;
CREATE TABLE `tblproduct` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) NOT NULL,
  `product_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0 - chưa  đư?c bán\n1 - đang bán\n2 - ng?ng kinh doanh',
  `product_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0 - không b? đưa vào thùng rác\n1 - b? đưa vào thùng rác',
  `product_visited` int(11) DEFAULT NULL,
  `product_price` double DEFAULT NULL,
  `product_images` text,
  `product_notes` text,
  `product_created_date` varchar(45) DEFAULT NULL,
  `product_last_modified` varchar(45) DEFAULT NULL,
  `product_pc_id` smallint(5) unsigned NOT NULL COMMENT 'Loai san pham',
  `product_shop_id` int(10) unsigned DEFAULT '0',
  `product_quantity` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1 COMMENT='Bảng sản phẩm';

--
-- Dumping data for table `tblproduct`
--

/*!40000 ALTER TABLE `tblproduct` DISABLE KEYS */;
INSERT INTO `tblproduct` (`product_id`,`product_name`,`product_status`,`product_deleted`,`product_visited`,`product_price`,`product_images`,`product_notes`,`product_created_date`,`product_last_modified`,`product_pc_id`,`product_shop_id`,`product_quantity`) VALUES 
 (6,'MacBook Air 13 inch M1 2020 7-core GPU',1,0,3,32000000,' https://cdn.tgdd.vn/Products/Images/44/231244/grey-1-org.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,2,1),
 (7,'HP 15s fq5229TU i3 1215U (8U237PA)',1,0,2,12300000,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,2,2),
 (8,'Asus TUF Gaming F15 FX506HF i5 11400H (HN014W)',1,0,1,16000000,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,2,3),
 (9,'Acer Aspire 5 Gaming A515 58GM 51LB i5 13420H (NX.KQ4SV.002)',1,0,42,19800000,' https://product.hstatic.net/200000837185/product/laptopgamingmsidelta15a5efk-095vn_e4fd817ae7fa48b3a3e4b73e50d60d80_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,3,4),
 (10,'Asus Vivobook Go 15 E1504FA R5 7520U (NJ776W)',1,0,123,17990000,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,5,5),
 (12,'HP 240 G9 i3 1215U (6L1X7PA)',1,0,12,11300000,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,3,5),
 (13,'Asus Vivobook 16 X1605VA i5 1335U (MB360W)',0,0,145,14000000,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,2,5),
 (14,'HP 15s fq5162TU i5 1235U (7C134PA)',1,0,25,15200000,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,2,5),
 (15,'Asus Vivobook 15 X1504ZA i3 1215U (NJ102W)',0,0,16,12300000,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,4,5),
 (16,'Asus Vivobook X515EA i3 1115G4 (EJ3948W)',1,0,22,11700000,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,1,2),
 (17,'HP Pavilion 14 dv2074TU i5 1235U (7C0P3PA)',0,0,NULL,12000000,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,1,5),
 (18,'Asus Vivobook X515EA i5 1135G7 (EJ4155W)',1,0,22,9800000,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,5,1),
 (19,'Dell Vostro 15 3520 i3 1215U (5M2TT1)',0,0,NULL,0,' https://cdn.tgdd.vn/Products/Images/44/314830/dell-vostro-3430-i5-71011900-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,2,2),
 (20,'HP 14 ep0126TU i3 N305 (8U233PA)',1,0,1,12200000,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,1,1),
 (21,'Lenovo Ideapad 3 15ITL6 i3 1115G4 (82H803SGVN)',0,0,NULL,0,' https://cdn.tgdd.vn/Products/Images/44/303562/lenovo-ideapad-1-15amn7-r5-82vg0061vn-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,1,3),
 (22,'Dell Inspiron 15 3520 i3 1215U (71003264)',1,0,54,14500000,' https://cdn.tgdd.vn/Products/Images/44/314830/dell-vostro-3430-i5-71011900-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,3,4),
 (23,'HP 15s fq2716TU i3 1115G4 (7C0X3PA)',0,0,NULL,12300000,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,4,3),
 (24,'Asus Vivobook X415EA i3 1115G4 (EK2034W)',1,0,11,11100000,' https://cdn.tgdd.vn/Products/Images/44/303562/lenovo-ideapad-1-15amn7-r5-82vg0061vn-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,5,1),
 (26,'Dell Inspiron 15 3520 i5 1235U (N5I5122W1)',1,0,22,16200000,' https://cdn.tgdd.vn/Products/Images/44/314830/dell-vostro-3430-i5-71011900-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,2,3),
 (27,'Asus Vivobook 15 X1504VA i5 1335U (NJ025W)',0,0,11,13900000,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,2,1),
 (29,'Lenovo Ideapad 3 15IAU7 i3 1215U (82RK005LVN)',0,0,3,11900000,' https://cdn.tgdd.vn/Products/Images/44/303562/lenovo-ideapad-1-15amn7-r5-82vg0061vn-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,1,2),
 (30,'HP Pavilion 15 eg2082TU i5 1240P (7C0Q5PA)',1,0,25,13900000,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,1,1),
 (31,'Lenovo Ideapad 3 15ITL6 i5 1155G7 (82H803RRVN)',0,0,1,9800000,' https://cdn.tgdd.vn/Products/Images/44/303562/lenovo-ideapad-1-15amn7-r5-82vg0061vn-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,1,1),
 (32,'HP 240 G8 i3 1115G4 (6L1A1PA)',1,0,15,9790000,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg','null',CURRENT_DATE(),' 30/10/2023',5,2,3),
 (33,'Asus TUF Gaming F15 FX506HE i7 11800H (HN378W)',0,0,1,10000000,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png','null',CURRENT_DATE(),' 30/10/2023',5,4,1),
 (34,'HP 15s fq5147TU i7 1255U (7C133PA)',1,0,12,12700000,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg','null',CURRENT_DATE(),' 30/10/2023',5,5,3),
 (35,'Acer Aspire 3 A315 59 314F i3 1215U (NX.K6TSV.002)',0,0,1,10000000,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,2,2),
 (36,'MSI Gaming GF63 Thin 11SC i5 11400H (664VN)',1,0,23,11200000,' https://product.hstatic.net/200000837185/product/laptopgamingmsidelta15a5efk-095vn_e4fd817ae7fa48b3a3e4b73e50d60d80_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,1,1),
 (38,'MSI Gaming GF63 Thin 11UC i7 11800H (1228VN)',1,0,0,13200000,' https://product.hstatic.net/200000837185/product/laptopgamingmsidelta15a5efk-095vn_e4fd817ae7fa48b3a3e4b73e50d60d80_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,1,1),
 (39,'Asus Vivobook 15 OLED A1505VA i5 13500H (L1341W)',1,1,231,16200000,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,2,1),
 (40,'Lenovo Ideapad Slim 3 15IAH8 i5 12450H (83ER000EVN)',1,0,100,18790000,' https://cdn.tgdd.vn/Products/Images/44/303562/lenovo-ideapad-1-15amn7-r5-82vg0061vn-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,2,1),
 (41,'MacBook Air 13 inch M2 2022 8-core GPU',0,0,0,0,' https://cdn.tgdd.vn/Products/Images/44/231244/grey-1-org.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,4,1),
 (42,'Acer Nitro 5 Gaming AN515 57 5669 i5 11400H (NH.QEHSV.001)',1,0,123,17600000,' https://cdn.tgdd.vn/Products/Images/44/231244/grey-1-org.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,1,1),
 (43,'HP Pavilion 15 eg2081TU i5 1240P (7C0Q4PA)',0,0,0,0,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,5,1),
 (44,'Dell Vostro 3520 i3 1215U (V5I3614W1)',1,0,0,14200000,' https://cdn.tgdd.vn/Products/Images/44/314830/dell-vostro-3430-i5-71011900-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,2,1),
 (45,'Lenovo Ideapad 3 15ITL6 i3 1115G4 (82H803SFVN)',0,1,0,11000000,' https://cdn.tgdd.vn/Products/Images/44/303562/lenovo-ideapad-1-15amn7-r5-82vg0061vn-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,1,1),
 (46, 'IDCooling Black Mid Tower Case', 1, 0, 0, 1500000, 'NULL', 'High-quality black mid tower case from IDCooling.', '2023-11-01', CURDATE(), 13, 1, 1),
(47, 'Corsair White Full Tower Case', 1, 0, 0, 2000000, 'NULL', 'Premium white full tower case from Corsair.', '2023-11-02', CURDATE(), 13, 2, 2),
(48, 'MSI Blue Mini Tower Case', 1, 0, 0, 1200000, 'NULL', 'Compact blue mini tower case from MSI.', '2023-11-03', CURDATE(), 13, 3, 3),
(49, 'Gigabyte Red Micro Tower Case', 1, 0, 0, 900000, 'NULL', 'Sleek red micro tower case from Gigabyte.', '2023-11-04', CURDATE(), 13, 4, 4),
(50, 'Asus Green ATX Case', 1, 0, 0, 1800000, 'NULL', 'Stylish green ATX case from Asus.', '2023-11-05', CURDATE(), 13, 5, 1),
(51, 'IDCooling Yellow Mini-ITX Case', 1, 0, 0, 1000000, 'NULL', 'Compact yellow mini-ITX case from IDCooling.', '2023-11-06', CURDATE(), 13, 1, 5),
(52, 'Corsair Purple Micro ATX Case', 1, 0, 0, 1500000, 'NULL', 'Elegant purple micro ATX case from Corsair.', '2023-11-07', CURDATE(), 13, 2, 4),
(53, 'MSI Orange E-ATX Case', 1, 0, 0, 2200000, 'NULL', 'Vibrant orange E-ATX case from MSI.', '2023-11-08', CURDATE(), 13, 3, 2),
(54, 'Gigabyte Pink Slim Tower Case', 1, 0, 0, 800000, 'NULL', 'Compact pink slim tower case from Gigabyte.', '2023-11-09', CURDATE(), 13, 4, 3),
(55, 'Asus Gray Cube Case', 1, 0, 0, 1300000, 'NULL', 'Modern gray cube case from Asus.', '2023-11-10', CURDATE(), 13, 5, 5),
(56, 'Corsair Black Air Cooler 120mm', 1, 0, 0, 800000, 'NULL', 'High-quality black air cooler from Corsair with 120mm fan size.', '2023-11-01', CURDATE(), 14, 1, 1),
(57, 'Deepcool White Liquid Cooler 120mm', 1, 0, 0, 1200000, 'NULL', 'Premium white liquid cooler from Deepcool with 120mm fan size.', '2023-11-02', CURDATE(), 14, 2, 2),
(58, 'Corsair Black Air Cooler 120mm', 1, 0, 0, 800000, 'NULL', 'High-quality black air cooler from Corsair with 120mm fan size.', '2023-11-03', CURDATE(), 14, 3, 3),
(59, 'Xigmatek Black Air Cooler 120mm', 1, 0, 0, 700000, 'NULL', 'Sleek black air cooler from Xigmatek with 120mm fan size.', '2023-11-04', CURDATE(), 14, 4, 4),
(60, 'ID-COOLING RGB Liquid Cooler 120mm', 1, 0, 0, 1500000, 'NULL', 'Colorful RGB liquid cooler from ID-COOLING with 120mm fan size.', '2023-11-05', CURDATE(), 14, 5, 5),
(61, 'ID-COOLING White Liquid Cooler 120mm', 1, 0, 0, 1400000, 'NULL', 'Elegant white liquid cooler from ID-COOLING with 120mm fan size.', '2023-11-06', CURDATE(), 14, 1, 1),
(62, 'Xigmatek White Air Cooler 120mm', 1, 0, 0, 750000, 'NULL', 'Sleek white air cooler from Xigmatek with 120mm fan size.', '2023-11-07', CURDATE(), 14, 2, 2),
(63, 'Corsair Black Liquid Cooler 120mm', 1, 0, 0, 1100000, 'NULL', 'High-quality black liquid cooler from Corsair with 120mm fan size.', '2023-11-08', CURDATE(), 14, 3, 3),
(64, 'Corsair Black Liquid Cooler 120mm', 1, 0, 0, 1100000, 'NULL', 'High-quality black liquid cooler from Corsair with 120mm fan size.', '2023-11-09', CURDATE(), 14, 4, 5),
(65, 'ID-COOLING White Liquid Cooler 120mm', 1, 0, 0, 1400000, 'NULL', 'Elegant white liquid cooler from ID-COOLING with 120mm fan size.', '2023-11-10', CURDATE(), 14, 5, 4),
(66, 'AMD Ryzen 9 7900 CPU', 1, 0, 800, 4500000, 'NULL', 'AMD Ryzen 9 7900 CPU with Socket AM5, 12 cores, 24 threads, and 3.0 - 4.6 GHz speed.', '2023-11-01', CURDATE(), 7, 2, 1), 
(67, 'AMD Ryzen 7 7800X3D CPU', 1, 0, 1000, 3000000, 'NULL', 'AMD Ryzen 7 7800X3D CPU with Socket AM5, 8 cores, 16 threads, and 3.2 - 4.8 GHz speed.', '2023-10-15', CURDATE(), 7, 3, 2), 
(68, 'Intel Core i9-14900K CPU', 1, 0, 1200, 6000000, 'NULL', 'Intel Core i9-14900K CPU with LGA 1700 socket, 24 cores, 32 threads, and 3.2 - 5.6 GHz speed.', '2023-09-20', CURDATE(), 7, 4, 3), 
(69, 'Intel Core i7-14700K CPU', 1, 0, 1400, 5500000, 'NULL', 'Intel Core i7-14700K CPU with LGA 1700 socket, 20 cores, 28 threads, and 3.4 - 5.6 GHz speed.', '2023-08-10', CURDATE(), 7, 5, 4), 
(70, 'Intel Core i5-12600K CPU', 1, 0, 1100, 3500000, 'NULL', 'Intel Core i5-12600K CPU with LGA 1200 socket, 12 cores, 16 threads, and 3.0 - 4.4 GHz speed.', '2023-07-05', CURDATE(), 7, 1, 5), 
(71, 'AMD Ryzen 5 6500 CPU', 1, 0, 1300, 2500000, 'NULL', 'AMD Ryzen 5 6500 CPU with Socket AM4, 6 cores, 12 threads, and 3.2 - 4.4 GHz speed.', '2023-06-20', CURDATE(), 7, 3, 1), 
(72, 'Intel Core i3-12100 CPU', 1, 0, 1500, 2000000, 'NULL', 'Intel Core i3-12100 CPU with LGA 1200 socket, 4 cores, 8 threads, and 2.8 - 4.2 GHz speed.', '2023-05-15', CURDATE(), 7, 2, 2), 
(73, 'AMD Athlon 3000G CPU', 1, 0, 900, 1000000, 'NULL', 'AMD Athlon 3000G CPU with Socket AM4, 4 cores, 4 threads, and 3.0 - 3.2 GHz speed.', '2023-04-10', CURDATE(), 7, 5, 3), 
(74, 'Intel Pentium Gold G6500 CPU', 1, 0, 700, 1200000, 'NULL', 'Intel Pentium Gold G6500 CPU with LGA 1200 socket, 2 cores, 4 threads, and 3.1 - 3.5 GHz speed.', '2023-03-05', CURDATE(), 7, 1, 4), 
(75, 'AMD A-Series A6-9500 CPU', 1, 0, 1000, 800000, 'NULL', 'AMD A-Series A6-9500 CPU with Socket AM4, 2 cores, 4 threads, and 3.5 - 3.8 GHz speed.', '2023-02-20', CURDATE(), 7, 4, 5),
(76, 'Asus Gaming Desktop', 1, 0, 800, 20000000, 'NULL', 'Gaming desktop by Asus with Intel Core i5-11400F CPU, NVIDIA GeForce GTX 1650 GPU, 16GB DDR4 RAM, and 512GB SSD storage.', '2023-11-15', CURDATE(), 9, 3, 22), 
(77, 'Giga Gaming Desktop', 1, 0, 1000, 35000000, 'NULL', 'Gaming desktop by Giga with Intel Core i7-14700K CPU, NVIDIA GeForce RTX 4060 Ti GPU, 32GB DDR5 RAM, and 1TB SSD + 2TB HDD storage.', '2023-10-05', CURDATE(), 9, 1, 18), 
(78, 'MSI Gaming Desktop', 1, 0, 1200, 25000000, 'NULL', 'Gaming desktop by MSI with Intel Core i5-12600K CPU, NVIDIA GeForce RTX 4060 Ti GPU, 16GB DDR4 RAM, and 1TB SSD storage.', '2023-09-20', CURDATE(), 9, 4, 20), 
(79, 'Asus Gaming Desktop', 1, 0, 900, 23000000, 'NULL', 'Gaming desktop by Asus with AMD Ryzen 9 5900X CPU, NVIDIA GeForce RTX 3080 GPU, 64GB DDR4 RAM, and 2TB NVMe SSD + 4TB HDD storage.', '2023-08-10', CURDATE(), 9, 2, 25), 
(80, 'Giga Gaming Desktop', 1, 0, 600, 10000000, 'NULL', 'Gaming desktop by Giga with AMD Ryzen 7 5800X CPU, NVIDIA GeForce RTX 3070 Ti GPU, 32GB DDR4 RAM, and 1TB SSD storage.', '2023-12-01', CURDATE(), 9, 5, 15), 
(81, 'MSI Gaming Desktop', 1, 0, 800, 16000000, 'NULL', 'Gaming desktop by MSI with Intel Core i9-12900K CPU, NVIDIA GeForce RTX 3090 GPU, 64GB DDR5 RAM, and 2TB NVMe SSD storage.', '2023-07-25', CURDATE(), 9, 3, 22), 
(82, 'Asus Office Desktop', 1, 0, 1100, 30000000, 'NULL', 'Office desktop by Asus with Intel Core i7-12700K CPU, NVIDIA GeForce RTX 3050 GPU, 32GB DDR4 RAM, and 1TB SSD storage.', '2023-06-15', CURDATE(), 9, 1, 20), 
(83, 'Giga Graphics Desktop', 1, 0, 1300, 35000000, 'NULL', 'Graphics desktop by Giga with AMD Ryzen 5 5600X CPU, NVIDIA GeForce RTX 3060 GPU, 16GB DDR4 RAM, and 512GB NVMe SSD storage.', '2023-05-05', CURDATE(), 9, 4, 18), 
(84, 'MSI Graphics Desktop', 1, 0, 1400, 38000000, 'NULL', 'Graphics desktop by MSI with Intel Core i5-12400F CPU, NVIDIA GeForce GTX 1660 Ti GPU, 16GB DDR4 RAM, and 512GB SSD + 1TB HDD storage.', '2023-04-10', CURDATE(), 9, 2, 21), 
(85, 'Asus Office Desktop', 1, 0, 950, 18000000, 'NULL', 'Office desktop by Asus with Intel Core i3-12100F CPU, NVIDIA GeForce GT 1030 GPU, 8GB DDR4 RAM, and 256GB SSD storage.', '2023-03-20', CURDATE(), 9, 5, 17),
(86, 'NVIDIA RTX 3060 12GB', 1, 0, 0, 12000000, 'NULL', 'High-performance graphics card for gaming and rendering.', '2023-11-01', CURDATE(), 11, 1, 25),
(87, 'AMD RX 6600 8GB', 1, 0, 0, 9000000, 'NULL', 'Mid-range graphics card suitable for gaming.', '2023-11-02', CURDATE(), 11, 2, 30),
(88, 'NVIDIA RTX 4070 16GB', 1, 0, 0, 25000000, 'NULL', 'High-end graphics card for gaming and professional workloads.', '2023-11-03', CURDATE(), 11, 3, 40),
(89, 'NVIDIA RTX 4090 24GB', 1, 0, 0, 40000000, 'NULL', 'Top-tier graphics card for extreme gaming and rendering.', '2023-11-04', CURDATE(), 11, 4, 35),
(90, 'NVIDIA GTX 1660 Ti 6GB', 1, 0, 0, 7000000, 'NULL', 'Budget-friendly graphics card for casual gaming.', '2023-11-05', CURDATE(), 11, 5, 20),
(91, 'AMD RX 6700 XT 12GB', 1, 0, 0, 18000000, 'NULL', 'High-performance graphics card for gaming and content creation.', '2023-11-06', CURDATE(), 11, 1, 30),
(92, 'NVIDIA GTX 3080 10GB', 1, 0, 0, 30000000, 'NULL', 'Powerful graphics card for high-end gaming and VR.', '2023-11-07', CURDATE(), 11, 2, 25),
(93, 'AMD RX 6800 XT 16GB', 1, 0, 0, 22000000, 'NULL', 'Flagship graphics card for enthusiast gaming and professional work.', '2023-11-08', CURDATE(), 11, 3, 40),
(94, 'NVIDIA GTX 3060 Ti 8GB', 1, 0, 0, 15000000, 'NULL', 'Mid-range graphics card for high-quality gaming.', '2023-11-09', CURDATE(), 11, 4, 35),
(95, 'AMD RX 6700 6GB', 1, 0, 0, 12000000, 'NULL', 'Entry-level graphics card for casual gaming and multimedia.', '2023-11-10', CURDATE(), 11, 5, 30),
(96, 'Logitech Wireless Headphones', 1, 0, 700, 900000, 'NULL', 'Wireless headphones by Logitech with USB connection.', '2023-07-15', CURDATE(), 4, 3, 18), 
(97, 'Asus Wired Headphones', 1, 0, 500, 600000, 'NULL', 'Wired headphones by Asus with USB connection.', '2023-09-28', CURDATE(), 4, 1, 15), 
(98, 'Razer Wired Headphones', 1, 0, 600, 800000, NULL, 'Wired headphones by Razer with USB connection.', '2023-08-20', CURDATE(), 4, 4, 17), 
(99, 'HyperX Wireless Bluetooth Headphones', 1, 0, 800, 1200000, NULL, 'Wireless Bluetooth headphones by HyperX with Bluetooth connection.', '2023-10-10', CURDATE(), 4, 2, 22), 
(100, 'Logitech Wireless Headphones', 1, 0, 650, 850000, NULL, 'Wireless headphones by Logitech with USB connection.', '2023-06-30', CURDATE(), 4, 5, 20), 
(101, 'Asus Wired Speaker', 1, 0, 750, 1500000, NULL, 'Wired speaker by Asus with 3.5mm connection.', '2023-11-05', CURDATE(), 4, 3, 25), 
(102, 'Razer Wired Headphones', 1, 0, 700, 1000000, NULL, 'Wired headphones by Razer with USB connection.', '2023-09-15', CURDATE(), 4, 1, 19), 
(103, 'HyperX Wireless Headphones', 1, 0, 900, 1300000, NULL, 'Wireless headphones by HyperX with USB connection.', '2023-08-05', CURDATE(), 4, 4, 21), 
(104, 'Logitech Wired Speaker', 1, 0, 600, 1000000, NULL, 'Wired speaker by Logitech with 3.5mm connection.', '2023-12-20', CURDATE(), 4, 2, 16), 
(105, 'Asus Wired Headphones', 1, 0, 550, 700000, NULL, 'Wired headphones by Asus with USB connection.', '2023-07-10', CURDATE(), 4, 5, 18),
(106, 'Gaming USB Compact Keyboard RGB', 1, 0, 800, 1200000, 'https://product.hstatic.net/200000837185/product/t-grey-001-removebg-preview_23a18b5201254f4c90b5b495d807bef7_1024x1024_5afd1f6e173c4ac49290baf8438dacb8_grande.png', 'Great for gaming enthusiasts. Features RGB LED backlighting and a compact design.', '2023-08-15', CURDATE(), 2, 3, 10), 
(107, 'Office Wireless Full-size Keyboard Single-color', 1, 0, 400, 800000, 'https://product.hstatic.net/200000837185/product/cd87hr_compressed_a4881570994642929959a7c92e686c6d_grande.jpg', 'Suitable for office tasks. Comes with single-color LED backlighting and wireless connectivity.', '2023-07-20', CURDATE(), 2, 1, 15), 
(108, 'Mechanical USB Full-size Keyboard RGB', 1, 0, 900, 1500000, 'https://product.hstatic.net/200000837185/product/black_d72bee8bdf254f3f9afd38cc50bdaf62_grande.jpg', 'Ideal for mechanical keyboard enthusiasts. Features RGB LED backlighting and a full-size layout.', '2023-10-05', CURDATE(), 2, 4, 8), 
(109, 'Mechanical_2 USB Tenkeyless Keyboard RGB', 1, 0, 600, 1400000, 'https://product.hstatic.net/200000837185/product/black_d72bee8bdf254f3f9afd38cc50bdaf62_grande.jpg', 'Compact mechanical keyboard with RGB LED backlighting. Tenkeyless design for space-saving.', '2023-09-12', CURDATE(), 2, 2, 12), 
(110, 'Gaming Wireless Compact Keyboard RGB', 1, 0, 1000, 2000000, 'https://product.hstatic.net/200000837185/product/t-grey-001-removebg-preview_23a18b5201254f4c90b5b495d807bef7_1024x1024_5afd1f6e173c4ac49290baf8438dacb8_grande.png', 'Compact wireless keyboard for gaming. Features RGB LED backlighting for an immersive gaming experience.', '2023-06-25', CURDATE(), 4, 5, 20), 
(111, 'Office USB Tenkeyless Keyboard Single-color', 1, 0, 700, 1000000, 'https://product.hstatic.net/200000837185/product/cd87hr_compressed_a4881570994642929959a7c92e686c6d_grande.jpg', 'Tenkeyless office keyboard with single-color LED backlighting. Ideal for office tasks.', '2023-11-18', CURDATE(), 2, 3, 9), 
(112, 'Mechanical Wireless Full-size Keyboard RGB', 1, 0, 1200, 1800000, 'https://product.hstatic.net/200000837185/product/white_f4f902b82b374e6c92fb3b359247991c_grande.jpg', 'Wireless mechanical keyboard with RGB LED backlighting. Full-size layout for comfortable typing.', '2023-12-01', CURDATE(), 2, 2, 14), 
(113, 'Gaming USB Full-size Keyboard RGB', 1, 0, 500, 1300000, 'https://product.hstatic.net/200000837185/product/t-grey-001-removebg-preview_23a18b5201254f4c90b5b495d807bef7_1024x1024_5afd1f6e173c4ac49290baf8438dacb8_grande.png', 'Full-size gaming keyboard with RGB LED backlighting. Perfect for gaming enthusiasts.', '2023-07-30', CURDATE(), 2, 1, 18), 
(114, 'Office Wireless Compact Keyboard Single-color', 1, 0, 1500, 900000, 'https://product.hstatic.net/200000837185/product/cd87hr_compressed_a4881570994642929959a7c92e686c6d_grande.jpg', 'Compact wireless office keyboard with single-color LED backlighting. Suitable for small workspaces.', '2023-10-25', CURDATE(), 2, 5, 6), 
(115, 'Mechanical_2 USB Full-size Keyboard RGB', 1, 0, 800, 1600000, 'https://product.hstatic.net/200000837185/product/white_f4f902b82b374e6c92fb3b359247991c_grande.jpg', 'Full-size mechanical keyboard with RGB LED backlighting. Designed for mechanical keyboard enthusiasts.', '2023-09-08', CURDATE(), 2, 4, 11),
(116, 'Mac Ultrabook', 1, 0, 800, 20000000, 'https://cdn.tgdd.vn/Products/Images/44/231244/grey-1-org.jpg', 'Ultrabook by Mac with Apple M1 Pro CPU, 16GB RAM, and 512GB SSD.', '2023-11-15', CURDATE(), 5, 3, 22), 
(117, 'Asus Gaming Laptop', 1, 0, 1000, 15000000, 'https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png', 'Gaming laptop by Asus with Intel Core i7-12700H CPU, 16GB DDR5 RAM, and NVIDIA GeForce RTX 3050 graphics card.', '2023-10-05', CURDATE(), 5, 1, 18), 
(118, 'Dell High-End Gaming Laptop', 1, 0, 1200, 25000000, 'https://cdn.tgdd.vn/Products/Images/44/314830/dell-vostro-3430-i5-71011900-glr-2.jpg', 'High-end gaming laptop by Dell with Intel Core i9-12900HK CPU, 32GB DDR5 RAM, and NVIDIA GeForce RTX 3070 graphics card.', '2023-09-20', CURDATE(), 5, 4, 20), 
(119, 'MSI High-End Gaming Laptop', 1, 0, 900, 23000000, 'https://product.hstatic.net/200000837185/product/laptopgamingmsidelta15a5efk-095vn_e4fd817ae7fa48b3a3e4b73e50d60d80_grande.png', 'High-end gaming laptop by MSI with AMD Ryzen 9 5900HX CPU, 32GB DDR4 RAM, and NVIDIA GeForce RTX 3080 graphics card.', '2023-08-10', CURDATE(), 5, 2, 25), 
(120, 'HP Office Laptop', 1, 0, 600, 10000000, 'https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg', 'Office laptop by HP with Intel Core i5-12400H CPU, 8GB DDR4 RAM, and integrated Intel Iris Xe Graphics.', '2023-12-01', CURDATE(), 5, 5, 15), 
(121, 'Lenovo Gaming Laptop', 1, 0, 800, 16000000, 'https://cdn.tgdd.vn/Products/Images/44/303562/lenovo-ideapad-1-15amn7-r5-82vg0061vn-glr-2.jpg', 'Gaming laptop by Lenovo with AMD Ryzen 7 5800H CPU, 16GB DDR4 RAM, and NVIDIA GeForce RTX 3060 graphics card.', '2023-07-25', CURDATE(), 5, 3, 22), 
(122, 'Apple High-Performance Laptop', 1, 0, 1100, 30000000, 'https://cdn.tgdd.vn/Products/Images/44/231244/grey-1-org.jpg', 'High-performance laptop by Apple with Apple M1 Max CPU, 32GB LPDDR5 RAM, and 2TB SSD.', '2023-06-15', CURDATE(), 5, 1, 20), 
(123, 'Asus Extreme Gaming Laptop', 1, 0, 1300, 35000000, 'https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png', 'Extreme gaming laptop by Asus with Intel Core i9-12900K CPU, 64GB DDR5 RAM, and NVIDIA GeForce RTX 3090 graphics card.', '2023-05-05', CURDATE(), 5, 4, 18), 
(124, 'Dell Extreme Gaming Laptop', 1, 0, 1400, 38000000, 'https://cdn.tgdd.vn/Products/Images/44/314830/dell-vostro-3430-i5-71011900-glr-2.jpg', 'Extreme gaming laptop by Dell with AMD Ryzen 9 6900HX CPU, 64GB DDR5 RAM, and AMD Radeon RX 6900M graphics card.', '2023-04-10', CURDATE(), 5, 2, 21), 
(125, 'Lenovo Content Creation Laptop', 1, 0, 950, 18000000, 'https://cdn.tgdd.vn/Products/Images/44/303562/lenovo-ideapad-1-15amn7-r5-82vg0061vn-glr-2.jpg', 'Content creation laptop by Lenovo with Intel Core i7-12750H CPU, 32GB DDR5 RAM, and NVIDIA GeForce RTX 3080 graphics card.', '2023-03-20', CURDATE(), 5, 5, 17),
(126, 'Logitech Wireless Standard Mouse', 1, 0, 650, 500000, NULL, 'Wireless mouse with standard design. Suitable for office use.', '2023-09-20', CURDATE(), 3, 2, 15), 
(127, 'Asus Wireless Ergonomic Mouse', 1, 0, 850, 700000, NULL, 'Ergonomic wireless mouse designed for comfort. Ideal for office tasks.', '2023-08-10', CURDATE(), 3, 4, 20), 
(128, 'Razer Wireless Ergonomic Gaming Mouse', 1, 0, 1000, 1200000, NULL, 'Ergonomic wireless gaming mouse by Razer. Designed for gaming enthusiasts.', '2023-10-05', CURDATE(), 3, 5, 18), 
(129, 'HyperX Wireless Ambidextrous Gaming Mouse', 1, 0, 900, 1100000, NULL, 'Ambidextrous wireless gaming mouse by HyperX. Suitable for both left-handed and right-handed users.', '2023-09-12', CURDATE(), 3, 1, 22), 
(130, 'Logitech Wireless Ergonomic Gaming Mouse', 1, 0, 1200, 1500000, NULL, 'Ergonomic wireless gaming mouse by Logitech. Designed for comfortable gaming sessions.', '2023-06-25', CURDATE(), 3, 3, 25), 
(131, 'Asus Wireless Standard Mouse', 1, 0, 700, 450000, NULL, 'Standard wireless mouse by Asus. Suitable for office use.', '2023-11-18', CURDATE(), 3, 2, 17), 
(132, 'Razer Wired Ergonomic Gaming Mouse', 1, 0, 600, 800000, NULL, 'Ergonomic wired gaming mouse by Razer. Designed for precision and accuracy in gaming.', '2023-12-01', CURDATE(), 3, 5, 16), 
(133, 'HyperX Wired Ambidextrous Gaming Mouse', 1, 0, 800, 900000, NULL, 'Ambidextrous wired gaming mouse by HyperX. Suitable for both left-handed and right-handed users.', '2023-07-30', CURDATE(), 3, 1, 21), 
(134, 'Logitech Wired Ergonomic Office Mouse', 1, 0, 500, 400000, NULL, 'Ergonomic wired office mouse by Logitech. Designed for comfort during long work hours.', '2023-10-25', CURDATE(), 3, 3, 14), 
(135, 'Asus Wired Standard Office Mouse', 1, 0, 700, 350000, NULL, 'Standard wired office mouse by Asus. Suitable for daily office tasks.', '2023-09-08', CURDATE(), 3, 4, 19),
(136, 'Asus 24 inch Gaming Monitor 1920x1080 IPS 144Hz', 1, 0, 1000, 5500000, 'https://product.hstatic.net/200000837185/product/h732__8__c8deb4ca682b45fd9819881b42a7963c_grande.png', 'Great for gaming enthusiasts. Comes with a 144Hz refresh rate for smooth gameplay.', '2023-08-15', CURDATE(), 1, 2, 10), 
(137, 'Giga 27 inch Office Monitor 2560x1440 VA 75Hz', 1, 0, 500, 3500000, 'https://product.hstatic.net/200000837185/product/g24f-1-copy_compressed_5051b10d64414a6aa5b9f935419f6dcb_grande.jpg', 'Ideal for office use. Offers a high-resolution display and a 75Hz refresh rate.', '2023-07-20', CURDATE(), 1, 4, 15), 
(138, 'MSI 32 inch Graphics Monitor 3840x2160 TN 60Hz', 1, 0, 800, 6000000, 'https://product.hstatic.net/200000837185/product/1024_aea08b1560ba4d10b69a54b118f259de_grande.png', 'Designed for graphic design professionals. Features a 4K resolution and a 60Hz refresh rate.', '2023-10-05', CURDATE(), 1, 3, 8), 
(139, 'Tuff 27 inch Gaming Monitor 2560x1440 IPS 165Hz', 1, 0, 1200, 4800000, 'https://product.hstatic.net/200000837185/product/tuf-gaming-vg249q3a-01-copy_compressed_5829614f86934ec98f552c8f5c3fd79f_grande.jpg', 'Perfect for hardcore gamers. Boasts a high refresh rate of 165Hz for responsive gaming.', '2023-09-12', CURDATE(), 1, 1, 12), 
(140, 'Asus 24 inch Office Monitor 1920x1200 IPS 60Hz', 1, 0, 600, 3500000, 'https://product.hstatic.net/200000837185/product/h732__8__c8deb4ca682b45fd9819881b42a7963c_grande.png', 'Suitable for office tasks. Offers a widescreen display with a 60Hz refresh rate.', '2023-06-25', CURDATE(), 1, 5, 20), 
(141, 'Giga 32 inch Graphics Monitor 3840x2160 IPS 144Hz', 1, 0, 700, 7000000, 'https://product.hstatic.net/200000837185/product/g24f-1-copy_compressed_5051b10d64414a6aa5b9f935419f6dcb_grande.jpg', 'Designed for graphic designers. Features a high-resolution display and a 144Hz refresh rate.', '2023-11-18', CURDATE(), 1, 2, 9), 
(142, 'MSI 27 inch Gaming Monitor 2560x1440 VA 144Hz', 1, 0, 900, 5500000, 'https://product.hstatic.net/200000837185/product/1024_aea08b1560ba4d10b69a54b118f259de_grande.png', 'Optimized for gaming. Offers a high refresh rate of 144Hz for smooth gameplay.', '2023-12-01', CURDATE(), 1, 3, 14), 
(143, 'Tuff 24 inch Office Monitor 1920x1080 IPS 75Hz', 1, 0, 400, 3000000, 'https://product.hstatic.net/200000837185/product/tuf-gaming-vg249q3a-01-copy_compressed_5829614f86934ec98f552c8f5c3fd79f_grande.jpg', 'Ideal for office use. Comes with a high-resolution display and a 75Hz refresh rate.', '2023-07-30', CURDATE(), 1, 4, 18), 
(144, 'Asus 27 inch Gaming Monitor 2560x1440 TN 240Hz', 1, 0, 1500, 8000000, 'https://product.hstatic.net/200000837185/product/h732__8__c8deb4ca682b45fd9819881b42a7963c_grande.png', 'Perfect for serious gamers. Offers a high refresh rate of 240Hz for ultra-smooth gameplay.', '2023-10-25', CURDATE(), 1, 5, 6), 
(145, 'Giga 32 inch Office Monitor 2560x1440 IPS 60Hz', 1, 0, 1000, 4000000, 'https://product.hstatic.net/200000837185/product/g24f-1-copy_compressed_5051b10d64414a6aa5b9f935419f6dcb_grande.jpg', 'Suitable for office tasks. Comes with a high-resolution display and a 60Hz refresh rate.', '2023-09-08', CURDATE(), 1, 1, 11),
(146, 'MSI B460 ATX Motherboard', 1, 0, 0, 2500000, NULL, 'ATX Motherboard from MSI with B460 chipset, LGA1200 socket, DDR4 RAM support, and 4 RAM slots.', '2023-11-01', CURDATE(), 8, 1, 30),
(147, 'Asus Z590 ATX Motherboard', 1, 0, 0, 3000000, NULL, 'ATX Motherboard from Asus with Z590 chipset, LGA1200 socket, DDR4 RAM support, and 4 RAM slots.', '2023-11-02', CURDATE(), 8, 2, 25),
(148, 'Gigabyte X570 ATX Motherboard', 1, 0, 0, 2800000, NULL, 'ATX Motherboard from Gigabyte with X570 chipset, AM4 socket, DDR4 RAM support, and 4 RAM slots.', '2023-11-03', CURDATE(), 8, 3, 20),
(149, 'MSI H470 Micro ATX Motherboard', 1, 0, 0, 2200000, NULL, 'Micro ATX Motherboard from MSI with H470 chipset, LGA1200 socket, DDR4 RAM support, and 4 RAM slots.', '2023-11-04', CURDATE(), 8, 4, 15),
(150, 'Asus B550 Micro ATX Motherboard', 1, 0, 0, 2600000, NULL, 'Micro ATX Motherboard from Asus with B550 chipset, AM4 socket, DDR4 RAM support, and 4 RAM slots.', '2023-11-05', CURDATE(), 8, 5, 18),
(151, 'Gigabyte B450 Mini-ITX Motherboard', 1, 0, 0, 2000000, NULL, 'Mini-ITX Motherboard from Gigabyte with B450 chipset, AM4 socket, DDR4 RAM support, and 2 RAM slots.', '2023-11-06', CURDATE(), 8, 1, 10),
(152, 'MSI B560 ATX Motherboard', 1, 0, 0, 2700000, NULL, 'ATX Motherboard from MSI with B560 chipset, LGA1200 socket, DDR4 RAM support, and 4 RAM slots.', '2023-11-07', CURDATE(), 8, 2, 22),
(153, 'Asus H510 Micro ATX Motherboard', 1, 0, 0, 2300000, NULL, 'Micro ATX Motherboard from Asus with H510 chipset, LGA1200 socket, DDR4 RAM support, and 4 RAM slots.', '2023-11-08', CURDATE(), 8, 3, 17),
(154, 'Gigabyte B550 ATX Motherboard', 1, 0, 0, 2700000, NULL, 'ATX Motherboard from Gigabyte with B550 chipset, AM4 socket, DDR4 RAM support, and 4 RAM slots.', '2023-11-09', CURDATE(), 8, 4, 23),
(155, 'MSI Z590 ATX Motherboard', 1, 0, 0, 3100000, NULL, 'ATX Motherboard from MSI with Z590 chipset, LGA1200 socket, DDR4 RAM support, and 4 RAM slots.', '2023-11-10', CURDATE(), 8, 5, 28),
(156, 'External SSD 1TB', 1, 0, 0, 800000, NULL, 'External SSD with 1TB capacity.', '2023-12-31', CURDATE(), 16, 1, 15),
(157, 'USB 3.0 Flash Drive 64GB', 1, 0, 0, 200000, NULL, 'USB 3.0 Flash Drive with 64GB capacity.', '2023-12-30', CURDATE(), 16, 2, 25),
(158, 'Wireless Charging Pad', 1, 0, 0, 500000, NULL, 'Wireless Charging Pad for smartphones.', '2023-12-29', CURDATE(), 16, 3, 20),
(159, 'Gaming Mouse Pad - Large', 1, 0, 0, 100000, NULL, 'Large gaming mouse pad for precise control.', '2023-12-28', CURDATE(), 16, 4, 30),
(160, 'Portable Laptop Stand', 1, 0, 0, 150000, NULL, 'Portable stand for laptops, tablets, and books.', '2023-12-27', CURDATE(), 16, 5, 15),
(161, 'Bluetooth Wireless Earbuds', 1, 0, 0, 300000, NULL, 'Wireless earbuds with Bluetooth connectivity.', '2023-12-26', CURDATE(), 16, 1, 25),
(162, 'Gaming Controller for PC', 1, 0, 0, 400000, NULL, 'Gaming controller compatible with PC.', '2023-12-25', CURDATE(), 16, 2, 20),
(163, 'RGB LED Light Strip - 5m', 1, 0, 0, 150000, NULL, '5-meter RGB LED light strip for decoration.', '2023-12-24', CURDATE(), 16, 3, 10),
(164, 'Webcam Cover Slider', 1, 0, 0, 50000, NULL, 'Slider for covering the webcam on laptops.', '2023-12-23', CURDATE(), 16, 4, 30),
(165, 'Anti-Static Wrist Strap', 1, 0, 0, 50000, NULL, 'Anti-static wrist strap for working on electronics.', '2023-12-22', CURDATE(), 16, 5, 20),
(166, 'Corsair 750W Power Supply', 1, 0, 0, 1500000, NULL, '750W Power Supply from Corsair with 80 Plus Gold certification, Fully Modular design, and ATX size.', '2023-11-01', CURDATE(), 12, 3, 50),
(167, 'NZXT 650W Power Supply', 1, 0, 0, 1200000, NULL, '650W Power Supply from NZXT with 80 Plus Platinum certification, Semi-Modular design, and ATX size.', '2023-11-02', CURDATE(), 12, 2, 30),
(168, 'NZXT 750W Power Supply', 1, 0, 0, 1300000, NULL, '750W Power Supply from NZXT with 80 Plus Gold certification, Fully Modular design, and ATX size.', '2023-11-03', CURDATE(), 12, 4, 40),
(169, 'NZXT 650W Power Supply', 1, 0, 0, 1100000, NULL, '650W Power Supply from NZXT with 80 Plus Bronze certification, Semi-Modular design, and ATX size.', '2023-11-04', CURDATE(), 12, 1, 20),
(170, 'Corsair 850W Power Supply', 1, 0, 0, 1600000, NULL, '850W Power Supply from Corsair with 80 Plus Platinum certification, Fully Modular design, and ATX size.', '2023-11-05', CURDATE(), 12, 5, 60),
(171, 'Corsair 1000W Power Supply', 1, 0, 0, 1800000, NULL, '1000W Power Supply from Corsair with 80 Plus Titanium certification, Fully Modular design, and ATX size.', '2023-11-06', CURDATE(), 12, 3, 45),
(172, 'Corsair 850W Power Supply', 1, 0, 0, 1600000, NULL, '850W Power Supply from Corsair with 80 Plus Gold certification, Fully Modular design, and ATX size.', '2023-11-07', CURDATE(), 12, 2, 35),
(173, 'NZXT 850W Power Supply', 1, 0, 0, 1700000, NULL, '850W Power Supply from NZXT with 80 Plus Gold certification, Fully Modular design, and ATX size.', '2023-11-08', CURDATE(), 12, 4, 55),
(174, 'Corsair DDR4 16GB RAM', 1, 0, 800, 1000000, NULL, 'Corsair DDR4 16GB RAM with 3200 MHz bus speed, XMP 2.0 standard.', '2023-11-01', CURDATE(), 9, 5, 25), 
(175, 'IDCooling DDR4 8GB RAM', 1, 0, 1000, 600000, NULL, 'IDCooling DDR4 8GB RAM with 2666 MHz bus speed, JEDEC standard.', '2023-10-15', CURDATE(), 9, 1, 20), 
(176, 'G.Skill DDR4 32GB RAM', 1, 0, 1200, 1500000, NULL, 'G.Skill DDR4 32GB RAM with 3600 MHz bus speed, XMP 2.0 standard.', '2023-09-20', CURDATE(), 9, 3, 18), 
(177, 'Kingston DDR4 16GB RAM', 1, 0, 1400, 800000, NULL, 'Kingston DDR4 16GB RAM with 3200 MHz bus speed, JEDEC standard.', '2023-08-10', CURDATE(), 9, 2, 22), 
(178, 'Corsair DDR4 64GB RAM', 1, 0, 1100, 2500000, NULL, 'Corsair DDR4 64GB RAM with 4000 MHz bus speed, XMP 3.0 standard.', '2023-07-05', CURDATE(), 9, 4, 19), 
(179, 'Crucial DDR4 8GB RAM', 1, 0, 1300, 500000, NULL, 'Crucial DDR4 8GB RAM with 2666 MHz bus speed, JEDEC standard.', '2023-06-20', CURDATE(), 9, 5, 15), 
(180, 'TeamGroup DDR4 16GB RAM', 1, 0, 1500, 900000, NULL, 'TeamGroup DDR4 16GB RAM with 3600 MHz bus speed, XMP 2.0 standard.', '2023-05-15', CURDATE(), 9, 1, 21), 
(181, 'ADATA DDR4 32GB RAM', 1, 0, 1000, 1300000, NULL, 'ADATA DDR4 32GB RAM with 3200 MHz bus speed, JEDEC standard.', '2023-04-10', CURDATE(), 9, 3, 17), 
(184, 'Corsair DDR5 16GB RAM', 1, 0, 900, 2000000, NULL, 'Corsair DDR5 16GB RAM with 4800 MHz bus speed, XMP 3.0 standard.', '2023-03-05', CURDATE(), 9, 2, 16), 
(185, 'Corsair DDR5 32GB RAM', 1, 0, 1100, 3000000, NULL, 'Corsair DDR5 32GB RAM with 5200 MHz bus speed, XMP 3.0 standard.', '2023-02-20', CURDATE(), 9, 4, 23),
(186, 'WDB SSD 500GB M.2 NVMe', 1, 0, 800, 1200000, NULL, 'Note: Reliable SSD for everyday use.', '2023-12-22', CURDATE(), 10, 2, 10),
(187, 'Samsung HDD 4TB 7200 RPM', 1, 0, 1000, 1500000, NULL, 'Note: Large-capacity HDD for storage.', '2023-12-23', CURDATE(), 10, 5, 10),
(188, 'Samsung SSD 500GB SATA', 1, 0, 900, 800000, NULL, 'Note: Fast SATA SSD for boot drive.', '2023-12-24', CURDATE(), 10, 3, 10),
(189, 'Kingston SSD 1TB SATA', 1, 0, 700, 1300000, NULL, 'Note: Affordable SSD for storage upgrades.', '2023-12-25', CURDATE(), 10, 2, 10),
(190, 'Samsung HDD 2TB SATA 500 RPM', 1, 0, 850, 900000, NULL, 'Note: Low-speed HDD for bulk storage.', '2023-12-26', CURDATE(), 10, 5, 10),
(191, 'Samsung SSD 2TB M.2 NVMe', 1, 0, 1300, 4000000, NULL, 'Note: High-performance SSD for enthusiasts.', '2023-12-27', CURDATE(), 10, 4, 10),
(192, 'Samsung SSD 1TB SATA', 1, 0, 1100, 1600000, NULL, 'Note: SATA SSD for general computing.', '2023-12-28', CURDATE(), 10, 2, 10),
(193, 'WDB SSD 1TB M.2 NVMe', 1, 0, 750, 2200000, NULL, 'Note: High-speed NVMe SSD for workstations.', '2023-12-29', CURDATE(), 10, 3, 10),
(194, 'SanDisk 64GB USB Flash Drive', 1, 0, 0, 150000, NULL, 'USB Flash Drive with 64GB capacity from SanDisk', '2023-12-31', CURDATE(), 15, 3, 50),
(195, 'Samsung 32GB USB Flash Drive', 1, 0, 0, 120000, NULL, 'USB Flash Drive with 32GB capacity from Samsung', '2023-12-30', CURDATE(), 15, 2, 30),
(196, 'Kingston 128GB USB Flash Drive', 1, 0, 0, 200000, NULL, 'USB Flash Drive with 128GB capacity from Kingston', '2023-12-29', CURDATE(), 15, 4, 40),
(197, 'Samsung 256GB USB Flash Drive', 1, 0, 0, 300000, NULL, 'USB Flash Drive with 256GB capacity from Samsung', '2023-12-28', CURDATE(), 15, 1, 20),
(198, 'SanDisk 64GB USB Flash Drive', 1, 0, 0, 150000, NULL, 'USB Flash Drive with 64GB capacity from SanDisk', '2023-12-27', CURDATE(), 15, 5, 60),
(199, 'Kingston 128GB USB Flash Drive', 1, 0, 0, 200000, NULL, 'USB Flash Drive with 128GB capacity from Kingston', '2023-12-26', CURDATE(), 15, 3, 45),
(200, 'SanDisk 32GB USB Flash Drive', 1, 0, 0, 100000, NULL, 'USB Flash Drive with 32GB capacity from SanDisk', '2023-12-25', CURDATE(), 15, 2, 35),
(201, 'Samsung 64GB USB Flash Drive', 1, 0, 0, 160000, NULL, 'USB Flash Drive with 64GB capacity from Samsung', '2023-12-24', CURDATE(), 15, 4, 55),
(202, 'Kingston 32GB USB Flash Drive', 1, 0, 0, 100000, NULL, 'USB Flash Drive with 32GB capacity from Kingston', '2023-12-23', CURDATE(), 15, 1, 25),
(203, 'Samsung 256GB USB Flash Drive', 1, 0, 0, 300000, NULL, 'USB Flash Drive with 256GB capacity from Samsung', '2023-12-22', CURDATE(), 15, 5, 65);
/*!40000 ALTER TABLE `tblproduct` ENABLE KEYS */;


--
-- Definition of table `tblsale`
--

DROP TABLE IF EXISTS `tblsale`;
CREATE TABLE `tblsale` (
  `sale_id` int(11) NOT NULL AUTO_INCREMENT,
  `sale_name` varchar(255) NOT NULL,
  `sale_product_id` int(11) NOT NULL,
  `sale_off_price` float NOT NULL,
  `sale_off_price_percent` float NOT NULL,
  `sale_start_date` date NOT NULL,
  `sale_end_date` date NOT NULL,
  PRIMARY KEY (`sale_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblsale`
--

/*!40000 ALTER TABLE `tblsale` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblsale` ENABLE KEYS */;


--
-- Definition of table `tblshop`
--

DROP TABLE IF EXISTS `tblshop`;
CREATE TABLE `tblshop` (
  `shop_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT 'Tên gian hàng',
  `shop_address` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Địa chỉ gian hàng',
  `shop_status` smallint(1) NOT NULL DEFAULT '1' COMMENT 'Trạng thái của gian hàng',
  `shop_user_id` int(11) DEFAULT '0' COMMENT 'Người quản lý gian hàng',
  `shop_website_link` varchar(45) DEFAULT NULL COMMENT 'Đường dẫn liên kết đến trang web làm việc',
  `shop_address_link` varchar(45) DEFAULT NULL COMMENT 'Đường dẫn địa chỉ',
  `shop_created_date` varchar(45) NOT NULL DEFAULT '1/1/2000' COMMENT 'Thời gian khởi tạo',
  `shop_modified_date` varchar(45) DEFAULT NULL COMMENT 'Thời gian chỉnh sửa',
  `shop_deleted` smallint(6) unsigned NOT NULL DEFAULT '0' COMMENT 'Trạng thái xóa',
  `shop_images` varchar(100) DEFAULT NULL COMMENT 'Hình ảnh gian hàng',
  `shop_notes` text COMMENT 'Mô tả',
  `shop_phone` varchar(15) DEFAULT NULL COMMENT 'Số điện thoại liên hệ',
  `shop_email` varchar(45) DEFAULT NULL COMMENT 'Email liên hệ',
  PRIMARY KEY (`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COMMENT='Bảng gian hàng';

--
-- Dumping data for table `tblshop`
--

/*!40000 ALTER TABLE `tblshop` DISABLE KEYS */;
INSERT INTO `tblshop` (`shop_id`,`shop_name`,`shop_address`,`shop_status`,`shop_user_id`,`shop_website_link`,`shop_address_link`,`shop_created_date`,`shop_modified_date`,`shop_deleted`,`shop_images`,`shop_notes`,`shop_phone`,`shop_email`) VALUES 
 (1,'Kho Vingroup','Tầng 7, Tòa nhà Vincom Center, 72 Lê Thánh Tôn, Phường Bến Nghé, Quận 1, Thành phố Hồ Chí Minh.',1,1,NULL,NULL,'30/4/2023','04/01/2024',1,'/home/images/shop/storage01.jpg','',NULL,NULL),
 (2,'Kho Viettel','285 Cách Mạng Tháng Tám, Phường 12, Quận 10, Thành phố Hồ Chí Minh.',1,2,NULL,NULL,'1/5/2023','04/01/2024',0,'/home/images/shop/storage02.jpg','',NULL,NULL),
 (3,'Kho FPT','Số 17 Duy Tân, Dịch Vọng Hậu, Cầu Giấy, Hà Nội.',1,3,NULL,NULL,'28/6/2023','23/12/2023',1,'/home/images/shop/storage01.jpg','',NULL,NULL),
 (4,'Kho Sun Group','14, Hạ Long , Bãi Cháy, Thành phố Hạ Long, Quảng Ninh.',1,4,NULL,NULL,'14/2/2023','23/12/2023',0,'/home/images/shop/storage03.jpg','',NULL,NULL),
 (5,'Kho PV Gas','36 Hoàng Cầu, Đống Đa, Hà Nội.',1,5,NULL,NULL,'3/4/2023','23/12/2023',0,'/home/images/shop/storage02.jpg','',NULL,NULL);
/*!40000 ALTER TABLE `tblshop` ENABLE KEYS */;


--
-- Definition of table `tbluser`
--

DROP TABLE IF EXISTS `tbluser`;
CREATE TABLE `tbluser` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_nickname` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Biệt danh',
  `user_fullname` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Tên đầy đủ',
  `user_images` varchar(200) DEFAULT NULL COMMENT 'Hình ảnh',
  `user_email` varchar(100) DEFAULT NULL COMMENT 'Email',
  `user_notes` text COMMENT 'Mô tả',
  `user_permission` smallint(6) NOT NULL DEFAULT '0' COMMENT 'Quyền trong hệ thống',
  `user_gender` smallint(1) NOT NULL DEFAULT '0' COMMENT 'Giới tính',
  `user_address` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Địa chỉ',
  `user_deleted` smallint(6) DEFAULT '0' COMMENT 'Trạng thái xóa ',
  `user_phone` varchar(15) DEFAULT NULL COMMENT 'Số điện thoại',
  `user_social_links` varchar(100) DEFAULT NULL COMMENT 'Liên hệ',
  `user_logined` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'Số lần đăng nhập',
  `user_name` varchar(45) NOT NULL COMMENT 'Tài khoản',
  `user_pass` varchar(45) NOT NULL COMMENT 'Mật khẩu',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1 COMMENT='Bảng người dùng';

--
-- Dumping data for table `tbluser`
--

/*!40000 ALTER TABLE `tbluser` DISABLE KEYS */;
INSERT INTO `tbluser` (`user_id`, `user_nickname`, `user_fullname`, `user_images`, `user_email`, `user_notes`, `user_permission`, `user_gender`, `user_address`, `user_deleted`, `user_phone`, `user_social_links`, `user_logined`, `user_name`, `user_pass`) VALUES
(1, 'Dog lover', 'John Wick', '\\home\\images\\user\\01.jpg', 'doglover@gmail.com', 'Ng??i tiêu dùng', 1, 0, '7 Lê Duẩn, Quận 1, Thành phố Hồ Chí Minh.', 0, '0342312435', NULL, 0, 'DogLoverr', 'NoDogNoLife3000'),
(2, 'Pé', 'Nguyễn Thị Ngọc Mai', '\\home\\images\\user\\02.jpg', 'mai06071969@gmail.com', 'Không có thông tin', 1, 0, '46 Hòa Mã, Quận Ba Đình, Hà Nội.', 0, '0123423131', NULL, 0, 'Pé', 'Pe060769'),
(3, 'SKT Khánh', 'Mai Quốc Khánh', '\\home\\images\\user\\03.jpg', 'faker123@gmail.com', 'Không có thông tin', 1, 1, '191 Lãng Yên, Quận Hà Đông, Hà Nội.', 0, '0257123423', NULL, 3, 'SktKhanh', '738a1eca9e15f674ff6fd7434ea1b965'),
(4, 'Cloudy Vân', 'Tô Văn Vân', '\\home\\images\\user\\04.jpg', 'imhigh@gmail.com', 'Không có thông tin', 1, 1, '57 Trần Hưng Đạo, Hoàn Kiếm, Hà Nội.', 0, '0385175892', NULL, 0, 'Cloudy999', 'VanCloud'),
(5, 'Tuấn White', 'Trần Tuấn Bạch', '\\home\\images\\user\\05.jpg', 'maninblack@gmail.com', 'Không có thông tin', 1, 1, '27 Liễu Giai, Quận Ba Đình, Hà Nội.', 0, '0385174512', NULL, 0, 'TuanWhite', 'TrangNhuOMO'),
(6, 'Donald Trump', 'Đỗ Nam Trung', '\\home\\images\\user\06.jpg', 'greatagain999@gmail.com', 'Qu?n lý t?i chi nhánh Lâm ??ng', 4, 1, '51 Nguyễn Du, Quận Hai Bà Trưng, Hà Nội.', 0, '08967912345', NULL, 575, 'admin@gmail.com', '75d23af433e0cea4c0e45a56dba18b30'),
(7, 'Janua', 'Trường', '\\home\\images\\user\\07.jpg', 'janua@gmail.com', 'Không có thông tin', 1, 0, '47 Đào Duy Từ, quận Hoàn Kiếm', 0, '0912334253', NULL, 1, 'January3', 'Xy#7pLz!'),
(8, 'Februa', 'Kỳ', '\\home\\images\\user\\08.jpg', 'februa@gmail.com', 'Không có thông tin', 2, 1, '24 Hàng Bồ, quận Hoàn Kiếm', 0, '0875643865', NULL, 1, 'February1', 'qRt2$yZa'),
(9, 'March', 'Kháng', '\\home\\images\\user\\09.jpg', 'march@gmail.com', 'Không có thông tin', 3, 0, '49 Bát Đàn, quận Hoàn Kiếm ', 0, '0864479754', NULL, 1, 'March7th', '9b#6sPxY'),
(10, 'April', 'Chiến', '\\home\\images\\user\\10.jpg', 'april@gmail.com', 'Không có thông tin', 4, 1, '235B Thụy Khuê, quận Tây Hồ', 0, '0654312675', NULL, 1, 'UrLieInApril', 'dF!4a2tZ'),
(11, 'May', 'Nhất', '\\home\\images\\user\\11.jpg', 'may@gmail.com', 'Không có thông tin', 5, 0, '36 Tạm Thương, quận Hoàn Kiếm', 0, '0321498765', NULL, 1, 'AuntMay<3', '8m%1pQxW'),
(12, 'June', 'Định', '\\home\\images\\user\\12.jpg', 'june@gmail.com', 'Không có thông tin', 1, 1, '61 Đinh Tiên Hoàng, quận Hoàn Kiếm', 0, '0124465899', NULL, 1, 'JuneJune', 'J!0zYx#7'),
(13, 'July', 'Thắng', '\\home\\images\\user\\13.jpg', 'july@gmail.com', 'Không có thông tin', 2, 0, '10 Lý Quốc Sư, quận Hoàn Kiếm', 0, '0535567843', NULL, 1, 'Julyette', 'cA2!vL8x'),
(14, 'August', 'Lợi', '\\home\\images\\user\\14.jpg', 'august@gmail.com', 'Không có thông tin', 3, 1, '43 Nguyễn Siêu, quận Hoàn Kiếm', 0, '0298846558', NULL, 1, 'August2', 'K5!a7yRz'),
(15, 'Septem', 'Nguyễn Hoàng Đức', '\\home\\images\\user\\15.jpg', 'septem@gmail.com', 'Không có thông tin', 4, 0, '66 Tô Hiến Thành, quận Hoàn Kiếm', 0, '0321635289', NULL, 1, 'Septemvaotu', 'g3xYt#P!'),
(16, 'Octo', 'Nguyễn Đức Chiến', '\\home\\images\\user\\16.jpg', 'octo@gmail.com', 'Không có thông tin', 5, 1, '29A Nguyễn Thiếp, quận Hoàn Kiếm', 0, '0859986589', NULL, 1, 'Octopuss', 'dZ9!o5xQ'),
(17, 'Novem', 'Trương Tiến Anh', '\\home\\images\\user\\17.jpg', 'novem@gmail.com', 'Không có thông tin', 1, 1, 'Ngã 3 Cao Thắng, quận Hoàn Kiếm', 0, '0614585455', NULL, 1, 'NNNovember', 'b7!2rWtX'),
(18, 'Decem', 'Khuất Văn Khang', '\\home\\images\\user\\18.jpg', 'decem@gmail.com', 'Không có thông tin', 2, 0, '47 Mã Mây, quận Hoàn Kiếm', 0, '0898745654', NULL, 1, 'DDDecember', 'Hx!Y3zL9'),
(19, 'AlphaMail', 'Nguyễn Quang Hải', '\\home\\images\\user\\19.jpg', 'alphamail@gmail.com', 'Ng??i tiêu dùng', 3, 0, '1 Hàng Mành, quận Hoàn Kiếm', 0, '0356865325', NULL, 1, '1stAlphaMail', '6o!z1WpL'),
(20, 'GigaChat', 'Phạm Văn Luân', '\\home\\images\\user\\20.jpg', 'gigachat@gmail.com', 'Ng??i tiêu dùng', 4, 1, '48 Cầu Gỗ, quận Hoàn Kiếm', 0, '0468532568', NULL, 1, 'GigachartGaren', 'T#8x5y!A');
/*!40000 ALTER TABLE `tbluser` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
