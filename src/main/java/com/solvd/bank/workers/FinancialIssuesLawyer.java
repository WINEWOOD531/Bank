package com.solvd.bank.workers;

import com.solvd.bank.departments.BankWorker;
import com.solvd.bank.interfaces.IDefend;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FinancialIssuesLawyer extends BankWorker implements IDefend {
    private String possibleDuties;
    private String ordinaryDuties;
    private int financialExperience;
    private int id;
    private static final Logger LOGGER = LogManager.getLogger(FinancialIssuesLawyer.class);

    public FinancialIssuesLawyer() {
    }

    public FinancialIssuesLawyer(String name) {
        super(name);
    }

    public FinancialIssuesLawyer(String name, String bankName, String possibleDuties,
                                 String ordinaryDuties, int financialExperience, int id) {
        super(name, bankName);
        this.possibleDuties = possibleDuties;
        this.ordinaryDuties = ordinaryDuties;
        this.financialExperience = financialExperience;
        this.id = id;
    }

    public void setPossibleDuties(String location) {
        this.possibleDuties = possibleDuties;
    }

    public void setOrdinaryDuties(String ordinaryDuties) {
        this.ordinaryDuties = ordinaryDuties;
    }

    public void setFinancialExperience(int salary) {
        this.financialExperience = financialExperience;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPossibleDuties() {
        return possibleDuties;
    }

    public String getOrdinaryDuties() {
        return ordinaryDuties;
    }

    public int getFinancialExperience() {
        return financialExperience;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "FinancialIssuesLawyer{" +
                "Possible Duties='" + possibleDuties + '\'' +
                ", Ordinary duties='" + ordinaryDuties + '\'' +
                ", financialExperience=" + financialExperience +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinancialIssuesLawyer that = (FinancialIssuesLawyer) o;
        return financialExperience == that.financialExperience && id == that.id &&
                possibleDuties.equals(that.possibleDuties) && ordinaryDuties.equals(that.ordinaryDuties);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (possibleDuties != null ? possibleDuties.hashCode() : 0);
        result = 31 * result + (ordinaryDuties != null ? ordinaryDuties.hashCode() : 0);
        result = 31 * result + financialExperience;
        return result;
    }

    @Override
    public void work() {
        LOGGER.info("Works on financial issues of the bank");
    }

    @Override
    public void consult() {
        LOGGER.info("Consults on financial issues of the bank");
    }

    @Override
    public void canDefend() {
        LOGGER.info("Protection of the interests of the Bank in financial matters," +
                "but also works with other issues: " + this.getPossibleDuties() +
                BENEFITS + financialExperience + " years financial experience");
    }
}
