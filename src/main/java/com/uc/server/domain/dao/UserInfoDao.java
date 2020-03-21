package com.uc.server.domain.dao;

import com.uc.server.domain.entry.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author yangxinyan
 * @date 2020/3/20 18:26
 */
@Mapper
public interface UserInfoDao{

  @Select("select * from user_info where user_id=#{userId}")
  public UserInfo findByUserId(@Param("userId") Integer userId);

}
