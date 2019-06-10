package app.mappers;

import app.commons.Mapper;
import app.mappers.dtos.PersonDto;
import app.models.Person;
import org.springframework.stereotype.Component;


@Component
public class PersonMapper implements Mapper<Person, PersonDto> {

    @Override
    public PersonDto map(Person f) {

        return PersonDto
                .builder()
                .personName(f.getPersonName())
                .personLastName(f.getPersonLastName())
                .homeNumber(f.getHomeNumber())
                .workNumber(f.getWorkNumber())
                .email(f.getEmail())
                .personPhoto(f.getPersonPhoto())
                .build();
    }
    @Override
    public Person reverse(PersonDto to) {
        return Person
                .builder()
                .personName(to.getPersonName())
                .personLastName(to.getPersonLastName())
                .homeNumber(to.getHomeNumber())
                .workNumber(to.getWorkNumber())
                .email(to.getEmail())
                .personPhoto(to.getPersonPhoto())
                .build();
    }
}
