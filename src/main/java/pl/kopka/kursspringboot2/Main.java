package pl.kopka.kursspringboot2;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.kopka.kursspringboot2.Aspect.StartAnnotation;
import pl.kopka.kursspringboot2.Aspect.StopAnnotation;
import pl.kopka.kursspringboot2.Model.Person;
import pl.kopka.kursspringboot2.Model.PersonMongo;
import pl.kopka.kursspringboot2.Model.PersonType;
import pl.kopka.kursspringboot2.Repository.PersonMongoRepo;
import pl.kopka.kursspringboot2.Repository.PersonRepo;
import pl.kopka.kursspringboot2.Service.CSVReader;

import java.util.List;

@Component
public class Main {

    private PersonRepo personRepo;
    private PersonMongoRepo personMongoRepo;
    private CSVReader csvReader;
    private List<Person> personList;
    private List<PersonMongo> personMongoList;


    public Main(PersonRepo personRepo, PersonMongoRepo personMongoRepo, CSVReader csvReader) {
        this.personRepo = personRepo;
        this.personMongoRepo = personMongoRepo;
        this.csvReader = csvReader;
        this.personList = (List<Person>) csvReader.parseCsvToPerson(PersonType.BASIC);
        this.personMongoList = (List<PersonMongo>) csvReader.parseCsvToPerson(PersonType.MONGODB);
    }

    @EventListener(ApplicationReadyEvent.class)
    @StartAnnotation
    @StopAnnotation
    public void testDbTime(){
//        saveAllPerson(personList);
//        saveAllPersonMongo(personMongoList);
//        savePerson();
//        savePersonMongo();
//        deleteByIdPerson(1L);
//        deleteByIdPersonMongo("5fa7305b1fc4a632af3471dd");
//        findPerson(2L);
//        findPersonMongo("5fa7305b1fc4a632af3471de");
//        removeAllPerson();
        removeAllPersonMongo();

    }

    public void saveAllPerson(List<Person> personList){
        personRepo.saveAll(personList);
    }

    public void saveAllPersonMongo(List<PersonMongo> personMongoList){
        personMongoRepo.saveAll(personMongoList);
    }

    public void savePerson(){
//        String firstName, String lastName, String email, String gender, String ipAddress
        personRepo.save(new Person("Jan", "Kowalksi", "jan@kowalski.pl", "M", "192.168.1.28"));
    }

    public void savePersonMongo(){
//        String firstName, String lastName, String email, String gender, String ipAddress
        personMongoRepo.save(new PersonMongo("Jan", "Kowalksi", "jan@kowalski.pl", "M", "192.168.1.28"));
    }

    public void deleteByIdPerson(Long id){
        personRepo.deleteById(id);
    }

    public void deleteByIdPersonMongo(String id){
        personMongoRepo.deleteById(id);
    }

    public void findPerson(Long id){
        personRepo.findById(id);
    }

    public void findPersonMongo(String id){
        personMongoRepo.findById(id);
    }

    public void removeAllPerson(){
        personRepo.deleteAll();
    }

    public void removeAllPersonMongo(){
        personMongoRepo.deleteAll();
    }
}
