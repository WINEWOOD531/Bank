package com.solvd.bank.extentions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RankException extends Exception {
    private static final Logger LOGGER = LogManager.getLogger(RankException.class);

    public RankException() {
        LOGGER.info("rank is incorrect!");
    }

    public RankException(String message) {
        super(message);
    }
}
