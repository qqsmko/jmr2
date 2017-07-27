/*
Navicat PGSQL Data Transfer

Source Server         : postgresql
Source Server Version : 90602
Source Host           : localhost:5432
Source Database       : jmr
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90602
File Encoding         : 65001

Date: 2017-07-27 18:11:23
*/


-- ----------------------------
-- Sequence structure for t_account_account_id_seq
-- ----------------------------
DROP SEQUENCE "public"."t_account_account_id_seq";
CREATE SEQUENCE "public"."t_account_account_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 5
 CACHE 1;
SELECT setval('"public"."t_account_account_id_seq"', 5, true);

-- ----------------------------
-- Sequence structure for t_ukey_id_seq
-- ----------------------------
DROP SEQUENCE "public"."t_ukey_id_seq";
CREATE SEQUENCE "public"."t_ukey_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."t_ukey_id_seq"', 1, true);

-- ----------------------------
-- Sequence structure for tbl_accessResource_id_seq
-- ----------------------------
DROP SEQUENCE "public"."tbl_accessResource_id_seq";
CREATE SEQUENCE "public"."tbl_accessResource_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for tbl_account_id_seq
-- ----------------------------
DROP SEQUENCE "public"."tbl_account_id_seq";
CREATE SEQUENCE "public"."tbl_account_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."tbl_account_id_seq"', 1, true);

-- ----------------------------
-- Sequence structure for tbl_account_role_id_seq
-- ----------------------------
DROP SEQUENCE "public"."tbl_account_role_id_seq";
CREATE SEQUENCE "public"."tbl_account_role_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for tbl_authority_id_seq
-- ----------------------------
DROP SEQUENCE "public"."tbl_authority_id_seq";
CREATE SEQUENCE "public"."tbl_authority_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for tbl_authority_resource_id_seq
-- ----------------------------
DROP SEQUENCE "public"."tbl_authority_resource_id_seq";
CREATE SEQUENCE "public"."tbl_authority_resource_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for tbl_indicator_statistics_id_seq
-- ----------------------------
DROP SEQUENCE "public"."tbl_indicator_statistics_id_seq";
CREATE SEQUENCE "public"."tbl_indicator_statistics_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for tbl_role_authority_id_seq
-- ----------------------------
DROP SEQUENCE "public"."tbl_role_authority_id_seq";
CREATE SEQUENCE "public"."tbl_role_authority_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for tbl_role_id_seq
-- ----------------------------
DROP SEQUENCE "public"."tbl_role_id_seq";
CREATE SEQUENCE "public"."tbl_role_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for temp_123_seq
-- ----------------------------
DROP SEQUENCE "public"."temp_123_seq";
CREATE SEQUENCE "public"."temp_123_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 22
 CACHE 1;
SELECT setval('"public"."temp_123_seq"', 22, true);

