CREATE TABLE `t_an_ques` (
  `ques_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '题目ID',
  `ques_name` varchar(64) NOT NULL COMMENT '题目名称',
  `ques_english_name` varchar(500) DEFAULT NULL,
  `ques_type` int(11) NOT NULL DEFAULT '0' COMMENT '题目类型 1：单选，2：多选，3：问答',
  `ques_survey_id` bigint(20) DEFAULT NULL COMMENT '所属问卷ID',
  `ques_type_id` bigint(20) DEFAULT NULL COMMENT '所属题目大类ID',
  `ques_score` int(11) DEFAULT NULL,
  `is_required` int(1) DEFAULT '0' COMMENT '是否必答，1是，2否',
  `order_by_id` int(11) DEFAULT NULL COMMENT '排序',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否可见',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ques_id`),
  UNIQUE KEY `ques_id_uk` (`ques_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='问题模板表';

CREATE TABLE `t_an_ques_answer_detail` (
  `answer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '问题答案ID',
  `answer_name` varchar(256) DEFAULT NULL COMMENT '问题答案名称',
  `option_id` varchar(8) DEFAULT NULL COMMENT '选项 1,2,3,4 或A,B,C,D',
  `ques_id` bigint(20) NOT NULL COMMENT '题目ID',
  `ques_name` varchar(64) NOT NULL COMMENT '题目名称',
  `ques_survey_id` bigint(20) NOT NULL COMMENT '所属问卷ID',
  `ques_type_id` bigint(20) DEFAULT NULL COMMENT '所属题目大类ID',
  `order_by_id` int(11) DEFAULT NULL COMMENT '排序1,2,3,4',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`answer_id`),
  UNIQUE KEY `answer_id_uk` (`answer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8 COMMENT='题目答案模板表';

CREATE TABLE `t_an_ques_survey` (
  `ques_survey_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '问卷ID',
  `ques_survey_name` varchar(64) NOT NULL COMMENT '问卷名称',
  `ques_survey_english_name` varchar(200) DEFAULT NULL,
  `ques_survey_logo_url` varchar(255) DEFAULT NULL COMMENT '问卷logo URL',
  `ques_survey_title` varchar(255) DEFAULT NULL COMMENT '问卷标题',
  `ques_survey_remarks` longtext COMMENT '问卷说明',
  `start_date` varchar(10) DEFAULT NULL,
  `end_date` varchar(10) DEFAULT NULL,
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ques_survey_id`),
  UNIQUE KEY `ques_survey_id_uk` (`ques_survey_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1536647459938 DEFAULT CHARSET=utf8 COMMENT='问卷调查模板表';

CREATE TABLE `t_an_ques_survey_answered_detail` (
  `ques_survey_answered_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '问卷调查每次作答唯一键',
  `ques_survey_id` bigint(20) NOT NULL COMMENT '所属问卷ID',
  `ques_survey_name` varchar(64) DEFAULT NULL COMMENT '问卷名称',
  `ques_type_id` bigint(20) DEFAULT NULL COMMENT '所属题目大类ID',
  `ques_type_name` varchar(64) DEFAULT NULL COMMENT '题目大类名称',
  `ques_id` bigint(20) NOT NULL COMMENT '题目ID',
  `ques_name` varchar(64) NOT NULL COMMENT '题目名称',
  `ques_type` int(11) NOT NULL COMMENT '题目类型 1：单选，2：多选，3：填空',
  `answer_id` bigint(20) DEFAULT NULL COMMENT '答案ID',
  `answer_name` varchar(256) DEFAULT NULL COMMENT '答案内容',
  `answer_score` varchar(64) DEFAULT NULL COMMENT '答案分数',
  `is_background_survey` int(1) NOT NULL DEFAULT '0' COMMENT '是否背景调查 0：否，1：是',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ques_survey_answered_id`),
  UNIQUE KEY `ques_survey_answered_id_uk` (`ques_survey_answered_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8 COMMENT='问卷答题明细表';

CREATE TABLE `t_an_ques_type` (
  `ques_type_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '题目大类ID',
  `ques_type_name` varchar(64) NOT NULL COMMENT '题目大类名称',
  `ques_type_english_name` varchar(200) DEFAULT NULL,
  `ques_type_remarks` varchar(500) DEFAULT NULL,
  `ques_survey_id` bigint(20) NOT NULL COMMENT '所属问卷ID',
  `order_by_id` int(11) DEFAULT NULL COMMENT '排序',
  `is_background_survey` int(1) NOT NULL DEFAULT '0' COMMENT '是否背景调查',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ques_type_id`),
  UNIQUE KEY `ques_type_id_uk` (`ques_type_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='问答大类模板表';

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) NOT NULL,
  `email` varchar(64) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_idx` (`user_name`) USING BTREE,
  UNIQUE KEY `email_idx` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

