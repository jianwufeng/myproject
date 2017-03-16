package com.crm.util.excel;

public class BeanAccessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BeanAccessException() {
        super();
    }

    private Throwable targetException;

    public Throwable getTargetException() {
        return this.targetException;
    }

    public void setTargetException(Throwable targetException) {
        this.targetException = targetException;
    }

    public BeanAccessException(String message) {
        super(message);
    }

    public BeanAccessException(String message, Throwable cause) {
        super(message, cause);
        setTargetException(cause);
    }

    public BeanAccessException(Throwable cause) {
        super(cause);
        setTargetException(cause);
    }
}
