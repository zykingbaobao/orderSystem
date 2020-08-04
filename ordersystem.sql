/*
Navicat MySQL Data Transfer

Source Server         : sbpp
Source Server Version : 50524
Source Host           : localhost:3306
Source Database       : ordersystem

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2020-08-04 11:21:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cancelorderapplication_table
-- ----------------------------
DROP TABLE IF EXISTS `cancelorderapplication_table`;
CREATE TABLE `cancelorderapplication_table` (
  `orderNumber` varchar(255) NOT NULL,
  `userId` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `feedback` varchar(255) DEFAULT NULL,
  `createTime` varchar(255) DEFAULT NULL,
  `updateTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderNumber`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for cart_table
-- ----------------------------
DROP TABLE IF EXISTS `cart_table`;
CREATE TABLE `cart_table` (
  `userId` varchar(255) NOT NULL,
  `commodityId` varchar(255) DEFAULT NULL,
  `amount` int(10) DEFAULT NULL,
  `createTime` varchar(255) DEFAULT NULL,
  `updateTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for commoditysort_table
-- ----------------------------
DROP TABLE IF EXISTS `commoditysort_table`;
CREATE TABLE `commoditysort_table` (
  `sortId` int(10) NOT NULL,
  `sortName` varchar(255) DEFAULT NULL,
  `createTime` varchar(255) DEFAULT NULL,
  `updateTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sortId`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for commodity_table
-- ----------------------------
DROP TABLE IF EXISTS `commodity_table`;
CREATE TABLE `commodity_table` (
  `commodityId` varchar(255) NOT NULL,
  `commodityName` varchar(255) DEFAULT NULL,
  `describe` varchar(255) DEFAULT NULL,
  `commodityImageUrl` varchar(255) DEFAULT NULL,
  `commodityMoney` float(10,0) DEFAULT NULL,
  `sortId` int(10) DEFAULT NULL,
  `materials` varchar(255) DEFAULT NULL,
  `createTime` varchar(255) DEFAULT NULL,
  `updateTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`commodityId`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for detailorder_table
-- ----------------------------
DROP TABLE IF EXISTS `detailorder_table`;
CREATE TABLE `detailorder_table` (
  `orderNumber` varchar(10) NOT NULL,
  `commodityId` varchar(255) DEFAULT NULL,
  `orderAmount` int(10) DEFAULT NULL,
  `commodityPrice` float(10,0) DEFAULT NULL,
  `createTime` varchar(255) DEFAULT NULL,
  `updateTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderNumber`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for orderstatistics_table
-- ----------------------------
DROP TABLE IF EXISTS `orderstatistics_table`;
CREATE TABLE `orderstatistics_table` (
  `commodityId` varchar(255) NOT NULL,
  `orderNumber` int(10) DEFAULT NULL,
  `orderAmount` float(10,0) DEFAULT NULL,
  `createTime` varchar(255) DEFAULT NULL,
  `updateTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`commodityId`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for order_table
-- ----------------------------
DROP TABLE IF EXISTS `order_table`;
CREATE TABLE `order_table` (
  `orderId` varchar(255) NOT NULL,
  `userId` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `orderMoney` float(10,0) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `orderTime` datetime DEFAULT NULL,
  `createTime` varchar(255) DEFAULT NULL,
  `updateTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for permission_table
-- ----------------------------
DROP TABLE IF EXISTS `permission_table`;
CREATE TABLE `permission_table` (
  `permissionId` varchar(10) NOT NULL,
  `permissionName` varchar(255) DEFAULT NULL,
  `havePermission` varchar(255) DEFAULT NULL,
  `createTime` varchar(255) DEFAULT NULL,
  `updateTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`permissionId`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for staff_table
-- ----------------------------
DROP TABLE IF EXISTS `staff_table`;
CREATE TABLE `staff_table` (
  `staffId` varchar(255) NOT NULL,
  `staffName` varchar(255) DEFAULT NULL,
  `permissionId` varchar(10) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `createTime` varchar(255) DEFAULT NULL,
  `updateTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`staffId`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for statistics_table
-- ----------------------------
DROP TABLE IF EXISTS `statistics_table`;
CREATE TABLE `statistics_table` (
  `orderNumber` int(10) DEFAULT NULL,
  `orderAmount` float(10,0) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `createTime` varchar(255) DEFAULT NULL,
  `updateTime` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for user_table
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table` (
  `userId` varchar(255) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `createTime` varchar(255) DEFAULT NULL,
  `updateTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;
