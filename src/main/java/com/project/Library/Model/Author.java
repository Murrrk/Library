package com.project.Library.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "penName")
	private String penName;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "birthday")
	private LocalDate birthday;
	
	@Column(name = "summary")
	private String summary;

}