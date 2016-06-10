package demo.stocks.formula;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import demo.stocks.model.Stock;
import demo.stocks.model.StockType;
import demo.stocks.model.Trade;
import demo.stocks.model.TradeIndicator;
import demo.stocks.utils.DateUtils;

public class StockFormulaTest {

	@Test
	public void testDividendYield_Common() {
		StockFormula stockFormula = new StockFormula();
		
		Stock stock = new Stock("TEA", StockType.COMMON, 10, 15, 12, 8);
		
		double dividendYield = stockFormula.dividendYield(stock);
		assertThat(dividendYield, is(1.25));
	}
	
	@Test
	public void testDividendYield_Preferred() {
		StockFormula stockFormula = new StockFormula();
		
		Stock stock = new Stock("GIN", StockType.PREFERRED, 12, 6, 20, 15);
		
		double dividendYield = stockFormula.dividendYield(stock);
		assertThat(dividendYield, is(8.0));
	}

	@Test
	public void testPeRatio_Common() {
		StockFormula stockFormula = new StockFormula();
		
		Stock stock = new Stock("TEA", StockType.COMMON, 10, 15, 12, 8);
		
		double peRatio = stockFormula.peRatio(stock);
		assertThat(peRatio, is(6.4));
	}
	
	@Test
	public void testPeRatio_Preferred() {
		StockFormula stockFormula = new StockFormula();
		
		Stock stock = new Stock("GIN", StockType.PREFERRED, 12, 6, 20, 15);
		
		double peRatio = stockFormula.peRatio(stock);
		assertThat(peRatio, is(1.875));
	}

	@Test
	public void testStockPrice() {
		StockFormula stockFormula = new StockFormula();
		
		Stock stock = new Stock("TEA", StockType.COMMON, 10, 15, 12, 8);
		
		List<Trade> trades = new ArrayList<>();
		
		Date currentDate = new Date();
		
		Trade trade1 = new Trade(stock, currentDate, 1000, 8, TradeIndicator.BUY);
		trades.add(trade1);

		Trade trade2 = new Trade(stock, DateUtils.getPastDateTime(currentDate, 5), 2000, 10, TradeIndicator.BUY);
		trades.add(trade2);

		Trade trade3 = new Trade(stock, DateUtils.getPastDateTime(currentDate, 10), 3000, 6, TradeIndicator.SELL);
		trades.add(trade3);

		Trade trade4 = new Trade(stock, DateUtils.getPastDateTime(currentDate, 15), 4000, 12, TradeIndicator.BUY);
		trades.add(trade4);

		Trade trade5 = new Trade(stock, DateUtils.getPastDateTime(currentDate, 20), 5000, 10, TradeIndicator.SELL);
		trades.add(trade5);
		
		stock.setTickerPrice(trade5.getPrice());
		
		double stockPrice = stockFormula.stockPrice(stock, trades);
		assertThat(stockPrice, is(9.6));
	}
}
