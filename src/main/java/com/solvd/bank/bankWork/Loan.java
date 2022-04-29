package com.solvd.bank.bankWork;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Loan extends Account {
    private static final Logger LOGGER = LogManager.getLogger(Loan.class);
    private String maturityDate;
    private float originalLoanAmount;

    public Loan() {
        super();
    }

    public Loan(int accountNumber, String customerName, float balance, String maturityDate, float originalLoanAmount) {
        super(accountNumber, customerName, balance);
        this.maturityDate = maturityDate;
        this.originalLoanAmount = originalLoanAmount;
    }

    public Loan(Loan loan) {
        super(loan.accountNumber, loan.customerName, loan.balance);
        maturityDate = loan.maturityDate;
        originalLoanAmount = loan.originalLoanAmount;
    }

    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }

    public void setOriginalLoanAmount(float originalLoanAmount) {
        this.originalLoanAmount = originalLoanAmount;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public float getOriginalLoanAmount() {
        return originalLoanAmount;
    }

    @Override
    public String toString() {
        return
                "\nAccountNumber=" + accountNumber +
                        "\nCustomerName='" + customerName + '\'' +
                        "\nBalance=" + balance +
                        "\nMaturityDate='" + maturityDate + '\'' +
                        "\nOriginalLoanAmount=" + originalLoanAmount;
    }

    @Override
    public Account addAccount() {

        Scanner in = new Scanner(System.in);

        LOGGER.info("\nAdding a Loan Account to the list! Please supply account details below:");

        LOGGER.info("Account Number: ");
        accountNumber = in.nextInt();
        LOGGER.info("Customer Name: ");
        customerName = in.next();
        LOGGER.info("Balance: ");
        balance = in.nextFloat();
        LOGGER.info("Maturity Date: ");
        maturityDate = in.next();
        LOGGER.info("Original Loan Amount: ");
        originalLoanAmount = in.nextFloat();

        Account obj = new Loan(accountNumber, customerName, balance, maturityDate, originalLoanAmount);

        return obj;
    }

    @Override
    public void deposit(float amt) {
        balance -= amt;
    }

    @Override
    public void withdrawal(float amt) {
        balance += amt;
    }
}
