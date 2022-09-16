package com.reader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.book.dto.BookDTO;

public class AuthorClient {

	private final String searchBooks_url = "localhost:8088/digitalbooks/getbook/%s/%s/%s";

	
	private RestTemplate restTemplate;
	
	public AuthorClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<BookDTO> getBooks(String category, Integer price, String authorName) {

		String actual_url = String.format(searchBooks_url, category, price, authorName);

		BookList response = restTemplate.getForObject(actual_url, BookList.class);
		
		return response.getBooks();
	}

}