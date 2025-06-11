package com.hd.sample_jpa_mysql_0605.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleMissingParam() {
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse("MISSING_PARAM", "이메일 파라미터가 누락되었습니다."));
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorResponse> handleDBError() {
        return ResponseEntity
                .status(500)
                .body(new ErrorResponse("DB_ERROR", "데이터베이스 오류가 발생했습니다."));
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustom(CustomException ex) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleDefault(Exception ex) {
        return ResponseEntity
                .status(500)
                .body(new ErrorResponse("UNKNOWN", "알 수 없는 서버 오류"));
    }

}
