package pl.kopka.kursspringboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kopka.kursspringboot2.Repo.*;
import pl.kopka.kursspringboot2.model.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Main {

    @Autowired
    public Main(StudentRepo studentRepo, BackpackRepo backpackRepo, NotepadRepo notepadRepo, ProfessorRepo professorRepo,
                NoteRepo noteRepo, RoomRepo roomRepo, CleanerRepo cleanerRepo) {

        //backpacks
        Backpack backpackNike = new Backpack("Nike");
        Backpack backpackAdidas = new Backpack("Adidas");

        backpackRepo.save(backpackNike);
        backpackRepo.save(backpackAdidas);


        //notes
        Note note1 = new Note();
        note1.setContent("Testowa notatka 1 Historia");
        noteRepo.save(note1);

        Note note2 = new Note();
        note2.setContent("Testowa notatka 2 Historia");
        noteRepo.save(note2);

        Note note3 = new Note("Testowa notatka 1 IT");
        noteRepo.save(note3);

        Note note4 = new Note("Testowa notatka 2 IT");
        noteRepo.save(note4);

        Set<Note> noteHistory = Stream.of(note1, note2).collect(Collectors.toSet());
        Set<Note> noteIt = Stream.of(note3, note4).collect(Collectors.toSet());


        //notepads
        Notepad notepadHistory = new Notepad("History");
        Notepad notepadIt = new Notepad("It");
        notepadIt.setNote(noteIt);
        notepadHistory.setNote(noteHistory);
        notepadHistory.setBackpack(backpackNike);
        notepadIt.setBackpack(backpackNike);
        notepadRepo.save(notepadHistory);
        notepadRepo.save(notepadIt);


        // students
        Student studentNcb = new Student("Karol", "Zdolny", "165 NCB");
        studentNcb.setBackpack(backpackNike);
        Student studentNca = new Student("Janusz", "Leniuch", "175 NCA");
        studentNca.setBackpack(backpackAdidas);
        Set<Student> studentSet = Stream.of(studentNcb, studentNca).collect(Collectors.toSet());

        // professors
        Professor professorPh = new Professor("Jan", "Springowski", "Ph.D.");
        Professor professorProf = new Professor("Karolina", "Bazodanowska", "Prof.");
        Set<Professor> professorSet = Stream.of(professorPh, professorProf).collect(Collectors.toSet());

        professorPh.setStudentSet(studentSet);
        professorProf.setStudentSet(studentSet);

        studentNcb.setProfessorSet(professorSet);
        studentNca.setProfessorSet(professorSet);



        professorRepo.save(professorPh);
        professorRepo.save(professorProf);

        studentRepo.save(studentNcb);
        studentRepo.save(studentNca);


        //rooms
        Room room1 = new Room(1.123);
        room1.setProfessor(professorPh);
        roomRepo.save(room1);

        Room room2 = new Room(2.001);
        room2.setProfessor(professorProf);


        //cleaners
        Cleaner cleaner1 = new Cleaner("Janina", "Kowalska");
        cleaner1.setRoomSet(Stream.of(room1).collect(Collectors.toSet()));

        Cleaner cleaner2 = new Cleaner("Halina", "Kowalska");
        cleaner1.setRoomSet(Stream.of(room2).collect(Collectors.toSet()));

        room1.setCleanerSet(Stream.of(cleaner1).collect(Collectors.toSet()));
        room2.setCleanerSet(Stream.of(cleaner2).collect(Collectors.toSet()));



        cleanerRepo.save(cleaner1);
        cleanerRepo.save(cleaner2);
        roomRepo.save(room1);
        roomRepo.save(room2);




    }
}
