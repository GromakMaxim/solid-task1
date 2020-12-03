package org.myshop.storage;

import org.myshop.enums.Genre;
import org.myshop.enums.NomenclatureGroups;
import org.myshop.products.Game;
import org.myshop.products.IProduct;
import org.myshop.products.Saleable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*класс "фильтр"
содержит список товаров со склада, по которому пользователь может фильтроваться/сортироваться(stream api).
выполняется Single Responsibility Principle (Storage.class и Filter.class отделены)
выполняется Liskov Substitution Principle (методы работают через IProduct)
*/
public class Filter {
    private List<IProduct> filteredIProductList;//товары, которые фильтрует пользователь

    public Filter() {
        this.filteredIProductList = new ArrayList<>();
        Storage storage1 = Storage.getInstance();
        filteredIProductList = storage1.fillFilter();
    }

    //вернуть пользователю весь список товаров
    public void removeFilters() {
        filteredIProductList.clear();
        Storage storage1 = Storage.getInstance();
        filteredIProductList = storage1.fillFilter();
    }

    //показать все товары во "временном" списке
    public void showAllProductsInFilteredList() {
        filteredIProductList.forEach(System.out::println);
    }

    //очистить временный список
    public void clearFilteredList() {
        filteredIProductList.clear();
    }

    //фильтр -- активные к продаже
    public void filterActiveForSaleProducts() {
        filteredIProductList = filteredIProductList.stream()
                .filter(Saleable::isActiveForSale)
                .collect(Collectors.toList());
    }

    //фильтр -- активные к заказу
    public void filterActiveForOrderProducts() {
        filteredIProductList = filteredIProductList.stream()
                .filter(IProduct::isActiveForOrder)
                .collect(Collectors.toList());
    }

    //фильтр -- по жанру
    public void filterBySelectedGenre(Genre genre) {
        filteredIProductList = filteredIProductList.stream()
                .filter(IProduct -> IProduct instanceof Game)
                .filter(IProduct -> !((Game) IProduct).getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    //фильтр -- не пустое описаниe
    public void filterNonEmptyDescription() {
        filteredIProductList = filteredIProductList.stream()
                .filter(IProduct -> IProduct instanceof Game)
                .filter(IProduct -> !((Game) IProduct).getDescription().equals(""))
                .collect(Collectors.toList());
    }

    //фильтр -- по возрастному ограничению
    public void filterByPEGI(String pegi) {
        if (filteredIProductList.stream()
                .filter(IProduct -> IProduct instanceof Game)
                .anyMatch(IProduct -> ((Game) IProduct).getRatingPEGI().toString().equalsIgnoreCase(pegi))) {
            filteredIProductList = filteredIProductList.stream()
                    .filter(IProduct -> IProduct instanceof Game)
                    .filter(IProduct -> ((Game) IProduct).getRatingPEGI().toString().equalsIgnoreCase(pegi))
                    .collect(Collectors.toList());
        }
    }

    public void printPEGI() {
        filteredIProductList.stream()
                .filter(IProduct -> IProduct instanceof Game)
                .map(game -> ((Game) game).getRatingPEGI())
                .distinct()
                .forEach(System.out::println);
    }

    //фильтр -- по заданной группе
    public void filterBySelectedProduct(NomenclatureGroups group) {
        //если в выборке существует товар с такой группой - фильтруем
        if (filteredIProductList.stream().anyMatch(IProduct -> IProduct.getNomenclatureGroup().equals(group))) {
            filteredIProductList = filteredIProductList.stream()
                    .filter(IProduct -> IProduct.getNomenclatureGroup().equals(group))
                    .collect(Collectors.toList());
        }
    }

    //фильтр -- тэг
    public void filterBySelectedTag(String kword) {
        //если в выборке существует такой тэг, - фильтруемся.
        if (filteredIProductList.stream()
                .anyMatch(IProduct -> IProduct.getKeywords().stream()
                        .anyMatch(keyword -> keyword.toString().equalsIgnoreCase(kword)))) {
            //фильтр по тегу
            filteredIProductList = filteredIProductList.stream()
                    .filter(IProduct -> IProduct.getKeywords().toString().contains(kword))
                    .collect(Collectors.toList());
        }
    }

    //фильтр - товары с остатками
    public void filterNotEmptyRemains() {
        filteredIProductList = filteredIProductList.stream()
                .filter(IProduct -> IProduct.getRemain() > 0)
                .collect(Collectors.toList());
    }

    //сортировка -- по возрастанию
    public void sortAcsByPrice() {
        filteredIProductList = filteredIProductList.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    //сортировка -- по убыванию
    public void sortDescByPrice() {
        filteredIProductList = filteredIProductList.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    //отобразить теги в отфильтрованном диапазоне
    public void printTags() {
        filteredIProductList.stream()
                .flatMap(IProduct -> Arrays.stream(IProduct.getKeywords().toArray()))
                .distinct()
                .map(product -> product + " ")
                .forEach(System.out::print);
    }
}
