package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Book;
import com.example.demo.dto.BookWithPublisherDTO;
import com.example.demo.service.BookService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/book")
@AllArgsConstructor
@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public Flux<Book> getAll(){
		System.out.println("All Books:");
		return bookService.getAll();
	}
	
	@GetMapping("{id}")
	public Mono<Book> getById(@PathVariable("id") final Long id){
		System.out.println("Book for BookID:"+id);
		return bookService.getById(id);
		
	}
	
	@PutMapping("{id}")
	public Mono updateById(@PathVariable("id") final String id, @RequestBody final Book book){
		System.out.println("Update book for BookID:"+id);
		return bookService.update(id,book);
		
	}
	
	@PostMapping
	public Mono save(@RequestBody final Book book){
		return bookService.save(book);
	}
	
	@DeleteMapping("{id}")
	public Mono<String> deleteById(@PathVariable("id") final Long id) {
	    System.out.println("Deleting book for BookID: " + id);
	    return bookService.delete(id).thenReturn("Deleted book with ID: " + id);
	}
	
	@GetMapping("/withPublisher/{id}")
	public Mono<BookWithPublisherDTO> getBookWithPublisher(@PathVariable Long id) {
	    return bookService.getBookWithPublisher(id);
	}

}

