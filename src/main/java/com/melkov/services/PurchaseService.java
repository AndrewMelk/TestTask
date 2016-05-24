package com.melkov.services;

import com.melkov.objects.Purchase;

import java.util.List;

/**
 * Created by andrew on 20.05.16.
 */
public interface PurchaseService {

    public void insertData(Purchase purchase);
    public List<Purchase> getPurchaseList();
    public List<Purchase> getPurchaseListByPeriod(int month);
}
