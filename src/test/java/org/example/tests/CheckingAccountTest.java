package org.example.tests;

import org.example.bank.Account;
import org.example.bank.CheckingAccount;
import org.example.logger.ConsoleLogger;
import org.example.logger.TransactionLogger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckingAccountTest {
    @Test
    void shouldDepositAmount() {
        TransactionLogger logger = new ConsoleLogger();
        Account account = new CheckingAccount("Geza", 10, logger);

        account.deposit(50);
        assertEquals(60, account.getBalance());
    }

    @Test
    void shouldThrowExceptionWhenAmountNegative() {
        TransactionLogger logger = new ConsoleLogger();
        Account account = new CheckingAccount("Geza", 10, logger);

        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-10);
        });
    }

    @Test
    void shouldEnabledOverdraftLimit() {
        TransactionLogger logger = new ConsoleLogger();
        Account account = new CheckingAccount("Geza", 10, logger);

        account.withdraw(60);
        assertEquals(-50, account.getBalance());
    }

    @Test
    void shouldDisabledOverOverdraftLimit() {
        TransactionLogger logger = new ConsoleLogger();
        Account account = new CheckingAccount("Geza", 10, logger);

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200);
        });
    }

    @Test
    void shouldThrowExceptionWhenWithdrawAmountNegativeOrZero() {
        TransactionLogger logger = new ConsoleLogger();
        Account account = new CheckingAccount("Geza", 10, logger);

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-10);
        });
    }
}