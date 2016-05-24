package com.melkov.dao;

import com.melkov.objects.Purchase;

import java.util.List;

/**
 * Created by andrew on 17.05.16.
 */
public interface PurchaseDAO {

    public void insertData(Purchase purchase);
    public List<Purchase> getPurchaseList();
    public List<Purchase> getPurchaseListByPeriod(int month);
    public Purchase getTestPurchase();

}
