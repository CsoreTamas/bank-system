package org.example.logger;

public class ConsoleLogger implements TransactionLogger {
    @Override
    public void log(String massage) {
        System.out.println(" [LOG] " + massage);
    }
}
