package com.cat;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String URL = "https://api.privatbank.ua/p24api/exchange_rates?json=true&date=";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date of your request is format day.month.year");
        String date = scanner.nextLine();
        System.out.println("Your date is " + date);
        String urlPrivatBank = URL + date;
        String response = UrlConnection.sendRequest(urlPrivatBank, null, null);
        System.out.println(response);
        Gson gson = new Gson();
        Bank bank = gson.fromJson(response, Bank.class);
        System.out.println(bank);
        String json = gson.toJson(bank);
        FileUtils.writeStringToFile(new File("json1.txt"), json, "UTF-8");
        List<ExchangeRate> exchangeRates = bank.getExchangeRate();
        System.out.println(exchangeRates);
        if (exchangeRates.isEmpty()) {
            System.out.println("PrivatBank has not information about sale dollar`s rate of National Bank of Ukraine for the " + date);
        } else {
            for (ExchangeRate e : exchangeRates) {
                if (e.getCurrency().equals("USD")) {
                    System.out.println("Sale dollar`s rate of National Bank of Ukraine is " + e.getSaleRateNB());
                }
            }
        }
    }
}
