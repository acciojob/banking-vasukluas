package com.driver;

public class InsufficientBalanceException extends Throwable {
    public InsufficientBalanceException(String insufficient_balance) {
        super(insufficient_balance);
    }
}
