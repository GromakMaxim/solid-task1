package org.myshop.products;

import org.myshop.enums.Keywords;
import org.myshop.enums.NomenclatureGroups;

import java.util.List;
/*класс-наследник "консоли"*/
public class Console extends Product {
    private String memory;//память
    private boolean bundle;//бандл?
    private boolean limitedEdition;//ограниченная серия?
    private double discount;//скидка

    public static class ConsoleBuilder {//pattern Builder
        private Console newConsole;

        public ConsoleBuilder() {
            newConsole = new Console();
        }

        public ConsoleBuilder withID(String id) {
            newConsole.id = id;
            return this;
        }

        public ConsoleBuilder withNomenclature(String nomenclature) {
            newConsole.nomenclature = nomenclature;
            return this;
        }

        public ConsoleBuilder withPrice(double price) {
            newConsole.price = price;
            return this;
        }

        public ConsoleBuilder withProducer(String producer) {
            newConsole.producer = producer;
            return this;
        }

        public ConsoleBuilder withRating(double rating) {
            newConsole.rating = rating;
            return this;
        }

        public ConsoleBuilder withRemain(double remain) {
            newConsole.remain = remain;
            return this;
        }

        public ConsoleBuilder withActivityForSale(boolean activityForSale) {
            newConsole.activeForSale = activityForSale;
            return this;
        }

        public ConsoleBuilder withActivityForOrder(boolean activityForOrder) {
            newConsole.activeForOrder = activityForOrder;
            return this;
        }

        public ConsoleBuilder withNomenclatureGroup(NomenclatureGroups nomenclatureGroup) {
            newConsole.nomenclatureGroup = nomenclatureGroup;
            return this;
        }

        public ConsoleBuilder withKeyWords(List<Keywords> keywords) {
            newConsole.keywords = keywords;
            return this;
        }

        public ConsoleBuilder withMemory(String memory) {
            newConsole.memory = memory;
            return this;
        }

        public ConsoleBuilder withBundle(boolean bundle) {
            newConsole.bundle = bundle;
            return this;
        }

        public ConsoleBuilder withLimitedEdition(boolean limitedEdition) {
            newConsole.limitedEdition = limitedEdition;
            return this;
        }
        public ConsoleBuilder withDiscount(double discount) {
            newConsole.discount = discount;
            return this;
        }


        public Console build() {
            return newConsole;
        }
    }
}
