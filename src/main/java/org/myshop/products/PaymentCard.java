package org.myshop.products;

import org.myshop.enums.Keywords;
import org.myshop.enums.NomenclatureGroups;

import java.util.List;
/*класс-наследник "платёжные карты"*/
public class PaymentCard extends Product {
    private double sum;

    public static class CardBuilder {//pattern Builder
        private PaymentCard newCard;

        public CardBuilder() {
            newCard = new PaymentCard();
        }

        public CardBuilder withID(String id) {
            newCard.id = id;
            return this;
        }

        public CardBuilder withNomenclature(String nomenclature) {
            newCard.nomenclature = nomenclature;
            return this;
        }

        public CardBuilder withPrice(double price) {
            newCard.price = price;
            return this;
        }

        public CardBuilder withProducer(String producer) {
            newCard.producer = producer;
            return this;
        }

        public CardBuilder withRating(double rating) {
            newCard.rating = rating;
            return this;
        }

        public CardBuilder withRemain(double remain) {
            newCard.remain = remain;
            return this;
        }

        public CardBuilder withActivityForSale(boolean activityForSale) {
            newCard.activeForSale = activityForSale;
            return this;
        }

        public CardBuilder withActivityForOrder(boolean activityForOrder) {
            newCard.activeForOrder = activityForOrder;
            return this;
        }

        public CardBuilder withNomenclatureGroup(NomenclatureGroups nomenclatureGroup) {
            newCard.nomenclatureGroup = nomenclatureGroup;
            return this;
        }

        public CardBuilder withKeyWords(List<Keywords> keywords) {
            newCard.keywords = keywords;
            return this;
        }

        public CardBuilder withSum(double sum) {
            newCard.sum = sum;
            return this;
        }

        public PaymentCard build() {
            return newCard;
        }
    }
}
