package com.example.expense_tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.expense_tracker.dto.ErrorResponseDTO;

@RestControllerAdvice
public class ExpenseExceptionHandler {

    @ExceptionHandler(ExpenseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleExpenseNotFound(ExpenseNotFoundException exception) {
        return new ErrorResponseDTO(exception.getMessage(), 404);
    }
}