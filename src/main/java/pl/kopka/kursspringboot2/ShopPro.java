package pl.kopka.kursspringboot2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("pro")
public class ShopPro implements Shop {

    @Value("${discount}")
    private double discount;


    public double generatePrice(){
        return getRandomPrice() * (1-discount);
    };
}
