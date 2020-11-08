package pl.kopka.kursspringboot2.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.kopka.kursspringboot2.Model.PersonMongo;

public interface PersonMongoRepo extends MongoRepository<PersonMongo, String> {
}
