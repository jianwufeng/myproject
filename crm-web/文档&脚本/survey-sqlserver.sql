/*
Navicat SQL Server Data Transfer

Source Server         : sqlserver
Source Server Version : 110000
Source Host           : localhost:1433
Source Database       : ques_survey
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 110000
File Encoding         : 65001

Date: 2018-11-08 14:33:25
*/

CREATE DATABASE ques_survey;
USE ques_survey;

-- ----------------------------
-- Table structure for t_an_ques
-- ----------------------------
CREATE TABLE [dbo].[t_an_ques] (
[ques_id] bigint NOT NULL IDENTITY(1,1) ,
[ques_name] varchar(64) NOT NULL ,
[ques_english_name] varchar(500) NULL ,
[ques_type] int NULL ,
[ques_survey_id] bigint NULL ,
[ques_type_id] bigint NULL ,
[ques_score] int NULL ,
[is_required] int NULL DEFAULT ((0)) ,
[order_by_id] int NULL ,
[is_delete] bit NULL DEFAULT ((0)) ,
[create_time] datetime NULL ,
[update_time] datetime NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[t_an_ques]', RESEED, 17)
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques', 
'COLUMN', N'ques_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'题目ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques'
, @level2type = 'COLUMN', @level2name = N'ques_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'题目ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques'
, @level2type = 'COLUMN', @level2name = N'ques_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques', 
'COLUMN', N'ques_name')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'题目名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques'
, @level2type = 'COLUMN', @level2name = N'ques_name'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'题目名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques'
, @level2type = 'COLUMN', @level2name = N'ques_name'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques', 
'COLUMN', N'ques_type')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'题目类型 1：单选，2：多选，3：问答'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques'
, @level2type = 'COLUMN', @level2name = N'ques_type'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'题目类型 1：单选，2：多选，3：问答'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques'
, @level2type = 'COLUMN', @level2name = N'ques_type'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques', 
'COLUMN', N'ques_survey_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'所属问卷ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques'
, @level2type = 'COLUMN', @level2name = N'ques_survey_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'所属问卷ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques'
, @level2type = 'COLUMN', @level2name = N'ques_survey_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques', 
'COLUMN', N'ques_type_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'所属题目大类ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques'
, @level2type = 'COLUMN', @level2name = N'ques_type_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'所属题目大类ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques'
, @level2type = 'COLUMN', @level2name = N'ques_type_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques', 
'COLUMN', N'is_required')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否必答，1是，2否'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques'
, @level2type = 'COLUMN', @level2name = N'is_required'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否必答，1是，2否'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques'
, @level2type = 'COLUMN', @level2name = N'is_required'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques', 
'COLUMN', N'order_by_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'排序'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques'
, @level2type = 'COLUMN', @level2name = N'order_by_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'排序'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques'
, @level2type = 'COLUMN', @level2name = N'order_by_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques', 
'COLUMN', N'is_delete')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否删除：1删除，0不删除'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques'
, @level2type = 'COLUMN', @level2name = N'is_delete'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否删除：1删除，0不删除'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques'
, @level2type = 'COLUMN', @level2name = N'is_delete'
GO

-- ----------------------------
-- Table structure for t_an_ques_answer_detail
-- ----------------------------
CREATE TABLE [dbo].[t_an_ques_answer_detail] (
[answer_id] bigint NOT NULL IDENTITY(1,1) ,
[answer_name] varchar(256) NULL ,
[option_id] varchar(8) NULL ,
[ques_id] bigint NOT NULL ,
[ques_name] varchar(64) NOT NULL ,
[ques_survey_id] bigint NOT NULL ,
[ques_type_id] bigint NULL ,
[order_by_id] int NULL ,
[is_delete] bit NOT NULL DEFAULT ((0)) ,
[create_time] datetime NULL ,
[update_time] datetime NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[t_an_ques_answer_detail]', RESEED, 30)
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_answer_detail', 
NULL, NULL)) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'题目答案模板表'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'题目答案模板表'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_answer_detail', 
'COLUMN', N'answer_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'问题答案ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'answer_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'问题答案ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'answer_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_answer_detail', 
'COLUMN', N'answer_name')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'问题答案名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'answer_name'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'问题答案名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'answer_name'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_answer_detail', 
'COLUMN', N'option_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'选项 1,2,3,4 或A,B,C,D'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'option_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'选项 1,2,3,4 或A,B,C,D'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'option_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_answer_detail', 
'COLUMN', N'ques_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'题目ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'ques_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'题目ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'ques_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_answer_detail', 
'COLUMN', N'ques_name')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'题目名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'ques_name'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'题目名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'ques_name'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_answer_detail', 
'COLUMN', N'ques_survey_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'所属问卷ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'ques_survey_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'所属问卷ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'ques_survey_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_answer_detail', 
'COLUMN', N'ques_type_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'所属题目大类ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'ques_type_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'所属题目大类ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'ques_type_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_answer_detail', 
'COLUMN', N'order_by_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'排序1,2,3,4'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'order_by_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'排序1,2,3,4'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'order_by_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_answer_detail', 
'COLUMN', N'is_delete')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否删除'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'is_delete'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否删除'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_answer_detail'
, @level2type = 'COLUMN', @level2name = N'is_delete'
GO

