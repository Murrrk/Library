package com.project.Library.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibrariesDTO {

    private Long id;
    private String name;
    private String address;
    private String description;
}
