package com.project.Library.Model;

import java.time.LocalDate;

import javax.persistence.*;
@Entity
@Table(name = "authors")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long a_id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "penName")
	private String penName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "birthday")
	private LocalDate birthday;
	
	@Column(name = "summary")
	private String summary;

	public Author() {
	}

	public Author(long a_id, String firstName, String surname, String lastName, String penName, int age, LocalDate birthday, String summary) {
		this.a_id = a_id;
		this.firstName = firstName;
		this.surname = surname;
		this.lastName = lastName;
		this.penName = penName;
		this.age = age;
		this.birthday = birthday;
		this.summary = summary;
	}

	public Author(long a_id, String firstName) {
		super();
		this.a_id = a_id;
		this.firstName = firstName;
	}

	public long getA_id() {
		return a_id;
	}

	public void setA_id(long a_id) {
		this.a_id = a_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPenName() {
		return penName;
	}

	public void setPenName(String penName) {
		this.penName = penName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "Author{" +
				"a_id=" + a_id +
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