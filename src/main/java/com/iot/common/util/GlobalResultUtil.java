package com.iot.common.util;

import lombok.Data;

/**
 * @program: vi-operation-log
 * @description: HTTP响应类
 * @author: cjr
 * @create: 2019-09-25 23:08
 **/
@Data
public class GlobalResultUtil {
    // 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    private String ok;  // 不使用

    public static GlobalResultUtil build(Integer code, String msg, Object data) {
        return new GlobalResultUtil(code, msg, data);
    }

    public static GlobalResultUtil ok(Object data) {
        return new GlobalResultUtil(data);
    }

    public static GlobalResultUtil ok() {
        return new GlobalResultUtil(null);
    }

    public static GlobalResultUtil errorMsg(String msg) {
        return new GlobalResultUtil(500, msg, null);
    }

    public static GlobalResultUtil errorMap(Object data) {
        return new GlobalResultUtil(501, "error", data);
    }

    public static GlobalResultUtil errorTokenMsg(String msg) {
        return new GlobalResultUtil(502, msg, null);
    }

    public static GlobalResultUtil errorException(String msg) {
        return new GlobalResultUtil(555, msg, null);
    }

    public static GlobalResultUtil databaseErrorException (String msg, Object data) {
        return new GlobalResultUtil(201, msg, data);
    }
    public GlobalResultUtil() {

    }

    public GlobalResultUtil(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public GlobalResultUtil(Object data) {
        this.code = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.code == 200;
    }
}
