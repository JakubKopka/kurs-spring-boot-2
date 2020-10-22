package pl.kopka.kursspringboot2.tydzien2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("start")
public class ShopStart implements Shop {

}
