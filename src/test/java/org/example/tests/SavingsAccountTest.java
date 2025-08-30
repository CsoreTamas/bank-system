package org.example.tests;

import org.example.bank.Account;
import org.example.bank.CheckingAccount;
import org.example.bank.SavingsAccount;
import org.example.logger.ConsoleLogger;
import org.example.logger.TransactionLogger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SavingsAccountTest {
    @Test
    void shouldDepositAmount() {
        TransactionLogger logger = new ConsoleLogger();
        Account account = new SavingsAccount("Geza", 10, logger);

        account.deposit(70);
        assertEquals(80, account.getBalance());
    }

    @Test
    void shouldThrowExceptionWhenAmountNegative() {
        TransactionLogger logger = new ConsoleLogger();
        Account account = new SavingsAccount("Geza", 10, logger);

        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-10);
        });
    }

    @Test
    void shouldThrowExceptionWhenWithdrawAmountNegativeOrZero() {
        TransactionLogger logger = new ConsoleLogger();
        Account account = new SavingsAccount("Geza", 10, logger);

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-10);
        });
    }

    @Test
    void shouldThrowExceptionWhenWithdrawAmountIsTooHigh() {
        TransactionLogger logger = new ConsoleLogger();
        Account account = new SavingsAccount("Geza", 10, logger);

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(20);
        });
    }
}

