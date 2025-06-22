package com.example.demo.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Book;
import com.example.demo.dto.BookWithPublisherDTO;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired 
	private PublisherRepository publisherRepo;
	
	public Flux<Book> getAll(){
		return bookRepo.findAll().switchIfEmpty(Flux.empty());
		
	}
	
	public Mono<Book> getById(final Long id){
		return bookRepo.findById(id);
		
	}
	
	public Mono update(final String id, final Book book ) {
		return bookRepo.save(book);
		
	}
	
	public Mono save(final Book book ) {
		return bookRepo.findById(book.getBookId())
		        .flatMap(existingBook -> {
		            // If a book with the same ID exists, return an error
		            return Mono.error(new RuntimeException("Book with ID " + book.getBookId() + " already exists"));
		        })
		        .switchIfEmpty(
		            bookRepo.save(book) // Only save if ID doesn't exist
		            
		        );
		
	}
	
	public Mono delete(final Long id) {
		
		final Mono<Book> DbBook= getById(id);
		if(Objects.isNull(DbBook)) {
			return Mono.empty();
		}
		
		return getById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull)
				.flatMap(bookToBeDeleted -> bookRepo
				.delete(bookToBeDeleted).then(Mono.just(DbBook)));
		
	}
	
	public Mono<BookWithPublisherDTO> getBookWithPublisher(Long bookId) {
	    return bookRepo.findById(bookId)
	        .flatMap(book -> {
	            // If publisherId is missing or null, still return the book with a null publisher
	            if (book.getPublisherId() == null) {
	                return Mono.just(new BookWithPublisherDTO(book, null));
	            }
	            return publisherRepo.findById(book.getPublisherId())
	                    .defaultIfEmpty(null)
	                    .map(publisher -> new BookWithPublisherDTO(book, publisher));
	        });
	}



}
