/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : exam

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-02-21 16:13:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `administrator_id` int(11) NOT NULL,
  `administrator_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `administrator_password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `userType` int(11) NOT NULL,
  PRIMARY KEY (`administrator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('1', 'lisi', '123', '3');
INSERT INTO `administrator` VALUES ('2', 'admin', '123', '3');

-- ----------------------------
-- Table structure for answersheet
-- ----------------------------
DROP TABLE IF EXISTS `answersheet`;
CREATE TABLE `answersheet` (
  `answersheet_id` int(11) NOT NULL AUTO_INCREMENT,
  `answersheet_topic_id` int(11) DEFAULT NULL,
  `answersheet_topic_answer` varchar(20) DEFAULT NULL,
  `answersheet_topic_fraction` varchar(10) DEFAULT NULL,
  `answersheet_fraction` varchar(10) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`answersheet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of answersheet
-- ----------------------------

-- ----------------------------
-- Table structure for choicetopic
-- ----------------------------
DROP TABLE IF EXISTS `choicetopic`;
CREATE TABLE `choicetopic` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `paper_id` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `difficulty` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(10) COLLATE utf8_unicode_ci DEFAULT '单选题',
  `knowledge` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_bank_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_a` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_b` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_c` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_d` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `answer` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creator` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_bank_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100012 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of choicetopic
-- ----------------------------
INSERT INTO `choicetopic` VALUES ('100001', null, '计算机网络是______相结合的产物', '非常容易', '单选题', '网络的分类', '计算机网络1', '计算机技术与通讯技术', '计算机技术与信息技术', '计算机技术与电子技术', '信息技术与通讯技术', 'B', 'lisi', null);
INSERT INTO `choicetopic` VALUES ('100002', null, '下列有关计算机网络叙述错误的是', '常规', '单选题', '计算机网络的形成与发展', '计算机网络1', '利用Internet网可以使用远程的超级计算中心的计算机资源', '建立计算机网络的最主要目的是实现资源共享', '建立计算机网络的最主要目的是实现资源共享', '以接入的计算机多少可以将网络划分为广域网、城域网和局域网', 'D', 'lisi', '1');
INSERT INTO `choicetopic` VALUES ('100003', null, ' 最早的（第一阶段）计算机网络系统，有几个主机', '常规', '单选题', '计算机网络的形成与发展', '计算机网络1', '1', '2', '10', '几十台', 'A', 'lisi', '1');
INSERT INTO `choicetopic` VALUES ('100004', null, ' ______被认为是Internet的前身', '常规', '单选题', '计算机网络的形成与发展', '计算机网络1', '万维网', 'ARPANET', 'HTTP ', 'HTTP ', 'B', 'lisi', '1');
INSERT INTO `choicetopic` VALUES ('100005', null, 'LAN通常是指______', '常规', '单选题', '网络的分类', '计算机网络1', '广域网', '局域网', '资源子网', '城域网', 'B', 'lisi', '1');
INSERT INTO `choicetopic` VALUES ('100006', null, ' 以下哪个不是网络拓扑结构', '常规', '单选题', '网络的分类', '计算机网络1', '总线型', '星型', '开放型', '环型', 'C', 'lisi', '1');
INSERT INTO `choicetopic` VALUES ('100007', null, '一 个学校内部网络一-般属于_ _', '常规', '单选题', '网络的分类', '计算机网络1', '城域网', '局域网', '广域网.', '互联网', 'B', 'lisi', '1');
INSERT INTO `choicetopic` VALUES ('100008', null, '将计算 机网络划分为局域网、城域网、广域网是按__ ___ 划分', '常规', '单选题', '网络的分类', '计算机网络1', '用途', '连接方式', '覆盖范围', '以上都不是', 'C', 'lisi', '1');
INSERT INTO `choicetopic` VALUES ('100009', null, '将计算机网络划分为 公用网和专用网是按        划分', '常规', '单选题', '网络的分类', '计算机网络1', '使用范围', '连接方式', '覆盖范围', '以上都不是', 'A', 'lisi', '1');
INSERT INTO `choicetopic` VALUES ('100010', null, '计算机网络的基本分类方法主要有两种: -种是根据网络所使用的传输技术;另一种是根\n据  _', '常规', '单选题', '网络的分类', '计算机网络1', '网络协议\n', '.网络操作系统类型', '覆盖范围与规模', '网络服务器类型与规模', 'C', 'lisi', '1');
INSERT INTO `choicetopic` VALUES ('100011', null, '属于不同城市的用户的计算机互相通信，他们组成的网络属于', '常规', '单选题', '网络的分类', '计算机网络1', '局域网', '城域网', '广域网.', '互联网', 'C', 'lisi', '1');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(10) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `creator` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `final_modifier` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '计算机网络', null, null, 'admin', 'lisi');

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `exam_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `exam_name` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '名称',
  `exam_start` timestamp NULL DEFAULT NULL COMMENT '开始时间',
  `exam_state` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '状态',
  `exam_end` timestamp NULL DEFAULT NULL COMMENT '结束时间',
  `exam_duration` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '时长',
  `total_people` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '总人数',
  `teacher_name` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `test_paper_id` int(11) DEFAULT NULL,
  `class_name` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '班级名称',
  PRIMARY KEY (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES ('17', '计算机网络测试', '2020-02-17 19:39:12', '通过', '2020-02-17 22:00:00', '120', '', 'lisi', '20064', '计算机科学与技术');
INSERT INTO `exam` VALUES ('18', '计算机网络', '2020-02-16 16:39:35', '通过', '2020-02-16 23:55:40', '120', '', 'lisi', '20065', '计算机科学与技术');
INSERT INTO `exam` VALUES ('24', '计算机网络测试', '2019-12-01 08:00:00', '通过', '2019-12-01 11:00:00', '120', '', 'lisi', '20064', null);

-- ----------------------------
-- Table structure for exampoint
-- ----------------------------
DROP TABLE IF EXISTS `exampoint`;
CREATE TABLE `exampoint` (
  `point_id` int(11) NOT NULL AUTO_INCREMENT,
  `point_content` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`point_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of exampoint
-- ----------------------------

-- ----------------------------
-- Table structure for examquestionanswer
-- ----------------------------
DROP TABLE IF EXISTS `examquestionanswer`;
CREATE TABLE `examquestionanswer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `answer_date` datetime DEFAULT NULL,
  `exam_id` int(11) DEFAULT NULL,
  `type` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of examquestionanswer
-- ----------------------------
INSERT INTO `examquestionanswer` VALUES ('112', 'A', '100005', '10004', null, '17', '单选题');
INSERT INTO `examquestionanswer` VALUES ('113', 'B', '100003', '10004', null, '17', '单选题');
INSERT INTO `examquestionanswer` VALUES ('114', 'D', '100002', '10004', null, '17', '单选题');
INSERT INTO `examquestionanswer` VALUES ('115', 'C', '100004', '10004', null, '17', '单选题');
INSERT INTO `examquestionanswer` VALUES ('116', 'B', '100001', '10004', null, '17', '单选题');
INSERT INTO `examquestionanswer` VALUES ('117', '354', '200005', '10004', null, '17', '填空题');
INSERT INTO `examquestionanswer` VALUES ('118', '34', '200003', '10004', null, '17', '填空题');
INSERT INTO `examquestionanswer` VALUES ('119', '432', '200004', '10004', null, '17', '填空题');
INSERT INTO `examquestionanswer` VALUES ('120', '54', '200001', '10004', null, '17', '填空题');
INSERT INTO `examquestionanswer` VALUES ('121', '55', '200002', '10004', null, '17', '填空题');
INSERT INTO `examquestionanswer` VALUES ('122', '45', '300003', '10004', null, '17', '简答题');
INSERT INTO `examquestionanswer` VALUES ('123', '454', '300004', '10004', null, '17', '简答题');
INSERT INTO `examquestionanswer` VALUES ('124', 'A', '100001', '10002', null, '18', '单选题');
INSERT INTO `examquestionanswer` VALUES ('125', 'D', '100002', '10002', null, '18', '单选题');
INSERT INTO `examquestionanswer` VALUES ('130', 'C', '100003', '10002', null, '18', '单选题');
INSERT INTO `examquestionanswer` VALUES ('131', 'A', '100004', '10002', null, '18', '单选题');
INSERT INTO `examquestionanswer` VALUES ('132', 'A', '100005', '10002', null, '18', '单选题');
INSERT INTO `examquestionanswer` VALUES ('133', '', '200001', '10002', null, '18', '填空题');
INSERT INTO `examquestionanswer` VALUES ('140', '', '200002', '10002', null, '18', '填空题');
INSERT INTO `examquestionanswer` VALUES ('141', '', '200003', '10002', null, '18', '填空题');
INSERT INTO `examquestionanswer` VALUES ('142', '', '200004', '10002', null, '18', '填空题');
INSERT INTO `examquestionanswer` VALUES ('143', '', '200005', '10002', null, '18', '填空题');
INSERT INTO `examquestionanswer` VALUES ('144', '', '300002', '10002', null, '18', '简答题');
INSERT INTO `examquestionanswer` VALUES ('145', '', '300003', '10002', null, '18', '简答题');
INSERT INTO `examquestionanswer` VALUES ('146', '', '300004', '10002', null, '18', '简答题');

-- ----------------------------
-- Table structure for examrequirement
-- ----------------------------
DROP TABLE IF EXISTS `examrequirement`;
CREATE TABLE `examrequirement` (
  `requirement_id` int(11) NOT NULL AUTO_INCREMENT,
  `point_id` int(11) DEFAULT NULL,
  `exam_content` varchar(100) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`requirement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of examrequirement
-- ----------------------------

-- ----------------------------
-- Table structure for exam_class
-- ----------------------------
DROP TABLE IF EXISTS `exam_class`;
CREATE TABLE `exam_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exam_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of exam_class
-- ----------------------------
INSERT INTO `exam_class` VALUES ('6', '18', '102');
INSERT INTO `exam_class` VALUES ('7', '18', '109');
INSERT INTO `exam_class` VALUES ('8', '18', '110');
INSERT INTO `exam_class` VALUES ('9', '17', '102');
INSERT INTO `exam_class` VALUES ('11', '24', '102');
INSERT INTO `exam_class` VALUES ('12', '24', '103');

-- ----------------------------
-- Table structure for filltopic
-- ----------------------------
DROP TABLE IF EXISTS `filltopic`;
CREATE TABLE `filltopic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_id` int(11) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `difficulty` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(50) COLLATE utf8_unicode_ci DEFAULT '填空题',
  `knowledge` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_bank_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `answer` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creator` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_bank_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=200011 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of filltopic
-- ----------------------------
INSERT INTO `filltopic` VALUES ('200001', null, '码元秒 是码元传输的速率单位，______是信息量的单位。', '常规', '填空题', '网络的分类', '计算机网络2', '比特', 'lisi', '2');
INSERT INTO `filltopic` VALUES ('200002', null, '从通信双方信息交互的方式来看，有三种基本方式，即______ 、全双工和半双\n工。', '常规', '填空题', '网络的分类', '计算机网络2', '单工', 'lisi', '2');
INSERT INTO `filltopic` VALUES ('200003', null, '802.3 局域网的MAC帧的最小长度是.64字节，MAC地址长度为 ______位。', '常规', '填空题', '网络的分类', '计算机网络2', '48', 'lisi', '2');
INSERT INTO `filltopic` VALUES ('200004', null, '标准化的DTE/DCE接口包括以下四个方面的特性:物理特性、______ 、\n功能特性、规程特性。', '常规', '填空题', '网络的分类', '计算机网络2', '机械特性', 'lisi', '2');
INSERT INTO `filltopic` VALUES ('200005', null, '以太网是局域网中应用最广泛的一种，它的介质访问控制方法采用的协议是______', '常规', '填空题', '网络的分类', '计算机网络2', 'CSMA/CD', 'lisi', '2');
INSERT INTO `filltopic` VALUES ('200006', null, 'CDMA系统中使用的多路复用技术是 ______ 。', '常规', '填空题', '网络的分类', '计算机网络2', '_码分多址', 'lisi', '2');
INSERT INTO `filltopic` VALUES ('200007', null, '设理想低通道信道带宽为3000Hz ,根据奈奎斯特(Nyquist)定理，最高码元传\n输速率为          波特。', '常规', '填空题', '网络的分类', '计算机网络2', '6000', 'lisi', '2');
INSERT INTO `filltopic` VALUES ('200008', null, 'IP 地址21.12.240.17的网络类别是.A类， 主机号是______  。', '常规', '填空题', '网络的分类', '计算机网络2', '12.240.17', 'lisi', '2');
INSERT INTO `filltopic` VALUES ('200009', null, '计算机网络最主要的两个性能指标是带宽和______   。', '常规', '填空题', '网络的分类', '计算机网络2', '时延.', 'lisi', '2');

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `class_id` int(10) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `grade` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `institute` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `student_number` int(50) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES ('102', '计算机科学与技术', '2016级', '大数据与软件工程学院', '1');
INSERT INTO `group` VALUES ('103', '制药工程', '2018级', '机械与材料工程学院&化学与资源再利用学院', '1');
INSERT INTO `group` VALUES ('106', '应用物理', '2016级', '电子与信息工程学院', '0');
INSERT INTO `group` VALUES ('107', '机械', '2015级', '机械与材料工程学院&化学与资源再利用学院', '0');
INSERT INTO `group` VALUES ('108', '电子工程', '2015级', '电子与信息工程学院', '0');
INSERT INTO `group` VALUES ('109', '软件工程', '2016级', '大数据与软件工程学院', '0');
INSERT INTO `group` VALUES ('110', '物联网', '2016级', '大数据与软件工程学院', '0');
INSERT INTO `group` VALUES ('111', '物联网', '2017级', '大数据与软件工程学院', '0');
INSERT INTO `group` VALUES ('112', '物联网', '2018级', '大数据与软件工程学院', '0');

-- ----------------------------
-- Table structure for judgetopic
-- ----------------------------
DROP TABLE IF EXISTS `judgetopic`;
CREATE TABLE `judgetopic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `difficulty` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci DEFAULT '判断题',
  `knowledge` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_bank_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `answer` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creator` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_bank_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=400000 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of judgetopic
-- ----------------------------
INSERT INTO `judgetopic` VALUES ('400001', 'ewrrw', '常规', '判断题', '34', '计算机', '错误', '34', '4');
INSERT INTO `judgetopic` VALUES ('400002', '6456', '常规', '判断题', '546', '计算机', '正确', 'lisi', '4');

-- ----------------------------
-- Table structure for multipletopic
-- ----------------------------
DROP TABLE IF EXISTS `multipletopic`;
CREATE TABLE `multipletopic` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `difficulty` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(10) COLLATE utf8_unicode_ci DEFAULT '多选题',
  `knowledge` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_bank_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_a` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_b` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_c` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_d` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `answer` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creator` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_bank_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=500001 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of multipletopic
-- ----------------------------
INSERT INTO `multipletopic` VALUES ('500001', '  34  ', '常规', '多选题', '34', '计算机1', '1', '2', '3', '34', 'A, C, D', 'lisi', '5');
INSERT INTO `multipletopic` VALUES ('500002', '  234', '常规', '多选题', '546', '计算机1', '3', '32', '3', '43', 'A, B', 'lisi', '5');
INSERT INTO `multipletopic` VALUES ('500003', '    以下哪个不是网络拓扑结构   ', '常规', '多选题', '网络的分类', '计算机1', '总线型', '星型', '开放型', '环型', 'A, B, C, D', 'lisi', '5');

-- ----------------------------
-- Table structure for statistics
-- ----------------------------
DROP TABLE IF EXISTS `statistics`;
CREATE TABLE `statistics` (
  `statistics_id` int(10) NOT NULL AUTO_INCREMENT,
  `pass_number` int(10) DEFAULT NULL,
  `now_number` int(10) DEFAULT NULL,
  `excellent_number` int(10) DEFAULT NULL,
  `total_people` int(10) DEFAULT NULL,
  `highest_score` int(10) DEFAULT NULL,
  `average_score` int(10) DEFAULT NULL,
  `lowest_score` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`statistics_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of statistics
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(10) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `student_password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `student_number` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `class_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `grade` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userType` int(10) NOT NULL DEFAULT '1',
  `class_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `group` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10009 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('10000', '祝佩文', '201600201150', '201600201150', '计算机科学与技术', '2016级', '1', '102');
INSERT INTO `student` VALUES ('10001', '晨晨', '201600201101', '201600201101', '计算机科学与技术', '2016级', '1', '102');
INSERT INTO `student` VALUES ('10002', '文文', '201600201102', '201600201102', '计算机科学与技术', '2016级', '1', '102');
INSERT INTO `student` VALUES ('10003', '小小', '201600201103', '201600201103', '计算机科学与技术', '2016级', '1', '102');
INSERT INTO `student` VALUES ('10004', '赵艳梅', '201600201149', '201600201149', '计算机科学与技术', '2016级', '1', '102');
INSERT INTO `student` VALUES ('10005', '张李梅', '201600201148', '201600201148', '计算机科学与技术', '2016级', '1', '102');
INSERT INTO `student` VALUES ('10006', '蒋海云', '201600201142', '201600201142', '计算机科学与技术', '2016级', '1', '102');
INSERT INTO `student` VALUES ('10007', '黄小娟', '201600201143', '201600201143', '计算机科学与技术', '2016级', '1', '102');
INSERT INTO `student` VALUES ('10008', '颜阳', '201600208229', '201600208229', '软件工程', '2016级', '1', '109');

-- ----------------------------
-- Table structure for studentexamscore
-- ----------------------------
DROP TABLE IF EXISTS `studentexamscore`;
CREATE TABLE `studentexamscore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exam_phase` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `exam_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `time_used` int(11) DEFAULT NULL,
  `exam_start` datetime DEFAULT NULL,
  `exam_end` datetime DEFAULT NULL,
  `exam_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of studentexamscore
-- ----------------------------
INSERT INTO `studentexamscore` VALUES ('5', '已交卷', '50', '18', '10003', null, null, null, '计算机网络');
INSERT INTO `studentexamscore` VALUES ('6', '最终得分', '60', '18', '10005', null, null, null, '计算机网络');
INSERT INTO `studentexamscore` VALUES ('7', '最终得分', '58', '17', '10008', null, null, null, '计算机网络测试');
INSERT INTO `studentexamscore` VALUES ('8', '已交卷', '90', '17', '10007', null, null, null, '计算机网络测试');
INSERT INTO `studentexamscore` VALUES ('9', '已交卷', '99', '17', '10008', null, null, null, '计算机网络测试');
INSERT INTO `studentexamscore` VALUES ('10', '最终得分', '28', '17', '10004', null, null, null, '计算机网络测试');
INSERT INTO `studentexamscore` VALUES ('13', '最终得分', '45', '18', '10002', null, null, null, '计算机网络');

-- ----------------------------
-- Table structure for sysright
-- ----------------------------
DROP TABLE IF EXISTS `sysright`;
CREATE TABLE `sysright` (
  `right_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `right_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `resourse_path` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `right_type` int(11) DEFAULT NULL,
  `right_sort_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`right_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sysright
-- ----------------------------
INSERT INTO `sysright` VALUES ('1', '学生', null, '1', '1');
INSERT INTO `sysright` VALUES ('2', '教师', '', '2', '2');
INSERT INTO `sysright` VALUES ('3', '管理员', '', '3', '3');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` int(10) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teacher_password` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userType` int(10) DEFAULT NULL,
  `course_id` int(20) DEFAULT NULL,
  `class_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'lisi', '123', '2', '3', '4');
INSERT INTO `teacher` VALUES ('2', 'daming', '123', '2', '3', '5');
INSERT INTO `teacher` VALUES ('3', '陈聪', null, '2', null, null);

-- ----------------------------
-- Table structure for testpaper
-- ----------------------------
DROP TABLE IF EXISTS `testpaper`;
CREATE TABLE `testpaper` (
  `testpaper_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '试卷id',
  `testpaper_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '试卷名称',
  `topic_id` int(20) DEFAULT NULL COMMENT '试题id',
  `total_score` int(11) DEFAULT NULL COMMENT '总分',
  `pass_score` int(11) DEFAULT NULL COMMENT '及格分数',
  `creator` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建者',
  `choice_per_score` int(11) DEFAULT NULL,
  `fill_per_score` int(11) DEFAULT NULL,
  `topic_per_score` int(11) DEFAULT NULL,
  PRIMARY KEY (`testpaper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20085 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of testpaper
-- ----------------------------
INSERT INTO `testpaper` VALUES ('20064', '计算机网络测试', null, '100', '60', 'lisi', '4', '5', '10');
INSERT INTO `testpaper` VALUES ('20065', '计算机网络', null, '100', '60', 'lisi', null, null, null);
INSERT INTO `testpaper` VALUES ('20084', '计算机网络测试', null, '115', '69', 'lisi', null, null, null);

-- ----------------------------
-- Table structure for testpaper_topic
-- ----------------------------
DROP TABLE IF EXISTS `testpaper_topic`;
CREATE TABLE `testpaper_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `testpaper_id` int(11) DEFAULT NULL,
  `topic_id` int(11) DEFAULT NULL,
  `choicetopic_id` int(11) DEFAULT NULL,
  `filltopic_id` int(11) DEFAULT NULL,
  `judgetopic_id` int(11) DEFAULT NULL,
  `multipletopic_id` int(11) DEFAULT NULL,
  `topic_type` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3A2A74EA990DDD5F` (`topic_id`),
  KEY `FK3A2A74EA44F272FF` (`testpaper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=841 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of testpaper_topic
-- ----------------------------
INSERT INTO `testpaper_topic` VALUES ('595', '20064', '300004', null, null, null, null, '简答题', '7');
INSERT INTO `testpaper_topic` VALUES ('597', '20064', '300002', null, null, null, null, '简答题', '10');
INSERT INTO `testpaper_topic` VALUES ('598', '20064', null, null, '200005', null, null, '填空题', '10');
INSERT INTO `testpaper_topic` VALUES ('599', '20064', null, null, '200006', null, null, '填空题', '10');
INSERT INTO `testpaper_topic` VALUES ('600', '20064', null, null, '200003', null, null, '填空题', '10');
INSERT INTO `testpaper_topic` VALUES ('601', '20064', null, null, '200004', null, null, '填空题', '10');
INSERT INTO `testpaper_topic` VALUES ('602', '20064', null, null, '200001', null, null, '填空题', '10');
INSERT INTO `testpaper_topic` VALUES ('603', '20064', null, '100005', null, null, null, '单选题', '5');
INSERT INTO `testpaper_topic` VALUES ('604', '20064', null, '100003', null, null, null, '单选题', '5');
INSERT INTO `testpaper_topic` VALUES ('605', '20064', null, '100002', null, null, null, '单选题', '5');
INSERT INTO `testpaper_topic` VALUES ('606', '20064', null, '100004', null, null, null, '单选题', '5');
INSERT INTO `testpaper_topic` VALUES ('607', '20064', null, '100001', null, null, null, '单选题', '5');
INSERT INTO `testpaper_topic` VALUES ('648', '20065', '300004', null, null, null, null, '简答题', '17');
INSERT INTO `testpaper_topic` VALUES ('649', '20065', '300005', null, null, null, null, '简答题', '18');
INSERT INTO `testpaper_topic` VALUES ('650', '20065', null, null, '200005', null, null, '填空题', '7');
INSERT INTO `testpaper_topic` VALUES ('651', '20065', null, null, '200006', null, null, '填空题', '7');
INSERT INTO `testpaper_topic` VALUES ('652', '20065', null, null, '200003', null, null, '填空题', '7');
INSERT INTO `testpaper_topic` VALUES ('653', '20065', null, null, '200004', null, null, '填空题', '7');
INSERT INTO `testpaper_topic` VALUES ('654', '20065', null, null, '200001', null, null, '填空题', '7');
INSERT INTO `testpaper_topic` VALUES ('820', '20084', '300002', null, null, null, null, '简答题', '10');
INSERT INTO `testpaper_topic` VALUES ('821', '20084', '300003', null, null, null, null, '简答题', '10');
INSERT INTO `testpaper_topic` VALUES ('822', '20084', null, null, '200009', null, null, '填空题', '5');
INSERT INTO `testpaper_topic` VALUES ('823', '20084', null, null, '200004', null, null, '填空题', '5');
INSERT INTO `testpaper_topic` VALUES ('824', '20084', null, null, '200008', null, null, '填空题', '5');
INSERT INTO `testpaper_topic` VALUES ('825', '20084', null, null, '200002', null, null, '填空题', '5');
INSERT INTO `testpaper_topic` VALUES ('826', '20084', null, null, '200007', null, null, '填空题', '5');
INSERT INTO `testpaper_topic` VALUES ('827', '20084', null, '100002', null, null, null, '单选题', '5');
INSERT INTO `testpaper_topic` VALUES ('828', '20084', null, '100007', null, null, null, '单选题', '5');
INSERT INTO `testpaper_topic` VALUES ('829', '20084', null, '100004', null, null, null, '单选题', '5');
INSERT INTO `testpaper_topic` VALUES ('830', '20084', null, '100003', null, null, null, '单选题', '5');
INSERT INTO `testpaper_topic` VALUES ('831', '20084', null, '100008', null, null, null, '单选题', '5');
INSERT INTO `testpaper_topic` VALUES ('832', '20084', null, '100005', null, null, null, '单选题', '5');
INSERT INTO `testpaper_topic` VALUES ('833', '20084', null, '100011', null, null, null, '单选题', '5');
INSERT INTO `testpaper_topic` VALUES ('834', '20084', null, '100006', null, null, null, '单选题', '5');
INSERT INTO `testpaper_topic` VALUES ('835', '20084', null, '100009', null, null, null, '单选题', '5');
INSERT INTO `testpaper_topic` VALUES ('836', '20084', null, '100010', null, null, null, '单选题', '5');
INSERT INTO `testpaper_topic` VALUES ('837', '20084', null, null, null, '400001', null, '判断题', '5');
INSERT INTO `testpaper_topic` VALUES ('838', '20084', null, null, null, '400002', null, '判断题', '5');
INSERT INTO `testpaper_topic` VALUES ('839', '20084', null, null, null, null, '500002', '多选题', '5');
INSERT INTO `testpaper_topic` VALUES ('840', '20084', null, null, null, null, '500003', '多选题', '5');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_id` int(11) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `difficulty` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(50) COLLATE utf8_unicode_ci DEFAULT '简答题',
  `knowledge` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_bank_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `answer` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `creator` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_bank_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `topic_ibfk_1` (`paper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=300018 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('300001', null, '通信系统必须具备的三个基本要素是', '常规', '简答题', '通信系统', '计算机网络3', '信源、通信媒体、信宿', 'lisi', '3');
INSERT INTO `topic` VALUES ('300002', null, ' TCP/IP网络中常用的距离矢量路由协议是', '常规', '简答题', '通信系统', '计算机网络3', ' RIP  ', 'lisi', '3');
INSERT INTO `topic` VALUES ('300003', null, ' 常用的传输介质中，带宽最宽、信号传输衰减最小、抗干扰能力最强的一类传输介质是', '常规', '简答题', '通信系统', '计算机网络3', '光纤 ', 'lisi', null);
INSERT INTO `topic` VALUES ('300004', null, '在OSI中，完成整个网络系统内连接工作，为上一层提供整个网络范围内两个终端用户之间数据传输通路工作的是', '常规', '简答题', '通信系统', '计算机网络3', '网络层 ', 'lisi', '3');
INSERT INTO `topic` VALUES ('300005', null, ' 计算机网络如果按作用范围进行分类', '常规', '简答题', '通信系统', '计算机网络3', '广域网（WAN）、局域网（LAN）和城域网 ', 'lisi', '3');

-- ----------------------------
-- Table structure for topicbank
-- ----------------------------
DROP TABLE IF EXISTS `topicbank`;
CREATE TABLE `topicbank` (
  `topic_bank_id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_bank_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `topic_num` int(11) unsigned zerofill DEFAULT NULL,
  `creator` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `final_modifier` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_bank_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`topic_bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of topicbank
-- ----------------------------
INSERT INTO `topicbank` VALUES ('1', '计算机网络1', '00000000000', 'admin', 'lisi', '单选题');
INSERT INTO `topicbank` VALUES ('2', '计算机网络2', '00000000000', 'lisi', 'lisi', '填空题');
INSERT INTO `topicbank` VALUES ('3', '计算机网络3', '00000000000', 'lisi', 'lisi', '简答题');
INSERT INTO `topicbank` VALUES ('4', '计算机', '00000000000', 'lisi', 'lisi', '判断题');
INSERT INTO `topicbank` VALUES ('5', '计算机1', '00000000000', 'lisi', 'lisi', '多选题');
