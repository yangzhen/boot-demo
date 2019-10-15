package com.uc.server.config;

public enum RES_STATUS {

  FAILED(-1, "未知错误"),

  SUCCESS(0, "SUCCESS"),

  BAD_CLIENT_ERROR(400, "客户端错误"),

  SERVER_UNKONW_ERROR(500, "服务器开小差了,请稍后再试"),

  THIRD_HAS_ERROR(71000, "第三方服务器异常"),

  ;

  public final int code;
  public final String msg;

  RES_STATUS(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public static RES_STATUS findStatusByCode(int code) {
    for (RES_STATUS status : RES_STATUS.values()) {
      if (status.code == code) {
        return status;
      }
    }
    return null;
  }

}
