package org.myshop.products;

import org.myshop.enums.Keywords;
import org.myshop.enums.NomenclatureGroups;

import java.util.List;

/*выполняется ISP - функциональность разделена на интерфейсы поменьше*/
public interface IProduct extends Comparable<IProduct>, Orderable, Saleable {

    String getProducer();

    double getRating();

    NomenclatureGroups getNomenclatureGroup();

    List<Keywords> getKeywords();

    void setRemain(double remain);
}
