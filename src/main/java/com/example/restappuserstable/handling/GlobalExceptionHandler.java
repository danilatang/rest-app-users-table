package com.example.restappuserstable.handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;

import static com.example.restappuserstable.constants.ErrorCodes.ERROR_CODE_MAP;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrorCodes().getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var e = ex.getBindingResult().getAllErrors();
        List<Integer> errorCodes = e.stream()
                .map(item -> ERROR_CODE_MAP.get(item.getDefaultMessage()))
                .toList();
        Integer error = errorCodes.get(0);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage() + ", код ошибки: " + error);
    }
}
