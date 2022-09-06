package com.project.Library.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryDTO {

    private Integer id;
    private String name;
    private String address;
    private String description;
}
