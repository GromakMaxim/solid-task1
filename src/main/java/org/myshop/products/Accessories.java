package org.myshop.products;

import org.myshop.enums.Compatibility;
import org.myshop.enums.Keywords;
import org.myshop.enums.NomenclatureGroups;

import java.util.List;

/*класс-наследник "аксессуары"*/
public class Accessories extends Product {
    private List<Compatibility> compatibility;


    public static class AccessoryBuilder {//pattern Builder
        private Accessories newAccessory;

        public AccessoryBuilder() {
            newAccessory = new Accessories();
        }

        public AccessoryBuilder withID(String id) {
            newAccessory.id = id;
            return this;
        }

        public AccessoryBuilder withNomenclature(String nomenclature) {
            newAccessory.nomenclature = nomenclature;
            return this;
        }

        public AccessoryBuilder withPrice(double price) {
            newAccessory.price = price;
            return this;
        }

        public AccessoryBuilder withProducer(String producer) {
            newAccessory.producer = producer;
            return this;
        }

        public AccessoryBuilder withRating(double rating) {
            newAccessory.rating = rating;
            return this;
        }

        public AccessoryBuilder withRemain(double remain) {
            newAccessory.remain = remain;
            return this;
        }

        public AccessoryBuilder withActivityForSale(boolean activityForSale) {
            newAccessory.activeForSale = activityForSale;
            return this;
        }

        public AccessoryBuilder withActivityForOrder(boolean activityForOrder) {
            newAccessory.activeForOrder = activityForOrder;
            return this;
        }

        public AccessoryBuilder withNomenclatureGroup(NomenclatureGroups nomenclatureGroup) {
            newAccessory.nomenclatureGroup = nomenclatureGroup;
            return this;
        }

        public AccessoryBuilder withKeyWords(List<Keywords> keywords) {
            newAccessory.keywords = keywords;
            return this;
        }

        public AccessoryBuilder compatibleWith(List<Compatibility> compatibility) {
            newAccessory.compatibility = compatibility;
            return this;
        }


        public Accessories build() {
            return newAccessory;
        }
    }
}
