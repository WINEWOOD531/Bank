package com.solvd.bank.interfaces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@FunctionalInterface
public interface IDefend {
    String BENEFITS = " His advantages: ";
    static final Logger LOGGER = LogManager.getLogger(IDefend.class);

    void canDefend();

    default void print() {

        LOGGER.info("Default method is working");
    }

    static int getBonus(int salary, int peculiarity, int coefficient) {
        return (salary * peculiarity) / coefficient;
    }
}
