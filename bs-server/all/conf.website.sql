/*
 Navicat Premium Data Transfer

 Source Server         : 47.114.83.215
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : 47.114.83.215:3306
 Source Schema         : tio_site_conf

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 09/02/2021 11:24:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for website
-- ----------------------------
DROP TABLE IF EXISTS `website`;
CREATE TABLE `website`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `createtime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `sitename` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `siteurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `siteicon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of website
-- ----------------------------
INSERT INTO `website` VALUES (3, '2021-02-03 13:48:29', '2021-02-03 13:48:29', '百度', 'http://www.baidu.com', NULL);
INSERT INTO `website` VALUES (4, '2021-02-03 17:01:18', '2021-02-04 09:46:23', '京东1', 'https://www.jd.com/', NULL);
INSERT INTO `website` VALUES (5, '2021-02-03 17:02:02', '2021-02-04 09:38:02', '京东2', 'https://www.jd.com/', NULL);

SET FOREIGN_KEY_CHECKS = 1;
