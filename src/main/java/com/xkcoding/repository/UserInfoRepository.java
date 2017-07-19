package com.xkcoding.repository;

import com.xkcoding.bean.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserInfo 的 JPA 接口
 *
 * @author Yangkai.Shen
 * @version 1.0
 * @date 2017.07.18 at 04:24:27
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
}
