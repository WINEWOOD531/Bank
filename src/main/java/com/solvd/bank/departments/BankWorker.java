package com.solvd.bank.departments;

public abstract class BankWorker {
    private String name;
    private String bankName;

    public BankWorker() {
    }

    public BankWorker(String name) {
        this.name = name;
    }

    public BankWorker(String name, String bankName) {
        this.name = name;
        this.bankName = bankName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getName() {
        return name;
    }

    public String getBankName() {
        return bankName;
    }

    public abstract void work();

    public abstract void consult();
}
