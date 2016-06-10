package demo.stocks;

import java.util.Date;
import java.util.List;

import demo.stocks.formula.StockFormula;
import demo.stocks.model.Stock;
import demo.stocks.model.Trade;
import demo.stocks.model.TradeIndicator;
import demo.stocks.utils.DateUtils;

/**
 * 
 * @author Irina
 *
 */
public class Output {

	private DataProvider dataProvider;
	private StockFormula stockFormula;
	
	public Output(DataProvider dataProvider) {
		this.dataProvider = dataProvider;
		stockFormula = new StockFormula(dataProvider);
	}
	
	// a. For a given stock:
	public void outputA(Stock stock) {
		
		// i. calculate the dividend yield
		double dividendYield = stockFormula.dividendYield(stock);
		System.out.println("Dividend Yield: " + dividendYield);

		// ii. calculate the P/E Ratio
		double peRatio = stockFormula.peRatio(stock);
		System.out.println("P/E ratio: " + peRatio);

		// iii. record a trade, with timestamp, quantity of shares,
		// buy or sell indicator and price
		Trade trade = new Trade(stock, new Date(), 200, 12, TradeIndicator.BUY);
		dataProvider.recordTrade(trade);

		// iv. calculate Stock Price based on trades recorded in past 15 minutes
		Date lastDate = DateUtils.getPastDateTime(new Date(), 15);
		List<Trade> trades = dataProvider.getTradesBy(stock, lastDate);
		
		double stockPrice = stockFormula.stockPrice(stock, trades);
		System.out.println("Stock price: " + stockPrice);
	}
	
	// b. Calculate the GBCE All Share Index using the geometric mean 
	// of prices for all stocks
	public void outputB() {
		List<Stock> allStocks = dataProvider.getStocks();
		List<Trade> allTrades = dataProvider.getAllTrades();
		
		double allShareIndex = stockFormula.gbceAllShareIndex(allStocks, allTrades);
		
		System.out.println("GBCE All Share Index: " + allShareIndex);
	}
}
