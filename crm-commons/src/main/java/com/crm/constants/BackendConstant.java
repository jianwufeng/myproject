package com.crm.constants;

/**
 * 
 */
public interface BackendConstant {

    public static final String BACKEND_SPACE = "/backend";

    public interface SessionKey {
        String USER = "user";
        String LOGIN = "loginSecurityCode";
        String REGISTER = "registerSecurityCode";
        String OTHER = "other.unSelect";
    }

    public interface Boolean {
        boolean True = true;
        boolean False = false;
    }

    public interface IsSuccess {
        Integer Success = 0;
        Integer Fail = 1;
    }

}
