package pl.kopka.kursspringboot2.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kopka.kursspringboot2.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
}
