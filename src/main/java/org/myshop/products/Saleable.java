package org.myshop.products;
/*продаваемый*/
public interface Saleable {
    String getId();

    String getNomenclature();

    double getPrice();

    boolean isActiveForSale();

    double getRemain();

}
