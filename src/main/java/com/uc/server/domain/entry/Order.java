package com.uc.server.domain.entry;

import lombok.Data;

/**
 * @author yangxinyan
 * @date 2020/3/20 18:29
 */
@Data
public class Order {

  private Integer orderId;

  private Integer userId;

  private Integer amount;

  private String goods;
}
