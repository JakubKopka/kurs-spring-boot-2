package pl.kopka.kursspringboot2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kopka.kursspringboot2.Model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
}
