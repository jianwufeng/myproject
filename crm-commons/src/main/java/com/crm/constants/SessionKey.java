package com.crm.constants;

public enum SessionKey {
    LOGIN(0, "loginSecurityCode"), REGISTER(1, "registerSecurityCode"), VALIDATECODE(2, "validateCode"), SMSCODE(3, "smsCode"), SMSPWDCODE(5, "smsPwdCode"), OTHER(
            999, "other.unSelect");

    // 成员变量
    private Integer key;
    private String value;

    // 构造方法
    private SessionKey(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    // 普通方法
    public static String getValue(int key) {
        for (SessionKey c : SessionKey.values()) {
            if (c.getKey() == key) {
                return c.getValue();
            }
        }
        return null;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
