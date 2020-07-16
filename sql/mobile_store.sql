/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : mobile_store

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 16/07/2020 23:19:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for buyer_address
-- ----------------------------
DROP TABLE IF EXISTS `buyer_address`;
CREATE TABLE `buyer_address`  (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `buyer_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家地址',
  `area_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址编码',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`address_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收货地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of buyer_address
-- ----------------------------
INSERT INTO `buyer_address` VALUES (1, '机器人', '13654879212', '广东省广州市荔湾区XX街道XX小区', '440103', '2020-07-16 12:01:13', '2020-07-15 23:17:28');
INSERT INTO `buyer_address` VALUES (2, '蟑螂恶霸', '13888888888', '北京市北京市西城区XX胡同', '110102', '2020-07-16 12:02:00', '2020-07-16 12:02:00');
INSERT INTO `buyer_address` VALUES (3, '测试', '19922222222', '江苏省常州市天宁区XX小区', '320402', '2020-07-16 12:24:42', '2020-07-16 12:24:42');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类目名称',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`category_id`) USING BTREE,
  UNIQUE INDEX `uqe_category_type`(`category_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '类目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '手机', 1, '2020-04-01 18:39:43', '2020-07-15 16:50:28');
INSERT INTO `category` VALUES (2, '平板', 2, '2020-04-01 18:39:43', '2020-07-15 16:50:32');
INSERT INTO `category` VALUES (3, '电脑', 3, '2020-04-01 18:39:43', '2020-07-15 16:50:35');

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `price` decimal(8, 2) NOT NULL COMMENT '商品单价',
  `description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `stock` int(11) NOT NULL COMMENT '库存',
  `icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '小图',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `tag` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES (1, 'iPhone 11', 5499.00, 'iPhone 11是美国苹果公司于北京时间2019年9月11日凌晨1点在史蒂夫·乔布斯剧院发布的iPhone手机', 24, 'http://i2.tiimg.com/721094/dd815599232a2de9.png', 1, '2020-07-16 18:03:08', '2020-07-16 23:17:35', 'A13仿生&6.1英寸');
INSERT INTO `info` VALUES (2, 'iPhone 11 Pro Max', 9599.00, 'iPhone 11 Pro Max采用6.5英寸OLED显示屏，后置“浴霸”三摄系统', 80, 'http://i2.tiimg.com/721094/37343adf659cbaa7.png', 1, '2020-07-16 18:03:08', '2020-07-16 23:17:43', 'A13仿生&6.5英寸');
INSERT INTO `info` VALUES (3, 'iPhone 11 Pro', 8699.00, 'iPhone 11 Pro是美国Apple（苹果公司）第一台命名为Pro的手机，采用后置三摄设计', 16, 'http://i2.tiimg.com/721094/1e13e50751393be2.png', 1, '2020-07-16 18:14:54', '2020-07-16 23:17:54', 'A13仿生&6.5英寸');
INSERT INTO `info` VALUES (6, 'HUAWEI P30', 2788.00, '华为P30，是华为公司旗下一款手机。手机搭载海思Kirin 980处理器，屏幕为6.1英寸', 184, 'http://i1.fuimg.com/721094/7ef02082f4c082bd.jpg', 1, '2020-07-16 18:14:54', '2020-07-16 23:18:01', '麒麟980&6.1英寸');
INSERT INTO `info` VALUES (7, 'HUAWEI Mate X', 28999.00, '华为Mate X是华为公司研发的5G折叠屏手机，采用可折叠全面屏设计，可实现0-180度自由翻折。', 77, 'http://i1.fuimg.com/721094/2a4b06cbfdabecd3.jpg', 1, '2020-07-16 18:14:54', '2020-07-16 23:18:12', '麒麟980+巴龙5000&6.6英寸');
INSERT INTO `info` VALUES (8, 'iPad Pro', 6229.00, '2020年3月18日，苹果公司在其官网公布了2020款11英寸与12.9英寸iPad Pro。', 250, 'http://i1.fuimg.com/721094/5c3f228a5780572d.jpg', 2, '2020-07-16 11:29:16', '2020-07-16 23:18:18', 'A12Z Bionic芯片&12.9英寸');
INSERT INTO `info` VALUES (20, 'HUAWEI MatePad Pro', 3299.00, '由华为研发的平板电脑', 53, 'http://i1.fuimg.com/721094/72a5265f6ac08e7c.jpg', 2, '2020-07-16 11:31:13', '2020-07-16 23:18:25', '麒麟990&10.8英寸');
INSERT INTO `info` VALUES (21, 'MacBook Pro 2019', 12488.00, '新 MacBook Pro 采用窄边框设计，搭载一块 16 英寸分辨率达到 3072×1920 屏幕', 220, 'http://i1.fuimg.com/721094/4968918f60b5306c.png', 3, '2020-07-16 11:36:28', '2020-07-16 23:18:28', '第9代i7&16 英寸 ');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `buyer_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家地址',
  `goods_id` int(11) NULL DEFAULT NULL COMMENT '商品编号',
  `goods_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goods_quantity` int(11) NULL DEFAULT NULL COMMENT '商品数量',
  `goods_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品小图',
  `specs_id` int(11) NULL DEFAULT NULL COMMENT '规格编号',
  `specs_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '规格名称',
  `specs_price` decimal(12, 2) NULL DEFAULT NULL COMMENT '规格单价',
  `order_amount` decimal(8, 2) NOT NULL COMMENT '订单总金额',
  `pay_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '支付状态，默认0未支付',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1594872902246125324', '蟑螂恶霸', '13888888888', '北京市北京市西城区XX胡同', 2, 'iPhone 11 Pro Max', 3, 'http://i2.tiimg.com/721094/37343adf659cbaa7.png', 7, '512GB', 1199900.00, 36007.00, 0, '2020-07-16 18:03:08', '2020-07-16 11:15:14');
INSERT INTO `order_master` VALUES ('1594873120637747369', '蟑螂恶霸', '13888888888', '北京市北京市西城区XX胡同', 2, 'iPhone 11 Pro Max', 5, 'http://i2.tiimg.com/721094/37343adf659cbaa7.png', 7, '512GB', 1199900.00, 60005.00, 1, '2020-07-16 18:03:08', '2020-07-16 12:19:04');
INSERT INTO `order_master` VALUES ('1594873262123838927', '蟑螂恶霸', '13888888888', '北京市北京市西城区XX胡同', 20, 'HUAWEI MatePad Pro', 2, 'http://i1.fuimg.com/721094/72a5265f6ac08e7c.jpg', 15, '128GB', 439900.00, 8808.00, 0, '2020-07-16 11:31:13', '2020-07-16 11:33:06');
INSERT INTO `order_master` VALUES ('1594873484427494339', '测试', '19922222222', '江苏省常州市天宁区XX小区', 20, 'HUAWEI MatePad Pro', 2, 'http://i1.fuimg.com/721094/72a5265f6ac08e7c.jpg', 15, '128GB', 439900.00, 8808.00, 1, '2020-07-16 11:31:13', '2020-07-16 12:24:48');
INSERT INTO `order_master` VALUES ('1594873512221843363', '蟑螂恶霸', '13888888888', '北京市北京市西城区XX胡同', 6, 'HUAWEI P30', 2, 'http://i1.fuimg.com/721094/7ef02082f4c082bd.jpg', 9, '512GB', 340000.00, 6810.00, 1, '2020-07-16 18:14:54', '2020-07-16 12:25:16');
INSERT INTO `order_master` VALUES ('1594891277002253502', '测试', '19922222222', '江苏省常州市天宁区XX小区', 21, 'MacBook Pro 2019', 1, 'http://i1.fuimg.com/721094/4968918f60b5306c.png', 17, '512GB SSD', 1648800.00, 16498.00, 0, '2020-07-16 11:36:28', '2020-07-16 11:38:02');
INSERT INTO `order_master` VALUES ('1594891308595464691', '蟑螂恶霸', '13888888888', '北京市北京市西城区XX胡同', 3, 'iPhone 11 Pro', 2, 'http://i2.tiimg.com/721094/1e13e50751393be2.png', 5, '512GB', 949900.00, 19008.00, 0, '2020-07-16 18:14:54', '2020-07-16 11:19:49');
INSERT INTO `order_master` VALUES ('1594912326007709773', '蟑螂恶霸', '13888888888', '北京市北京市西城区XX胡同', 7, 'HUAWEI Mate X', 1, 'http://i1.fuimg.com/721094/2a4b06cbfdabecd3.jpg', 10, '128GB', 2899900.00, 29009.00, 1, '2020-07-16 18:14:54', '2020-07-16 23:12:08');
INSERT INTO `order_master` VALUES ('1594912344959572777', '蟑螂恶霸', '13888888888', '北京市北京市西城区XX胡同', 1, 'iPhone 11', 1, 'http://i2.tiimg.com/721094/dd815599232a2de9.png', 2, '128GB', 649900.00, 6509.00, 1, '2020-07-16 18:03:08', '2020-07-16 23:12:27');
INSERT INTO `order_master` VALUES ('1594912722334186081', '测试', '19922222222', '江苏省常州市天宁区XX小区', 2, 'iPhone 11 Pro Max', 2, 'http://i2.tiimg.com/721094/37343adf659cbaa7.png', 7, '512GB', 1199900.00, 24008.00, 1, '2020-07-16 18:03:08', '2020-07-16 23:18:44');
INSERT INTO `order_master` VALUES ('1594912752420661346', '蟑螂恶霸', '13888888888', '北京市北京市西城区XX胡同', 2, 'iPhone 11 Pro Max', 1, 'http://i2.tiimg.com/721094/37343adf659cbaa7.png', 6, '128GB', 959900.00, 9609.00, 1, '2020-07-16 18:03:08', '2020-07-16 23:19:14');

-- ----------------------------
-- Table structure for specs
-- ----------------------------
DROP TABLE IF EXISTS `specs`;
CREATE TABLE `specs`  (
  `specs_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `specs_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规格名称',
  `specs_stock` int(11) NOT NULL COMMENT '库存',
  `specs_price` decimal(11, 2) NOT NULL COMMENT '单价',
  `specs_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '小图',
  `specs_preview` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '预览图',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`specs_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品规格表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of specs
-- ----------------------------
INSERT INTO `specs` VALUES (1, '1', '64GB', 23, 549900.00, 'http://i2.tiimg.com/721094/dd815599232a2de9.png', 'http://i2.tiimg.com/721094/dd815599232a2de9.png', '2020-07-16 23:13:20', '2020-04-01 22:16:36');
INSERT INTO `specs` VALUES (2, '1', '128GB', 1, 649900.00, 'http://i2.tiimg.com/721094/dd815599232a2de9.png', 'http://i2.tiimg.com/721094/dd815599232a2de9.png', '2020-07-16 11:51:21', '2020-04-01 22:16:36');
INSERT INTO `specs` VALUES (3, '1', '512GB', 0, 730000.00, 'http://i2.tiimg.com/721094/dd815599232a2de9.png', 'http://i2.tiimg.com/721094/dd815599232a2de9.png', '2020-07-16 11:51:19', '2020-07-16 11:49:13');
INSERT INTO `specs` VALUES (4, '3', '128GB', 15, 86900.00, 'http://i2.tiimg.com/721094/1e13e50751393be2.png', 'http://i2.tiimg.com/721094/1e13e50751393be2.png', '2020-07-16 11:52:11', '2020-07-16 11:50:43');
INSERT INTO `specs` VALUES (5, '3', '512GB', 1, 949900.00, 'http://i2.tiimg.com/721094/1e13e50751393be2.png', 'http://i2.tiimg.com/721094/1e13e50751393be2.png', '2020-07-16 11:52:15', '2020-07-16 11:50:58');
INSERT INTO `specs` VALUES (6, '2', '128GB', 6, 959900.00, 'http://i2.tiimg.com/721094/37343adf659cbaa7.png', 'http://i2.tiimg.com/721094/37343adf659cbaa7.png', '2020-07-16 11:54:50', '2020-07-16 11:52:45');
INSERT INTO `specs` VALUES (7, '2', '512GB', 74, 1199900.00, 'http://i2.tiimg.com/721094/37343adf659cbaa7.png', 'http://i2.tiimg.com/721094/37343adf659cbaa7.png', '2020-07-16 11:53:57', '2020-07-16 11:53:23');
INSERT INTO `specs` VALUES (8, '6', '128GB', 112, 278800.00, 'http://i1.fuimg.com/721094/7ef02082f4c082bd.jpg', 'http://i1.fuimg.com/721094/7ef02082f4c082bd.jpg', '2020-07-16 11:54:43', '2020-07-16 11:54:43');
INSERT INTO `specs` VALUES (9, '6', '512GB', 72, 340000.00, 'http://i1.fuimg.com/721094/7ef02082f4c082bd.jpg', 'http://i1.fuimg.com/721094/7ef02082f4c082bd.jpg', '2020-07-16 11:55:05', '2020-07-16 11:55:05');
INSERT INTO `specs` VALUES (10, '7', '128GB', 31, 2899900.00, 'http://i1.fuimg.com/721094/2a4b06cbfdabecd3.jpg', 'http://i1.fuimg.com/721094/2a4b06cbfdabecd3.jpg', '2020-07-16 11:55:58', '2020-07-16 11:55:58');
INSERT INTO `specs` VALUES (11, '7', '512GB', 46, 3999900.00, 'http://i1.fuimg.com/721094/2a4b06cbfdabecd3.jpg', 'http://i1.fuimg.com/721094/2a4b06cbfdabecd3.jpg', '2020-07-16 11:56:38', '2020-07-16 11:56:28');
INSERT INTO `specs` VALUES (12, '8', '64GB', 184, 622900.00, 'http://i1.fuimg.com/721094/5c3f228a5780572d.jpg', 'http://i1.fuimg.com/721094/5c3f228a5780572d.jpg', '2020-07-16 11:57:24', '2020-07-16 11:57:24');
INSERT INTO `specs` VALUES (13, '8', '128GB', 66, 839900.00, 'http://i1.fuimg.com/721094/5c3f228a5780572d.jpg', 'http://i1.fuimg.com/721094/5c3f228a5780572d.jpg', '2020-07-16 11:57:44', '2020-07-16 11:57:44');
INSERT INTO `specs` VALUES (14, '20', '64GB', 33, 329900.00, 'http://i1.fuimg.com/721094/72a5265f6ac08e7c.jpg', 'http://i1.fuimg.com/721094/72a5265f6ac08e7c.jpg', '2020-07-16 11:58:39', '2020-07-16 11:58:07');
INSERT INTO `specs` VALUES (15, '20', '128GB', 20, 439900.00, 'http://i1.fuimg.com/721094/72a5265f6ac08e7c.jpg', 'http://i1.fuimg.com/721094/72a5265f6ac08e7c.jpg', '2020-07-16 11:58:41', '2020-07-16 11:58:22');
INSERT INTO `specs` VALUES (16, '21', '256GB SSD', 99, 1248800.00, 'http://i1.fuimg.com/721094/4968918f60b5306c.png', 'http://i1.fuimg.com/721094/4968918f60b5306c.png', '2020-07-16 12:00:11', '2020-07-16 12:00:11');
INSERT INTO `specs` VALUES (17, '21', '512GB SSD', 121, 1648800.00, 'http://i1.fuimg.com/721094/4968918f60b5306c.png', 'http://i1.fuimg.com/721094/4968918f60b5306c.png', '2020-07-16 12:00:38', '2020-07-16 12:00:38');

SET FOREIGN_KEY_CHECKS = 1;
