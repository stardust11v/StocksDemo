package demo.stocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import demo.stocks.model.Stock;
import demo.stocks.model.StockType;
import demo.stocks.model.Trade;
import demo.stocks.model.TradeIndicator;
import demo.stocks.utils.DateUtils;

/**
 * 
 * @author Irina
 *
 */
public class DataProvider {

	private List<Stock> stocks = new ArrayList<>();
	private List<Trade> trades = new ArrayList<>();

	public DataProvider() {
		initStocks();
		initTrades();
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public List<Trade> getAllTrades() {
		return trades;
	}
	
	public List<Trade> getTradesBy(Stock stock) {
		List<Trade> filteredTradeList = new ArrayList<>();

        for (Trade trade : trades) {
            if (trade.getStock().equals(stock)) {
                filteredTradeList.add(trade);
            }
        }
        
        return filteredTradeList;
	}
	
	public List<Trade> getTradesBy(Stock stock, Date lastDate) {
		List<Trade> filteredTradeList = new ArrayList<>();

        for (Trade trade : trades) {
            if (trade.getStock().equals(stock) 
            		&& trade.getTimestamp().getTime() > lastDate.getTime()) {
                filteredTradeList.add(trade);
            }
        }
        
        return filteredTradeList;
	}

	public void recordTrade(Trade trade) {
		trades.add(trade);
		trade.getStock().setTickerPrice(trade.getPrice());
	}

	private void initStocks() {
		stocks = new ArrayList<>();

		stocks.add(new Stock("TEA", StockType.COMMON, 10, 15, 12, 8));
		stocks.add(new Stock("POP", StockType.COMMON, 100, 150, 120, 80));
		stocks.add(new Stock("ALE", StockType.COMMON, 5, 0, 100, 110));
		stocks.add(new Stock("GIN", StockType.PREFERRED, 0, 0, 20, 30));
		stocks.add(new Stock("JOE", StockType.COMMON, 0, 0, 50, 60));
	}

	private void initTrades() {
		trades = new ArrayList<>();

		Stock stock1 = stocks.get(0);

		Date currentDate = new Date();
		
		Trade trade1 = new Trade(stock1, currentDate, 1000, 8, TradeIndicator.BUY);
		recordTrade(trade1);

		Trade trade2 = new Trade(stock1, DateUtils.getPastDateTime(currentDate, 5), 2000, 10, TradeIndicator.BUY);
		recordTrade(trade2);

		Trade trade3 = new Trade(stock1, DateUtils.getPastDateTime(currentDate, 10), 3000, 6, TradeIndicator.SELL);
		recordTrade(trade3);

		Trade trade4 = new Trade(stock1, DateUtils.getPastDateTime(currentDate, 15), 4000, 12, TradeIndicator.BUY);
		recordTrade(trade4);

		Trade trade5 = new Trade(stock1, DateUtils.getPastDateTime(currentDate, 20), 5000, 10, TradeIndicator.SELL);
		recordTrade(trade5);
	}
}
