package demo.stocks.sevice;

import java.util.Date;

import demo.stocks.model.Stock;
import demo.stocks.model.Trade;

/**
 * Class that exposes the functionality of this simple stock app.
 * 
 * @author Irina
 *
 */
public interface StockService {

	double computeDividendYield(Stock stock);
	
	double computePeRatio(Stock stock);
	
	double computeStockPrice(Stock stock, Date sinceLastDate);
	
	double computeGbceAllShareIndex();
	
	void recordTrade(Trade trade);
}
