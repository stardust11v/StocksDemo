package demo.stocks.formula;

import java.util.ArrayList;
import java.util.List;

import demo.stocks.DataProvider;
import demo.stocks.model.Stock;
import demo.stocks.model.Trade;

/**
 * 
 * @author Irina
 *
 */
public class StockFormula {

	private DataProvider dataProvider;
	
	public StockFormula(DataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}
	
	public double dividendYield(Stock stock) {
		double dividendYield = 0;

		switch (stock.getType()) {
		case COMMON:
			dividendYield = stock.getLastDividend() / stock.getTickerPrice();
			break;

		case PREFERRED:
			dividendYield = (stock.getFixedDividend() * stock.getParValue()) / stock.getTickerPrice();
			break;
		}

		return dividendYield;
	}

	public double peRatio(Stock stock) {
		double peRatio = 0;

		double dividendYield = dividendYield(stock);

		if (dividendYield > 0) {
			peRatio = stock.getTickerPrice() / dividendYield;
		}

		return peRatio;
	}

	public double stockPrice(Stock stock, List<Trade> trades) {
		double stockPrice = 0;

        double tradeSum = 0;
        double quantitySum = 0;

        for (Trade trade : trades) {
            tradeSum += (trade.getPrice() * trade.getQuantity());
            quantitySum += trade.getQuantity();
        }

        if (quantitySum > 0) {
            stockPrice = tradeSum / quantitySum;
        }

		return stockPrice;
	}

	public double gbceAllShareIndex(List<Stock> stocks, List<Trade> allTrades) {
		double allShareIndex = 0;

        List<Double> stockPrices = new ArrayList<>();

        for (Stock stock : stocks) {
            List<Trade> stockTrades = dataProvider.getTradesBy(stock);
            double price = stockPrice(stock, stockTrades);
            if (price > 0) {
                stockPrices.add(price);
            }
        }

        if (!stockPrices.isEmpty()) {
        	allShareIndex = geometricMean(stockPrices);
        }
        
		return allShareIndex;
	}

	private double geometricMean(List<Double> prices) {
		double geometricMean = 1;

		for (double price : prices) {
			geometricMean = geometricMean * price;
		}

		geometricMean = Math.pow(geometricMean, 1 / prices.size());

		return geometricMean;
	}
}
