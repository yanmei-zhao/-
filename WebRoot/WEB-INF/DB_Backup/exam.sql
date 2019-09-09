/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : exam

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-02-17 18:52:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `administrator_id` int(10) NOT NULL,
  `administrator_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `administrator_password` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`administrator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('1', 'lisi', '123');
INSERT INTO `administrator` VALUES ('2', 'admin', '123');

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
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(20) DEFAULT NULL,
  `grade` varchar(10) DEFAULT NULL,
  `institute` varchar(10) DEFAULT NULL,
  `class_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of class
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(10) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `creator` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `final_modifier` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '计算机', null, null, 'admin', 'daming');
INSERT INTO `course` VALUES ('2', '大学英语', null, null, 'admin', 'lisi');

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
  `class_name` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '班级名称',
  `teacher_name` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES ('12', '高等数学', '2019-02-14 14:49:28', '未发布', '2019-02-14 14:49:39', '900', '60', '16软件工程', 'lisi');
INSERT INTO `exam` VALUES ('13', '数学', '2019-02-04 00:00:00', '待审核', '2018-02-13 00:00:00', '3', '32', '32', 'lisi');

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
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES ('102', '计算机科学与技术', '2016级', '大数据与软件工程学院', '1');
INSERT INTO `group` VALUES ('103', '软件工程', '2016级', '大数据与软件工程学院', '1');
INSERT INTO `group` VALUES ('104', '汉语言文学', '2015级', '文学与传媒学院', '1');
INSERT INTO `group` VALUES ('106', '应用物理', '2016级', '电子与信息工程学院', '0');
INSERT INTO `group` VALUES ('107', '机械', '2015级', '机械与材料工程学院&化学与资源再利用学院', '0');
INSERT INTO `group` VALUES ('108', '电子工程', '2015级', '电子与信息工程学院', '0');

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
  `student_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `student_password` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `class_id` int(10) DEFAULT NULL,
  `class_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `student_number` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `grade` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('3', 'zym', '123', null, '计算机科学与技术', '201600201149', '2016级');
INSERT INTO `student` VALUES ('4', 'ly', '123', null, '计算机科学与技术', '201600201146', '2015级');
INSERT INTO `student` VALUES ('9', 'hyl', '123', null, '计算机科学与技术', '21600589', '2015级');

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
INSERT INTO `sysright` VALUES ('1', '教师', '', '1', '1');
INSERT INTO `sysright` VALUES ('2', '管理员', '', '2', '2');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` int(10) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `course_id` int(20) DEFAULT NULL,
  `class_id` int(20) DEFAULT NULL,
  `teacher_password` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'lisi', '3', '4', '123');
INSERT INTO `teacher` VALUES ('2', 'daming', '3', '5', '123');

-- ----------------------------
-- Table structure for testpaper
-- ----------------------------
DROP TABLE IF EXISTS `testpaper`;
CREATE TABLE `testpaper` (
  `testpaper_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '试卷id',
  `testpaper_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '试卷名称',
  `topic_id` int(20) DEFAULT NULL COMMENT '试题id',
  PRIMARY KEY (`testpaper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20029 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of testpaper
-- ----------------------------
INSERT INTO `testpaper` VALUES ('20018', '数学1', null);
INSERT INTO `testpaper` VALUES ('20022', '32', null);
INSERT INTO `testpaper` VALUES ('20027', '32', null);
INSERT INTO `testpaper` VALUES ('20028', '42', null);

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `topic_id` int(10) NOT NULL AUTO_INCREMENT,
  `topic_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `point_name` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_degree` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_types` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_a` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_b` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_c` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_d` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_answer_0` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_answer_1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_answer_2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_answer_3` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_answer` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `course_name` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teacher_name` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_bank_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_1` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_2` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_3` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_4` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_5` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_6` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_7` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option_8` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_score` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('25', '                1+1=?\r\n    \r\n    \r\n\r\n    \r\n    \r\n ', '算法', '常规', '单选题', '2', '23', '3', '1', '                                                                                  \r\n    \r\n    \r\n    ', null, null, null, 'A', '高数', 'daming', '高数1', '', '', '', '', null, null, null, null, null);
INSERT INTO `topic` VALUES ('26', '                        1=2=？\r\n    \r\n    \r\n    \r\n ', '哲学', '比较难', '多选题', '', '', '', '', '                                                                                              \r\n    ', null, null, null, 'A, B, C', '高数2', 'daming', '高数2', '3', '4', '6', '44', '34', null, null, null, null);
INSERT INTO `topic` VALUES ('27', '        32\r\n    ', '321', '常规', '问答题', '', '', '', '', '          3\r\n    32', null, null, null, null, '13', 'daming', '高数2', '', '', '', '', null, null, null, null, null);
INSERT INTO `topic` VALUES ('28', '   这是一种物理现象\r\n\r\n   \r\n    ', '而我', '常规', '判断题', '', '', '', '', '                                                                \r\n    \r\n    \r\n    \r\n    \r\n    \r\n    ', null, null, null, '错误', '惹我', 'daming', '应用物理', '', '', '', '', null, null, null, null, null);
INSERT INTO `topic` VALUES ('30', '    323', '23', '常规', '填空题', '', '', '', '', '    ', '32', null, null, null, '32', 'daming', '应用物理', '', '', '', '', null, null, null, null, null);
INSERT INTO `topic` VALUES ('31', '    23', '32', '常规', '单选题', '1', '2', '23', '3', '    ', null, null, null, 'A', '23', 'daming', '高数1', '', '', '', '', null, null, null, null, null);

-- ----------------------------
-- Table structure for topicbank
-- ----------------------------
DROP TABLE IF EXISTS `topicbank`;
CREATE TABLE `topicbank` (
  `topic_bank_id` int(11) NOT NULL,
  `topic_bank_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `topic_num` int(11) unsigned zerofill DEFAULT NULL,
  `creator` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `final_modifier` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`topic_bank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of topicbank
-- ----------------------------
INSERT INTO `topicbank` VALUES ('1', '高数1', '00000000000', 'admin', 'admin');
INSERT INTO `topicbank` VALUES ('2', '高数2', '00000000000', 'lisi', 'admin');
INSERT INTO `topicbank` VALUES ('3', '应用物理', '00000000000', 'lisi', 'lisi');
INSERT INTO `topicbank` VALUES ('4', '化学', '00000000000', 'lisi', 'lisi');
