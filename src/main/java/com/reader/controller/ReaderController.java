package com.reader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.book.dto.BookDTO;
import com.book.service.BookServiceImpl;
import com.reader.model.PurchagedBook;
import com.reader.model.Reader;
import com.reader.service.IReaderService;

@RestController
@RequestMapping("/reader")
@CrossOrigin(origins = "http://localhost:4200")
public class ReaderController {

	private final String searchBooks_url = "http://localhost:8088/digitalbooks/getbook/%s/%s/%s";

	@Autowired
	IReaderService readerService;

	@Autowired
	BookServiceImpl bookService;
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getallbooks/{category}")
	public List<BookDTO> getBooksByCategory(@PathVariable String category) {
		List<BookDTO> books = bookService.getBookByCategory(category);

		return books;
	}

	@GetMapping("/getbookbyprice/{price}")
	public List<BookDTO> getBookByprice(@PathVariable Integer price) {
		List<BookDTO> books = bookService.getBookByPrice(price);

		return books;
	}

	@GetMapping("/getbookbyauthorname/{authorName}")
	public List<BookDTO> getBookByAuthorName(@PathVariable String authorName) {
		List<BookDTO> books = bookService.getBookByAuthorName(authorName);

		return books;
	}

	@GetMapping("/getallbooks")
	public List<BookDTO> getBooks() {
		List<BookDTO> books = bookService.getAllBooks();
		
		return books;
	}

	@GetMapping("/getbook/{category}/{price}/{authorName}")
	public List<BookDTO> getBook(@PathVariable String category, @PathVariable Integer price,
			@PathVariable String authorName) {

		return getBooks(category, price, authorName);

	}
	
	public List<BookDTO> getBooks(String category, Integer price, String authorName) {

		String actual_url = String.format(searchBooks_url, category, price, authorName);

		List<BookDTO>  response = restTemplate.getForObject(actual_url, List.class);
		
		return response;
	}

	
	@PostMapping("/purchasebook")
	public Long createReader(@RequestBody Reader reader, @RequestBody PurchagedBook pbook) {
		Long id = readerService.createReader(reader);
		Long pid = readerService.createReader(reader);
		return id;

	}

}