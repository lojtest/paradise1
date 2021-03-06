/*
MySQL Data Transfer
Source Host: localhost
Source Database: l1jdb
Target Host: localhost
Target Database: l1jdb
Date: 2011-12-19 ฯยฮ็ 06:33:40
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for weapon_skill
-- ----------------------------
CREATE TABLE `weapon_skill` (
  `weapon_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `note` varchar(255) DEFAULT NULL,
  `probability` int(11) unsigned NOT NULL DEFAULT '0',
  `fix_damage` int(11) unsigned NOT NULL DEFAULT '0',
  `random_damage` int(11) unsigned NOT NULL DEFAULT '0',
  `area` int(11) NOT NULL DEFAULT '0',
  `skill_id` int(11) unsigned NOT NULL DEFAULT '0',
  `skill_time` int(11) unsigned NOT NULL DEFAULT '0',
  `effect_id` int(11) unsigned NOT NULL DEFAULT '0',
  `effect_target` int(11) unsigned NOT NULL DEFAULT '0',
  `arrow_type` int(11) unsigned NOT NULL DEFAULT '0',
  `attr` int(11) unsigned NOT NULL DEFAULT '0',
  `gfx_id` int(11) unsigned NOT NULL DEFAULT '0',
  `gfx_id_target` int(1) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`weapon_id`)
) ENGINE=MyISAM AUTO_INCREMENT=316 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `weapon_skill` VALUES ('47', 'ๆฒ้ปไนๅ', '2', '0', '0', '0', '64', '16', '2177', '0', '0', '0', '0', '1');
INSERT INTO `weapon_skill` VALUES ('54', 'ๅ็นไนๅ', '15', '35', '25', '0', '0', '0', '10', '0', '0', '8', '0', '1');
INSERT INTO `weapon_skill` VALUES ('58', 'ๆญปไบก้ชๅฃซ็็ไนๅ', '7', '75', '15', '0', '0', '0', '1811', '0', '0', '2', '0', '1');
INSERT INTO `weapon_skill` VALUES ('76', 'ไผฆๅพๅๅ', '15', '35', '25', '0', '0', '0', '1805', '0', '0', '1', '0', '1');
INSERT INTO `weapon_skill` VALUES ('121', 'ๅฐไนๅฅณ็้ญๆ', '25', '95', '55', '0', '0', '0', '1810', '0', '0', '4', '0', '1');
INSERT INTO `weapon_skill` VALUES ('203', '็้ญ็ๅๆๅ', '15', '90', '90', '2', '0', '0', '762', '0', '0', '2', '0', '1');
INSERT INTO `weapon_skill` VALUES ('205', '็ฝ็ๅคฉไฝฟๅผ', '5', '8', '0', '0', '0', '0', '6288', '0', '1', '0', '0', '1');
INSERT INTO `weapon_skill` VALUES ('256', 'ไธๅฃ่ๅ็้ฟๅ', '8', '35', '25', '0', '0', '0', '2750', '0', '0', '1', '0', '1');
INSERT INTO `weapon_skill` VALUES ('257', 'ไธๅฃ่้ฟๅ', '8', '35', '25', '0', '0', '0', '2750', '0', '0', '1', '0', '1');
INSERT INTO `weapon_skill` VALUES ('258', '็ปๆไธๅฃ่ๅ็้ฟๅ', '8', '35', '25', '0', '0', '0', '2750', '0', '0', '1', '0', '1');
INSERT INTO `weapon_skill` VALUES ('301', '่ๆญฆ็ญๅ', '8', '65', '30', '0', '0', '0', '129', '0', '0', '0', '0', '1');
INSERT INTO `weapon_skill` VALUES ('302', '่ๆญฆๅๆๅ', '8', '65', '30', '0', '0', '0', '129', '0', '0', '0', '0', '1');
INSERT INTO `weapon_skill` VALUES ('303', '่ๆญฆๅๅ', '8', '65', '30', '0', '0', '0', '129', '0', '0', '0', '0', '1');
INSERT INTO `weapon_skill` VALUES ('304', '่ๆญฆไนๅผฉ', '8', '65', '30', '0', '0', '0', '129', '0', '1', '0', '0', '1');
INSERT INTO `weapon_skill` VALUES ('305', '่ๆญฆ้ญๆ', '8', '65', '30', '0', '0', '0', '129', '0', '0', '0', '0', '1');
INSERT INTO `weapon_skill` VALUES ('306', '็นๅถ็่ๆญฆ็ญๅ', '8', '65', '30', '0', '0', '0', '129', '0', '0', '0', '0', '1');
INSERT INTO `weapon_skill` VALUES ('307', '็นๅถ็่ๆญฆๅๆๅ', '8', '65', '30', '0', '0', '0', '129', '0', '0', '0', '0', '1');
INSERT INTO `weapon_skill` VALUES ('308', '็นๅถ็่ๆญฆๅๅ', '8', '65', '30', '0', '0', '0', '129', '0', '0', '0', '0', '1');
INSERT INTO `weapon_skill` VALUES ('309', '็นๅถ็่ๆญฆไนๅผฉ', '8', '65', '30', '0', '0', '0', '129', '0', '1', '0', '0', '1');
INSERT INTO `weapon_skill` VALUES ('310', '็นๅถ็่ๆญฆ้ญๆ', '8', '65', '30', '0', '0', '0', '129', '0', '0', '0', '0', '1');
INSERT INTO `weapon_skill` VALUES ('311', '่ถ็นๅถ็่ๆญฆ็ญๅ', '8', '65', '30', '0', '0', '0', '129', '0', '0', '0', '0', '1');
INSERT INTO `weapon_skill` VALUES ('312', '่ถ็นๅถ็่ๆญฆๅๆๅ', '8', '65', '30', '0', '0', '0', '129', '0', '0', '0', '0', '1');
INSERT INTO `weapon_skill` VALUES ('313', '่ถ็นๅถ็่ๆญฆๅๅ', '8', '65', '30', '0', '0', '0', '129', '0', '0', '0', '0', '1');
INSERT INTO `weapon_skill` VALUES ('314', '่ถ็นๅถ็่ๆญฆไนๅผฉ', '8', '65', '30', '0', '0', '0', '129', '0', '1', '0', '0', '1');
INSERT INTO `weapon_skill` VALUES ('315', '่ถ็นๅถ็่ๆญฆ้ญๆ', '8', '65', '30', '0', '0', '0', '129', '0', '0', '0', '0', '1');
