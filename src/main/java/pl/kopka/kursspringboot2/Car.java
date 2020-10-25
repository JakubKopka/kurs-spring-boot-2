package pl.kopka.kursspringboot2;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Car {
    private long id;
    private String mark;
    private String model;
    private String color;
}
