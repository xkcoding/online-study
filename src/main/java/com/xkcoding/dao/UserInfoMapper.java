package com.xkcoding.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

import com.xkcoding.bean.entity.UserInfo;

/**
 * UserInfoMapper
 *
 * @author Yangkai.Shen
 * @version 1.0
 * @date 2017.07.18 at 05:27:58
 */
@Mapper
@Repository
public interface UserInfoMapper {
	List<UserInfo> selectAll();

	UserInfo selectById(String id);
}