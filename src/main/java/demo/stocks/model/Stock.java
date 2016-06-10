package demo.stocks.model;

/**
 * 
 * @author Irina
 *
 */
public class Stock {

	private String symbol;
	private StockType type;
	
	private double lastDividend;
	private double fixedDividend;
    private double parValue;
    private double tickerPrice;
	
    public Stock() {
	}    

	/**
     * This constructor is just for the simplicity of creating a new Stock 
     * with dummy values in DataProvider.
     */
	public Stock(String symbol, StockType type, double lastDividend, double fixedDividend, double parValue, double tickerPrice) {
		this.symbol = symbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
		this.tickerPrice = tickerPrice;
	}
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public StockType getType() {
		return type;
	}

	public void setType(StockType type) {
		this.type = type;
	}
	
	public double getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}

	public double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public double getParValue() {
		return parValue;
	}

	public void setParValue(double parValue) {
		this.parValue = parValue;
	}

	public double getTickerPrice() {
		return tickerPrice;
	}

	public void setTickerPrice(double tickerPrice) {
		this.tickerPrice = tickerPrice;
	}
}
