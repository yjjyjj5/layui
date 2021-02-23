/*
Navicat MySQL Data Transfer

Source Server         : mysql5.6
Source Server Version : 50641
Source Host           : localhost:3306
Source Database       : layui

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2021-02-23 17:57:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `description` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `url` varchar(255) DEFAULT NULL COMMENT '权限访问路径',
  `perms` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `parentid` int(11) DEFAULT NULL COMMENT '父级权限ID',
  `type` int(11) DEFAULT NULL COMMENT '类型 0目录 1菜单 2按钮',
  `ordernum` int(11) DEFAULT NULL COMMENT '排序',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `status` int(11) DEFAULT NULL COMMENT '状态 1有效 2删除',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '我的信息', '我的信息', '', '', null, '0', '1', null, '1', '2021-01-29 10:27:11', '2021-01-29 10:27:11');
INSERT INTO `permission` VALUES ('2', '我的地址', '我的地址', '/address/list', '', '1', '1', '1', null, '1', '2021-01-30 17:22:48', '2021-01-30 17:22:48');
INSERT INTO `permission` VALUES ('3', '地址查询', '地址查询', '/address/list', 'address:select', '2', '2', null, null, '1', '2021-01-25 15:58:08', '2021-01-25 15:58:08');
INSERT INTO `permission` VALUES ('4', '地址添加', '地址添加', '/address/add', 'address:insert', '2', '2', null, null, '1', '2021-01-25 16:02:42', '2021-01-25 16:02:42');
INSERT INTO `permission` VALUES ('5', '地址修改', '地址修改', '/address/update', 'address:update', '2', '2', null, null, '1', '2021-01-25 16:02:46', '2021-01-25 16:02:46');
INSERT INTO `permission` VALUES ('6', '地址删除', '地址删除', '/address/delete', 'address:delete', '2', '2', null, null, '1', '2021-01-26 16:53:56', '2021-01-26 16:53:56');
INSERT INTO `permission` VALUES ('7', '我的积分', '我的积分', '/integral/list', '', '1', '1', '2', null, '1', '2021-01-25 16:03:13', '2021-01-25 16:03:13');
INSERT INTO `permission` VALUES ('8', '积分查询', '积分查询', '/integral/list', 'integral:select', '7', '2', null, null, '1', '2021-01-25 16:03:59', '2021-01-25 16:03:59');
INSERT INTO `permission` VALUES ('9', '积分添加', '积分添加', '/integral/add', 'integral:insert', '7', '2', null, null, '1', '2021-01-25 16:04:06', '2021-01-25 16:04:06');
INSERT INTO `permission` VALUES ('10', '积分修改', '积分修改', '/integral/update', 'integral:update', '7', '2', null, null, '1', '2021-01-25 16:04:25', '2021-01-25 16:04:25');
INSERT INTO `permission` VALUES ('11', '积分删除', '积分删除', '/integral/delete', 'integral:delete', '7', '2', null, null, '1', '2021-01-25 16:04:52', '2021-01-25 16:04:52');
INSERT INTO `permission` VALUES ('12', '订单管理', '订单管理', '', '', null, '0', '2', null, '1', '2021-01-29 10:12:19', '2021-01-29 10:12:19');
INSERT INTO `permission` VALUES ('13', '我的订单', '我的订单', '/order/list', '', '12', '1', '1', null, '1', '2021-01-29 10:12:17', '2021-01-29 10:12:17');
INSERT INTO `permission` VALUES ('14', '订单查询', '订单查询', '/order/list', 'order:select', '13', '2', null, '', '1', '2021-01-25 16:07:37', '2021-01-25 16:07:37');
INSERT INTO `permission` VALUES ('15', '订单添加', '订单添加', '/order/add', 'order:insert', '13', '2', null, null, '1', '2021-01-25 16:46:33', '2021-01-25 16:46:33');
INSERT INTO `permission` VALUES ('16', '订单修改', '订单修改', '/order/update', 'order:update', '13', '2', null, null, '1', '2021-01-25 16:46:33', '2021-01-25 16:46:33');
INSERT INTO `permission` VALUES ('17', '订单删除', '订单删除', '/order/delete', 'order:delete', '13', '2', null, null, '1', '2021-01-25 16:46:34', '2021-01-25 16:46:34');
INSERT INTO `permission` VALUES ('18', '消费汇总', '消费汇总', '/order/report', '', '12', '1', '2', null, '1', '2021-01-25 16:47:14', '2021-01-25 16:47:14');
INSERT INTO `permission` VALUES ('19', '消费汇总查询', '消费汇总查询', '/order/report', 'report:select', '18', '2', null, null, '1', '2021-01-25 16:47:21', '2021-01-25 16:47:21');
INSERT INTO `permission` VALUES ('20', '权限管理', '权限管理', '', '', null, '0', '3', null, '1', '2021-01-29 10:13:15', '2021-01-29 10:13:15');
INSERT INTO `permission` VALUES ('21', '用户管理', '用户管理', '/user/list', '', '20', '1', '1', null, '1', '2021-01-25 16:47:55', '2021-01-25 16:47:55');
INSERT INTO `permission` VALUES ('22', '用户查询', '用户查询', '/user/list', 'user:select', '21', '2', null, null, '1', '2021-01-25 16:47:57', '2021-01-25 16:47:57');
INSERT INTO `permission` VALUES ('23', '用户添加', '用户添加', '/user/add', 'user:insert', '21', '2', null, null, '1', '2021-01-25 16:48:49', '2021-01-25 16:48:49');
INSERT INTO `permission` VALUES ('24', '用户修改', '用户修改', '/user/update', 'user:update', '21', '2', null, null, '1', '2021-01-25 16:49:15', '2021-01-25 16:49:15');
INSERT INTO `permission` VALUES ('25', '用户删除', '用户删除', '/user/delete', 'user:delete', '21', '2', null, null, '1', '2021-01-26 17:23:26', '2021-01-26 17:23:26');
INSERT INTO `permission` VALUES ('26', '角色管理', '角色管理', '/role/list', '', '20', '1', '2', null, '1', '2021-01-29 10:12:15', '2021-01-29 10:12:15');
INSERT INTO `permission` VALUES ('27', '角色查询', '角色查询', '/role/list', 'role:select', '26', '2', null, null, '1', '2021-01-25 16:50:24', '2021-01-25 16:50:24');
INSERT INTO `permission` VALUES ('28', '角色添加', '角色添加', '/role/add', 'role:insert', '26', '2', null, null, '1', '2021-01-25 16:50:50', '2021-01-25 16:50:50');
INSERT INTO `permission` VALUES ('29', '角色修改', '角色修改', '/role/update', 'role:update', '26', '2', null, null, '1', '2021-01-25 16:53:29', '2021-01-25 16:53:29');
INSERT INTO `permission` VALUES ('30', '角色删除', '角色删除', '/role/delete', 'role:delete', '26', '2', null, null, '1', '2021-01-25 16:53:29', '2021-01-25 16:53:29');
INSERT INTO `permission` VALUES ('31', '权限管理', '权限管理', '/permission/list', '', '20', '1', '3', null, '1', '2021-01-29 10:13:22', '2021-01-29 10:13:22');
INSERT INTO `permission` VALUES ('32', '权限查询', '权限查询', '/permission/list', 'permission:select', '31', '2', null, null, '1', '2021-01-25 16:53:30', '2021-01-25 16:53:30');
INSERT INTO `permission` VALUES ('33', '权限添加', '权限添加', '/permission/add', 'permission:insert', '31', '2', null, null, '1', '2021-01-25 16:53:30', '2021-01-25 16:53:30');
INSERT INTO `permission` VALUES ('34', '权限修改', '权限修改', '/permission/update', 'permission:update', '31', '2', null, null, '1', '2021-01-25 16:53:31', '2021-01-25 16:53:31');
INSERT INTO `permission` VALUES ('35', '权限删除', '权限删除', '/permission/delete', 'permission:delete', '31', '2', null, null, '1', '2021-01-25 16:54:00', '2021-01-25 16:54:00');
INSERT INTO `permission` VALUES ('36', 'druid', 'druid', '/druid', null, '20', '1', null, null, '1', '2021-02-22 09:34:30', '2021-02-22 09:34:30');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `status` varchar(255) DEFAULT NULL COMMENT '状态 1有效 2删除',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '拥有所有权限', '1', '2021-01-25 15:39:49', '2021-01-25 15:39:49');
INSERT INTO `role` VALUES ('2', '普通员工', '拥有部分权限', '1', '2021-01-25 15:39:56', '2021-01-25 15:39:56');
INSERT INTO `role` VALUES ('7', 'putong', 'putong', '1', '2021-01-29 09:00:01', '2021-01-29 09:00:48');

-- ----------------------------
-- Table structure for rolepermission
-- ----------------------------
DROP TABLE IF EXISTS `rolepermission`;
CREATE TABLE `rolepermission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) DEFAULT NULL COMMENT '角色ID',
  `permissionid` int(11) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=377 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of rolepermission
-- ----------------------------
INSERT INTO `rolepermission` VALUES ('242', '2', '20');
INSERT INTO `rolepermission` VALUES ('243', '2', '26');
INSERT INTO `rolepermission` VALUES ('244', '2', '27');
INSERT INTO `rolepermission` VALUES ('252', '7', '20');
INSERT INTO `rolepermission` VALUES ('253', '7', '21');
INSERT INTO `rolepermission` VALUES ('254', '7', '22');
INSERT INTO `rolepermission` VALUES ('255', '7', '26');
INSERT INTO `rolepermission` VALUES ('256', '7', '27');
INSERT INTO `rolepermission` VALUES ('257', '7', '31');
INSERT INTO `rolepermission` VALUES ('258', '7', '32');
INSERT INTO `rolepermission` VALUES ('341', '1', '1');
INSERT INTO `rolepermission` VALUES ('342', '1', '2');
INSERT INTO `rolepermission` VALUES ('343', '1', '3');
INSERT INTO `rolepermission` VALUES ('344', '1', '4');
INSERT INTO `rolepermission` VALUES ('345', '1', '5');
INSERT INTO `rolepermission` VALUES ('346', '1', '6');
INSERT INTO `rolepermission` VALUES ('347', '1', '7');
INSERT INTO `rolepermission` VALUES ('348', '1', '8');
INSERT INTO `rolepermission` VALUES ('349', '1', '9');
INSERT INTO `rolepermission` VALUES ('350', '1', '10');
INSERT INTO `rolepermission` VALUES ('351', '1', '11');
INSERT INTO `rolepermission` VALUES ('352', '1', '12');
INSERT INTO `rolepermission` VALUES ('353', '1', '13');
INSERT INTO `rolepermission` VALUES ('354', '1', '14');
INSERT INTO `rolepermission` VALUES ('355', '1', '15');
INSERT INTO `rolepermission` VALUES ('356', '1', '16');
INSERT INTO `rolepermission` VALUES ('357', '1', '17');
INSERT INTO `rolepermission` VALUES ('358', '1', '18');
INSERT INTO `rolepermission` VALUES ('359', '1', '19');
INSERT INTO `rolepermission` VALUES ('360', '1', '20');
INSERT INTO `rolepermission` VALUES ('361', '1', '36');
INSERT INTO `rolepermission` VALUES ('362', '1', '21');
INSERT INTO `rolepermission` VALUES ('363', '1', '22');
INSERT INTO `rolepermission` VALUES ('364', '1', '23');
INSERT INTO `rolepermission` VALUES ('365', '1', '24');
INSERT INTO `rolepermission` VALUES ('366', '1', '25');
INSERT INTO `rolepermission` VALUES ('367', '1', '26');
INSERT INTO `rolepermission` VALUES ('368', '1', '27');
INSERT INTO `rolepermission` VALUES ('369', '1', '28');
INSERT INTO `rolepermission` VALUES ('370', '1', '29');
INSERT INTO `rolepermission` VALUES ('371', '1', '30');
INSERT INTO `rolepermission` VALUES ('372', '1', '31');
INSERT INTO `rolepermission` VALUES ('373', '1', '32');
INSERT INTO `rolepermission` VALUES ('374', '1', '33');
INSERT INTO `rolepermission` VALUES ('375', '1', '34');
INSERT INTO `rolepermission` VALUES ('376', '1', '35');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别 1男 2女',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `status` varchar(4) DEFAULT NULL COMMENT '用户状态 1有效 2删除',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `lastlogintime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123', 'asd123@qq.com', '1234', '男', '13', '1', '2021-02-23 08:57:29', '2021-02-23 08:57:29', '2021-02-23 08:57:29');
INSERT INTO `user` VALUES ('2', 'test', '123', 'asd123@qq.com', '1234', '女', '13', '1', '2021-02-23 08:57:22', '2021-02-23 08:57:22', '2021-02-23 08:57:22');
INSERT INTO `user` VALUES ('4', 'admin1', '123', 'asd123@qq.com', '1234', '女', '13', '2', '2021-02-23 17:39:20', '2021-02-23 17:39:20', '2021-02-23 17:39:20');

-- ----------------------------
-- Table structure for userrole
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL COMMENT '用户ID',
  `roleid` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES ('1', '1', '1');
INSERT INTO `userrole` VALUES ('2', '1', '2');
INSERT INTO `userrole` VALUES ('3', '2', '2');
INSERT INTO `userrole` VALUES ('11', '4', '7');
