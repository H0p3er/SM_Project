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
(56, 'Corsair', 'Liquid Cooler', 'Black', '120mm'),
(57, 'IDCooling', 'Air Cooler', 'White', '140mm'),
(58, 'Corsair', 'AIO Cooler', 'Red', '240mm'),
(59, 'IDCooling', 'RGB Cooler', 'Blue', '120mm'),
(60, 'Corsair', 'Low Profile Cooler', 'Gray', '80mm'),
(61, 'IDCooling', 'Tower Cooler', 'Black', '120mm'),
(62, 'Corsair', 'Liquid Cooler', 'White', '240mm'),
(63, 'IDCooling', 'AIO Cooler', 'Green', '140mm'),
(64, 'Corsair', 'Air Cooler', 'Blue', '120mm'),
(65, 'IDCooling', 'RGB Cooler', 'Red', '240mm');
/*!40000 ALTER TABLE `tbl_cooling` ENABLE KEYS */;


--
-- Definition of table `tbl_cpus`
--

DROP TABLE IF EXISTS `tbl_cpus`;
CREATE TABLE `tbl_cpus` (
  `cpu_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `cpu_collection` varchar(100) DEFAULT NULL COMMENT 'core i5/ryzen 5',
  `cpu_socket` int(11) unsigned DEFAULT NULL COMMENT 'Socket',
  `cpu_cores` int(11) unsigned DEFAULT NULL COMMENT 'Core',
  `cpu_theats` int(11) unsigned DEFAULT NULL COMMENT 'Theats',
  `cpu_speed_ghz` int(11) unsigned DEFAULT NULL COMMENT 'Speed',
  PRIMARY KEY (`cpu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='CPUs Table';

--
-- Dumping data for table `tbl_cpus`
--

/*!40000 ALTER TABLE `tbl_cpus` DISABLE KEYS */;
INSERT INTO `tbl_cpus` (`product_id`, `cpu_collection`, `cpu_socket`, `cpu_cores`, `cpu_theats`, `cpu_speed_ghz`)
VALUES
(66, 'Intel Core i5', 'LGA1200', '6', '12', '3.6 GHz'),
(67, 'AMD Ryzen 5', 'AM4', '6', '12', '3.8 GHz'),
(68, 'Intel Core i5', 'LGA1151', '6', '12', '3.4 GHz'),
(69, 'AMD Ryzen 5', 'AM4', '6', '12', '3.6 GHz'),
(70, 'Intel Core i5', 'LGA1200', '6', '12', '3.2 GHz'),
(71, 'AMD Ryzen 5', 'AM4', '6', '12', '3.5 GHz'),
(72, 'Intel Core i5', 'LGA1151', '6', '12', '3.0 GHz'),
(73, 'AMD Ryzen 5', 'AM4', '6', '12', '3.3 GHz'),
(74, 'Intel Core i5', 'LGA1200', '6', '12', '2.8 GHz'),
(75, 'AMD Ryzen 5', 'AM4', '6', '12', '3.1 GHz');
/*!40000 ALTER TABLE `tbl_cpus` ENABLE KEYS */;


--
-- Definition of table `tbl_desktops`
--

DROP TABLE IF EXISTS `tbl_desktops`;
CREATE TABLE `tbl_desktops` (
  `desktop_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11)  NOT NULL,
  `desktop_manufacturer` varchar(20) DEFAULT NULL,
  `desktop_type` smallint(1) unsigned DEFAULT '0' COMMENT '0-Old; 1-New',
  `desktop_cpu` varchar(20) NOT NULL COMMENT 'CPU',
  `desktop_gpu` varchar(20) DEFAULT NULL COMMENT 'GPU',
  `desktop_ram_capacity` int(11) unsigned DEFAULT NULL COMMENT 'RAM Capacity',
  `desktop_ram_type` varchar(20) DEFAULT NULL COMMENT 'RAM Type',
  `desktop_storage` int(11) unsigned NOT NULL COMMENT 'Storage',
  `desktop_power_supply` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`desktop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Desktops Table';

--
-- Dumping data for table `tbl_desktops`
--

/*!40000 ALTER TABLE `tbl_desktops` DISABLE KEYS */;
INSERT INTO `tbl_desktops` (`product_id`, `desktop_manufacturer`, `desktop_type`, `desktop_cpu`, `desktop_gpu`, `desktop_ram_capacity`, `desktop_ram_type`, `desktop_storage`, `desktop_power_supply`)
VALUES
(76, 'MSI', 'Gaming Desktop', 'Intel Core i5', 'NVIDIA GeForce RTX 3060', '16GB', 'DDR4', '512GB SSD + 1TB HDD', '650W'),
(77, 'Asus', 'Office Desktop', 'Intel Core i5', 'Integrated Intel UHD Graphics 630', '8GB', 'DDR4', '256GB SSD', '300W'),
(78, 'Gigabyte', 'Gaming Desktop', 'AMD Ryzen 5', 'AMD Radeon RX 6700 XT', '32GB', 'DDR4', '1TB NVMe SSD', '750W'),
(79, 'MSI', 'Gaming Desktop', 'Intel Core i5', 'NVIDIA GeForce GTX 1660 Ti', '16GB', 'DDR4', '512GB SSD', '550W'),
(80, 'Asus', 'Office Desktop', 'Intel Core i5', 'Integrated Intel UHD Graphics 630', '8GB', 'DDR4', '512GB SSD', '300W'),
(81, 'Gigabyte', 'Gaming Desktop', 'AMD Ryzen 5', 'AMD Radeon RX 6800', '32GB', 'DDR4', '2TB SSD', '800W'),
(82, 'MSI', 'Gaming Desktop', 'Intel Core i5', 'NVIDIA GeForce RTX 3070', '16GB', 'DDR4', '1TB SSD + 1TB HDD', '700W'),
(83, 'Asus', 'Office Desktop', 'Intel Core i5', 'Integrated Intel UHD Graphics 630', '8GB', 'DDR4', '256GB SSD', '300W'),
(84, 'Gigabyte', 'Gaming Desktop', 'AMD Ryzen 5', 'AMD Radeon RX 6600 XT', '32GB', 'DDR4', '512GB SSD', '650W'),
(85, 'MSI', 'Gaming Desktop', 'Intel Core i5', 'NVIDIA GeForce GTX 1650', '16GB', 'DDR4', '1TB SSD', '550W');
/*!40000 ALTER TABLE `tbl_desktops` ENABLE KEYS */;


--
-- Definition of table `tbl_graphics_cards`
--

DROP TABLE IF EXISTS `tbl_graphics_cards`;
CREATE TABLE `tbl_graphics_cards` (
  `graphics_card_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) unsigned NOT NULL,
  `graphics_card_manufacturer` varchar(100) DEFAULT NULL COMMENT 'Manufacturer',
  `graphics_card_speed` int(11) unsigned DEFAULT NULL,
  `graphics_card_cores` int(11) unsigned DEFAULT NULL,
  `graphics_card_version` varchar(50) DEFAULT NULL COMMENT 'Version',
  `graphics_card_vram_capacity` int(11) unsigned DEFAULT NULL COMMENT 'VRAM Capacity',
  `graphics_card_require_psu` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`graphics_card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Graphics Cards Table';

--
-- Dumping data for table `tbl_graphics_cards`
--

/*!40000 ALTER TABLE `tbl_graphics_cards` DISABLE KEYS */;
INSERT INTO `tbl_graphics_cards` (`product_id`, `graphics_card_manufacturer`, `graphics_card_speed`, `graphics_card_cores`, `graphics_card_version`, `graphics_card_vram_capacity`, `graphics_card_require_psu`)
VALUES
(86, 'NVIDIA', '1800 MHz', '3584', 'RTX 3060', '12GB', '550W'),
(87, 'AMD', '2105 MHz', '2560', 'RX 6700 XT', '12GB', '750W'),
(88, 'NVIDIA', '1770 MHz', '2944', 'GTX 1660 Ti', '6GB', '500W'),
(89, 'AMD', '2015 MHz', '3840', 'RX 6800', '16GB', '800W'),
(90, 'NVIDIA', '1500 MHz', '5888', 'RTX 3070', '8GB', '650W'),
(91, 'AMD', '2333 MHz', '2048', 'RX 6600 XT', '8GB', '650W'),
(92, 'NVIDIA', '1590 MHz', '1280', 'GTX 1650', '4GB', '450W'),
(93, 'AMD', '2424 MHz', '5120', 'RX 6600', '8GB', '650W'),
(94, 'NVIDIA', '1410 MHz', '896', 'GT 1030', '2GB', '300W'),
(95, 'AMD', '1905 MHz', '2048', 'RX 6500 XT', '4GB', '450W');
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
INSERT INTO `tbl_headphones_speakers` (`product_id`, `headphones_manufacturer`, `headphone_type`, `headphones_connection`, `headphones_connection_ports`)
VALUES
(96, 'Corsair', 'Over-ear Headphones', 'Wired', '3.5mm Jack'),
(97, 'IDCooling', 'In-ear Earphones', 'Wireless', 'Bluetooth'),
(98, 'Corsair', 'Gaming Headset', 'Wired', 'USB'),
(99, 'IDCooling', 'Over-ear Headphones', 'Wireless', 'Bluetooth'),
(100, 'Corsair', 'Wireless Earbuds', 'Wireless', 'Bluetooth'),
(101, 'IDCooling', 'Gaming Headset', 'Wired', 'USB'),
(102, 'Corsair', 'On-ear Headphones', 'Wired', '3.5mm Jack'),
(103, 'IDCooling', 'In-ear Monitors', 'Wireless', 'Bluetooth'),
(104, 'Corsair', 'Gaming Headphones', 'Wired', 'USB'),
(105, 'IDCooling', 'Over-ear Headphones', 'Wireless', 'Bluetooth');
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
INSERT INTO `tbl_keyboards` (`product_id`, `keyboard_type`, `keyboard_connection_type`, `keyboard_size_layout`, `keyboard_led_backlighting`)
VALUES
(106, 'Gaming', 'Wired', 'Full-size', 1),
(107, 'Mechanical', 'Wired', 'Tenkeyless', 1),
(108, 'Office', 'Wireless', 'Full-size', 0),
(109, 'Gaming', 'Wired', 'Full-size', 1),
(110, 'Mechanical', 'Wireless', 'Tenkeyless', 1),
(111, 'Office', 'Wired', 'Full-size', 0),
(112, 'Gaming', 'Wireless', 'Full-size', 1),
(113, 'Mechanical', 'Wired', 'Tenkeyless', 1),
(114, 'Office', 'Wireless', 'Full-size', 0),
(115, 'Gaming', 'Wired', 'Full-size', 1);
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
INSERT INTO `tbl_laptops` (`product_id`, `laptop_manufacturer`, `laptop_cpu`, `laptop_ram`, `laptop_graphics_card`, `laptop_storage`, `laptop_screen_size`, `laptop_refresh_rate`, `laptop_resolution`, `laptop_type`)
VALUES
(6, 'Apple', 'M1', '8GB', 'Integrated', NULL, '13 inches', NULL, NULL, 'MacBook Air'),
(7, 'HP', 'i3 1215U', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'HP 15s'),
(8, 'Asus', 'i5 11400H', NULL, NULL, NULL, NULL, NULL, NULL, 'Asus TUF Gaming F15'),
(9, 'Acer', 'i5 13420H', NULL, NULL, NULL, NULL, NULL, NULL, 'Acer Aspire 5 Gaming'),
(10, 'Asus', 'R5 7520U', NULL, NULL, NULL, NULL, NULL, NULL, 'Asus Vivobook Go 15'),
(12, 'HP', 'i3 1215U', NULL, NULL, NULL, '14 inches', NULL, NULL, 'HP 240 G9'),
(13, 'Asus', 'i5 1335U', NULL, NULL, NULL, '16 inches', NULL, NULL, 'Asus Vivobook 16'),
(14, 'HP', 'i5 1235U', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'HP 15s'),
(15, 'Asus', 'i3 1215U', NULL, NULL, NULL, '15 inches', NULL, NULL, 'Asus Vivobook 15'),
(16, 'Asus', 'i3 1115G4', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'Asus Vivobook X515EA'),
(17, 'HP', 'i5 1235U', NULL, NULL, NULL, '14 inches', NULL, NULL, 'HP Pavilion 14'),
(18, 'Asus', 'i5 1135G7', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'Asus Vivobook X515EA'),
(19, 'Dell', 'i3 1215U', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'Dell Vostro 15'),
(20, 'HP', 'i3 N305', NULL, NULL, NULL, '14 inches', NULL, NULL, 'HP 14'),
(21, 'Lenovo', 'i3 1115G4', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'Lenovo Ideapad 3'),
(22, 'Dell', 'i3 1215U', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'Dell Inspiron 15'),
(23, 'HP', 'i3 1115G4', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'HP 15s'),
(24, 'Asus', 'i3 1115G4', NULL, NULL, NULL, '14 inches', NULL, NULL, 'Asus Vivobook X415EA'),
(26, 'Dell', 'i5 1235U', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'Dell Inspiron 15'),
(27, 'Asus', 'i5 1335U', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'Asus Vivobook 15'),
(29, 'Lenovo', 'i3 1215U', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'Lenovo Ideapad 3'),
(30, 'HP', 'i5 1240P', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'HP Pavilion 15'),
(31, 'Lenovo', 'i5 1155G7', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'Lenovo Ideapad 3'),
(32, 'HP', 'i3 1115G4', NULL, NULL, NULL, '14 inches', NULL, NULL, 'HP 240 G8'),
(33, 'Asus', 'i7 11800H', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'Asus TUF Gaming F15'),
(34, 'HP', 'i7 1255U', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'HP 15s'),
(35, 'Acer', 'i3 1215U', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'Acer Aspire 3'),
(36, 'MSI', 'i5 11400H', NULL, NULL, NULL, NULL, NULL, NULL, 'MSI Gaming GF63 Thin'),
(38, 'MSI', 'i7 11800H', NULL, NULL, NULL, NULL, NULL, NULL, 'MSI Gaming GF63 Thin'),
(39, 'Asus', 'i5 13500H', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'Asus Vivobook 15 OLED'),
(40, 'Lenovo', 'i5 12450H', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'Lenovo Ideapad Slim 3'),
(41, 'Apple', 'M2', NULL, NULL, NULL, '13 inches', NULL, NULL, 'MacBook Air'),
(42, 'Acer', 'i5 11400H', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'Acer Nitro 5 Gaming'),
(43, 'HP', 'i5 1240P', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'HP Pavilion 15'),
(44, 'Dell', 'i3 1215U', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'Dell Vostro 3520'),
(45, 'Lenovo', 'i3 1115G4', NULL, NULL, NULL, '15.6 inches', NULL, NULL, 'Lenovo Ideapad 3'),
(116, 'MSI', 'Intel Core i5-1135G7', '16GB DDR4', 'NVIDIA GeForce GTX 1650', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Gaming Laptop'),
(117, 'Asus', 'Intel Core i5-1135G7', '8GB DDR4', 'Integrated Intel Iris Xe Graphics', '256GB SSD', '14 inches', '60Hz', '1920x1080', 'Office Laptop'),
(118, 'Gigabyte', 'AMD Ryzen 5 5600H', '32GB DDR4', 'AMD Radeon RX 6700M', '1TB NVMe SSD', '15.6 inches', '144Hz', '1920x1080', 'Gaming Laptop'),
(119, 'MSI', 'Intel Core i5-1135G7', '16GB DDR4', 'NVIDIA GeForce MX450', '512GB SSD', '15.6 inches', '60Hz', '1920x1080', 'Gaming Laptop'),
(120, 'Asus', 'Intel Core i5-1135G7', '8GB DDR4', 'Integrated Intel Iris Xe Graphics', '512GB SSD', '14 inches', '60Hz', '1920x1080', 'Office Laptop'),
(121, 'Gigabyte', 'AMD Ryzen 5 5600H', '32GB DDR4', 'AMD Radeon RX 6800M', '2TB NVMe SSD', '15.6 inches', '165Hz', '2560x1440', 'Gaming Laptop'),
(122, 'MSI', 'Intel Core i5-1135G7', '16GB DDR4', 'NVIDIA GeForce RTX 3050 Ti', '1TB SSD', '15.6 inches', '144Hz', '1920x1080', 'Gaming Laptop'),
(123, 'Asus', 'Intel Core i5-1135G7', '8GB DDR4', 'Integrated Intel Iris Xe Graphics', '256GB SSD', '14 inches', '60Hz', '1920x1080', 'Office Laptop'),
(124, 'Gigabyte', 'AMD Ryzen 5 5600H', '32GB DDR4', 'AMD Radeon RX 6600M', '512GB NVMe SSD', '15.6 inches', '144Hz', '1920x1080', 'Gaming Laptop'),
(125, 'MSI', 'Intel Core i5-1135G7', '16GB DDR4', 'NVIDIA GeForce MX450', '1TB SSD', '15.6 inches', '60Hz', '1920x1080', 'Gaming Laptop');
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
INSERT INTO `tbl_mice` (`product_id`, `mouse_manufacturer`, `mouse_type`, `mouse_connection_type`, `mouse_design`, `mouse_battery`)
VALUES
(126, 'Corsair', 'Gaming Mouse', 'Wired', 'Ergonomic', 'Rechargeable'),
(127, 'IDCooling', 'Office Mouse', 'Wireless', 'Ambidextrous', 'Battery'),
(128, 'Corsair', 'Wireless Mouse', 'Wireless', 'Ergonomic', 'Rechargeable'),
(129, 'IDCooling', 'Gaming Mouse', 'Wired', 'Ambidextrous', 'Battery'),
(130, 'Corsair', 'Gaming Mouse', 'Wired', 'Ergonomic', 'Rechargeable'),
(131, 'IDCooling', 'Office Mouse', 'Wireless', 'Ambidextrous', 'Battery'),
(132, 'Corsair', 'Wireless Mouse', 'Wireless', 'Ergonomic', 'Rechargeable'),
(133, 'IDCooling', 'Gaming Mouse', 'Wired', 'Ambidextrous', 'Battery'),
(134, 'Corsair', 'Gaming Mouse', 'Wired', 'Ergonomic', 'Rechargeable'),
(135, 'IDCooling', 'Office Mouse', 'Wireless', 'Ambidextrous', 'Battery');
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
(136, 'MSI', '27 inches', 'Gaming', '2560x1440', 'IPS', '144Hz', '16:9', '1ms'),
(137, 'Asus', '24 inches', 'Office', '1920x1080', 'IPS', '60Hz', '16:9', '5ms'),
(138, 'Gigabyte', '32 inches', 'Gaming', '3840x2160', 'VA', '144Hz', '16:9', '1ms'),
(139, 'MSI', '27 inches', 'Gaming', '2560x1440', 'IPS', '165Hz', '16:9', '1ms'),
(140, 'Asus', '24 inches', 'Office', '1920x1080', 'IPS', '75Hz', '16:9', '5ms'),
(141, 'Gigabyte', '32 inches', 'Gaming', '3840x2160', 'VA', '144Hz', '16:9', '1ms'),
(142, 'MSI', '27 inches', 'Gaming', '2560x1440', 'IPS', '144Hz', '16:9', '1ms'),
(143, 'Asus', '24 inches', 'Office', '1920x1080', 'IPS', '60Hz', '16:9', '5ms'),
(144, 'Gigabyte', '32 inches', 'Gaming', '3840x2160', 'VA', '144Hz', '16:9', '1ms'),
(145, 'MSI', '27 inches', 'Gaming', '2560x1440', 'IPS', '165Hz', '16:9', '1ms');
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
(167, 'Corsair', '80 Plus Bronze', 'Semi-Modular', 'ATX', '650W'),
(168, 'Seasonic', '80 Plus Platinum', 'Fully Modular', 'ATX', '850W'),
(169, 'EVGA', '80 Plus Gold', 'Fully Modular', 'ATX', '850W'),
(170, 'Thermaltake', '80 Plus Bronze', 'Non-Modular', 'ATX', '500W'),
(171, 'NZXT', '80 Plus Gold', 'Fully Modular', 'ATX', '650W'),
(172, 'Cooler Master', '80 Plus Bronze', 'Semi-Modular', 'ATX', '550W'),
(173, 'Antec', '80 Plus Platinum', 'Fully Modular', 'ATX', '750W');
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
  `ram_capacity` int(4) unsigned DEFAULT NULL COMMENT 'RAM Capacity',
  `ram_bus_speed` int(11) unsigned DEFAULT NULL COMMENT 'RAM Bus Speed',
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
(176, 'Corsair', 'DDR4', '32GB', '3600 MHz', 'XMP 2.0'),
(177, 'IDCooling', 'DDR4', '16GB', '3000 MHz', 'JEDEC'),
(178, 'Corsair', 'DDR4', '8GB', '3200 MHz', 'XMP 2.0'),
(179, 'IDCooling', 'DDR4', '16GB', '2666 MHz', 'JEDEC'),
(180, 'Corsair', 'DDR4', '32GB', '3600 MHz', 'XMP 2.0'),
(181, 'IDCooling', 'DDR4', '8GB', '3000 MHz', 'JEDEC'),
(182, 'Corsair', 'DDR4', '16GB', '3200 MHz', 'XMP 2.0'),
(183, 'IDCooling', 'DDR4', '8GB', '2666 MHz', 'JEDEC');
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
  `storage_capacity` int(11) unsigned DEFAULT NULL COMMENT 'Capacity',
  `storage_m2_pcie_type` varchar(50) DEFAULT NULL COMMENT 'M.2 PCIe type',
  `storage_rpm` int(11) unsigned DEFAULT NULL COMMENT 'RPM',
  PRIMARY KEY (`storage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Storage Table';

--
-- Dumping data for table `tbl_storage`
--

/*!40000 ALTER TABLE `tbl_storage` DISABLE KEYS */;
INSERT INTO `tbl_storage` (`product_id`, `storage_manufacturer`, `storage_type`, `storage_capacity`, `storage_m2_pcie_type`, `storage_rpm`)
VALUES
(184, 'Samsung', 'SSD', '1TB', 'NVMe', NULL),
(185, 'WDBlack', 'HDD', '2TB', NULL, 7200),
(186, 'Samsung', 'SSD', '500GB', 'SATA', NULL),
(187, 'WDBlack', 'HDD', '4TB', NULL, 7200),
(188, 'Samsung', 'SSD', '2TB', 'NVMe', NULL),
(189, 'WDBlack', 'SSD', '1TB', 'SATA', NULL),
(190, 'Samsung', 'SSD', '500GB', 'NVMe', NULL),
(191, 'WDBlack', 'HDD', '1TB', NULL, 7200),
(192, 'Samsung', 'SSD', '1TB', 'SATA', NULL),
(193, 'WDBlack', 'SSD', '2TB', 'NVMe', NULL);
/*!40000 ALTER TABLE `tbl_storage` ENABLE KEYS */;


--
-- Definition of table `tbl_usbs`
--

DROP TABLE IF EXISTS `tbl_usbs`;
CREATE TABLE `tbl_usbs` (
  `usb_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) unsigned NOT NULL,
  `usb_manufacturer` varchar(100) DEFAULT NULL COMMENT 'Manufacturer',
  `usb_capacity` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`usb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='USBs Table';

--
-- Dumping data for table `tbl_usbs`
--

/*!40000 ALTER TABLE `tbl_usbs` DISABLE KEYS */;
INSERT INTO `tbl_usbs` (`product_id`, `usb_manufacturer`, `usb_capacity`)
VALUES
(194, 'Samsung', '128GB'),
(195, 'WDBlack', '256GB'),
(196, 'Samsung', '64GB'),
(197, 'WDBlack', '512GB'),
(198, 'Samsung', '256GB'),
(199, 'WDBlack', '128GB'),
(200, 'Samsung', '512GB'),
(201, 'WDBlack', '32GB'),
(202, 'Samsung', '256GB'),
(203, 'WDBlack', '64GB');
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
 (6,'MacBook Air 13 inch M1 2020 7-core GPU',1,0,NULL,10000,' https://cdn.tgdd.vn/Products/Images/44/231244/grey-1-org.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,2,1),
 (7,'HP 15s fq5229TU i3 1215U (8U237PA)',0,0,NULL,123,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,2,2),
 (8,'Asus TUF Gaming F15 FX506HF i5 11400H (HN014W)',1,0,NULL,123,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,2,3),
 (9,'Acer Aspire 5 Gaming A515 58GM 51LB i5 13420H (NX.KQ4SV.002)',0,0,NULL,1231312,' https://product.hstatic.net/200000837185/product/laptopgamingmsidelta15a5efk-095vn_e4fd817ae7fa48b3a3e4b73e50d60d80_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,9,4),
 (10,'Asus Vivobook Go 15 E1504FA R5 7520U (NJ776W)',1,0,NULL,1231231,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,10,5),
 (12,'HP 240 G9 i3 1215U (6L1X7PA)',1,0,NULL,1231232,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,11,12),
 (13,'Asus Vivobook 16 X1605VA i5 1335U (MB360W)',0,0,NULL,1231231,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,12,5),
 (14,'HP 15s fq5162TU i5 1235U (7C134PA)',1,0,NULL,4321,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,13,12),
 (15,'Asus Vivobook 15 X1504ZA i3 1215U (NJ102W)',0,0,NULL,324234,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,14,5),
 (16,'Asus Vivobook X515EA i3 1115G4 (EJ3948W)',1,0,NULL,2332,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,15,12),
 (17,'HP Pavilion 14 dv2074TU i5 1235U (7C0P3PA)',0,0,NULL,23423,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,16,5),
 (18,'Asus Vivobook X515EA i5 1135G7 (EJ4155W)',1,0,NULL,234234,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,17,1),
 (19,'Dell Vostro 15 3520 i3 1215U (5M2TT1)',0,0,NULL,234234,' https://cdn.tgdd.vn/Products/Images/44/314830/dell-vostro-3430-i5-71011900-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,18,2),
 (20,'HP 14 ep0126TU i3 N305 (8U233PA)',1,0,NULL,234234,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,19,35),
 (21,'Lenovo Ideapad 3 15ITL6 i3 1115G4 (82H803SGVN)',0,0,NULL,234234,' https://cdn.tgdd.vn/Products/Images/44/303562/lenovo-ideapad-1-15amn7-r5-82vg0061vn-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,20,23),
 (22,'Dell Inspiron 15 3520 i3 1215U (71003264)',1,0,NULL,23423,' https://cdn.tgdd.vn/Products/Images/44/314830/dell-vostro-3430-i5-71011900-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,21,4),
 (23,'HP 15s fq2716TU i3 1115G4 (7C0X3PA)',0,0,NULL,23423,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,6,3),
 (24,'Asus Vivobook X415EA i3 1115G4 (EK2034W)',1,0,NULL,231,' https://cdn.tgdd.vn/Products/Images/44/303562/lenovo-ideapad-1-15amn7-r5-82vg0061vn-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,12,1),
 (26,'Dell Inspiron 15 3520 i5 1235U (N5I5122W1)',1,0,NULL,23423,' https://cdn.tgdd.vn/Products/Images/44/314830/dell-vostro-3430-i5-71011900-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,8,3),
 (27,'Asus Vivobook 15 X1504VA i5 1335U (NJ025W)',0,0,NULL,23423,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,9,1),
 (29,'Lenovo Ideapad 3 15IAU7 i3 1215U (82RK005LVN)',0,0,NULL,123,' https://cdn.tgdd.vn/Products/Images/44/303562/lenovo-ideapad-1-15amn7-r5-82vg0061vn-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,10,2),
 (30,'HP Pavilion 15 eg2082TU i5 1240P (7C0Q5PA)',1,0,NULL,123,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,9,12),
 (31,'Lenovo Ideapad 3 15ITL6 i5 1155G7 (82H803RRVN)',0,0,NULL,123,' https://cdn.tgdd.vn/Products/Images/44/303562/lenovo-ideapad-1-15amn7-r5-82vg0061vn-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,10,1),
 (32,'HP 240 G8 i3 1115G4 (6L1A1PA)',1,0,NULL,123,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg','null',CURRENT_DATE(),' 30/10/2023',5,12,3),
 (33,'Asus TUF Gaming F15 FX506HE i7 11800H (HN378W)',0,0,NULL,123,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png','null',CURRENT_DATE(),' 30/10/2023',5,7,1),
 (34,'HP 15s fq5147TU i7 1255U (7C133PA)',1,0,NULL,NULL,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg','null',CURRENT_DATE(),' 30/10/2023',5,8,3),
 (35,'Acer Aspire 3 A315 59 314F i3 1215U (NX.K6TSV.002)',0,0,NULL,NULL,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,9,2),
 (36,'MSI Gaming GF63 Thin 11SC i5 11400H (664VN)',1,0,NULL,NULL,' https://product.hstatic.net/200000837185/product/laptopgamingmsidelta15a5efk-095vn_e4fd817ae7fa48b3a3e4b73e50d60d80_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,10,1),
 (38,'MSI Gaming GF63 Thin 11UC i7 11800H (1228VN)',1,0,NULL,NULL,' https://product.hstatic.net/200000837185/product/laptopgamingmsidelta15a5efk-095vn_e4fd817ae7fa48b3a3e4b73e50d60d80_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,10,1),
 (39,'Asus Vivobook 15 OLED A1505VA i5 13500H (L1341W)',0,1,NULL,NULL,' https://product.hstatic.net/200000837185/product/laptopasusvivobookpro15m6500qc-ma002w_9d63d2e1f8d649b596755a3a77ad08ae_grande.png',' null',CURRENT_DATE(),' 30/10/2023',5,10,1),
 (40,'Lenovo Ideapad Slim 3 15IAH8 i5 12450H (83ER000EVN)',1,0,NULL,NULL,' https://cdn.tgdd.vn/Products/Images/44/303562/lenovo-ideapad-1-15amn7-r5-82vg0061vn-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,10,1),
 (41,'MacBook Air 13 inch M2 2022 8-core GPU',0,0,NULL,NULL,' https://cdn.tgdd.vn/Products/Images/44/231244/grey-1-org.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,10,1),
 (42,'Acer Nitro 5 Gaming AN515 57 5669 i5 11400H (NH.QEHSV.001)',1,0,NULL,NULL,' https://cdn.tgdd.vn/Products/Images/44/231244/grey-1-org.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,10,1),
 (43,'HP Pavilion 15 eg2081TU i5 1240P (7C0Q4PA)',0,0,NULL,NULL,' https://cdn.tgdd.vn/Products/Images/44/312871/hp-245-g10-r5-8f155pa-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,10,1),
 (44,'Dell Vostro 3520 i3 1215U (V5I3614W1)',1,0,NULL,NULL,' https://cdn.tgdd.vn/Products/Images/44/314830/dell-vostro-3430-i5-71011900-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,10,1),
 (45,'Lenovo Ideapad 3 15ITL6 i3 1115G4 (82H803SFVN)',0,1,NULL,NULL,' https://cdn.tgdd.vn/Products/Images/44/303562/lenovo-ideapad-1-15amn7-r5-82vg0061vn-glr-2.jpg',' null',CURRENT_DATE(),' 30/10/2023',5,10,1),
 (46, 'IDCooling Black Mid Tower', 1, 0, NULL, NULL,' https://product.hstatic.net/200000837185/product/case-asus-rog-strix-helios-white-edition-rgb-gx601-_-atx-rtefc_066fa99f3c264a5b9c724af2f25c5231_grande.jpg' , NULL, NULL, '30/10/2023', 13, 0, 10),
(47, 'Corsair White Full Tower', 1, 0, NULL, NULL, ' https://product.hstatic.net/200000837185/product/case-asus-rog-strix-helios-white-edition-rgb-gx601-_-atx-rtefc_066fa99f3c264a5b9c724af2f25c5231_grande.jpg', NULL, NULL, '30/10/2023', 13, 0, 10),
(48, 'MSI Blue Mini Tower', 1, 0, NULL, NULL, ' https://product.hstatic.net/200000837185/product/case-msi-mpg-velox-100p-airflow-_-atx-4-fan-f5oc9_741e137078d446e5ab551c4f0b7ab1ed_grande.jpg', NULL, NULL, '30/10/2023', 13, 0, 10),
(49, 'Gigabyte Red Micro Tower', 1, 0, NULL, NULL, ' https://product.hstatic.net/200000837185/product/case-msi-mpg-velox-100p-airflow-_-atx-4-fan-f5oc9_741e137078d446e5ab551c4f0b7ab1ed_grande.jpg', NULL, NULL, '30/10/2023', 13, 0, 10),
(50, 'Asus Green ATX', 1, 0, NULL, NULL, NULL, NULL, NULL, '30/10/2023', 13, 0, 10),
(51, 'IDCooling Yellow Mini-ITX', 1, 0, NULL, NULL, NULL, NULL, NULL, '30/10/2023', 13, 0, 10),
(52, 'Corsair Purple Micro ATX', 1, 0, NULL, NULL, NULL, NULL, NULL, '30/10/2023', 13, 0, 10),
(53, 'MSI Orange E-ATX', 1, 0, NULL, NULL, NULL, NULL, NULL, '30/10/2023', 13, 0, 10),
(54, 'Gigabyte Pink Slim Tower', 1, 0, NULL, NULL, NULL, NULL, NULL, '30/10/2023', 13, 0, 10),
(55, 'Asus Gray Cube Case', 1, 0, NULL, NULL, NULL, NULL, NULL, '30/10/2023', 13, 0, 10),
(56, 'Corsair Liquid Cooler', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/bo-3-fan-xigmatek-starz-pro-m20a-den-black-argb-x3-rdryu_c2cc25dc228945559ba309203cf569be_grande.jpg', NULL, NULL, NULL, 14, 0, 10),
(57, 'IDCooling Air Cooler', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/halo3_compressed_29f894ceb63e4202827824cd134a2b36_grande.jpg', NULL, NULL, NULL, 14, 0, 10),
(58, 'Corsair AIO Cooler', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/bo-3-fan-deepcool-fc120-3-in1-argb-white-b44ih_4ef3dbecb2134c8f95e194d3dc409be1_grande.jpg', NULL, NULL, NULL, 14, 0, 10),
(59, 'IDCooling RGB Cooler', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/halo3_compressed_29f894ceb63e4202827824cd134a2b36_grande.jpg', NULL, NULL, NULL, 14, 0, 10),
(60, 'Corsair Low Profile Cooler', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/bo-3-fan-deepcool-fc120-3-in1-argb-white-b44ih_4ef3dbecb2134c8f95e194d3dc409be1_grande.jpg', NULL, NULL, NULL, 14, 0, 10),
(61, 'IDCooling Tower Cooler', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/halo3_compressed_29f894ceb63e4202827824cd134a2b36_grande.jpg', NULL, NULL, NULL, 14, 0, 10),
(62, 'Corsair Liquid Cooler', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/bo-3-fan-xigmatek-starz-pro-m20a-den-black-argb-x3-rdryu_c2cc25dc228945559ba309203cf569be_grande.jpg', NULL, NULL, NULL, 14, 0, 10),
(63, 'IDCooling AIO Cooler', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/bo-3-fan-xigmatek-starz-pro-m20a-den-black-argb-x3-rdryu_c2cc25dc228945559ba309203cf569be_grande.jpg', NULL, NULL, NULL, 14, 0, 10),
(64, 'Corsair Air Cooler', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/bo-3-fan-xigmatek-starz-pro-m20a-den-black-argb-x3-rdryu_c2cc25dc228945559ba309203cf569be_grande.jpg', NULL, NULL, NULL, 14, 0, 10),
(65, 'IDCooling RGB Cooler', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/halo3_compressed_29f894ceb63e4202827824cd134a2b36_grande.jpg', NULL, NULL, NULL, 14, 0, 10),
(66, 'Intel Core i5', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/9-14900k-3-2ghz-up-to-6-0ghz-33mb-cache-24-cores-32-thread-8p-6e-0mgm4_549f45d709c743368bc1064c15ac56e6_grande.jpg', NULL, NULL, NULL, 7, 0, 10),
(67, 'AMD Ryzen 5', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/cpu-amd-ryzen-9-7900-12-nhan-24-luong-_-socket-amd-am5-pajtt_40695c897cd34f63a1d15fb7d5798d50_grande.jpg', NULL, NULL, NULL, 7, 0, 10),
(68, 'Intel Core i5', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/9-14900k-3-2ghz-up-to-6-0ghz-33mb-cache-24-cores-32-thread-8p-6e-0mgm4_549f45d709c743368bc1064c15ac56e6_grande.jpg', NULL, NULL, NULL, 7, 0, 10),
(69, 'AMD Ryzen 5', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/cpu-amd-ryzen-7-7800x3d-8-nhan-16-luong-_-socket-amd-am5-4u08k_1e41c09d507242f79bdd1c6b04d6320c_grande.jpg', NULL, NULL, NULL, 7, 0, 10),
(70, 'Intel Core i5', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/-14700k-3-4ghz-up-to-5-6ghz-33mb-cache-20-cores-28-thread-8p-12e-ibjhp_f8cc3eedbfd943bfb2aff8a4b2e90f82_grande.jpg', NULL, NULL, NULL, 7, 0, 10),
(71, 'AMD Ryzen 5', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/cpu-amd-ryzen-9-7900-12-nhan-24-luong-_-socket-amd-am5-pajtt_40695c897cd34f63a1d15fb7d5798d50_grande.jpg', NULL, NULL, NULL, 7, 0, 10),
(72, 'Intel Core i5', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/-14700k-3-4ghz-up-to-5-6ghz-33mb-cache-20-cores-28-thread-8p-12e-ibjhp_f8cc3eedbfd943bfb2aff8a4b2e90f82_grande.jpg', NULL, NULL, NULL, 7, 0, 10),
(73, 'AMD Ryzen 5', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/cpu-amd-ryzen-9-7900-12-nhan-24-luong-_-socket-amd-am5-pajtt_40695c897cd34f63a1d15fb7d5798d50_grande.jpg', NULL, NULL, NULL, 7, 0, 10),
(74, 'Intel Core i5', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/-14700k-3-4ghz-up-to-5-6ghz-33mb-cache-20-cores-28-thread-8p-12e-ibjhp_f8cc3eedbfd943bfb2aff8a4b2e90f82_grande.jpg', NULL, NULL, NULL, 7, 0, 10),
(75, 'AMD Ryzen 5', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 7, 0, 10),
(76, 'MSI Gaming Desktop', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/pcxgearpro5wifi4060ti_8ddc036eb1274187ab404bd5a15cafe0_grande.png', NULL, NULL, NULL, 6, 0, 10),
(77, 'Asus Office Desktop', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/pcxgearprimei5406t_9d6af901efc54a13bab89512b602c95e_grande.png', NULL, NULL, NULL, 6, 0, 10),
(78, 'Gigabyte Gaming Desktop', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/14700k_4060ti-16g_compressed_88a2992a00e04ebea8cdcbceba8c9a12_grande.jpg', NULL, NULL, NULL, 6, 0, 10),
(79, 'MSI Gaming Desktop', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/pcxgearpro5wifi4060ti_8ddc036eb1274187ab404bd5a15cafe0_grande.png', NULL, NULL, NULL, 6, 0, 10),
(80, 'Asus Office Desktop', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/pcxgearprimei5406t_9d6af901efc54a13bab89512b602c95e_grande.png', NULL, NULL, NULL, 6, 0, 10),
(81, 'Gigabyte Gaming Desktop', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/14700k_4060ti-16g_compressed_88a2992a00e04ebea8cdcbceba8c9a12_grande.jpg', NULL, NULL, NULL, 6, 0, 10),
(82, 'MSI Gaming Desktop', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/pcxgearpro5wifi4060ti_8ddc036eb1274187ab404bd5a15cafe0_grande.png', NULL, NULL, NULL, 6, 0, 10),
(83, 'Asus Office Desktop', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/pcxgearprimei5406t_9d6af901efc54a13bab89512b602c95e_grande.png', NULL, NULL, NULL, 6, 0, 10),
(84, 'Gigabyte Gaming Desktop', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/14700k_4060ti-16g_compressed_88a2992a00e04ebea8cdcbceba8c9a12_grande.jpg', NULL, NULL, NULL, 6, 0, 10),
(85, 'MSI Gaming Desktop', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/pcxgearpro5wifi4060ti_8ddc036eb1274187ab404bd5a15cafe0_grande.png', NULL, NULL, NULL, 6, 0, 10),
(86, 'NVIDIA RTX 3060', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/gv-n3060gaming-oc-12gd-candb_compressed_0599a6ae3d89478491b4463b44dac400_grande.jpg', NULL, NULL, NULL, 11, 0, 10),
(87, 'AMD RX 6700 XT', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/radeon_-rx-6600-eagle-8g-01-copy_compressed_912486f3f67142e6aab0842a687dbfd1_grande.jpg', NULL, NULL, NULL, 11, 0, 10),
(88, 'NVIDIA GTX 1660 Ti', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/ce-rtx-4070-12gb-gddr6x-oc-edition-rog-strix-rtx4070-o12g-gaming-laat5_e6178d71bc1c4d86b5bdfdfe8c8a7cdf_grande.jpg', NULL, NULL, NULL, 11, 0, 10),
(89, 'AMD RX 6800', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/radeon_-rx-6600-eagle-8g-01-copy_compressed_912486f3f67142e6aab0842a687dbfd1_grande.jpg', NULL, NULL, NULL, 11, 0, 10),
(90, 'NVIDIA RTX 3070', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/ce-rtx-4070-12gb-gddr6x-oc-edition-rog-strix-rtx4070-o12g-gaming-laat5_e6178d71bc1c4d86b5bdfdfe8c8a7cdf_grande.jpg', NULL, NULL, NULL, 11, 0, 10),
(91, 'AMD RX 6600 XT', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/radeon_-rx-6600-eagle-8g-01-copy_compressed_912486f3f67142e6aab0842a687dbfd1_grande.jpg', NULL, NULL, NULL, 11, 0, 10),
(92, 'NVIDIA GTX 1650', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/radeon_-rx-6600-eagle-8g-01-copy_compressed_912486f3f67142e6aab0842a687dbfd1_grande.jpg', NULL, NULL, NULL, 11, 0, 10),
(93, 'AMD RX 6600', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/radeon_-rx-6600-eagle-8g-01-copy_compressed_912486f3f67142e6aab0842a687dbfd1_grande.jpg', NULL, NULL, NULL, 11, 0, 10),
(94, 'NVIDIA GT 1030', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/radeon_-rx-6600-eagle-8g-01-copy_compressed_912486f3f67142e6aab0842a687dbfd1_grande.jpg', NULL, NULL, NULL, 11, 0, 10),
(95, 'AMD RX 6500 XT', 1, 0, NULL, NULL, 'https://product.hstatic.net/200000837185/product/asus-tuf-gaming-geforce-rtx-4090-oc-24gb-tuf-rtx4090-o24g-gaming-k7u6h_45ba7bfcd08c46ada8c04ccd09f5844f_grande.jpg', NULL, NULL, NULL, 11, 0, 10),
(96, 'Corsair Over-ear Headphones', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(97, 'IDCooling In-ear Earphones', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(98, 'Corsair Gaming Headset', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(99, 'IDCooling Over-ear Headphones', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(100, 'Corsair Wireless Earbuds', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(101, 'IDCooling Gaming Headset', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(102, 'Corsair On-ear Headphones', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(103, 'IDCooling In-ear Monitors', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(104, 'Corsair Gaming Headphones', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(105, 'IDCooling Over-ear Headphones', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(106, 'Gaming Wired Keyboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 2, 0, 10),
(107, 'Mechanical Wired Keyboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 2, 0, 10),
(108, 'Office Wireless Keyboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 2, 0, 10),
(109, 'Gaming Wired Keyboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 2, 0, 10),
(110, 'Mechanical Wireless Keyboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 2, 0, 10),
(111, 'Office Wired Keyboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 2, 0, 10),
(112, 'Gaming Wireless Keyboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 2, 0, 10),
(113, 'Mechanical Wired Keyboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 2, 0, 10),
(114, 'Office Wireless Keyboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 2, 0, 10),
(115, 'Gaming Wired Keyboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 2, 0, 10),
(116, 'MSI Gaming Laptop', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 5, 0, 10),
(117, 'Asus Office Laptop', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 5, 0, 10),
(118, 'Gigabyte Gaming Laptop', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 5, 0, 10),
(119, 'MSI Gaming Laptop', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 5, 0, 10),
(120, 'Asus Office Laptop', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 5, 0, 10),
(121, 'Gigabyte Gaming Laptop', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 5, 0, 10),
(122, 'MSI Gaming Laptop', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 5, 0, 10),
(123, 'Asus Office Laptop', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 5, 0, 10),
(124, 'Gigabyte Gaming Laptop', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 5, 0, 10),
(125, 'MSI Gaming Laptop', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 5, 0, 10),
(126, 'Corsair Gaming Mouse', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 3, 0, 10),
(127, 'IDCooling Office Mouse', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 3, 0, 10),
(128, 'Corsair Wireless Mouse', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 3, 0, 10),
(129, 'IDCooling Gaming Mouse', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 3, 0, 10),
(130, 'Corsair Gaming Mouse', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 3, 0, 10),
(131, 'IDCooling Office Mouse', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 3, 0, 10),
(132, 'Corsair Wireless Mouse', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 3, 0, 10),
(133, 'IDCooling Gaming Mouse', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 3, 0, 10),
(134, 'Corsair Gaming Mouse', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 3, 0, 10),
(135, 'IDCooling Office Mouse', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 3, 0, 10),
(136, 'MSI Gaming Monitor', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(137, 'Asus Office Monitor', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(138, 'Gigabyte Gaming Monitor', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(139, 'MSI Gaming Monitor', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(140, 'Asus Office Monitor', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(141, 'Gigabyte Gaming Monitor', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(142, 'MSI Gaming Monitor', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(143, 'Asus Office Monitor', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(144, 'Gigabyte Gaming Monitor', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(145, 'MSI Gaming Monitor', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 4, 0, 10),
(146, 'MSI Motherboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 7, 0, 10),
(147, 'Asus Motherboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 7, 0, 10),
(148, 'Gigabyte Motherboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 7, 0, 10),
(149, 'MSI Motherboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 7, 0, 10),
(150, 'Asus Motherboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 7, 0, 10),
(151, 'Gigabyte Motherboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 7, 0, 10),
(152, 'MSI Motherboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 7, 0, 10),
(153, 'Asus Motherboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 7, 0, 10),
(154, 'Gigabyte Motherboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 7, 0, 10),
(155, 'MSI Motherboard', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 7, 0, 10),
(156, 'External SSD 1TB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 16, 0, 10),
(157, 'USB 3.0 Flash Drive 64GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 16, 0, 10),
(158, 'Wireless Charging Pad', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 16, 0, 10),
(159, 'Gaming Mouse Pad - Large', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 16, 0, 10),
(160, 'Portable Laptop Stand', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 16, 0, 10),
(161, 'Bluetooth Wireless Earbuds', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 16, 0, 10),
(162, 'Gaming Controller for PC', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 16, 0, 10),
(163, 'RGB LED Light Strip - 5m', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 16, 0, 10),
(164, 'Webcam Cover Slider', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 16, 0, 10),
(165, 'Anti-Static Wrist Strap', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 16, 0, 10),
(166, 'Corsair PSU', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 12, 0, 10),
(167, 'Corsair PSU', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 12, 0, 10),
(168, 'Seasonic PSU', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 12, 0, 10),
(169, 'EVGA PSU', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 12, 0, 10),
(170, 'Thermaltake PSU', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 12, 0, 10),
(171, 'NZXT PSU', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 12, 0, 10),
(172, 'Cooler Master PSU', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 12, 0, 10),
(173, 'Antec PSU', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 12, 0, 10),
(174, 'Corsair DDR4 RAM 16GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 9, 0, 10),
(175, 'IDCooling DDR4 RAM 8GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 9, 0, 10),
(176, 'Corsair DDR4 RAM 32GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 9, 0, 10),
(177, 'IDCooling DDR4 RAM 16GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 9, 0, 10),
(178, 'Corsair DDR4 RAM 8GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 9, 0, 10),
(179, 'IDCooling DDR4 RAM 16GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 9, 0, 10),
(180, 'Corsair DDR4 RAM 32GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 9, 0, 10),
(181, 'IDCooling DDR4 RAM 8GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 9, 0, 10),
(182, 'Corsair DDR4 RAM 16GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 9, 0, 10),
(183, 'IDCooling DDR4 RAM 8GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 9, 0, 10),
(184, 'Samsung SSD 1TB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 10, 0, 10),
(185, 'WDBlack HDD 2TB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 10, 0, 10),
(186, 'Samsung SSD 500GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 10, 0, 10),
(187, 'WDBlack HDD 4TB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 10, 0, 10),
(188, 'Samsung SSD 2TB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 10, 0, 10),
(189, 'WDBlack SSD 1TB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 10, 0, 10),
(190, 'Samsung SSD 500GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 10, 0, 10),
(191, 'WDBlack HDD 1TB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 10, 0, 10),
(192, 'Samsung SSD 1TB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 10, 0, 10),
(193, 'WDBlack SSD 2TB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 10, 0, 10),
(194, 'Samsung USB 128GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 15, 0, 10),
(195, 'WDBlack USB 256GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 15, 0, 10),
(196, 'Samsung USB 64GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 15, 0, 10),
(197, 'WDBlack USB 512GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 15, 0, 10),
(198, 'Samsung USB 256GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 15, 0, 10),
(199, 'WDBlack USB 128GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 15, 0, 10),
(200, 'Samsung USB 512GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 15, 0, 10),
(201, 'WDBlack USB 32GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 15, 0, 10),
(202, 'Samsung USB 256GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 15, 0, 10),
(203, 'WDBlack USB 64GB', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, 15, 0, 10);
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
  `user_last_modified_id` int(11) DEFAULT '0' COMMENT 'Người chỉnh sửa lần cuối',
  `user_last_modified_date` varchar(15) DEFAULT NULL COMMENT 'Thời gian chỉnh sửa',
  `user_gender` smallint(1) NOT NULL DEFAULT '0' COMMENT 'Giới tính',
  `user_address` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Địa chỉ',
  `user_created_date` varchar(15) DEFAULT NULL COMMENT 'Thời gian khởi tạo',
  `user_deleted` smallint(6) DEFAULT '0' COMMENT 'Trạng thái xóa ',
  `user_mobile_phone` varchar(15) DEFAULT NULL COMMENT 'Số điện thoại',
  `user_office_phone` varchar(20) DEFAULT NULL COMMENT 'Số điện thoại văn phòng',
  `user_social_links` varchar(100) DEFAULT NULL COMMENT 'Liên hệ',
  `user_creator_id` int(11) DEFAULT '0' COMMENT 'Người khởi tạo',
  `user_logined` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'Số lần đăng nhập',
  `user_name` varchar(45) NOT NULL COMMENT 'Tài khoản',
  `user_pass` varchar(45) NOT NULL COMMENT 'Mật khẩu',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1 COMMENT='Bảng người dùng';

--
-- Dumping data for table `tbluser`
--

/*!40000 ALTER TABLE `tbluser` DISABLE KEYS */;
INSERT INTO `tbluser` (`user_id`,`user_nickname`,`user_fullname`,`user_images`,`user_email`,`user_notes`,`user_permission`,`user_last_modified_id`,`user_last_modified_date`,`user_gender`,`user_address`,`user_created_date`,`user_deleted`,`user_mobile_phone`,`user_office_phone`,`user_social_links`,`user_creator_id`,`user_logined`,`user_name`,`user_pass`) VALUES 
 (1,'Dog lover','John Wick','\\home\\images\\user\\01.jpg','doglover@gmail.com','Ng??i tiêu dùng',1,0,NULL,0,'7 Lê Duẩn, Quận 1, Thành phố Hồ Chí Minh.','01/12/2023',0,'0342312435','0456323456',NULL,5,0,'DogLoverr','NoDogNoLife3000'),
 (2,'Pé','Nguyễn Thị Ngọc Mai','\\home\\images\\user\\02.jpg','mai06071969@gmail.com','Không có thông tin',1,0,NULL,0,'46 Hòa Mã, Quận Ba Đình, Hà Nội.','02/12/2023',0,'0123423131','0563457123',NULL,4,56,'testing','ae2b1fca515949e5d54fb22b8ed95575'),
 (3,'SKT Khánh','Mai Quốc Khánh','\\home\\images\\user\\03.jpg','faker123@gmail.com','Không có thông tin',1,0,NULL,1,'191 Lãng Yên, Quận Hà Đông, Hà Nội.','03/12/2023',0,'0257123423','0353412345',NULL,3,3,'SktKhanh','738a1eca9e15f674ff6fd7434ea1b965'),
 (4,'Cloudy Vân','Tô Văn Vân','\\home\\images\\user\\04.jpg','imhigh@gmail.com','Không có thông tin',1,0,NULL,1,'57 Trần Hưng Đạo, Hoàn Kiếm, Hà Nội.','04/12/2023',0,'0385175892','0653451234',NULL,2,0,'Cloudy999','VanCloud'),
 (5,'Tuấn White','Trần Tuấn Bạch','\\home\\images\\user\\05.jpg','maninblack@gmail.com','Không có thông tin',1,1,NULL,1,'27 Liễu Giai, Quận Ba Đình, Hà Nội.','05/12/2023',0,'0385174512','0578412345',NULL,1,0,'TuanWhite','TrangNhuOMO'),
 (6,'Donald Trump','Đỗ Nam Trung','\\home\\images\\user\06.jpg','greatagain999@gmail.com','Qu?n lý t?i chi nhánh Lâm ??ng',4,0,NULL,1,'51 Nguyễn Du, Quận Hai Bà Trưng, Hà Nội.','06/12/2023',0,'08967912345','0123542523',NULL,20,601,'admin@gmail.com','75d23af433e0cea4c0e45a56dba18b30'),
 (7,'Janua','Trường','\\home\\images\\user\\07.jpg','janua@gmail.com','Không có thông tin',1,0,NULL,0,'47 Đào Duy Từ, quận Hoàn Kiếm','07/12/2023',0,'0912334253','0123456789',NULL,0,1,'January3','Xy#7pLz!'),
 (8,'Februa','Kỳ','\\home\\images\\user\\08.jpg','februa@gmail.com','Không có thông tin',2,0,NULL,1,'24 Hàng Bồ, quận Hoàn Kiếm','08/12/2023',0,'0875643865','0345678901',NULL,0,1,'February1','qRt2$yZa'),
 (9,'March','Kháng','\\home\\images\\user\\09.jpg','march@gmail.com','Không có thông tin',3,0,NULL,0,'49 Bát Đàn, quận Hoàn Kiếm ','09/12/2023',0,'0864479754','0987654321',NULL,0,1,'March7th','9b#6sPxY'),
 (10,'April','Chiến','\\home\\images\\user\\10.jpg','april@gmail.com','Không có thông tin',4,0,NULL,1,'235B Thụy Khuê, quận Tây Hồ','10/12/2023',0,'0654312675','0456789012',NULL,0,1,'UrLieInApril','dF!4a2tZ'),
 (11,'May','Nhất','\\home\\images\\user\\11.jpg','may@gmail.com','Không có thông tin',5,0,NULL,0,'36 Tạm Thương, quận Hoàn Kiếm','11/12/2023',0,'0321498765','0678901234',NULL,0,1,'AuntMay<3','8m%1pQxW'),
 (12,'June','Định','\\home\\images\\user\\12.jpg','june@gmail.com','Không có thông tin',1,0,NULL,1,'61 Đinh Tiên Hoàng, quận Hoàn Kiếm','12/12/2023',0,'0124465899','0234567890',NULL,0,1,'JuneJune','J!0zYx#7'),
 (13,'July','Thắng','\\home\\images\\user\\13.jpg','july@gmail.com','Không có thông tin',2,0,NULL,0,'10 Lý Quốc Sư, quận Hoàn Kiếm','13/12/2023',0,'0535567843','0890123456',NULL,0,1,'Julyette','cA2!vL8x'),
 (14,'August','Lợi','\\home\\images\\user\\14.jpg','august@gmail.com','Không có thông tin',3,0,NULL,1,'43 Nguyễn Siêu, quận Hoàn Kiếm','14/12/2023',0,'0298846558','0567890123',NULL,0,1,'August2','K5!a7yRz'),
 (15,'Septem','Nguyễn Hoàng Đức','\\home\\images\\user\\15.jpg','septem@gmail.com','Không có thông tin',4,0,NULL,0,'66 Tô Hiến Thành, quận Hoàn Kiếm','15/12/2023',0,'0321635289','0789012345',NULL,0,1,'Septemvaotu','g3xYt#P!'),
 (16,'Octo','Nguyễn Đức Chiến','\\home\\images\\user\\16.jpg','octo@gmail.com','Không có thông tin',5,0,NULL,1,'29A Nguyễn Thiếp, quận Hoàn Kiếm','16/12/2023',0,'0859986589','0321456789',NULL,0,1,'Octopuss','dZ9!o5xQ'),
 (17,'Novem','Trương Tiến Anh','\\home\\images\\user\\17.jpg','novem@gmail.com','Không có thông tin',1,0,NULL,1,'Ngã 3 Cao Thắng, quận Hoàn Kiếm','17/12/2023',0,'0614585455','0543210987',NULL,0,1,'NNNovember','b7!2rWtX'),
 (18,'Decem','Khuất Văn Khang','\\home\\images\\user\\18.jpg','decem@gmail.com','Không có thông tin',2,0,NULL,0,'47 Mã Mây, quận Hoàn Kiếm','18/12/2023',0,'0898745654','0102345678',NULL,0,1,'DDDecember','Hx!Y3zL9'),
 (19,'AlphaMail','Nguyễn Quang Hải','\\home\\images\\user\\19.jpg','alphamail@gmail.com','Ng??i tiêu dùng',3,0,NULL,0,'1 Hàng Mành, quận Hoàn Kiếm','19/12/2023',0,'0356865325','0102345678',NULL,0,1,'1stAlphaMail','6o!z1WpL'),
 (20,'GigaChat','Phạm Văn Luân','\\home\\images\\user\\20.jpg','gigachat@gmail.com','Ng??i tiêu dùng',4,0,NULL,1,'48 Cầu Gỗ, quận Hoàn Kiếm','20/12/2023',0,'0468532568','0765432109',NULL,0,1,'GigachartGaren','T#8x5y!A');
/*!40000 ALTER TABLE `tbluser` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
