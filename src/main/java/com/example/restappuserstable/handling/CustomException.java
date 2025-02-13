package com.example.restappuserstable.handling;

import com.example.restappuserstable.constants.ErrorCodes;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException {
    private final ErrorCodes errorCodes;
}
