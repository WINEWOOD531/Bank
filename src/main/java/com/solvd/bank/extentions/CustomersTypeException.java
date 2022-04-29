package com.solvd.bank.extentions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomersTypeException extends Exception {
    private static final Logger LOGGER = LogManager.getLogger(CustomersTypeException.class);

    public CustomersTypeException() {
        LOGGER.info("customersType is incorrect!");
    }

    public CustomersTypeException(String message) {
        super(message);
    }
}
