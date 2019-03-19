 drop table if EXISTS product;
 drop table if EXISTS kufang;

 create table product(
 id  bigint PRIMARY KEY ,
 identifier varchar(255),
 name varchar(200),
 gg varchar(200),
 xh varchar(255)
 );

 create table kufang(
 id  bigint PRIMARY KEY ,
 identifier varchar(255),
 name varchar(200),
 bz varchar(2000)
 );

-- ----------------------------
-- Table structure for zy_user
-- ----------------------------
DROP TABLE IF EXISTS `zy_user`;
CREATE TABLE `zy_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `status` int(5) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_USERNAME` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_user
-- ----------------------------
INSERT INTO `zy_user` VALUES ('1', 'admin', '小豆丁', '123456', '1','1');

-- ----------------------------
-- Table structure for zy_role
-- ----------------------------
DROP TABLE IF EXISTS `zy_role`;
CREATE TABLE `zy_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(140) DEFAULT NULL,
  `name` varchar(32) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_role
-- ----------------------------
INSERT INTO `zy_role` VALUES ('1', null, 'admin', '0');

-- ----------------------------
-- Table structure for zy_permission
-- ----------------------------
DROP TABLE IF EXISTS `zy_permission`;
CREATE TABLE `zy_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(140) DEFAULT NULL,
  `name` varchar(32) NOT NULL,
  `parent_id` bigint(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `weight` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_NAME` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_permission
-- ----------------------------
INSERT INTO `zy_permission` VALUES ('1', '进入后台', 'admin', '0', '0', '0');
INSERT INTO `zy_permission` VALUES ('2', '栏目管理', 'channel:list', '0', '0', '0');
INSERT INTO `zy_permission` VALUES ('3', '编辑栏目', 'channel:update', '2', '0', '0');
INSERT INTO `zy_permission` VALUES ('4', '删除栏目', 'channel:delete', '2', '0', '0');
INSERT INTO `zy_permission` VALUES ('5', '文章管理', 'post:list', '0', '0', '0');
INSERT INTO `zy_permission` VALUES ('6', '编辑文章', 'post:update', '5', '0', '0');
INSERT INTO `zy_permission` VALUES ('7', '删除文章', 'post:delete', '5', '0', '0');
INSERT INTO `zy_permission` VALUES ('8', '评论管理', 'comment:list', '0', '0', '0');
INSERT INTO `zy_permission` VALUES ('9', '删除评论', 'comment:delete', '8', '0', '0');
INSERT INTO `zy_permission` VALUES ('10', '用户管理', 'user:list', '0', '0', '0');
INSERT INTO `zy_permission` VALUES ('11', '用户授权', 'user:role', '10', '0', '0');
INSERT INTO `zy_permission` VALUES ('12', '修改密码', 'user:pwd', '10', '0', '0');
INSERT INTO `zy_permission` VALUES ('13', '激活用户', 'user:open', '10', '0', '0');
INSERT INTO `zy_permission` VALUES ('14', '关闭用户', 'user:close', '10', '0', '0');
INSERT INTO `zy_permission` VALUES ('15', '角色管理', 'role:list', '0', '0', '0');
INSERT INTO `zy_permission` VALUES ('16', '修改角色', 'role:update', '15', '0', '0');
INSERT INTO `zy_permission` VALUES ('17', '删除角色', 'role:delete', '15', '0', '0');
INSERT INTO `zy_permission` VALUES ('18', '主题管理', 'theme:index', '0', '0', '0');
INSERT INTO `zy_permission` VALUES ('19', '系统配置', 'options:index', '0', '0', '0');
INSERT INTO `zy_permission` VALUES ('20', '修改配置', 'options:update', '19', '0', '0');
-- ----------------------------
-- Table structure for zy_user_role
-- ----------------------------
DROP TABLE IF EXISTS `zy_user_role`;
CREATE TABLE `zy_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_user_role
-- ----------------------------
INSERT INTO `zy_user_role` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for zy_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `zy_role_permission`;
CREATE TABLE `zy_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_role_permission
-- ----------------------------
INSERT INTO `zy_role_permission` VALUES ('1', '1', '1');
INSERT INTO `zy_role_permission` VALUES ('2', '2', '1');
INSERT INTO `zy_role_permission` VALUES ('3', '3', '1');
INSERT INTO `zy_role_permission` VALUES ('4', '4', '1');
INSERT INTO `zy_role_permission` VALUES ('5', '5', '1');
INSERT INTO `zy_role_permission` VALUES ('6', '6', '1');
INSERT INTO `zy_role_permission` VALUES ('7', '7', '1');
INSERT INTO `zy_role_permission` VALUES ('8', '8', '1');
INSERT INTO `zy_role_permission` VALUES ('9', '9', '1');
INSERT INTO `zy_role_permission` VALUES ('10', '10', '1');
INSERT INTO `zy_role_permission` VALUES ('11', '11', '1');
INSERT INTO `zy_role_permission` VALUES ('12', '12', '1');
INSERT INTO `zy_role_permission` VALUES ('13', '13', '1');
INSERT INTO `zy_role_permission` VALUES ('14', '14', '1');
INSERT INTO `zy_role_permission` VALUES ('15', '15', '1');
INSERT INTO `zy_role_permission` VALUES ('16', '16', '1');
INSERT INTO `zy_role_permission` VALUES ('17', '17', '1');
INSERT INTO `zy_role_permission` VALUES ('18', '18', '1');
INSERT INTO `zy_role_permission` VALUES ('19', '19', '1');
INSERT INTO `zy_role_permission` VALUES ('20', '20', '1');
