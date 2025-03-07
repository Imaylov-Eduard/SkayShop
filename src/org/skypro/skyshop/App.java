package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        // Создаем корзину
        ProductBasket basket = new ProductBasket();

        // Создаем продукты
        SimpleProduct laptop = new SimpleProduct("Ноутбук", 50000);
        DiscountedProduct smartphone = new DiscountedProduct("Смартфон", 30000, 10);
        FixPriceProduct headphones = new FixPriceProduct("Наушники");

        // Добавляем продукты в корзину
        basket.addProduct(laptop);
        basket.addProduct(smartphone);
        basket.addProduct(headphones);

        // Печать содержимого корзины
        System.out.println("Содержимое корзины:");
        basket.printBasket();

        // Получение общей стоимости корзины
        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());

        // Поиск товара, который есть в корзине
        System.out.println("Есть ли в корзине 'Наушники'? " + basket.containsProduct("Наушники"));

        // Очистка корзины
        basket.clearBasket();

        // Печать содержимого пустой корзины
        System.out.println("Содержимое корзины после очистки:");
        basket.printBasket();
    }
}