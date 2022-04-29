package com.solvd.bank.workers;

import com.solvd.bank.departments.BankWorker;
import com.solvd.bank.extentions.AgeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankIssuesLawyer extends BankWorker {
    private String mainWorkPlace;
    private String possibleWorkPlace;
    private int levelMaxAge;
    private int id;
    private static final Logger LOGGER = LogManager.getLogger(BankIssuesLawyer.class);

    public BankIssuesLawyer() {
    }

    public BankIssuesLawyer(String name) {
        super(name);
    }

    public BankIssuesLawyer(String name, String bankName, String mainWorkPlace, String possibleWorkPlace,
                            int levelMaxAge, int id) {
        super(name, bankName);
        this.mainWorkPlace = mainWorkPlace;
        this.possibleWorkPlace = possibleWorkPlace;
        this.levelMaxAge = levelMaxAge;
        this.id = id;
    }

    public void setMainWorkPlace(String location) {
        this.mainWorkPlace = mainWorkPlace;
    }

    public void setPossibleWorkPlace(String possibleWorkPlace) {
        this.possibleWorkPlace = possibleWorkPlace;
    }

    public void setLevelMaxAge(int levelMaxAge) throws AgeException {
        if (levelMaxAge < 25 || levelMaxAge > 30) {
            throw new AgeException("You levelMaxAge typed incorrect - " + levelMaxAge);
        } else {
            this.levelMaxAge = levelMaxAge;
        }


    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMainWorkPlace() {
        return mainWorkPlace;
    }

    public String getPossibleWorkPlace() {
        return possibleWorkPlace;
    }

    public int getLevelMaxAge() {
        return levelMaxAge;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BankIssuesLawyer{" +
                "MainWork Place='" + mainWorkPlace + '\'' +
                ", Possible Work Place='" + possibleWorkPlace + '\'' +
                ", levelMaxAge=" + levelMaxAge +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankIssuesLawyer that = (BankIssuesLawyer) o;
        return levelMaxAge == that.levelMaxAge && id == that.id && mainWorkPlace.equals(that.mainWorkPlace)
                && possibleWorkPlace.equals(that.possibleWorkPlace);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mainWorkPlace != null ? mainWorkPlace.hashCode() : 0);
        result = 31 * result + (possibleWorkPlace != null ? possibleWorkPlace.hashCode() : 0);
        result = 31 * result + levelMaxAge;
        return result;
    }

    @Override
    public void work() {
        LOGGER.info(getName() + getBankName() + "Works on banking issues " +
                "and in relations with other banks of the country");
    }

    @Override
    public void consult() {
        LOGGER.info("Advises guidance on banking issues and relations with other banks of the country");
    }
}
