package com.xkcoding.bean.entity;

import java.util.Date;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * UserInfo 实体类
 *
 * @author Yangkai.Shen
 * @version 1.0
 * @date 2017.07.18 at 03:20:47
 */
@Data
@Entity
public class UserInfo {
	@Id
	private String userId;
	private String username;
	private String password;
	private String salt;
	private String wxOpenid;
	private String qqOpenid;
	private String phone;
	private Integer isTeacher;
	private String ip;
	private Integer loginTimes;
	private Date lastTime;
	private Date createTime;
	private Date updateTime;
}