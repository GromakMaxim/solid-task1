package org.myshop;
import org.myshop.customer.Customer;
import org.myshop.enums.NomenclatureGroups;
import org.myshop.storage.Filter;
import java.util.Scanner;

/*программа-магазин
*-фильтрация по группе товара
*-фильтрация по тегам
*-фильтрация по возр. ограничениям
*-сортировка по цене
*-добавление товара в корзину и печать чека
*
* SRP - чтобы избавиться от эффекта god-object, я выделил непосредственно
Storage.class откуда будут списываться товары и Filter.class в котором происходит фильтрация пользователя
* OCP - товары имплементируют один и тот же интерфейс IProduct. Filter и Storage работают через этот интерфейс IProduct.
* "Открытость для расширения" достигается наследованием от Product
* LSP - методы в Filter.class работают через интерфейс IProduct
* ISP - функциональность IProduct разделена на интерфейсы поменьше
* DIP - ??
*
* */
public class App {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        Filter storageFilter = new Filter();

        System.out.println("Добро пожаловать в магазин. Для регистрации, ответте на пару вопросов");
        System.out.println("Как к вам обращаться?");
        String customerName = myScan.nextLine();
        Customer customer = new Customer(customerName);//создаётся покупатель
        System.out.println("Отлично, " + "\"" + customer.getUsername() + "\"" + " Возможно, у нас есть что-то для вас.");
        while (true) {
            storageFilter.showAllProductsInFilteredList();//показываем весь массив товаров

            //меню магазина
            System.out.println("1. Фильтр \"игры\"");
            System.out.println("2. Фильтр \"консоли\"");
            System.out.println("3. Фильтр \"аксессуары\"");
            System.out.println("4. Фильтр \"карты оплаты\"");
            System.out.println("5. Фильтр по тегу");
            System.out.println("6. Фильтр \"возрастные ограничения\"");
            System.out.println("7. Добавить товар в корзину");
            System.out.println("8. Показать товары в корзине");
            System.out.println("> Сортировка по цене по убыванию");
            System.out.println("< Сортировка по цене по возрастанию");
            System.out.println("0. Снять фильтры");

            String customerInput = myScan.next();

            switch (customerInput) {
                case "1" -> storageFilter.filterBySelectedProduct(NomenclatureGroups.GAME);
                case "2" -> storageFilter.filterBySelectedProduct(NomenclatureGroups.CONSOLE);
                case "3" -> storageFilter.filterBySelectedProduct(NomenclatureGroups.ACCESSORIES);
                case "4" -> storageFilter.filterBySelectedProduct(NomenclatureGroups.PAYMENTCARD);
                case "5" -> {
                    storageFilter.printTags();//показать все теги
                    String keyword = myScan.next();
                    storageFilter.filterBySelectedTag(keyword);
                }
                case "6" -> {
                    System.out.println("Все теги: ");
                    storageFilter.printPEGI();//показать все возрастные рейтинги
                    System.out.println();
                    System.out.println("Введите тег");
                    String pegi = myScan.nextLine();
                    storageFilter.filterByPEGI(pegi);
                }
                case "7" -> {
                    System.out.println("Введите код товара");
                    String code = myScan.next();
                    System.out.println("Введите количество товара");
                    int quantity = myScan.nextInt();
                    customer.buy(code, quantity);
                }

                case "8" -> {
                    System.out.println("Товар --- Цена за 1 ед --- Кол-во --- Цена тотал");
                    System.out.println(customer.printShopCart());
                }

                case ">" -> storageFilter.sortDescByPrice();
                case "<" -> storageFilter.sortAcsByPrice();
                case "0" -> storageFilter.removeFilters();
            }
        }
    }
}
