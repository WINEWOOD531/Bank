package com.solvd.bank.workers;

import com.solvd.bank.departments.BankWorker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Consultant extends BankWorker {
    private String separationBankType;
    private int id;
    private static final Logger LOGGER = LogManager.getLogger(Consultant.class);

    public Consultant() {
    }

    public Consultant(String name) {
        super(name);
    }

    public Consultant(String name, String bankName, String separationBankType, int id) {
        super(name, bankName);
        this.separationBankType = separationBankType;
        this.id = id;
    }

    public void setSeparationBankType(String separationBankType) {
        this.separationBankType = separationBankType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeparationBankType() {
        return separationBankType;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "separation Bank Type='" + separationBankType + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultant that = (Consultant) o;
        return id == that.id && separationBankType.equals(that.separationBankType);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (separationBankType != null ? separationBankType.hashCode() : 0);
        return result;
    }

    @Override
    public void work() {
        LOGGER.info(getName() + "Works in the cash hall");
    }

    @Override
    public void consult() {
        LOGGER.info("Advises customers to which employee they will turn better");
    }
}
