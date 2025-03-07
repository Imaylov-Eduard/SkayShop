package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        try {
            SimpleProduct invalidProduct = new SimpleProduct("", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            DiscountedProduct invalidDiscountedProduct = new DiscountedProduct("Смартфон", -100, 110);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        ProductBasket basket = new ProductBasket();

        SimpleProduct laptop = new SimpleProduct("Ноутбук", 50000);
        DiscountedProduct smartphone = new DiscountedProduct("Смартфон", 30000, 10);
        FixPriceProduct headphones = new FixPriceProduct("Наушники");

        basket.addProduct(laptop);
        basket.addProduct(smartphone);
        basket.addProduct(headphones);

        Article article1 = new Article("Обзор ноутбуков", "Ноутбуки стали мощнее и доступнее.");
        Article article2 = new Article("Новые смартфоны", "Смартфоны с улучшенными камерами.");

        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(laptop);
        searchEngine.add(smartphone);
        searchEngine.add(headphones);
        searchEngine.add(article1);
        searchEngine.add(article2);

        try {
            Searchable bestMatch = searchEngine.findBestMatch("ноутбук");
            System.out.println("Найден лучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            Searchable bestMatch = searchEngine.findBestMatch("несуществующий запрос");
            System.out.println("Найден лучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}