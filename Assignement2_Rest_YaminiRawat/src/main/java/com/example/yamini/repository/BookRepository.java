package com.example.yamini.repository;

import com.example.yamini.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
