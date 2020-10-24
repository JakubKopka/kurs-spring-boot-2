package pl.kopka.kursspringboot2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {
    private long id;
    private String mark;
    private String model;
    private String color;
}
