/*
 Navicat Premium Data Transfer

 Source Server         : Localhost
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : gspdb

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 21/11/2019 09:51:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `lastname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pass` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `_created` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'Homer', 'Truong', 'homer@gsp.com', '12345678', '2019-11-07 23:16:05');
INSERT INTO `users` VALUES (2, 'Tri', 'Tran', 'tri@gsp.com', '12345678', '2019-11-07 23:16:05');
INSERT INTO `users` VALUES (3, 'Tuan', 'Mac', 'tuan@gsp.com', '12345678', '2019-11-07 23:16:05');
INSERT INTO `users` VALUES (4, 'Thuyen', 'Nguyen', 'thuyen@gsp.com', '12345678', '2019-11-21 09:48:09');
INSERT INTO `users` VALUES (5, 'Sang', 'Cao', 'sang@gsp.com', '12345678', '2019-11-21 09:48:37');
INSERT INTO `users` VALUES (6, 'Truc', 'Nguyen', 'truc@gsp.com', '12345678', '2019-11-21 09:49:13');
INSERT INTO `users` VALUES (7, 'Cuong', 'Phan', 'cuong@gsp.com', '12345678', '2019-11-21 09:49:50');
INSERT INTO `users` VALUES (8, 'Dung', 'Nguyen', 'dung@gsp.com', '12345678', '2019-11-21 09:50:21');

SET FOREIGN_KEY_CHECKS = 1;
