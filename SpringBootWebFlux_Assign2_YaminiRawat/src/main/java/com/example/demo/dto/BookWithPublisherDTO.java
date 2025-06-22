package com.example.demo.dto;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.Publisher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookWithPublisherDTO {

	private Book book;
    private Publisher publisher;
    
	public BookWithPublisherDTO(Book book, Publisher publisher) {
		super();
		this.book = book;
		this.publisher = publisher;
	}

}
