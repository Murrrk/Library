package com.project.Library.DTO;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {

    private Integer id;
    private String title;
    private String isbn;
    private String description;
    private AuthorDTO aut;
    private LocalDate dateOfArrival;


}
