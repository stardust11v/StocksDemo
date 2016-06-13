package demo.stocks;

import demo.stocks.model.Stock;

/**
 * The entry point of this simple stock Java app.
 * 
 * @author Irina
 *
 */
public class App {

	public static void main(String[] args) {
		AppObject appObject = new AppObject();
		
		Stock stock = appObject.getDataProvider().getAllStocks().get(0);
		
		appObject.getOutput().outputA(stock);
		appObject.getOutput().outputB();
	}
}
