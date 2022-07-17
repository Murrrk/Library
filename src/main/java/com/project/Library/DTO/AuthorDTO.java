package com.project.Library.DTO;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDTO {

    private Long id;
    private String firstName;
    private String surname;
    private String lastName;
    private String penName;
    private Integer age;
    private LocalDate birthday;
    private String summary;

}
