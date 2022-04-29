package com.solvd.bank.deadLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FirstClass {
    private static final Logger LOGGER = LogManager.getLogger(FirstClass.class);

    synchronized void foo(SecondClass b) {
        String name = Thread.currentThread().getName();
        LOGGER.info(name + " entered the method FirstClass.foo()");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            LOGGER.info("class FirstClass interrupted");
        }
        LOGGER.info(name + " Trying to call the method SecondClass.last()");
        b.last();
    }

    synchronized void last() {
        LOGGER.info("In the method FirstClass.last()");
    }
}
