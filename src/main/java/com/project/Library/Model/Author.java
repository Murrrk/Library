package com.project.Library.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
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


	@Override
	public String toString() {
		return "Author{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", surname='" + surname + '\'' +
				", lastName='" + lastName + '\'' +
				", penName='" + penName + '\'' +
				", age=" + age +
				", birthday=" + birthday +
				", summary='" + summary + '\'' +
				'}';
	}
}