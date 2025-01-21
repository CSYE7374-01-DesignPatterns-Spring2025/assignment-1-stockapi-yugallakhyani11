package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public abstract class StockAPI implements Tradable {
	protected String ID;
    protected String name;
    protected double price;
    protected String description;
    protected List<Double> bidHistory = new ArrayList<>();

    public StockAPI(String ID, String name, double price, String description) {
    	this.ID = ID;
        this.name = name;
        this.price = price;
        this.description = description;
    }
    
    @Override
    public  void setBid(String bid) {
		try {
			double bidValue = Double.parseDouble(bid);
			bidHistory.add(bidValue);
			price = bidValue; // Update price based on the latest bid
		} catch (NumberFormatException e) {
			System.out.println("Invalid bid format: " + bid);
		}
	}

    @Override
    public abstract int getMetric();

    @Override
    public String toString() {
        return "[Stock ID:" + ID + " name=" + name + ", price:" + price + ", description:" + description + ", metric:" + getMetric() + "]";
    }

}
