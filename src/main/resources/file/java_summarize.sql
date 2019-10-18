/*
 Navicat Premium Data Transfer

 Source Server         : 221
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 10.71.141.221:3306
 Source Schema         : java_summarize

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 18/10/2019 11:10:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for spring_cron_schedule
-- ----------------------------
DROP TABLE IF EXISTS `spring_cron_schedule`;
CREATE TABLE `spring_cron_schedule`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '定时任务名',
  `task_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务编号',
  `task_class` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '定时任务完整类名',
  `auto_start_up` tinyint(4) NULL DEFAULT NULL COMMENT '是否自动启动',
  `cron_expression` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'cron表达式',
  `task_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务描述',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态 1：正常 2：停用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of spring_cron_schedule
-- ----------------------------
INSERT INTO `spring_cron_schedule` VALUES (1, NULL, NULL, NULL, NULL, '*/20 * * * * ?', '动态打印', NULL, NULL, 1);
INSERT INTO `spring_cron_schedule` VALUES (2, NULL, NULL, NULL, NULL, '*/60 * * * * ?', 'add', NULL, NULL, 1);
INSERT INTO `spring_cron_schedule` VALUES (6, '动态添加定时任务', 'DynamicScheduledTask', 'com.lpan.java_summarize.bootschedule.dynamicscheduled.DynamicScheduledTask', 1, '*/2 * * * * ?', 'add dynamic', NULL, NULL, 1);

-- ----------------------------
-- Table structure for spring_scheduled_result
-- ----------------------------
DROP TABLE IF EXISTS `spring_scheduled_result`;
CREATE TABLE `spring_scheduled_result`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `task_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行结果',
  `start_date` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_date` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `detail_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细信息',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` datetime(0) NULL DEFAULT NULL,
  `address` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'liupp', '18', '2019-05-20 16:59:43', '西安');

SET FOREIGN_KEY_CHECKS = 1;