-- ----------------------------
-- Table structure for t_an_ques_survey
-- ----------------------------
CREATE TABLE [dbo].[t_an_ques_survey] (
[ques_survey_id] bigint NOT NULL IDENTITY(1,1) ,
[ques_survey_name] varchar(64) NULL ,
[ques_survey_english_name] varchar(200) NULL ,
[ques_survey_logo_url] varchar(255) NULL ,
[ques_survey_title] varchar(255) NULL ,
[ques_survey_remarks] varchar(MAX) NULL ,
[start_date] varchar(10) NULL ,
[end_date] varchar(10) NULL ,
[is_delete] bit NULL DEFAULT ((0)) ,
[create_time] datetime NULL ,
[update_time] datetime NULL 
)


GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey', 
NULL, NULL)) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'问卷调查模板表'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'问卷调查模板表'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey', 
'COLUMN', N'ques_survey_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'问卷ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey'
, @level2type = 'COLUMN', @level2name = N'ques_survey_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'问卷ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey'
, @level2type = 'COLUMN', @level2name = N'ques_survey_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey', 
'COLUMN', N'ques_survey_name')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'问卷名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey'
, @level2type = 'COLUMN', @level2name = N'ques_survey_name'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'问卷名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey'
, @level2type = 'COLUMN', @level2name = N'ques_survey_name'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey', 
'COLUMN', N'ques_survey_logo_url')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'问卷logo URL'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey'
, @level2type = 'COLUMN', @level2name = N'ques_survey_logo_url'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'问卷logo URL'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey'
, @level2type = 'COLUMN', @level2name = N'ques_survey_logo_url'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey', 
'COLUMN', N'ques_survey_title')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'问卷标题'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey'
, @level2type = 'COLUMN', @level2name = N'ques_survey_title'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'问卷标题'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey'
, @level2type = 'COLUMN', @level2name = N'ques_survey_title'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey', 
'COLUMN', N'ques_survey_remarks')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'问卷说明'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey'
, @level2type = 'COLUMN', @level2name = N'ques_survey_remarks'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'问卷说明'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey'
, @level2type = 'COLUMN', @level2name = N'ques_survey_remarks'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey', 
'COLUMN', N'is_delete')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否删除'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey'
, @level2type = 'COLUMN', @level2name = N'is_delete'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否删除'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey'
, @level2type = 'COLUMN', @level2name = N'is_delete'
GO

