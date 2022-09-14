package com.reader.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.book.model.Book;
import com.reader.model.Reader;

@Component
public interface IReaderService {

	public Long createReader(Reader reader);
}
