package com.solvd.bank.workers;

import com.solvd.bank.departments.BankWorker;
import com.solvd.bank.interfaces.IDefend;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InternationalIssuesLawyer extends BankWorker implements IDefend {
    private String directDuties;
    private String additionalDuties;
    private int category;
    private int id;
    private static final Logger LOGGER = LogManager.getLogger(InternationalIssuesLawyer.class);

    public InternationalIssuesLawyer() {
    }

    public InternationalIssuesLawyer(String name) {
        super(name);
    }

    public InternationalIssuesLawyer(String name, String bankName, String directDuties,
                                     String additionalDuties, int category, int id) {
        super(name, bankName);
        this.directDuties = directDuties;
        this.additionalDuties = additionalDuties;
        this.category = category;
        this.id = id;
    }

    public void setDirectDuties(String directDuties) {
        this.directDuties = directDuties;
    }

    public void setAdditionalDuties(String additionalDuties) {
        this.additionalDuties = additionalDuties;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirectDuties() {
        return directDuties;
    }

    public String getAdditionalDuties() {
        return additionalDuties;
    }

    public int getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "InternationalIssuesLawyer{" +
                "Direct duties='" + directDuties + '\'' +
                ", Additional duties='" + additionalDuties + '\'' +
                ", category=" + category +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternationalIssuesLawyer that = (InternationalIssuesLawyer) o;
        return category == that.category && id == that.id && directDuties.equals(that.directDuties) &&
                additionalDuties.equals(that.additionalDuties);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (directDuties != null ? directDuties.hashCode() : 0);
        result = 31 * result + (additionalDuties != null ? additionalDuties.hashCode() : 0);
        result = 31 * result + category;
        return result;
    }

    @Override
    public void work() {
        LOGGER.info("Works with international customers and banks of other countries");
    }

    @Override
    public void consult() {
        LOGGER.info("Advises leadership in relations with international customers " +
                "and banks of other countries");
    }

    @Override
    public void canDefend() {
        LOGGER.info("Protection of the interests of" +
                " the Bank in international issues: " + this.getDirectDuties() + BENEFITS + category + " category");
    }
}
