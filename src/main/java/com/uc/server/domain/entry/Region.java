package com.uc.server.domain.entry;

import lombok.Data;

/**
 * @author yangxinyan
 * @date 2019/4/23 14:20
 */
@Data
public class Region {

  private Integer id;

  private Integer code;

  private Integer enabled;

  private String name;

  private String parentCode;

  private String sign;

  private String zipcode;



}
