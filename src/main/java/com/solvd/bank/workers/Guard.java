package com.solvd.bank.workers;

import com.solvd.bank.departments.SecurityDepartmentEmployee;
import com.solvd.bank.extentions.RankException;
import com.solvd.bank.interfaces.IGettingBonus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Guard extends SecurityDepartmentEmployee implements IGettingBonus {

    private String responsibility;
    private String powers;
    private int rank;
    private int id;
    private static final Logger LOGGER = LogManager.getLogger(Guard.class);

    public Guard(String name) {
        super(name);
    }

    public Guard() {
    }

    public Guard(String responsibility, String powers, int rank, int id) {
        this.responsibility = responsibility;
        this.powers = powers;
        this.rank = rank;
        this.id = id;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public void setPowers(String powers) {
        this.powers = powers;
    }

    public void setRank(int rank) throws RankException {
        if (rank < 1 || rank > 6) {
            throw new RankException("You rank typed incorrect - " + rank);
        } else {
            this.rank = rank;
        }

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public String getPowers() {
        return powers;
    }

    public int getRank() {
        return rank;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Guard{" +
                "Responsibility='" + responsibility + '\'' +
                ", Powers='" + powers + '\'' +
                ", Rank=" + rank +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guard guard = (Guard) o;
        return rank == guard.rank && id == guard.id &&
                responsibility.equals(guard.responsibility) && powers.equals(guard.powers);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (responsibility != null ? responsibility.hashCode() : 0);
        result = 31 * result + (powers != null ? powers.hashCode() : 0);
        result = 31 * result + rank;
        return result;
    }

    @Override
    public void guard() {
        LOGGER.info(getSecurityObject() + " is protected");
    }

    @Override
    public void protect() {
        LOGGER.info("Protects the Bank's property from robbers");
    }


    @Override
    public int canEarnHolidayBonus() {
        int stake;
        if (rank >= 5) {
            stake = 600;
        } else {
            stake = 500;
        }
        LOGGER.info("Bonus for one holiday day is: " + (stake * HOLIDAY_COEFFICIENT));
        return 0;
    }

    public void print(String responsibility) {

    }

    public int print(int rank) {
        return 0;
    }
}
