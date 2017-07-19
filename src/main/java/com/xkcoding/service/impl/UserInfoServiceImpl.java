package com.xkcoding.service.impl;

import com.xkcoding.bean.entity.UserInfo;
import com.xkcoding.dao.UserInfoMapper;
import com.xkcoding.repository.UserInfoRepository;
import com.xkcoding.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserInfoService 接口实现类
 *
 * @author Yangkai.Shen
 * @version 1.0
 * @date 2017.07.18 at 12:53:52
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public UserInfo save(UserInfo userInfo) {
		return userInfoRepository.save(userInfo);
	}

	@Override
	public List<UserInfo> findAll() {
		return userInfoMapper.selectAll();
	}

	@Override
	public UserInfo findById(String id) {
		return userInfoMapper.selectById(id);
	}
}
