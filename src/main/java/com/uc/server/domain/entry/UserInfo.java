package com.uc.server.domain.entry;

import lombok.Data;

/**
 * @author yangxinyan
 * @date 2020/3/20 18:26
 */
@Data
public class UserInfo {

  private Integer userId;

  private String password;

  private String name;

  private String email;

}
