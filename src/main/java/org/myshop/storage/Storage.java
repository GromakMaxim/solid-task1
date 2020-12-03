package org.myshop.storage;

import org.myshop.products.IProduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*класс - склад
pattern Singletone

выполняется Single Responsibility Principle - чтобы избавиться от эффекта god-object, я выделил непосредственно
Storage.class откуда будут списываться/продаваться товары и Filter.class в котором происходит фильтраци пользователя
*/
public class Storage {
    private static Storage instance = null;
    private final Map<String, IProduct> storageMap;//key:value -- код товара : товар; все товары на складе

    private Storage() {
        this.storageMap = new HashMap<>();
        fillStorage();
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    //наполнить склад товарами
    private void fillStorage() {
        ProductCreator productCreator = new ProductCreator();
        for (IProduct item : productCreator.createNewGoodsList()) {
            storageMap.put(item.getId(), item);//добавляем товары на склад
        }
    }

    public List<IProduct> fillFilter() {
        List<IProduct> filteredIProductList = new ArrayList<>();
        for (Map.Entry<String, IProduct> item : storageMap.entrySet()) {
            filteredIProductList.add(item.getValue());
        }
        return filteredIProductList;
    }

    public IProduct sellProduct(String code, int quantity) {
        if (storageMap.containsKey(code) && storageMap.get(code).getRemain() >= quantity) {//если на складе есть такой товар и в нужном количестве...
            reduceRemains(code, quantity);//..убираем со склада покупаемое количество товаров
            return storageMap.get(code);
        }
        return null;
    }

    public IProduct getProduct(String code) {
        if (storageMap.containsKey(code)) {
            return storageMap.get(code);
        }
        return null;
    }

    //уменьшить остаток товара на складе
    private void reduceRemains(String code, int quantity) {
        storageMap.get(code).setRemain(storageMap.get(code).getRemain() - quantity);
    }
}

