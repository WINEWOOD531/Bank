package com.solvd.bank.extentions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AgeException extends Exception {
    private static final Logger LOGGER = LogManager.getLogger(AgeException.class);

    public AgeException() {
        LOGGER.info("levelMaxAge is incorrect!");
    }

    public AgeException(String message) {
        super(message);
    }
}
