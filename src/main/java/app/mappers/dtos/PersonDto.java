package app.mappers.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDto {

    private String personName;
    private String personLastName;
    private Integer homeNumber;
    private Integer workNumber;
    private String email;
    private String personPhoto;
}
