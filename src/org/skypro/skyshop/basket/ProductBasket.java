package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap;

    public ProductBasket() {
        this.productsMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        productsMap.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeProductByName(String name) {
        return productsMap.remove(name);
    }

    public int getTotalCost() {
        return productsMap.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        productsMap.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    private long getSpecialCount() {
        return productsMap.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean containsProduct(String name) {
        return productsMap.containsKey(name);
    }

    public void clearBasket() {
        productsMap.clear();
    }
}