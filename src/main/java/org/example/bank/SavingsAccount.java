package org.example.bank;

import org.example.logger.TransactionLogger;

public class SavingsAccount extends Account {
    public SavingsAccount(String ownerName, double balance, TransactionLogger logger) {
        super(ownerName, balance, logger);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > getBalance()) {
            throw new IllegalArgumentException("Don't have enough money");
        }
        setBalance(getBalance() - amount);
        getLogger().log(getOwnerName() + " withdrew: " + amount);
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}
