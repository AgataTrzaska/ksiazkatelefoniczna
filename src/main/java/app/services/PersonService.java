package app.services;

import app.mappers.PersonMapper;
import app.mappers.dtos.PersonDto;
import app.models.Person;
import app.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public List<PersonDto> getPersonsDto() {

        return personRepository
                .findAll()
                .stream()
                .map(personMapper::map)
                .collect(Collectors.toList());
    }

    public Person getPersonByEmail(String email) {
        return personRepository.findByEmail(email).get();
    }

    public Person addPerson(PersonDto personDto) {
       return personRepository.save(personMapper.reverse(personDto));
    }

    public void deletePerson(String email) {
        personRepository.deleteByEmail(email);
    }

    public void updatePersonByEmail(String email, PersonDto personDto) {
        Optional<Person> person = personRepository.findByEmail(email);
        personRepository
                .findByEmail(personDto.getEmail())
                .ifPresent(p -> {
                    p.setPersonName(personDto.getPersonName());
                    p.setPersonLastName(personDto.getPersonLastName());
                    p.setHomeNumber(personDto.getHomeNumber());
                    p.setWorkNumber(personDto.getWorkNumber());
                    p.setEmail(personDto.getEmail());
                    p.setPersonPhoto(personDto.getPersonPhoto());

                    personRepository.save(p);

                });}}