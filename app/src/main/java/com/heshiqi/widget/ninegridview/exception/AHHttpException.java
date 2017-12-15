package com.heshiqi.widget.ninegridview.exception;

/**
 * Created by heshiqi on 17/7/28.
 * 网路访问异常类
 */

public class AHHttpException extends Exception {

    public static final int ERROR_UC_TICKET_IS_NULL = -2;
    public static final int ERROR_RESPONSE_OBJ_IS_NULL = -3;

    private int errorCode = - 1;

    public AHHttpException(){super();}

    public AHHttpException(int errorCode) {
        super();
        this.errorCode=errorCode;
    }

    public AHHttpException(int errorCode, String message) {
        super(message);
        this.errorCode=errorCode;
    }

    public AHHttpException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode=errorCode;
    }
    public AHHttpException(int errorCode, Throwable cause) {
        super(cause);
        this.errorCode=errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
