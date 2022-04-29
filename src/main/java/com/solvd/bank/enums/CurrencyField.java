package com.solvd.bank.enums;

public enum CurrencyField {
    DOLLAR(29, 28), EURO(35, 30);

    private int saleValue;
    private int purchaseValue;

    CurrencyField(int saleValue, int purchaseValue) {
        this.saleValue = saleValue;
        this.purchaseValue = purchaseValue;
    }

    public int getSaleValue() {
        return saleValue;
    }

    public int getPurchaseValue() {
        return purchaseValue;
    }

}
