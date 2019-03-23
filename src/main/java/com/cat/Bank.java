package com.cat;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String date;
    private String bank;
    private int baseCurrency;
    private String baseCurrencyLit;
    private List<ExchangeRate> exchangeRate = new ArrayList<ExchangeRate>();

    public Bank() {
    }

    public void setExchangeRate(List<ExchangeRate> exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getDate() {
        return date;
    }

    public String getBank() {
        return bank;
    }

    public int getBaseCurrency() {
        return baseCurrency;
    }

    public String getBaseCurrencyLit() {
        return baseCurrencyLit;
    }

    public List<ExchangeRate> getExchangeRate() {
        return exchangeRate;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "date='" + date + '\'' +
                ", bank='" + bank + '\'' +
                ", baseCurrency=" + baseCurrency +
                ", baseCurrencyLit='" + baseCurrencyLit + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}
