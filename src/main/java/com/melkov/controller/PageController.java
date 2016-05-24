package com.melkov.controller;

import com.melkov.Constants.PurchaseURIConstants;
import com.melkov.Util.DateUtil;
import com.melkov.objects.Purchase;
import com.melkov.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by andrew on 16.05.16.
 */
@RestController
public class PageController {

    @Autowired
    PurchaseService purchaseService;

    @RequestMapping(value = PurchaseURIConstants.INSERT_URI,
                    method = RequestMethod.POST,
                    headers="Accept=application/json")
    public @ResponseBody String insertData(){
        Purchase purchase = new Purchase();
        purchase.setProductName("Bike");
        purchase.setQuantity(1);
        purchase.setProductPrice(1000);
        purchase.setDate(DateUtil.setDate());

        purchaseService.insertData(purchase);

       return "redirect:" + PurchaseURIConstants.LIST_PURCHASE;

    }

    @RequestMapping(value = PurchaseURIConstants.LIST_PURCHASE,
                    method = RequestMethod.GET,
                    headers="Accept=application/json")
    public @ResponseBody List<Purchase> getAllPurchase(){
        List<Purchase> purchaseList = purchaseService.getPurchaseList();
        return purchaseList;
    }

    @RequestMapping(value = PurchaseURIConstants.LIST_PURCHASE_URI,
                    method = RequestMethod.GET,
                    headers="Accept=application/json")
    public @ResponseBody List<Purchase> getProductLIst(@PathVariable int month) {
        List<Purchase> purchaseList = purchaseService.getPurchaseListByPeriod(month);
        return purchaseList;
    }

}
