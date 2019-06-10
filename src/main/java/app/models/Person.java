package app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "person_name", nullable = false)
    private String personName;

    @Column(name = "person_last_name", nullable = false)
    private String personLastName;

    @Column(name = "home_number", nullable = false)
    private Integer homeNumber;

    @Column(name = "work_number", nullable = false)
    private Integer workNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "person_photo", nullable = false)
    private String personPhoto;

    }


