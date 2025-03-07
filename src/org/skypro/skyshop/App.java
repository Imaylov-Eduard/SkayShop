package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        // Создаем корзину
        ProductBasket basket = new ProductBasket();

        // Создаем продукты
        Product laptop = new Product("Ноутбук", 50000);
        Product smartphone = new Product("Смартфон", 30000);
        Product headphones = new Product("Наушники", 5000);
        Product monitor = new Product("Монитор", 15000);
        Product keyboard = new Product("Клавиатура", 2000);

        // Добавляем продукты в корзину
        basket.addProduct(laptop);
        basket.addProduct(smartphone);
        basket.addProduct(headphones);
        basket.addProduct(monitor);
        basket.addProduct(keyboard);

        // Попытка добавить продукт в заполненную корзину
        Product mouse = new Product("Мышь", 1000);
        basket.addProduct(mouse); // Должно вывести "Невозможно добавить продукт"

        // Печать содержимого корзины
        System.out.println("Содержимое корзины:");
        basket.printBasket();

        // Получение общей стоимости корзины
        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());

        // Поиск товара, который есть в корзине
        System.out.println("Есть ли в корзине 'Наушники'? " + basket.containsProduct("Наушники"));

        // Поиск товара, которого нет в корзине
        System.out.println("Есть ли в корзине 'Мышь'? " + basket.containsProduct("Мышь"));

        // Очистка корзины
        basket.clearBasket();

        // Печать содержимого пустой корзины
        System.out.println("Содержимое корзины после очистки:");
        basket.printBasket();

        // Получение стоимости пустой корзины
        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalCost());

        // Поиск товара по имени в пустой корзине
        System.out.println("Есть ли в корзине 'Ноутбук'? " + basket.containsProduct("Ноутбук"));
    }
}