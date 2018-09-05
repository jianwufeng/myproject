package com.crm.common.res;

public class CrmException extends Exception {

    private static final long serialVersionUID = 1L;

    private CrmErrorCode errorCode;

    private String selfMessage;

    public CrmException(CrmErrorCode errorCode, Throwable cause) {

        super(cause);

        this.errorCode = errorCode;

    }

    public CrmException(CrmErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public CrmException(String errorCode, Throwable cause) {

        super(errorCode, cause);

    }

    public CrmException(String errorCode) {
        super(errorCode);
    }

    public CrmException(String errorCode, String selfMessage) {
        this(errorCode);
        this.selfMessage = selfMessage;
    }

    public CrmException() {
        super();
    }

    public String getErrorCode() {

        if (errorCode != null) {
            return errorCode.getErrorCode();
        }

        return super.getMessage();
    }

    public String getSelfMessage() {
        return selfMessage;
    }

}
