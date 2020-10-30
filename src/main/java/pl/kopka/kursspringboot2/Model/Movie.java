package pl.kopka.kursspringboot2.Model;

import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.validation.constraints.Min;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @NotNull
    private Long id;

    @NotNull
    @Min(2)
    private String tittle;

    @NotNull
    @Min(1900)
    private int year;

    @NotNull
    @Min(5)
    private String director;
}
