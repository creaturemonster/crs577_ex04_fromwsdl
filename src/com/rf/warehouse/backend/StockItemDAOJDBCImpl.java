package com.rf.warehouse.backend;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import com.rf.warehouse.common.StockItem;
import com.rf.warehouse.common.StockItemDAO;

/**
 * Queries warehouse database
 * 
 * @author v.lakshmanan
 *  
 */
public class StockItemDAOJDBCImpl implements StockItemDAO {
    private Logger log = Logger.getLogger(StockItemDAOJDBCImpl.class.getCanonicalName());
    /* Note that the log files can be viewed via the Glassfish admim server */
    private Connection conn; // non-pooled connection
    
    public StockItemDAOJDBCImpl() {
        try{
            Properties prop = new Properties();
            //InputStream is = this.getClass().getClassLoader().getResourceAsStream("database.properties");
            InputStream is = this.getClass().getResourceAsStream("database.properties");
            if ( is == null ){
                log.severe("Unable to load database.properties from CLASSPATH.");
                return;
            }
            prop.load(is);
            String dbURL = prop.getProperty("DBURL");
            String driver = prop.getProperty("DRIVER");
            String user = prop.getProperty("USER");
            String passwd = prop.getProperty("PASSWORD");
            Class.forName(driver);
            conn = DriverManager.getConnection(dbURL,user,passwd);
        }
        catch(Exception e){
            throw new DataException(e);
        }
    }
    
    public void close(){
        try{
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e){
            // ok
        }
    }

    public List<StockItem> getStockItemsWithQuantityLessThan(int thresh){
        try {
            PreparedStatement lowStockQuery = conn.prepareStatement("Select * from STOCK item where item.quantity < ?");
            lowStockQuery.setInt(1, thresh);
            ResultSet rs = lowStockQuery.executeQuery(); 
            return createStockItems(rs);
        } catch (SQLException e){
            throw new DataException(e);
        } 
    }
    
    private List<StockItem> createStockItems(ResultSet rs) throws SQLException {
        List<StockItem> result = new ArrayList<StockItem>();
        while (rs.next()){
            int id = rs.getInt("product_id");
            int quantity = rs.getInt("quantity");
            result.add(new StockItem(id,quantity));
        }
        return result;
    }

    public List<StockItem> getStockItemsWithQuantityBetween(int min, int max){
        if ( min > max ){
            throw new IllegalArgumentException("min should be <= than max");
        }
        try {
            PreparedStatement qtyRangeQuery = conn.prepareStatement("Select * from STOCK item where item.quantity >= ? AND item.quantity <= ?");
            qtyRangeQuery.setInt(1, min);
            qtyRangeQuery.setInt(2, max);
            ResultSet rs = qtyRangeQuery.executeQuery();
            return createStockItems(rs);
        } catch (SQLException e){
            throw new DataException(e);
        }
    }
    
    public boolean isInStock(int productId){
        try {
            PreparedStatement inStockQuery = conn.prepareStatement("Select item.quantity from STOCK item where item.product_id = ?");
            inStockQuery.setInt(1, productId);
            ResultSet rs = inStockQuery.executeQuery();
            if (rs.next()){
                int qty = rs.getInt(1);
                return (qty > 0);
            } else {
                return false;
            }
        } catch (SQLException e){
            throw new DataException(e);
        }
    }
}
