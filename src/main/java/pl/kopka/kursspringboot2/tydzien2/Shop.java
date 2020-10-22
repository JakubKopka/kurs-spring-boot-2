package pl.kopka.kursspringboot2.tydzien2;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;

public interface Shop {

    List<Product> productList = new ArrayList<>();

    @EventListener(ApplicationReadyEvent.class)
    default void start(){
        initShoppingBasket();
        System.out.println("Sum of bsasket: " + getSumOfBasket() + " pln");
    }

    default void initShoppingBasket() {
        productList.add(new Product("Produkt#01", generatePrice()));
        productList.add(new Product("Produkt#02", generatePrice()));
        productList.add(new Product("Produkt#03", generatePrice()));
        productList.add(new Product("Produkt#04", generatePrice()));
        productList.add(new Product("Produkt#05", generatePrice()));

        productList.forEach(o -> System.out.println(o.toString()));
    }

    default double generatePrice(){
        return getRandomPrice();
    };

    default double getRandomPrice() {
        return Math.random() * (300 - 50 + 1) + 50;
    }

    default double getSumOfBasket() {
        return productList.stream().mapToDouble(o -> o.getPrice()).sum();
    }
}
