/*
Navicat MySQL Data Transfer

Source Server         : 120.25.211.167
Source Server Version : 50635
Source Host           : 120.25.211.167:3306
Source Database       : larbook

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-06-13 06:33:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '登陆账号',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '登陆密码',
  `realname` varchar(18) NOT NULL DEFAULT '' COMMENT '真是姓名',
  `phone` varchar(15) NOT NULL DEFAULT '' COMMENT '手机号码',
  `sex` int(1) NOT NULL DEFAULT '0' COMMENT '性别(0保密，1女，2男)',
  `expire` int(1) NOT NULL DEFAULT '0' COMMENT '账号是否有效（0|1）',
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('19', 'qjw', '$2y$10$cMjk4jUJhSdhxbFcfdhwkOs0UIP/eJng1i9rtc04v8wqEKhFyNbiu', '', '', '0', '0');
INSERT INTO `admin` VALUES ('20', 'root', '$2y$10$DlG9nXOrSNSepbE6EwbGUO1kDlDewMsS1sXs1kMauwG.vFEiq/cl2', '', '', '0', '0');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '图书ID',
  `codeno` varchar(20) NOT NULL DEFAULT '' COMMENT '条码号',
  `checkno` varchar(20) NOT NULL DEFAULT '' COMMENT '检索号',
  `isbn` varchar(20) NOT NULL DEFAULT '' COMMENT 'ISBN号',
  `book_name` varchar(100) NOT NULL DEFAULT '' COMMENT '图书名称',
  `law_author` varchar(100) NOT NULL DEFAULT '' COMMENT '责任者',
  `author` varchar(100) NOT NULL DEFAULT '' COMMENT '作者',
  `pub_addr` varchar(100) NOT NULL DEFAULT '' COMMENT '出版社',
  `pub_loc` varchar(1000) NOT NULL DEFAULT '' COMMENT '出版地',
  `pub_datatime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '出版时间',
  `copyno` int(11) NOT NULL DEFAULT '0' COMMENT '副本数',
  `price` float NOT NULL DEFAULT '0' COMMENT '价格',
  `addres` varchar(1000) NOT NULL DEFAULT '' COMMENT '藏书地址',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '状态',
  `count` int(11) NOT NULL DEFAULT '0' COMMENT '库存总数',
  `note` varchar(1000) NOT NULL DEFAULT '' COMMENT '备注',
  `description` varchar(1000) NOT NULL DEFAULT '' COMMENT '图书描述',
  `pages` int(11) NOT NULL DEFAULT '0' COMMENT '页数',
  `author_intro` varchar(1000) NOT NULL DEFAULT '' COMMENT '作者简介',
  `createtime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '入库时间',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '所属类别',
  `picUrl` varchar(1000) NOT NULL DEFAULT '' COMMENT '图片url',
  `left_count` int(11) NOT NULL DEFAULT '0' COMMENT '可借数',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('64', '206744745', '00307442', '7805159572', '马克·吐温幽默演说集', '', '（美）马克·吐温王建华，王寅译', '上海社会科学院', '上海', '0000-00-00 00:00:00', '123', '65', '华中科技大学图书馆', '1', '345', '', '收《美国汪达尔人》、《认错了人》、《罗杰斯与铁路》等40余篇演说词。', '230', '', '0000-00-00 00:00:00', '82', 'http://202.112.150.126/index.php?client=szlib&isbn=9787111428046%20pbk%20/cover', '0');
INSERT INTO `book` VALUES ('65', '00307385', 'G25/686', '7-309-01310-7', '图书馆信息科学的理论与实践', '', '巴克兰德', '复旦大学出版社', '上海', '0000-00-00 00:00:00', '0', '10.5', '华中科技大学图书馆', '1', '0', '', '', '0', '', '0000-00-00 00:00:00', '82', 'http://202.112.150.126/index.php?client=szlib&isbn=9787564153861%20/cover', '0');
INSERT INTO `book` VALUES ('66', '00307385', 'G25/686', '7-309-01310-7', '图书馆信息科学的理论与实践', '', '巴克兰德', '复旦大学出版社', '上海', '0000-00-00 00:00:00', '0', '10.5', '华中科技大学图书馆', '1', '3', '', '', '0', '', '0000-00-00 00:00:00', '82', 'http://202.112.150.126/index.php?client=szlib&isbn=9787564134457/cover', '0');
INSERT INTO `book` VALUES ('67', '206744745', 'K562/5', '7-208-05523-8', '爱尔兰大饥荒', '', '', '上海人民出版社', '上海', '0000-00-00 00:00:00', '0', '29.8', '华中科技大学图书馆', '1', '0', '', '', '0', '', '0000-00-00 00:00:00', '82', 'http://202.112.150.126/index.php?client=szlib&isbn=9787115420114%20pbk%20/cover', '0');
INSERT INTO `book` VALUES ('68', '00307454', 'D82/211', '7-5006-1526-4', '蒋介石政府与纳粹德国 ', '', '柯伟林', '中国青年出版社', '北京', '0000-00-00 00:00:00', '0', '11.3', '华中科技大学图书馆', '1', '3', '', '', '0', '', '0000-00-00 00:00:00', '65', 'http://202.112.150.126/index.php?client=szlib&isbn=7115095795%200072132086/cover', '0');
INSERT INTO `book` VALUES ('69', '213580846', 'H319.4:I561/68', '978-7-111-25891-9', '当初我们两分别', '', '拜伦', '机械工业出版社', '北京', '0000-00-00 00:00:00', '0', '0', '华中科技大学图书馆', '1', '0', '本书精选浪漫主义文学泰斗拜伦的最经典篇章。', '本书精选浪漫主义文学泰斗拜伦的最经典篇章。', '0', '', '0000-00-00 00:00:00', '65', 'http://202.112.150.126/index.php?client=szlib&isbn=9787564122669%20pbk%20/cover', '0');
INSERT INTO `book` VALUES ('70', '00307439', 'B844/226', '7-309-01302-6', '成长与烦恼：青少年咨询手记', '', '王裕如、陆为之、马邦一', '复旦大学出版社', '上海', '0000-00-00 00:00:00', '0', '5.8', '华中科技大学图书馆', '1', '0', '', '通过几十个事例, 对青少年成长过程中关于代沟、异性交往、人生目标、社会适应等问题进行了探讨。', '0', '', '0000-00-00 00:00:00', '65', 'http://202.112.150.126/index.php?client=szlib&isbn=9787121198366%209787894326225/cover', '0');
INSERT INTO `book` VALUES ('71', '208243809', 'K825', '7-5065-4781-3', '聂荣臻元帅回忆录', '', '聂荣臻', '解放军出版社', '北京', '0000-00-00 00:00:00', '0', '0', '华中科技大学图书馆', '1', '0', '', '本书共分二十五章，内容分别为青少年时期、留法勤工俭学、回国参加大革命、南昌起义、广州起义、白区斗争、在中央革命根据地、长征、在陕北、开赴抗日前线等。', '0', '', '0000-00-00 00:00:00', '65', 'http://202.112.150.126/index.php?client=szlib&isbn=9787564159146%20pbk%20/cover', '0');
INSERT INTO `book` VALUES ('72', 'F4401050071588', 'TP312PH/4.v3', '9787564153878', ' PHP经典实例 ', '', 'Sklar, David.　Trachtenberg, Adam.', '东南大学出版社', '南京', '0000-00-00 00:00:00', '0', '0', '华中科技大学图书馆', '1', '0', '', '《PHP经典实例（影印版）》将PHP的特性与经典实例丛书的独特形式组合到一起，足以帮您成功地构建跨浏览器的Web应用程序。从初学者常见的问题到高级Web编程技术，这本包含了丰富的、具有实际应用价值的实例图书，可以满足使用PHP生成动态web内容的任何人的需要。', '0', '', '0000-00-00 00:00:00', '65', 'http://unicover.duxiu.com/coverNew/CoverNew.dll?iid=64646267696C626C696759A6A69F9C95A594A5AC59643132333132393533', '0');
INSERT INTO `book` VALUES ('73', 'xoj234', 'fkla234', '9787111362845', '三级数据库:全国计算机等级考试命题研究中心', '', '全国计算机等级考试命题研究中心 天合教育金版一考通研究中心', '北京;机械工业出版', '', '0000-00-00 00:00:00', '0', '0', '华中科技大学图书馆', '1', '0', '', '2012年全国计算机等级考试系列辅导用书——上机、笔试、智能软件三合一 2012年考试专用。　共分为“笔试考试试题”、“上机考试试题”、“笔试考试试题答案与解析”和“上机考试试题答案与解析”四个部分。', '0', '', '2017-02-06 05:06:55', '82', 'http://202.112.150.126/index.php?client=szlib&isbn=9787111362845/cover', '0');
INSERT INTO `book` VALUES ('75', 'jljfk03999', 'sdfjl3200993', '9787302305712', '大话数据库/ 邹茂扬，田洪川编著', '', '邹茂扬编著　田洪川编著', '北京:清华大学出版社 ', '', '0000-00-00 00:00:00', '0', '0', '华中科技大学图书馆', '1', '233242', '', '本书第一部分对于数据库的创建、备份、配置、安全等做详细介绍，通过这部分学习，可以掌握关系数据库的基础，以及对数据库的日常维护操作；本书第二部分对于分析项目需求，创建表，然后使用T-SQL语句和存储过程对表中数据做各种操作等做详细讲解，通过这一部分的学习，可以掌握对数据库的基本应用，熟练使用T-SQL语言建库、建表、T-SQL查询、高级检索、存储过程、性能优化技巧等。', '0', '', '2017-02-06 06:06:04', '82', 'http://202.112.150.126/index.php?client=szlib&isbn=9787302305712/cover', '32');

-- ----------------------------
-- Table structure for `book_bow`
-- ----------------------------
DROP TABLE IF EXISTS `book_bow`;
CREATE TABLE `book_bow` (
  `by_id` int(11) NOT NULL AUTO_INCREMENT,
  `reader_id` int(11) DEFAULT NULL COMMENT '读者id',
  `book_id` int(11) DEFAULT NULL COMMENT '图书id',
  `bow_time` datetime NOT NULL COMMENT '预约时间',
  `get_book_time` int(11) NOT NULL DEFAULT '0' COMMENT '取书时间(秒)',
  `get_book_addr` varchar(1000) NOT NULL DEFAULT '' COMMENT '取书地点',
  `zf_mon` float NOT NULL DEFAULT '0' COMMENT '缴纳押金',
  `get_book_num` varchar(50) NOT NULL DEFAULT '' COMMENT '取书号',
  PRIMARY KEY (`by_id`),
  KEY `book_bow2reader_id` (`reader_id`),
  KEY `book_bow2book_id` (`book_id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_bow
-- ----------------------------
INSERT INTO `book_bow` VALUES ('23', '1', '76', '2017-05-05 09:33:54', '28', '华中科技大学图书馆2', '10', 'u7HQUfgx');
INSERT INTO `book_bow` VALUES ('24', '1', '76', '2017-06-05 09:33:54', '28', '华中科技大学图书馆', '10', 'u7HQUfgx');
INSERT INTO `book_bow` VALUES ('31', '20', '64', '2017-06-09 06:35:48', '28', '华中科技大学图书馆', '0', 'NCy4kmvH');

-- ----------------------------
-- Table structure for `book_bow_j`
-- ----------------------------
DROP TABLE IF EXISTS `book_bow_j`;
CREATE TABLE `book_bow_j` (
  `bj_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `reader_id` int(11) DEFAULT NULL COMMENT '读者id',
  `book_id` int(11) DEFAULT NULL COMMENT '图书id',
  `get_book_addr` varchar(1000) NOT NULL DEFAULT '' COMMENT '借书地点',
  `get_book_time` datetime NOT NULL COMMENT '借书时间',
  `bow_book_time` int(11) NOT NULL DEFAULT '0' COMMENT '还书时间',
  PRIMARY KEY (`bj_id`),
  KEY `book_bow_j2reader_id` (`reader_id`),
  KEY `book_bow_j2book_id` (`book_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_bow_j
-- ----------------------------
INSERT INTO `book_bow_j` VALUES ('4', '19', '76', '华中科技大学图书馆', '2017-06-05 09:59:29', '28');
INSERT INTO `book_bow_j` VALUES ('5', '19', '76', '华中科技大学图书馆', '2017-06-05 10:03:00', '28');
INSERT INTO `book_bow_j` VALUES ('6', '19', '76', '华中科技大学图书馆', '2017-06-05 10:05:04', '28');
INSERT INTO `book_bow_j` VALUES ('7', '20', '75', '华中科技大学图书馆', '2017-06-09 06:11:52', '28');
INSERT INTO `book_bow_j` VALUES ('8', '20', '64', '华中科技大学图书馆', '2017-06-09 06:12:34', '28');
INSERT INTO `book_bow_j` VALUES ('9', '20', '73', '华中科技大学图书馆', '2017-06-09 06:36:27', '28');

-- ----------------------------
-- Table structure for `book_type`
-- ----------------------------
DROP TABLE IF EXISTS `book_type`;
CREATE TABLE `book_type` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID号',
  `t_name` varchar(100) NOT NULL DEFAULT '' COMMENT '分类名',
  `t_code` varchar(20) NOT NULL DEFAULT '' COMMENT '分类编号',
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '所属父类',
  `levels` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_type
-- ----------------------------
INSERT INTO `book_type` VALUES ('63', '思维科学', 'B80', '80', '209');
INSERT INTO `book_type` VALUES ('64', '逻辑学', 'B81', '51', '210');
INSERT INTO `book_type` VALUES ('79', '社会科学现状、概况', 'C1', '31', '301');
INSERT INTO `book_type` VALUES ('80', '机关、团体、会议', 'C2', '31', '302');
INSERT INTO `book_type` VALUES ('81', '社会科学研究方法', 'C3', '31', '303');
INSERT INTO `book_type` VALUES ('82', '编程', 'PR0112', '0', '0');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL DEFAULT '0' COMMENT '评论对应的图书ID',
  `reader_id` int(11) NOT NULL DEFAULT '0' COMMENT '评论人',
  `content` text NOT NULL COMMENT '评论内容',
  `maxStar` int(11) NOT NULL DEFAULT '0' COMMENT '最大星星',
  `minStar` int(11) NOT NULL DEFAULT '0' COMMENT '最少星星',
  `avgStar` int(11) NOT NULL DEFAULT '0' COMMENT '平均星星',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('2', '75', '12', '绝对是几米的代表作，之后各种小说、漫画、电影就出现一连串的“擦肩而过的故事', '12', '2', '3', '0000-00-00 00:00:00');
INSERT INTO `comment` VALUES ('4', '75', '13', '#重读#如今的我，彻底理解了男女主角的心情，想起13年前第一次阅读时的自己，天真无邪，“后来我们终于没有再相遇”，泪流满面。', '13', '2', '3', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for `reader_info`
-- ----------------------------
DROP TABLE IF EXISTS `reader_info`;
CREATE TABLE `reader_info` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `acount` varchar(20) NOT NULL DEFAULT '' COMMENT '读者证',
  `password` varchar(1000) NOT NULL DEFAULT '' COMMENT '密码(读者证登陆密码)',
  `wexin_num` int(11) NOT NULL DEFAULT '0' COMMENT '绑定微信号ID',
  `createtime` datetime NOT NULL COMMENT '绑定时间(获得借阅资格的时间)',
  `phone` varchar(15) NOT NULL DEFAULT '' COMMENT '手机号',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',
  `reader_type_id` int(11) NOT NULL DEFAULT '0' COMMENT '类型（读者类型，与借阅次数有关）id',
  `work_addr` varchar(1000) NOT NULL DEFAULT '' COMMENT '所在单位',
  `money` float NOT NULL DEFAULT '0' COMMENT '余额',
  `jifen` int(11) NOT NULL DEFAULT '0' COMMENT '积分',
  `book_browrr_times` int(11) NOT NULL DEFAULT '0' COMMENT '借阅次数',
  `expire_borower_times` int(11) NOT NULL DEFAULT '0' COMMENT '逾期次数',
  `fire_times` int(11) NOT NULL DEFAULT '0' COMMENT '罚款次数',
  `now_borrow_acount` int(11) NOT NULL DEFAULT '0' COMMENT '在借数量（未还的数量）',
  `real_name` varchar(20) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `face` varchar(1000) NOT NULL DEFAULT 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496981907498&di=2171936e61edc7ca3a67201b670efdfb&imgtype=0&src=http%3A%2F%2Fwww.lgmjg.com%2Fimg%2F338986.jpg',
  `nikename` varchar(100) NOT NULL DEFAULT '' COMMENT '昵称',
  PRIMARY KEY (`r_id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reader_info
-- ----------------------------
INSERT INTO `reader_info` VALUES ('12', '2', '', '3', '0000-00-00 00:00:00', '', '', '1', '', '0', '0', '0', '0', '0', '0', '覃家旺', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496983415836&di=acb104c009ffcd523e0fd395c8d85846&imgtype=0&src=http%3A%2F%2Fk2.jsqq.net%2Fuploads%2Fallimg%2F1705%2F7_170524143440_5.jpg', '碧落亦然');
INSERT INTO `reader_info` VALUES ('13', '2', '', '13', '0000-00-00 00:00:00', '', '', '0', '', '0', '0', '0', '0', '0', '0', 'LIMINF', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496993292896&di=39e0b72c355bb4c32c2c54a77eb392ee&imgtype=0&src=http%3A%2F%2Ftx.haiqq.com%2Fuploads%2Fallimg%2F150410%2F16491631P-13.jpg', '意闲');
INSERT INTO `reader_info` VALUES ('14', '2', '', '234', '0000-00-00 00:00:00', '', '', '0', '', '0', '0', '0', '0', '0', '0', '23', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496981907498&di=2171936e61edc7ca3a67201b670efdfb&imgtype=0&src=http%3A%2F%2Fwww.lgmjg.com%2Fimg%2F338986.jpg', '');
INSERT INTO `reader_info` VALUES ('15', '2', '', '234932423', '0000-00-00 00:00:00', '', '', '0', '', '0', '0', '0', '0', '0', '0', '23', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496981907498&di=2171936e61edc7ca3a67201b670efdfb&imgtype=0&src=http%3A%2F%2Fwww.lgmjg.com%2Fimg%2F338986.jpg', '');
INSERT INTO `reader_info` VALUES ('17', '2', '', '897892', '0000-00-00 00:00:00', '', '', '0', '', '0', '0', '0', '0', '0', '0', '23', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496981907498&di=2171936e61edc7ca3a67201b670efdfb&imgtype=0&src=http%3A%2F%2Fwww.lgmjg.com%2Fimg%2F338986.jpg', '');
INSERT INTO `reader_info` VALUES ('19', '2', '', '324', '0000-00-00 00:00:00', '', '', '1', '', '0', '0', '0', '0', '0', '0', '23', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496981907498&di=2171936e61edc7ca3a67201b670efdfb&imgtype=0&src=http%3A%2F%2Fwww.lgmjg.com%2Fimg%2F338986.jpg', '');
INSERT INTO `reader_info` VALUES ('20', 'admin', 'admin', '92341431', '0000-00-00 00:00:00', '', '', '1', '', '0', '0', '0', '0', '0', '0', '23', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496981907498&di=2171936e61edc7ca3a67201b670efdfb&imgtype=0&src=http%3A%2F%2Fwww.lgmjg.com%2Fimg%2F338986.jpg', '');

-- ----------------------------
-- Table structure for `reader_type`
-- ----------------------------
DROP TABLE IF EXISTS `reader_type`;
CREATE TABLE `reader_type` (
  `rt_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `type_code` varchar(255) NOT NULL DEFAULT '' COMMENT '类型编号',
  `note` varchar(1000) NOT NULL DEFAULT '' COMMENT '类型说明',
  `book_bow_m` int(11) NOT NULL DEFAULT '0' COMMENT '借书册数限制',
  `will_book_bow_m` int(11) NOT NULL DEFAULT '0' COMMENT '预约册数限制',
  `bow_time` int(11) NOT NULL DEFAULT '0' COMMENT '借期(秒)',
  `will_book_bow_times` int(11) NOT NULL DEFAULT '0' COMMENT '续借次数',
  `will_book_bow_time` int(11) NOT NULL DEFAULT '0' COMMENT '续借期限(秒)',
  `will_book_bow_maxtime` int(11) NOT NULL DEFAULT '0' COMMENT '最大续借次数(秒)',
  `h_days` int(11) NOT NULL DEFAULT '0' COMMENT '到期提前续借天数(天)',
  `xj_time` int(11) NOT NULL DEFAULT '0' COMMENT '续借时间(秒)',
  PRIMARY KEY (`rt_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reader_type
-- ----------------------------
INSERT INTO `reader_type` VALUES ('1', '1', '在职教职工、离退休人员、博士后', '30', '1', '56', '1', '28', '2', '7', '28');

-- ----------------------------
-- Table structure for `wchart_friend`
-- ----------------------------
DROP TABLE IF EXISTS `wchart_friend`;
CREATE TABLE `wchart_friend` (
  `w_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `acount` varchar(1000) NOT NULL COMMENT '微信号',
  PRIMARY KEY (`w_id`)
) ENGINE=MyISAM AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wchart_friend
-- ----------------------------
INSERT INTO `wchart_friend` VALUES ('11', 'oF2zD0mCtu8tBh_f8IpU9AjiBP2M');

-- ----------------------------
-- Table structure for `wchart_group`
-- ----------------------------
DROP TABLE IF EXISTS `wchart_group`;
CREATE TABLE `wchart_group` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT,
  `g_name` varchar(20) NOT NULL DEFAULT '' COMMENT '分组名称',
  PRIMARY KEY (`g_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wchart_group
-- ----------------------------

-- ----------------------------
-- Table structure for `wchart_menu`
-- ----------------------------
DROP TABLE IF EXISTS `wchart_menu`;
CREATE TABLE `wchart_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `m_name` varchar(10) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `expire` int(1) NOT NULL DEFAULT '0' COMMENT '是否启用(0不启用 1启用)',
  `m_type` varchar(50) NOT NULL DEFAULT '' COMMENT '菜单类型',
  `keyword` varchar(255) NOT NULL DEFAULT 'key' COMMENT '关键字',
  `linkname` varchar(50) NOT NULL DEFAULT '' COMMENT 'Url链接名称',
  `url` varchar(1000) NOT NULL DEFAULT '' COMMENT 'url',
  `level` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '父ID',
  `media_id` int(11) NOT NULL DEFAULT '0' COMMENT '调用新增永久素材接口返回的合法media_id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wchart_menu
-- ----------------------------
INSERT INTO `wchart_menu` VALUES ('1', '资源', '1', 'view', 'key', '', 'http://120.25.211.167/wchart/#/so', '0', '0', '0');
INSERT INTO `wchart_menu` VALUES ('2', '图书搜索', '1', 'view', 'key', '', 'http://120.25.211.167/wchart/#/so', '0', '1', '0');
INSERT INTO `wchart_menu` VALUES ('3', '扫码借还', '1', 'scancode_push', 'scancode', '', '', '0', '1', '0');
INSERT INTO `wchart_menu` VALUES ('4', '图书续借', '1', 'view', 'key', '', 'http://120.25.211.167/wchart/#/searchbook', '0', '1', '0');
INSERT INTO `wchart_menu` VALUES ('5', '微信帮助', '1', 'view', 'key', '', 'http://120.25.211.167/wchart/#/help', '0', '1', '0');
INSERT INTO `wchart_menu` VALUES ('6', '服务', '1', 'view', 'key', '', 'http://120.25.211.167/wchart/#/searchbook', '0', '0', '0');
INSERT INTO `wchart_menu` VALUES ('7', '新闻公告', '1', 'view', 'key', '', 'http://120.25.211.167/wchart/#/news', '0', '6', '0');
INSERT INTO `wchart_menu` VALUES ('8', '活动公告', '1', 'view', 'key', '', 'http://120.25.211.167/wchart/#/activity', '0', '6', '0');
INSERT INTO `wchart_menu` VALUES ('9', '读者帮助', '1', 'view', 'key', '', 'http://120.25.211.167/wchart/#/searchbook', '0', '6', '0');
INSERT INTO `wchart_menu` VALUES ('10', '位置导航', '1', 'view', 'key', '', 'http://map.qq.com/?type=bus', '0', '6', '0');
INSERT INTO `wchart_menu` VALUES ('11', '图书推荐', '1', 'view', 'key', '', 'http://120.25.211.167/wchart/#/searchbook', '0', '6', '0');
INSERT INTO `wchart_menu` VALUES ('12', '我的', '1', 'view', 'key', '', 'http://120.25.211.167/wchart/#/searchbook', '0', '0', '0');
INSERT INTO `wchart_menu` VALUES ('13', '借阅记录', '1', 'view', 'key', '', 'http://120.25.211.167/wchart/#/borrow', '0', '12', '0');
INSERT INTO `wchart_menu` VALUES ('14', '馆员助手', '1', 'view', 'key', '', 'http://120.25.211.167/wchart/#/home', '0', '12', '0');
INSERT INTO `wchart_menu` VALUES ('15', '历史操作', '1', 'view', 'key', '', 'http://120.25.211.167/wchart/#/history', '0', '12', '0');
INSERT INTO `wchart_menu` VALUES ('19', '绑定/解绑', '1', 'view', 'key', '', 'http://120.25.211.167/wchart/#/login', '0', '12', '0');
INSERT INTO `wchart_menu` VALUES ('18', '自习室预约', '1', 'view', 'key', '', 'http://120.25.211.167/wchart/#/searchbook', '0', '12', '0');
INSERT INTO `wchart_menu` VALUES ('20', '兴趣部落', '1', 'view', 'key', '', 'http://120.25.211.167/wchart/#/zoom', '0', '12', '0');
INSERT INTO `wchart_menu` VALUES ('21', '附近图书馆', '1', 'view', 'key', '', 'http://120.25.211.167/wchart/#/neiglibrary', '0', '12', '0');

-- ----------------------------
-- Table structure for `wchart_msg`
-- ----------------------------
DROP TABLE IF EXISTS `wchart_msg`;
CREATE TABLE `wchart_msg` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `eventtype` varchar(20) NOT NULL DEFAULT '',
  `keyword` varchar(20) NOT NULL DEFAULT '',
  `matchtype` varchar(20) NOT NULL DEFAULT '',
  `msgtype` varchar(20) NOT NULL DEFAULT '',
  `resid` int(11) NOT NULL DEFAULT '0',
  `content` varchar(1000) NOT NULL DEFAULT '',
  `createtime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`mid`)
) ENGINE=MyISAM AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wchart_msg
-- ----------------------------
INSERT INTO `wchart_msg` VALUES ('1', 'subscribe', '', '', '', '0', '欢迎关注 图书借阅伴侣 微信公众号,感谢您的关注! 这是关注消息', '0000-00-00 00:00:00');
INSERT INTO `wchart_msg` VALUES ('2', 'unsubscribe', '', '', '', '0', '取消关注', '0000-00-00 00:00:00');
INSERT INTO `wchart_msg` VALUES ('29', '', '查询图书', '', 'text', '0', '查询图书请点击下方工具栏 <资源>  <图书搜索> 您可了解到：1、该图书的馆藏地点和数量以及是否可外借 2、该图书外借情况', '2017-10-05 04:05:45');
INSERT INTO `wchart_msg` VALUES ('27', '', 'help', '', 'text', '0', '请您按提示，正确输入相关指令（输入汉字指令）。 1、查询 2、借书还书 3、帮助 4、关于 5、提出意见 6、联系管理员', '2017-10-05 04:05:43');
INSERT INTO `wchart_msg` VALUES ('28', '', '查询', '', 'text', '0', '1、查询相关图书的馆藏和借阅情况［查询图书］ 2、查询关于我的图书借阅情况［我的借阅］。 中括号内文本为相关指令！', '2017-10-05 04:05:44');
INSERT INTO `wchart_msg` VALUES ('30', '', '我的借阅', '', 'text', '0', '我的借阅请点击下方工具栏  <我的>  <历史操作> 您可了解到： 1、查询我的已借阅图书 2、查询我的图书归还时间 3、查询我的图书可否续借 4、查询我的超期罚款', '2017-10-05 04:05:46');
INSERT INTO `wchart_msg` VALUES ('31', '', '借书还书', '', 'text', '0', '请点击下方工具栏资源选择扫码借还或图书续借（按照您的需求进行选择），进入相关页面进行操作。', '2017-10-05 04:05:47');
INSERT INTO `wchart_msg` VALUES ('32', '', '帮助', '', 'text', '0', '1、如何在微信端扫码借书还书［扫码］ 2、扫码借书后如何去图书馆拿到自己的书［取书］ 3、在微信端还书后多长时间内将书归还至图书馆［还书］ 中括号内文本为相关指令！', '2017-10-05 04:05:48');
INSERT INTO `wchart_msg` VALUES ('33', '', '扫码', '', 'text', '0', '点击下方工具栏<资源><扫码借还>，进入相关页面后搜索到您需要的图书，获取二维码进行扫描，即可借书或还书（按照流程您将体验极速预约到书的快乐！）', '2017-10-05 04:05:48');
INSERT INTO `wchart_msg` VALUES ('34', '', '取书', '', 'text', '0', '微信端预借后，请在当天凭湖北文理学院一卡通（饭卡），前往指定地点取书，过期则您的借阅积分会被扣除，您需重新借阅，请珍惜大家的劳动。', '2017-10-05 04:05:50');
INSERT INTO `wchart_msg` VALUES ('35', '', '还书', '', 'text', '0', '微信端预还后，请在当天凭湖北文理学院一卡通（饭卡），前往指定地点还书，过期则您的借阅积分会被扣除，说不定有人在等着借您手中的书哦，共享公共资源。', '2017-10-05 04:05:51');
INSERT INTO `wchart_msg` VALUES ('36', '', '联系管理员', '', 'text', '0', '请致电661573或加微信号1qaz，将有工作人员竭诚为您服务，谢谢！', '2017-10-05 04:05:51');
INSERT INTO `wchart_msg` VALUES ('37', '', '关于', '', 'text', '0', '1、关于我校图书馆［图书馆］ 2、关于微信端图书借阅伴侣［借阅伴侣］ 中括号内文本为相关指令！', '2017-10-05 04:05:51');
INSERT INTO `wchart_msg` VALUES ('38', '', '图书馆', '', 'text', '0', '湖北文理学院图书馆始建于1999年，为邵逸夫先生捐赠，也称逸夫楼，图书馆分为ABC三区（西苑、中苑、东苑），主要分为阅览室、自习室等，馆藏书目达180万册。 谢谢您的关注！想要了解更多请登录。', '2017-10-05 04:05:52');
INSERT INTO `wchart_msg` VALUES ('39', '', '借阅伴侣', '', 'text', '0', '该款微信借阅伴侣是基于湖北文理学院图书馆（逸夫楼）全方位打造的，实现了微信在线预借、续借、归还以及相关的查阅信息，让您高效、方便地与图书馆保持交流。 多读书、多看报、少迷惘，多睡觉！感谢您的关注！', '2017-10-05 04:05:52');
INSERT INTO `wchart_msg` VALUES ('40', '', '提出意见', '', 'text', '0', '提出意见请在下方工具栏选择 <服务> <意见箱> 进行意见投放。您可以对馆藏的相关图书提出意见，还可以对我们的管理模式提出意见！', '2017-10-05 04:05:55');
INSERT INTO `wchart_msg` VALUES ('41', '', '书', '', 'text', '0', '书是人类进步的阶梯！我校图书馆馆藏书目180万册，总有一款适合您。输入help，我们将帮助您！', '2017-10-05 04:05:55');
INSERT INTO `wchart_msg` VALUES ('42', '', '书籍种类', '', 'text', '0', '我校藏书种类多样，涵盖面广，报刊书籍涉及到各个专业、各类兴趣。可进入<资源><图书搜索>进行查看！', '2017-10-05 04:05:56');
INSERT INTO `wchart_msg` VALUES ('43', '', '你好', '', 'text', '0', '您好！欢迎使用微信借阅伴侣，我们将竭诚为您服务！回复help获取相关指令回复！', '2017-10-05 04:05:57');
INSERT INTO `wchart_msg` VALUES ('44', '', '专业', '', 'text', '0', '社科新书借阅处，位于图书馆三楼中庭，目前我校流通的专业书籍，大多馆藏于此处，供学生借阅学习。您可在微信上进行查找预借！', '2017-10-05 05:05:05');
INSERT INTO `wchart_msg` VALUES ('45', '', '专业书', '', 'text', '0', '社科新书借阅处，位于图书馆三楼中庭，目前我校流通的专业书籍，大多馆藏于此处，供学生借阅学习。您可在微信上进行查找预借！', '2017-10-05 05:05:05');
INSERT INTO `wchart_msg` VALUES ('46', '', '导航', '', 'text', '0', '回复【图书馆】查询最近的图书馆位置。回复【我要去】', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for `wchart_setting`
-- ----------------------------
DROP TABLE IF EXISTS `wchart_setting`;
CREATE TABLE `wchart_setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `set_name` varchar(100) NOT NULL DEFAULT '' COMMENT '对象名称',
  `value` varchar(1000) NOT NULL DEFAULT '' COMMENT '对象的值',
  `note` varchar(1000) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wchart_setting
-- ----------------------------
INSERT INTO `wchart_setting` VALUES ('1', 'access_token', 'n2rsemt1Uwx0oQo5qyGLCm-EVUSOmDnSpIP2eW3asjAiO7K49FJA1xpxaePphPhLxHFJgmKAe03H3vT9401xiMU4R95gBEPO-u4lh71vyWdKq03fUukVLY7JCTbWONDPJFFeACASOO', '');
INSERT INTO `wchart_setting` VALUES ('2', 'appid', 'wxa6fc87e12b3cd9cf', '开发者中心-配置项-AppSecret(应用密钥)');
INSERT INTO `wchart_setting` VALUES ('3', 'secret', '18da5e0be63acbdc40121285fed2fb87', '');
INSERT INTO `wchart_setting` VALUES ('4', 'expire_time', '1497254204', '');
INSERT INTO `wchart_setting` VALUES ('5', 'token', 'weixin', '开发者中心-配置项-服务器配置-Token(令牌)');
INSERT INTO `wchart_setting` VALUES ('6', 'EncodingAESKey', 'nHwXBWpHHfcnwQUVohKl92XPDYxUMFNavBUtkdOIKN3', '开发者中心-配置项-服务器配置-EncodingAESKey(消息加解密密钥)');
