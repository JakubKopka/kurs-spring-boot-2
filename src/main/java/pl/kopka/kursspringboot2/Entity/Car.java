package pl.kopka.kursspringboot2.Entity;

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
