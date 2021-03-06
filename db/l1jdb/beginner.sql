/*
MySQL Data Transfer
Source Host: localhost
Source Database: l1jdb
Target Host: localhost
Target Database: l1jdb
Date: 2011-12-19 ĻĀĪē 06:26:02
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for beginner
-- ----------------------------
CREATE TABLE `beginner` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `item_id` int(6) NOT NULL DEFAULT '0',
  `count` int(10) NOT NULL DEFAULT '0',
  `charge_count` int(10) NOT NULL DEFAULT '0',
  `enchantlvl` int(6) NOT NULL DEFAULT '0',
  `item_name` varchar(50) NOT NULL DEFAULT '',
  `activate` char(1) NOT NULL DEFAULT 'A',
  `bless` int(11) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `beginner` VALUES ('1', '40005', '1', '0', '0', 'č”ē', 'A', '1');
INSERT INTO `beginner` VALUES ('2', '40005', '1', '0', '0', 'č”ē', 'A', '1');
INSERT INTO `beginner` VALUES ('3', '40641', '1', '0', '0', 'čÆ“čÆå·č½“', 'A', '1');
INSERT INTO `beginner` VALUES ('4', '35', '1', '0', '0', 'č±”ēå”åęå', 'K', '1');
INSERT INTO `beginner` VALUES ('5', '48', '1', '0', '0', 'č±”ēå”åęå', 'K', '1');
INSERT INTO `beginner` VALUES ('6', '147', '1', '0', '0', 'č±”ēå”ę§å¤“', 'K', '1');
INSERT INTO `beginner` VALUES ('7', '105', '1', '0', '0', 'č±”ēå”éæē', 'K', '1');
INSERT INTO `beginner` VALUES ('8', '174', '1', '0', '0', 'č±”ēå”ē³å¼', 'K', '1');
INSERT INTO `beginner` VALUES ('9', '7', '1', '0', '0', 'č±”ēå”ē­å', 'K', '1');
INSERT INTO `beginner` VALUES ('10', '49309', '1', '0', '0', 'č±”ēå”ē®­ē­', 'K', '1');
INSERT INTO `beginner` VALUES ('11', '35', '1', '0', '0', 'č±”ēå”åęå', 'P', '1');
INSERT INTO `beginner` VALUES ('12', '48', '1', '0', '0', 'č±”ēå”åęå', 'P', '1');
INSERT INTO `beginner` VALUES ('13', '147', '1', '0', '0', 'č±”ēå”ę§å¤“', 'P', '1');
INSERT INTO `beginner` VALUES ('14', '7', '1', '0', '0', 'č±”ēå”ē­å', 'P', '1');
INSERT INTO `beginner` VALUES ('15', '35', '1', '0', '0', 'č±”ēå”åęå', 'E', '1');
INSERT INTO `beginner` VALUES ('16', '175', '1', '0', '0', 'č±”ēå”éæå¼', 'E', '1');
INSERT INTO `beginner` VALUES ('17', '174', '1', '0', '0', 'č±”ēå”ē³å¼', 'E', '1');
INSERT INTO `beginner` VALUES ('18', '7', '1', '0', '0', 'č±”ēå”ē­å', 'E', '1');
INSERT INTO `beginner` VALUES ('19', '49309', '1', '0', '0', 'č±”ēå”ē®­ē­', 'E', '1');
INSERT INTO `beginner` VALUES ('20', '35', '1', '0', '0', 'č±”ēå”åęå', 'W', '1');
INSERT INTO `beginner` VALUES ('21', '224', '1', '0', '0', 'č±”ēå”é­ę', 'W', '1');
INSERT INTO `beginner` VALUES ('22', '7', '1', '0', '0', 'č±”ēå”ē­å', 'W', '1');
INSERT INTO `beginner` VALUES ('23', '35', '1', '0', '0', 'č±”ēå”åęå', 'D', '1');
INSERT INTO `beginner` VALUES ('24', '174', '1', '0', '0', 'č±”ēå”ē³å¼', 'D', '1');
INSERT INTO `beginner` VALUES ('25', '73', '1', '0', '0', 'č±”ēå”åå', 'D', '1');
INSERT INTO `beginner` VALUES ('26', '156', '1', '0', '0', 'č±”ēå”é¢ēŖ', 'D', '1');
INSERT INTO `beginner` VALUES ('27', '7', '1', '0', '0', 'č±”ēå”ē­å', 'D', '1');
INSERT INTO `beginner` VALUES ('28', '49309', '1', '0', '0', 'č±”ēå”ē®­ē­', 'D', '1');
INSERT INTO `beginner` VALUES ('29', '35', '1', '0', '0', 'č±”ēå”åęå', 'R', '1');
INSERT INTO `beginner` VALUES ('30', '48', '1', '0', '0', 'č±”ēå”åęå', 'R', '1');
INSERT INTO `beginner` VALUES ('31', '147', '1', '0', '0', 'č±”ēå”ę§å¤“', 'R', '1');
INSERT INTO `beginner` VALUES ('32', '147', '1', '0', '0', 'č±”ēå”ę§å¤“', 'I', '1');
INSERT INTO `beginner` VALUES ('33', '174', '1', '0', '0', 'č±”ēå”ē³å¼', 'I', '1');
INSERT INTO `beginner` VALUES ('34', '224', '1', '0', '0', 'č±”ēå”é­ę', 'I', '1');
INSERT INTO `beginner` VALUES ('35', '49309', '1', '0', '0', 'č±”ēå”ē®­ē­', 'I', '1');
