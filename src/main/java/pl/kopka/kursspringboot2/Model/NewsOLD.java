package pl.kopka.kursspringboot2.Model;


import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewsOLD {

    @NotNull
    private String id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String url;

    @NotNull
    private String author;

    @NotNull
    private String image;

    @NotNull
    private String published;


}
