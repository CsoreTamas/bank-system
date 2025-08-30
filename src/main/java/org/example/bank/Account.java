package org.example.bank;

import lombok.Getter;
import lombok.Setter;
import org.example.logger.TransactionLogger;

@Setter
@Getter
public abstract class Account {
    private String ownerName;
    private double balance;
    private final TransactionLogger logger;

    public Account(String ownerName, double balance, TransactionLogger logger) {
        this.ownerName = ownerName;
        this.balance = balance;
        this.logger = logger;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
        logger.log(ownerName + " deposited: " + amount);
    }

    public abstract void withdraw(double amount);

    abstract String getAccountType();
}
