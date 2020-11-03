package pl.kopka.kursspringboot2.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "weathers")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double temp;
    private Double pressure;
    private Double humidity;
    private Double windSpeed;
    private Double windDirection;
    private String observationTime;
}
