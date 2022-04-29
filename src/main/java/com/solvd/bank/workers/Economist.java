package com.solvd.bank.workers;

import com.solvd.bank.departments.BankWorker;
import com.solvd.bank.extentions.CustomersTypeException;
import com.solvd.bank.extentions.WorkingDayCountException;
import com.solvd.bank.interfaces.IGettingSaleBonus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Economist extends BankWorker implements IGettingSaleBonus {
    private String category;
    private String customersType;
    private int workingDayCount;
    private int id;
    private static final Logger LOGGER = LogManager.getLogger(Economist.class);

    public Economist() {
    }

    public Economist(String name) {
        super(name);
    }

    public Economist(String name, String bankName, String category, String customersType, int workingDayCount, int id) {
        super(name, bankName);
        this.category = category;
        this.customersType = customersType;
        this.workingDayCount = workingDayCount;
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCustomersType(String customersType) throws CustomersTypeException {
        if (customersType == "VIP" || customersType == "individual" || customersType == "entity") {
            this.customersType = customersType;
        } else {
            throw new CustomersTypeException("You customersType typed incorrect - " + customersType);
        }

    }

    public void setWorkingDayCount(int workingDayCount) throws WorkingDayCountException {
        if (workingDayCount < 20 || workingDayCount > 22) {
            throw new WorkingDayCountException("You workingDayCount typed incorrect - " + workingDayCount);
        } else {
            this.workingDayCount = workingDayCount;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public String getCustomersType() {
        return customersType;
    }

    public int getWorkingDayCount() {
        return workingDayCount;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Economist{" +
                "category='" + category + '\'' +
                ", customersType='" + customersType + '\'' +
                ", workingDayCount=" + workingDayCount +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Economist economist = (Economist) o;
        return workingDayCount == economist.workingDayCount && id == economist.id &&
                category.equals(economist.category) && customersType.equals(economist.customersType);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (customersType != null ? customersType.hashCode() : 0);
        result = 31 * result + workingDayCount;
        return result;
    }

    @Override
    public void work() {
        LOGGER.info("Servicing on deposit, credit, as well as speech sketches");
    }

    @Override
    public void consult() {
        LOGGER.info("Consulting by deposit, credit, as well as trials of lichens");
    }

    @Override
    public int canEarn() {
        int ante = 800;
        int salary;
        if (MIN_COUNT_WORKING_DAYS <= workingDayCount && workingDayCount <= MAX_COUNT_WORKING_DAYS) {
            LOGGER.info("Economist salary: ");
            LOGGER.info(salary = ante * workingDayCount);
        } else {
            LOGGER.info("Something wrong.Incorrect workingDayCount OR you was ill?");
        }

        return 0;
    }

    public void showInfo(String category, String customersType) {

    }

    public void showInfo(int workingDayCount) {

    }
}
