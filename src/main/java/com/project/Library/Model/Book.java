package com.project.Library.Model;

import java.time.LocalDate;

import javax.persistence.*;
@Entity
@Table(name = "books")
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


	public Book() {
	}

	public Book(long id, String title, String iban, String description, Author aut, LocalDate dateOfArrival) {
		this.id = id;
		this.title = title;
		this.iban = iban;
		this.description = description;
		this.aut = aut;
		this.dateOfArrival = dateOfArrival;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Author getAut() {
		return aut;
	}

	public void setAut(Author aut) {
		this.aut = aut;
	}

	public LocalDate getDateOfArrival() {
		return dateOfArrival;
	}

	public void setDateOfArrival(LocalDate dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

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