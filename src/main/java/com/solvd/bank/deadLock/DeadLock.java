package com.solvd.bank.deadLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeadLock implements Runnable {
    FirstClass a = new FirstClass();
    SecondClass b = new SecondClass();
    private static final Logger LOGGER = LogManager.getLogger(DeadLock.class);

    DeadLock() {
        Thread.currentThread().setName("Main flow");
        Thread t = new Thread(this, "Comparent flow");
        t.start();
        a.foo(b);
        LOGGER.info("Back to the main stream");
    }

    @Override
    public void run() {
        b.bar(a);
        LOGGER.info("Back to another stream");
    }

    public static void main(String args[]) {
        new DeadLock();
    }
}
