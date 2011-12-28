/*
MySQL Data Transfer
Source Host: localhost
Source Database: l1jdb
Target Host: localhost
Target Database: l1jdb
Date: 2011-12-20 ���� 11:35:18
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for z_copy_etcitem
-- ----------------------------
CREATE TABLE `z_copy_etcitem` (
  `item_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `unidentified_name_id` varchar(45) NOT NULL DEFAULT '',
  `identified_name_id` varchar(45) NOT NULL DEFAULT '',
  `item_type` varchar(40) NOT NULL DEFAULT '',
  `use_type` varchar(20) NOT NULL DEFAULT '',
  `material` varchar(45) NOT NULL DEFAULT '',
  `weight` int(10) unsigned NOT NULL DEFAULT '0',
  `invgfx` int(10) unsigned NOT NULL DEFAULT '0',
  `grdgfx` int(10) unsigned NOT NULL DEFAULT '0',
  `itemdesc_id` int(10) unsigned NOT NULL DEFAULT '0',
  `stackable` int(10) unsigned NOT NULL DEFAULT '0',
  `max_charge_count` int(10) unsigned NOT NULL DEFAULT '0',
  `dmg_small` int(10) unsigned NOT NULL DEFAULT '0',
  `dmg_large` int(10) unsigned NOT NULL DEFAULT '0',
  `min_lvl` int(10) unsigned NOT NULL DEFAULT '0',
  `max_lvl` int(10) unsigned NOT NULL DEFAULT '0',
  `locx` int(10) unsigned NOT NULL DEFAULT '0',
  `locy` int(10) unsigned NOT NULL DEFAULT '0',
  `mapid` int(10) unsigned NOT NULL DEFAULT '0',
  `bless` int(2) unsigned NOT NULL DEFAULT '1',
  `trade` int(2) unsigned NOT NULL DEFAULT '0',
  `cant_delete` int(2) unsigned NOT NULL DEFAULT '0',
  `can_seal` int(2) unsigned NOT NULL DEFAULT '0',
  `delay_id` int(10) unsigned NOT NULL DEFAULT '0',
  `delay_time` int(10) unsigned NOT NULL DEFAULT '0',
  `delay_effect` int(10) unsigned NOT NULL DEFAULT '0',
  `food_volume` int(10) unsigned NOT NULL DEFAULT '0',
  `save_at_once` tinyint(1) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`item_id`)
) ENGINE=MyISAM AUTO_INCREMENT=240102 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------