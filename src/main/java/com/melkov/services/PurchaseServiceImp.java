package com.melkov.services;

import com.melkov.dao.PurchaseDAO;
import com.melkov.objects.Purchase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by andrew on 20.05.16.
 */
public class PurchaseServiceImp implements PurchaseService {

    @Autowired
    PurchaseDAO purchaseDAO;

    @Override
    public void insertData(Purchase purchase) {
        purchaseDAO.insertData(purchase);

    }

    @Override
    public List<Purchase> getPurchaseList() {
        return purchaseDAO.getPurchaseList();
    }

    @Override
    public List<Purchase> getPurchaseListByPeriod(int month) {

        return purchaseDAO.getPurchaseListByPeriod(month);
    }
}
