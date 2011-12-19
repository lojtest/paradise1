/*
MySQL Data Transfer
Source Host: localhost
Source Database: l1jdb
Target Host: localhost
Target Database: l1jdb
Date: 2011-12-19 ���� 06:26:42
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for character_buddys
-- ----------------------------
CREATE TABLE `character_buddys` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `char_id` int(10) NOT NULL DEFAULT '0',
  `buddy_id` int(10) unsigned NOT NULL DEFAULT '0',
  `buddy_name` varchar(45) NOT NULL,
  PRIMARY KEY (`char_id`,`buddy_id`),
  KEY `key_id` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
