package com.solvd.bank.bankWork;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Saving extends Account {
    private static final Logger LOGGER = LogManager.getLogger(Saving.class);
    private String debitCardNumber;
    private String pinCode;

    public Saving() {
        super();
    }

    public Saving(int accountNumber, String customerName, float balance, String debitCardNumber, String pinCode) {
        super(accountNumber, customerName, balance);
        this.debitCardNumber = debitCardNumber;
        this.pinCode = pinCode;
    }

    public Saving(Saving saving) {
        super(saving.accountNumber, saving.customerName, saving.balance);
        debitCardNumber = saving.debitCardNumber;
        pinCode = saving.pinCode;
    }

    public void setDebitCardNumber(String debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getDebitCardNumber() {
        return debitCardNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    @Override
    public String toString() {
        return
                "\nAccountNumber=" + accountNumber +
                        "\nCustomerName='" + customerName + '\'' +
                        "\nBalance=" + balance +
                        "\nDebitCardNumber='" + debitCardNumber + '\'' +
                        "\nPinCode='" + pinCode + '\'';
    }

    @Override
    public Account addAccount() {
        Scanner in = new Scanner(System.in);

        LOGGER.info("\nAdding a Savings Account to the list! Please supply account details below:");

        LOGGER.info("Account Number: ");
        accountNumber = in.nextInt();
        LOGGER.info("Customer Name: ");
        customerName = in.next();
        LOGGER.info("Balance: ");
        balance = in.nextFloat();
        LOGGER.info("Debit Card Number: ");
        debitCardNumber = in.next();
        LOGGER.info("Pin Code: ");
        pinCode = in.next();

        return new Saving(accountNumber, customerName, balance, debitCardNumber, pinCode);
    }

    @Override
    public void deposit(float amt) {
        balance += amt;
    }

    @Override
    public void withdrawal(float amt) {
        balance -= amt;
    }
}
