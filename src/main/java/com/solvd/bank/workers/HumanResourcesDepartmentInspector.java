package com.solvd.bank.workers;

import com.solvd.bank.departments.BankWorker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HumanResourcesDepartmentInspector extends BankWorker {
    private String rights;
    private String liability;
    private int workExperience;
    private int id;
    private static final Logger LOGGER = LogManager.getLogger(HumanResourcesDepartmentInspector.class);

    public HumanResourcesDepartmentInspector() {
    }

    public HumanResourcesDepartmentInspector(String name) {
        super(name);
    }

    public HumanResourcesDepartmentInspector(String name, String bankName,
                                             String rights, String liability, int workExperience, int id) {
        super(name, bankName);
        this.rights = rights;
        this.liability = liability;
        this.workExperience = workExperience;
        this.id = id;
    }

    public void setRights(String location) {
        this.rights = rights;
    }

    public void setLiability(String liability) {
        this.liability = liability;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRights() {
        return rights;
    }

    public String getLiability() {
        return liability;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "HumanResourcesDepartmentInspector{" +
                "rights='" + rights + '\'' +
                ", liability='" + liability + '\'' +
                ", work experience=" + workExperience +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HumanResourcesDepartmentInspector that = (HumanResourcesDepartmentInspector) o;
        return workExperience == that.workExperience && id == that.id && rights.equals(that.rights) &&
                liability.equals(that.liability);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (rights != null ? rights.hashCode() : 0);
        result = 31 * result + (liability != null ? liability.hashCode() : 0);
        result = 31 * result + workExperience;
        return result;
    }

    @Override
    public void work() {
        LOGGER.info("Fills, keeps record and keeps employment" +
                " records, determines the work experience.");
    }

    @Override
    public void consult() {
        LOGGER.info("Issues certificates about the present and past work activities of employees");
    }
}
