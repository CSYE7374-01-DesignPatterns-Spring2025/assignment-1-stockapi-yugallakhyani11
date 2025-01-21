package edu.neu.csye7374;


import java.util.ArrayList;
import java.util.List;

//Implementing Singleton class
public class StockMarket {
    private static StockMarket instance; // Lazy Singleton instance
    private List<StockAPI> stocks = new ArrayList<>();

    // Private constructor to implement lazy initialization 
    private StockMarket() {
    	instance = null;
    }

    //Method to get the singleton instance
    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void addStock(StockAPI stock) {
        stocks.add(stock);
    }

    public void tradeStock(String stockName, String bid) {
        for (StockAPI stock : stocks) {
            if (stock.ID.equals(stockName)) {
                stock.setBid(bid);
                System.out.println("Traded " + stockName + " with bid: " + bid);
                System.out.println(stockName + " New " + stock.getMetric());
            }
        }
    }

    public void removeStock(String stockName) {
        stocks.removeIf(stock -> stock.ID.equals(stockName));
    }

    public void showAllStocks() {
        for (StockAPI stock : stocks) {
            System.out.println(stock);
        }
    }
    
    public static void demo() {
    	
    	StockMarket stockExchange = StockMarket.getInstance();
  
    	TechStock techStock = new TechStock("AAPL", "Apple Inc.", 200.0, "Innovative consumer electronics company");
        EnergyStock energyStock = new EnergyStock("PFE", "Pfizer Inc.", 75.0, "Global pharmaceutical leader");
        EnergyStock energyStock2 = new EnergyStock("BP", "BP Plc", 50.0, "Multinational oil and gas company");

     
        stockExchange.addStock(techStock);
        stockExchange.addStock(energyStock);
        stockExchange.addStock(energyStock2);
       

  
        System.out.println("Simulating bids for Apple Inc. (AAPL):");
        stockExchange.tradeStock("AAPL", "210");
        stockExchange.tradeStock("AAPL", "220");
        stockExchange.tradeStock("AAPL", "230");
        stockExchange.tradeStock("AAPL", "225");
        stockExchange.tradeStock("AAPL", "240");
        stockExchange.tradeStock("AAPL", "250");
        
        System.out.println("\nSimulating bids for Pfizer Inc. (PFE):");
        stockExchange.tradeStock("PFE", "76");
        stockExchange.tradeStock("PFE", "78");
        stockExchange.tradeStock("PFE", "80");
        stockExchange.tradeStock("PFE", "79");
        stockExchange.tradeStock("PFE", "81");
        stockExchange.tradeStock("PFE", "82");
        
        System.out.println("\nSimulating bids for BP Plc (BP):");
        stockExchange.tradeStock("BP", "52");
        stockExchange.tradeStock("BP", "54");
        stockExchange.tradeStock("BP", "53");

      
        stockExchange.showAllStocks();


        stockExchange.removeStock("BP");
        System.out.println("Showing stocks after remove call");

  
        stockExchange.showAllStocks();
        
    }
}
