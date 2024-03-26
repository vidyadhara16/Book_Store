package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bookstore.entity.MyBookList;
import com.bookstore.repository.MyBookRepository;

@Service
public class MyBookService {

	@Autowired
	private MyBookRepository myBookRepository;
	
	public void SaveMyBook(MyBookList MyBook) {
		myBookRepository.save(MyBook);
		
	}
	public List<MyBookList> getMyBooks(){
		
		return myBookRepository.findAll();
		}
	public void deleteMyBook(int id) {
		myBookRepository.deleteById(id);
	}
}
