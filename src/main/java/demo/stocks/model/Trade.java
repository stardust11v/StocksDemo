package demo.stocks.model;

import java.util.Date;

/**
 * 
 * @author Irina
 *
 */
public class Trade {

	private Stock stock;
	
	private Date timestamp;
	private int quantity;
	private double price;
	
	private TradeIndicator indicator;
	
	public Trade() {		
	}
	
	public Trade(Stock stock, Date timestamp, int quantity, double price, TradeIndicator indicator) {
		this.stock = stock;
		this.timestamp = timestamp;
		this.quantity = quantity;
		this.price = price;
		this.indicator = indicator;	
	}
	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public TradeIndicator getIndicator() {
		return indicator;
	}

	public void setIndicator(TradeIndicator indicator) {
		this.indicator = indicator;
	}
}
