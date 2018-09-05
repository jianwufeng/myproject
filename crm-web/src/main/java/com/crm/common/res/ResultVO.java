package com.crm.common.res;

import java.io.Serializable;

public class ResultVO implements Serializable {

    /**
     */
    private static final long serialVersionUID = -7858656799717777730L;

    private String            code;

    private String            msg;

    private int               count;

    private Object            data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
