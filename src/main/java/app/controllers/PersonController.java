package app.controllers;

import app.mappers.dtos.PersonDto;
import app.models.Person;
import app.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons/{email}")
    public Person getPerson(@PathVariable(value = "email") String email) {
        return personService.getPersonByEmail(email);
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/dto/persons")
    public List<PersonDto> getPersonDto() {
        return personService.getPersonsDto();
    }

    @PostMapping("/dto/persons")
    public Person addPerson(@RequestBody PersonDto personDto) {
        return personService.addPerson(personDto);
    }

    @PutMapping("/dto/persons/{email}")
    public void updatePersonByEmail(@PathVariable(value = "email") String email, @RequestBody PersonDto personDto) {
      personService.updatePersonByEmail(email, personDto);
    }

    @DeleteMapping("/dto/persons/{email}")
    public void deletePerson(@PathVariable String email) {
        personService.deletePerson(email);
    }
}
