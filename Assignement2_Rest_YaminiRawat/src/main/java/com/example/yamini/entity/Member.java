package com.example.yamini.entity;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Member {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membId;

    private String name;
    private String address;
    private String membType;
    private Date membDate;
    private Date expiryDate;

    @OneToMany(mappedBy = "member")
    private List<Book> borrowedBooks;

	public Member() {
		super();
	}

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
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

	public String getMembType() {
		return membType;
	}

	public void setMembType(String membType) {
		this.membType = membType;
	}

	public Date getMembDate() {
		return membDate;
	}

	public void setMembDate(Date membDate) {
		this.membDate = membDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	public Member(Long membId, String name, String address, String membType, Date membDate, Date expiryDate,
			List<Book> borrowedBooks) {
		super();
		this.membId = membId;
		this.name = name;
		this.address = address;
		this.membType = membType;
		this.membDate = membDate;
		this.expiryDate = expiryDate;
		this.borrowedBooks = borrowedBooks;
	}
    
}
