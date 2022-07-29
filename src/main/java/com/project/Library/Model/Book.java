package com.project.Library.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

}