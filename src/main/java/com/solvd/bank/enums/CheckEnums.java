package com.solvd.bank.enums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckEnums {
    Сurrency c = Сurrency.DOLLAR;
    int sum = 0;
    private static final Logger LOGGER = LogManager.getLogger(CheckEnums.class);

    public void checkСurrency() {

        switch (c) {
            case DOLLAR:
                sum += 29;
                break;
            case EURO:
                sum += 35;
                break;
        }
        LOGGER.info(sum);
    }

    public void checkMethod() {
        CurrencyMethod cm = CurrencyMethod.DOLLAR;
        cm.isPossibleToPay();
        cm.іsAvailableToPurchase();
        cm.printChosen();
    }

    public void checkFields() {
        CurrencyField cf = CurrencyField.DOLLAR;
        CurrencyField.DOLLAR.getSaleValue();
        CurrencyField.DOLLAR.getPurchaseValue();
    }

}
