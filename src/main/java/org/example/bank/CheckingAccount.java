package org.example.bank;

import org.example.logger.TransactionLogger;

public class CheckingAccount extends Account {
    private static final double OVERDRAFT_LIMIT = -100;

    public CheckingAccount(String ownerName, double balance, TransactionLogger logger) {
        super(ownerName, balance, logger);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Don't have enough money");
        }
        if (getBalance() - amount < OVERDRAFT_LIMIT) {
            throw new IllegalArgumentException("Overdraft limit exceeded");
        }
        setBalance(getBalance() - amount);
        getLogger().log(getOwnerName() + "withdrew" + amount);
    }

    @Override
    public String getAccountType() {
        return "Checking";
    }
}