-- ----------------------------
-- Table structure for t_an_ques_survey_answered_detail
-- ----------------------------
CREATE TABLE [dbo].[t_an_ques_survey_answered_detail] (
[ques_survey_answered_id] bigint NOT NULL IDENTITY(1,1) ,
[ques_survey_id] bigint NOT NULL ,
[ques_survey_name] varchar(64) NULL ,
[ques_type_id] bigint NULL ,
[ques_type_name] varchar(64) NULL ,
[ques_id] bigint NOT NULL ,
[ques_name] varchar(64) NULL ,
[ques_type] int NOT NULL ,
[answer_id] bigint NULL ,
[answer_name] varchar(256) NULL ,
[answer_score] varchar(64) NULL ,
[is_background_survey] int NOT NULL DEFAULT ((0)) ,
[is_delete] bit NOT NULL DEFAULT ((0)) ,
[create_time] datetime2(7) NULL ,
[update_time] datetime2(7) NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[t_an_ques_survey_answered_detail]', RESEED, 43)
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey_answered_detail', 
NULL, NULL)) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'问卷答题明细表'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'问卷答题明细表'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey_answered_detail', 
'COLUMN', N'ques_survey_answered_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'问卷调查每次作答唯一键'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'ques_survey_answered_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'问卷调查每次作答唯一键'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'ques_survey_answered_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey_answered_detail', 
'COLUMN', N'ques_survey_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'所属问卷ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'ques_survey_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'所属问卷ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'ques_survey_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey_answered_detail', 
'COLUMN', N'ques_survey_name')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'问卷名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'ques_survey_name'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'问卷名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'ques_survey_name'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey_answered_detail', 
'COLUMN', N'ques_type_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'所属题目大类ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'ques_type_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'所属题目大类ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'ques_type_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey_answered_detail', 
'COLUMN', N'ques_type_name')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'题目大类名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'ques_type_name'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'题目大类名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'ques_type_name'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey_answered_detail', 
'COLUMN', N'ques_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'题目ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'ques_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'题目ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'ques_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey_answered_detail', 
'COLUMN', N'ques_name')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'题目名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'ques_name'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'题目名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'ques_name'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey_answered_detail', 
'COLUMN', N'ques_type')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'题目类型 1：单选，2：多选，3：填空'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'ques_type'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'题目类型 1：单选，2：多选，3：填空'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'ques_type'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey_answered_detail', 
'COLUMN', N'answer_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'答案ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'answer_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'答案ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'answer_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey_answered_detail', 
'COLUMN', N'answer_name')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'答案内容'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'answer_name'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'答案内容'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'answer_name'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey_answered_detail', 
'COLUMN', N'answer_score')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'答案分数'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'answer_score'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'答案分数'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'answer_score'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey_answered_detail', 
'COLUMN', N'is_background_survey')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否背景调查 0：否，1：是'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'is_background_survey'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否背景调查 0：否，1：是'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'is_background_survey'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_survey_answered_detail', 
'COLUMN', N'is_delete')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否删除'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'is_delete'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否删除'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_survey_answered_detail'
, @level2type = 'COLUMN', @level2name = N'is_delete'
GO

-- ----------------------------
-- Table structure for t_an_ques_type
-- ----------------------------
CREATE TABLE [dbo].[t_an_ques_type] (
[ques_type_id] bigint NOT NULL IDENTITY(1,1) ,
[ques_type_name] varchar(64) NULL ,
[ques_type_english_name] varchar(200) NULL ,
[ques_type_remarks] varchar(500) NULL ,
[ques_survey_id] bigint NOT NULL ,
[order_by_id] int NULL ,
[is_background_survey] int NOT NULL DEFAULT ((0)) ,
[is_delete] bit NOT NULL DEFAULT ((0)) ,
[create_time] datetime2(7) NULL ,
[update_time] datetime2(7) NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[t_an_ques_type]', RESEED, 11)
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_type', 
NULL, NULL)) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'问答大类模板表'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_type'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'问答大类模板表'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_type'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_type', 
'COLUMN', N'ques_type_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'题目大类ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_type'
, @level2type = 'COLUMN', @level2name = N'ques_type_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'题目大类ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_type'
, @level2type = 'COLUMN', @level2name = N'ques_type_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_type', 
'COLUMN', N'ques_type_name')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'题目大类名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_type'
, @level2type = 'COLUMN', @level2name = N'ques_type_name'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'题目大类名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_type'
, @level2type = 'COLUMN', @level2name = N'ques_type_name'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_type', 
'COLUMN', N'ques_survey_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'所属问卷ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_type'
, @level2type = 'COLUMN', @level2name = N'ques_survey_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'所属问卷ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_type'
, @level2type = 'COLUMN', @level2name = N'ques_survey_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_type', 
'COLUMN', N'order_by_id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'排序'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_type'
, @level2type = 'COLUMN', @level2name = N'order_by_id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'排序'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_type'
, @level2type = 'COLUMN', @level2name = N'order_by_id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_type', 
'COLUMN', N'is_background_survey')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否背景调查'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_type'
, @level2type = 'COLUMN', @level2name = N'is_background_survey'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否背景调查'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_type'
, @level2type = 'COLUMN', @level2name = N'is_background_survey'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_an_ques_type', 
'COLUMN', N'is_delete')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否删除'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_type'
, @level2type = 'COLUMN', @level2name = N'is_delete'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否删除'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_an_ques_type'
, @level2type = 'COLUMN', @level2name = N'is_delete'
GO

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
CREATE TABLE [dbo].[t_user] (
[id] bigint NOT NULL IDENTITY(1,1) ,
[user_name] nvarchar(64) NOT NULL ,
[email] nvarchar(64) NULL ,
[password] nvarchar(255) NULL ,
[create_time] datetime2(7) NULL ,
[update_time] datetime2(7) NULL 
)


