package com.xkcoding.service;

import com.xkcoding.bean.entity.UserInfo;

import java.util.List;

/**
 * UserInfoService 接口
 *
 * @author Yangkai.Shen
 * @version 1.0
 * @date 2017.07.18 at 12:54:02
 */
public interface UserInfoService {
	UserInfo save(UserInfo userInfo);

	List<UserInfo> findAll();

	UserInfo findById(String id);
}
