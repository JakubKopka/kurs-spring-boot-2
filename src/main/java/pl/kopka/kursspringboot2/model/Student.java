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
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String groupNumber;
    @ManyToMany
    private Set<Professor> professorSet;

    @OneToOne
    private Backpack backpack;


    public Student(String name, String surname, String groupNumber) {
        this.name = name;
        this.surname = surname;
        this.groupNumber = groupNumber;
    }

}
