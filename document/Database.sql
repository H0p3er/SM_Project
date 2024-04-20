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
  `bd_product_price` int(11) NOT NULL DEFAULT '0' COMMENT 'Gia',
  `bd_product_quantity` int(10) NOT NULL DEFAULT '0' COMMENT 'Số lượng',
  `bd_product_note` varchar(14) NOT NULL COMMENT 'Ghi chu',
  PRIMARY KEY (`bd_id`)
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=utf8 COMMENT='Bảng chi tiết hóa đơn';

--
-- Dumping data for table `tblbd`
--

/*!40000 ALTER TABLE `tblbd` DISABLE KEYS */;
INSERT INTO `tblbd` (`bd_id`,`bd_bill_id`,`bd_product_id`,`bd_product_price`,`bd_product_quantity`,`bd_product_note`) VALUES 
 (1,1,7,0,5,'0'),
 (2,1,8,17990000,3,'0'),
 (3,1,9,17590000,2,'0'),
 (4,1,10,10990000,1,'0'),
 (5,1,6,8990000,4,'0'),
 (6,2,8,27090000,3,'0'),
 (7,2,9,17590000,2,'0'),
 (8,2,12,8990000,4,'0'),
 (9,2,7,10690000,1,'0'),
 (10,2,9,13490000,3,'0'),
 (11,3,12,17990000,4,'0'),
 (12,3,15,10990000,2,'0'),
 (13,3,6,19590000,1,'0'),
 (14,3,8,16990000,3,'0'),
 (15,3,10,13490000,2,'0'),
 (16,4,13,27090000,2,'0'),
 (17,4,23,17590000,3,'0'),
 (18,4,25,8990000,1,'0'),
 (19,4,17,10690000,4,'0'),
 (20,4,19,13490000,2,'0'),
 (21,5,21,17990000,3,'0'),
 (22,5,14,10990000,4,'0'),
 (23,5,16,19590000,1,'0'),
 (24,5,8,16990000,2,'0'),
 (25,5,10,13490000,3,'0'),
 (26,6,12,27090000,3,'0'),
 (27,6,13,17590000,2,'0'),
 (28,6,15,8990000,4,'0'),
 (29,6,17,10690000,1,'0'),
 (30,6,9,13490000,3,'0'),
 (31,7,12,17990000,4,'0'),
 (32,7,14,10990000,2,'0'),
 (33,7,6,19590000,1,'0'),
 (34,7,8,16990000,3,'0'),
 (35,7,10,13490000,2,'0'),
 (36,8,12,27090000,2,'0'),
 (37,8,13,17590000,3,'0'),
 (38,8,15,8990000,1,'0'),
 (39,8,7,10690000,4,'0'),
 (40,8,9,13490000,2,'0'),
 (41,9,12,17990000,3,'0'),
 (42,9,14,10990000,4,'0'),
 (43,9,16,19590000,1,'0'),
 (44,9,18,16990000,2,'0'),
 (45,9,10,13490000,3,'0'),
 (46,10,12,27090000,5,'0'),
 (47,10,12,17990000,3,'0'),
 (48,10,13,17590000,2,'0'),
 (49,10,14,10990000,1,'0'),
 (50,10,15,8990000,4,'0'),
 (51,11,12,27090000,3,'0'),
 (52,11,21,17990000,2,'0'),
 (53,11,13,17590000,1,'0'),
 (54,11,14,10990000,4,'0'),
 (55,11,15,8990000,3,'0'),
 (56,12,6,19590000,2,'0'),
 (57,12,8,16990000,3,'0'),
 (58,12,10,13490000,1,'0'),
 (59,12,12,9690000,4,'0'),
 (60,12,14,14990000,2,'0'),
 (61,13,16,9790000,3,'0'),
 (62,13,18,13990000,4,'0'),
 (63,13,20,11990000,1,'0'),
 (64,13,22,9190000,3,'0'),
 (65,13,24,15990000,2,'0'),
 (66,14,17,16290000,4,'0'),
 (67,14,19,13990000,2,'0'),
 (68,14,21,10990000,1,'0'),
 (69,14,23,15990000,3,'0'),
 (70,14,25,9190000,2,'0'),
 (71,15,12,27090000,3,'0'),
 (72,15,13,17590000,2,'0'),
 (73,15,15,8990000,1,'0'),
 (74,15,7,10690000,4,'0'),
 (75,15,9,13490000,2,'0'),
 (76,16,12,17990000,4,'0'),
 (77,16,14,10990000,2,'0'),
 (78,16,16,19590000,1,'0'),
 (79,16,18,16990000,3,'0'),
 (80,16,10,13490000,2,'0'),
 (81,17,12,27090000,2,'0'),
 (82,17,31,17590000,3,'0'),
 (83,17,15,8990000,1,'0'),
 (84,17,17,10690000,4,'0'),
 (85,17,9,13490000,2,'0'),
 (86,18,12,17990000,3,'0'),
 (87,18,14,10990000,4,'0'),
 (88,18,16,19590000,1,'0'),
 (89,18,8,16990000,2,'0'),
 (90,18,10,13490000,3,'0'),
 (91,19,12,15000000,3,'0'),
 (92,19,13,12000000,2,'0'),
 (93,19,15,9000000,1,'0'),
 (94,19,17,11000000,4,'0'),
 (95,19,19,13500000,2,'0'),
 (96,20,12,16000000,4,'0'),
 (97,20,14,13000000,3,'0'),
 (98,20,16,10000000,2,'0'),
 (99,20,18,8000000,1,'0'),
 (100,20,20,14000000,4,'0'),
 (101,21,21,27090000,3,'0'),
 (102,21,22,17990000,2,'0'),
 (103,21,23,17590000,1,'0'),
 (104,21,24,10990000,4,'0'),
 (105,21,25,8990000,3,'0'),
 (106,22,6,19590000,2,'0'),
 (107,22,8,16990000,3,'0'),
 (108,22,10,13490000,1,'0'),
 (109,22,12,9690000,4,'0'),
 (110,22,14,14990000,2,'0'),
 (111,23,16,9790000,3,'0'),
 (112,23,18,13990000,4,'0'),
 (113,23,20,11990000,1,'0'),
 (114,23,22,9190000,3,'0'),
 (115,23,24,15990000,2,'0'),
 (116,24,17,16290000,4,'0'),
 (117,24,19,13990000,2,'0'),
 (118,24,21,10990000,1,'0'),
 (119,24,23,15990000,3,'0'),
 (120,24,25,9190000,2,'0'),
 (121,25,12,27090000,3,'0'),
 (122,25,13,17590000,2,'0'),
 (123,25,15,8990000,1,'0'),
 (124,25,17,10690000,4,'0'),
 (125,25,9,13490000,2,'0'),
 (126,26,12,17990000,4,'0'),
 (127,26,14,10990000,2,'0'),
 (128,26,6,19590000,1,'0'),
 (129,26,8,16990000,3,'0'),
 (130,26,10,13490000,2,'0'),
 (131,27,10,27090000,2,'0'),
 (132,27,31,17590000,3,'0'),
 (133,27,15,8990000,1,'0'),
 (134,27,7,10690000,4,'0'),
 (135,27,9,13490000,2,'0'),
 (136,28,12,17990000,3,'0'),
 (137,28,14,10990000,4,'0'),
 (138,28,6,19590000,1,'0'),
 (139,28,8,16990000,2,'0'),
 (140,28,10,13490000,3,'0'),
 (141,29,10,15000000,3,'0'),
 (142,29,13,12000000,2,'0'),
 (143,29,15,9000000,1,'0'),
 (144,29,17,11000000,4,'0'),
 (145,29,19,13500000,2,'0'),
 (146,30,12,16000000,4,'0'),
 (147,30,14,13000000,3,'0'),
 (148,30,16,10000000,2,'0'),
 (149,30,18,8000000,1,'0'),
 (150,30,20,14000000,4,'0'),
 (151,31,21,27090000,3,'0'),
 (152,31,22,17990000,2,'0'),
 (153,31,23,17590000,1,'0'),
 (154,31,24,10990000,4,'0'),
 (155,31,25,8990000,3,'0'),
 (156,32,6,19590000,2,'0'),
 (157,32,8,16990000,3,'0'),
 (158,32,10,13490000,1,'0'),
 (159,32,12,9690000,4,'0'),
 (160,32,14,14990000,2,'0'),
 (161,33,16,9790000,3,'0'),
 (162,33,18,13990000,4,'0'),
 (163,33,20,11990000,1,'0'),
 (164,33,22,9190000,3,'0'),
 (165,33,24,15990000,2,'0'),
 (166,34,17,16290000,4,'0'),
 (167,34,19,13990000,2,'0'),
 (168,34,21,10990000,1,'0'),
 (169,34,23,15990000,3,'0'),
 (170,34,25,9190000,2,'0'),
 (171,35,10,27090000,3,'0'),
 (172,35,13,17590000,2,'0'),
 (173,35,15,8990000,1,'0'),
 (174,35,17,10690000,4,'0'),
 (175,35,9,13490000,2,'0'),
 (176,36,12,17990000,4,'0'),
 (177,36,14,10990000,2,'0'),
 (178,36,6,19590000,1,'0'),
 (179,36,8,16990000,3,'0'),
 (180,36,10,13490000,2,'0'),
 (181,37,10,27090000,2,'0'),
 (182,37,13,17590000,3,'0'),
 (183,37,15,8990000,1,'0'),
 (184,37,7,10690000,4,'0'),
 (185,37,19,13490000,2,'0'),
 (186,38,12,17990000,3,'0'),
 (187,38,14,10990000,4,'0'),
 (188,38,16,19590000,1,'0'),
 (189,38,8,16990000,2,'0'),
 (190,38,10,13490000,3,'0'),
 (191,39,12,15000000,3,'0'),
 (192,39,13,12000000,2,'0'),
 (193,39,15,9000000,1,'0'),
 (194,39,17,11000000,4,'0'),
 (195,39,19,13500000,2,'0'),
 (196,40,12,16000000,4,'0'),
 (197,40,14,13000000,3,'0'),
 (198,40,16,10000000,2,'0'),
 (199,40,18,8000000,1,'0'),
 (200,40,20,14000000,4,'0'),
 (201,41,21,27090000,3,'0'),
 (202,41,22,17990000,2,'0'),
 (203,41,23,17590000,1,'0'),
 (204,41,24,10990000,4,'0'),
 (205,41,25,8990000,3,'0'),
 (206,42,6,19590000,2,'0'),
 (207,42,8,16990000,3,'0'),
 (208,42,10,13490000,1,'0'),
 (209,42,12,9690000,4,'0'),
 (210,42,14,14990000,2,'0'),
 (211,43,16,9790000,3,'0'),
 (212,43,18,13990000,4,'0'),
 (213,43,20,11990000,1,'0'),
 (214,43,22,9190000,3,'0'),
 (215,43,24,15990000,2,'0'),
 (216,44,17,16290000,4,'0'),
 (217,44,19,13990000,2,'0'),
 (218,44,21,10990000,1,'0'),
 (219,44,23,15990000,3,'0'),
 (220,44,25,9190000,2,'0'),
 (221,45,13,27090000,3,'0'),
 (222,45,13,17590000,2,'0'),
 (223,45,15,8990000,1,'0'),
 (224,45,7,10690000,4,'0'),
 (225,45,9,13490000,2,'0'),
 (226,46,12,17990000,4,'0'),
 (227,46,14,10990000,2,'0'),
 (228,46,6,19590000,1,'0'),
 (229,46,8,16990000,3,'0'),
 (230,46,10,13490000,2,'0'),
 (231,47,14,27090000,2,'0'),
 (232,47,13,17590000,3,'0'),
 (233,47,5,8990000,1,'0'),
 (234,47,7,10690000,4,'0'),
 (235,47,9,13490000,2,'0'),
 (236,48,12,17990000,3,'0'),
 (237,48,14,10990000,4,'0'),
 (238,48,16,19590000,1,'0'),
 (239,48,8,16990000,2,'0'),
 (240,48,10,13490000,3,'0'),
 (241,49,15,15000000,3,'0'),
 (242,49,13,12000000,2,'0'),
 (243,49,15,9000000,1,'0'),
 (244,49,17,11000000,4,'0'),
 (245,49,19,13500000,2,'0'),
 (246,50,12,16000000,4,'0'),
 (247,50,14,13000000,3,'0'),
 (248,50,16,10000000,2,'0'),
 (249,50,18,8000000,1,'0'),
 (250,50,20,14000000,4,'0');
