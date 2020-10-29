package pl.kopka.kursspringboot2.Entity;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private String tittle;
    private int year;
    private String director;
}
