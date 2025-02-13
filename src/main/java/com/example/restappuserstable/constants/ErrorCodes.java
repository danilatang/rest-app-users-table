package com.example.restappuserstable.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum ErrorCodes {
    USER_WITH_EMAIL_ALREADY_EXIST(0, ValidationConstants.USER_WITH_EMAIL_ALREADY_EXIST),
    EMAIL_NOT_VALID(1, ValidationConstants.EMAIL_NOT_VALID),
    EMAIL_NOT_EMPTY(2, ValidationConstants.EMAIL_NOT_EMPTY);

    public static final Map<String, Integer> ERROR_CODE_MAP = new HashMap<>();

    private final int code;

    private final String message;

    static {
        for (ErrorCodes errorCode : ErrorCodes.values()) {
            ERROR_CODE_MAP.put(errorCode.message, errorCode.code);
        }
    }
}
