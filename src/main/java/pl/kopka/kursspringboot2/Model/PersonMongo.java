package pl.kopka.kursspringboot2.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class PersonMongo {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String ipAddress;


    public PersonMongo(String firstName, String lastName, String email, String gender, String ipAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.ipAddress = ipAddress;
    }
}
