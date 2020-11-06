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
@Table(name = "professors")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String title;
    @ManyToMany(mappedBy = "professorSet")
    private Set<Student> studentSet;

    @OneToOne(mappedBy = "professor")
    private Room room;

    public Professor(String name, String surname, String title) {
        this.name = name;
        this.surname = surname;
        this.title = title;
    }

}
