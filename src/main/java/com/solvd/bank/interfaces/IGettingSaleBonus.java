package com.solvd.bank.interfaces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@FunctionalInterface
public interface IGettingSaleBonus {
    int MIN_COUNT_WORKING_DAYS = 20;
    int MAX_COUNT_WORKING_DAYS = 22;
    static final Logger LOGGER = LogManager.getLogger(IGettingSaleBonus.class);

    int canEarn();

    default void print() {

        LOGGER.info("Default method on interface IGettingSaleBonus");
    }

    static int getBonus(int countProducts, int productSum) {
        return ((countProducts * productSum) * 2) / 100;
    }
}

