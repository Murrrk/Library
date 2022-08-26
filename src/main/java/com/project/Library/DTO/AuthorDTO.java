package com.project.Library.DTO;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDTO {

    private Integer id;
    private String firstName;
    private String surname;
    private String lastName;
    private String penName;
    private Integer age;
    private LocalDate birthday;
    private String summary;

    private List<BookDTO> books;

}
