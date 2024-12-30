package org.epam;

public class CashMachine implements ATM {

     Account account;
     int cashDispensed = 0;

    public CashMachine(Account account) {
        this.account = account;
    }

    @Override
    public void withDraw(int amount) {
        int initialBalance = account.getBalance();
        if (initialBalance >= amount) {
            account.debit(amount);//if this works fine it will pass to next step otherwise throw exception
            cashDispensed = amount;
        }else {
            throw new IllegalArgumentException("Insufficient balance!!");
        }
    }

    public int getCashDispensed(){
        return cashDispensed;
    }
}