/*
 Navicat Premium Data Transfer

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : hoteldb

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 09/01/2019 11:22:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `cID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`cID`, `uID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('320925199806010011', '张三', '17890908846', '1002');
INSERT INTO `customer` VALUES ('320925199806010001', 'xxx', '15189808832', '1001');

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`  (
  `iname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stock` decimal(20, 0) NULL DEFAULT NULL,
  `iID` decimal(20, 0) NOT NULL,
  `icost` decimal(10, 2) NULL DEFAULT NULL,
  `unit` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`iID`) USING BTREE,
  INDEX `iID`(`iID`) USING BTREE,
  INDEX `iID_2`(`iID`) USING BTREE,
  INDEX `iID_3`(`iID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('牙刷', 35, 1, 3.00, '只');
INSERT INTO `item` VALUES ('毛巾', 85, 2, 8.00, '条');
INSERT INTO `item` VALUES ('棉被', 35, 3, 40.00, '卷');
INSERT INTO `item` VALUES ('沐浴露', 185, 4, 0.50, '袋');
INSERT INTO `item` VALUES ('洗发水', 176, 5, 1.00, '袋');
INSERT INTO `item` VALUES ('芳香剂', 10, 6, 0.00, '个');

-- ----------------------------
-- Table structure for itememploy
-- ----------------------------
DROP TABLE IF EXISTS `itememploy`;
CREATE TABLE `itememploy`  (
  `ieNo` int(11) NOT NULL AUTO_INCREMENT,
  `oNo` int(20) NULL DEFAULT NULL,
  `iecost` int(10) NULL DEFAULT NULL,
  `ieTime` datetime(0) NULL DEFAULT NULL,
  `ieday` int(11) NULL DEFAULT NULL,
  `iID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ieNo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of itememploy
-- ----------------------------
INSERT INTO `itememploy` VALUES (37, 19, 3, '2019-00-03 00:00:00', 1, '1');
INSERT INTO `itememploy` VALUES (38, 19, 8, '2019-00-03 00:00:00', 1, '2');
INSERT INTO `itememploy` VALUES (39, 19, 40, '2019-00-03 00:00:00', 1, '3');
INSERT INTO `itememploy` VALUES (40, 19, 1, '2019-00-03 00:00:00', 1, '4');
INSERT INTO `itememploy` VALUES (41, 19, 1, '2019-00-03 00:00:00', 1, '5');
INSERT INTO `itememploy` VALUES (42, 20, 3, '2019-01-04 00:00:00', 1, '1');
INSERT INTO `itememploy` VALUES (43, 20, 8, '2019-01-04 00:00:00', 1, '2');
INSERT INTO `itememploy` VALUES (44, 20, 40, '2019-01-04 00:00:00', 1, '3');
INSERT INTO `itememploy` VALUES (45, 20, 1, '2019-01-04 00:00:00', 1, '4');
INSERT INTO `itememploy` VALUES (46, 20, 1, '2019-01-04 00:00:00', 1, '5');
INSERT INTO `itememploy` VALUES (47, 21, 3, '2019-01-04 00:00:00', 1, '1');
INSERT INTO `itememploy` VALUES (48, 21, 8, '2019-01-04 00:00:00', 1, '2');
INSERT INTO `itememploy` VALUES (49, 21, 40, '2019-01-04 00:00:00', 1, '3');
INSERT INTO `itememploy` VALUES (50, 21, 1, '2019-01-04 00:00:00', 1, '4');
INSERT INTO `itememploy` VALUES (51, 21, 1, '2019-01-04 00:00:00', 1, '5');
INSERT INTO `itememploy` VALUES (52, 21, 0, '2019-01-04 00:00:00', 1, '6');
INSERT INTO `itememploy` VALUES (53, 22, 3, '2019-01-04 00:00:00', 1, '1');
INSERT INTO `itememploy` VALUES (54, 22, 8, '2019-01-04 00:00:00', 1, '2');
INSERT INTO `itememploy` VALUES (55, 22, 40, '2019-01-04 00:00:00', 1, '3');
INSERT INTO `itememploy` VALUES (56, 22, 1, '2019-01-04 00:00:00', 1, '4');
INSERT INTO `itememploy` VALUES (57, 22, 1, '2019-01-04 00:00:00', 1, '5');
INSERT INTO `itememploy` VALUES (58, 22, 0, '2019-01-04 00:00:00', 1, '6');
INSERT INTO `itememploy` VALUES (59, 23, 3, '2019-01-04 00:00:00', 1, '1');
INSERT INTO `itememploy` VALUES (60, 23, 8, '2019-01-04 00:00:00', 1, '2');
INSERT INTO `itememploy` VALUES (61, 23, 40, '2019-01-04 00:00:00', 1, '3');
INSERT INTO `itememploy` VALUES (62, 23, 1, '2019-01-04 00:00:00', 1, '4');
INSERT INTO `itememploy` VALUES (63, 23, 1, '2019-01-04 00:00:00', 1, '5');
INSERT INTO `itememploy` VALUES (64, 23, 0, '2019-01-04 00:00:00', 1, '6');
INSERT INTO `itememploy` VALUES (65, 24, 3, '2019-01-04 00:00:00', 1, '1');
INSERT INTO `itememploy` VALUES (66, 24, 8, '2019-01-04 00:00:00', 1, '2');
INSERT INTO `itememploy` VALUES (67, 24, 40, '2019-01-04 00:00:00', 1, '3');
INSERT INTO `itememploy` VALUES (68, 24, 1, '2019-01-04 00:00:00', 1, '4');
INSERT INTO `itememploy` VALUES (69, 24, 10, '2019-01-04 00:00:00', 1, '5');
INSERT INTO `itememploy` VALUES (70, 24, 0, '2019-01-04 00:00:00', 1, '6');
INSERT INTO `itememploy` VALUES (71, 25, 3, '2019-01-04 00:00:00', 1, '1');
INSERT INTO `itememploy` VALUES (72, 25, 8, '2019-01-04 00:00:00', 1, '2');
INSERT INTO `itememploy` VALUES (73, 25, 40, '2019-01-04 00:00:00', 1, '3');
INSERT INTO `itememploy` VALUES (74, 25, 1, '2019-01-04 00:00:00', 1, '4');
INSERT INTO `itememploy` VALUES (75, 25, 1, '2019-01-04 00:00:00', 1, '5');
INSERT INTO `itememploy` VALUES (76, 25, 0, '2019-01-04 00:00:00', 1, '6');
INSERT INTO `itememploy` VALUES (77, 26, 3, '2019-01-04 00:00:00', 1, '1');
INSERT INTO `itememploy` VALUES (78, 26, 8, '2019-01-04 00:00:00', 1, '2');
INSERT INTO `itememploy` VALUES (79, 26, 40, '2019-01-04 00:00:00', 1, '3');
INSERT INTO `itememploy` VALUES (80, 26, 1, '2019-01-04 00:00:00', 1, '4');
INSERT INTO `itememploy` VALUES (81, 26, 1, '2019-01-04 00:00:00', 1, '5');
INSERT INTO `itememploy` VALUES (82, 26, 0, '2019-01-04 00:00:00', 1, '6');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `oNo` int(11) NOT NULL AUTO_INCREMENT,
  `cID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `otype` int(11) NULL DEFAULT NULL,
  `oTime` datetime(0) NULL DEFAULT NULL,
  `day` int(11) NULL DEFAULT NULL,
  `total` decimal(10, 2) NULL DEFAULT NULL,
  `bargain` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`oNo`) USING BTREE,
  INDEX `cID_customer`(`cID`) USING BTREE,
  INDEX `rID_room`(`rID`) USING BTREE,
  CONSTRAINT `rID_room` FOREIGN KEY (`rID`) REFERENCES `room` (`rid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (18, '320925199806010011', '1', 1, '2019-01-04 00:00:00', 1, 152.50, 0);
INSERT INTO `order` VALUES (19, '320925199806010011', '2', 0, '2019-01-03 00:00:00', 1, 162.50, 0);
INSERT INTO `order` VALUES (20, '320925199806010011', '3', 0, '2019-01-04 00:01:00', 1, 172.50, 0);
INSERT INTO `order` VALUES (21, '320925199806010001', '1', 1, '2019-01-04 00:01:00', 1, 152.50, 0);
INSERT INTO `order` VALUES (22, '320925199806010001', '1', 0, '2019-01-04 00:01:00', 1, 152.50, 0);
INSERT INTO `order` VALUES (23, '320925199806010001', '1', 0, '2019-01-04 00:01:00', 1, 152.50, 0);
INSERT INTO `order` VALUES (24, '320925199806010001', '1', 0, '2019-01-04 00:01:00', 1, 161.50, 0);
INSERT INTO `order` VALUES (25, '320925199806010001', '2', 1, '2019-01-04 00:01:00', 1, 162.50, 100);
INSERT INTO `order` VALUES (26, '320925199806010001', '2', 0, '2019-01-04 00:01:00', 1, 162.50, 100);

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `rname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  `rID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rcost` decimal(20, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`rID`) USING BTREE,
  INDEX `rID`(`rID`) USING BTREE,
  INDEX `rID_2`(`rID`) USING BTREE,
  INDEX `rID_3`(`rID`) USING BTREE,
  INDEX `rID_4`(`rID`) USING BTREE,
  INDEX `rID_5`(`rID`) USING BTREE,
  INDEX `rID_6`(`rID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('A101', 0, '1', 100.00);
INSERT INTO `room` VALUES ('A102', 2, '2', 110.00);
INSERT INTO `room` VALUES ('A103', 0, '3', 120.00);
INSERT INTO `room` VALUES ('A104', 0, '4', 130.00);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uID` decimal(20, 0) NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`uID`) USING BTREE,
  INDEX `uID`(`uID`) USING BTREE,
  INDEX `uID_2`(`uID`) USING BTREE,
  INDEX `uID_3`(`uID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1001, '123456', 0);
INSERT INTO `user` VALUES (1002, '123456', 0);
INSERT INTO `user` VALUES (11001, '123456', 1);
INSERT INTO `user` VALUES (21001, '123456', 2);
INSERT INTO `user` VALUES (123456, '123456', 0);

SET FOREIGN_KEY_CHECKS = 1;
