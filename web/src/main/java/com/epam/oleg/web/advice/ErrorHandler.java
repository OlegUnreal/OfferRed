package com.epam.oleg.web.advice;

import com.epam.oleg.business.exception.NotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleGeneral(Exception e) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleNotFound(Exception e) {
        return ResponseEntity.status(NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(value = UnsupportedOperationException.class)
    public ResponseEntity<Object> handleUnprocessableEntity(Exception e) {
        return ResponseEntity.status(UNPROCESSABLE_ENTITY).body(e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodNotValidException(MethodArgumentNotValidException e) {
        String msg = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("; "));
        return ResponseEntity.status(UNPROCESSABLE_ENTITY).body(msg);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleBadRequest(Exception e) {
        return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> handleMethodNotSupported(Exception e) {
        return ResponseEntity.status(METHOD_NOT_ALLOWED).body(e.getMessage());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDenied(Exception e) {
        return ResponseEntity.status(FORBIDDEN).body(e.getMessage());
    }
}
