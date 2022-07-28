package com.project.Library.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author")
	private Author aut;


	@Column(name = "dateOfArrival")
	private LocalDate dateOfArrival;


	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", title='" + title + '\'' +
				", isbn='" + isbn + '\'' +
				", description='" + description + '\'' +
				", aut=" + aut +
				", dateOfArrival=" + dateOfArrival +
				'}';
	}
}