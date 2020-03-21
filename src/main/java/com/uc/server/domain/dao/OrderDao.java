package com.uc.server.domain.dao;

import com.uc.server.domain.entry.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yangxinyan
 * @date 2020/3/20 18:33
 */
@Mapper
public interface OrderDao{

  public Order findByOrderId(@Param("userId") Integer userId, @Param("orderId") Integer orderId);
}
