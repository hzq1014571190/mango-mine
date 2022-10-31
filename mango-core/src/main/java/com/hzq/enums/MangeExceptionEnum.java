package com.hzq.enums;

import lombok.Data;

/**
 * @Author hzq
 * @EnumName MangeExceptionEnum
 * @Date 2022/10/27 10:47
 * @Description 异常枚举类
 */
public enum MangeExceptionEnum {

    /**
     * 成功的请求
     */
    SUCCESS("000000", "OK"),
    INTERNAL_SERVER_ERROR("000001", "未知异常")
    ;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 业务状态码
     */
    private String code;
    /**
     * 描述信息
     */
    private String desc;

    MangeExceptionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
