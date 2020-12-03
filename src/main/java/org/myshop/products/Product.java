package org.myshop.products;

import org.myshop.enums.Keywords;
import org.myshop.enums.NomenclatureGroups;

import java.util.List;

/*базовый класс "товар"*/
/*выполняется Open-Closed Prinsiple - товары имплементируют один и тот же интерфейс IProduct. Filter и Storage работают через этот интерфейс IProduct*/
public abstract class Product implements IProduct,Orderable,Saleable {
    public String id;//код товара
    public String nomenclature;//название номенклатуры
    public double price;//цена
    public String producer;//производитель
    public double rating;//пользовательский рейтинг
    public double remain;//кол-во на остатках
    public boolean activeForSale;//активность к продаже
    public boolean activeForOrder;//активность к заказу
    public NomenclatureGroups nomenclatureGroup;//группа товаров
    public List<Keywords> keywords;//теги(для пользователей)

    @Override
    public String getId() {
        return id;
    }


    @Override
    public String getNomenclature() {
        return nomenclature;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getProducer() {
        return producer;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public double getRemain() {
        return remain;
    }

    @Override
    public boolean isActiveForSale() {
        return activeForSale;
    }

    @Override
    public boolean isActiveForOrder() {
        return activeForOrder;
    }

    @Override
    public NomenclatureGroups getNomenclatureGroup() {
        return nomenclatureGroup;
    }

    @Override
    public List<Keywords> getKeywords() {
        return keywords;
    }

    @Override
    public void setRemain(double remain) {
        this.remain = remain;
    }

    @Override
    public String toString() {
        return "Код: "+ getId() + " Наименование: " + getNomenclature() + " " +
                "Цена: " + getPrice();
    }

    @Override
    public int compareTo(IProduct o) {
        return (int) (this.getPrice() - o.getPrice());
    }
}
