package com.project.Library.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "libraries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Libraries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;
}