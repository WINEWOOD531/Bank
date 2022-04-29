package com.solvd.bank.extentions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorkingDayCountException extends Exception {
    private static final Logger LOGGER = LogManager.getLogger(WorkingDayCountException.class);

    public WorkingDayCountException() {
        LOGGER.info("workingDayCount is incorrect!");
    }

    public WorkingDayCountException(String message) {
        super(message);
    }
}
