package org.epam;

public class Account {

    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void debit(int requestedAmount) {
        if (requestedAmount <= balance) {
            balance = balance - requestedAmount;
        } else {
            throw new IllegalArgumentException("Insufficient Balance");
        }
    }
}

