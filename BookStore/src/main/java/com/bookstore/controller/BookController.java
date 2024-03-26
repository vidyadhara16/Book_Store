package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.entity.Book;
import com.bookstore.entity.MyBookList;
import com.bookstore.service.BookService;
import com.bookstore.service.MyBookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private MyBookService myBookService;
	
	@GetMapping("/")
	public String home() {
	
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	@GetMapping("/available_books")
	public ModelAndView getAllbook() {
		List<Book> list=bookService.getAllBooks();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
//		return m;
		return new ModelAndView("bookList","book",list);
		}
	
	@PostMapping("/save")
	public String addbook(@ModelAttribute Book book) {
		bookService.save(book);
		return "redirect:/available_books";
		
	}
	@GetMapping("/my_books")
	public String mybooks(Model model) {
		List<MyBookList> list1=myBookService.getMyBooks();
		model.addAttribute("mybook", list1);
		return "MyBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=bookService.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		myBookService.SaveMyBook(mb);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id")int id, Model model) {
		Book b=bookService.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bookService.deleteByid(id);
		return "redirect:/available_books";
	}
}
