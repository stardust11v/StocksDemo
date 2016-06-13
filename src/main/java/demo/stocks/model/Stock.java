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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (type != other.type)
			return false;
		return true;
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
