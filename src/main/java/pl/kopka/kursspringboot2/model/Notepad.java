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
@Table(name = "notepads")
public class Notepad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    private Backpack backpack;

    @OneToMany
    @JoinColumn(name = "notepad_id")
    private Set<Note> note;

    public Notepad(String title) {
        this.title = title;
    }


}