package demo.stocks;

import demo.stocks.data.DataProvider;
import demo.stocks.sevice.StockService;
import demo.stocks.sevice.StockServiceImpl;

/**
 * Creates and wires together all the components of this application.
 * 
 * @author Irina
 *
 */
public class AppObject {

	// data
	private DataProvider dataProvider = new DataProvider();
	
	// functionality
	private StockService stockService = new StockServiceImpl(dataProvider);
	
	// demo output for functionality
	private Output output = new Output(stockService);

	public DataProvider getDataProvider() {
		return dataProvider;
	}
	
	public Output getOutput() {
		return output;
	}
}
