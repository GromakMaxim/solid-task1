package org.myshop.products;
/*"заказываемый"*/
public interface Orderable {
    String getId();

    String getNomenclature();

    double getPrice();

    boolean isActiveForOrder();
}
