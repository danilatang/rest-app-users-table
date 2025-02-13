package com.example.restappuserstable.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum UserStatus {
    UNBLOCKED(0, "Разблокирован"),
    BLOCKED(1, "Заблокирован");

    public static final Map<String, Integer> ERROR_CODE_MAP = new HashMap<>();

    private final int code;

    private final String message;

    static {
        for (UserStatus statusCode : UserStatus.values()) {
            ERROR_CODE_MAP.put(statusCode.message, statusCode.code);
        }
    }
}
