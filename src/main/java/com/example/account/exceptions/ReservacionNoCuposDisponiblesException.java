package com.example.account.exceptions;


public class ReservacionNoCuposDisponiblesException extends RuntimeException {
    public ReservacionNoCuposDisponiblesException(String message) {
        super(message);
    }
}
