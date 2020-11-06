package pl.kopka.kursspringboot2.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kopka.kursspringboot2.model.Notepad;

@Repository
public interface NotepadRepo extends JpaRepository<Notepad, Long> {
}