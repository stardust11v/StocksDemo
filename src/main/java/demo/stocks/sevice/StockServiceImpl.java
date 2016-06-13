package demo.stocks.sevice;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demo.stocks.computation.StockFormulas;
import demo.stocks.data.DataProvider;
import demo.stocks.model.Stock;
import demo.stocks.model.Trade;

/**
 * Implementation of the StockService.
 * 
 * @author Irina
 *
 */
public class StockServiceImpl implements StockService {

	private DataProvider dataProvider;
	private StockFormulas stockFormulas;

	public StockServiceImpl(DataProvider dataProvider) {
		this.dataProvider = dataProvider;
		this.stockFormulas = new StockFormulas();
	}

	@Override
	public double computeDividendYield(Stock stock) {
		return stockFormulas.dividendYield(stock);
	}

	@Override
	public double computePeRatio(Stock stock) {
		return stockFormulas.peRatio(stock);
	}

	@Override
	public double computeStockPrice(Stock stock, Date sinceLastDate) {
		List<Trade> trades = dataProvider.getTradesBy(stock, sinceLastDate);

		return stockFormulas.stockPrice(stock, trades);
	}

	@Override
	public double computeGbceAllShareIndex() {
		Map<Stock, List<Trade>> allStocksTrades = new HashMap<>();
		
		List<Stock> allStocks = dataProvider.getAllStocks();
		for (Stock stock : allStocks) {
			allStocksTrades.put(stock, dataProvider.getTradesBy(stock));
		}

		double allShareIndex = stockFormulas.gbceAllShareIndex(allStocksTrades);

		return allShareIndex;
	}

	@Override
	public void recordTrade(Trade trade) {
		dataProvider.addTrade(trade);
		trade.getStock().setTickerPrice(trade.getPrice());
	}
}
