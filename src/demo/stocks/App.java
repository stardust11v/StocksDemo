package demo.stocks;

import demo.stocks.model.Stock;

/**
 * 
 * @author Irina
 *
 */
public class App {

	private DataProvider dataProvider = new DataProvider();
	private Output output = new Output(dataProvider);
	
	public static void main(String[] args) {
		App app = new App();
		
		Stock stock = app.dataProvider.getStocks().get(0);
		
		app.output.outputA(stock);
		app.output.outputB();
	}
}
