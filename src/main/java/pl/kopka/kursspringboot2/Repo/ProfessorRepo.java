package pl.kopka.kursspringboot2.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kopka.kursspringboot2.model.Professor;

@Repository
public interface ProfessorRepo extends JpaRepository<Professor, Long> {
}
