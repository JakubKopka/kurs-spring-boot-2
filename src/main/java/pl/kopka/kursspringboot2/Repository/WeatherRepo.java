package pl.kopka.kursspringboot2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kopka.kursspringboot2.Model.Weather;

public interface WeatherRepo extends JpaRepository<Weather, Long> {
}
