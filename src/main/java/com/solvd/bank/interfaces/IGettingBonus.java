package com.solvd.bank.interfaces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@FunctionalInterface
public interface IGettingBonus {
    int HOLIDAY_COEFFICIENT = 2;
    static final Logger LOGGER = LogManager.getLogger(IGettingBonus.class);

    int canEarnHolidayBonus();

    default void getInfo() {

        LOGGER.info("This is indicator of working default method of interface IGettingBonus");
    }

    static int getFestiveBonus(int festiveDaysCount, int rate, int coefficient) {
        return ((rate * festiveDaysCount) * coefficient);
    }
}
