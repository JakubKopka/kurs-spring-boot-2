package pl.kopka.kursspringboot2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.DoubleStream;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double roomNumber;

    @ManyToMany
    private Set<Cleaner> cleanerSet;

    @OneToOne
    private Professor professor;

    public Room(double roomNumber) {
        this.roomNumber = roomNumber;
    }
}

