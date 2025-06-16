package com.example.yamini.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Publisher {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pubId;

    private String name;
    private String address;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

	public Publisher() {
		super();
	}
	
	public Publisher(Long pubId, String name, String address, List<Book> books) {
		super();
		this.pubId = pubId;
		this.name = name;
		this.address = address;
		this.books = books;
	}

	public Long getPubId() {
		return pubId;
	}

	public void setPubId(Long pubId) {
		this.pubId = pubId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
    
    
}
