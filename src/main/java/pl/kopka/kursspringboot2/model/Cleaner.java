package pl.kopka.kursspringboot2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cleaners")
public class Cleaner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @ManyToMany(mappedBy = "cleanerSet")
    private Set<Room> roomSet;

    public Cleaner(String name, String surname) {
        this.name=name;
        this.surname=surname;
    }
}
