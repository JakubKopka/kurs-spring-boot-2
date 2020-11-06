package pl.kopka.kursspringboot2.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kopka.kursspringboot2.model.Cleaner;

public interface CleanerRepo extends JpaRepository<Cleaner, Long> {
}
