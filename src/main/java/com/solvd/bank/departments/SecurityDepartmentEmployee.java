package com.solvd.bank.departments;


public abstract class SecurityDepartmentEmployee {
    private String securityObject;
    private int workingHoursNumber;

    public SecurityDepartmentEmployee() {

    }

    public SecurityDepartmentEmployee(String securityObject) {
        this.securityObject = securityObject;
    }

    public void setSecurityObject(String name) {
        this.securityObject = securityObject;
    }

    public void setWorkingHoursNumber(int age) {
        this.workingHoursNumber = workingHoursNumber;
    }

    public String getSecurityObject() {
        return securityObject;
    }

    public int getWorkingHoursNumber() {
        return workingHoursNumber;
    }

    public abstract void guard();

    public abstract void protect();
}
