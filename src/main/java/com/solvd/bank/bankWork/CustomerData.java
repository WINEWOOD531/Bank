package com.solvd.bank.bankWork;

import java.util.Objects;

import com.solvd.bank.reflection.Reflection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerData {
    private static final Logger LOGGER = LogManager.getLogger(Reflection.class);
    private String customerCardNumber;
    private int customerPassportNumber;

    public CustomerData() {
    }

    public CustomerData(String customerCardNumber, int customerPassportNumber) {
        this.customerCardNumber = customerCardNumber;
        this.customerPassportNumber = customerPassportNumber;
    }

    public void setCustomerCardNumber(String customerCardNumber) {
        this.customerCardNumber = customerCardNumber;
    }

    public void setCustomerPassportNumber(int customerPassportNumber) {
        this.customerPassportNumber = customerPassportNumber;
    }

    public String getCustomerCardNumber() {
        LOGGER.info(customerCardNumber);
        return customerCardNumber;
    }

    public int getCustomerPassportNumber() {
        return customerPassportNumber;
    }

    @Override
    public String toString() {
        return "CustomerData{" +
                "customerCardNumber='" + customerCardNumber + '\'' +
                ", customerPassportNumber=" + customerPassportNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerData that = (CustomerData) o;
        return customerPassportNumber == that.customerPassportNumber && customerCardNumber.equals(that.customerCardNumber);
    }

    @Override
    public int hashCode() {
        int result = customerPassportNumber;
        result = 31 * result + (customerCardNumber != null ? customerCardNumber.hashCode() : 0);
        return result;
    }
}
