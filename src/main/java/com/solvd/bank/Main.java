package com.solvd.bank;

import com.solvd.bank.bankWork.Bank;
import com.solvd.bank.functionalInterfaces.PrintFunctionalInterfaces;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.welcomeInBank();
    }
}
