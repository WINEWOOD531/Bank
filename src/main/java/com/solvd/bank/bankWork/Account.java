package com.solvd.bank.bankWork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public abstract class Account {
    private static final Logger LOGGER = LogManager.getLogger(Account.class);
    protected int accountNumber;
    protected String customerName;
    protected float balance;

    public Account() {
    }

    public Account(int accountNumber, String customerName, float balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public Account(Account account) {
        accountNumber = account.accountNumber;
        customerName = account.customerName;
        balance = account.balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void display() {
        LOGGER.info(toString());
    }

    @Override
    public String toString() {
        return "" +
                "AccountNumber: " + accountNumber +
                "\nCustomerName: '" + customerName + '\'' +
                "\nBalance: " + balance;
    }

    public abstract Account addAccount() throws InputMismatchException;

    public abstract void deposit(float amt);

    public abstract void withdrawal(float amt);
}
