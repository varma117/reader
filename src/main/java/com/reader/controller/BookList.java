package com.reader.controller;

import java.util.ArrayList;
import java.util.List;

import com.book.dto.BookDTO;

public class BookList {

	private List<BookDTO> books;

	public BookList() {
		books = new ArrayList<>();
	}

	public List<BookDTO> getBooks() {
		return books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}

	
}
