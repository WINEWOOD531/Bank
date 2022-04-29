package com.solvd.bank.workers;

import com.solvd.bank.departments.SecurityDepartmentEmployee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Collector extends SecurityDepartmentEmployee {

    private String professionalDuties;
    private String extraSkills;
    private int id;
    private static final Logger LOGGER = LogManager.getLogger(Collector.class);

    public Collector() {
    }

    public Collector(String name, String professionalDuties, String extraSkills, int id) {
        super(name);
        this.professionalDuties = professionalDuties;
        this.extraSkills = extraSkills;
        this.id = id;
    }

    public void setProfessionalDuties(String location) {
        this.professionalDuties = professionalDuties;
    }

    public void setExtraSkills(String extraSkills) {
        this.extraSkills = extraSkills;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfessionalDuties() {
        return professionalDuties;
    }

    public String getExtraSkills() {
        return extraSkills;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Collector{" +
                "Professional Duties='" + professionalDuties + '\'' +
                ", Extra skills='" + extraSkills + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collector collector = (Collector) o;
        return id == collector.id && professionalDuties.equals(collector.professionalDuties) &&
                extraSkills.equals(collector.extraSkills);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (professionalDuties != null ? professionalDuties.hashCode() : 0);
        result = 31 * result + (extraSkills != null ? extraSkills.hashCode() : 0);
        return result;
    }

    @Override
    public void guard() {
        LOGGER.info(getSecurityObject() + " is protected");
    }

    @Override
    public void protect() {
        LOGGER.info("Protects money from robbers if they attacked");
    }
}
