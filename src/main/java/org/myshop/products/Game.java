package org.myshop.products;

import org.myshop.enums.Genre;
import org.myshop.enums.Keywords;
import org.myshop.enums.NomenclatureGroups;
import org.myshop.enums.PEGI;

import java.util.List;
/*класс-наследник "игры"*/
public class Game extends Product {
    private String description;//описание
    private Genre genre;//жанр
    private PEGI ratingPEGI;//возрастной рейтинг

    public String getDescription() {
        return description;
    }

    public Genre getGenre() {
        return genre;
    }

    public PEGI getRatingPEGI() {
        return ratingPEGI;
    }

    public static class PSGameBuilder {//pattern Builder
        private Game newGame;

        public PSGameBuilder() {
            newGame = new Game();
        }

        public PSGameBuilder withID(String id) {
            newGame.id = id;
            return this;
        }

        public PSGameBuilder withNomenclature(String nomenclature) {
            newGame.nomenclature = nomenclature;
            return this;
        }

        public PSGameBuilder withPrice(double price) {
            newGame.price = price;
            return this;
        }

        public PSGameBuilder withProducer(String producer) {
            newGame.producer = producer;
            return this;
        }

        public PSGameBuilder withRating(double rating) {
            newGame.rating = rating;
            return this;
        }

        public PSGameBuilder withRemain(double remain) {
            newGame.remain = remain;
            return this;
        }

        public PSGameBuilder withActivityForSale(boolean activityForSale) {
            newGame.activeForSale = activityForSale;
            return this;
        }

        public PSGameBuilder withActivityForOrder(boolean activityForOrder) {
            newGame.activeForOrder = activityForOrder;
            return this;
        }

        public PSGameBuilder withNomenclatureGroup(NomenclatureGroups nomenclatureGroup) {
            newGame.nomenclatureGroup = nomenclatureGroup;
            return this;
        }

        public PSGameBuilder withKeyWords(List<Keywords> keywords) {
            newGame.keywords = keywords;
            return this;
        }

        public PSGameBuilder withDescription(String description) {
            newGame.description = description;
            return this;
        }

        public PSGameBuilder withGenre(Genre genre) {
            newGame.genre = genre;
            return this;
        }

        public PSGameBuilder withRatingPEGI(PEGI ratingPEGI) {
            newGame.ratingPEGI = ratingPEGI;
            return this;
        }

        public Game build() {
            return newGame;
        }
    }
}
