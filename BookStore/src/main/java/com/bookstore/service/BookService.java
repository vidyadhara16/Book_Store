package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
		public void save(Book book) {
			bookRepository.save(book);
	}
		
	public List<Book> getAllBooks(){
		
		return bookRepository.findAll();
		}
	
	public Book getBookById(int id) {
		return bookRepository.findById(id).get();
	}
	public void deleteByid(int id) {
		bookRepository.deleteById(id);
	}
}
