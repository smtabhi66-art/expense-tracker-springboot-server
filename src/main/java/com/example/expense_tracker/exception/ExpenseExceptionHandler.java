package com.example.expense_tracker.exception;

import com.example.expense_tracker.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class ExpenseExceptionHandler {

    @ExceptionHandler(ExpenseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleExpenseNotFound(ExpenseNotFoundException exception) {
        return new ErrorResponseDTO(exception.getMessage(), 404);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponseDTO handleInvalidCredentials(
            InvalidCredentialsException exception) {

        return new ErrorResponseDTO(
                exception.getMessage(),
                401
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleValidationException(
            MethodArgumentNotValidException exception) {

        return new ErrorResponseDTO(
                "Invalid request data",
                400
        );
    }

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponseDTO handleEmailAlreadyRegistered(
            EmailAlreadyRegisteredException exception) {

        return new ErrorResponseDTO(
                exception.getMessage(),
                409
        );
    }
}