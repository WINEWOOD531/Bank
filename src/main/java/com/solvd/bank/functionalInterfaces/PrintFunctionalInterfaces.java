package com.solvd.bank.functionalInterfaces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrintFunctionalInterfaces implements IPrint, ISaleDollar, ISupplier {
    private static final Logger LOGGER = LogManager.getLogger(PrintFunctionalInterfaces.class);
    IPrint iPrint = new IPrint() {
        @Override
        public String print(String message) {
            LOGGER.info(message);
            return message;
        }
    };

    @Override
    public String print(String message) {
        LOGGER.info(message);
        return message;
    }

    @Override
    public int exchange(int customerSum, int purchaseCourse) {
        LOGGER.info("As a result of the transaction you will receive: " + (customerSum * purchaseCourse));
        return customerSum * purchaseCourse;
    }

    @Override
    public Object get() {
        int start = 1000;
        int finish = 9999;
        int pinCode = start + (int) (Math.random() * finish);
        if (pinCode > finish) {
            pinCode = start + (int) (Math.random() * finish);
        }
        LOGGER.info(pinCode);
        return pinCode;
    }

    public void printInterfacesResults() {
        IPrint iPrint = message -> {
            return "IPrint on Lambda is working? " + message;
        };
        LOGGER.info(iPrint.print("\nYES,It working."));

        ISaleDollar iSaleDollar = (customerSum, purchaseCourse) -> (customerSum * purchaseCourse);
        LOGGER.info("As a result of the transaction you will receive: "
                + iSaleDollar.exchange(10, 27));

        ISupplier iSupplier = () -> (1000 + (int) (Math.random() * 8998));
        LOGGER.info("New Unique PIN-code: " + iSupplier.get());
    }
}
