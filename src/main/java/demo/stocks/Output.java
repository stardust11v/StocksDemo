package demo.stocks;

import java.util.Date;

import demo.stocks.model.Stock;
import demo.stocks.model.Trade;
import demo.stocks.model.TradeIndicator;
import demo.stocks.sevice.StockService;
import demo.stocks.util.DateUtils;

/**
 * It outputs the functionality of this simple stocks app
 * to the console.
 * 
 * @author Irina
 *
 */
public class Output {

	private StockService stockService;
	
	public Output(StockService stockService) {
		this.stockService = stockService;
	}
	
	// a. For a given stock:
	public void outputA(Stock stock) {
		
		// i. calculate the dividend yield
		double dividendYield = stockService.computeDividendYield(stock);
		System.out.println("Dividend Yield: " + dividendYield);

		// ii. calculate the P/E Ratio
		double peRatio = stockService.computePeRatio(stock);
		System.out.println("P/E ratio: " + peRatio);

		// iii. record a trade, with timestamp, quantity of shares,
		// buy or sell indicator and price
		Trade trade = new Trade(stock, new Date(), 200, 12, TradeIndicator.BUY);
		stockService.recordTrade(trade);

		// iv. calculate Stock Price based on trades recorded in past 15 minutes
		Date lastDate = DateUtils.getPastDateTime(new Date(), 15);		
		double stockPrice = stockService.computeStockPrice(stock, lastDate);
		System.out.println("Stock price: " + stockPrice);
	}
	
	// b. Calculate the GBCE All Share Index using the geometric mean 
	// of prices for all stocks
	public void outputB() {
		double allShareIndex = stockService.computeGbceAllShareIndex();		
		System.out.println("GBCE All Share Index: " + allShareIndex);
	}
}
