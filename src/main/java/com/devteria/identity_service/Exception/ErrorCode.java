package com.devteria.identity_service.Exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized Exception"),
    USERNAME_INVALID(1003, "Username must be least 4 character"),
    PASSWORD_INVALID(1004, "Password must be least 8 character"),
    USER_EXISTED(1002, "User existed");
    private int code;
    private String message;

    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
