package com.example.expense_tracker.dto;

public class ErrorResponseDTO {

    private String message;
    private int status;

    public ErrorResponseDTO(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}