package com.melkov.jdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrew on 20.05.16.
 */
public class PurchaseRowMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        PurchaseExtractor purchaseExtractor = new PurchaseExtractor();
        return purchaseExtractor.extractData(resultSet);
    }
}
