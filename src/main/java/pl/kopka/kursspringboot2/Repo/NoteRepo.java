package pl.kopka.kursspringboot2.Repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kopka.kursspringboot2.model.Note;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {
}
