package com.bookapp.api.books.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.api.books.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
