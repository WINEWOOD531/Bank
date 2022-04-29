package com.solvd.bank.workers;

import com.solvd.bank.departments.BankWorker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Clerk extends BankWorker {
    private int salary;
    private int id;
    private static final Logger LOGGER = LogManager.getLogger(Clerk.class);

    public Clerk() {
    }

    public Clerk(String name) {
        super(name);
    }

    public Clerk(String name, String bankName, int salary, int id) {
        super(name, bankName);
        this.salary = salary;
        this.id = id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Clerk{" +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clerk clerk = (Clerk) o;
        return salary == clerk.salary && id == clerk.id;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + salary;
        return result;
    }

    @Override
    public void work() {
        LOGGER.info(getName() + getBankName() + "Works with personal affairs bank employees");
    }

    @Override
    public void consult() {
        LOGGER.info("If there is a need to consult how to work with the affairs of bank employees");
    }

    public void calculate(int salary, int workingDaysCount) {

    }

    public void calculate(int salary) {

    }
}
