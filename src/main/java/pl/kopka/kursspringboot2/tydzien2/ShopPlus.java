package pl.kopka.kursspringboot2.tydzien2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("plus")
public class ShopPlus implements Shop {

    @Value("${tax}")
    private double tax;


    public double generatePrice(){
        return getRandomPrice() * tax;
    };

}
