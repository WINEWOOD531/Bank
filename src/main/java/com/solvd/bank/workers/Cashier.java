package com.solvd.bank.workers;

import com.solvd.bank.departments.BankWorker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cashier extends BankWorker {
    private String responsibilityObject;
    private String cashierType;
    private int id;
    private static final Logger LOGGER = LogManager.getLogger(Cashier.class);

    public Cashier() {
    }

    public Cashier(String name) {
        super(name);
    }

    public Cashier(String name, String bankName, String responsibilityObject, String cashierType, int id) {
        super(name, bankName);
        this.responsibilityObject = responsibilityObject;
        this.cashierType = cashierType;
        this.id = id;
    }

    public void setResponsibilityObject(String responsibilityObject) {
        this.responsibilityObject = responsibilityObject;
    }

    public void setCashierType(String cashierType) {
        this.cashierType = cashierType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponsibilityObject() {
        return responsibilityObject;
    }

    public String getCashierType() {
        return cashierType;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "responsibility object='" + responsibilityObject + '\'' +
                ", cashier type='" + cashierType + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cashier cashier = (Cashier) o;
        return id == cashier.id && responsibilityObject.equals(cashier.responsibilityObject) &&
                cashierType.equals(cashier.cashierType);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (responsibilityObject != null ? responsibilityObject.hashCode() : 0);
        result = 31 * result + (cashierType != null ? cashierType.hashCode() : 0);
        return result;
    }

    @Override
    public void work() {
        LOGGER.info(getName() + "Works on payment, remittances, removal of money and other");
    }

    @Override
    public void consult() {
        LOGGER.info("Advises on payment, remittances, removal of money and other");
    }

    public void printInfo(String responsibilityObject, String cashierType) {

    }

    public void printInfo(String cashierType) {

    }
}
