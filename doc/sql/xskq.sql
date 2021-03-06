/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : xskq

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2019-07-04 11:25:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `apppermission`
-- ----------------------------
DROP TABLE IF EXISTS `apppermission`;
CREATE TABLE `apppermission` (
  `id` varchar(32) NOT NULL,
  `p_code` varchar(10) DEFAULT NULL,
  `p_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `apppermission_unique` (`p_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of apppermission
-- ----------------------------
INSERT INTO `apppermission` VALUES ('12135', 'backMgr', '后台管理');
INSERT INTO `apppermission` VALUES ('12457', 'menuMgr', '菜单管理');

-- ----------------------------
-- Table structure for `approle`
-- ----------------------------
DROP TABLE IF EXISTS `approle`;
CREATE TABLE `approle` (
  `id` varchar(32) NOT NULL,
  `roleId` varchar(15) DEFAULT NULL,
  `roleName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_unique` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of approle
-- ----------------------------

-- ----------------------------
-- Table structure for `class`
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `cid` varchar(32) NOT NULL,
  `cname` varchar(20) DEFAULT NULL,
  `cremark` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('111', 'SE0301', '软件工程三年一班');
INSERT INTO `class` VALUES ('112', 'SE0302', '软件工程三年二班');
INSERT INTO `class` VALUES ('113', 'SE0303', '软件工程三年三班');
INSERT INTO `class` VALUES ('114', 'EE0101', '电子工程一年一班');
INSERT INTO `class` VALUES ('115', 'EE0102', '电子工程一年二班');
INSERT INTO `class` VALUES ('116', 'EE0103', '电子工程一年三班');
INSERT INTO `class` VALUES ('117', 'CS0201', '计算计科学二年一班');
INSERT INTO `class` VALUES ('118', 'CS0203', '计算计科学二年三班');
INSERT INTO `class` VALUES ('119', 'CS0301', '计算计科学三年一班');
INSERT INTO `class` VALUES ('120', 'CS0302', '计算计科学三年二班');

-- ----------------------------
-- Table structure for `duty`
-- ----------------------------
DROP TABLE IF EXISTS `duty`;
CREATE TABLE `duty` (
  `did` varchar(32) NOT NULL,
  `uid` varchar(32) DEFAULT NULL,
  `dstate` varchar(10) DEFAULT NULL,
  `ddate` datetime DEFAULT NULL,
  `dremark` varchar(100) DEFAULT NULL,
  `cid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of duty
-- ----------------------------

-- ----------------------------
-- Table structure for `dutylist`
-- ----------------------------
DROP TABLE IF EXISTS `dutylist`;
CREATE TABLE `dutylist` (
  `lid` varchar(32) NOT NULL,
  `did` varchar(32) DEFAULT NULL,
  `sid` varchar(32) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dutylist
-- ----------------------------

-- ----------------------------
-- Table structure for `oauth_access_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(48) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_access_token
-- ----------------------------

-- ----------------------------
-- Table structure for `oauth_approvals`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
  `userId` varchar(256) DEFAULT NULL,
  `clientId` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `expiresAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lastModifiedAt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_approvals
-- ----------------------------

-- ----------------------------
-- Table structure for `oauth_client_details`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(48) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('app', null, 'app', 'app', 'password,refresh_token', null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('XcWebApp', null, '$2a$10$9bEpZ/hWRQxyr5hn5wHUj.jxFpIrnOmBcWlE/g/0Zp3uNxt9QTh/S', 'app', 'authorization_code,password,refresh_token,client_credentials', null, null, '43200', '43200', null, null);

-- ----------------------------
-- Table structure for `oauth_client_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(48) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_token
-- ----------------------------

-- ----------------------------
-- Table structure for `oauth_code`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code` varchar(256) DEFAULT NULL,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_code
-- ----------------------------

-- ----------------------------
-- Table structure for `oauth_refresh_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_refresh_token
-- ----------------------------

-- ----------------------------
-- Table structure for `rolepermission`
-- ----------------------------
DROP TABLE IF EXISTS `rolepermission`;
CREATE TABLE `rolepermission` (
  `id` varchar(32) NOT NULL,
  `p_code` varchar(20) NOT NULL,
  `roleId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rolepermission
-- ----------------------------
INSERT INTO `rolepermission` VALUES ('12389', 'backMgr', 'a1');
INSERT INTO `rolepermission` VALUES ('12890', 'menuMgr', 'a1');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` varchar(32) NOT NULL,
  `cid` varchar(32) DEFAULT NULL,
  `sname` varchar(50) DEFAULT NULL,
  `sstate` varchar(10) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `mobiletel` varchar(20) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('100', '111', '李向群', '正常', '男', null, '1343', null, '塔山英模');
INSERT INTO `student` VALUES ('101', '112', '苏宁', '正常', '男', null, '1520', null, '优秀干部');
INSERT INTO `student` VALUES ('103', '111', '刘小午', '正常', '男', null, '1521', null, '41指挥官');

-- ----------------------------
-- Table structure for `userpo`
-- ----------------------------
DROP TABLE IF EXISTS `userpo`;
CREATE TABLE `userpo` (
  `uid` varchar(32) NOT NULL,
  `uname` varchar(20) NOT NULL,
  `upwd` varchar(128) NOT NULL,
  `ustate` varchar(50) DEFAULT NULL,
  `realName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `user_unique` (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userpo
-- ----------------------------
INSERT INTO `userpo` VALUES ('123', 'nzc', '$2a$10$qrQAI7uOFwrd77UjBa.F2Oh1MCE05Hxr5HL7P.PILPod/CMgFYxi.', null, null);

-- ----------------------------
-- Table structure for `userrole`
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `id` varchar(32) NOT NULL,
  `uid` varchar(20) NOT NULL,
  `roleId` varchar(20) NOT NULL,
  `roleName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES ('1111', '123', 'a1', 'admin');

-- ----------------------------
-- Table structure for `xc_user`
-- ----------------------------
DROP TABLE IF EXISTS `xc_user`;
CREATE TABLE `xc_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(45) NOT NULL COMMENT '用户名',
  `password` varchar(96) NOT NULL COMMENT '密码',
  `salt` varchar(45) DEFAULT NULL COMMENT '盐',
  `name` varchar(45) NOT NULL COMMENT '用户昵称',
  `userpic` varchar(255) DEFAULT NULL COMMENT '头像',
  `utype` varchar(32) NOT NULL COMMENT '用户类型',
  `birthday` datetime DEFAULT NULL,
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `qq` varchar(32) DEFAULT NULL,
  `status` varchar(32) NOT NULL COMMENT '用户状态',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_user_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of xc_user
-- ----------------------------
