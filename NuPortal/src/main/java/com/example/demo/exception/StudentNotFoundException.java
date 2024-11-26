package com.example.demo.exception;

/**
 * @author Simpson Alfred
 */

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
