package pl.kopka.kursspringboot2.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kopka.kursspringboot2.model.Backpack;


@Repository
public interface BackpackRepo extends JpaRepository<Backpack, Long> {
}
