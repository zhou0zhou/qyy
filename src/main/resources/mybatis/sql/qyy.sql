/*
 Navicat Premium Data Transfer

 Source Server         : kkkwww
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : qyy

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 07/07/2023 16:34:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_topictitle` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `comment_content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `comment_likes` int(0) NULL DEFAULT NULL,
  `comment_account` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  INDEX `comment_topictitle`(`comment_topictitle`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`comment_topictitle`) REFERENCES `topic` (`topic_title`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('计算机专业就业前景', '985本硕秋招也毫无消息正常吗？投了20多家，笔试2场面试0场，一边实习一边秋招一边改论文，每天还忍受着北京3小时的通勤，太难了每天都在考虑辞掉实习工作。补充：建筑专业，五年制本科。', 2, '李四');
INSERT INTO `comment` VALUES ('计算机专业就业前景', '感触颇多。我也是十年社畜，去年是秋招大数据面试官，一面二面都有。985.211硕士好多，还面了清华的他们未来肯定比我厉害的多，但真的我们就只招2个人。好多人确实很优秀，算法其实问的都是牛客网自带的。一般一道简单一道中等。有时候看到有实习项目的，会问点项目，可惜都比较浅，非常理解。我真的好想让很多人过，但人数卡的厉害，后来就凭面试感觉留人了，毕竟后面要共事。感觉人开朗随和的就过了。', 2, ' zhangxu');
INSERT INTO `comment` VALUES ('MyBatis项目开发流程', 'Mybatis就是帮助程序猿将数据存入数据库中 , 和从数据库中取数据。传统的jdbc操作 , 有很多重复代码块 .比如 : 数据取出时的封装 , 数据库的建立连接等等… , 通过框架可以减少重复代码,提高开发效率。MyBatis 是一个半自动化的ORM框架。所有的事情，不用Mybatis依旧可以做到，只是用了它，所有实现会更加简单！', 3, '张三');
INSERT INTO `comment` VALUES ('MyBatis项目开发流程', '利用MyBatis可以简化JDBC的书写，在后续的开发过程中可以解决硬编码问题。JDBC是甲骨文公司提供的标准化接口，不同的数据库厂商提供不同的jar驱动包，对于Mysql数据库来说，在书写过程中需要构建Collection对象，再通过Preparedment对象来操作sql语句，最后再执行对应的方法来实现sql语句的执行文件。使用MyBatis，如果在普通的项目内想使用，就要导入对应的jar包，要使用 MyBatis，只需将mybatis.xxx.jar 文件置于类路径（classpath）中即可。', 1, '张三');
INSERT INTO `comment` VALUES ('MyBatis项目开发流程', '利用mybatis插入数据中文乱码的原因： （1）数据库字符集不能正确，这里要确认三个地方，第一数据库字符集，表的字符集，字段的字符集。这里首要确认“字段字符集”是否为UTF-8。(2) 数据库连接字符串添加自定义字符集以及指明需要使用的字符集，正确的数链接：jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8', 2, '李四');
INSERT INTO `comment` VALUES ('MyBatis项目开发流程', '在方法openSession处ctrl+p只能显示boolean b的，是因为没有下载源码 下载源码的方式是：按住ctrl鼠标左键点击Mybatis的任一成员，进去后右上角有download sources 然后很多人的idea马上就会报错 idea cannot Download Sources 解决办法是在idea的Terminal中 mvn dependency:resolve -Dclassifier=sources 源码就下下来了', 3, 'Supreme Lord Lao Zi');

-- ----------------------------
-- Table structure for follower
-- ----------------------------
DROP TABLE IF EXISTS `follower`;
CREATE TABLE `follower`  (
  `useraccount` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `followeraccount` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of follower
-- ----------------------------
INSERT INTO `follower` VALUES ('张三', '孙悟空');
INSERT INTO `follower` VALUES ('张三', '猪八戒');
INSERT INTO `follower` VALUES ('张三', 'zhou');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `topic_title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `topic_content` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `topic_likes` int(0) NULL DEFAULT NULL,
  `publisher_account` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `publish_time` timestamp(0) NULL DEFAULT NULL,
  `poi_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`topic_title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('MyBatis项目开发流程', '需求分析和数据库设计：明确项目需求，设计数据库结构，包括表、列和关系。\r\n\r\n配置MyBatis：在项目配置文件中配置MyBatis相关信息，如数据库连接、映射文件路径和类型别名。\r\n\r\n创建DAO接口：定义数据库的增删改查操作方法，每个方法对应一个SQL查询或更新操作。\r\n\r\n编写SQL映射文件：为每个DAO接口编写对应的SQL映射文件，定义具体的SQL语句和参数映射规则。\r\n\r\n实现DAO接口：根据DAO接口编写具体的实现类，通过MyBatis的API执行数据库操作。\r\n\r\n配置和启动项目：根据项目需要配置Web容器或其他运行环境，启动项目。\r\n\r\n测试和调试：编写单元测试代码，测试DAO接口的各种方法是否正常工作。\r\n\r\n迭代开发和维护：根据实际需求不断迭代开发和优化项目，可以进行SQL查询的优化和调整。', 22, 'Xingzhe', '2023-07-04 00:00:57', '计算机技术');
INSERT INTO `topic` VALUES ('[NBA]掘金主场94-89战胜热火 大比分4-1夺队史首冠', '这是一场殊死搏斗，面对强硬坚韧的迈阿密热火，掘金一直追赶奋战到了最后一刻。  13日上午，在NBA总决赛第五战中，掘金在全场落后的不利形势下，主场94-89逆转热火，总比分4-1拿下系列赛胜利，捧起了他们队史的第一座总冠军奖杯。这是掘金建队47年来首个NBA总冠军，掘金也超越骑士的46年，成为NBA历史建队距离首冠最久的球队。全场比赛，约基奇拿下28分16篮板，斩获总决赛最有价值球员FMVP，穆雷14分8篮板8助攻，小波特16分；热火一边，巴特勒21分，阿德巴约20分12篮板。', 0, ' zhangxu', '2023-07-07 16:02:06', '体育赛事');
INSERT INTO `topic` VALUES ('夜莺·上', '在古代的中国，皇帝的花园里住着一只夜莺，它的歌声非常美妙动听，为忙碌的渔夫和穷苦的女孩带来快乐和安慰。但是不论皇帝或是他的臣子，都不知道自己国内有这么一只鸟儿，直到外国人的书里说起，才好不容易地找到了它。这虽然是一只并不漂亮的平凡的灰色鸟儿，但它的歌声也打动了皇帝的心弦，使他不禁流出了眼泪。这时，日本皇帝送来一只夜莺，是人造的工艺品，全身镶满钻石、红玉和碧玉，跟真的夜莺完全一样，只要上好发条，就会唱真夜莺所唱的歌。当皇宫里的人几十次不知疲倦地被诱引去听这只“高等皇家夜间歌手”的歌唱时，真夜莺就悄悄地飞回青翠的树林中去了。', 0, 'seele', '2023-07-07 16:02:10', '童话故事');
INSERT INTO `topic` VALUES ('夜莺·下', '可惜一年以后，人造夜莺所能唱的调子，听的人甚至都能够背了；随后，它身体里面的发条也断了，勉强修好，也只能每年让它唱一次。又过了五年，皇帝也病了，垂危中，面对死神，他呼唤人造夜莺为他歌唱，但这只鸟儿因为没有上好发条，一动也不会动。就在这个时候，窗外传来那只小夜莺的歌声，它是特地在这个非常时刻来向皇帝唱安慰和希望的歌的。果然，随着它的歌声，“皇帝孱弱的肢体里，血也开始流得快起来”，使他终于恢复了体力，而且神志也清醒了；原来等在他身边的死神则变成一股寒冷的白雾，从窗子里消失了。', 0, 'seele', '2023-07-07 16:02:13', '童话故事');
INSERT INTO `topic` VALUES ('大学生自主管理', '大学生如果拥有想要提升自身能力，但是又不明白以后要做什么的时候可以静下心来，拿出纸笔： 第一步：开始自己的职业规划，这里面包括你想做的事、你想成功的、你想达到的目标等，希望在什么时候达成这些目标； 第二步：选出在一段时间内你最重要的目标、列出你目前的条件，可以使用的资源并且需要获取的资源； 第三步：针对自己的重要目标，确定好实现它的每一个步骤，然后为之努力； 第四步：当你完成一个目标时，进行一次个人复盘，了解自身的确定，还能改进的地方。一个想努力的人，不管是有目标性的提升自主学习能力，还是没有目的性的想要提升，都要让自己拥有自身职业怪话和想要达成的目标，按照一步一个节奏，走到想要的位置。', 0, 'wow', '2023-07-07 16:02:18', '学习');
INSERT INTO `topic` VALUES ('小红帽', '故事讲述了从前有个人见人爱的小姑娘，喜欢戴着外婆送给她的一顶红色天鹅绒的帽子，于是大家就叫她小红帽。有一天，母亲叫她给住在森林的外婆送食物，并嘱咐她不要离开大路，走得太远。小红帽在森林中遇见了狼，她从未见过狼，也不知道狼性凶残，于是告诉了狼她要去森林里看望自己的外婆。狼知道后诱骗小红帽去采野花，自己到林中小屋把小红帽的外婆吃了。后来他伪装成外婆，等小红帽来找外婆时，狼一口把她吃掉了。幸好后来一个勇敢的猎人把小红帽和外婆从狼肚里救了出来。', 2, 'seele', '2023-07-07 16:02:26', '童话故事');
INSERT INTO `topic` VALUES ('民主革命终结和社会主义革命开始', '1949年6月，毛泽东发表《论人民民主专政》：明确指出人民民主专政需要工人阶级的领导。人民民主专政的基础是：工人阶级、农民阶级和城市小资产阶级的联盟，主要是工人和农民阶级的联盟。民族资产阶级不能充当领导者，也不应在国家政权中占主要地位。1949年9月21日，中国人民政治协商会议第一届会议在北平召开。通过了《政治协商会议组织法》《中央人民政府组织法》《中国人民政治协商会议共同纲领》（起到了临时宪法的作用）。人民政协的召开标志着中国共产党领导的多党合作和政治协商制度的确立。10月1日中华人民共和国成立，民主革命终结和社会主义革命开始。', 0, 'Deepness', '2023-07-07 16:02:21', '历史');
INSERT INTO `topic` VALUES ('热身赛-刘俊贤一传两射 国奥3-1克罗地亚乙级队', '克罗地亚当地时间3月20日下午15点，中国国奥队前往里耶卡同克罗地亚乙级联赛队伍NK Opatija队进行了一场热身赛。  　　上半场第5分钟，何龙海前场策动进攻，刘俊贤边路接球后回传，马辅渔罚球区外远射破门。第14分钟，贾非凡主罚右侧角球，刘俊贤后点垫射破门。第37分钟，刘俊贤前场抢断后单刀破门梅开二度。下半场第78分钟，对手利用任意球机会扳回一球。  　　最终，中国国奥队以3比1战胜NK Opatija队。', 0, ' zhangxu', '2023-07-07 16:02:23', '体育赛事');
INSERT INTO `topic` VALUES ('经皮二尖瓣和三尖瓣置换术', '一般认为，引起器质性三尖瓣关闭不全的原因很多，如风湿性心脏病、先天性Ebstein畸形、感染性心内膜炎所致的瓣膜毁损、三尖瓣脱垂、右心室心肌梗塞及胸部外伤等。\r\n\r\n\r\n\r\n心脏是人体最任劳任怨、须臾不停的器官，瓣膜发生问题后仍要坚持工作，其结果往往是问题愈来愈严重，发展到晚期，换瓣毫无疑问是最可靠的治疗手段，但是此时，往往患者的心肺功能已无法耐受心脏外科手术，很多患者不得不在药物的维持下继续低生活质量的生命历程。\r\n\r\n\r\n\r\n虽然目前心脏外科手术已经十分成熟，但心脏专科医生们仍然在孜孜不倦地寻找减少创伤的治疗技术，比如通过动脉在心脏置入支架。\r\n\r\n\r\n\r\n近来，医学家也在寻找更佳的心脏换瓣技术。2016 年经皮心脏二尖瓣和三尖瓣置换术已经成功实施，该技术通过皮下穿刺血管，将导管送至瓣膜处，对病灶进行手术置换。', 0, 'Xingzhe', '2023-07-03 00:00:00', '医学');
INSERT INTO `topic` VALUES ('美术学的研究对象', '美术学是人文科学的组成部分，是一门研究美术现象及其规律的科学，美术历史的演变过程、美术理论及美术批评均是它的主要内容。美术学要研究美术家、美术创作、美术鉴赏、美术活动等美术现象，同时也要研究美术思潮、造型美学、美术史学等。此外，美术学还要研究本身的历史 即美术学史，就像哲学要研究哲学史一样 。', 0, 'Xingzhe', '2023-07-03 00:00:00', '美术学');
INSERT INTO `topic` VALUES ('计算机专业就业前景', '对于今年刚刚毕业的大学生来说，计算机专业确实给人一种刚火没两年就要凉了的错觉。那么，计算机专业真的不香了吗？首先，这属于理解性偏差。不是计算机不行了，而是这个行业目前发展到了瓶颈，进入成熟平稳期了，没有了前些年高速发展的红利了。计算机行业还在那里，各大厂的业务也还在那里，保持着目前的业务规模还是可以的。仔细观察之后就会发现，今年计算机校招，薪酬待遇并未下降，各种高薪岗位层出不穷。但是，招聘人数却在下降，也就是说，招聘门槛提升了。计算机等信息类专业学生的就业不会再像以前一样，是个学计算机的都会有高薪酬起点，拿offer拿到手软的情况了。', 0, 'wow', '2023-07-07 16:02:28', '计算机');
INSERT INTO `topic` VALUES ('长端粒综合征人群的家族性克隆性造血', '本研究最初共纳入17名POT1突变携带者和21名非携带者亲属，随后纳入了另外6名突变携带者组成验证队列。在评估端粒长度的POT1突变携带者中，大多数（13例中的9例）的端粒较长（>第99百分位数）。POT1突变携带者除患B细胞和T细胞淋巴瘤以及髓系恶性肿瘤外，还患上皮、间质和神经元的各种良性和恶性肿瘤。18例POT1突变携带者中有5例（28%）有T细胞克隆性，12例中有8例（67%）有潜能不确定的克隆性造血。克隆性造血的易感性为常染色体显性遗传模式，外显率随年龄增加而增加；体细胞DNMT3A和JAK2热点突变常见。这些和其他体细胞驱动突变很可能发生在生命的最初几十年，它们的谱系随后积累了较高的突变负荷，其特征是时钟样基因突变特征。连续几代表现出遗传预期（即发病年龄越来越早）。非携带者亲属的端粒随年龄增长而缩短，而POT1突变携带者的端粒长度在2年内保持不变。', 2, '张三', '2023-07-03 00:00:00', '医学');
INSERT INTO `topic` VALUES ('风洞', '我的评价是：非常满意', 3, '张三', '2023-07-07 15:46:44', '其他');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(0) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `sex` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '男',
  `nickname` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `picture` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `introduction` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `security_answer` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `suggestion` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE,
  UNIQUE INDEX `account`(`account`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Jige', '123jige', '男', '蔡徐坤', '无', '中国', '练习时长两年半', '1024', '无');
INSERT INTO `user` VALUES (2, 'Lee Sin', '123leesin', '男.', '李青', '一个图片', '艾欧尼亚', '神龙敖兴之力', '1024', '添加功能页面');
INSERT INTO `user` VALUES (3, 'Aatrox', '123aatrox', '男', '亚托克斯', '无', '符文之地', '你好，我是亚托克斯', '1024', '无');
INSERT INTO `user` VALUES (4, '张三', '123456', '男', '张三', '无', '武汉市', '法外狂徒', '1024', '我的评价是：非常满意');
INSERT INTO `user` VALUES (5, 'Gautamabuddha', '123456', '男', '如来', '', '印度', '他真来了吗', '1024', '无');
INSERT INTO `user` VALUES (6, 'Supreme Lord Lao Zi', '123456', '男', '太上老君', '无', '天庭', '太清道德天尊', '1024', '无');
INSERT INTO `user` VALUES (7, 'xingzhe', '123456', '男', '孙悟空', '一个图片', '水帘洞', '行者孙', '1024', '无');
INSERT INTO `user` VALUES (8, '李四', '123456', '男', NULL, NULL, NULL, NULL, NULL, '无');
INSERT INTO `user` VALUES (32, 'seele', 'wer157', '女', 'Marry', '', '上海', '我是一个新用户', '1024', '还不错');
INSERT INTO `user` VALUES (33, ' zhangxu', 'Qw159874263', '男', 'oraclekane', '', '河北', '一个新社区？', '210', '无');
INSERT INTO `user` VALUES (34, 'wow', 'asd987', '男', 'Jack', '', '北京市', '嗨嗨', '24', '无');
INSERT INTO `user` VALUES (35, 'Deepness', '123456', '男', 'John', '', '北京市', '希望交到朋友', '512', '无');
INSERT INTO `user` VALUES (36, 'zhou', '123456', '女', '阿达', '', '北京市', '我是户', '1231', '无');

SET FOREIGN_KEY_CHECKS = 1;
