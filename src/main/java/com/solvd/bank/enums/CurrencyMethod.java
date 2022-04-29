package com.solvd.bank.enums;

import com.solvd.bank.bankWork.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum CurrencyMethod {
    DOLLAR {
        @Override
        public boolean isPossibleToPay() {
            return true;
        }
    }, EURO {
        @Override
        public boolean іsAvailableToPurchase() {
            return true;
        }
    };

    protected String printChosen() {
        final Logger LOGGER = LogManager.getLogger(Account.class);
        String message = "You are take " + this;
        LOGGER.info(message);
        return message;
    }

    public boolean іsAvailableToPurchase() {
        return false;
    }

    public boolean isPossibleToPay() {
        return false;
    }
}
