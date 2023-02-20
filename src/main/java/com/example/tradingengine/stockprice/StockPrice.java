package com.example.tradingengine.stockprice;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class StockPrice {

    public static void main(String[] args) throws IOException {
        String[] symbols = new String[] {"INTC", "BABA", "TSLA", "AIR.PA", "YHOO"};

        new StockPrice(symbols);
    }

    public StockPrice(String[] symbols) throws IOException {
        Map<String, Stock> stocks = YahooFinance.get(symbols); // single request

        for (Map.Entry<String, Stock> entry : stocks.entrySet()) {

            Stock stock = entry.getValue();

            BigDecimal price = stock.getQuote().getPrice();
            BigDecimal change = stock.getQuote().getChangeInPercent();
            BigDecimal peg = stock.getStats().getPeg();
            BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

            stock.print();

        }

    }

}
