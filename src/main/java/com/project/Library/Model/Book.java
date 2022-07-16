package com.project.Library.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.*;
@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "iban")
	private String iban;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	private Author aut;


	@Column(name = "dateOfArrival")
	private LocalDate dateOfArrival;

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", title='" + title + '\'' +
				", iban='" + iban + '\'' +
				", description='" + description + '\'' +
				", aut=" + aut +
				", dateOfArrival=" + dateOfArrival +
				'}';
	}
}