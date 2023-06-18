/*
 Navicat MySQL Data Transfer

 Source Server         : 124.70.182.161_3306
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 124.70.182.161:3306
 Source Schema         : gamersoul

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 21/05/2022 14:45:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bought_games
-- ----------------------------
DROP TABLE IF EXISTS `bought_games`;
CREATE TABLE `bought_games`  (
  `user_id` bigint NOT NULL COMMENT '用户id号',
  `game_id` bigint NOT NULL COMMENT '游戏id号',
  `game_serial_number` bigint NOT NULL COMMENT '游戏序列号'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bought_games
-- ----------------------------

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `friend_id` bigint NULL DEFAULT NULL COMMENT '朋友id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES (3, 2, 3);
INSERT INTO `friend` VALUES (4, 2, 4);
INSERT INTO `friend` VALUES (5, 3, 4);
INSERT INTO `friend` VALUES (6, 3, 5);
INSERT INTO `friend` VALUES (9, 5, 1);
INSERT INTO `friend` VALUES (13, 1, 2);
INSERT INTO `friend` VALUES (14, 1, 4);

-- ----------------------------
-- Table structure for game
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game`  (
  `game_id` bigint NOT NULL AUTO_INCREMENT COMMENT '游戏id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '游戏名字',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '简介',
  `sale_count` bigint NULL DEFAULT NULL COMMENT '销量',
  `discount` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '折扣',
  `old_price` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '原价',
  `cur_price` double(10, 2) NULL DEFAULT NULL COMMENT '现价',
  `img_title_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '游戏海报',
  `status` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '游戏状态(推荐游戏、优惠游戏、新品游戏)',
  `small_imgs` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '小图片的链接路径',
  `mid_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '中段图片\r\n',
  PRIMARY KEY (`game_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of game
-- ----------------------------
INSERT INTO `game` VALUES (1, '双人成行', '游玩《双人成行》，踏上生命中最疯狂的旅程。利用好友通行证*邀请一位好友免费游玩，共同体验多种多样的乐趣，享受颠覆性的玩法挑战。', 2000, '无', '198.00', 198.00, 'imgs/it_takes_two.png', 'new', 'https://media.st.dl.pinyuncloud.com/steam/apps/1426210/ss_3e59753eefaba9a7704a18e902b48e8d38e95e0b.600x338.jpg?t=1643015238,https://media.st.dl.pinyuncloud.com/steam/apps/1426210/ss_fdac523e3ea4d2f32a44449bb8c224857563bd7d.600x338.jpg?t=1643015238,https://media.st.dl.pinyuncloud.com/steam/apps/1426210/ss_4a62bc8fa398fc5b2094a6225dc5ecff9485f824.600x338.jpg?t=1643015238,https://media.st.dl.pinyuncloud.com/steam/apps/1426210/ss_a15164ddd357ab3c0b2aff575a6b215b2d91b406.600x338.jpg?t=1643015238', '');
INSERT INTO `game` VALUES (2, 'The Beast Inside', '《The Beast Inside》是一款惊悚生存类恐怖游戏。你将扮演两个背负着阴暗过去的角色，揭开被埋藏的秘密、家族悲剧及人性中的疯狂。在3D实景扫描的场景中与敌人对峙，解开一个个谜题，体验令人战栗的恐惧。', 1000, '-42%', '220.00', 132.00, 'https://media.st.dl.pinyuncloud.com/steam/apps/792300/header.jpg?t=1646774135', '现已推出', 'https://media.st.dl.pinyuncloud.com/steam/apps/792300/ss_99e49e2a5e97e11cccf2e3fbedfc66a19532755c.600x338.jpg?t=1646774135,https://media.st.dl.pinyuncloud.com/steam/apps/792300/ss_e6c66be26549a130c56a2e210a61e205bd5dfb09.600x338.jpg?t=1646774135,https://media.st.dl.pinyuncloud.com/steam/apps/792300/ss_a7e59cd56b0df09dba730c96f023ff8856f00b93.600x338.jpg?t=1646774135,https://media.st.dl.pinyuncloud.com/steam/apps/792300/ss_776210f990b7d86f3eff819265f66cf864890327.600x338.jpg?t=1646774135', 'https://media.st.dl.pinyuncloud.com/steam/apps/792300/extras/ezgif-1-390faaa10e07.gif?t=1646774135');
INSERT INTO `game` VALUES (3, 'Dread Hunger', '这是一场关于生存与背叛的游戏。八位探险家将乘著船只航行过残酷的北极，而船上有两位叛徒呼唤了黑暗的力量，想陷害其他的探险家。', 600, '无', '90.00', 90.00, 'https://media.st.dl.pinyuncloud.com/steam/apps/1418630/ss_62aae690307c00937ba95b2f542148b1d244a847.600x338.jpg?t=1647100775', 'new', 'https://media.st.dl.pinyuncloud.com/steam/apps/1418630/ss_62aae690307c00937ba95b2f542148b1d244a847.600x338.jpg?t=1647100775,https://media.st.dl.pinyuncloud.com/steam/apps/1418630/ss_61b09a3418de995478818a946453cdcff7185809.600x338.jpg?t=1647100775,https://media.st.dl.pinyuncloud.com/steam/apps/1418630/ss_5990e94c5e19f8261f10c3b591c2a6f4a48ee7a8.600x338.jpg?t=1647100775,https://media.st.dl.pinyuncloud.com/steam/apps/1418630/ss_e288360023538c6a85745ff2070dc84003bdd8f5.600x338.jpg?t=1647100775', 'https://media.st.dl.pinyuncloud.com/steam/apps/1418630/extras/N0PNEWK_-_Imgur.gif?t=1647100775');
INSERT INTO `game` VALUES (4, 'Orcs Must Die! 3', '在玩家翘首以盼的《兽人必须死！》续作中，玩家可以使用武器和陷阱对付来犯的兽人大军。切碎它们！烧焦它们！电击它们', 600, '-41%', '152.00', 90.00, 'https://media.st.dl.pinyuncloud.com/steam/apps/1522820/header.jpg?t=1649351957', '现已推出', 'https://media.st.dl.pinyuncloud.com/steam/apps/1522820/ss_0c7c33c345a7a5d96246ce97a4d9cb87671cf134.600x338.jpg?t=1649351957,https://media.st.dl.pinyuncloud.com/steam/apps/1522820/ss_233f151eca027215270cd6133334971039cd5d1d.600x338.jpg?t=1649351957,https://media.st.dl.pinyuncloud.com/steam/apps/1522820/ss_9d2490f86172180c3b44d92ed3bf9e1af5839830.600x338.jpg?t=1649351957,https://media.st.dl.pinyuncloud.com/steam/apps/1522820/ss_7a775f23aeb51c70b5728979a408a6e9e1f3f9dc.600x338.jpg?t=1649351957', 'https://media.st.dl.pinyuncloud.com/steam/apps/1522820/extras/omd_steam_gif_v2.gif?t=1649351957');
INSERT INTO `game` VALUES (22, '爆炸大冒险', '很刺激', 800, '-10%', '40', 30.00, '/fb2dd1c6-25cc-4104-9cb4-2d2803e175d7.png', '', '/dffc5703-0ef7-4690-81cc-af33e69380f6.png', '');

-- ----------------------------
-- Table structure for game_comment
-- ----------------------------
DROP TABLE IF EXISTS `game_comment`;
CREATE TABLE `game_comment`  (
  `comment_id` bigint NOT NULL AUTO_INCREMENT,
  `game_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '游戏id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `parent_id` int NULL DEFAULT NULL COMMENT '上级评论id',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论',
  `urls` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论图片',
  `is_parent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否是父级评论',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of game_comment
-- ----------------------------
INSERT INTO `game_comment` VALUES (70, '1', 1, '帆帆', 0, '这游戏真好玩儿~', '/109fcecd-9f38-4f3a-aba8-650ea267cbea.png', '1');
INSERT INTO `game_comment` VALUES (71, '1', 1, '帆帆', 70, '真的吗！那我也下一个', '', '0');
INSERT INTO `game_comment` VALUES (72, '4', 1, '帆帆', 0, '这游戏真好玩儿！', '/39df8806-d3f3-425d-a41c-5b4ad9014228.png', '1');
INSERT INTO `game_comment` VALUES (73, '4', 1, '帆帆', 72, '真的吗，我也要下！', '', '0');

-- ----------------------------
-- Table structure for game_explain
-- ----------------------------
DROP TABLE IF EXISTS `game_explain`;
CREATE TABLE `game_explain`  (
  `explain_id` bigint NOT NULL AUTO_INCREMENT COMMENT '游戏说明',
  `game_id` bigint NULL DEFAULT NULL COMMENT '游戏id',
  `headline` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`explain_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of game_explain
-- ----------------------------
INSERT INTO `game_explain` VALUES (1, 1, '主要特色', '纯粹而完美的合作模式——通过远程同乐**邀请好友免费畅玩，体验一场纯粹为两位玩家打造的惊奇冒险。体验分屏显示模式，选择本地合作或在线联机，面对不断变化的挑战，团结一致是前进的唯一途径。搞笑又颠覆想像的游戏——从暴走的真空吸尘器到走心的爱情大师，您永远不会知道接下来会遇到什么。每个关卡都有大量别开生面的挑战和需要掌握的全新角色技能，体验故事和游戏交织的隐喻风格，推动互动式故事徐徐展开。');
INSERT INTO `game_explain` VALUES (2, 1, '关于 HAZELIGHT', 'Hazelight 位于瑞典斯德哥尔摩，是一家屡获殊荣的独立游戏开发工作室。在 2014 年由 Josef Fares（影片导演和获奖游戏《兄弟：双子传说》的创作者）创办，Hazelight 致力于推动游戏的创意界限。在 2018 年，Hazelight 发布了荣获 BAFTA 奖的游戏《A Way Out》——史上第一款第三人称动作-冒险合作游戏——这是 EA Originals 计划的一部分。');
INSERT INTO `game_explain` VALUES (3, 1, '关于 EA ORIGINALS', 'EA Originals 帮助全球充满热情,自成一格,才华横溢的游戏工作室崭露头角。发掘别出心裁的游戏制作者，探索他们天马行空的想象力，展现新颖而难忘的游戏体验。');
INSERT INTO `game_explain` VALUES (4, 4, '主要特色', '在《兽人必须死！3 》中体验前所未有的屠戮兽人的快感。玩家可以单人游戏也可以与同伴一起两人并肩作战。使用大量陷阱和武器来武装自己吧。在这部玩家翘首以盼的续作中，玩家可以使用武器和陷阱对付来犯的兽人大军。切碎它们！烧焦它们！电击它们！');
INSERT INTO `game_explain` VALUES (5, 4, '主要特色', '在《兽人必须死！3 》中体验前所未有的屠戮兽人的快感。玩家可以单人游戏也可以与同伴一起两人并肩作战。使用大量陷阱和武器来武装自己吧。在这部玩家翘首以盼的续作中，玩家可以使用武器和陷阱对付来犯的兽人大军。切碎它们！烧焦它们！电击它们！');
INSERT INTO `game_explain` VALUES (6, 4, '新增特色', '战争机器 - 你需要新的具有毁灭力量的武器来对抗兽人部落。战争机器是一种超大规模的陷阱。放下巨型翻转陷阱，让大批兽人跌得头昏眼花。装备超级火药桶发射器，让火焰燃尽一切');
INSERT INTO `game_explain` VALUES (7, 3, '在北极生存', '生火来取暖、击退狼与其他掠食动物，并且打猎以取得食物。一切都是为了在残忍无情的加拿大北极圈地区求生存。');
INSERT INTO `game_explain` VALUES (8, 3, '背叛您的朋友', '给他们吃受污染的食物、引诱动物攻击他们、用血液魔法诅咒他们，如果一切都失败...那就在他们背后放冷枪。');
INSERT INTO `game_explain` VALUES (9, 3, '成为一位船长', '驾驶一艘 19 世纪的军舰绕过 (或是撞上) 冰山。替永远吃不饱的锅炉寻找煤炭，让船继续前进...或是爆炸。');
INSERT INTO `game_explain` VALUES (10, 2, '成人内容描述', '开发者对内容描述如下：\r\n\r\n该游戏包括粗俗语言，暴力，血腥和虐待。');
INSERT INTO `game_explain` VALUES (11, 2, '剧情描述', '1979年，波士顿。中情局破译员亚当与妻子艾玛离开城市，来到宁静的乡间。他的上司担心他的人身安全，但亚当却认为，自己需要丛林间的静谧，以帮助自己破译苏联的军事密码。他的成功与否将左右冷战的局势。然而，这里却并不是他们期待的温馨家园……');

-- ----------------------------
-- Table structure for game_sort
-- ----------------------------
DROP TABLE IF EXISTS `game_sort`;
CREATE TABLE `game_sort`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `game_id` bigint NULL DEFAULT NULL,
  `sort_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of game_sort
-- ----------------------------
INSERT INTO `game_sort` VALUES (4, 2, 4);
INSERT INTO `game_sort` VALUES (5, 2, 6);
INSERT INTO `game_sort` VALUES (6, 4, 6);
INSERT INTO `game_sort` VALUES (7, 4, 2);
INSERT INTO `game_sort` VALUES (62, 1, 1);
INSERT INTO `game_sort` VALUES (63, 1, 2);
INSERT INTO `game_sort` VALUES (64, 1, 6);
INSERT INTO `game_sort` VALUES (65, 13, 1);
INSERT INTO `game_sort` VALUES (66, 13, 5);
INSERT INTO `game_sort` VALUES (67, 14, 1);
INSERT INTO `game_sort` VALUES (68, 14, 2);
INSERT INTO `game_sort` VALUES (69, 15, 2);
INSERT INTO `game_sort` VALUES (70, 15, 3);
INSERT INTO `game_sort` VALUES (71, 16, 2);
INSERT INTO `game_sort` VALUES (72, 16, 3);
INSERT INTO `game_sort` VALUES (76, 18, 1);
INSERT INTO `game_sort` VALUES (77, 18, 2);
INSERT INTO `game_sort` VALUES (78, 19, 1);
INSERT INTO `game_sort` VALUES (79, 19, 2);
INSERT INTO `game_sort` VALUES (80, 17, 2);
INSERT INTO `game_sort` VALUES (81, 17, 1);
INSERT INTO `game_sort` VALUES (82, 17, 3);
INSERT INTO `game_sort` VALUES (83, 20, 4);
INSERT INTO `game_sort` VALUES (86, 21, 3);
INSERT INTO `game_sort` VALUES (87, 22, 29);

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `img_id` bigint NOT NULL AUTO_INCREMENT COMMENT '小图片id',
  `game_id` int NULL DEFAULT NULL COMMENT '游戏id',
  `game_image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '游戏示例图片',
  PRIMARY KEY (`img_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES (1, 1, 'https://media.st.dl.pinyuncloud.com/steam/apps/1426210/ss_6ce2d50261a94284c72164e2d6d3721fe2f00013.600x338.jpg?t=1643015238');
INSERT INTO `image` VALUES (2, 1, 'https://media.st.dl.pinyuncloud.com/steam/apps/1426210/ss_a15164ddd357ab3c0b2aff575a6b215b2d91b406.600x338.jpg?t=1643015238');
INSERT INTO `image` VALUES (3, 1, 'https://media.st.dl.pinyuncloud.com/steam/apps/1426210/ss_3e59753eefaba9a7704a18e902b48e8d38e95e0b.600x338.jpg?t=1643015238');
INSERT INTO `image` VALUES (4, 1, 'https://media.st.dl.pinyuncloud.com/steam/apps/1426210/ss_d7a931229cbf1cc25975bb5860cbde5b9bbc826a.600x338.jpg?t=1643015238');
INSERT INTO `image` VALUES (5, 4, 'https://media.st.dl.pinyuncloud.com/steam/apps/1522820/ss_0c7c33c345a7a5d96246ce97a4d9cb87671cf134.600x338.jpg?t=1649351957');
INSERT INTO `image` VALUES (6, 4, 'https://media.st.dl.pinyuncloud.com/steam/apps/1522820/ss_9d2490f86172180c3b44d92ed3bf9e1af5839830.600x338.jpg?t=1649351957');
INSERT INTO `image` VALUES (7, 4, 'https://media.st.dl.pinyuncloud.com/steam/apps/1522820/ss_59e9806b4db46f539f7327d887694ee3fac3e984.600x338.jpg?t=1649351957');
INSERT INTO `image` VALUES (8, 4, 'https://media.st.dl.pinyuncloud.com/steam/apps/1522820/ss_abf9380dd511e9ce460029a1fa37641fa4f30d84.600x338.jpg?t=164935195');
INSERT INTO `image` VALUES (9, 2, 'https://media.st.dl.pinyuncloud.com/steam/apps/792300/ss_99e49e2a5e97e11cccf2e3fbedfc66a19532755c.600x338.jpg?t=1646774135');
INSERT INTO `image` VALUES (10, 2, 'https://media.st.dl.pinyuncloud.com/steam/apps/792300/ss_f3469ee1579a651d3f62f45e9d6af58abce4d24d.600x338.jpg?t=1646774135');
INSERT INTO `image` VALUES (11, 2, 'https://media.st.dl.pinyuncloud.com/steam/apps/792300/ss_a7e59cd56b0df09dba730c96f023ff8856f00b93.600x338.jpg?t=1646774135');
INSERT INTO `image` VALUES (12, 2, 'https://media.st.dl.pinyuncloud.com/steam/apps/792300/ss_776210f990b7d86f3eff819265f66cf864890327.600x338.jpg?t=1646774135');
INSERT INTO `image` VALUES (13, 3, 'https://media.st.dl.pinyuncloud.com/steam/apps/1418630/ss_62aae690307c00937ba95b2f542148b1d244a847.600x338.jpg?t=1647100775');
INSERT INTO `image` VALUES (14, 3, 'https://media.st.dl.pinyuncloud.com/steam/apps/1418630/ss_61b09a3418de995478818a946453cdcff7185809.600x338.jpg?t=1647100775');
INSERT INTO `image` VALUES (15, 3, 'https://media.st.dl.pinyuncloud.com/steam/apps/1418630/ss_5990e94c5e19f8261f10c3b591c2a6f4a48ee7a8.600x338.jpg?t=1647100775');
INSERT INTO `image` VALUES (16, 3, 'https://media.st.dl.pinyuncloud.com/steam/apps/1418630/ss_09f19269a851bbeb80c5f64dfdb8a83bdb4ffeef.600x338.jpg?t=1647100775');

-- ----------------------------
-- Table structure for navigation
-- ----------------------------
DROP TABLE IF EXISTS `navigation`;
CREATE TABLE `navigation`  (
  `nav_id` bigint NOT NULL AUTO_INCREMENT COMMENT '导航栏分类',
  `nav` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '导航栏分类',
  PRIMARY KEY (`nav_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of navigation
-- ----------------------------
INSERT INTO `navigation` VALUES (1, '游戏商城');
INSERT INTO `navigation` VALUES (2, '游戏分类');
INSERT INTO `navigation` VALUES (3, '热销游戏');
INSERT INTO `navigation` VALUES (4, '新品游戏');
INSERT INTO `navigation` VALUES (5, '优惠游戏');
INSERT INTO `navigation` VALUES (6, '游戏机和配件');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单号',
  `order_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单名称',
  `order_total` float NULL DEFAULT NULL COMMENT '订单总额',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `trade_status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '交易状态',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '兑换码',
  PRIMARY KEY (`order_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('20220521122319522', '我的订单', 180, 1, 'TRADE_SUCCESS', '5hyrY608lBO9LRrsBPZiQ9kmkC');

-- ----------------------------
-- Table structure for order_game
-- ----------------------------
DROP TABLE IF EXISTS `order_game`;
CREATE TABLE `order_game`  (
  `order_no` bigint NOT NULL COMMENT '订单号',
  `game_id` bigint NULL DEFAULT NULL COMMENT '游戏id',
  `game_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_game
-- ----------------------------
INSERT INTO `order_game` VALUES (20220521122319522, 4, NULL);
INSERT INTO `order_game` VALUES (20220521122319522, 3, NULL);

-- ----------------------------
-- Table structure for recommend
-- ----------------------------
DROP TABLE IF EXISTS `recommend`;
CREATE TABLE `recommend`  (
  `game_id` bigint NULL DEFAULT NULL COMMENT '游戏id',
  `headline` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '游戏小标题',
  `describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '游戏描述'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of recommend
-- ----------------------------

-- ----------------------------
-- Table structure for shopping_car
-- ----------------------------
DROP TABLE IF EXISTS `shopping_car`;
CREATE TABLE `shopping_car`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `game_id` bigint NULL DEFAULT NULL COMMENT '游戏id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shopping_car
-- ----------------------------
INSERT INTO `shopping_car` VALUES (3, 2, 1);
INSERT INTO `shopping_car` VALUES (4, 2, 4);
INSERT INTO `shopping_car` VALUES (7, 3, 3);
INSERT INTO `shopping_car` VALUES (8, 4, 2);
INSERT INTO `shopping_car` VALUES (9, 4, 3);
INSERT INTO `shopping_car` VALUES (12, 23, 1);
INSERT INTO `shopping_car` VALUES (14, 24, 1);

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort`  (
  `sort_id` bigint NOT NULL AUTO_INCREMENT COMMENT '类别id',
  `sort_title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类别',
  `sort_item` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类别子项',
  PRIMARY KEY (`sort_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sort
-- ----------------------------
INSERT INTO `sort` VALUES (1, '动作', '动作类Rogue');
INSERT INTO `sort` VALUES (2, '动作', '平台及奔跑');
INSERT INTO `sort` VALUES (3, '动作', '格斗及武术');
INSERT INTO `sort` VALUES (4, '动作', '清版动作');
INSERT INTO `sort` VALUES (5, '动作', '第一人称射击');
INSERT INTO `sort` VALUES (6, '动作', '第三人称射击');
INSERT INTO `sort` VALUES (7, '动作', '街机及节奏');
INSERT INTO `sort` VALUES (8, '角色扮演', '冒险角色扮演');
INSERT INTO `sort` VALUES (9, '角色扮演', '动作角色扮演');
INSERT INTO `sort` VALUES (10, '角色扮演', '回合制');
INSERT INTO `sort` VALUES (11, '角色扮演', '团队制');
INSERT INTO `sort` VALUES (12, '角色扮演', '日系角色扮演');
INSERT INTO `sort` VALUES (13, '角色扮演', '策略角色扮演');
INSERT INTO `sort` VALUES (14, '角色扮演', '类Rogue');
INSERT INTO `sort` VALUES (15, '策略', '军事');
INSERT INTO `sort` VALUES (16, '策略', '卡牌及桌游');
INSERT INTO `sort` VALUES (17, '策略', '回合制策略');
INSERT INTO `sort` VALUES (18, '策略', '城市及定居点');
INSERT INTO `sort` VALUES (19, '策略', '塔防');
INSERT INTO `sort` VALUES (20, '策略', '大战略及4X');
INSERT INTO `sort` VALUES (21, '冒险及休闲', '休闲');
INSERT INTO `sort` VALUES (22, '冒险及休闲', '冒险');
INSERT INTO `sort` VALUES (23, '冒险及休闲', '冒险角色扮演');
INSERT INTO `sort` VALUES (24, '冒险及休闲', '剧情丰富');
INSERT INTO `sort` VALUES (25, '冒险及休闲', '类银河战士恶魔城');
INSERT INTO `sort` VALUES (26, '冒险及休闲', '视觉小说');
INSERT INTO `sort` VALUES (27, '冒险及休闲', '解谜');
INSERT INTO `sort` VALUES (28, '模拟', '农场及制作');
INSERT INTO `sort` VALUES (29, '模拟', '太空及飞行');
INSERT INTO `sort` VALUES (30, '模拟', '建造及自动化');
INSERT INTO `sort` VALUES (31, '模拟', '恋爱');
INSERT INTO `sort` VALUES (32, '模拟', '沙盒及物理');
INSERT INTO `sort` VALUES (33, '模拟', '爱好与工作');
INSERT INTO `sort` VALUES (34, '模拟', '生活及沉浸式');
INSERT INTO `sort` VALUES (35, '体育及竞技', '体育模拟');
INSERT INTO `sort` VALUES (36, '体育及竞技', '单人运动');
INSERT INTO `sort` VALUES (37, '体育及竞技', '团队体育');
INSERT INTO `sort` VALUES (38, '体育及竞技', '所有运动');
INSERT INTO `sort` VALUES (39, '体育及竞技', '竞速');
INSERT INTO `sort` VALUES (40, '体育及竞技', '竞速模拟');
INSERT INTO `sort` VALUES (41, '体育及竞技', '钓鱼及狩猎');
INSERT INTO `sort` VALUES (42, '策略', '即时战略');
INSERT INTO `sort` VALUES (52, '动作', '即时策略');

-- ----------------------------
-- Table structure for sort_title
-- ----------------------------
DROP TABLE IF EXISTS `sort_title`;
CREATE TABLE `sort_title`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sort_title
-- ----------------------------
INSERT INTO `sort_title` VALUES (1, '动作');
INSERT INTO `sort_title` VALUES (2, '角色扮演');
INSERT INTO `sort_title` VALUES (3, '策略');
INSERT INTO `sort_title` VALUES (4, '冒险及休闲');
INSERT INTO `sort_title` VALUES (5, '模拟');
INSERT INTO `sort_title` VALUES (6, '体育及竞技');
INSERT INTO `sort_title` VALUES (10, 'slg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `mem_phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号码',
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `identity` bigint NULL DEFAULT NULL COMMENT '身份',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'hu', '13136376882', '123456', 1);
INSERT INTO `user` VALUES (2, 'he', '13276087172', '123456', 1);
INSERT INTO `user` VALUES (3, 'kun', NULL, '123456', 0);
INSERT INTO `user` VALUES (4, 'qiang', NULL, '123456', 1);
INSERT INTO `user` VALUES (21, '潇之恋', '13295013715', 'cx5201314', 1);
INSERT INTO `user` VALUES (22, '崔凯', '14796708097', '123456wap', 1);
INSERT INTO `user` VALUES (23, 'a123', '13489073976', '123456', 1);

-- ----------------------------
-- Table structure for user_detail
-- ----------------------------
DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail`  (
  `detail_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL COMMENT '用户id',
  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `grade` int NULL DEFAULT NULL COMMENT '用户等级',
  `nation_img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '国旗图片链接',
  `nation` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '国家',
  `user_avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像链接',
  `signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '个性签名',
  PRIMARY KEY (`detail_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_detail
-- ----------------------------
INSERT INTO `user_detail` VALUES (1, 2, '笑呵呵', '喝两瓶', 2, 'http://localhost:63342/gamersoul/static/1/Steam%20%E7%A4%BE%E5%8C%BA%20__%20%E8%80%81%E5%9D%A4%E8%B4%BC_files/hk.gif', '中国', '/4715fb4a-cd26-4955-8216-3974df567adc.png', '我太懒啦');
INSERT INTO `user_detail` VALUES (2, 3, 'kun', 'l林坤', 2, 'http://localhost:63342/gamersoul/static/1/Steam%20%E7%A4%BE%E5%8C%BA%20__%20%E8%80%81%E5%9D%A4%E8%B4%BC_files/hk.gif', '中国', 'imgs/hu_avatar.jpg', NULL);
INSERT INTO `user_detail` VALUES (3, 1, '啊帆', '胡帆', 6, 'http://localhost:63342/gamersoul/static/1/Steam%20%E7%A4%BE%E5%8C%BA%20__%20%E8%80%81%E5%9D%A4%E8%B4%BC_files/hk.gif', '中国', '/ee0f223e-7266-4ef1-b5ed-eefb3bc29d80.png', '这个人真的很懒！！');
INSERT INTO `user_detail` VALUES (4, 4, '强哥', '林强', 3, 'http://localhost:63342/gamersoul/static/1/Steam%20%E7%A4%BE%E5%8C%BA%20__%20%E8%80%81%E5%9D%A4%E8%B4%BC_files/hk.gif', '中国', '/83dce57b-c129-4dec-b5d3-7fd4526a4b12.png', '嘿嘿~');
INSERT INTO `user_detail` VALUES (5, 5, '杰', '文杰', 2, 'http://localhost:63342/gamersoul/static/1/Steam%20%E7%A4%BE%E5%8C%BA%20__%20%E8%80%81%E5%9D%A4%E8%B4%BC_files/hk.gif', '中国', 'imgs/hu_avatar.jpg', NULL);

-- ----------------------------
-- Table structure for user_game
-- ----------------------------
DROP TABLE IF EXISTS `user_game`;
CREATE TABLE `user_game`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `game_id` bigint NULL DEFAULT NULL COMMENT '用户购买的游戏',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_game
-- ----------------------------
INSERT INTO `user_game` VALUES (1, 1, 1);
INSERT INTO `user_game` VALUES (2, 1, 2);
INSERT INTO `user_game` VALUES (3, 1, 3);
INSERT INTO `user_game` VALUES (4, 2, 1);
INSERT INTO `user_game` VALUES (5, 2, 2);
INSERT INTO `user_game` VALUES (6, 3, 1);
INSERT INTO `user_game` VALUES (7, 3, 3);
INSERT INTO `user_game` VALUES (8, 4, 1);
INSERT INTO `user_game` VALUES (9, 4, 4);
INSERT INTO `user_game` VALUES (10, 5, 1);
INSERT INTO `user_game` VALUES (11, 5, 2);
INSERT INTO `user_game` VALUES (12, 5, 3);
INSERT INTO `user_game` VALUES (13, 5, 4);

-- ----------------------------
-- Table structure for user_game_active_code
-- ----------------------------
DROP TABLE IF EXISTS `user_game_active_code`;
CREATE TABLE `user_game_active_code`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `game_id` int NULL DEFAULT NULL,
  `active_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `game_active_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_game_active_code
-- ----------------------------

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `video_id` bigint NOT NULL AUTO_INCREMENT,
  `game_id` int NULL DEFAULT NULL COMMENT '游戏id',
  `game_video` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '游戏示例视频',
  PRIMARY KEY (`video_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (1, 1, 'https://media.st.dl.pinyuncloud.com/steam/apps/256827093/movie480_vp9.webm?t=1616514535,https://media.st.dl.pinyuncloud.com/steam/apps/256825938/movie480_vp9.webm?t=1615809022,https://media.st.dl.pinyuncloud.com/steam/apps/256813190/movie480_vp9.webm?t=16');
INSERT INTO `video` VALUES (2, 2, 'https://media.st.dl.pinyuncloud.com/steam/apps/256764339/movie480.webm?t=1571931095,https://media.st.dl.pinyuncloud.com/steam/apps/256764340/movie480.webm?t=1571931104,https://media.st.dl.pinyuncloud.com/steam/apps/256764894/movie480.webm?t=1571421972');
INSERT INTO `video` VALUES (3, 3, 'https://media.st.dl.pinyuncloud.com/steam/apps/256870834/movie480_vp9.webm?t=1643230899,https://media.st.dl.pinyuncloud.com/steam/apps/256829802/movie480_vp9.webm?t=1618373272,https://media.st.dl.pinyuncloud.com/steam/apps/256843217/movie480_vp9.webm?t=16');
INSERT INTO `video` VALUES (4, 4, 'https://media.st.dl.pinyuncloud.com/steam/apps/256842963/movie480_vp9.webm?t=1627049067,https://media.st.dl.pinyuncloud.com/steam/apps/256835791/movie480_vp9.webm?t=1623619680,https://media.st.dl.pinyuncloud.com/steam/apps/256833492/movie480_vp9.webm?t=16');
INSERT INTO `video` VALUES (5, 15, '阿的说法');
INSERT INTO `video` VALUES (6, 16, '');
INSERT INTO `video` VALUES (7, 17, '');
INSERT INTO `video` VALUES (8, 18, '');
INSERT INTO `video` VALUES (9, 19, '');
INSERT INTO `video` VALUES (10, 20, '');
INSERT INTO `video` VALUES (11, 21, '');
INSERT INTO `video` VALUES (12, 22, '');

SET FOREIGN_KEY_CHECKS = 1;
