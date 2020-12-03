package org.myshop.customer;

import org.myshop.storage.Storage;

import java.util.HashMap;
import java.util.Map;

public class Customer implements ICustomer {
    private String username; //пользовательский никнейм
    private Map<String, Integer> shopCart; //k:v -- код товара : кол-во штук

    public Customer(String username) {
        this.username = username;
        this.shopCart = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void buy(String code, int quantity) {
        Storage storage1 = Storage.getInstance();
        if (storage1.sellProduct(code, quantity) != null) {
            shopCart.put(code, quantity);
        }
    }

    public String printShopCart() {
        Storage storage1 = Storage.getInstance();
        StringBuilder sb = new StringBuilder();
        double cheque = 0;
        for (Map.Entry<String, Integer> item : shopCart.entrySet()) {
            String nomenclature = storage1.getProduct(item.getKey()).getNomenclature();
            double price = storage1.getProduct(item.getKey()).getPrice();
            double pricePerPosition = price * item.getValue();
            cheque = cheque + pricePerPosition;
            sb.append(nomenclature + " --- " + price + " --- " + item.getValue() + " --- " + pricePerPosition + "\n");
        }
        sb.append("----------------------------------------------------------------------------------------------\n");
        sb.append(cheque + "\n");
        return sb.toString();
    }
}
