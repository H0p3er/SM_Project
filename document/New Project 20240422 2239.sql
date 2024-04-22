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
-- Definition of table `tblcomment`
--

DROP TABLE IF EXISTS `tblcomment`;
CREATE TABLE `tblcomment` (
  `comment_id` int(11) NOT NULL,
  `comment_content` text NOT NULL,
  `comment_created_date` int(11) NOT NULL,
  `comment_creator_id` int(11) NOT NULL,
  `comment_product_id` int(11) NOT NULL
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
  `delivery_id` int(11) NOT NULL,
  `delivery_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbldelivery`
--

/*!40000 ALTER TABLE `tbldelivery` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbldelivery` ENABLE KEYS */;


--
-- Definition of table `tblsale`
--

DROP TABLE IF EXISTS `tblsale`;
CREATE TABLE `tblsale` (
  `sale_id` int(11) NOT NULL,
  `sale_name` varchar(255) NOT NULL,
  `sale_product_id` int(11) NOT NULL,
  `sale_off_price` float NOT NULL,
  `sale_off_price_percent` float NOT NULL,
  `sale_start_date` date NOT NULL,
  `sale_end_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblsale`
--

/*!40000 ALTER TABLE `tblsale` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblsale` ENABLE KEYS */;


--
-- Definition of table `tblaction`
--

DROP TABLE IF EXISTS `tblaction`;
CREATE TABLE `tblaction` (
  `action_id` int(11) unsigned NOT NULL,
  `action_created_date` varchar(14) NOT NULL,
  `action_creator_id` int(11) unsigned NOT NULL DEFAULT '0',
  `action_target_table` int(11) unsigned NOT NULL,
  `action_target_column` int(11) unsigned NOT NULL DEFAULT '0',
  `action_method` int(1) unsigned NOT NULL
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
  `bd_id` int(11) unsigned NOT NULL COMMENT 'ID',
  `bd_bill_id` int(11) NOT NULL DEFAULT '0' COMMENT 'ID hóa đơn',
  `bd_product_id` int(11) NOT NULL DEFAULT '0' COMMENT 'ID Sản phẩm',
  `bd_product_quantity` int(10) NOT NULL DEFAULT '0' COMMENT 'Số lượng'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Bảng chi tiết hóa đơn';

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
  `bill_id` int(11) NOT NULL COMMENT 'ID hóa đơn',
  `bill_created_date` varchar(15) DEFAULT NULL COMMENT 'Ngày tạo hóa đơn',
  `bill_creator_id` int(11) DEFAULT '0' COMMENT 'Người tạo hóa đơn',
  `bill_delivery_id` int(11) DEFAULT '0' COMMENT 'Người vận chuyển, Đơn vị vận chuyển'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Bảng hóa đơn';

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
-- Definition of table `tblguarantee`
--

DROP TABLE IF EXISTS `tblguarantee`;
CREATE TABLE `tblguarantee` (
  `guarantee_id` int(11) DEFAULT NULL,
  `guarantee_started_date` date DEFAULT NULL,
  `guarantee_expired_date` date DEFAULT NULL,
  `guarantee_deleted` smallint(6) DEFAULT NULL,
  `guarantee_price` int(11) DEFAULT NULL,
  `guarantee_method` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblguarantee`
--

/*!40000 ALTER TABLE `tblguarantee` DISABLE KEYS */;
INSERT INTO `tblguarantee` (`guarantee_id`,`guarantee_started_date`,`guarantee_expired_date`,`guarantee_deleted`,`guarantee_price`,`guarantee_method`) VALUES 
 (8,'0000-00-00','0000-00-00',0,10000,0),
 (9,'0000-00-00','0000-00-00',0,900000,0),
 (10,'0000-00-00','0000-00-00',0,40000,0),
 (11,'0000-00-00','0000-00-00',0,45000,0),
 (12,'0000-00-00','0000-00-00',0,620000,0),
 (13,'0000-00-00','0000-00-00',1,780000,0),
 (14,'0000-00-00','0000-00-00',1,93000,0),
 (15,'0000-00-00','0000-00-00',1,365000,0),
 (16,'0000-00-00','0000-00-00',1,21000,0),
 (17,'0000-00-00','0000-00-00',1,104000,0);
/*!40000 ALTER TABLE `tblguarantee` ENABLE KEYS */;


--
-- Definition of table `tbllog`
--

DROP TABLE IF EXISTS `tbllog`;
CREATE TABLE `tbllog` (
  `log_id` int(10) unsigned NOT NULL,
  `log_user_id` varchar(45) NOT NULL COMMENT 'ID người khởi tạo',
  `log_user_permission` smallint(1) unsigned NOT NULL COMMENT 'Quyền của người dùng',
  `log_username` varchar(45) NOT NULL COMMENT 'Tên người dùng',
  `log_action` smallint(1) unsigned NOT NULL COMMENT '1-Add, 2- Edit, 3-Del',
  `log_position` smallint(50) unsigned NOT NULL COMMENT 'Vị trí bảng (1-bill, 2-bd, 3-employee. 4-guarantee, 5-product, 6-provider, 7-user, 8-shop, 9-wsd)',
  `log_name` text COMMENT 'Tên log',
  `log_notes` text COMMENT 'Ghi chú của log',
  `log_created_date` varchar(45) DEFAULT NULL COMMENT 'Ngày khởi tạo Log',
  `log_deleted` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Bảng thông tin nhật ký';

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
  `pc_id` int(11) NOT NULL,
  `pc_name` varchar(100) DEFAULT NULL,
  `pc_notes` text,
  `pc_created_date` varchar(10) DEFAULT NULL,
  `pc_image` varchar(100) DEFAULT NULL,
  `pc_enable` bit(1) DEFAULT NULL,
  `pc_parent_id` int(11) DEFAULT NULL,
  `pc_creator_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Bảng danh mục sản phẩm';

--
-- Dumping data for table `tblpc`
--

/*!40000 ALTER TABLE `tblpc` DISABLE KEYS */;
INSERT INTO `tblpc` (`pc_id`,`pc_name`,`pc_notes`,`pc_created_date`,`pc_image`,`pc_enable`,`pc_parent_id`,`pc_creator_id`) VALUES 
 (1,'Laptop - Tablet - Mobile','Danh m?c Laptop - Tablet - Mobile','','',0x00,0,0),
 (2,'Máy tính - Máy chủ','Danh m?c Máy tính - Máy ch?','','',0x00,0,0),
 (3,'Máy tính All-in-one','Danh m?c Máy tính All-in-one','','',0x00,0,0),
 (4,'PCAP Máy Tính An Phát','Danh m?c PCAP Máy Tính An Phát','','',0x00,0,0),
 (5,'Apple, đèn led','Danh m?c Apple','','',0x00,0,0),
 (6,'Máy in - TB Văn Phòng','Danh m?c Máy in - TB V?n Phòng','','',0x00,0,0),
 (7,'Linh Kiện Máy Tính','Danh m?c Linh Ki?n Máy Tính','','',0x00,0,0),
 (8,'Màn Hình Máy Tính','Danh m?c Màn Hình Máy Tính','','',0x00,0,0),
 (9,'Gaming Gear','Danh m?c Gaming Gear','','',0x00,0,0),
 (10,'Thiết bị lưu trữ, USB, thẻ nhớ','Danh m?c Thi?t b? l?u tr?, USB, th? nh?','','',0x00,0,0),
 (11,'Loa, Tai Nghe, Webcam, Tivi','Danh m?c Loa, Tai Nghe, Webcam, Tivi','','',0x00,0,0),
 (12,'Camera','Danh m?c Camera','','',0x00,0,0),
 (13,'Cooling, Tản nhiệt','Danh m?c Cooling, T?n nhi?t','','',0x00,0,0),
 (14,'Thiết Bị Mạng','Danh m?c Thi?t B? M?ng','','',0x00,0,0),
 (15,'Phụ Kiện Laptop, PC, Khác','Danh m?c Ph? Ki?n Laptop, PC, Khác','','',0x00,0,0),
 (16,'Xe Đạp Điện, Smart Home','Danh m?c Xe ??p ?i?n, Smart Home','','',0x00,0,0),
 (17,'Buồng Chơi Game Giả Lập','Danh m?c Bu?ng Ch?i Game Gi? L?p','','',0x00,0,0);
/*!40000 ALTER TABLE `tblpc` ENABLE KEYS */;


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
-- Definition of table `tbltranspoter`
--

DROP TABLE IF EXISTS `tbltranspoter`;
CREATE TABLE `tbltranspoter` (
  `transpoter_id` int(11) NOT NULL AUTO_INCREMENT,
  `transpoter_name` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT 'Tên nhà cung cấp',
  `transpoter_notes` text CHARACTER SET utf8 COMMENT 'Mô tả ',
  `transpoter_address` varchar(45) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Địa chỉ',
  PRIMARY KEY (`transpoter_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COMMENT='Bảng nhà cung cấp';

--
-- Dumping data for table `tbltranspoter`
--

/*!40000 ALTER TABLE `tbltranspoter` DISABLE KEYS */;
INSERT INTO `tbltranspoter` (`transpoter_id`,`transpoter_name`,`transpoter_notes`,`transpoter_address`) VALUES 
 (1,'Apple','Apple là m?t hãng công ngh? ?a d?ng n?i ti?ng v?i s?n ph?m máy tính và thi?t b? ?i?n t? sang tr?ng và hi?u su?t cao.','1 Infinite Loop, Cupertino, California 95014,'),
 (2,'Microsoft','Microsoft là m?t trong nh?ng tên tu?i hàng ??u trong l?nh v?c công ngh?, chuyên s?n xu?t các s?n ph?m và d?ch v? liên quan ??n máy tính và ph?n m?m.','1 Microsoft Way, Redmond, Washington 98052, H'),
 (3,'HP','HP (Hewlett-Packard) là m?t trong nh?ng th??ng hi?u n?i ti?ng trong ngành công nghi?p máy tính, chuyên s?n xu?t các s?n ph?m máy tính và máy in.','1501 Page Mill Road, Palo Alto, California 94'),
 (4,'Dell','Dell là m?t hãng máy tính toàn c?u n?i ti?ng v?i s? chuyên nghi?p trong vi?c s?n xu?t máy tính cá nhân, máy tính xách tay và các d?ch v? công ngh? liên quan.','1 Dell Way, Round Rock, Texas 78682, Hoa Kỳ.'),
 (5,'MSI','MSI (Micro-Star International) là m?t công ty chuyên s?n xu?t các s?n ph?m công ngh? ch?i game, bao g?m máy tính và linh ki?n ch?i game cao c?p.','69, Lide St., Zhonghe Dist., New Taipei City ');
/*!40000 ALTER TABLE `tbltranspoter` ENABLE KEYS */;


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
 (2,'Pé','Nguyễn Thị Ngọc Mai','\\home\\images\\user\\02.jpg','mai06071969@gmail.com','Không có thông tin',1,0,NULL,0,'46 Hòa Mã, Quận Ba Đình, Hà Nội.','02/12/2023',0,'0123423131','0563457123',NULL,4,39,'testing','ae2b1fca515949e5d54fb22b8ed95575'),
 (3,'SKT Khánh','Mai Quốc Khánh','\\home\\images\\user\\03.jpg','faker123@gmail.com','Không có thông tin',1,0,NULL,1,'191 Lãng Yên, Quận Hà Đông, Hà Nội.','03/12/2023',0,'0257123423','0353412345',NULL,3,3,'SktKhanh','738a1eca9e15f674ff6fd7434ea1b965'),
 (4,'Cloudy Vân','Tô Văn Vân','\\home\\images\\user\\04.jpg','imhigh@gmail.com','Không có thông tin',1,0,NULL,1,'57 Trần Hưng Đạo, Hoàn Kiếm, Hà Nội.','04/12/2023',0,'0385175892','0653451234',NULL,2,0,'Cloudy999','VanCloud'),
 (5,'Tuấn White','Trần Tuấn Bạch','\\home\\images\\user\\05.jpg','maninblack@gmail.com','Không có thông tin',1,1,NULL,1,'27 Liễu Giai, Quận Ba Đình, Hà Nội.','05/12/2023',0,'0385174512','0578412345',NULL,1,0,'TuanWhite','TrangNhuOMO'),
 (6,'Donald Trump','Đỗ Nam Trung','\\home\\images\\user\06.jpg','greatagain999@gmail.com','Qu?n lý t?i chi nhánh Lâm ??ng',4,0,NULL,1,'51 Nguyễn Du, Quận Hai Bà Trưng, Hà Nội.','06/12/2023',0,'08967912345','0123542523',NULL,20,597,'admin@gmail.com','75d23af433e0cea4c0e45a56dba18b30'),
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


--
-- Definition of table `tbl_cases`
--
DROP TABLE IF EXISTS `tbl_cases`;
CREATE TABLE `tbl_cases` (
  `case_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `case_manufacturer` varchar(50) DEFAULT NULL,
  `case _color` varchar(50) DEFAULT NULL COMMENT 'Color',
  `case_size` varchar(50) DEFAULT NULL COMMENT 'Case Size'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Cases Table';

--
-- Dumping data for table `tbl_cases`
--

/*!40000 ALTER TABLE `tbl_cases` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_cases` ENABLE KEYS */;


--
-- Definition of table `tbl_cooling`
--
DROP TABLE IF EXISTS `tbl_cooling`;
CREATE TABLE `tbl_cooling` (
  `cooling_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `cooling_manufacturer` varchar(50) DEFAULT NULL,
  `cooling_type` varchar(50) DEFAULT NULL COMMENT 'Cooling Type',
  `cooling_color` varchar(50) DEFAULT NULL COMMENT 'Color',
  `cooling_fan_size` varchar(50) DEFAULT NULL COMMENT 'Fan Size'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Cooling Table';

--
-- Dumping data for table `tbl_cooling`
--

/*!40000 ALTER TABLE `tbl_cooling` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_cooling` ENABLE KEYS */;

--
-- Definition of table `tbl_cpus`
--
DROP TABLE IF EXISTS `tbl_cpus`;
CREATE TABLE `tbl_cpus` (
  `cpu_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `cpu_collection` varchar(100) DEFAULT NULL COMMENT 'core i5/ryzen 5',
  `socket` varchar(50) DEFAULT NULL COMMENT 'Socket',
  `cores` varchar(50) DEFAULT NULL COMMENT 'Core',
  `theats` varchar(50) DEFAULT NULL COMMENT 'Theats',
  `speed` varchar(50) DEFAULT NULL COMMENT 'Speed'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='CPUs Table';

--
-- Dumping data for table `tbl_cpus`
--

/*!40000 ALTER TABLE `tbl_cpus` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_cpus` ENABLE KEYS */;

--
-- Definition of table `tbl_desktops`
--
DROP TABLE IF EXISTS `tbl_desktops`;
CREATE TABLE `tbl_desktops` (
  `desktop_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `desktop_manufacturer` varchar(50) DEFAULT NULL,
  `desktop_type` varchar(50) DEFAULT NULL COMMENT 'Type',
  `desktop_cpu` varchar(100) DEFAULT NULL COMMENT 'CPU',
  `desktop_gpu` varchar(100) DEFAULT NULL COMMENT 'GPU',
  `desktop_ram_capacity` varchar(20) DEFAULT NULL COMMENT 'RAM Capacity',
  `desktop_ram_type` varchar(20) DEFAULT NULL COMMENT 'RAM Type',
  `desktop_storage` varchar(100) DEFAULT NULL COMMENT 'Storage',
  `desktop_power_supply` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Desktops Table';

--
-- Dumping data for table `tbl_desktops`
--

/*!40000 ALTER TABLE `tbl_desktops` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_desktops` ENABLE KEYS */;

--
-- Definition of table `tbl_graphics_cards`
--
DROP TABLE IF EXISTS `tbl_graphics_cards`;
CREATE TABLE `tbl_graphics_cards` (
  `graphics_card_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `graphics_card_manufacturer` varchar(100) DEFAULT NULL COMMENT 'Manufacturer',
  `graphics_card_speed` varchar(50) DEFAULT NULL,
  `graphics_card_cores` varchar(50) DEFAULT NULL,
  `graphics_card_version` varchar(50) DEFAULT NULL COMMENT 'Version',
  `graphics_card_vram_capacity` varchar(20) DEFAULT NULL COMMENT 'VRAM Capacity',
  `graphics_card_require_psu` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Graphics Cards Table';

--
-- Dumping data for table `tbl_graphics_cards`
--

/*!40000 ALTER TABLE `tbl_graphics_cards` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_graphics_cards` ENABLE KEYS */;

--
-- Definition of table `tbl_headphones_speakers`
--
DROP TABLE IF EXISTS `tbl_headphones_speakers`;
CREATE TABLE `tbl_headphones_speakers` (
  `headphones_speakers_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `headphones_manufacturer` varchar(50) DEFAULT NULL,
  `headphone_type` varchar(100) DEFAULT NULL COMMENT 'Inear/Overear/Speaker',
  `headphones_connection` varchar(50) DEFAULT NULL COMMENT 'Connection Type',
  `headphones_connection_ports` varchar(100) DEFAULT NULL COMMENT 'Connection Ports'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Headphones/Speakers Table';

--
-- Dumping data for table `tbl_headphones_speakers`
--

/*!40000 ALTER TABLE `tbl_headphones_speakers` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_headphones_speakers` ENABLE KEYS */;

--
-- Definition of table `tbl_keyboards`
--
DROP TABLE IF EXISTS `tbl_keyboards`;
CREATE TABLE `tbl_keyboards` (
  `keyboard_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `keyboard_type` varchar(100) DEFAULT NULL COMMENT 'Gaming/mechanical/Office',
  `keyboard_connection_type` varchar(50) DEFAULT NULL COMMENT 'Connection Type',
  `keyboard_size_layout` varchar(50) DEFAULT NULL COMMENT 'Size Layout',
  `keyboard_led_backlighting` tinyint(1) DEFAULT NULL COMMENT 'LED Backlighting'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Keyboards Table';

--
-- Dumping data for table `tbl_keyboards`
--

/*!40000 ALTER TABLE `tbl_keyboards` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_keyboards` ENABLE KEYS */;

--
-- Definition of table `tbl_laptops`
--
DROP TABLE IF EXISTS `tbl_laptops`;
CREATE TABLE `tbl_laptops` (
  `laptop_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `laptop_manufacturer` varchar(100) DEFAULT NULL COMMENT 'Manufacturer',
  `laptop_cpu` varchar(100) DEFAULT NULL COMMENT 'CPU',
  `laptop_ram` varchar(100) DEFAULT NULL COMMENT 'RAM',
  `laptop_graphics_card` varchar(100) DEFAULT NULL COMMENT 'Graphics Card',
  `laptop_storage` varchar(100) DEFAULT NULL COMMENT 'Storage',
  `laptop_screen_size` varchar(20) DEFAULT NULL COMMENT 'Screen Size',
  `laptop_refresh_rate` varchar(50) DEFAULT NULL COMMENT 'Refresh Rate',
  `laptop_resolution` varchar(20) DEFAULT NULL COMMENT 'Resolution',
  `laptop_type` varchar(50) DEFAULT NULL COMMENT 'Type'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Laptops Table';

--
-- Dumping data for table `tbl_laptops`
--

/*!40000 ALTER TABLE `tbl_laptops` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_laptops` ENABLE KEYS */;

--
-- Definition of table `tbl_mice`
--
DROP TABLE IF EXISTS `tbl_mice`;
CREATE TABLE `tbl_mice` (
  `mouse_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `mouse_manufacturer` varchar(50) DEFAULT NULL,
  `mouse_type` varchar(100) DEFAULT NULL COMMENT 'Gaming/Office',
  `mouse_connection_type` varchar(50) DEFAULT NULL COMMENT 'Connection Type',
  `mouse_design` varchar(100) DEFAULT NULL COMMENT 'Design',
  `mouse_battery` varchar(50) DEFAULT NULL COMMENT 'Battery Type'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Mice Table';

--
-- Dumping data for table `tbl_mice`
--

/*!40000 ALTER TABLE `tbl_mice` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_mice` ENABLE KEYS */;

--
-- Definition of table `tbl_monitors`
--
DROP TABLE IF EXISTS `tbl_monitors`;
CREATE TABLE `tbl_monitors` (
  `monitor_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `monitor_manufacturer` varchar(100) DEFAULT NULL COMMENT 'Manufacturer',
  `monitor_size` varchar(50) DEFAULT NULL COMMENT 'Size',
  `monitor_type` varchar(100) DEFAULT NULL COMMENT 'Gaming/Office/Graphics',
  `monitor_resolution` varchar(50) DEFAULT NULL COMMENT 'Resolution',
  `monitor_panel_type` varchar(50) DEFAULT NULL COMMENT 'Panel Type',
  `monitor_refresh_rate` varchar(50) DEFAULT NULL COMMENT 'Refresh Rate',
  `monitor_screen_type` varchar(50) DEFAULT NULL COMMENT 'Shape/Ratio',
  `monitor_response` varchar(50) DEFAULT NULL COMMENT 'Respone time'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Monitors Table';

--
-- Dumping data for table `tbl_monitors`
--

/*!40000 ALTER TABLE `tbl_monitors` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_monitors` ENABLE KEYS */;

--
-- Definition of table `tbl_motherboards`
--
DROP TABLE IF EXISTS `tbl_motherboards`;
CREATE TABLE `tbl_motherboards` (
  `motherboard_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `motherboard_manufacturer` varchar(100) DEFAULT NULL COMMENT 'Manufacturer',
  `motherboard_chipset` varchar(100) DEFAULT NULL COMMENT 'Chipset',
  `motherboard_socket` varchar(50) DEFAULT NULL COMMENT 'Socket',
  `motherboard_size` varchar(50) DEFAULT NULL COMMENT 'Size',
  `motherboard_ram_support` varchar(50) DEFAULT NULL COMMENT 'RAM Support',
  `motherboard_ram_slots` varchar(50) DEFAULT NULL COMMENT 'Number of RAM Slots'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Motherboards Table';

--
-- Dumping data for table `tbl_motherboards`
--

/*!40000 ALTER TABLE `tbl_motherboards` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_motherboards` ENABLE KEYS */;

--
-- Definition of table `tbl_other_accessories`
--
DROP TABLE IF EXISTS `tbl_other_accessories`;
CREATE TABLE `tbl_other_accessories` (
  `accessory_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL COMMENT 'Description'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Other Accessories Table';

--
-- Dumping data for table `tbl_other_accessories`
--

/*!40000 ALTER TABLE `tbl_other_accessories` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_other_accessories` ENABLE KEYS */;

--
-- Definition of table `tbl_power_supply`
--
DROP TABLE IF EXISTS `tbl_power_supply`;
CREATE TABLE `tbl_power_supply` (
  `psu_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `psu_manufacturer` varchar(50) DEFAULT NULL,
  `psu_certification` varchar(50) DEFAULT NULL COMMENT 'Power Certification',
  `psu_cable_type` varchar(100) DEFAULT NULL COMMENT 'Cable Type',
  `psu_size` varchar(50) DEFAULT NULL COMMENT 'Size',
  `psu_power_output` varchar(50) DEFAULT NULL COMMENT 'Power Output'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Power Supply Table';

--
-- Dumping data for table `tbl_power_supply`
--

/*!40000 ALTER TABLE `tbl_power_supply` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_power_supply` ENABLE KEYS */;

--
-- Definition of table `tbl_rams`
--
DROP TABLE IF EXISTS `tbl_rams`;
CREATE TABLE `tbl_rams` (
  `ram_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `ram_manufacturer` varchar(50) DEFAULT NULL,
  `ram_type` varchar(50) DEFAULT NULL COMMENT 'RAM Type',
  `ram_capacity` varchar(20) DEFAULT NULL COMMENT 'RAM Capacity',
  `ram_bus_speed` varchar(20) DEFAULT NULL COMMENT 'RAM Bus Speed',
  `ram_standard` varchar(50) DEFAULT NULL COMMENT 'RAM Standard'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='RAMs Table';

--
-- Dumping data for table `tbl_rams`
--

/*!40000 ALTER TABLE `tbl_rams` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_rams` ENABLE KEYS */;

--
-- Definition of table `tbl_storage`
--
DROP TABLE IF EXISTS `tbl_storage`;
CREATE TABLE `tbl_storage` (
  `storage_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `storage_manufacturer` varchar(50) DEFAULT NULL,
  `storage_type` varchar(50) DEFAULT NULL COMMENT 'SSD/HDD',
  `storage_capacity` varchar(20) DEFAULT NULL COMMENT 'Capacity',
  `storage_m2_pcie_type` varchar(50) DEFAULT NULL COMMENT 'M.2 PCIe type',
  `storage_rpm` int(11) DEFAULT NULL COMMENT 'RPM'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Storage Table';

--
-- Dumping data for table `tbl_storage`
--

/*!40000 ALTER TABLE `tbl_storage` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_storage` ENABLE KEYS */;

--
-- Definition of table `tbl_usbs`
--
DROP TABLE IF EXISTS `tbl_usbs`;
CREATE TABLE `tbl_usbs` (
  `usb_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `usb_manufacturer` varchar(100) DEFAULT NULL COMMENT 'Manufacturer',
  `usb_capacity` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='USBs Table';

--
-- Dumping data for table `tbl_usbs`
--

/*!40000 ALTER TABLE `tbl_usbs` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_usbs` ENABLE KEYS */;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
