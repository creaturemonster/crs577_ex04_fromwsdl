/**
 * 
 */
package com.rf.warehouse.webapps;

import java.util.List;

import javax.jws.WebService;

import com.rf.warehouse.backend.StockItemDAOJDBCImpl;
import com.rf.warehouse.common.StockItem;
import com.rf.warehouse.common.StockItemDAO;
import com.rf.warehouse.generated.webapps.Stock;
import com.rf.warehouse.generated.webapps.StockListType;

/**
 * Demonstrates web service created from WSDL
 */
// TODO: Add required annotations and 'implements' relationships
// HINT: See slide 4-16
@WebService(endpointInterface = "com.rf.warehouse.generated.webapps.Stock")
public class StockWebServiceImpl implements Stock {
	// TODO: Examine the declaration and initialization of a StockItemDAO.
	// All Web service calls will be delegated to this object.
	// (No code changes required).
	private StockItemDAO dao = new StockItemDAOJDBCImpl();

	// TODO: Examine the declaration and initialization of a StockListAdapter.
	// This is a helper class that can convert the List<StockItem>
	// returned by the DAO methods to the StockListType required by the
	// Web service methods.
	// (No code changes required).
	private StockListAdapter adapter = new StockListAdapter();

	@Override
	public StockListType getStockItemsWithQuantityLessThan(int threshold) {
		List<StockItem> items = dao.getStockItemsWithQuantityLessThan(threshold);
		StockListType stockList = adapter.createStockList(items);
		return stockList;
	}

	@Override
	public StockListType getStockItemsWithQuantityBetween(int min, int max) {
		List<StockItem> items = dao.getStockItemsWithQuantityBetween(min, max);
		StockListType stockList = adapter.createStockList(items);
		return stockList;
	}

	@Override
	public boolean isInStock(int productId) {
		// TODO Auto-generated method stub
		return dao.isInStock(productId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	// TODO: Implement the operations defined by the generated Stock service
	// endpoint interface
	// HINT: Right-click here, select Source | Override/Implement Methods,
	// select the 3 methods in the Stock interface, OK
	// HINT: Call dao methods to get the data
	// HINT: Use adapter to convert data to correct type

}