GO

-- ----------------------------
-- Indexes structure for table t_an_ques
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table t_an_ques
-- ----------------------------
ALTER TABLE [dbo].[t_an_ques] ADD PRIMARY KEY ([ques_id])
GO

-- ----------------------------
-- Indexes structure for table t_an_ques_answer_detail
-- ----------------------------
CREATE UNIQUE INDEX [answer_id_uk] ON [dbo].[t_an_ques_answer_detail]
([answer_id] ASC) 
WITH (IGNORE_DUP_KEY = ON, STATISTICS_NORECOMPUTE = ON)
GO

-- ----------------------------
-- Primary Key structure for table t_an_ques_answer_detail
-- ----------------------------
ALTER TABLE [dbo].[t_an_ques_answer_detail] ADD PRIMARY KEY ([answer_id])
GO

-- ----------------------------
-- Indexes structure for table t_an_ques_survey
-- ----------------------------
CREATE UNIQUE INDEX [ques_survey_id_uk] ON [dbo].[t_an_ques_survey]
([ques_survey_id] ASC) 
WITH (IGNORE_DUP_KEY = ON, STATISTICS_NORECOMPUTE = ON)
GO

-- ----------------------------
-- Primary Key structure for table t_an_ques_survey
-- ----------------------------
ALTER TABLE [dbo].[t_an_ques_survey] ADD PRIMARY KEY ([ques_survey_id])
GO

-- ----------------------------
-- Indexes structure for table t_an_ques_survey_answered_detail
-- ----------------------------
CREATE UNIQUE INDEX [ques_survey_answered_id_uk] ON [dbo].[t_an_ques_survey_answered_detail]
([ques_survey_answered_id] ASC) 
WITH (IGNORE_DUP_KEY = ON, STATISTICS_NORECOMPUTE = ON)
GO

-- ----------------------------
-- Primary Key structure for table t_an_ques_survey_answered_detail
-- ----------------------------
ALTER TABLE [dbo].[t_an_ques_survey_answered_detail] ADD PRIMARY KEY ([ques_survey_answered_id])
GO

-- ----------------------------
-- Indexes structure for table t_an_ques_type
-- ----------------------------
CREATE UNIQUE INDEX [ques_type_id_uk] ON [dbo].[t_an_ques_type]
([ques_type_id] ASC) 
WITH (IGNORE_DUP_KEY = ON, STATISTICS_NORECOMPUTE = ON)
GO

-- ----------------------------
-- Primary Key structure for table t_an_ques_type
-- ----------------------------
ALTER TABLE [dbo].[t_an_ques_type] ADD PRIMARY KEY ([ques_type_id])
GO

-- ----------------------------
-- Indexes structure for table t_user
-- ----------------------------
CREATE UNIQUE INDEX [user_name_idx] ON [dbo].[t_user]
([user_name] ASC) 
WITH (IGNORE_DUP_KEY = ON, STATISTICS_NORECOMPUTE = ON)
GO
CREATE UNIQUE INDEX [email_idx] ON [dbo].[t_user]
([email] ASC) 
WITH (IGNORE_DUP_KEY = ON, STATISTICS_NORECOMPUTE = ON)
GO

-- ----------------------------
-- Primary Key structure for table t_user
-- ----------------------------
ALTER TABLE [dbo].[t_user] ADD PRIMARY KEY ([id])
GO

INSERT INTO [t_user] ([user_name], [email], [password], [create_time], [update_time]) VALUES ( 'admin', 'admin@163.com', '123456', '2018-11-8 15:02:36', '2018-11-8 15:02:38');
GO
