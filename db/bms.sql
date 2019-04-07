/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : bms529

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-12-22 21:42:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` char(36) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `name` varchar(12) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `PASSWORD` varchar(25) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('2', 'ZiyuZhang', '123456');
INSERT INTO `admin` VALUES ('3', 'getianao', '123456');
INSERT INTO `admin` VALUES ('4', 'ChaofanZhu', '123456');
INSERT INTO `admin` VALUES ('6', 'test', '123456');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` char(36) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `name` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `ISBN` varchar(25) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `type` varchar(10) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `description` varchar(150) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `img_url` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `status` char(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'C++ primer', 'ISBN123456', 'CS', 'a book to learn c++', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1543753094957&di=7a46097a9b7862008a38e06809372c4e&imgtype=0&src=http%3A%2F%2Fwww.kfzimg.com%2FW03%2Fd3%2Fee%2Fd3ee202eeed2dc2918622c6eda4aa15b_b.jpg', '1');
INSERT INTO `book` VALUES ('10', '镖人', 'ISBN9787559625793', 'other', '3次登上日本央视NHK电视台新闻报道节目，被日本媒体誉为“太阳系级别的中国动漫精品”！ 日文单行本热卖中！', 'https://book.douban.com/subject/30331243/?icn=index-latestbook-subject', '1');
INSERT INTO `book` VALUES ('11', '进击的智人', 'ISBN9787508695655', 'other', '“特别会讲故事的博物学者”河森堡首部作品。同名演讲《进击的智人》播放量破亿次。', 'https://img3.doubanio.com/view/subject/l/public/s29946936.jpg', '0');
INSERT INTO `book` VALUES ('12', '310上海异人故事', 'ISBN9787532167845', 'fiction', '310，上海人身份证数字前三位，一组刻进身体的社会基因密码；', 'https://img1.doubanio.com/view/subject/l/public/s29906087.jpg', '1');
INSERT INTO `book` VALUES ('2', 'Machine Yearning', 'ISBN123123', 'CS', 'a book to learn machine learning', 'https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjNi7i-64DfAhWKilQKHWFxD0IQjRx6BAgBEAU&url=https%3A%2F%2Fwww.goodreads.com%2Fbook%2Fshow%2F30741739-machine-learning-yearning&psig=AOvVaw0pWJjro4q9z7Gdou-0x8Ww&ust=1543829553627064', '0');
INSERT INTO `book` VALUES ('3', '十二个圣诞古树', 'ISBN9787559618566', 'fiction', '《橘子不是唯一的水果》作者珍妮特·温特森的魔法时间！', 'https://img3.doubanio.com/view/subject/l/public/s29938670.jpg', '1');
INSERT INTO `book` VALUES ('4', '无羁', 'ISBN9787541151736', 'fiction', '这一次，“夷陵老祖”魏无羡与“含光君”蓝忘机携手探秘，能否解开这几十年间的重重谜团？', 'https://img3.doubanio.com/view/subject/l/public/s29939394.jpg', '1');
INSERT INTO `book` VALUES ('5', '极简科学起源课', 'ISBN9787535799500', 'science', '古希腊的阿那克西曼德，见证科学思想从萌芽到生长，一路讲述到哥白尼、伽利略、爱因斯坦，用诗意优美的语言引领我们重走这趟长达26世纪的伟大旅程。', 'https://img3.doubanio.com/view/subject/l/public/s29908872.jpg', '1');
INSERT INTO `book` VALUES ('6', '如何成为一个有绝活的人', 'ISBN9787121346187', 'other', '这是一本少有的、以工作为主题却能让上班族广泛传阅的杰作，总会有小员工如获至宝地在网络上转发，也会有大老板交代下属大量复印，让员工仔细阅读。', 'https://img3.doubanio.com/view/subject/l/public/s29934325.jpg', '1');
INSERT INTO `book` VALUES ('7', '有斐：男士基本款', 'ISBN9787807682615', 'life', '《有斐Basic：男士基本款》是知名新媒体品牌“杜绍斐”出版的第一本主题MOOK（杂志书）。旨在推广时尚、健康的男装文化的同时，帮助中国当下亿万“嗷嗷待哺”的直男，认识男装历史，了解男装礼仪、培养男装审美以及建立自己的衣着品格。', 'https://img3.doubanio.com/view/subject/l/public/s29887813.jpg', '1');
INSERT INTO `book` VALUES ('8', '沉睡的记忆', 'ISBN9787020145492', 'other', '《沉睡的记忆》出版于2017年，是莫迪亚诺荣获诺贝尔文学奖之后首部新作', 'https://img1.doubanio.com/view/subject/l/public/s29852158.jpg', '1');
INSERT INTO `book` VALUES ('9', '无规则游戏', 'ISBN9787213088308', 'fiction', '塔米姆·安萨利是一位阿富汗裔美国人，他出生和成长在喀布尔，于1964年移居美国，兼有阿富汗和美国两国血统。他讲述的阿富汗故事饱含对故国家园的深切关怀，从局内人的视角为我们解读阿富汗动荡不安的内在原因。他坦言，在阿富汗，西方式的民主没有植根的土壤；按照西方的游戏规则，阿富汗人将无法生存。', 'https://img3.doubanio.com/view/subject/l/public/s29923214.jpg', '1');

-- ----------------------------
-- Table structure for `borrower`
-- ----------------------------
DROP TABLE IF EXISTS `borrower`;
CREATE TABLE `borrower` (
  `id` char(36) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `name` varchar(12) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `PASSWORD` varchar(25) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `type` varchar(8) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `degree` varchar(6) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of borrower
-- ----------------------------
INSERT INTO `borrower` VALUES ('1', 'andy', '123456', 'stu', 'BD');
INSERT INTO `borrower` VALUES ('3', 'TianaoGe', '123456', 'teacher', null);
INSERT INTO `borrower` VALUES ('4', 'ChaofanZhu', '123456', 'stu', 'MD');
INSERT INTO `borrower` VALUES ('6', 'test', '123456', 'teacher', '');

-- ----------------------------
-- Table structure for `borrowrecord`
-- ----------------------------
DROP TABLE IF EXISTS `borrowrecord`;
CREATE TABLE `borrowrecord` (
  `recordID` char(36) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `borrowerID` char(36) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `bookID` char(36) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `borrowTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `dueTime` timestamp NOT NULL,
  `status` char(1) NOT NULL,
  PRIMARY KEY (`recordID`) USING BTREE,
  KEY `borrowerID` (`borrowerID`) USING BTREE,
  KEY `bookID` (`bookID`) USING BTREE,
  CONSTRAINT `borrowrecord_ibfk_1` FOREIGN KEY (`borrowerID`) REFERENCES `borrower` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `borrowrecord_ibfk_2` FOREIGN KEY (`bookID`) REFERENCES `book` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of borrowrecord
-- ----------------------------
INSERT INTO `borrowrecord` VALUES ('1', '3', '3', '2018-12-20 16:52:17', '2018-12-30 11:54:35', '1');
INSERT INTO `borrowrecord` VALUES ('2', '1', '2', '2018-12-20 18:08:35', '2019-01-30 11:54:35', '0');
INSERT INTO `borrowrecord` VALUES ('3', '4', '3', '2018-12-20 16:52:20', '2018-12-15 11:54:35', '1');
INSERT INTO `borrowrecord` VALUES ('4', '3', '11', '2018-12-20 18:01:59', '2018-12-20 17:07:54', '0');
INSERT INTO `borrowrecord` VALUES ('5', '6', '10', '2018-12-20 18:01:31', '2018-12-20 17:08:10', '1');

-- ----------------------------
-- Table structure for `loginticket`
-- ----------------------------
DROP TABLE IF EXISTS `loginticket`;
CREATE TABLE `loginticket` (
  `ticket` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `userid` varchar(36) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT '',
  `role` varchar(10) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT '',
  `expired` date DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ticket`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of loginticket
-- ----------------------------
INSERT INTO `loginticket` VALUES ('0ab1a', '1', 'operator', '2018-12-20', '0');
INSERT INTO `loginticket` VALUES ('123abcabc', '1', 'admin', '2018-12-02', '1');
INSERT INTO `loginticket` VALUES ('19c0c', '1', 'borrower', '2018-12-21', '0');
INSERT INTO `loginticket` VALUES ('1e50a', '1', 'admin', '2018-12-20', '0');
INSERT INTO `loginticket` VALUES ('1e744', '1', 'admin', '2018-12-20', '0');
INSERT INTO `loginticket` VALUES ('46a45', '1', 'admin', '2018-12-20', '0');
INSERT INTO `loginticket` VALUES ('6d989', '6', 'admin', '2018-12-23', '0');
INSERT INTO `loginticket` VALUES ('71b9c', '6', 'admin', '2018-12-21', '0');
INSERT INTO `loginticket` VALUES ('7a4e0', '1', 'operator', '2018-12-21', '0');
INSERT INTO `loginticket` VALUES ('7bbab', '1', 'borrower', '2018-12-20', '0');
INSERT INTO `loginticket` VALUES ('80466', '1', 'borrower', '2018-12-21', '0');
INSERT INTO `loginticket` VALUES ('8de89', '1', 'borrower', '2018-12-21', '0');
INSERT INTO `loginticket` VALUES ('93651', '1', 'operator', '2018-12-20', '0');
INSERT INTO `loginticket` VALUES ('945ca', '1', 'operator', '2018-12-21', '0');
INSERT INTO `loginticket` VALUES ('9a9a0', '1', 'borrower', '2018-12-20', '0');
INSERT INTO `loginticket` VALUES ('af4f7', '1', 'admin', '2018-12-20', '0');
INSERT INTO `loginticket` VALUES ('bb579', '6', 'admin', '2018-12-21', '0');
INSERT INTO `loginticket` VALUES ('c3e0d', '1', 'operator', '2018-12-21', '0');
INSERT INTO `loginticket` VALUES ('d5082', '1', 'borrower', '2018-12-21', '0');
INSERT INTO `loginticket` VALUES ('dadac', '1', 'operator', '2018-12-21', '0');
INSERT INTO `loginticket` VALUES ('e6b86', '1', 'operator', '2018-12-21', '0');
INSERT INTO `loginticket` VALUES ('fb341', '1', 'operator', '2018-12-23', '0');
INSERT INTO `loginticket` VALUES ('fb939', '1', 'operator', '2018-12-21', '0');

-- ----------------------------
-- Table structure for `operator`
-- ----------------------------
DROP TABLE IF EXISTS `operator`;
CREATE TABLE `operator` (
  `id` char(36) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `name` varchar(12) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `PASSWORD` varchar(25) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of operator
-- ----------------------------
INSERT INTO `operator` VALUES ('1', 'andy', '123456');
INSERT INTO `operator` VALUES ('2', 'ZiyuZhang', '123456');
INSERT INTO `operator` VALUES ('3', 'TianaoGe', '123456');
INSERT INTO `operator` VALUES ('4', 'Chaofan Zhu', '123456');
DROP TRIGGER IF EXISTS `bookStatusTrigger`;
DELIMITER ;;
CREATE TRIGGER `bookStatusTrigger` AFTER UPDATE ON `borrowrecord` FOR EACH ROW BEGIN UPDATE book SET status=new.status WHERE book.id=new.bookID; END
;;
DELIMITER ;
