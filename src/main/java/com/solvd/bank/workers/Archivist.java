package com.solvd.bank.workers;

import com.solvd.bank.departments.BankWorker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Archivist extends BankWorker {
    private String laborDuties;
    private String personalQualities;
    private int id;
    private static final Logger LOGGER = LogManager.getLogger(Archivist.class);

    public Archivist() {
    }

    public Archivist(String name) {
        super(name);
    }

    public Archivist(String name, String bankName, String laborDuties, String personalQualities, int id) {
        super(name, bankName);
        this.laborDuties = laborDuties;
        this.personalQualities = personalQualities;
        this.id = id;
    }

    public void setLaborDuties(String location) {
        this.laborDuties = laborDuties;
    }

    public void setPersonalQualities(String personalQualities) {
        this.personalQualities = personalQualities;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLaborDuties() {
        return laborDuties;
    }

    public String getPersonalQualities() {
        return personalQualities;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Archivist{" +
                "labor Duties='" + laborDuties + '\'' +
                ", Personal qualities='" + personalQualities + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Archivist archivist = (Archivist) o;
        return id == archivist.id && laborDuties.equals(archivist.laborDuties) &&
                personalQualities.equals(archivist.personalQualities);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (laborDuties != null ? laborDuties.hashCode() : 0);
        result = 31 * result + (personalQualities != null ? personalQualities.hashCode() : 0);
        return result;
    }

    @Override
    public void work() {
        LOGGER.info("Organizes storage and" +
                " ensures the safety of documents enrolled in the archive");
    }

    @Override
    public void consult() {
        LOGGER.info("Participates in the development of the nomenclature of cases, " +
                "checks the correctness of their formation and design when transferring to the archive");
    }
}
