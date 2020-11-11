package pl.kopka.kursspringboot2.model;


import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @NotNull
    private Long id;

    @NotNull
    private String mark;

    @NotNull
    private String model;

    @NotNull
    private String color;

    @NotNull
    private String productionDate;
}
