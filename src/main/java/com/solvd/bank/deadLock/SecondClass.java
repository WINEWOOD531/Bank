package com.solvd.bank.deadLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SecondClass {
    private static final Logger LOGGER = LogManager.getLogger(SecondClass.class);

    synchronized void bar(FirstClass a) {
        String name = Thread.currentThread().getName();
        LOGGER.info(name + " entered the method SecondClass.bar()");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            LOGGER.info("class SecondClass interrupted");
        }
        LOGGER.info(name + " Trying to call the method FirstClass.last()");
        a.last();
    }

    synchronized void last() {
        LOGGER.info("In the method SecondClass.last()");
    }
}
