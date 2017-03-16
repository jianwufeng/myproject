package com.crm.exception;

public class ValidationException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final String message = "验证异常";

    public ValidationException() {
        super(message);
    }

    public ValidationException(String message) {
        super(message);
    }
}