/*!40000 ALTER TABLE `tblbd` ENABLE KEYS */;


--
-- Definition of table `tblbill`
--

DROP TABLE IF EXISTS `tblbill`;
CREATE TABLE `tblbill` (
  `bill_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID hóa đơn',
  `bill_status` smallint(1) DEFAULT '1' COMMENT '1-Hóa đơn chưa thanh toán; 2-Hóa đơn đã được thanh toán',
  `bill_created_date` varchar(15) DEFAULT NULL COMMENT 'Ngày tạo hóa đơn',
  `bill_last_modified_date` varchar(15) DEFAULT NULL COMMENT 'Ngày chỉnh sửa lần cuối',
  `bill_last_modified_id` int(11) DEFAULT '0' COMMENT 'Người chỉnh sửa lần cuối',
  `bill_creator_id` int(11) DEFAULT '0' COMMENT 'Người tạo hóa đơn',
  `bill_transporter_id` int(11) DEFAULT '0' COMMENT 'Người vận chuyển, Đơn vị vận chuyển',
  `bill_type` smallint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Loại hóa đơn: 1= import, 2 = export, 3 = transfer',
  `bi_target_shop_id` int(11) DEFAULT '0' COMMENT 'ID kho hoặc cửa hàng được nhập hàng',
  `bi_provider_id` int(11) DEFAULT '0' COMMENT 'ID Nhà cung cấp',
  `be_customer_id` int(11) DEFAULT '0' COMMENT 'Người nhận hàng',
  `be_current_shop_id` int(11) DEFAULT '0' COMMENT 'ID Kho xuất hàng',
  `be_target_address` varchar(100) DEFAULT NULL COMMENT 'Địa chỉ nhận hàng',
  PRIMARY KEY (`bill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COMMENT='Bảng hóa đơn';

--
-- Dumping data for table `tblbill`
--

/*!40000 ALTER TABLE `tblbill` DISABLE KEYS */;
INSERT INTO `tblbill` (`bill_id`,`bill_status`,`bill_created_date`,`bill_last_modified_date`,`bill_last_modified_id`,`bill_creator_id`,`bill_transporter_id`,`bill_type`,`bi_target_shop_id`,`bi_provider_id`,`be_customer_id`,`be_current_shop_id`,`be_target_address`) VALUES 
 (1,1,'1/1/2023','4/1/2023',1,1,1,1,0,0,1,1,'8 Hùng Vương, Điện Biên, Ba Đình, Hà Nội'),
 (2,1,'6/1/2023','9/1/2023',2,2,2,1,0,0,2,2,'458 Minh Khai, P.Vĩnh Tuy, Q.Hai Bà Trưng, Hà Nội'),
 (3,1,'13/1/2023','16/1/2023',3,3,3,1,0,0,3,3,'72 Nguyễn Trãi, Thanh Xuân, Hà Nội'),
 (4,1,'20/1/2023','23/1/2023',4,4,4,1,0,0,4,4,'12 Đường Bưởi, Thủ Lệ, Ba Đình, Hà Nội'),
 (5,1,'26/1/2023','1/2/2023',5,5,5,1,0,0,5,5,'47 Phạm Hùng, Mễ Trì, Nam Từ Liêm, Hà Nội'),
 (6,1,'3/2/2023','6/2/2023',6,6,6,1,0,0,1,1,'1 Lương Yên, Bạch Đằng, Hai Bà Trưng, Hà Nội'),
 (7,1,'8/2/2023','10/2/2023',7,7,7,1,0,0,2,2,'27 Cổ Linh, Long Biên, Hà Nội'),
 (8,1,'12/2/2023','16/2/2023',8,8,8,1,0,0,3,3,'Ngõ 264 Âu Cơ, Nhật Tân, Tây Hồ, Hà Nội'),
 (9,1,'18/2/2023','20/2/2023',9,9,9,1,0,0,4,4,'16 tuyến phố xung quanh Hồ Gươm, Hoàn Kiếm, Hà Nội'),
 (10,1,'23/2/2023','25/2/2023',10,10,10,1,0,0,5,5,'222 Trần Duy Hưng, Cầu Giấy, Hà Nội'),
 (11,1,'1/3/2023','5/3/2023',11,1,11,1,0,0,1,1,'11 Lê Lợi, Vinh, Nghệ An'),
 (12,1,'9/3/2023','12/3/2023',12,2,12,1,0,0,2,2,'102 Đào Duy Từ, Hà Tĩnh, Hà Tĩnh'),
 (13,1,'15/3/2023','19/3/2023',13,3,13,1,0,0,3,3,'63 Nguyễn Huệ, Huế, Thừa Thiên Huế'),
 (14,1,'21/3/2023','24/3/2023',14,4,14,1,0,0,4,4,'75 Lê Lai, Đà Nẵng'),
 (15,1,'28/3/2023','1/4/2023',15,5,15,1,0,0,5,5,'29 Trần Hưng Đạo, Quảng Ngãi, Quảng Ngãi'),
 (16,1,'3/4/2023','6/4/2023',16,6,16,1,0,0,1,1,'144 Quang Trung, Pleiku, Gia Lai'),
 (17,1,'8/4/2023','12/4/2023',17,7,17,1,0,0,2,2,'212 Lê Duẩn, Buôn Ma Thuột, Đắk Lắk'),
 (18,1,'15/4/2023','18/4/2023',18,8,18,1,0,0,3,3,'9 Nguyễn Văn Cừ, Nha Trang, Khánh Hòa'),
 (19,1,'22/4/2023','24/4/2023',19,9,19,1,0,0,4,4,'16 Ngô Quyền, Cam Ranh, Khánh Hòa'),
 (20,1,'26/4/2023','1/5/2023',20,10,20,1,0,0,5,5,'89 Hùng Vương, Phan Thiết, Bình Thuận'),
 (21,1,'5/5/2023','7/5/2023',21,1,21,1,0,0,1,1,'6 Lê Lai, Vũng Tàu, Bà Rịa - Vũng Tàu'),
 (22,1,'10/5/2023','14/5/2023',22,2,22,1,0,0,2,2,'37 Đống Đa, Biên Hòa, Đồng Nai'),
 (23,1,'16/5/2023','19/5/2023',23,3,23,1,0,0,3,3,'88 Trần Hưng Đạo, Long Xuyên, An Giang'),
 (24,1,'21/5/2023','23/5/2023',24,4,24,1,0,0,4,4,'2 Nguyễn Huệ, Cần Thơ'),
 (25,1,'27/5/2023','1/6/2023',25,5,25,1,0,0,5,5,'4 Hàm Nghi, Sóc Trăng'),
 (26,1,'5/6/2023','9/6/2023',26,6,26,0,1,1,0,0,NULL),
 (27,1,'11/6/2023','13/6/2023',27,7,27,0,2,2,0,0,NULL),
 (28,1,'17/6/2023','19/6/2023',28,8,28,0,3,3,0,0,NULL),
 (29,1,'23/6/2023','26/6/2023',29,9,29,0,4,4,0,0,NULL),
 (30,1,'28/6/2023','1/7/2023',30,10,30,0,5,5,0,0,NULL),
 (31,1,'4/7/2023','7/7/2023',31,1,31,0,1,6,0,0,NULL),
 (32,1,'11/7/2023','15/7/2023',32,2,32,0,2,1,0,0,NULL),
 (33,1,'17/7/2023','21/7/2023',33,3,33,0,3,2,0,0,NULL),
 (34,1,'23/7/2023','26/7/2023',34,4,34,0,4,3,0,0,NULL),
 (35,1,'1/8/2023','4/8/2023',35,5,35,0,5,4,0,0,NULL),
 (36,1,'8/8/2023','12/8/2023',36,6,36,0,1,5,0,0,NULL),
 (37,1,'14/8/2023','16/8/2023',37,7,37,0,2,6,0,0,NULL),
 (38,1,'19/8/2023','22/8/2023',38,8,38,0,3,1,0,0,NULL),
 (39,1,'25/8/2023','1/9/2023',39,9,39,0,4,2,0,0,NULL),
 (40,1,'4/9/2023','8/9/2023',40,10,40,0,5,3,0,0,NULL),
 (41,1,'12/9/2023','14/9/2023',41,1,41,0,1,4,0,0,NULL),
 (42,1,'17/9/2023','20/9/2023',42,2,42,0,2,5,0,0,NULL),
 (43,1,'24/9/2023','27/9/2023',43,3,43,0,3,6,0,0,NULL),
 (44,1,'1/10/2023','3/10/2023',44,4,44,0,4,1,0,0,NULL),
 (45,1,'7/10/2023','9/10/2023',45,5,45,0,5,2,0,0,NULL),
 (46,1,'13/10/2023','15/10/2023',46,6,46,0,1,3,0,0,NULL),
 (47,1,'17/10/2023','19/10/2023',47,7,47,0,2,4,0,0,NULL),
 (48,1,'23/10/2023','26/10/2023',48,8,48,0,3,5,0,0,NULL),
 (49,1,'1/11/2023','4/11/2023',49,9,49,0,4,6,0,0,NULL),
 (50,1,'8/11/2023','10/11/2023',50,10,50,0,5,1,0,0,NULL);
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
  `log_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `log_creator_id` varchar(45) NOT NULL COMMENT 'ID người khởi tạo',
  `log_user_permission` smallint(1) unsigned NOT NULL COMMENT 'Quyền của người dùng',
  `log_username` varchar(45) NOT NULL COMMENT 'Tên người dùng',
  `log_action` smallint(1) unsigned NOT NULL COMMENT '1-Add, 2- Edit, 3-Del',
  `log_position` smallint(50) unsigned NOT NULL COMMENT 'Vị trí bảng (1-bill, 2-bd, 3-employee. 4-guarantee, 5-product, 6-provider, 7-user, 8-shop, 9-wsd)',
  `log_name` text COMMENT 'Tên log',
  `log_notes` text COMMENT 'Ghi chú của log',
  `log_created_date` varchar(45) DEFAULT NULL COMMENT 'Ngày khởi tạo Log',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='Bảng thông tin nhật ký';

--
-- Dumping data for table `tbllog`
--

/*!40000 ALTER TABLE `tbllog` DISABLE KEYS */;
INSERT INTO `tbllog` (`log_id`,`log_creator_id`,`log_user_permission`,`log_username`,`log_action`,`log_position`,`log_name`,`log_notes`,`log_created_date`) VALUES 
 (1,'1',1,'DogLoverr',1,1,'log_name 1','log_notes 1','10:20:40 21/12/2023'),
 (2,'2',2,'Pé',2,2,'log_name 2','log_notes 2','15:20:30 22/12/2023'),
 (3,'3',3,'SktKhanh',3,3,'log_name 3','log_notes 3','9:30:05 23/12/2023'),
 (4,'4',4,'Cloudy999',1,4,'log_name 4','log_notes 4','8:11:06 24/12/2023'),
 (5,'5',5,'TuanWhite',2,5,'log_name 5','log_notes 5','9:09:08 24/12/2023'),
 (6,'6',4,'admin@gmail.com',1,8,NULL,'','07:08:06 26/12/2023'),
 (7,'6',4,'admin@gmail.com',1,8,NULL,'','02:37:07 29/12/2023'),
 (8,'6',4,'admin@gmail.com',1,8,NULL,'','09:18:16 29/12/2023'),
 (9,'6',4,'admin@gmail.com',3,8,NULL,'','23:01:01 04/01/2024'),
 (10,'6',4,'admin@gmail.com',1,8,NULL,'','23:02:24 04/01/2024'),
 (11,'6',4,'admin@gmail.com',1,8,NULL,'','23:03:04 04/01/2024');
/*!40000 ALTER TABLE `tbllog` ENABLE KEYS */;


--
-- Definition of table `tblpc`
--

DROP TABLE IF EXISTS `tblpc`;
CREATE TABLE `tblpc` (
  `pc_id` int(11) NOT NULL AUTO_INCREMENT,
  `pc_name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `pc_notes` text CHARACTER SET utf8,
  PRIMARY KEY (`pc_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='Bảng danh mục sản phẩm';

--
-- Dumping data for table `tblpc`
--

/*!40000 ALTER TABLE `tblpc` DISABLE KEYS */;
INSERT INTO `tblpc` (`pc_id`,`pc_name`,`pc_notes`) VALUES 
 (1,'Laptop - Tablet - Mobile','Danh m?c Laptop - Tablet - Mobile'),
 (2,'Máy tính - Máy chủ','Danh m?c Máy tính - Máy ch?'),
 (3,'Máy tính All-in-one','Danh m?c Máy tính All-in-one'),
 (4,'PCAP Máy Tính An Phát','Danh m?c PCAP Máy Tính An Phát'),
 (5,'Apple, đèn led','Danh m?c Apple'),
 (6,'Máy in - TB Văn Phòng','Danh m?c Máy in - TB V?n Phòng'),
 (7,'Linh Kiện Máy Tính','Danh m?c Linh Ki?n Máy Tính'),
 (8,'Màn Hình Máy Tính','Danh m?c Màn Hình Máy Tính'),
 (9,'Gaming Gear','Danh m?c Gaming Gear'),
 (10,'Thiết bị lưu trữ, USB, thẻ nhớ','Danh m?c Thi?t b? l?u tr?, USB, th? nh?'),
 (11,'Loa, Tai Nghe, Webcam, Tivi','Danh m?c Loa, Tai Nghe, Webcam, Tivi'),
 (12,'Camera','Danh m?c Camera'),
 (13,'Cooling, Tản nhiệt','Danh m?c Cooling, T?n nhi?t'),
 (14,'Thiết Bị Mạng','Danh m?c Thi?t B? M?ng'),
 (15,'Phụ Kiện Laptop, PC, Khác','Danh m?c Ph? Ki?n Laptop, PC, Khác'),
 (16,'Xe Đạp Điện, Smart Home','Danh m?c Xe ??p ?i?n, Smart Home'),
 (17,'Buồng Chơi Game Giả Lập','Danh m?c Bu?ng Ch?i Game Gi? L?p');
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
  `product_images` text,
  `product_guarantee_id` int(11) DEFAULT NULL COMMENT 'M? b?o hành',
  `product_notes` text,
  `product_created_date` varchar(45) DEFAULT NULL,
  `product_modified_date` varchar(45) DEFAULT NULL,
  `product_pc_id` smallint(5) unsigned NOT NULL COMMENT 'Loai san pham',
  `product_shop_id` int(10) unsigned DEFAULT '0',
  `product_quantity` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='Bảng sản phẩm';

--
-- Dumping data for table `tblproduct`
--

/*!40000 ALTER TABLE `tblproduct` DISABLE KEYS */;
INSERT INTO `tblproduct` (`product_id`,`product_name`,`product_status`,`product_deleted`,`product_images`,`product_guarantee_id`,`product_notes`,`product_created_date`,`product_modified_date`,`product_pc_id`,`product_shop_id`,`product_quantity`) VALUES 
 (6,'MacBook Air 13 inch M1 2020 7-core GPU',1,0,' /home/images/product/macbook-air-m1-2020-gray-600x600.jpg',0,' null',NULL,' 30/10/2023',1,2,1),
 (7,'HP 15s fq5229TU i3 1215U (8U237PA)',0,0,' /home/images/product/hp-15s-fq5229tu-i3-8u237pa-thumb-600x600.png',0,' null',NULL,' 30/10/2023',2,2,2),
 (8,'Asus TUF Gaming F15 FX506HF i5 11400H (HN014W)',1,0,' /home/images/product/asus-tuf-gaming-f15-fx506hf-i5-hn014w-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',3,2,3),
 (9,'Acer Aspire 5 Gaming A515 58GM 51LB i5 13420H (NX.KQ4SV.002)',0,0,' /home/images/product/acer-aspire-5-a515-58gm-51lb-i5-nxkq4sv002-170923-015941-600x600.jpg',0,' null',NULL,' 30/10/2023',4,1,4),
 (10,'Asus Vivobook Go 15 E1504FA R5 7520U (NJ776W)',1,0,' /home/images/product/asus-vivobook-go-15-e1504fa-r5-nj776w-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',5,2,5),
 (12,'HP 240 G9 i3 1215U (6L1X7PA)',1,0,' /home/images/product/hp-240-g9-i3-6l1x7pa-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',7,2,12),
 (13,'Asus Vivobook 16 X1605VA i5 1335U (MB360W)',0,0,' /home/images/product/asus-vivobook-16-x1605va-i5-mb360w-thumb-laptop-600x600.jpg',0,' null',NULL,' 30/10/2023',7,1,5),
 (14,'HP 15s fq5162TU i5 1235U (7C134PA)',1,0,' /home/images/product/hp-15s-fq5162tu-i5-7c134pa-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',7,2,12),
 (15,'Asus Vivobook 15 X1504ZA i3 1215U (NJ102W)',0,0,' /home/images/product/asus-vivobook-15-x1504za-i3-nj102w-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',7,2,5),
 (16,'Asus Vivobook X515EA i3 1115G4 (EJ3948W)',1,0,' /home/images/product/asus-vivobook-x515ea-i3-ej3948w-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',8,2,12),
 (17,'HP Pavilion 14 dv2074TU i5 1235U (7C0P3PA)',0,0,' /home/images/product/hp-pavilion-14-dv2074tu-i5-7c0p3pa-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',8,2,5),
 (18,'Asus Vivobook X515EA i5 1135G7 (EJ4155W)',1,0,' /home/images/product/asus-vivobook-x515ea-i5-ej4155w-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',16,2,1),
 (19,'Dell Vostro 15 3520 i3 1215U (5M2TT1)',0,0,' /home/images/product/dell-vostro-15-3520-i3-5m2tt1-090823-041032-600x600.png',0,' null',NULL,' 30/10/2023',16,1,2),
 (20,'HP 14 ep0126TU i3 N305 (8U233PA)',1,0,' /home/images/product/hp-14-ep0126tu-i3-8u233pa-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',16,19,35),
 (21,'Lenovo Ideapad 3 15ITL6 i3 1115G4 (82H803SGVN)',0,0,' /home/images/product/lenovo-ideapad-3-15itl6-i3-82h803sgvn-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',16,1,23),
 (22,'Dell Inspiron 15 3520 i3 1215U (71003264)',1,0,' /home/images/product/dell-inspiron-3520-i3-71003264-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',16,4,4),
 (23,'HP 15s fq2716TU i3 1115G4 (7C0X3PA)',0,0,' /home/images/product/hp-15s-fq2716tu-i3-7c0x3pa-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',2,6,3),
 (24,'Asus Vivobook X415EA i3 1115G4 (EK2034W)',1,0,' /home/images/product/asus-vivobook-x415ea-i3-ek2034w-thumb-laptop-600x600.jpg',0,' null',NULL,' 30/10/2023',2,5,1),
 (26,'Dell Inspiron 15 3520 i5 1235U (N5I5122W1)',1,0,' /home/images/product/dell-inspiron-15-3520-i5-n5i5122w1-191222-091429-600x600.jpg',0,' null',NULL,' 30/10/2023',17,4,3),
 (27,'Asus Vivobook 15 X1504VA i5 1335U (NJ025W)',0,0,' /home/images/product/asus-vivobook-15-x1504va-i5-nj025w-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',17,5,1),
 (29,'Lenovo Ideapad 3 15IAU7 i3 1215U (82RK005LVN)',0,0,' /home/images/product/lenovo-ideapad-3-15iau7-i3-82rk005lvn-281122-051953-600x600.jpg',0,' null',NULL,' 30/10/2023',17,1,2),
 (30,'HP Pavilion 15 eg2082TU i5 1240P (7C0Q5PA)',1,0,' /home/images/product/hp-pavilion-15-eg2082tu-i5-7c0q5pa-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',17,2,12),
 (31,'Lenovo Ideapad 3 15ITL6 i5 1155G7 (82H803RRVN)',0,0,' /home/images/product/lenovo-ideapad-3-15itl6-i5-82h803rrvn-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',17,1,1),
 (32,'HP 240 G8 i3 1115G4 (6L1A1PA)',1,0,' /home/images/product/hp-240-g8-i3-6l1a1pa-210423-031503-600x600.jpg',0,'null',NULL,' 30/10/2023',17,2,3),
 (33,'Asus TUF Gaming F15 FX506HE i7 11800H (HN378W)',0,0,' /home/images/product/asus-tuf-gaming-f15-fx506he-i7-hn378w-thumb-600x600.jpg',0,'null',NULL,' 30/10/2023',2,3,1),
 (34,'HP 15s fq5147TU i7 1255U (7C133PA)',1,0,' /home/images/product/hp-15s-fq5147tu-i7-7c133pa-thumb-600x600.jpg',0,'null',NULL,' 30/10/2023',2,3,3),
 (35,'Acer Aspire 3 A315 59 314F i3 1215U (NX.K6TSV.002)',0,0,' /home/images/product/acer-aspire-3-a315-59-314f-i3-nxk6tsv002-thumb-1-600x600.jpg',0,' null',NULL,' 30/10/2023',2,3,2),
 (36,'MSI Gaming GF63 Thin 11SC i5 11400H (664VN)',1,0,' /home/images/product/msi-gaming-gf63-thin-11sc-i5-664vn-glr-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',2,3,1),
 (38,'MSI Gaming GF63 Thin 11UC i7 11800H (1228VN)',1,0,' /home/images/product/msi-gaming-gf63-thin-11uc-i7-1228vn-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',2,3,1),
 (39,'Asus Vivobook 15 OLED A1505VA i5 13500H (L1341W)',0,1,' /home/images/product/asus-vivobook-15-oled-a1505va-i5-l1341w-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',2,4,1),
 (40,'Lenovo Ideapad Slim 3 15IAH8 i5 12450H (83ER000EVN)',1,0,' /home/images/product/lenovo-ideapad-slim-3-15iah8-i5-83er00evn-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',2,5,1),
 (41,'MacBook Air 13 inch M2 2022 8-core GPU',0,0,' /home/images/product/apple-macbook-air-m2-2022-vang-600x600.jpg',0,' null',NULL,' 30/10/2023',2,2,1),
 (42,'Acer Nitro 5 Gaming AN515 57 5669 i5 11400H (NH.QEHSV.001)',1,0,' /home/images/product/acer-nitro-5-gaming-an515-57-5669-i5-11400h-8gb-512gb-144hz-4gb-gtx1650-win11-nhqehsv001-031221-100506-600x600.jpg',0,' null',NULL,' 30/10/2023',2,4,1),
 (43,'HP Pavilion 15 eg2081TU i5 1240P (7C0Q4PA)',0,0,' /home/images/product/hp-pavilion-15-eg2081tu-i5-7c0q4pa-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',2,1,1),
 (44,'Dell Vostro 3520 i3 1215U (V5I3614W1)',1,0,' /home/images/product/dell-vostro-3520-i3-v5i3614w1-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',2,3,1),
 (45,'Lenovo Ideapad 3 15ITL6 i3 1115G4 (82H803SFVN)',0,1,' /home/images/product/lenovo-ideapad-3-15itl6-i3-82h803sfvn-thumb-600x600.jpg',0,' null',NULL,' 30/10/2023',2,2,1);
/*!40000 ALTER TABLE `tblproduct` ENABLE KEYS */;


--
-- Definition of table `tblproviders`
--

DROP TABLE IF EXISTS `tblproviders`;
CREATE TABLE `tblproviders` (
  `provider_id` int(11) NOT NULL AUTO_INCREMENT,
  `provider_name` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT 'Tên nhà cung cấp',
  `provider_notes` text CHARACTER SET utf8 COMMENT 'Mô tả ',
  `provider_address` varchar(45) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Địa chỉ',
  PRIMARY KEY (`provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='Bảng nhà cung cấp';

--
-- Dumping data for table `tblproviders`
--

/*!40000 ALTER TABLE `tblproviders` DISABLE KEYS */;
INSERT INTO `tblproviders` (`provider_id`,`provider_name`,`provider_notes`,`provider_address`) VALUES 
 (1,'Apple','Apple là m?t hãng công ngh? ?a d?ng n?i ti?ng v?i s?n ph?m máy tính và thi?t b? ?i?n t? sang tr?ng và hi?u su?t cao.','1 Infinite Loop, Cupertino, California 95014,'),
 (2,'Microsoft','Microsoft là m?t trong nh?ng tên tu?i hàng ??u trong l?nh v?c công ngh?, chuyên s?n xu?t các s?n ph?m và d?ch v? liên quan ??n máy tính và ph?n m?m.','1 Microsoft Way, Redmond, Washington 98052, H'),
 (3,'HP','HP (Hewlett-Packard) là m?t trong nh?ng th??ng hi?u n?i ti?ng trong ngành công nghi?p máy tính, chuyên s?n xu?t các s?n ph?m máy tính và máy in.','1501 Page Mill Road, Palo Alto, California 94'),
 (4,'Dell','Dell là m?t hãng máy tính toàn c?u n?i ti?ng v?i s? chuyên nghi?p trong vi?c s?n xu?t máy tính cá nhân, máy tính xách tay và các d?ch v? công ngh? liên quan.','1 Dell Way, Round Rock, Texas 78682, Hoa Kỳ.'),
 (5,'MSI','MSI (Micro-Star International) là m?t công ty chuyên s?n xu?t các s?n ph?m công ngh? ch?i game, bao g?m máy tính và linh ki?n ch?i game cao c?p.','69, Lide St., Zhonghe Dist., New Taipei City ');
/*!40000 ALTER TABLE `tblproviders` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='Bảng gian hàng';

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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='Bảng người dùng';

--
-- Dumping data for table `tbluser`
--

/*!40000 ALTER TABLE `tbluser` DISABLE KEYS */;
INSERT INTO `tbluser` (`user_id`,`user_nickname`,`user_fullname`,`user_images`,`user_email`,`user_notes`,`user_permission`,`user_last_modified_id`,`user_last_modified_date`,`user_gender`,`user_address`,`user_created_date`,`user_deleted`,`user_mobile_phone`,`user_office_phone`,`user_social_links`,`user_creator_id`,`user_logined`,`user_name`,`user_pass`) VALUES 
 (1,'Dog lover','John Wick','\\home\\images\\user\\01.jpg','doglover@gmail.com','Ng??i tiêu dùng',1,0,NULL,0,'7 Lê Duẩn, Quận 1, Thành phố Hồ Chí Minh.','01/12/2023',0,'0342312435','0456323456',NULL,5,0,'DogLoverr','NoDogNoLife3000'),
 (2,'Pé','Nguyễn Thị Ngọc Mai','\\home\\images\\user\\02.jpg','mai06071969@gmail.com','Không có thông tin',1,0,NULL,0,'46 Hòa Mã, Quận Ba Đình, Hà Nội.','02/12/2023',0,'0123423131','0563457123',NULL,4,0,'Pé','Pe060769'),
 (3,'SKT Khánh','Mai Quốc Khánh','\\home\\images\\user\\03.jpg','faker123@gmail.com','Không có thông tin',1,0,NULL,1,'191 Lãng Yên, Quận Hà Đông, Hà Nội.','03/12/2023',0,'0257123423','0353412345',NULL,3,3,'SktKhanh','738a1eca9e15f674ff6fd7434ea1b965'),
 (4,'Cloudy Vân','Tô Văn Vân','\\home\\images\\user\\04.jpg','imhigh@gmail.com','Không có thông tin',1,0,NULL,1,'57 Trần Hưng Đạo, Hoàn Kiếm, Hà Nội.','04/12/2023',0,'0385175892','0653451234',NULL,2,0,'Cloudy999','VanCloud'),
 (5,'Tuấn White','Trần Tuấn Bạch','\\home\\images\\user\\05.jpg','maninblack@gmail.com','Không có thông tin',1,1,NULL,1,'27 Liễu Giai, Quận Ba Đình, Hà Nội.','05/12/2023',0,'0385174512','0578412345',NULL,1,0,'TuanWhite','TrangNhuOMO'),
 (6,'Donald Trump','Đỗ Nam Trung','\\home\\images\\user\06.jpg','greatagain999@gmail.com','Qu?n lý t?i chi nhánh Lâm ??ng',4,0,NULL,1,'51 Nguyễn Du, Quận Hai Bà Trưng, Hà Nội.','06/12/2023',0,'08967912345','0123542523',NULL,20,575,'admin@gmail.com','75d23af433e0cea4c0e45a56dba18b30'),
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
