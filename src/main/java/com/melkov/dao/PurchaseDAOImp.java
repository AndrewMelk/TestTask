package com.melkov.dao;


import com.melkov.jdbc.PurchaseRowMapper;
import com.melkov.objects.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 20.05.16.
 */
public class PurchaseDAOImp implements PurchaseDAO {

    @Autowired
    DataSource dataSource;

    @Override
    public void insertData(Purchase purchase) {

        String sql = "INSERT INTO Purchase" +
                "(prod_id, quantity, purchase_date) VALUES (?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(
                sql,
                new Object[]{purchase.getProdId(),
                            purchase.getQuantity(),
                            purchase.getProductPrice(),
                            purchase.getDate()});

    }

    @Override
    public List<Purchase> getPurchaseList() {
        List purchaseList = new ArrayList();

        String sql = "SELECT Product.prod_name, " +
                            "Purchase.quantity, " +
                            "Product.price , " +
                            "Purchase.purchase_date " +
                     "FROM Purchase " +
                     "INNER JOIN Product " +
                     "ON Product.prod_id = Purchase.prod_id";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        purchaseList = jdbcTemplate.query(sql, new PurchaseRowMapper());
        if (purchaseList!=null){
            return purchaseList;
        }
        return null;
    }

    @Override
    public List<Purchase> getPurchaseListByPeriod(int month) {
        List purchaseList = new ArrayList();

        String sql = "SELECT Product.prod_name,Purchase.quantity,Product.price , Purchase.purchase_date " +
                "FROM Purchase " +
                "INNER JOIN Product " +
                "ON Product.prod_id = Purchase.prod_id " +
                "WHERE Purchase.purchase_date >= DATE_SUB(CURRENT_DATE, INTERVAL " + month + " MONTH);";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        purchaseList = jdbcTemplate.query(sql, new PurchaseRowMapper());
        if (purchaseList!=null){
        return purchaseList;
        }
        return null;
    }

    @Override
    public Purchase getTestPurchase() {
        Purchase purchase = new Purchase();

        String sql = "SELECT Product.prod_name, " +
                "Purchase.quantity, " +
                "Product.price , " +
                "Purchase.purchase_date " +
                "FROM Purchase " +
                "INNER JOIN Product " +
                "ON Product.prod_id = Purchase.prod_id " +
                "WHERE Product.prod_name = 'Bike',Purchase.purchase_date='2016-03-11'";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        purchase = (Purchase) jdbcTemplate.query(sql, new PurchaseRowMapper());
        if (purchase!=null){
            return purchase;
        }
        return null;

    }


}