-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_account";
CREATE TABLE "public"."t_account" (
"account_id" int4 DEFAULT nextval('t_account_account_id_seq'::regclass) NOT NULL,
"account" varchar(32) COLLATE "default" NOT NULL,
"password" varchar(128) COLLATE "default" NOT NULL,
"create_at" timestamp(6) NOT NULL,
"institutions_id" int4,
"account_type" int4 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_account"."account_type" IS '1=超管 2=机构老师 3=人社科管理员';

-- ----------------------------
-- Records of t_account
-- ----------------------------
INSERT INTO "public"."t_account" VALUES ('5', 'admin', '21232f297a57a5a743894a0e4a801fc3
', '2017-06-14 16:58:12', '999999998', '3');
INSERT INTO "public"."t_account" VALUES ('2', 'root', '63a9f0ea7bb98050796b649e85481845
', '2017-06-14 16:56:28', '999999999', '1');
INSERT INTO "public"."t_account" VALUES ('3', 'teacher1', '41c8949aa55b8cb5dbec662f34b62df3', '2017-06-14 16:57:20', '229677', '2');
INSERT INTO "public"."t_account" VALUES ('4', 'teacher2', 'ccffb0bb993eeb79059b31e1611ec353
', '2017-06-09 16:57:46', '381790', '2');

-- ----------------------------
-- Table structure for t_attendance
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_attendance";
CREATE TABLE "public"."t_attendance" (
"attendance_id" int4 NOT NULL,
"deviceid" int4 NOT NULL,
"detail_id" int4 NOT NULL,
"attendance_type" int4 NOT NULL,
"datatime" timestamp(6) NOT NULL,
"attendance_state" int4 NOT NULL,
"is_delete" int4 NOT NULL,
"create_by" varchar(20) COLLATE "default" NOT NULL,
"create_at" timestamp(6) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_attendance"."attendance_type" IS '打卡类型（指纹、摄像头）';
COMMENT ON COLUMN "public"."t_attendance"."datatime" IS '打卡时间';
COMMENT ON COLUMN "public"."t_attendance"."attendance_state" IS '打卡状态（迟到，早退，正常）';

-- ----------------------------
-- Records of t_attendance
-- ----------------------------
INSERT INTO "public"."t_attendance" VALUES ('312345', '718293', '223123', '0', '2017-06-06 20:57:02', '1', '0', 'test', '2017-06-03 20:57:18');
INSERT INTO "public"."t_attendance" VALUES ('312346', '978310', '223124', '1', '2017-06-20 21:00:42', '2', '0', 'test', '2017-06-16 21:01:01');
INSERT INTO "public"."t_attendance" VALUES ('312347', '234233', '223125', '0', '2017-06-08 21:02:01', '0', '0', 'test', '2017-06-06 21:02:14');

-- ----------------------------
-- Table structure for t_attendance_detail
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_attendance_detail";
CREATE TABLE "public"."t_attendance_detail" (
"detail_id" int4 NOT NULL,
"fingerprint_id" int4,
"avatar_id" int4,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_attendance_detail
-- ----------------------------
INSERT INTO "public"."t_attendance_detail" VALUES ('223123', '175382', '321567', '0', 'test', '2017-06-06 21:05:07');
INSERT INTO "public"."t_attendance_detail" VALUES ('223124', '234112', '312634', '0', 'test', '2017-06-07 21:06:19');

-- ----------------------------
-- Table structure for t_attendance_institutions
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_attendance_institutions";
CREATE TABLE "public"."t_attendance_institutions" (
"attendance_id" int4 NOT NULL,
"institutions_id" int4 NOT NULL,
"is_delete" int4 NOT NULL,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_attendance_institutions
-- ----------------------------
INSERT INTO "public"."t_attendance_institutions" VALUES ('312345', '229677', '0', 'test', '2017-06-06 21:07:31');
INSERT INTO "public"."t_attendance_institutions" VALUES ('312346', '381790', '0', 'test', '2017-06-27 21:08:05');

-- ----------------------------
-- Table structure for t_attendance_statistics
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_attendance_statistics";
CREATE TABLE "public"."t_attendance_statistics" (
"statistics_id" int4 NOT NULL,
"statistics_name" varchar(255) COLLATE "default",
"statisics_value" varchar(255) COLLATE "default",
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_attendance_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for t_avatar
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_avatar";
CREATE TABLE "public"."t_avatar" (
"avatar_id" int4 NOT NULL,
"avatar_img" varchar(50) COLLATE "default",
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6),
"institutions_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_avatar
-- ----------------------------
INSERT INTO "public"."t_avatar" VALUES ('312634', 'mayun.jpg', '0', 'test', '2017-06-02 11:41:19', null);
INSERT INTO "public"."t_avatar" VALUES ('321567', 'dilireba.jpg', '0', 'test', '2017-06-06 11:39:30', null);
INSERT INTO "public"."t_avatar" VALUES ('512446', 'wanglihong.jpg', '0', 'test', '2017-06-02 11:41:40', null);

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_class";
CREATE TABLE "public"."t_class" (
"class_id" int4 NOT NULL,
"class_name" varchar(255) COLLATE "default",
"student_count" int4,
"state" int4,
"responsible" varchar(20) COLLATE "default",
"telephone" varchar(20) COLLATE "default",
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6),
"institutions_id" int4,
"start_time" date,
"end_time" date,
"hangye_type" varchar(20) COLLATE "default",
"work_type" varchar(20) COLLATE "default",
"training_mode" varchar(20) COLLATE "default",
"fee" int4,
"is_subsidy" varchar(20) COLLATE "default",
"subsidy_number" int4,
"training_type" varchar(20) COLLATE "default",
"certificate" varchar(20) COLLATE "default",
"training_level" varchar(20) COLLATE "default",
"perfection_standard" varchar(20) COLLATE "default",
"employment_intention" varchar(20) COLLATE "default",
"training_pos" varchar(20) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO "public"."t_class" VALUES ('20', null, null, '0', null, null, '1', 'test', '2017-07-17 13:00:00.273', null, '2017-07-06', '2017-07-06', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO "public"."t_class" VALUES ('575288', '市场价格调查1班', '32', '0', '小王', '17733333333', '0', 'test', '2017-06-06 13:23:09', null, '2017-06-06', '2017-06-24', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO "public"."t_class" VALUES ('575289', '市场价格调查2班', '18', '0', '小李', '18833334444', '0', 'test', '2017-06-07 13:23:13', null, '2017-06-20', '2017-06-25', 'fsdf', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123');
INSERT INTO "public"."t_class" VALUES ('575290', '市场价格调查3班', '6', '0', '小猪', '19933333333', '0', 'test', '2017-06-15 13:23:17', null, '2017-06-05', '2017-06-24', null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for t_class_class_series
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_class_class_series";
CREATE TABLE "public"."t_class_class_series" (
"class_series_id" int4 NOT NULL,
"class_id" int4 NOT NULL,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_class_class_series
-- ----------------------------
INSERT INTO "public"."t_class_class_series" VALUES ('769024', '575288', '0', 'test', '2017-06-14 12:19:55');
INSERT INTO "public"."t_class_class_series" VALUES ('769024', '575289', '0', 'test', '2017-06-14 12:20:21');
INSERT INTO "public"."t_class_class_series" VALUES ('769024', '575290', '0', 'test', '2017-06-19 12:20:49');

-- ----------------------------
-- Table structure for t_class_institutions
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_class_institutions";
CREATE TABLE "public"."t_class_institutions" (
"institutions_id" int4 NOT NULL,
"class_id" int4 NOT NULL,
"is_delete" int4 NOT NULL,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_class_institutions
-- ----------------------------
INSERT INTO "public"."t_class_institutions" VALUES ('999999999', '20', '0', 'test', '2017-07-17 13:00:00.508');
INSERT INTO "public"."t_class_institutions" VALUES ('229677', '575288', '0', 'test', '2017-06-14 09:49:27');
INSERT INTO "public"."t_class_institutions" VALUES ('381790', '575289', '0', 'test', '2017-06-08 09:49:51');
INSERT INTO "public"."t_class_institutions" VALUES ('381790', '575290', '0', 'test', '2017-06-08 09:49:51');

-- ----------------------------
-- Table structure for t_class_series
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_class_series";
CREATE TABLE "public"."t_class_series" (
"class_series_id" int4 NOT NULL,
"class_series_name" varchar(255) COLLATE "default",
"classes_count" int4,
"start_time" date,
"end_time" date,
"state" int4,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_class_series
-- ----------------------------
INSERT INTO "public"."t_class_series" VALUES ('769024', '市场价格调查', '3', '2017-04-27', '2017-07-14', '0', '0', 'test', '2017-06-14 12:18:42');

-- ----------------------------
-- Table structure for t_class_series_completion
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_class_series_completion";
CREATE TABLE "public"."t_class_series_completion" (
"class_series_id" int4 NOT NULL,
"class_series_name" varchar(255) COLLATE "default",
"classes_count" int4,
"start_time" date,
"end_time" date,
"state" int4,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_class_series_completion
-- ----------------------------

-- ----------------------------
-- Table structure for t_class_series_course
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_class_series_course";
CREATE TABLE "public"."t_class_series_course" (
"class_series_id" int4 NOT NULL,
"course_id" int4 NOT NULL,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_class_series_course
-- ----------------------------
INSERT INTO "public"."t_class_series_course" VALUES ('229677', '328765', '0', 'test', '2017-06-12 12:19:10');

-- ----------------------------
-- Table structure for t_class_series_verifyed
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_class_series_verifyed";
CREATE TABLE "public"."t_class_series_verifyed" (
"class_series_id" int4 NOT NULL,
"class_series_name" varchar(255) COLLATE "default",
"classes_count" int4,
"start_time" date,
"end_time" date,
"state" int4,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_class_series_verifyed
-- ----------------------------

-- ----------------------------
-- Table structure for t_class_student
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_class_student";
CREATE TABLE "public"."t_class_student" (
"student_id" int4 NOT NULL,
"class_id" int4 NOT NULL,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_class_student
-- ----------------------------
INSERT INTO "public"."t_class_student" VALUES ('324516', '575288', '0', 'test', '2017-06-05 21:13:09');
INSERT INTO "public"."t_class_student" VALUES ('617821', '575290', '0', 'test', '2017-06-16 21:14:45');
INSERT INTO "public"."t_class_student" VALUES ('713213', '575289', '0', 'test', '2017-06-07 21:14:07');

-- ----------------------------
-- Table structure for t_class_teacher
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_class_teacher";
CREATE TABLE "public"."t_class_teacher" (
"teacher_id" int4 NOT NULL,
"class_id" int4 NOT NULL,
"is_head" int4,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_class_teacher
-- ----------------------------
INSERT INTO "public"."t_class_teacher" VALUES ('371890', '575288', '0', '0', 'test', '2017-06-28 21:16:22');
INSERT INTO "public"."t_class_teacher" VALUES ('728391', '575289', '1', '0', 'test', '2017-06-13 21:17:12');

-- ----------------------------
-- Table structure for t_class_verify
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_class_verify";
CREATE TABLE "public"."t_class_verify" (
"class_series_id" int4 NOT NULL,
"apply_name" varchar(255) COLLATE "default",
"telephone" varchar(255) COLLATE "default",
"apply_state" varchar(255) COLLATE "default",
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_class_verify
-- ----------------------------
INSERT INTO "public"."t_class_verify" VALUES ('769024', '马老师', '18866663333', '0', '0', 'test', '2017-04-19 14:29:03');

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_course";
CREATE TABLE "public"."t_course" (
"course_id" int4 DEFAULT nextval('temp_123_seq'::regclass) NOT NULL,
"course_name" varchar(255) COLLATE "default",
"major_name" varchar(255) COLLATE "default",
"describe" varchar(255) COLLATE "default",
"study_time" int4,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6),
"teacher_name" varchar(20) COLLATE "default",
"teachering_book" varchar(20) COLLATE "default",
"class_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO "public"."t_course" VALUES ('19', '测试', '321', '321', '321', '0', 'test', '2017-07-16 16:34:26.83', '321', '233', null);
INSERT INTO "public"."t_course" VALUES ('328765', '市场价格调查', '市场学', '调查市场的价格', '32', '0', 'test', '2017-05-04 12:15:37', '王老师', '市场学', null);

-- ----------------------------
-- Table structure for t_course_institutions
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_course_institutions";
CREATE TABLE "public"."t_course_institutions" (
"institutions_id" int4 NOT NULL,
"course_id" int4 NOT NULL,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_course_institutions
-- ----------------------------
INSERT INTO "public"."t_course_institutions" VALUES ('229677', '328765', '0', 'test', '2017-06-14 12:17:22');
INSERT INTO "public"."t_course_institutions" VALUES ('999999999', '19', '0', 'test', '2017-07-16 16:34:26.84');

-- ----------------------------
-- Table structure for t_device
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_device";
CREATE TABLE "public"."t_device" (
"device_id" int4 NOT NULL,
"device_code" varchar(255) COLLATE "default",
"description" varchar(255) COLLATE "default",
"buy_time" date,
"state" int4,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_device
-- ----------------------------
INSERT INTO "public"."t_device" VALUES ('234233', '698670', '打卡机', '2017-06-14', '0', '0', 'test', '2017-06-21 21:23:43');
INSERT INTO "public"."t_device" VALUES ('718293', '698668', '打卡机', '2017-06-01', '0', '0', 'test', '2017-06-16 21:20:51');
INSERT INTO "public"."t_device" VALUES ('978310', '698669', '打卡机', '2017-06-08', '0', '0', 'test', '2017-06-14 21:21:58');

-- ----------------------------
-- Table structure for t_device_institutions
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_device_institutions";
CREATE TABLE "public"."t_device_institutions" (
"device_id" int4 NOT NULL,
"institutions_id" int4 NOT NULL,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_device_institutions
-- ----------------------------
INSERT INTO "public"."t_device_institutions" VALUES ('718293', '229677', '0', 'test', '2017-06-05 21:26:16');

-- ----------------------------
-- Table structure for t_fingerprint
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_fingerprint";
CREATE TABLE "public"."t_fingerprint" (
"fingerprint_id" int4 NOT NULL,
"fingerprint_img" varchar(50) COLLATE "default",
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6),
"fingerprint_code" varchar(50) COLLATE "default",
"institutions_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_fingerprint
-- ----------------------------
INSERT INTO "public"."t_fingerprint" VALUES ('175382', 'wanglihong_f.jpg', '0', 'test', '2017-06-02 11:54:18', '4d1224acfa1ea71f256c73bc34d104b4', null);
INSERT INTO "public"."t_fingerprint" VALUES ('231423', 'dilireba_f.jpg', '0', 'test', '2017-06-03 11:52:29', 'e73f43bfa2d7598a3b048cc11a0b1b29', null);
INSERT INTO "public"."t_fingerprint" VALUES ('234112', 'mayun_f.jpg', '0', 'test', '2017-06-03 11:48:07', '01fd6df0f81ee0491eb32d4c05babeef', null);

-- ----------------------------
-- Table structure for t_idcard
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_idcard";
CREATE TABLE "public"."t_idcard" (
"card_id" varchar(32) COLLATE "default" NOT NULL,
"card_name" varchar(20) COLLATE "default",
"gender" int4,
"nation" varchar(20) COLLATE "default",
"birthday" date,
"address" varchar(50) COLLATE "default",
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6),
"institutions_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_idcard
-- ----------------------------
INSERT INTO "public"."t_idcard" VALUES ('420103892813989899', '刘老师', '2', '壮族', '2011-05-19', '北京海淀区牡丹园108号', '0', 'test', '2016-02-18 16:02:16', null);
INSERT INTO "public"."t_idcard" VALUES ('420107199406031123', '迪丽热巴', '2', '维吾尔族', '2014-06-20', '北京海淀区牡丹园88号', '0', 'test', '2017-04-11 05:00:06', null);
INSERT INTO "public"."t_idcard" VALUES ('420107199408217719', '王力宏', '1', '汉族', '2017-05-03', '北京海淀区牡丹园20号', '0', 'test', '2017-05-10 15:54:46', null);
INSERT INTO "public"."t_idcard" VALUES ('420108199506063316', '马云', '1', '汉族', '2017-04-12', '北京海淀区牡丹园6号', '0', 'test', '2017-05-09 15:53:36', null);
INSERT INTO "public"."t_idcard" VALUES ('420331637817283871', '王老师', '1', '汉族', '2017-06-06', '北京海淀区牡丹园88号', '0', 'test', '2017-04-12 16:01:24', null);

-- ----------------------------
-- Table structure for t_idcard_latest
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_idcard_latest";
CREATE TABLE "public"."t_idcard_latest" (
"card_id" varchar(32) COLLATE "default" NOT NULL,
"latest_class" timestamp(6),
"is_ok" int4,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_idcard_latest
-- ----------------------------

-- ----------------------------
-- Table structure for t_institutions
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_institutions";
CREATE TABLE "public"."t_institutions" (
"institutions_id" int4 NOT NULL,
"institutions_name" varchar(50) COLLATE "default",
"responsible" varchar(20) COLLATE "default",
"telephone" varchar(20) COLLATE "default",
"address" varchar(50) COLLATE "default",
"employee_count" int4,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_institutions
-- ----------------------------
INSERT INTO "public"."t_institutions" VALUES ('229677', '通过机构', '阿米', '19463331233', '鸭子路10号', '113', '0', 'test', '2017-06-05 10:54:18');
INSERT INTO "public"."t_institutions" VALUES ('381790', '测试机构2', '小花', '13419990000', '小花路10号', '23', '0', 'test', '2017-06-03 16:46:56');
INSERT INTO "public"."t_institutions" VALUES ('999999998', 'admin创建', 'admin', '00000000000', 'admin', '0', '0', 'test', '2017-06-09 16:18:28');
INSERT INTO "public"."t_institutions" VALUES ('999999999', 'root创建', 'root', '00000000000', 'root', '0', '0', 'test', '2017-06-15 16:06:58');

-- ----------------------------
-- Table structure for t_institutions_apply
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_institutions_apply";
CREATE TABLE "public"."t_institutions_apply" (
"apply_email" varchar(30) COLLATE "default" NOT NULL,
"apply_name" varchar(20) COLLATE "default",
"telephone" varchar(20) COLLATE "default",
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_institutions_apply
-- ----------------------------
INSERT INTO "public"."t_institutions_apply" VALUES ('ff@123.com', '豆豆', '32144443333', '0', 'test', '2017-06-14 01:14:37');
INSERT INTO "public"."t_institutions_apply" VALUES ('test@123.com', '小王', '13499998888', '0', 'test', '2017-06-07 16:18:16');

-- ----------------------------
-- Table structure for t_institutions_filed
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_institutions_filed";
CREATE TABLE "public"."t_institutions_filed" (
"institutions_id" int4 NOT NULL,
"institutions_name" varchar(50) COLLATE "default",
"responsible" varchar(20) COLLATE "default",
"telephone" varchar(20) COLLATE "default",
"address" varchar(50) COLLATE "default",
"employee_count" int4,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_institutions_filed
-- ----------------------------
INSERT INTO "public"."t_institutions_filed" VALUES ('765322', '归档机构', '小3', '13812341234', '归档路10号', '333', '0', '小米', '2017-06-02 10:52:34');

-- ----------------------------
-- Table structure for t_institutions_prepare
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_institutions_prepare";
CREATE TABLE "public"."t_institutions_prepare" (
"institutions_id" int4 NOT NULL,
"institutions_name" varchar(50) COLLATE "default",
"responsible" varchar(20) COLLATE "default",
"telephone" varchar(20) COLLATE "default",
"address" varchar(50) COLLATE "default",
"employee_count" int4,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_institutions_prepare
-- ----------------------------
INSERT INTO "public"."t_institutions_prepare" VALUES ('188426', '测试机构', '王老师', '12300000000', '测试路10号', '30', '0', 'test', '2017-06-07 16:18:16');
INSERT INTO "public"."t_institutions_prepare" VALUES ('321142', '测试机构2', '小老师', '32311112222', '小猫路10号', '24', '0', 'test', '2017-06-06 01:13:51');

-- ----------------------------
-- Table structure for t_institutions_teacher
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_institutions_teacher";
CREATE TABLE "public"."t_institutions_teacher" (
"institutions_id" int4 NOT NULL,
"teacher_id" int4 NOT NULL,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_institutions_teacher
-- ----------------------------
INSERT INTO "public"."t_institutions_teacher" VALUES ('229677', '371890', '0', 'test', '2017-06-06 21:31:36');
INSERT INTO "public"."t_institutions_teacher" VALUES ('381790', '728391', '0', 'test', '2017-06-21 21:32:06');

-- ----------------------------
-- Table structure for t_institutions_verify
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_institutions_verify";
CREATE TABLE "public"."t_institutions_verify" (
"apply_email" varchar(30) COLLATE "default" NOT NULL,
"institutions_id" int4 NOT NULL,
"approval_date" timestamp(6),
"is_delete" int4 NOT NULL,
"create_by" varchar(20) COLLATE "default" NOT NULL,
"create_at" timestamp(6) NOT NULL,
"apply_date" timestamp(6) NOT NULL,
"apply_state" int4 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_institutions_verify"."apply_email" IS '申请人邮箱';
COMMENT ON COLUMN "public"."t_institutions_verify"."institutions_id" IS '机构id';
COMMENT ON COLUMN "public"."t_institutions_verify"."apply_date" IS '申请时间';
COMMENT ON COLUMN "public"."t_institutions_verify"."apply_state" IS '申请状态(0申请中 1已通过 2不通过)';

-- ----------------------------
-- Records of t_institutions_verify
-- ----------------------------
INSERT INTO "public"."t_institutions_verify" VALUES ('ff@123.com', '321142', null, '0', 'test', '2017-06-13 01:17:24', '2017-06-24 01:17:28', '0');
INSERT INTO "public"."t_institutions_verify" VALUES ('test@123.com', '188426', '2017-06-11 11:04:20.698', '0', 'test', '2017-06-07 16:18:16', '2017-06-07 16:18:16', '1');

-- ----------------------------
-- Table structure for t_ip_device
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_ip_device";
CREATE TABLE "public"."t_ip_device" (
"dev_hao" int4 NOT NULL,
"ip" varchar(30) COLLATE "default",
"http_port" int2,
"dev_port" int2,
"username" varchar(30) COLLATE "default",
"password" varchar(128) COLLATE "default",
"dev_stype" varchar(50) COLLATE "default",
"dev_adr" varchar(50) COLLATE "default",
"dev_description" varchar(255) COLLATE "default",
"institution" varchar(50) COLLATE "default",
"inst_route" varchar(50) COLLATE "default",
"dev_effect" bool,
"inst_route_port" int2
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_ip_device
-- ----------------------------

-- ----------------------------
-- Table structure for t_operation_record
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_operation_record";
CREATE TABLE "public"."t_operation_record" (
"record_id" int4 NOT NULL,
"record_time" timestamp(6) NOT NULL,
"record_type" int4 NOT NULL,
"table_name" varchar(255) COLLATE "default" NOT NULL,
"is_delete" int4 NOT NULL,
"create_by" varchar(20) COLLATE "default" NOT NULL,
"create_at" timestamp(6) NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_operation_record
-- ----------------------------

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_student";
CREATE TABLE "public"."t_student" (
"student_id" int4 NOT NULL,
"telephone" varchar(20) COLLATE "default",
"email" varchar(30) COLLATE "default",
"education" int4,
"insured_state" int4,
"state" int4,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO "public"."t_student" VALUES ('324516', '18822228888', 'mayun@123.com', '3', '1', '1', '0', 'test', '2017-06-02 11:47:28');
INSERT INTO "public"."t_student" VALUES ('617821', '13266664545', 'dilireba@qq.com', '1', '1', '1', '0', 'test', '2017-06-11 11:58:58');
INSERT INTO "public"."t_student" VALUES ('713213', '19866667777', 'wanglihong@234.com', '2', '0', '1', '0', 'test', '2017-06-10 11:58:27');

-- ----------------------------
-- Table structure for t_student_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_student_info";
CREATE TABLE "public"."t_student_info" (
"student_id" int4 NOT NULL,
"card_id" varchar(32) COLLATE "default" NOT NULL,
"fingerprint_id" int4 NOT NULL,
"avatar_id" int4 NOT NULL,
"responsible" varchar(20) COLLATE "default",
"telephone" varchar(20) COLLATE "default",
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6),
"account_name" varchar(20) COLLATE "default",
"account_back" varchar(20) COLLATE "default",
"account_number" varchar(20) COLLATE "default",
"people_type" int4,
"tuition" int4,
"subsidy" int4,
"subsidy_type" int4,
"is_refund" int4,
"residence_type" int4,
"residence" int4,
"is_discontinue" int4,
"discontinue_date" int4,
"has_certificate" int4,
"certificate_level" int4,
"certificate_name" varchar(20) COLLATE "default",
"has_training_vouchers" int4,
"training_vouchers_number" varchar(20) COLLATE "default",
"is_new_employees" int4,
"contract_period" int4,
"people_name" varchar(20) COLLATE "default",
"absent_days" int4,
"theoretical_mark" int4,
"practical_mark" int4,
"certificate_number" int4,
"fee" int4,
"sex" int4,
"has_subsidy" int4,
"is_ok" int4,
"is_appraisal" int4,
"appraisal_type" int4,
"appraisal_date" date,
"appraisal_level" int4,
"appraisal_number" varchar COLLATE "default",
"appraisal_name" varchar COLLATE "default",
"appraisal_office" varchar(20) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_student_info
-- ----------------------------
INSERT INTO "public"."t_student_info" VALUES ('1', '420800197401241547', '1', '1', '蔡毅', '13800003333', '0', 'test', '2017-07-20 00:00:00', '5153123', '中国银行', '62645433198', '3', '1000', '900', '1', '1', '1', '33', '1', '99', '1', '5', '国家职业资格证书', '1', '200', '1', '5', '小明', '30', '99', '99', '72716663', '100', '1', '1', '1', '1', '2', '2017-07-13', '4', '1417800000401', '中华人民共和国', '职业技能鉴定');
INSERT INTO "public"."t_student_info" VALUES ('324516', '420108199506063316', '234112', '312634', '马老师', '13944165512', '0', 'test', '2017-06-02 11:34:51', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO "public"."t_student_info" VALUES ('617821', '420107199406031123', '231423', '321567', '马老师', '13944165112', '0', 'test', '2017-06-01 12:03:16', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO "public"."t_student_info" VALUES ('713213', '420107199408217719', '175382', '512446', '马老师', '13944165112', '0', 'test', '2017-06-03 12:01:25', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_teacher";
CREATE TABLE "public"."t_teacher" (
"teacher_id" int4 NOT NULL,
"telephone" varchar(20) COLLATE "default",
"email" varchar(30) COLLATE "default",
"education" int4,
"state" int4,
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6),
"institutions_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO "public"."t_teacher" VALUES ('371890', '13877774444', 'test@abc.com', '1', '0', '0', 'test', '2015-05-13 16:13:49', null);
INSERT INTO "public"."t_teacher" VALUES ('728391', '14912536712', 'good@ddc.net', '2', '0', '0', 'test', '2013-03-11 16:14:41', null);

-- ----------------------------
-- Table structure for t_teacher_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_teacher_info";
CREATE TABLE "public"."t_teacher_info" (
"teacher_id" int4 NOT NULL,
"card_id" varchar(32) COLLATE "default" NOT NULL,
"responsible" varchar(20) COLLATE "default",
"telephone" varchar(20) COLLATE "default",
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_teacher_info
-- ----------------------------
INSERT INTO "public"."t_teacher_info" VALUES ('371890', '420331637817283871', '审核员', '13766663333', '0', 'test', '2017-06-06 16:20:07');
INSERT INTO "public"."t_teacher_info" VALUES ('728391', '420103892813989899', 'check', '13966627789', '0', 'good', '2017-04-13 16:20:46');

-- ----------------------------
-- Table structure for t_ukey
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_ukey";
CREATE TABLE "public"."t_ukey" (
"id" int4 DEFAULT nextval('t_ukey_id_seq'::regclass) NOT NULL,
"ukey_id" varchar(128) COLLATE "default" NOT NULL,
"responsible" varchar(32) COLLATE "default" NOT NULL,
"telephone" varchar(32) COLLATE "default" NOT NULL,
"is_delete" int4 NOT NULL,
"create_by" varchar(20) COLLATE "default" NOT NULL,
"create_at" timestamp(6) NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_ukey
-- ----------------------------
INSERT INTO "public"."t_ukey" VALUES ('1', '912ec803b2ce49e4a541068d495ab570', '刘测试', '19933227766', '0', 'test', '2017-06-06 14:50:43');

-- ----------------------------
-- Table structure for t_update_record
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_update_record";
CREATE TABLE "public"."t_update_record" (
"record_id" int4 NOT NULL,
"record_time" timestamp(6),
"table_name" varchar(255) COLLATE "default",
"field_name" varchar(255) COLLATE "default",
"old_value" varchar(255) COLLATE "default",
"new_value" varchar(255) COLLATE "default",
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_update_record
-- ----------------------------

-- ----------------------------
-- Table structure for t_verify_record
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_verify_record";
CREATE TABLE "public"."t_verify_record" (
"record_id" int4 NOT NULL,
"responsible" varchar(255) COLLATE "default",
"telephone" varchar(255) COLLATE "default",
"verify_type" int4,
"record_time" timestamp(6),
"record_content" varchar(255) COLLATE "default",
"is_delete" int4,
"create_by" varchar(20) COLLATE "default",
"create_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_verify_record
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_accessResource
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbl_accessResource";
CREATE TABLE "public"."tbl_accessResource" (
"id" int4 DEFAULT nextval('"tbl_accessResource_id_seq"'::regclass) NOT NULL,
"resource_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"resource_name" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"resource_desc" varchar(50) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"resource_path" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"ebable" int2 DEFAULT 1 NOT NULL,
"create_time" timestamp(6) NOT NULL,
"update_time" timestamp(6) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tbl_accessResource" IS '访问资源表';
COMMENT ON COLUMN "public"."tbl_accessResource"."id" IS '主键';
COMMENT ON COLUMN "public"."tbl_accessResource"."resource_id" IS '资源Id';
COMMENT ON COLUMN "public"."tbl_accessResource"."resource_name" IS '资源名称';
COMMENT ON COLUMN "public"."tbl_accessResource"."resource_desc" IS '资源描述';
COMMENT ON COLUMN "public"."tbl_accessResource"."resource_path" IS '资源路径';
COMMENT ON COLUMN "public"."tbl_accessResource"."ebable" IS '资源是否可用，0=不可用，1=可用';
COMMENT ON COLUMN "public"."tbl_accessResource"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."tbl_accessResource"."update_time" IS '更新时间';

-- ----------------------------
-- Records of tbl_accessResource
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_account
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbl_account";
CREATE TABLE "public"."tbl_account" (
"id" int4 DEFAULT nextval('tbl_account_id_seq'::regclass) NOT NULL,
"user_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"account" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"password" varchar(128) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"login_ip" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"login_time" timestamp(6) NOT NULL,
"enable" int2 DEFAULT 1 NOT NULL,
"is_locked" int2 DEFAULT 0 NOT NULL,
"is_expired" int2 DEFAULT 0 NOT NULL,
"deadLine" timestamp(6) DEFAULT '2030-01-01 00:00:00'::timestamp without time zone NOT NULL,
"create_time" timestamp(6) NOT NULL,
"update_time" timestamp(6) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tbl_account" IS '账号信息表';
COMMENT ON COLUMN "public"."tbl_account"."id" IS '主键';
COMMENT ON COLUMN "public"."tbl_account"."user_id" IS '用户Id';
COMMENT ON COLUMN "public"."tbl_account"."account" IS '账号';
COMMENT ON COLUMN "public"."tbl_account"."password" IS '密码(密文)';
COMMENT ON COLUMN "public"."tbl_account"."login_ip" IS '最近一次登录Ip';
COMMENT ON COLUMN "public"."tbl_account"."login_time" IS '最近一次登录时间';
COMMENT ON COLUMN "public"."tbl_account"."enable" IS '账号是否可用，0=不可用，1=可用';
COMMENT ON COLUMN "public"."tbl_account"."is_locked" IS '账号是否锁定，0=未锁定，1=锁定';
COMMENT ON COLUMN "public"."tbl_account"."is_expired" IS '账号是否过期，0=未过期，1=过期';
COMMENT ON COLUMN "public"."tbl_account"."deadLine" IS '过期时间';
COMMENT ON COLUMN "public"."tbl_account"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."tbl_account"."update_time" IS '更新时间';

-- ----------------------------
-- Records of tbl_account
-- ----------------------------
INSERT INTO "public"."tbl_account" VALUES ('1', '', 'root', '63a9f0ea7bb98050796b649e85481845', '112.74.35.167', '2017-06-09 15:40:47', '1', '0', '0', '2017-06-30 15:39:24', '2017-06-03 15:39:39', '2017-06-16 15:39:36');

-- ----------------------------
-- Table structure for tbl_account_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbl_account_role";
CREATE TABLE "public"."tbl_account_role" (
"id" int4 DEFAULT nextval('tbl_account_role_id_seq'::regclass) NOT NULL,
"role_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"user_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tbl_account_role" IS '账号角色关联表';
COMMENT ON COLUMN "public"."tbl_account_role"."id" IS '主键';
COMMENT ON COLUMN "public"."tbl_account_role"."role_id" IS '角色Id';
COMMENT ON COLUMN "public"."tbl_account_role"."user_id" IS '用户Id';

-- ----------------------------
-- Records of tbl_account_role
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_authority
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbl_authority";
CREATE TABLE "public"."tbl_authority" (
"id" int4 DEFAULT nextval('tbl_authority_id_seq'::regclass) NOT NULL,
"authority_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"authority_name" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"authority_desc" varchar(50) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"prompt_message" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"enable" int2 DEFAULT 1 NOT NULL,
"create_time" timestamp(6) NOT NULL,
"update_time" timestamp(6) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tbl_authority" IS '权限记录表';
COMMENT ON COLUMN "public"."tbl_authority"."id" IS '主键';
COMMENT ON COLUMN "public"."tbl_authority"."authority_id" IS '权限Id';
COMMENT ON COLUMN "public"."tbl_authority"."authority_name" IS '权限名称，约定以AUTH_起始';
COMMENT ON COLUMN "public"."tbl_authority"."authority_desc" IS '权限描述';
COMMENT ON COLUMN "public"."tbl_authority"."prompt_message" IS '提示信息';
COMMENT ON COLUMN "public"."tbl_authority"."enable" IS '资源是否可用，0=不可用，1=可用';
COMMENT ON COLUMN "public"."tbl_authority"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."tbl_authority"."update_time" IS '更新时间';

-- ----------------------------
-- Records of tbl_authority
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_authority_resource
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbl_authority_resource";
CREATE TABLE "public"."tbl_authority_resource" (
"id" int4 DEFAULT nextval('tbl_authority_resource_id_seq'::regclass) NOT NULL,
"authority_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"resource_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tbl_authority_resource" IS '权限资源关联表';
COMMENT ON COLUMN "public"."tbl_authority_resource"."id" IS '主键';
COMMENT ON COLUMN "public"."tbl_authority_resource"."authority_id" IS '权限Id';
COMMENT ON COLUMN "public"."tbl_authority_resource"."resource_id" IS '权限Id';

-- ----------------------------
-- Records of tbl_authority_resource
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_indicator_statistics
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbl_indicator_statistics";
CREATE TABLE "public"."tbl_indicator_statistics" (
"id" int4 DEFAULT nextval('tbl_indicator_statistics_id_seq'::regclass) NOT NULL,
"indicator_type" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"indicator_name" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"cycle_time" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"cycle_Statistics_value" int4 NOT NULL,
"update_time" timestamp(6) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tbl_indicator_statistics" IS '指标统计记录表';
COMMENT ON COLUMN "public"."tbl_indicator_statistics"."id" IS '主键';
COMMENT ON COLUMN "public"."tbl_indicator_statistics"."indicator_type" IS '指标类型';
COMMENT ON COLUMN "public"."tbl_indicator_statistics"."indicator_name" IS '指标名称';
COMMENT ON COLUMN "public"."tbl_indicator_statistics"."cycle_time" IS '周期 n+(m,h,d,M,y), n为数字';
COMMENT ON COLUMN "public"."tbl_indicator_statistics"."cycle_Statistics_value" IS '周期统计值';
COMMENT ON COLUMN "public"."tbl_indicator_statistics"."update_time" IS '更新时间';

-- ----------------------------
-- Records of tbl_indicator_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbl_role";
CREATE TABLE "public"."tbl_role" (
"id" int4 DEFAULT nextval('tbl_role_id_seq'::regclass) NOT NULL,
"role_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"role_name" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"role_desc" varchar(50) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"priority" int2 DEFAULT 100 NOT NULL,
"enable" int2 DEFAULT 1 NOT NULL,
"create_time" timestamp(6) NOT NULL,
"update_time" timestamp(6) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tbl_role" IS '角色记录表';
COMMENT ON COLUMN "public"."tbl_role"."id" IS '主键';
COMMENT ON COLUMN "public"."tbl_role"."role_id" IS '角色Id';
COMMENT ON COLUMN "public"."tbl_role"."role_name" IS '角色名称，约定以ROLE_起始';
COMMENT ON COLUMN "public"."tbl_role"."role_desc" IS '角色描述';
COMMENT ON COLUMN "public"."tbl_role"."priority" IS '优先级,值越小优先级越大';
COMMENT ON COLUMN "public"."tbl_role"."enable" IS '角色是否可用，0=不可用，1=可用';
COMMENT ON COLUMN "public"."tbl_role"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."tbl_role"."update_time" IS '更新时间';

-- ----------------------------
-- Records of tbl_role
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_role_authority
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbl_role_authority";
CREATE TABLE "public"."tbl_role_authority" (
"id" int4 DEFAULT nextval('tbl_role_authority_id_seq'::regclass) NOT NULL,
"role_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"authority_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tbl_role_authority" IS '角色权限关联表';
COMMENT ON COLUMN "public"."tbl_role_authority"."id" IS '主键';
COMMENT ON COLUMN "public"."tbl_role_authority"."role_id" IS '角色Id';
COMMENT ON COLUMN "public"."tbl_role_authority"."authority_id" IS '权限Id';

-- ----------------------------
-- Records of tbl_role_authority
-- ----------------------------

-- ----------------------------
-- Table structure for temp
-- ----------------------------
DROP TABLE IF EXISTS "public"."temp";
CREATE TABLE "public"."temp" (
"123" int4 DEFAULT nextval('temp_123_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of temp
-- ----------------------------

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
ALTER SEQUENCE "public"."t_account_account_id_seq" OWNED BY "t_account"."account_id";
ALTER SEQUENCE "public"."t_ukey_id_seq" OWNED BY "t_ukey"."id";
ALTER SEQUENCE "public"."tbl_accessResource_id_seq" OWNED BY "tbl_accessResource"."id";
ALTER SEQUENCE "public"."tbl_account_id_seq" OWNED BY "tbl_account"."id";
ALTER SEQUENCE "public"."tbl_account_role_id_seq" OWNED BY "tbl_account_role"."id";
ALTER SEQUENCE "public"."tbl_authority_id_seq" OWNED BY "tbl_authority"."id";
ALTER SEQUENCE "public"."tbl_authority_resource_id_seq" OWNED BY "tbl_authority_resource"."id";
ALTER SEQUENCE "public"."tbl_indicator_statistics_id_seq" OWNED BY "tbl_indicator_statistics"."id";
ALTER SEQUENCE "public"."tbl_role_authority_id_seq" OWNED BY "tbl_role_authority"."id";
ALTER SEQUENCE "public"."tbl_role_id_seq" OWNED BY "tbl_role"."id";
ALTER SEQUENCE "public"."temp_123_seq" OWNED BY "temp"."123";

-- ----------------------------
-- Uniques structure for table t_account
-- ----------------------------
ALTER TABLE "public"."t_account" ADD UNIQUE ("account");

-- ----------------------------
-- Primary Key structure for table t_account
-- ----------------------------
ALTER TABLE "public"."t_account" ADD PRIMARY KEY ("account");

-- ----------------------------
-- Primary Key structure for table t_attendance
-- ----------------------------
ALTER TABLE "public"."t_attendance" ADD PRIMARY KEY ("attendance_id", "deviceid", "detail_id");

-- ----------------------------
-- Primary Key structure for table t_attendance_detail
-- ----------------------------
ALTER TABLE "public"."t_attendance_detail" ADD PRIMARY KEY ("detail_id");

-- ----------------------------
-- Primary Key structure for table t_attendance_institutions
-- ----------------------------
ALTER TABLE "public"."t_attendance_institutions" ADD PRIMARY KEY ("institutions_id");

-- ----------------------------
-- Primary Key structure for table t_attendance_statistics
-- ----------------------------
ALTER TABLE "public"."t_attendance_statistics" ADD PRIMARY KEY ("statistics_id");

-- ----------------------------
-- Uniques structure for table t_avatar
-- ----------------------------
ALTER TABLE "public"."t_avatar" ADD UNIQUE ("institutions_id");

-- ----------------------------
-- Primary Key structure for table t_avatar
-- ----------------------------
ALTER TABLE "public"."t_avatar" ADD PRIMARY KEY ("avatar_id");

-- ----------------------------
-- Uniques structure for table t_class
-- ----------------------------
ALTER TABLE "public"."t_class" ADD UNIQUE ("institutions_id");

-- ----------------------------
-- Primary Key structure for table t_class
-- ----------------------------
ALTER TABLE "public"."t_class" ADD PRIMARY KEY ("class_id");

-- ----------------------------
-- Primary Key structure for table t_class_class_series
-- ----------------------------
ALTER TABLE "public"."t_class_class_series" ADD PRIMARY KEY ("class_series_id", "class_id");

-- ----------------------------
-- Primary Key structure for table t_class_institutions
-- ----------------------------
ALTER TABLE "public"."t_class_institutions" ADD PRIMARY KEY ("class_id");

-- ----------------------------
-- Primary Key structure for table t_class_series
-- ----------------------------
ALTER TABLE "public"."t_class_series" ADD PRIMARY KEY ("class_series_id");

-- ----------------------------
-- Primary Key structure for table t_class_series_completion
-- ----------------------------
ALTER TABLE "public"."t_class_series_completion" ADD PRIMARY KEY ("class_series_id");

-- ----------------------------
-- Primary Key structure for table t_class_series_course
-- ----------------------------
ALTER TABLE "public"."t_class_series_course" ADD PRIMARY KEY ("class_series_id", "course_id");

-- ----------------------------
-- Primary Key structure for table t_class_series_verifyed
-- ----------------------------
ALTER TABLE "public"."t_class_series_verifyed" ADD PRIMARY KEY ("class_series_id");

-- ----------------------------
-- Primary Key structure for table t_class_student
-- ----------------------------
ALTER TABLE "public"."t_class_student" ADD PRIMARY KEY ("student_id", "class_id");

-- ----------------------------
-- Primary Key structure for table t_class_teacher
-- ----------------------------
ALTER TABLE "public"."t_class_teacher" ADD PRIMARY KEY ("teacher_id", "class_id");

-- ----------------------------
-- Primary Key structure for table t_class_verify
-- ----------------------------
ALTER TABLE "public"."t_class_verify" ADD PRIMARY KEY ("class_series_id");

-- ----------------------------
-- Primary Key structure for table t_course
-- ----------------------------
ALTER TABLE "public"."t_course" ADD PRIMARY KEY ("course_id");

-- ----------------------------
-- Primary Key structure for table t_course_institutions
-- ----------------------------
ALTER TABLE "public"."t_course_institutions" ADD PRIMARY KEY ("institutions_id", "course_id");

-- ----------------------------
-- Primary Key structure for table t_device
-- ----------------------------
ALTER TABLE "public"."t_device" ADD PRIMARY KEY ("device_id");

-- ----------------------------
-- Primary Key structure for table t_device_institutions
-- ----------------------------
ALTER TABLE "public"."t_device_institutions" ADD PRIMARY KEY ("device_id", "institutions_id");

-- ----------------------------
-- Uniques structure for table t_fingerprint
-- ----------------------------
ALTER TABLE "public"."t_fingerprint" ADD UNIQUE ("institutions_id");

-- ----------------------------
-- Primary Key structure for table t_fingerprint
-- ----------------------------
ALTER TABLE "public"."t_fingerprint" ADD PRIMARY KEY ("fingerprint_id");

-- ----------------------------
-- Uniques structure for table t_idcard
-- ----------------------------
ALTER TABLE "public"."t_idcard" ADD UNIQUE ("institutions_id");

-- ----------------------------
-- Primary Key structure for table t_idcard
-- ----------------------------
ALTER TABLE "public"."t_idcard" ADD PRIMARY KEY ("card_id");

-- ----------------------------
-- Primary Key structure for table t_idcard_latest
-- ----------------------------
ALTER TABLE "public"."t_idcard_latest" ADD PRIMARY KEY ("card_id");

-- ----------------------------
-- Primary Key structure for table t_institutions
-- ----------------------------
ALTER TABLE "public"."t_institutions" ADD PRIMARY KEY ("institutions_id");

-- ----------------------------
-- Primary Key structure for table t_institutions_apply
-- ----------------------------
ALTER TABLE "public"."t_institutions_apply" ADD PRIMARY KEY ("apply_email");

-- ----------------------------
-- Primary Key structure for table t_institutions_filed
-- ----------------------------
ALTER TABLE "public"."t_institutions_filed" ADD PRIMARY KEY ("institutions_id");

-- ----------------------------
-- Primary Key structure for table t_institutions_prepare
-- ----------------------------
ALTER TABLE "public"."t_institutions_prepare" ADD PRIMARY KEY ("institutions_id");

-- ----------------------------
-- Primary Key structure for table t_institutions_teacher
-- ----------------------------
ALTER TABLE "public"."t_institutions_teacher" ADD PRIMARY KEY ("institutions_id", "teacher_id");

-- ----------------------------
-- Primary Key structure for table t_institutions_verify
-- ----------------------------
ALTER TABLE "public"."t_institutions_verify" ADD PRIMARY KEY ("apply_email", "institutions_id");

-- ----------------------------
-- Primary Key structure for table t_ip_device
-- ----------------------------
ALTER TABLE "public"."t_ip_device" ADD PRIMARY KEY ("dev_hao");

-- ----------------------------
-- Primary Key structure for table t_operation_record
-- ----------------------------
ALTER TABLE "public"."t_operation_record" ADD PRIMARY KEY ("record_id");

-- ----------------------------
-- Primary Key structure for table t_student
-- ----------------------------
ALTER TABLE "public"."t_student" ADD PRIMARY KEY ("student_id");

-- ----------------------------
-- Primary Key structure for table t_student_info
-- ----------------------------
ALTER TABLE "public"."t_student_info" ADD PRIMARY KEY ("student_id", "card_id", "fingerprint_id", "avatar_id");

-- ----------------------------
-- Uniques structure for table t_teacher
-- ----------------------------
ALTER TABLE "public"."t_teacher" ADD UNIQUE ("institutions_id");

-- ----------------------------
-- Primary Key structure for table t_teacher
-- ----------------------------
ALTER TABLE "public"."t_teacher" ADD PRIMARY KEY ("teacher_id");

-- ----------------------------
-- Primary Key structure for table t_teacher_info
-- ----------------------------
ALTER TABLE "public"."t_teacher_info" ADD PRIMARY KEY ("teacher_id", "card_id");

-- ----------------------------
-- Primary Key structure for table t_ukey
-- ----------------------------
ALTER TABLE "public"."t_ukey" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_update_record
-- ----------------------------
ALTER TABLE "public"."t_update_record" ADD PRIMARY KEY ("record_id");

-- ----------------------------
-- Primary Key structure for table t_verify_record
-- ----------------------------
ALTER TABLE "public"."t_verify_record" ADD PRIMARY KEY ("record_id");

-- ----------------------------
-- Uniques structure for table tbl_accessResource
-- ----------------------------
ALTER TABLE "public"."tbl_accessResource" ADD UNIQUE ("resource_id");

-- ----------------------------
-- Primary Key structure for table tbl_accessResource
-- ----------------------------
ALTER TABLE "public"."tbl_accessResource" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table tbl_account
-- ----------------------------
CREATE INDEX "idx_user_id" ON "public"."tbl_account" USING btree (user_id);

-- ----------------------------
-- Uniques structure for table tbl_account
-- ----------------------------
ALTER TABLE "public"."tbl_account" ADD UNIQUE ("account");

-- ----------------------------
-- Primary Key structure for table tbl_account
-- ----------------------------
ALTER TABLE "public"."tbl_account" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table tbl_account_role
-- ----------------------------
CREATE INDEX "tbl_account_role_role_id_idx" ON "public"."tbl_account_role" USING btree (role_id);
CREATE INDEX "tbl_account_role_user_id_idx" ON "public"."tbl_account_role" USING btree (user_id);

-- ----------------------------
-- Primary Key structure for table tbl_account_role
-- ----------------------------
ALTER TABLE "public"."tbl_account_role" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table tbl_authority
-- ----------------------------
CREATE INDEX "idx_authority_id" ON "public"."tbl_authority" USING btree (authority_id);

-- ----------------------------
-- Uniques structure for table tbl_authority
-- ----------------------------
ALTER TABLE "public"."tbl_authority" ADD UNIQUE ("authority_name");

-- ----------------------------
-- Primary Key structure for table tbl_authority
-- ----------------------------
ALTER TABLE "public"."tbl_authority" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table tbl_authority_resource
-- ----------------------------
CREATE INDEX "tbl_authority_resource_authority_id_idx" ON "public"."tbl_authority_resource" USING btree (authority_id);
CREATE INDEX "tbl_authority_resource_resource_id_idx" ON "public"."tbl_authority_resource" USING btree (resource_id);

-- ----------------------------
-- Primary Key structure for table tbl_authority_resource
-- ----------------------------
ALTER TABLE "public"."tbl_authority_resource" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table tbl_indicator_statistics
-- ----------------------------
ALTER TABLE "public"."tbl_indicator_statistics" ADD UNIQUE ("indicator_type", "indicator_name");

-- ----------------------------
-- Primary Key structure for table tbl_indicator_statistics
-- ----------------------------
ALTER TABLE "public"."tbl_indicator_statistics" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table tbl_role
-- ----------------------------
CREATE INDEX "tbl_role_role_id_idx" ON "public"."tbl_role" USING btree (role_id);

-- ----------------------------
-- Uniques structure for table tbl_role
-- ----------------------------
ALTER TABLE "public"."tbl_role" ADD UNIQUE ("role_name");

-- ----------------------------
-- Primary Key structure for table tbl_role
-- ----------------------------
ALTER TABLE "public"."tbl_role" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table tbl_role_authority
-- ----------------------------
CREATE INDEX "tbl_role_authority_authority_id_idx" ON "public"."tbl_role_authority" USING btree (authority_id);
CREATE INDEX "tbl_role_authority_role_id_idx" ON "public"."tbl_role_authority" USING btree (role_id);

-- ----------------------------
-- Primary Key structure for table tbl_role_authority
-- ----------------------------
ALTER TABLE "public"."tbl_role_authority" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Key structure for table "public"."t_institutions_verify"
-- ----------------------------
ALTER TABLE "public"."t_institutions_verify" ADD FOREIGN KEY ("apply_email") REFERENCES "public"."t_institutions_apply" ("apply_email") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."t_institutions_verify" ADD FOREIGN KEY ("institutions_id") REFERENCES "public"."t_institutions_prepare" ("institutions_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
