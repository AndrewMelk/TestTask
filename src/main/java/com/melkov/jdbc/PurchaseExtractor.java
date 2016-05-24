package com.melkov.jdbc;


import com.melkov.objects.Purchase;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Created by andrew on 20.05.16.
 */
public class PurchaseExtractor implements ResultSetExtractor<Purchase> {

        Logger log = Logger.getLogger("PurchaseExtractor");
    @Override
    public Purchase extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        Purchase purchase = new Purchase();

        purchase.setProductName(resultSet.getString("prod_name"));
        purchase.setQuantity(resultSet.getInt("quantity"));
        purchase.setProductPrice(resultSet.getDouble("price"));
        purchase.setDate(resultSet.getString("purchase_date"));



        return purchase;
    }
}
