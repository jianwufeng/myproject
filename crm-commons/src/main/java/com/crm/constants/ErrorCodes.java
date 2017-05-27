package com.crm.constants;

/**
 * 错误码
 * 
 */
public enum ErrorCodes {

    /* -------------------------- 会员 -------------------------- */
    MEMBER_INEXISTENCE(10001, "会员不存在");

    private Integer code;
    private String message;

    ErrorCodes(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return code;
    }

    public String message() {
        return message;
    }
}
