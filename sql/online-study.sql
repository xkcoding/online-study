CREATE TABLE `user_info` (
	`user_id`     VARCHAR(32) NOT NULL,
	`username`    VARCHAR(32) NOT NULL,
	`password`    VARCHAR(32) NOT NULL,
	`salt`        VARCHAR(32) NOT NULL,
	`wx_openid`   VARCHAR(32) NOT NULL
	COMMENT '微信 openid',
	`qq_openid`   VARCHAR(32) NOT NULL
	COMMENT 'QQ openid',
	`phone`       VARCHAR(32) NOT NULL
	COMMENT '用户手机号',
	`is_teacher`  TINYINT(3)  NOT NULL DEFAULT 0
	COMMENT '是否为讲师，默认不是',
	`ip`          VARCHAR(32) NOT NULL
	COMMENT '登录IP',
	`login_times` INT NOT NULL DEFAULT 0 COMMENT '总共登录次数',
	`last_time`   TIMESTAMP   NOT NULL DEFAULT current_timestamp
	COMMENT '上次登录时间',
	`create_time` TIMESTAMP   NOT NULL DEFAULT current_timestamp
	COMMENT '创建时间',
	`update_time` TIMESTAMP   NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
	COMMENT '更新时间',
	PRIMARY KEY (`user_id`)
)
	COMMENT '用户信息表';

CREATE TABLE `course_master` (
	`course_id`          VARCHAR(32)  NOT NULL,
	`course_name`        VARCHAR(32)  NOT NULL
	COMMENT '课程名称',
	`teacher_id`         VARCHAR(32)  NOT NULL
	COMMENT '讲师id',
	`course_count`       INT          NOT NULL
	COMMENT '课程总集数',
	`course_description` VARCHAR(512) NOT NULL
	COMMENT '课程描述',
	`category_type`      INT          NOT NULL
	COMMENT '类目编号',
	`course_icon`        VARCHAR(512) NOT NULL
	COMMENT '课程主缩略图',
	`course_duration`    VARCHAR(32)  NOT NULL DEFAULT '0'
	COMMENT '视频总时长',
	`create_time`        TIMESTAMP    NOT NULL DEFAULT current_timestamp
	COMMENT '创建时间',
	`update_time`        TIMESTAMP    NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
	COMMENT '更新时间',
	PRIMARY KEY (`course_id`),
	KEY `idx_teacher_id` (`teacher_id`)
)
	COMMENT '课程表';

CREATE TABLE `course_category` (
	`category_id`   INT         NOT NULL AUTO_INCREMENT,
	`category_name` VARCHAR(32) NOT NULL
	COMMENT '类目名字',
	`category_type` INT         NOT NULL
	COMMENT '类目编号',
	`create_time`   TIMESTAMP   NOT NULL DEFAULT current_timestamp
	COMMENT '创建时间',
	`update_time`   TIMESTAMP   NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
	COMMENT '更新时间',
	PRIMARY KEY (`category_id`),
	UNIQUE KEY `uqe_category_type` (`category_type`)
)
	COMMENT '课程类目表';

CREATE TABLE `course_detail` (
	`detail_id`          VARCHAR(32)  NOT NULL,
	`course_id`          VARCHAR(32)  NOT NULL
	COMMENT '所属课程',
	`course_index`       INT          NOT NULL
	COMMENT '课程顺序',
	`detail_name`        VARCHAR(32)  NOT NULL
	COMMENT '每集的详情名称',
	`detail_description` VARCHAR(512) NOT NULL
	COMMENT '每集的详情描述',
	`detail_icon`        VARCHAR(512) NOT NULL
	COMMENT '每集的详情缩略图',
	`detail_url`         VARCHAR(512) NOT NULL
	COMMENT '每集的播放地址',
	`detail_duration`    VARCHAR(32)  NOT NULL DEFAULT '0'
	COMMENT '每集的播放时长',
	`create_time`        TIMESTAMP    NOT NULL DEFAULT current_timestamp
	COMMENT '创建时间',
	`update_time`        TIMESTAMP    NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
	COMMENT '更新时间',
	PRIMARY KEY (`detail_id`),
	KEY `idx_course_id` (`course_id`)
)
	COMMENT '课程详情表';

CREATE TABLE `study_log` (
	`log_id`        VARCHAR(32) NOT NULL,
	`user_id`       VARCHAR(32) NOT NULL,
	`detail_id`     VARCHAR(32) NOT NULL,
	`category_type` INT         NOT NULL
	COMMENT '类目编号',
	`is_complete`   TINYINT(3)  NOT NULL DEFAULT '0'
	COMMENT '是否已完成',
	`record`        VARCHAR(32) NOT NULL DEFAULT '0'
	COMMENT '记录播放时间，已完成则置为0',
	`create_time`   TIMESTAMP   NOT NULL DEFAULT current_timestamp
	COMMENT '创建时间',
	`update_time`   TIMESTAMP   NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
	COMMENT '更新时间',
	PRIMARY KEY (`log_id`),
	KEY `idx_user_id` (`user_id`)
)
	COMMENT '学习记录';