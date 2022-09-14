package com.reader.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.dto.BookDTO;
import com.book.model.Book;
import com.book.service.BookServiceImpl;
import com.reader.model.Reader;
import com.reader.service.IReaderService;
import com.reader.service.ReaderServiceImpl;

@RestController
@RequestMapping("/reader")
@CrossOrigin(origins = "http://localhost:4200")
public class ReaderController
{

	@Autowired
	IReaderService readerService;
	
	@Autowired
	BookServiceImpl bookService;
	
	@GetMapping("/getallbooks/{category}")
	public List<BookDTO> getBooksByCategory(@PathVariable String category){
		List<BookDTO> books = bookService.getBookByCategory(category);
		return books;
	} 
	
	@GetMapping("/getbookbyprice/{price}")
	public List<BookDTO> getBookByprice(@PathVariable Integer price){
		List<BookDTO> books = bookService.getBookByPrice(price);
		return books;
		
	}
	
	@GetMapping("/getbookbyauthorname/{authorName}")
	public List<BookDTO> getBookByAuthorName(@PathVariable String authorName){
		List<BookDTO> books = bookService.getBookByAuthorName(authorName);
		return books;
		
	}
	@GetMapping("/getbook/{category}/{price}/{authorName}")
	public List<BookDTO> getBook(@PathVariable String category,@PathVariable Integer price,@PathVariable String authorName ){
		
		List<BookDTO> books = bookService.getBookByCategoryOrPriceOrAuthorName(category, price,authorName);
		return books;
		
	}
	
	@PostMapping( value="/createreader",consumes="application/json")
	
	public Long createReader(@RequestBody Reader reader) {
		Long id = readerService.createReader(reader);
		return id;
		
	}
	
}