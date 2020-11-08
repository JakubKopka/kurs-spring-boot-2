package pl.kopka.kursspringboot2.Service;

import org.springframework.stereotype.Service;
import pl.kopka.kursspringboot2.Model.Person;
import pl.kopka.kursspringboot2.Model.PersonMongo;
import pl.kopka.kursspringboot2.Model.PersonType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVReader {

    private String csvFile;
    private String line;
    private String cvsSplitBy;

    public CSVReader() {
        this.csvFile = "/Users/jakubkopka/Projekty/Java/kurs-spring-boot-2/src/main/java/pl/kopka/kursspringboot2/MOCK_DATA.csv";
        this.line = "";
        this.cvsSplitBy = ",";
    }

    public List<?> parseCsvToPerson(PersonType personType) {
        List<Person> personList = new ArrayList<>();
        List<PersonMongo> personMongoList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] person = line.split(cvsSplitBy);
                if (personType.equals(PersonType.BASIC)) {
                    personList.add(new Person(person[1], person[2], person[3], person[4], person[5]));
                } else if (personType.equals(PersonType.MONGODB)) {
                    personMongoList.add(new PersonMongo(person[1], person[2], person[3], person[4], person[5]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (personType) {
            case BASIC:
                return personList;
            case MONGODB:
                return personMongoList;
            default:
                return null;
        }
    }
}

