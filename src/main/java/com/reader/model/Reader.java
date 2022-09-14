package com.reader.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reader")
public class Reader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rId;
	@Column
	private String name;
	@Column
	private String email;
	//provide getter,s,c and send manually book id
	private List<Integer> book;
	
	@Column
	@ElementCollection(targetClass=PurchagedBook.class)
	private List<PurchagedBook> books;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<PurchagedBook> getBooks() {
		return books;
	}
	public void setBooks(List<PurchagedBook> books) {
		this.books = books;
	}
	public Long getrId() {
		return rId;
	}
	public void setrId(Long rId) {
		this.rId = rId;
	}
	
	public Reader() {
		super();
	}
	public Reader(Long rId, String name, String email, List<PurchagedBook> books) {
		super();
		this.rId = rId;
		this.name = name;
		this.email = email;
		this.books = books;
	}
	

}
